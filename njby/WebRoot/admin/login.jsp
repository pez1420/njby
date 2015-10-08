<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.system.Setting"%>
<%@page import="com.njby.utils.SettingUtils"%>
<%@page import="com.njby.utils.SpringUtils"%>
<%@page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@page import="java.util.UUID"%>
<%@page import="com.system.Setting.AccountLockType"%>
<%@page import="org.apache.commons.lang.ArrayUtils"%>
<%@page import="com.system.Setting.CaptchaType"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String base = request.getContextPath();
	String captchaId = UUID.randomUUID().toString();
	ApplicationContext applicationContext = SpringUtils.getApplicationContext();
	Setting setting = SettingUtils.get();
	System.out.println(setting.getSiteName());
	if (applicationContext != null) {
%>
		<shiro:authenticated>
<%
		response.sendRedirect(base + "/admin/common/main.jhtml");
%>
		</shiro:authenticated>
<%
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">
<%
if (applicationContext != null) {
	String message = null;
	String loginFailure = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
	if (loginFailure != null) {
		if (loginFailure.equals("org.apache.shiro.authc.pam.UnsupportedTokenException")) {
			message = "admin.captcha.invalid";
		} else if (loginFailure.equals("org.apache.shiro.authc.UnknownAccountException")) {
			message = "admin.login.unknownAccount";
		} else if (loginFailure.equals("org.apache.shiro.authc.DisabledAccountException")) {
			message = "admin.login.disabledAccount";
		} else if (loginFailure.equals("org.apache.shiro.authc.LockedAccountException")) {
			message = "admin.login.lockedAccount";
		} else if (loginFailure.equals("org.apache.shiro.authc.IncorrectCredentialsException")) {
			if (ArrayUtils.contains(setting.getAccountLockTypes(), AccountLockType.admin)) {
				message = "admin.login.accountLockCount";
			} else {
				message = "admin.login.incorrectCredentials";
			}
		} else if (loginFailure.equals("org.apache.shiro.authc.AuthenticationException")) {
			message = "admin.login.authentication";
		}
	}
%>
	<title>后台管理</title>
    <link href="<%=base%>/resources/css/admin/style.css" rel="stylesheet">
    <link href="<%=base%>/resources/css/admin/style-responsive.css" rel="stylesheet">
    
	<!-- Placed js at the end of the document so the pages load faster -->
	<script src="<%=base%>/resources/jquery-2.1.0.min.js"></script>
	<script src="<%=base%>/uilib/bootstrap-3/js/bootstrap.min.js"></script>
	<script src="<%=base%>/resources/modernizr.min.js"></script>
    <script src="<%=base%>/resources/admin/common.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="<%=base%>/resources/html5shiv.js"></script>
    <script src="<%=base%>/resources/respond.min.js"></script>
    <![endif]-->
    
    <script>
		$(function(){
			var $loginForm = $("#loginForm");
			var $enPassword = $("#enPassword");
			var $username = $("#username");
			var $password = $("#password");
			var $captcha = $("#captcha");
			var $captchaImage = $("#captchaImage");
			var $isRememberUsername = $("#isRememberUsername");
			
			// 记住用户名
			if(getCookie("adminUsername") != null) {
				$isRememberUsername.prop("checked", true);
				$username.val(getCookie("adminUsername"));
				$password.focus();
			} else {
				$isRememberUsername.prop("checked", false);
				$username.focus();
			}
			
			// 更换验证码
			$captchaImage.click( function() {
				$captchaImage.attr("src", "<%=base%>/admin/common/captcha.jhtml?captchaId=<%=captchaId%>&timestamp=" + (new Date()).valueOf());
			});

			// 表单验证、记住用户名
			$loginForm.submit( function() {
				if ($username.val() == "") {
					//$.message("warn", "<%=SpringUtils.getMessage("admin.login.usernameRequired")%>");
					return false;
				}
				if ($password.val() == "") {
					//$.message("warn", "<%=SpringUtils.getMessage("admin.login.passwordRequired")%>");
					return false;
				}
				if ($captcha.val() == "") {
					//$.message("warn", "<%=SpringUtils.getMessage("admin.login.captchaRequired")%>");
					return false;
				}
				
				if ($isRememberUsername.prop("checked")) {
					addCookie("adminUsername", $username.val(), {expires: 7 * 24 * 60 * 60});
				} else {
					removeCookie("adminUsername");
				}
				
				$enPassword.val($password.val());
				console.log($enPassword.val());
				
			});

			<%if (message != null) {%>
				//$.message("error", "<%=SpringUtils.getMessage(message, setting.getAccountLockCount())%>");
				alert("<%=message%>");
			<%}%>
		
			
		});
    </script>
<%} else {%>
	<title>后台管理</title>
    <link href="<%=base%>/resources/css/admin/style.css" rel="stylesheet">
    <link href="<%=base%>/resources/css/admin/style-responsive.css" rel="stylesheet">

	<script src="<%=base%>/resources/jquery-2.1.0.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="<%=base%>/resources/html5shiv.js"></script>
    <script src="<%=base%>/resources/respond.min.js"></script>
    <![endif]-->
<%}%>
</head>
<body class="login-body">
	<%if (applicationContext != null) {%>
		<div class="container">
	
	    <form class="form-signin form-horizontal" id="loginForm" action="login.jsp" method="post">
	        <input type="hidden" id="enPassword" name="enPassword" />
	        <input type="hidden" name="captchaId" value="<%=captchaId%>" />
	        <div class="form-signin-heading text-center">
	            <h1 class="sign-title"><i class="fa fa-sun-o"></i>乾冠Waf监控管理平台</h1>
	            <img src="<%=base%>/resources/images/admin/login/login-logo.png" alt=""/>
	        </div>
	
	        <div class="login-wrap">
	            <div class="form-group text-center">
	                <label class="col-md-3 col-sm-3 control-label">用户名</label>
	
	                <div class="col-md-9 col-sm-9">
	                    <input class="form-control" name="username" type="text"  placeholder="用户名" autofocus>
	                </div>
	            </div>
	
	
	            <div class="form-group text-center">
	                <label class="col-md-3 col-sm-3 control-label">密码</label>
	
	                <div class="col-md-9 col-sm-9">
	                    <input  class="form-control" id="password" type="password" placeholder="密码">
	                </div>
	            </div>
	
	            <div class="form-group text-center">
	                <label class="col-md-3 col-sm-3 control-label">验证码</label>
	
	                <div class="col-md-5 col-sm-5">
	                    <input  class="form-control" id="captcha" name="captcha" type="text" maxlength="4" autocomplete="off" placeholder="验证码">
	                </div>
	                
	                <div class="col-md-4 col-sm-4">
	                    <img class="form-control captchaImage" style="padding:0px" id="captchaImage"  src="<%=base%>/admin/common/captcha.jhtml?captchaId=<%=captchaId%>" title="" />
	                </div>
	
	            </div>
	
	
	            <button class="btn btn-lg btn-login btn-block" type="submit">
	                <i class="fa fa-check"></i>
	            </button>
	
	            <label class="checkbox">
	                <input type="checkbox" id="isRememberUsername" value="true" > 记住当前用户
	                <span class="pull-right">
	                    <a data-toggle="modal" href="#myModal"> 忘记密码?</a>
	                </span>
	            </label>
	
	        </div>
	
	        <!-- Modal 取回忘记的密码模式对话框-->
	        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
	            <div class="modal-dialog">
	                <div class="modal-content">
	                    <div class="modal-header">
	                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                        <h4 class="modal-title">忘记密码 ?</h4>
	                    </div>
	                    <div class="modal-body">
	                        <p>输入Email地址找回密码.</p>
	                        <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
	
	                    </div>
	                    <div class="modal-footer">
	                        <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
	                        <button class="btn btn-primary" type="button">确定</button>
	                    </div>
	                </div>
	            </div>
	        </div>
	
	    </form>
	
	</div>
	

<%} else {%>
	系统出现异常
<%}%>
</body>
</html>
    

