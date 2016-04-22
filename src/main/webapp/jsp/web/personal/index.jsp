<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/web/login/global.css">
<title>个人主页！</title>
</head>
<body class="body_color">
	<!--状态栏 begin-->
<div class="wrap100 wap_header"></div>
    <!--状态栏 over-->

    <!--导航 begin-->
    <div class="wrap100 topNav">
        <ul>
            <li class="bg1"><a href="${ctx }/faWap/myFlow!index.action"><i class="house-icon"></i>首页</a></li>
            <li><img src="${ctx }/jsp/faWap/images/jt1.jpg" height="60" /> </li>
            <li class="bg2"><a href="${ctx}/faWap/personalCenter!account.action">我的账户</a> </li>
            <li><img src="${ctx }/jsp/faWap/images/jt2_2.png" height="60" /> </li>
        </ul>
    </div>
    <!--导航 end-->

    <div class="m-t-110"></div>

    <!--我的账户 begin-->

    <div class="wrap100 mar10 fl mus_skt">
    	<div class="wrap100 fl">
    		<div style=" text-align:center;">
    			<p style="font-size:28px;margin-top:0px;color:#ffffff;">个人中心</p>
    		</div>
    	
        	<div class="mus_tou" onclick="window.location.href='${ctx}/faWap/personalCenter!personInfo.action'" style="margin-left:100px;width: 90px;float:left;">
               	<img class="ger_tou" src="${session.userPhotoImg}" style="border:0px;background:none;width: 116px;height: 120px;margin-bottom: 17px;" >
        	</div>
        	<div style="margin-left:25px;float:left;color:#ffffff;">
        		<p style="font-size:24px;margin-top:8px;">${loginName }</p>
        		<p style="font-size:24px;margin-top:8px;">账户总流量</p>
                <p class="mus_zllp01" style="font-size:24px;">${count}MB</p>
        	</div>
        	<br/><br/><br/><br/><br/><br/><br/><br/>
        	<div>
        		<a href="javascript:showFlowDetails()" style="cursor: pointer;color: #ffffff;font-size:20px;text-decoration: underline;float:right;margin-right:40px;">查看流量明细</a>
        	</div>
        </div>
    </div>
    
    <div class="wrap100 fl mar30">
    	<div class="mus_cai">
        	<ul>
            	<li>
                	<a href="${ctx}/faWap/personalCenter!flowDetails.action?flowType=">
                        <img src="${ctx}/jsp/faWap/images/mus_cai_icon01.png">
                        <span class="fl">交易明细</span>
                        <i></i>
                    </a>
                </li>
                <li>
                	<a href="${ctx}/faWap/personalCenter!myOrderInit.action?orderStatus="+''>
                        <img src="${ctx}/jsp/faWap/images/mus_cai_icon02.png">
                        <span class="fl">我的订单</span>
                        <i></i>
                    </a>
                </li>
                <li>
                	<a href="${ctx}/faWap/personalCenter!realName.action">
                        <img src="${ctx}/jsp/faWap/images/mus_cai_icon03.png">
                        <span class="fl">实名认证</span>
                        <i></i>
                        <s:if test='%{realnameFlag=="1"}'>
                        	<span class="fr">已认证</span>
                        </s:if>
						<s:else>
							<span class="fr">未认证</span>
						</s:else>
                    </a>
                </li>
                <li>
                	<a href="${ctx}/faWap/personalCenter!bandingPhone.action">
                        <img src="${ctx}/jsp/faWap/images/mus_cai_icon04.png">
                        <span class="fl">手机绑定</span>
                        <i></i>
                        
                        <s:if test='%{bindSvcnumFlag=="1"}'>
                        		<span class="fr">${serviceNum }</span>
	                    </s:if>
	                    <s:else>
	                        	<span class="fr">未绑定手机</span>
	                    </s:else>
                    </a>
                </li>
                <li>
                	<a href="${ctx}/faWap/personalCenter!bandingEmail.action">
                        <img src="${ctx}/jsp/faWap/images/mus_cai_icon05.png">
                        <span class="fl">邮箱绑定</span>
                        <i></i>
                        <s:if test='%{bindEmailFlag=="1"}'>
                        	<span class="fr">${email}</span>
                        </s:if>
                        <s:else>
                        	<span class="fr">未绑定邮箱</span>
                        </s:else>
                    </a>
                </li>
                <li>
                	<a href="${ctx}/faWap/personalCenter!loginpwd.action">
                        <img src="${ctx}/jsp/faWap/images/mus_cai_icon06.png">
                        <span class="fl">登录密码管理</span>
                        <i></i>
                    </a>
                </li>
                <li>
                	<a href="${ctx}/faWap/personalCenter!problem.action?scrollIndex=0&&roundIndex=1">
                        <img src="${ctx}/jsp/faWap/images/mus_cai_icon07.png">
                        <span class="fl">常见问题</span>
                        <i></i>
                    </a>
                </li>
                <li>
                	<a href="${ctx}/faWap/personalCenter!feedback.action">
                        <img src="${ctx}/jsp/faWap/images/mus_cai_icon08.png">
                        <span class="fl">意见反馈</span>
                        <i></i>
                    </a>
                </li>
                <li>
                	<a href="javascript:deleteAccount()">
                        <img src="${ctx}/jsp/faWap/images/mus_cai_icon09.png">
                        <span class="fl">删除账号</span>
                        <i></i>
                    </a>
                </li>
            </ul>
            <div class="clear"></div>
        </div>
    </div>
    
    <div class="down_button">
    	<button onclick="window.location.href='${ctx}/faWap/personalCenter!loginOut.action'">退出登录</button>
    </div>

