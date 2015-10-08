package com.njby.entity;


import com.system.ananotation.EntityInfo;

@EntityInfo("系统日志")
public class Log extends BaseEntity{
	
	private static final long serialVersionUID = -163676682767581792L;
	public static final String LOG_CONTENT_ATTRIBUTE_NAME = Log.class.getName() + ".CONTENT";
	
	private String operation;
	private String operator;
	private String content;
	private String parameter;
	private String ip;
	
	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getParameter() {
		return parameter;
	}
	
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}

	
	  
}
