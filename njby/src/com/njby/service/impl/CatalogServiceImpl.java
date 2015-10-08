package com.njby.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njby.dao.CatalogDao;
import com.njby.entity.Catalog;
import com.njby.service.CatalogService;

@Service
public class CatalogServiceImpl extends BaseServiceImpl<Catalog, String> 
	implements CatalogService {

	@Resource
	private CatalogDao catalogDao;
	
	@Resource
	public void setBaseDao(CatalogDao catalogDao) {
		super.setBaseDao(catalogDao);
	}
	
	@Override
	public List<Catalog> findRoots(Integer count) {
		return catalogDao.findRoots(count);
	}

	@Override
	public List<Catalog> findParents(List<String> ids, Integer count) {
		return this.catalogDao.findParents(ids, count);
	}


	@Override
	public List<Catalog> findChildrens(Catalog parent, Integer count) {
		List<Catalog> childs = this.catalogDao.findChildrens(parent, count);
		return childs;
		//return repeat(childs, parent);
	}
	
	@Transactional(readOnly=true)
	public List<Catalog> findParents(Catalog catalog, Integer count) {
		List<String> ids = catalog.getTreePaths();
		return this.catalogDao.findParents(ids, count);
	}
	
	@Transactional(readOnly=true)
	public List<Catalog> findTree() {
		return this.findChildrens(null, null);
	}
	

	@Transactional
	public void save(Catalog catalog) {
		super.save(catalog);
	}
	
/*	private List<Catalog> repeat(List<Catalog> childs,
			Catalog parent) {
		List<Catalog> resList = new ArrayList<Catalog>();
		if (childs != null) {
			Iterator<Catalog> it = childs.iterator();
			while (it.hasNext()) {
				Catalog catalog = (Catalog) it.next();
				if (catalog.getParent() == parent) {
					resList.add(catalog);
					resList.addAll(repeat(childs, catalog));
				}
			}
		}
		return resList;
	}*/
}
