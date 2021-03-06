package com.njby.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.njby.service.FileService;
import com.njby.utils.FreemarkerUtils;
import com.njby.utils.SettingUtils;
import com.system.Setting;
import com.system.FileInfo.FileType;

@Service
public class FileServiceImpl implements FileService, ServletContextAware {

	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public boolean isValid(FileType fileType, MultipartFile multipartFile) {
		if (multipartFile == null) {
			return false;
		}

		if (multipartFile.getSize() > 10 * 1024L * 1024L) {
			return false;
		}

		String[] uploadImageExtensions = new String[] { "jpg", "jpeg", "bmp",
				"gif", "png" };
		if (ArrayUtils.isNotEmpty(uploadImageExtensions)) {
			return FilenameUtils.isExtension(
					multipartFile.getOriginalFilename(), uploadImageExtensions);
		}

		return false;
	}

	@Override
	public String upload(FileType fileType, MultipartFile multipartFile) {
		// 返回图片上传的路径
		Setting setting = SettingUtils.get();
		String imageUploadPath = setting.getImageUploadPath();

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uuid", UUID.randomUUID().toString());
		String uploadPath = FreemarkerUtils.process(imageUploadPath, map);
		String fileName = uploadPath
				+ UUID.randomUUID()
				+ "."
				+ FilenameUtils.getExtension(multipartFile
						.getOriginalFilename());

		//上传文件
		File targetFile = new File(this.servletContext.getRealPath(fileName));
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		try {
			multipartFile.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return fileName;
	}

}
