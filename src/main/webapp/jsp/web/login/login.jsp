<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="format-detection" content="telephone=no">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<link rel="stylesheet" href="/css/web/login/global.css">
<link rel="stylesheet" href="/css/web/login/login.css">
<script type="text/javascript" src="/js/web/login/login.js"></script>
<title>账号登录</title>
</head>
<body>
<body>
	<div class="login">
            <div class="login-title"><p>推浪网登录</p>
                <i></i>
            </div>
            <form method="post" action="success.html">
            <div class="login-bar">
                <ul>
                    <li><img src="/css/web/images/login_user.png"><input type="text" class="text" placeholder="请输入用户名" /></li>
                    <li><img src="/css/web/images/login_pwd.png"><input type="password" class="psd" placeholder="请输入确认密码" /></li>
                </ul>
            </div>
            <div class="login-btn">
                <button class="submit" type="submit">登陆</button>
                <a href="register.html"><div class="login-reg"><p>莫有账号，先注册</p></div></a>
            </div>
            </form>
        </div>
		<div style="text-align:center;">
<div class="bottom">Copyright &copy; 2014 - 2015 <a href="#" style="color: #555555">系统登陆</a></div>
</div>
</body>
</html>