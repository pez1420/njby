package com.njby.service;

import java.util.Map;

public interface StaticService {
	  public abstract int build(String templatePath, String staticPath,
				Map<String, Object> model);
	  
	  public abstract int build(String templatePath, String staticPath);
	  
	  //public abstract int build(Article article);
	  
	  //public abstract int build(Product paramProduct);
	  
	  public abstract int buildIndex();
	  
	  public abstract int buildAboutus();
	  
	  public abstract int buildContactus();
	  
	  public abstract int buildSitemap();
	  
	  public abstract int buildOther();
	  
	  public abstract int buildAll();
	  
	  public abstract int delete(String paramString);
	  
	  //public abstract int delete(Article paramArticle);
	  
	  //public abstract int delete(Product paramProduct);
	  
	  public abstract int deleteIndex();
	  
	  public abstract int deleteOther();
}
