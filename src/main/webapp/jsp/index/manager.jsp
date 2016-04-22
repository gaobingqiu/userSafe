<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
<style type="text/css">
h1{
text-align: center;
margin-bottom: 20px;
}
a{margin-left: 50px;
margin-bottom: 20px;
}
</style>
<title>后台管理中心</title>
</head>
<body>
    <h1 >亲爱管理员，欢迎进入后台管理中心！</h1>
    <a href="/advise/goList.do" class="button blue medium">进入用户建议管理中心！</a>
    <a href="/manager/goList.do" class="button gray medium">进入管理员管理中心！</a>
    <a href="/records/goList.do" class="button blue medium">进入安全记录管理中心！</a>
    <a href="/user/goList.do" class="button gray medium" >进入用户管理中心！</a>
    <a href="/web/goList.do" class="button blue medium">进入门户管理中心！</a>
    <a href="/file/toUpload.do" class="button gray medium">进入文件上传测试中心！</a>
</body>
<link rel="stylesheet" type="text/css" href="/css/button/page.css" />
<link rel="stylesheet" type="text/css" href="/css/button/buttons.css" />
</html>