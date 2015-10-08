package com.system;

import java.io.Serializable;

public class Template implements Serializable {
	private static final long serialVersionUID = -2668300785246158972L;

	public enum Type {
		page, mail, print;
	}

	private String id;
	//0=page, 1=mail,2=print
	private Integer type;
	private String name;
	private String templatePath;
	private String staticPath;
	private String description;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplatePath() {
		return this.templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getStaticPath() {
		return this.staticPath;
	}

	public void setStaticPath(String staticPath) {
		this.staticPath = staticPath;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}