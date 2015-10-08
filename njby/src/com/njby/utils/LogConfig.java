package com.njby.utils;

import java.io.Serializable;

/***
 * 模块日志配置
 * @author Administrator
 *
 */
public class LogConfig implements Serializable{
	private static final long serialVersionUID = 6924033087108165316L;
	private String operation;
	private String urlPattern; 
	
	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getUrlPattern() {
		return urlPattern;
	}
	
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}
	
	public String toString() {
		return this.getUrlPattern() + " " + this.getOperation();
	}
}
