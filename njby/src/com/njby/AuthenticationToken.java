package com.njby;

import org.apache.shiro.authc.UsernamePasswordToken;

public class AuthenticationToken extends UsernamePasswordToken {
	
	private static final long serialVersionUID = 8016386936876527828L;
	
	private String captchaId;
	private String captcha;

	public AuthenticationToken(String username, String password,
			String captchaId, String captcha, boolean rememberMe, String host) {
		super(username, password, rememberMe);
		this.captchaId = captchaId;
		this.captcha = captcha;
	}

	public String getCaptchaId() {
		return this.captchaId;
	}

	public void setCaptchaId(String captchaId) {
		this.captchaId = captchaId;
	}

	public String getCaptcha() {
		return this.captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
