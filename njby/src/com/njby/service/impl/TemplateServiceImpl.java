package com.njby.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.njby.service.TemplateService;
import com.system.Template;

@Service
public class TemplateServiceImpl implements TemplateService,
		ServletContextAware {
	private ServletContext servletContext;
	@Value("${template.loader_path}")
	private String[] loaderPaths;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Cacheable({ "template" })
	public List<Template> getAll() {
		try {
			File file = new ClassPathResource("/system.xml").getFile();
			Document document = new SAXReader().read(file);
			ArrayList<Template> templates = new ArrayList<Template>();
			List list = document.selectNodes("/system/template");
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Element element = (Element) it.next();
				Template template = getTemplate(element);
				templates.add(template);
			}
			return templates;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Cacheable({ "template" })
	public List<Template> getList(Integer type) {
		if (type != null) {
			try {
				File file = new ClassPathResource("/system.xml").getFile();
				Document document = new SAXReader().read(file);
				ArrayList<Template> templates = new ArrayList<Template>();
				List list = document
						.selectNodes("/system/template[@type='" + type + "']");
				Iterator it = list.iterator();
				while (it.hasNext()) {
					Element element = (Element) it.next();
					Template template = getTemplate(element);
					templates.add(template);
				}
				return templates;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return getAll();
	}

	@Cacheable({ "template" })
	public Template get(String id) {
		try {
			File file = new ClassPathResource("/system.xml").getFile();
			Document document = new SAXReader().read(file);
			Element element = (Element) document
					.selectSingleNode("/system/template[@id='" + id + "']");
			Template template = getTemplate(element);
			return template;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String read(String id) {
		Template template = get(id);
		return read(template);
	}

	public String read(Template template) {
		String realPath = this.servletContext.getRealPath(this.loaderPaths[0]
				+ template.getTemplatePath());
		File file = new File(realPath);
		String content = null;
		try {
			content = FileUtils.readFileToString(file, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	public void write(String id, String content) {
		Template template = get(id);
		write(template, content);
	}

	public void write(Template template, String content) {
		String realPath = this.servletContext.getRealPath(this.loaderPaths[0]
				+ template.getTemplatePath());
		File file = new File(realPath);
		try {
			FileUtils.writeStringToFile(file, content, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Template getTemplate(Element element) {
		String id 	= element.attributeValue("id");
		String type = element.attributeValue("type");
		String name = element.attributeValue("name");
		String templatePath = element.attributeValue("templatePath");
		String staticPath 	= element.attributeValue("staticPath");
		String description 	= element.attributeValue("description");
		
		Template template 	= new Template();
		template.setId(id);
		template.setType(Integer.valueOf(type));
		template.setName(name);
		template.setTemplatePath(templatePath);
		template.setStaticPath(staticPath);
		template.setDescription(description);
		
		return template;
	}
}
