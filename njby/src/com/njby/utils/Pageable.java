package com.njby.utils;

import java.io.Serializable;

public class Pageable implements Serializable{
	private static final long serialVersionUID = -7180054555214785748L;
	
	private static final int DEFAULT_PAGE_NUMBER = 1;
	private static final int DEFAULT_PAGE_SIZE = 5;
	private static final int MAX_PAGE_SIZE = 1000;
	
	//页号
	private int pageNumber = DEFAULT_PAGE_NUMBER;
	//页尺寸
	private int pageSize = DEFAULT_PAGE_SIZE;
	//由mybatis分页拦截器填充
	private long total = 0L;  

	
	public Pageable() {
	}

	public Pageable(Integer pageNumber, Integer pageSize) {
		if ((pageNumber != null) && (pageNumber.intValue() >= 1)) {
			this.pageNumber = pageNumber.intValue();
		}

		if ((pageSize != null) && (pageSize.intValue() >= 1)
				&& (pageSize.intValue() <= MAX_PAGE_SIZE)) {
			this.pageSize = pageSize.intValue();
		}
	}

	public int getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber < 1) {
			pageNumber = 1;
		}
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		if ((pageSize < 1) || (pageSize > MAX_PAGE_SIZE)) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String toString() {
	       StringBuilder builder = new StringBuilder();   
	       builder.append("Page [pageNumber=").append(this.pageNumber).append(", pageSize=")   
	              .append(pageSize).append(", totalRecords=").append(total).append("]");   
	       return builder.toString();
	}
}
