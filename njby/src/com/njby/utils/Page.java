package com.njby.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Page<T> implements Serializable{
	private static final long serialVersionUID = -7157966661239121988L;
	
	private final List<T> content = new ArrayList<T>();
	private final Pageable pageable;

	public Page() {
		this.pageable = new Pageable();
	}

	public Page(List<T> content, Pageable pageable) {
		this.content.addAll(content);
		this.pageable = pageable;
	}

	//总记录数
	public long getTotal() {
		return this.pageable.getTotal();
	}
	
	//当前页码
	public int getPageNumber() {
		return this.pageable.getPageNumber();
	}

	//页大小
	public int getPageSize() {
		return this.pageable.getPageSize();
	}
	
	//总页数
	public int getTotalPages() {
		return (int) Math.ceil(getTotal()*1.0 / getPageSize());
	}

	public List<T> getContent() {
		return this.content;
	}

	public Pageable getPageable() {
		return this.pageable;
	}
}
