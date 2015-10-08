package com.njby.template.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.njby.entity.Culture;
import com.njby.entity.Notice;
import com.njby.service.CultureService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;


@Component
public class CultureListDirective extends BaseDirective{
	
	@Resource
	private CultureService cultureService;

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		boolean useCache = this.getUseCache(env, params);
		useCache = false;
		Integer count = this.getCount(params);
		
		List<Culture> cultures = null;
		if (useCache) {
			//使用缓存
		} else {
			cultures = this.cultureService.findList(count);
		}
		
		this.render("cultures", cultures, env, body);
	}

}
