package com.ruijie.framework.kyo.session;

import java.io.Serializable;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class KyoSession implements Serializable, HttpSession {

	private static final long serialVersionUID = 7448628268839455575L;

	private Long createTime;

	private volatile boolean isVaild;

	private String sessionId;

	private volatile Long lastAccessTime;

	private volatile boolean isExpire;

	private int maxInactiveInterval;

	private Map<String, Object> data = new ConcurrentHashMap<String, Object>();

	private transient ServletContext servletContext;

	private transient KyoSessionFacade sessionFacade;
	
	private transient HttpSessionContext sessionContext;
	
	private transient Enumeration attributeNames;
	
	private transient Object attribute;

	private transient String[] valueNames;
	
	private transient Object value;
	
	private boolean isNew;

	public boolean isExpire() {
		return isExpire;
	}

	public void setExpire(boolean isExpire) {
		this.isExpire = isExpire;
	}

	public KyoSessionFacade getSessionFacade() {
		return sessionFacade;
	}

	public void setSessionFacade(KyoSessionFacade sessionFacade) {
		this.sessionFacade = sessionFacade;
	}

	public Long getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public boolean isVaild() {
		return isVaild;
	}

	public void setVaild(boolean isVaild) {
		this.isVaild = isVaild;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	
	public long getCreationTime() {
		return this.createTime;
	}

	
	public String getId() {
		return sessionId;
	}

	
	public long getLastAccessedTime() {
		return this.lastAccessTime;
	}

	
	public ServletContext getServletContext() {
		return this.servletContext;
	}

	
	public void setMaxInactiveInterval(int interval) {
		this.maxInactiveInterval = interval;
	}

	
	public int getMaxInactiveInterval() {
		return maxInactiveInterval;
	}

	
	public HttpSessionContext getSessionContext() {
		return null;
	}

	
	public Object getAttribute(String name) {
		if (name == null) {
			throw new IllegalArgumentException(
					"session.getAttribute , the  key can not  be  null ........");
		}
		return data.get(name);
	}

	
	@Deprecated
	public Object getValue(String name) {
		return (getAttribute(name));
	}

	
	public Enumeration getAttributeNames() {
		Set<String> names = new HashSet<String>();
		names.addAll(data.keySet());
		return Collections.enumeration(names);
	}

	
	public String[] getValueNames() {
		return null;
	}

	
	public void setAttribute(String name, Object value) {
		if (name == null) {
			throw new IllegalArgumentException(
					"session.setAttribute , the  key can not  be  null ........");
		}
		data.put(name, value);
	}

	
	public void putValue(String name, Object value) {

	}

	
	public void removeAttribute(String name) {
		if (name == null) {
			return;
		}
		data.remove(name);
	}

	
	public void removeValue(String name) {

	}

	
	public void invalidate() {
		KyoSessionManager.removeSession(this.getSessionId());
	}

	
	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

}
