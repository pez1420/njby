package com.njby.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.njby.entity.Catalog;

public interface CatalogDao extends BaseDao<Catalog, String> {

	public abstract List<Catalog> findRoots(Integer count);

	public abstract List<Catalog> findParents(
			@Param("ids") List<String> ids, @Param("count") Integer count);

	public abstract List<Catalog> findChildrens(
			@Param("parent") Catalog parent, @Param("count") Integer count);

}
