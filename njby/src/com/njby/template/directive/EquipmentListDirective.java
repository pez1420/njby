package com.njby.template.directive;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.njby.service.EquipmentService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;


@Component
public class EquipmentListDirective extends BaseDirective{

	@Resource
	private EquipmentService equipmentService;
	
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		boolean useCache = this.getUseCache(env, params);
		useCache = false;
		Integer count = this.getCount(params);

	}
}
