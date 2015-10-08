package com.njby.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.ProductType;
import com.njby.entity.search.SearchProductType;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

public interface ProductTypeService extends BaseService<ProductType, String> {
	
	public abstract Page<ProductType> findPage(@Param("pageable")Pageable pageable, 
			@Param("search")SearchProductType searchProductType);
	
	public abstract List<ProductType> findRoots(Integer count);
	  
	public abstract List<ProductType> findParents(List<String> ids, Integer count);
	  
	public abstract List<ProductType> findParents(ProductType productType, Integer count);
	
	public abstract List<ProductType> findChildrens(ProductType parent, Integer count);
	
	public abstract List<ProductType> findChildrens(ProductType parent);
	
	public abstract List<ProductType> findTree();
}
