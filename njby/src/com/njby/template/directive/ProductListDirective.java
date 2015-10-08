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

@Component
public class ProductListDirective extends BaseDirective{

	@Resource
	private ProductService productService;

	@Resource
	private ProductTypeService productTypeService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
		String productTypeId = FreemarkerUtils.getParameter("productTypeId", String.class, 
				params);
		ProductType productType = this.productTypeService.find(productTypeId);
		
		List products = null;
		if (productTypeId != null && productType == null) {
			products = new ArrayList();
		} else {
	    	boolean useCache = this.getUseCache(env, params);
			String  cacheRegion = this.getCacheRegion(env, params);
			Integer count = this.getCount(params);
			products = this.productService.findList(count);
		}
		render("products", products, env, body);

	}
}
