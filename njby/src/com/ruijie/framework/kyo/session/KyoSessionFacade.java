package com.ruijie.framework.kyo.session;

import java.io.Serializable;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
/**
 * @description KyoSession的包装类，屏蔽KyoSession内部的一些操作，只暴露 HttpSession中声明的方法
 * @author lqiang
 *
 */
public class KyoSessionFacade implements Serializable,HttpSession {
	
	private static final long serialVersionUID = 6191054207323411261L;
	
	private KyoSession session;

	public KyoSessionFacade(KyoSession session) {
		this.session = session;
	}

	
	public long getCreationTime() {
		return session.getCreationTime();
	}

	
	public String getId() {
		return session.getId();
	}

	
	public long getLastAccessedTime() {
		return session.getLastAccessedTime();
	}

	
	public ServletContext getServletContext() {
		return session.getServletContext();
	}

	
	public void setMaxInactiveInterval(int interval) {
		session.setMaxInactiveInterval(interval);
	}

	
	public int getMaxInactiveInterval() {
		return session.getMaxInactiveInterval();
	}

	
	public HttpSessionContext getSessionContext() {
		return session.getSessionContext();
	}

	
	public Object getAttribute(String name) {
		return session.getAttribute(name);
	}

	
	public Object getValue(String name) {
		return session.getValue(name);
	}

	
	public Enumeration getAttributeNames() {
		return session.getAttributeNames();
	}

	
	public String[] getValueNames() {
		return session.getValueNames();
	}

	
	public void setAttribute(String name, Object value) {
		session.setAttribute(name, value);
	}

	
	public void putValue(String name, Object value) {
		session.putValue(name, value);
	}

	
	public void removeAttribute(String name) {
		session.removeAttribute(name);
	}

	
	public void removeValue(String name) {
		session.removeValue(name);
	}

	
	public void invalidate() {
		session.invalidate();
	}

	
	public boolean isNew() {
		return session.isNew();
	}
}
