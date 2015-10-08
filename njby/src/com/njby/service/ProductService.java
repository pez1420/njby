package com.njby.service;

import java.util.List;

import com.njby.entity.Product;
import com.njby.entity.search.SearchProduct;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public interface ProductService extends BaseService<Product, String>{
	
	public abstract Page<Product> findPage(Pageable pageable, SearchProduct searchProduct);
	
	public abstract boolean snExists(String currentSn);
	
	public abstract boolean snUnique(String previousSn, String currentSn);
	
	public abstract  List<Product> findList(Integer count);
}
