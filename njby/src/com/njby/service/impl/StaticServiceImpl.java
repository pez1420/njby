package com.njby.service.impl;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;


import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.njby.dao.ProductDao;
import com.njby.service.StaticService;
import com.njby.service.TemplateService;

@Service
public class StaticServiceImpl implements StaticService, ServletContextAware{
	
	@Resource
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Resource
	private TemplateService templateService;
	@Resource
	private ProductDao productDao;	
	
	private ServletContext servletContext;
	
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;	
	}

	@Transactional(readOnly = true)
	public int build(String templatePath, String staticPath,
			Map<String, Object> model) {
		
		Assert.hasText(templatePath);
		Assert.hasText(staticPath);
		
		FileOutputStream fileOutputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			freemarker.template.Template template = this.freeMarkerConfigurer
					.getConfiguration().getTemplate(templatePath);
			File file = new File(this.servletContext.getRealPath(staticPath));
			File parentFile = file.getParentFile();
			if (!parentFile.exists()) {
				parentFile.mkdirs();
			}
			fileOutputStream = new FileOutputStream(file);
			outputStreamWriter = new OutputStreamWriter(
					fileOutputStream, "UTF-8");
			bufferedWriter = new BufferedWriter(outputStreamWriter);
			template.process(model, bufferedWriter);
			bufferedWriter.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(bufferedWriter);
			IOUtils.closeQuietly(outputStreamWriter);
			IOUtils.closeQuietly(fileOutputStream);
		}
		return 0;
	}

	@Transactional(readOnly = true)
	public int build(String templatePath, String staticPath) {
		return build(templatePath, staticPath, null);
	}

	@Transactional(readOnly = true)
	public int buildIndex() {
		com.system.Template template = this.templateService.get("index");
		return build(template.getTemplatePath(),
				template.getStaticPath());
	}

	@Transactional(readOnly = true)
	public int buildAboutus() {
		com.system.Template template = this.templateService.get("aboutus");
		return build(template.getTemplatePath(),
				template.getStaticPath());
	}
	
	@Override
	public int buildSitemap() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int buildOther() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional(readOnly = true)
	public int buildAll() {
		int i = 0;
		buildIndex();
		return i;
	}

	@Override
	public int delete(String paramString) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOther() {
		// TODO Auto-generated method stub
		return 0;
	}



}
