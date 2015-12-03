package com.njby.entity;

//import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.system.ananotation.EntityInfo;

@EntityInfo("产品图片")
public class ProductImage extends BaseEntity{
	
	private static final long serialVersionUID = 4400299567664515629L;

	private String title;
	
	private String source;
	
	private String thumbnail;
	
	Product product;
	
	private MultipartFile file;


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

	@Transient
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	 @Transient
	 public boolean isEmpty() {
		 if (true) {
			  
		  }
		 
		 return true;
	 }
}
