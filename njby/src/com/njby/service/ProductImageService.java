package com.njby.service;

import com.njby.entity.ProductImage;



public interface ProductImageService {

	/**
	 * 创建图片的缩略图
	 * 
	 * @param productImage
	 */
	public void build(ProductImage productImage);
	
	
}
