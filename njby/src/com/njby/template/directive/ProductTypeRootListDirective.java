package com.njby.template.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.njby.entity.ProductType;
import com.njby.service.ProductTypeService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class ProductTypeRootListDirective extends BaseDirective{
	
	@Resource
	private ProductTypeService productTypeService;
	
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		boolean useCache = this.getUseCache(env, params);
		useCache = false;
		String  cacheRegion = this.getCacheRegion(env, params);
		Integer count = this.getCount(params);
		
		List<ProductType> list = null;
		if (useCache) {
			//从缓存中读取数据
			//list = this.productTypeService.findRoots(count, cacheRegion);
		} else {
			list = this.productTypeService.findRoots(count);
		}
		
		render("productTypes", list, env, body);
	}
}
