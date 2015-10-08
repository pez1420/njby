package com.njby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.dao.ProductTypeDao;
import com.njby.entity.ProductType;
import com.njby.entity.search.SearchProductType;
import com.njby.service.ProductTypeService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;

@Service
public class ProductTypeServiceImpl extends BaseServiceImpl<ProductType, String> 
	implements ProductTypeService{

	@Resource
	private ProductTypeDao productTypeDao;
	
	@Resource
	public void setBaseDao(ProductTypeDao productTypeDao) {
		super.setBaseDao(productTypeDao);
	}

	@Transactional
	public void save(ProductType productType) {
		super.save(productType);
	}
	
	@Transactional(readOnly=true)
	public Page<ProductType> findPage(Pageable pageable, SearchProductType searchProductType) {
		//分页并计算出总页数 
		List<ProductType> productTypes = productTypeDao.findPage(pageable, searchProductType);
		Page<ProductType> page = new Page<ProductType>(productTypes, pageable);
		return page;
	}

	@Transactional(readOnly=true)
	public List<ProductType> findRoots(Integer count) {
		return productTypeDao.findRoots(count);
	}

	@Override
	public List<ProductType> findParents(List<String> ids, Integer count) {
		return this.productTypeDao.findParents(ids, count);
	}


	@Override
	public List<ProductType> findChildrens(ProductType parent, Integer count) {
		List<ProductType> childs = this.productTypeDao.findChildrens(parent, count);
		return childs;
	}

	@Transactional(readOnly=true)
	public List<ProductType> findTree() {
		return this.findChildrens(null, null);
	}
	
	
	@Transactional(readOnly=true)
	public List<ProductType> findParents(ProductType productType, Integer count) {
		List<String> ids = productType.getTreePaths();
		return this.productTypeDao.findParents(ids, count);
	}
	

	@Transactional(readOnly=true)
	public List<ProductType> findChildrens(ProductType parent) {
		return this.findChildrens(parent, null);
	}


}
