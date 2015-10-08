package com.njby.service;

import java.util.List;


import com.njby.entity. Catalog;

public interface CatalogService extends BaseService<Catalog, String> {
	
	  public abstract List<Catalog> findRoots(Integer count);
	  
	  public abstract List<Catalog> findParents(List<String> ids, Integer count);
	  
	  public abstract List<Catalog> findParents(Catalog catalog, Integer count);
	  
	  public abstract List<Catalog> findChildrens(Catalog parent, Integer count);
		
	  public abstract List<Catalog> findTree();
}
