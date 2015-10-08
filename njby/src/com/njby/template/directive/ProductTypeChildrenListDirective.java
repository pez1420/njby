package com.njby.template.directive;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;









import org.springframework.stereotype.Component;

import com.njby.entity.ProductType;
import com.njby.service.ProductService;
import com.njby.service.ProductTypeService;
import com.njby.utils.FreemarkerUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

@Component("productTypeChildrenListDirective")
public class ProductTypeChildrenListDirective extends BaseDirective{

	@Resource
	private ProductTypeService productTypeService;

	public void execute(Environment env, Map params, TemplateModel[] loopVars, 
			TemplateDirectiveBody body) throws TemplateException, IOException {
		String productTypeId = FreemarkerUtils.getParameter("productTypeId", String.class, params);
		ProductType productType = this.productTypeService.find(productTypeId);
	    List productTypes = null;
	    if ((productTypeId != null) && (productType == null)) {
	    	productTypes = new ArrayList();
	    } else {
	    	boolean useCache = this.getUseCache(env, params);
			String  cacheRegion = this.getCacheRegion(env, params);
			Integer count = this.getCount(params);
			useCache = false;
			if (useCache) {
	    	  //productTypes = this.IIIlllII.findChildren(productCategory, localInteger, str);
			} else {
	    	  productTypes = this.productTypeService.findChildrens(productType, count);
			}
	    }
	    render("productTypes", productTypes, env, body);
	}
}
