package com.njby.entity;

import org.springframework.web.multipart.MultipartFile;

public class ProductImage extends OrderEntity{
	
	private static final long serialVersionUID = 2746536868988238516L;
	
	private Integer orders;
	
	private String title;
	
	private String source;
	
	private String thumbnail;
	
	Product product;
	
	private MultipartFile file;

	
	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	

}
