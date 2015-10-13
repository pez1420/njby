package com.njby.controller.admin;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;


import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.njby.service.ProductService;
import com.njby.service.StaticService;

@Controller("adminStaticController")
@RequestMapping({ "/admin/static" })
public class StaticController extends BaseAdminController {
	
	public enum BuildType
	{
	  index,  aboutus, article,  product,  other;
	}
	
	@Resource
	private ProductService productService;
	@Resource
	private StaticService staticService;
	
	@RequestMapping(value = { "/build" }, method = { RequestMethod.GET })
	public String build(ModelMap model) {
		model.addAttribute("defaultBeginDate",
				DateUtils.addDays(new Date(), -7));
		model.addAttribute("defaultEndDate", new Date());
		return "/admin/content/static/static";
	}
	
	@RequestMapping(value = { "/build" }, method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> build(Integer buildType, Date beginDate,
			Date endDate, Integer first, Integer count, ModelMap model) {
		//开始时间
		long st = System.currentTimeMillis();
		
		Calendar calendar;
		if (beginDate != null) { 
			calendar = DateUtils.toCalendar(beginDate);
			calendar.set(11, calendar.getActualMinimum(11)); 
			calendar.set(12, calendar.getActualMinimum(12));
			calendar.set(13, calendar.getActualMinimum(13));
			beginDate = calendar.getTime();
		}
		if (endDate != null) {
			calendar = DateUtils.toCalendar(endDate);
			calendar.set(11, calendar.getActualMaximum(11));
			calendar.set(12, calendar.getActualMaximum(12));
			calendar.set(13, calendar.getActualMaximum(13));
			endDate = calendar.getTime();
		}
		
		if ((first == null) || (first.intValue() < 0)) {
			first = Integer.valueOf(0);
		}
		
		if ((count == null) || (count.intValue() <= 0)) {
			count = Integer.valueOf(50);
		}	
		
		int i = 0;
		boolean bool = true;
		
		//首页
		if (buildType.intValue() == 0) {
			this.staticService.buildIndex();
		} else if (buildType.intValue() == 1) {
			this.staticService.buildAboutus();
		} else if (buildType.intValue() == 2) {
			this.staticService.buildAboutus();
		} else {
			this.staticService.buildAll();
		}
		
		//结束时间
		long et = System.currentTimeMillis();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first", first);
		map.put("buildCount", Integer.valueOf(i));
		map.put("buildTime", Long.valueOf(et - st));
		map.put("isCompleted", Boolean.valueOf(bool));
		return map;
	}
}
