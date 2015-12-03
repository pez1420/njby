package com.njby.service.impl;

import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.njby.entity.ProductImage;
import com.njby.service.ProductImageService;
import com.njby.utils.FreemarkerUtils;
import com.njby.utils.ImageUtils;
import com.njby.utils.SettingUtils;
import com.system.Setting;

@Service
public class ProductImageServiceImpl implements ProductImageService, ServletContextAware {

	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}

	@Override
	public void build(ProductImage productImage) {
		
		Setting setting = SettingUtils.get();
		String imageUploadPath = setting.getImageUploadPath();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uuid", UUID.randomUUID().toString());
		String uploadPath = FreemarkerUtils.process(imageUploadPath, map);
		
		String source = productImage.getSource();
		String srcImageRealPath = this.servletContext.getRealPath(productImage.getSource());
		String destImageRealPath = this.servletContext.getRealPath(uploadPath 
				+ FilenameUtils.getBaseName(source)
				+ "-" + "thumbnail." 
				+ FilenameUtils.getExtension(source));
		
		ImageUtils.resize(srcImageRealPath, destImageRealPath, 50, 50);
	}

}
