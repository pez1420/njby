package com.njby.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.system.ananotation.EntityInfo;

@EntityInfo("产品")
public class Product extends BaseEntity{
	private static final long serialVersionUID = -1174555358912287863L;
	private String sn; //编号
	private String name; //名称
	private String price; //价格
	private String introduction; //产品介绍
	private String remark; //产品备注
	
	private Boolean isMarketable; //是否上架
	private Integer stock; //库存量
	
	private String keyword; //搜索关键词
	private String seoTitle; //页面标题
	private String seoKeywords; //页面关键词
	private String seoDescription; //页面描述
	
	//图片路径
	private String image;
	
	private ProductType productType; //产品类型
	
	private List<ProductImage> productImages = new ArrayList<ProductImage>();
	
	private MultipartFile imageFile;
	
	private MultipartFile[] files;
	
	public String getSn() {
		return sn;
	}
	
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Boolean getIsMarketable() {
		return isMarketable;
	}
	
	public void setIsMarketable(Boolean isMarketable) {
		this.isMarketable = isMarketable;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getSeoTitle() {
		return seoTitle;
	}
	
	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}
	
	public String getSeoKeywords() {
		return seoKeywords;
	}
	
	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}
	
	public String getSeoDescription() {
		return seoDescription;
	}
	
	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}



	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	@Transient
	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	
	
	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	@Transient
	public String getPath() {
		if (getId() != null)
			return "/upload/" + this.getImage();
		
		return null;
	}	
	
}
