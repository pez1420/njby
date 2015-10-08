package com.njby.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.dao.ProductDao;
import com.njby.entity.Product;
import com.njby.entity.search.SearchProduct;
import com.njby.service.ProductService;
import com.njby.utils.Page;
import com.njby.utils.Pageable;


@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, String> 
	implements ProductService{
	
	@Resource
	private ProductDao productDao;
	
	@Resource
	public void setBaseDao(ProductDao productDao) {
		super.setBaseDao(productDao);
	}

	@Transactional(readOnly=true)
	public Page<Product> findPage(Pageable pageable, SearchProduct searchProduct) {
		//分页并计算出总页数 
		List<Product> products = productDao.findPage(pageable, searchProduct);
		Page<Product> page = new Page<Product>(products, pageable);
		return page;
	}

	@Transactional(readOnly=true)
	public boolean snExists(String sn) {
		return this.productDao.snExists(sn);
	}
	
	@Transactional(readOnly=true)
	public boolean snUnique(String previousSn, String currentSn) {
	    if (StringUtils.equalsIgnoreCase(previousSn, currentSn)) {
	        return true;
	    }
	    
	    return !this.productDao.snExists(currentSn);
	}

	@Transactional(readOnly=true)
	public List<Product> findList(Integer count) {
		return this.productDao.findList(count);
	}
	
}
