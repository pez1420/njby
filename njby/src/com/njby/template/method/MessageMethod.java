package com.njby.template.method;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.njby.utils.SpringUtils;

@Component("messageMethod")
public class MessageMethod implements TemplateMethodModelEx {
	public Object exec(@SuppressWarnings("rawtypes") List arguments) {
		if ((arguments != null) && (!arguments.isEmpty())
				&& (arguments.get(0) != null)
				&& (StringUtils.isNotEmpty(arguments.get(0).toString()))) {
			String message = null;
			String code = arguments.get(0).toString();
			if (arguments.size() > 1) {
				Object[] args = arguments.subList(1, arguments.size()).toArray();
				message = SpringUtils.getMessage(code, args);
			} else {
				message = SpringUtils.getMessage(code, new Object[0]);
			}
			return new SimpleScalar(message);
		}
		return null;
	}
}
