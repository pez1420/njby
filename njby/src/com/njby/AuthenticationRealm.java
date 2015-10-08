package com.njby;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.njby.entity.Admin;
import com.njby.service.AdminService;
import com.njby.service.CaptchaService;
import com.njby.utils.SettingUtils;
import com.system.Setting;
import com.system.Setting.CaptchaType;


public class AuthenticationRealm extends AuthorizingRealm {
	@Resource(name = "captchaServiceImpl")
	private CaptchaService captchaService;
	@Resource(name = "adminServiceImpl")
	private AdminService adminService;

	/*这是认证（登陆）方式*/
	protected AuthenticationInfo doGetAuthenticationInfo(
			org.apache.shiro.authc.AuthenticationToken token) {
		/**
		 * Shiro的认证过程最终会交由Realm执行，这时会调用Realm的getAuthenticationInfo(token)方法。 
			该方法主要执行以下操作: 
			1、检查提交的进行认证的令牌信息 
			2、根据令牌信息从数据源(通常为数据库)中获取用户信息 
			3、对用户信息进行匹配验证。 
			4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例。 
			5、验证失败则抛出AuthenticationException异常信息。
			
			而在我们的应用程序中要做的就是自定义一个Realm类，继承AuthorizingRealm抽象类，
			重载doGetAuthenticationInfo ()，重写获取用户信息的方法。 
		 */
		//token中存储着输入的用户名和密码
		AuthenticationToken authenticationToken = (AuthenticationToken) token;
		// 通过表单接收的用户名
		String username = authenticationToken.getUsername();
		// 通过表单接收的密码
		String password = new String(authenticationToken.getPassword());
		//通过表单接收的验证码
		String captchaId = authenticationToken.getCaptchaId();
		String captcha = authenticationToken.getCaptcha();
		String host = authenticationToken.getHost();
		
		if (!this.captchaService.isValid(CaptchaType.adminLogin, 
				captchaId, captcha)) {
			throw new UnsupportedTokenException();
		}
		
		if ((username != null) && (password != null)) {
			Admin admin = this.adminService.findByUsername(username);
			if (admin == null) {
				throw new UnknownAccountException();
			}
			if (!admin.getIsEnabled().booleanValue()) {
				throw new DisabledAccountException();
			}
			
			Setting setting = SettingUtils.get();
			if (admin.getIsLocked().booleanValue()) {
				if (ArrayUtils.contains(setting.getAccountLockTypes(),
						Setting.AccountLockType.admin)) {
					int lockTime = setting.getAccountLockTime().intValue();
					if (lockTime == 0) {
						throw new LockedAccountException();
					}
					Date lockDate = admin.getLockedDate();
					Date addDate = DateUtils.addMinutes(lockDate, lockTime);
					if (new Date().after(addDate)) {
						admin.setLoginFailureCount(Integer.valueOf(0));
						admin.setIsLocked(Boolean.valueOf(false));
						admin.setLockedDate(null);
						this.adminService.update(admin);
					} else {
						throw new LockedAccountException();
					}
				} else {
					admin.setLoginFailureCount(Integer.valueOf(0));
					admin.setIsLocked(Boolean.valueOf(false));
					admin.setLockedDate(null);
					this.adminService.update(admin);
				}
			}
			
			//!DigestUtils.md5Hex(password)
			if (!password.equals(admin.getPassword())) {
				int failureCounts = admin.getLoginFailureCount().intValue() + 1;
				if (failureCounts >= setting.getAccountLockCount().intValue()) {
					admin.setIsLocked(Boolean.valueOf(true));
					admin.setLockedDate(new Date());
				}
				admin.setLoginFailureCount(Integer.valueOf(failureCounts));
				this.adminService.update(admin);
				throw new IncorrectCredentialsException();
			}
			
			admin.setLoginIp(host);
			admin.setLoginDate(new Date());
			admin.setLoginFailureCount(Integer.valueOf(0));
			
			this.adminService.update(admin);
			
			return new SimpleAuthenticationInfo(new Principal(
					admin.getId(), username), password, getName());
		}
		throw new UnknownAccountException();
	}

	/*这是授权(访问控制)方法*/
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		/**
		 * 而授权实现则与认证实现非常相似，在我们自定义的Realm中，
		 * 重载doGetAuthorizationInfo()方法，
		 * 重写获取用户权限的方法即可。 
		 */
		
		Principal principal = (Principal) principals.fromRealm(getName()).iterator().next();
		if (principal != null) {
			List<String> permissions = this.adminService.findAuthorities(principal.getId());
			if (permissions != null) {
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				info.addStringPermissions(permissions);
				return info;
			}
		}
		return null;
	}
}
