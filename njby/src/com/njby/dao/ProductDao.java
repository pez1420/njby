package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.Product;
import com.njby.entity.search.SearchProduct;
import com.njby.utils.Pageable;

public interface ProductDao extends BaseDao<Product, String> {
	
	/**
	 * 产品分类分页
	 * 
	 * @param pageable
	 * 			分页
	 * @param searchProduct
	 * 			搜索条件
	 * @return
	 */
	public abstract List<Product> findPage(@Param("pageable")Pageable pageable, 
			@Param("search")SearchProduct searchProduct);
	
	/**
	 * 检查sn序列号是否存在
	 * 
	 * @param sn
	 * 		序列号
	 * 
	 * @return  是否存在
	 */
	public abstract boolean snExists(String sn);
	
	
	/**
	 * 
	 * @param count
	 * 
	 * @return
	 */
	public abstract  List<Product> findList(Integer count);
}
