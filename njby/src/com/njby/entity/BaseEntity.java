package com.njby.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.groups.Default;

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -4408527936946073327L;

	public abstract interface Save extends Default {}
	public abstract interface Update extends Default {}	
	
	private String id;
	private Date createDate;
	private Date modifyDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		
		if (this == obj) {
			return true;
		}
		
		//判断BaseEntity是否是obj的父类
		if (!BaseEntity.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		BaseEntity e = (BaseEntity) obj;
		return getId() != null ? getId().equals(e.getId())
				: false;
	}
	
	public int hashCode() {
	    int i = 17;
	    i += (getId() == null ? 0 : getId().hashCode() * 31);
	    return i;
	}

}
