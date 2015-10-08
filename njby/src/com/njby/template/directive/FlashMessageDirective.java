package com.njby.template.directive;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.njby.utils.Message;


import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component
public class FlashMessageDirective extends BaseDirective {
	public static final String FLASH_MESSAGE_ATTRIBUTE_NAME = FlashMessageDirective.class
			.getName() + ".FLASH_MESSAGE";
	private static final String FLASH_MESSAGE = "flashMessage";

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		RequestAttributes requestAttributes = RequestContextHolder
				.currentRequestAttributes();
		if (requestAttributes != null) {
			Message message = (Message) requestAttributes
					.getAttribute(FLASH_MESSAGE_ATTRIBUTE_NAME, 0);
			if (body != null) {
				render(FLASH_MESSAGE, message, env, body);
			} else if (message != null) {
				Writer writer = env.getOut();
				if (message.getType() == Message.Type.success) {
					writer.write("$.scojs_message(\"" + message.getContent() 
							+ "\", $.scojs_message.TYPE_OK);");
				} else {
					writer.write("$.scojs_message(\"" + message.getContent() 
							+ "\", $.scojs_message.TYPE_ERROR);");
				}
			}
		}
	}
}
