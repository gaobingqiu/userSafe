<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>密码管理</title>
<link href="/css/web/personal/codeManage.css" rel="stylesheet"
	type="text/css" />
<script src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/js/manage/select-ui.min.js"></script>
<script type="text/javascript">
	KE.show({
		id : 'content7',
		cssPath : './index.css'
	});
</script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 200
		});
		$(".select3").uedSelect({
			width : 200
		});
	});
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
		</ul>
	</div>

	<div class="formbody">
		<div id="tab2" class="tabson">
			<ul class="seachform">
				<li><label>综合查询</label><input name="" type="text"
					class="scinput" /></li>

				<li><label>重点网站</label>
					<div class="vocation">
						<select class="select3">
							<option>高评价</option>
							<option>其他</option>
						</select>
					</div></li>

				<li><label>网站状态</label>
					<div class="vocation">
						<select class="select3">
							<option>支持快速登陆</option>
							<option>其他</option>
						</select>
					</div></li>

				<li><label>&nbsp;</label><input name="" type="button"
					class="scbtn" value="查询" /></li>

			</ul>

			<table class="tablelist">
				<thead>
					<tr>
						<th><input name="" type="checkbox" value="" checked="checked" /></th>
						<th>编号<i class="sort"><img src="/images/manage/px.gif" /></i></th>
						<th>网站</th>
						<th>上次登陆时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input name="" type="checkbox" value="" /></td>
						<td>20150908</td>
						<td>www.baidu.com</td>
						<td>2015-09-09 15:05</td>
						<td><a href="#" class="tablelink">获取</a> <a href="#"
							class="tablelink"> 登陆</a></td>
					</tr>

					<tr>
						<td><input name="" type="checkbox" value="" /></td>
						<td>20150907</td>
						<td>http://www.csdn.net/</td>
						<td>2015-09-08 14:02</td>
						<td><a href="#" class="tablelink">获取</a> <a href="#"
							class="tablelink"> 登陆</a></td>
					</tr>

					<tr>
						<td><input name="" type="checkbox" value="" /></td>
						<td>20150906</td>
						<td>http://www.sina.com.cn/</td>
						<td>2015-09-07 13:16</td>
						<td><a href="#" class="tablelink">获取</a> <a href="#"
							class="tablelink"> 登陆</a></td>
					</tr>

					<tr>
						<td><input name="" type="checkbox" value="" /></td>
						<td>20150905</td>
						<td>http://www.nubia.com/</td>
						<td>2015-09-06 10:36</td>
						<td><a href="#" class="tablelink">获取</a> <a href="#"
							class="tablelink"> 登陆</a></td>
					</tr>

					<tr>
						<td><input name="" type="checkbox" value="" /></td>
						<td>20150907</td>
						<td>https://www.ttpod.com/</td>
						<td>2015-09-08 14:02</td>
						<td><a href="#" class="tablelink">获取</a> <a href="#"
							class="tablelink"> 登陆</a></td>
					</tr>
				</tbody>
			</table>
		</div>

	</div>
	<script type="text/javascript">
		$("#usual1 ul").idTabs();
	</script>

	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	</div>
</body>
</html>
