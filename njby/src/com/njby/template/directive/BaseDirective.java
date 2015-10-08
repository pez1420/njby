package com.njby.template.directive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.njby.Order;
import com.njby.utils.FreemarkerUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/***
 *   TemplateDirectiveModel接口是freemarker自定标签或者自定义指令的核心处理接口。
 *   通过实现该接口，用户可以自定义标签（指令）进行任意操作，、 任意文本写入模板的输出。
	     该接口中只定义了如下方法，当模板页面遇到用户自定义的标签指令时，该方法会被执行。
	public void execute(Environment env, Map params, TemplateModel[] loopVars, 
	            TemplateDirectiveBody body) throws TemplateException, IOException;
	 
	@param env：系统环境变量，通常用它来输出相关内容，如Writer out = env.getOut();
	@param params：自定义标签传过来的对象，其key=自定义标签的参数名，value值是TemplateModel类型，
				而TemplateModel是一个接口类型，通常我们都使用TemplateScalarModel
				接口来替代它获取一个String值，如TemplateScalarModel.getAsString();
				当然还有其它常用的替代接口，如TemplateNumberModel获取number，TemplateHashModel等
	@param loopVars  循环替代变量
	@param body 用于处理自定义标签中的内容，如<@myDirective>将要被处理的内容</@myDirective>；
	                当标签是<@myDirective />格式时，body=null
 *  @author Administrator
 *
 */

public abstract class BaseDirective implements TemplateDirectiveModel {
	
	private static final String PARAM_USECACHE = "useCache";
	private static final String PARAM_CACHEREGION = "cacheRegion";
	private static final String PARAM_ID = "id";
	private static final String PARAM_COUNT = "count";
	
	protected boolean getUseCache(Environment paramEnvironment,Map<String, TemplateModel> map) throws TemplateModelException {
		Boolean b = (Boolean) FreemarkerUtils.getParameter(PARAM_USECACHE, Boolean.class, map);
		return b != null ? b.booleanValue() : true;
	}

	protected String getCacheRegion(Environment paramEnvironment,Map<String, TemplateModel> map) throws TemplateModelException {
		String str = (String) FreemarkerUtils.getParameter(PARAM_CACHEREGION,String.class, map);
		return str != null ? str : paramEnvironment.getTemplate().getName();
	}

	protected Long getID(Map<String, TemplateModel> map)throws TemplateModelException {
		return (Long) FreemarkerUtils.getParameter(PARAM_ID, Long.class, map);
	}

	protected Integer getCount(Map<String, TemplateModel> map)throws TemplateModelException {
		return (Integer) FreemarkerUtils.getParameter(PARAM_COUNT, Integer.class, map);
	}
	
	protected List<Order> getOrderBy(Map<String, TemplateModel> map, 
			  String[] paramArrayOfString) throws TemplateModelException {
	    String orderBy = StringUtils.trim((String)FreemarkerUtils.getParameter("orderBy", String.class, map));
	    List<Order> orders = new ArrayList<Order>();
	    
	    if (StringUtils.isNotEmpty(orderBy)) {
	    	String[] strs = orderBy.split("\\s*,\\s*");
	    	for (String str : strs) {
	    		if (!StringUtils.isNotEmpty(str))
	    			continue;
	    		
	    		String property = null;
	    		Order.Direction direction = null;
	    		String[] fields = str.split("\\s+");
	    		
	    		if (fields.length == 1) {
	    			property = fields[0];
	    			
	    		} else {
	    			if (fields.length < 2)
	    				continue;
	    			
	    			property = fields[0];
	    			try {
	    				direction = Order.Direction.valueOf(fields[1]);
	    			} catch (IllegalArgumentException e) {
	    				continue;
	    			}
	    		}
	    		
	    		if (ArrayUtils.contains(paramArrayOfString, property))
	    			continue;
	    		
	    		orders.add(new Order(property, direction));
	    	}
	    }
	    
	    return orders;
	}	
	
	protected void render(String name, Object object, Environment env,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		TemplateModel templateModel = FreemarkerUtils.getVariable(name, env);
		FreemarkerUtils.setVariable(name, object, env);
		body.render(env.getOut());
		FreemarkerUtils.setVariable(name, templateModel, env);
	}

	@SuppressWarnings("rawtypes")
	protected void render(Map<String, Object> map, Environment env,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		HashMap hashMap = new HashMap();
		Iterator iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String name = (String) iterator.next();
			TemplateModel templateModel = FreemarkerUtils.getVariable(name, env);
			hashMap.put(name, templateModel);
		}
		FreemarkerUtils.setVariables(map, env);
		body.render(env.getOut());
		FreemarkerUtils.setVariables(hashMap, env);
	}
}
