package com.njby.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -4408527936946073327L;

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
		
		if (!BaseEntity.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		BaseEntity localBaseEntity = (BaseEntity) obj;
		return getId() != null ? getId().equals(localBaseEntity.getId())
				: false;
	}
	
	public int hashCode() {
	    int i = 17;
	    i += (getId() == null ? 0 : getId().hashCode() * 31);
	    return i;
	}

}
