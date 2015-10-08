package com.njby.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.njby.service.FileService;
import com.njby.utils.FreemarkerUtils;
import com.njby.utils.SettingUtils;
import com.system.Setting;
import com.system.FileInfo.FileType;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public boolean isValid(FileType fileType, MultipartFile multipartFile) {
		if (multipartFile == null) {
			return false;
		}

		if ( multipartFile.getSize() > 10 * 1024L * 1024L ) {
			return false;
		}
		
		String[] uploadImageExtensions = new String[] {"jpg","jpeg","bmp","gif","png"};
		if (ArrayUtils.isNotEmpty(uploadImageExtensions)) {
			return FilenameUtils.isExtension(
					multipartFile.getOriginalFilename(), uploadImageExtensions);
		}
		return false;
	}

	@Override
	public String upload(HttpServletRequest request, FileType fileType,
			MultipartFile multipartFile) {
		
		Setting setting = SettingUtils.get();
		System.out.println(setting.getImageUploadPath());
		HashMap map = new HashMap();
        map.put("uuid", UUID.randomUUID().toString());
        String imageUploadPath = FreemarkerUtils.process(setting.getImageUploadPath(), map);
        
		String realPath = request.getSession().getServletContext().getRealPath("upload");
		String fileName = multipartFile.getOriginalFilename();
		
		File targetFile = new File(realPath, fileName);  
	    if(!targetFile.exists()){  
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
