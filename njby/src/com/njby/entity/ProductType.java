package com.njby.entity;

import java.util.ArrayList;
import java.util.List;






import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.system.ananotation.EntityInfo;
import com.system.ananotation.Meaning;

@EntityInfo("产品类型")
public class ProductType extends OrderEntity{
	
	private static final long serialVersionUID = 7400092714869462635L;
	public static final String TREE_PATH_SEPRATOR = ",";
	
	@Meaning("名字")
	private String name;
	@Meaning("等级")
	private Integer grade;
	private String treePath;

	private String seoTitle; //页面标题
	private String seoKeywords; //页面关键词
	private String seoDescription; //页面描述
	  
	private ProductType parent;
	
	private List<ProductType> childrens = new ArrayList<ProductType>();
	
	List<Product> products = new ArrayList<Product>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getTreePath() {
		return treePath;
	}

	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}

	
	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public ProductType getParent() {
		return parent;
	}

	public void setParent(ProductType parent) {
		this.parent = parent;
	}

	public List<ProductType> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<ProductType> childrens) {
		this.childrens = childrens;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<String> getTreePaths() {
		List<String> treePaths = new ArrayList<String>();
	    String[] ids = StringUtils.split(getTreePath(), ",");
	    if (ids != null) {
	      for (String id : ids) {
	    	  treePaths.add(id);
	      }
	    }
	    return treePaths;
	}

	@Transient
	public String getPath() {
		if (getId() != null)
			return "/product/list/" + getId() + ".jhtml";
		
		return null;
	}
}
