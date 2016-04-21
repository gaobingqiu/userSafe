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
<link rel="stylesheet" href="/css/web/login/register.css">
<script type="text/javascript" src="/js/web/login/register.js"></script>
<title>账号注册</title>
</head>
<body>
<body>
	 <div id="layout">
            <span>推浪网账号注册</span>
            <form  method="post">
            <ul>
                <p id="err_msg"></p>
                <li><i class="un"><img src="/css/web/images/user_name.png"></i><input class="username" type="text" placeholder="请输入用户名" /></li>
                <li><i class="yz"><img src="/css/web/images/msg.png"></i><input class="yzm" type="text" placeholder="请输入手机验证码" /><input type="button" id="send" value="获取验证码" /></li>
                <li><i class="pw"><img src="/css/web/images/pwd.png"></i><input class="pwd" type="password" placeholder="请输入密码" /></li>
                <li><i class="pw2"><img src="/css/web/images/pwd.png"></i><input class="pwd2" type="password" placeholder="请输入确认密码" /></li>
            </ul>
                <div class="reg_btn">
                    <button class="submit" type="submit">注册</button>
                    <a href="login.html"><div class="reg-login"><p>已有帐号，立即登陆</p></div></a>
                </div>
            </form>
        </div>
        <div class="bottom">Copyright &copy; 2014 - 2015 <a href="#" style="color: #555555">系统登陆</a></div>
</body>
</html>