<div class="delf-wrap" id="flowDetail" style="display: none;width:88%;">
	<div class="del_wkb_top"></div>
	<br/><br/><br/><br/>
	<div style="padding: 25px;font-size:24px;">
		<s:iterator value="rspFA10008.flowBook" id="flowBookList">
    		<ul style="line-height: 35px;margin-bottom: 10px;color:#000000;">
           		<li>
           			<s:property value="#flowBookList.resTypeName" />
           			<a style="color:blue;"><s:property value="#flowBookList.resNum" /></a>
           			<s:property value="#flowBookList.resUnit" />
           		</li>
       		</ul>
    	</s:iterator>
   	</div>  
    <div class="ui-form">
        <div class="btn-wrap" style="margin-top:10px;padding:15px;">
            <button id="btnAdd" class="btn btn-orange" onclick="hideFlowDetails()">确认</button>
        </div>
    </div>
</div>


<!-- 删除账户 start-->
<div class="delf-wrap" id="deleteAccount" style="display: none;width:88%;">
	<div class="del_wkb_top">登录密码</div>
	<br/><br/><br/><br/>
	<div style="margin-top:10px;padding:15px;"><input id="password" type="password" placeholder="请输入登录密码" style="width:100%;height: 60px;border-radius:8px;text-align:center;font-size: 1.5rem;color:#000000;" /></div>
    <div class="ui-form">
        <div class="btn-wrap" style="margin-top:10px;padding:15px;">
            <button id="btnAdd" class="btn btn-orange" onclick="verifyPassword()" style="cursor: pointer;">确定</button>
        </div>
    </div>
    <div style="font-size: 20px;text-align: center;color:#6E6E6E;">只有实名认证并且账户资源为空（免费和有价资源都空）的账号才可以注销。</div>
</div>
<!-- 删除账户over-->

<!-- 选择删除方式 start-->
<div class="delf-wrap" id="chooseDeleteType" style="display: none;width:88%;">
    <div class="ui-form">
        <div class="btn-wrap" style="margin-top:10px;padding:15px;">
            <button id="btnAdd" class="btn btn-orange" onclick="phoneDeleteAccount()" style="cursor:pointer;">通过手机删除账号</button>
            <button id="btnAdd" class="btn btn-orange" onclick="emailDeleteAccount()" style="margin-top:35px;cursor:pointer;">通过邮箱删除账号</button>
        </div>
    </div>
</div>
<!-- 选择删除方式 over-->

<!-- 通过手机删除账号 start-->
<div class="delf-wrap" id="phoneDeleteAccount" style="display: none;width:88%;">
	<div class="del_wkb_top"></div>
	<div style="text-align: center;margin-top: 80px;font-size: 23px;">当前绑定手机为：${serviceNum }</div>
	<div style="text-align: center;margin-top: 20px;">
		<input id="mobileCode" type="text" placeholder="请输入验证码" style="height:45px; border-radius:8px;width:50%;font-size:24px;padding-left: 10px;" />
    	&nbsp&nbsp<a id="a_getMobileCode" href="javascript:getMobileCode('a_getMobileCode');" class="phone_back" style="width:70%;height: 45px;margin-top: 0px;font-size: 26px;text-decoration:underline;color: #646464;">发送验证码</a>
	</div>
    <div class="ui-form">
        <div class="btn-wrap" style="margin-top:10px;padding:15px;">
            <button id="btnAdd" class="btn btn-orange" onclick="phoneConfirmDelete()" style="margin-top:15px;cursor:pointer;height: 60px;">确认删除</button>
        </div>
    </div>
</div>
<!-- 通过手机删除账号 over-->

<!-- 通过邮箱删除账号 start-->
<div class="delf-wrap" id="emailDeleteAccount" style="display: none;width:88%;">
	<div class="del_wkb_top"></div>
	<div style="text-align: center;margin-top: 80px;font-size: 23px;">当前绑定邮箱为：${email }</div>
	<div style="text-align: center;margin-top: 20px;">
		<input id="emailCode" type="text" placeholder="请输入验证码" style="height:45px; border-radius:8px;width:50%;font-size:24px;padding-left: 10px;" />
    	&nbsp&nbsp<a id="a_getEmailCode" href="javascript:getEmailValidCode(2,'a_getEmailCode');" class="phone_back" style="width:70%;height: 45px;font-size: 26px;text-decoration:underline;color: #646464;">发送验证码</a>
	</div>
    <div class="ui-form">
        <div class="btn-wrap" style="margin-top:10px;padding:15px;">
            <button id="btnAdd" class="btn btn-orange" onclick="emailConfirmDelete(2)" style="margin-top:15px;cursor:pointer;height: 60px;">确认删除</button>
        </div>
    </div>
</div>
<!-- 通过邮箱删除账号 over-->

    <!--底部版权 begin-->
    <jsp:include page="../bottom.jsp" flush="true"/>
    <!--底部版权 over-->
    <!--我的账户 over-->
<script>
       adaptUILayout.adapt(480); //适配当前页面
</script>
</body>
</html>