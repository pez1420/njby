package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.ProductType;
import com.njby.entity.ProductType;
import com.njby.entity.search.SearchProductType;
import com.njby.utils.Pageable;

public interface ProductTypeDao extends BaseDao<ProductType, String>{
	
	public abstract List<ProductType> findPage(@Param("pageable")Pageable pageable, 
			@Param("search")SearchProductType searchProductType);

	public abstract List<ProductType> findRoots(Integer count);

	public abstract List<ProductType> findParents(
			@Param("ids") List<String> ids, @Param("count") Integer count);

	public abstract List<ProductType> findChildrens(
			@Param("parent") ProductType parent, @Param("count") Integer count);
	
}
