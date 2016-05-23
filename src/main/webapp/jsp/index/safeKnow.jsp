<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
<script src="/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	function showThings() {
		$("#things").show();
	}
	function showAdvise() {
		$("#advise").show();
	}
</script>
<style type="text/css">
a {
	display: block;
	margin-left: 50px;
	margin-bottom: 20px;
	margin-left: 50px;
}

span {
	margin-top: 20px;
	margin-bottom: 20px;
	display: block;
	display: none;
	font-size: 20px;
	color: black;
}

h1 {
	color: black;
	margin-bottom: 20px;
	text-align: center;
}
</style>
<title>安全天地</title>
</head>
<body>
	<h1>安全知识</h1>
	<a href="javascript:showThings();" class="button blue medium">账号泄露案例</a>
	</br>
	<span id="things">● 电子商务网站信息外漏
		2012年1月，亚马逊旗下美国电子商务网站Zappos遭到黑客网络攻击，2400万用户的电子邮件和密码等信息被窃取。同年7月，雅虎、Linkedin和安卓论坛累计超过800万用户信息泄密，而且让人堪忧的是，部分网站的密码和用户名称是以未加密的方式储存在纯文字档案内，意味着所有人都可使用这些信息。

		● 银行、保险公司用户信息外泄
		2012年3月，央视3.15晚会曝光招商银行(600036,股吧)、中国工商银行(601398,股吧)、中国农业银行(601288,股吧)员工以一份十元到几十元的价格大肆兜售个人征信报告、银行卡信息，导致部分用户银行卡账号被盗。
		同年8月，银行外包后台成泄密重灾区，江苏银行个月卖千份客户资料，上海数十万条新生儿信息遭倒卖，出自市卫生局数据库外包维护工作人员。2013年
		2月，中国人寿(601628,股吧)80万份保单信息可上网任意查询，包括险种、手机号、身份证号和密码一应俱全。 ●
		12306新版上线即曝漏洞
		2012年12月，为配合新一轮的春运工作，新版中国铁路客户服务中心12306网站正式上线试运行。上线第一天，擅长“挑刺”的IT高手们就发现12306新版网站存在漏洞。漏洞发现者指出，12306网站漏洞泄露用户信息，可查询登录名、邮箱、姓名、身份证号码以及电话号码等隐私信息。另一个漏洞的发现者也曝出“新版12306网站存在多个订票逻辑漏洞”，该漏洞可能导致后期订票软件泛滥，造成订票不公。铁路总公司对此回应，“上线当晚漏洞已经弥补”，但12306的安全性也由此被人们打上问号。

		● 支付宝、腾讯QQ用户数据泄漏
		2013年3月，支付宝转账信息被谷歌抓取，直接搜索“site:shenghuo.alipay.com”就能搜到转账信息，数量超过2000条。2013年11月，国内知名漏洞网站乌云网曝光称，腾讯QQ群关系数据被泄露，在迅雷上很容易就能找到数据下载链接。据测试，该数据包括QQ号、用户备注的真实姓名、年龄、社交关系网甚至从业经历等大量个人隐私。数据库解压后超过90G，有7000多万个QQ群信息，12亿多个部分重复的QQ号码。随后腾讯公司回应称，此次QQ群泄露的只是2011年之前的数据，黑客攻击的漏洞也已经修复。不过这么大规模数据在网上公开，由此引发的后遗症很难消除。</span>
	</br>
	<a href="javascript:showAdvise();" class="button gray medium">密码设置建议</a></br>
	<span id="advise">密码设置技巧：先设置基础密码，然后用统一规则叠加组合成不同强密码
		首先选取一个基础密码，然后根据不同的应用场合，再按照自己设置的简单规则叠加组合一些其他元素。
		基础密码+网站名称的前两辅音字母+网站名称的前两个元音字母：比如基础密码是“yesky”，那么要登录Yahoo时密码就是yeskyYHAO，登陆eBay时就是yeskyBYEA。
		自己喜欢的单词＋喜欢的数字排列＋网站名称的前三个字母或者后三个字母。这样，淘宝（Taobao)登录密码可以是Flower100TAO或者是Gold520Bao。
		选定基础密码之后，键入时将手指在键盘上向某一个方向偏移一些位置。比如基础密码是“cat“，我们输入时将手指向左上方偏移一个键位，就变成了”dq5“。
		注意：好的密码长度应该超过8个字符，同时包含大写字母、小写字母、数字以及特殊字符。 下面提供一些选择基础密码的小技巧供大家参考：
		某句短语或是某首歌曲副歌的首字母。比如你很喜欢The Jackson 5的那首成名曲 I Want You
		Back，就可以用“IWUB”。或者PPtt13Mod，DKstFre1st对应的“娉娉婷婷十三余，豆蔻梢头二月初”。用键盘上比较靠近的按键组合，比如说“yui”或是“zxcv”。用自己家人或者朋友名字的首字母以及特殊的纪念日，比如“TFB0602”。
		其他密码设置怪招
		胡乱敲击键盘：对于敏感账户，有专家建议随机乱敲键盘，并间或敲击Shift键，然后将结果复制到一个文本，存入一个有密码保护的U盘。
		安全问题答非所问：网站的验证问题经常问道“你最喜欢什么食物？”“你毕业于什么学校？”，这些问题的答案局限性太大，很容易搜索出答案。比较安全的做法是密码提示和问题无关。比如安全问题是“你喜欢什么歌曲？”，你的回答可以是你宠物店名字等等。
		密码生成器：如果还是不想自己设置，网络上有很多在线密码生成器，可以根据一些算法，根据基础密码和网站地址来生成不同的密码。本项目提供了各种随机性的密码生成方法，而且项目生成的密码会排除不安全的密码。非常欢迎用户使用本系统的密码生成算法。
		现在很多网站也设置了双重认证等机制，增加额外密码安全保护，并且要求验证两个独立的方式，通常情况下是密码和短信验证码的组合。结合上面介绍的一些方法和技巧，希望大家的“密码生活”更加轻松安全。
	</span>

</body>
<link rel="stylesheet" type="text/css" href="/css/button/page.css" />
<link rel="stylesheet" type="text/css" href="/css/button/buttons.css" />
</html>