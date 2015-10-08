package com.njby.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * shiro机制 身份认证过滤器
 * 
 * @author Administrator
 * 
 */
public class AuthenticationFilter extends FormAuthenticationFilter {

	// 添加 captchaParam 等变量，为的是页面表单提交验证码的参数名可以进行灵活配置
	private String enPasswordParam = "enPassword";
	private String captchaIdParam = "captchaId";
	private String captchaParam = "captcha";

	// 首先覆盖 createToken 方法，以便获取 CaptchaUsernamePasswordToken 实例
	protected org.apache.shiro.authc.AuthenticationToken createToken(
			ServletRequest servletRequest, ServletResponse servletResponse) {
		String username = getUsername(servletRequest);
		String password = getPassword(servletRequest);
		String captchaId = getCaptchaId(servletRequest);
		String captcha = getCaptcha(servletRequest);
		boolean rememberMe = isRememberMe(servletRequest);
		String host = getHost(servletRequest);
		System.out.println(username + ", " + password + ", " + captchaId + ", "
				+ captcha + ", " + rememberMe);
		return new com.njby.AuthenticationToken(username, password,
				captchaId, captcha, rememberMe, host);
	}

	protected boolean onAccessDenied(ServletRequest servletRequest,
			ServletResponse servletResponse) throws IOException, Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		// Ajax 请求多了个 "x-requested-with"参数
		String str = httpServletRequest.getHeader("X-Requested-With");
		if ((str != null) && (str.equalsIgnoreCase("XMLHttpRequest"))) {
			httpServletResponse.addHeader("loginStatus", "accessDenied");
			httpServletResponse.sendError(403);

			return false;
		}
		return super.onAccessDenied(httpServletRequest, httpServletResponse);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected boolean onLoginSuccess(
			org.apache.shiro.authc.AuthenticationToken token, Subject subject,
			ServletRequest servletRequest, ServletResponse servletResponse)
			throws IOException, Exception {
		Session session = subject.getSession();
		HashMap hashMap = new HashMap();
		Collection<?> collection = session.getAttributeKeys();
		Iterator<?> cIterator = collection.iterator();
		Object keyObject;
		while (cIterator.hasNext()) {
			keyObject = cIterator.next();
			hashMap.put(keyObject, session.getAttribute(keyObject));
		}
		session.stop();
		session = subject.getSession();
		Iterator entryIterator = hashMap.entrySet().iterator();
		while (entryIterator.hasNext()) {
			Map.Entry entry = (Map.Entry) entryIterator.next();
			session.setAttribute(entry.getKey(), entry.getValue());
		}
		return super.onLoginSuccess(token, subject, servletRequest,
				servletResponse);
	}

	protected String getPassword(ServletRequest servletRequest) {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		String pwd = httpServletRequest.getParameter(this.enPasswordParam);
		return pwd;
	}

	protected String getCaptchaId(ServletRequest servletRequest) {
		String captchaId = WebUtils.getCleanParam(servletRequest,
				this.captchaIdParam);
		if (captchaId == null) {
			captchaId = ((HttpServletRequest) servletRequest).getSession()
					.getId();
		}
		return captchaId;
	}

	protected String getCaptcha(ServletRequest servletRequest) {
		return WebUtils.getCleanParam(servletRequest, this.captchaParam);
	}

	public String getEnPasswordParam() {
		return this.enPasswordParam;
	}

	public void setEnPasswordParam(String enPasswordParam) {
		this.enPasswordParam = enPasswordParam;
	}

	public String getCaptchaIdParam() {
		return this.captchaIdParam;
	}

	public void setCaptchaIdParam(String captchaIdParam) {
		this.captchaIdParam = captchaIdParam;
	}

	public String getCaptchaParam() {
		return this.captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}
}
