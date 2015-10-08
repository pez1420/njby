package com.njby.template.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Component;

import com.njby.entity.Notice;
import com.njby.service.NoticeService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class NoticeListDirective extends BaseDirective{
	
	@Resource
	private NoticeService noticeService;
	
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		boolean useCache = this.getUseCache(env, params);
		useCache = false;
		Integer count = this.getCount(params);
		
		List<Notice> notices = null;
		if (useCache) {
			//使用缓存
		} else {
			notices = this.noticeService.findList(count);
		}
		
		this.render("notices", notices, env, body);
	}

}
