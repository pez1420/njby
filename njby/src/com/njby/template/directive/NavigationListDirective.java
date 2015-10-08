package com.njby.template.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Component;

import com.njby.entity.Navigation;
import com.njby.service.NavigationService;
import com.njby.utils.FreemarkerUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class NavigationListDirective extends BaseDirective{
	
	@Resource(name="navigationServiceImpl")
	private NavigationService navigationService;
	  
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, 
			TemplateDirectiveBody body) throws TemplateException, IOException {
		Integer position = (Integer) FreemarkerUtils.getParameter(
				"position", Integer.class, params); 
		List<Navigation> navigations = this.navigationService.findList(position);
		render("navigations", navigations, env, body);
	}

}
