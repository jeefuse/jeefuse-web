<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="com.jeefuse.system.security.service.spring.SecurityHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>jeefuse快速开发平台</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui|treeview', ctx, theme);
	importJsFile('jquery|common|ui|blockUI|treeview', ctx);
	importJsFile('/resources/content/system/main.js', ctx);
</script>
</head>
<body class="easyui-layout v-container ">
		<div id="banner" region="north" border="false">
			<div id="logo">
				<a target="_top" class="logo" href="#" title="jeefuse快速开发平台">
					<img src="${ctx}/resources/style/base/images/jeefuse_logo.png" width="160" height="56"/>
				</a>
			</div>
			<div id="sysInfo">
				<div id="helper">
					<ul	class="nav">
						<li><a href="${ctx}/goolov_security_logout" title="点击安全退出系统">安全退出</a></li>
						<li><a href="#">设置</a></li>
						<li><a href="#">建议反馈</a></li>
						<li><a href="#">帮助</a></li>
					</ul>
					<br class="clear"/>
				</div>
				<div id="welcome">
					<span id="greeting"></span>
					<span class="greetingName"><%=SecurityHolder.getLoginUserName()%></span>
					<span id="dailyTime" style="width: 200px;">
						<script>
							dailyTimeCall();
		                    setInterval("dailyTimeCall();",1000);
	                    </script>
                    </span>
				</div>
			</div>
		</div>	
		
		<div id="category" region="west" split="true" title="导航菜单" style="width:210px;padding:1px;">
					<div id="sysMenuTree" class="v-tree" ></div>
		</div>
		
		<div id="center" region="center" border="false">
			<div id="mainTabs"  class="easyui-tabs" fit="true" border="false">
				<div title="主页">
					<!-- 内容区域START --> 
					<div style="padding:20px;">
					   <h1>欢迎您使用jeefuse快速开发平台</h1>
					   <div id="lastLoginTime" class="v-item">
					   	 <span class="label">本次登录时间</span>
					   	 <span class="text">${loginUser.lastLoginTimeToStr}</span>
					   </div>
					</div>
					<!-- 内容区域END -->
				</div>
			</div>
		</div>
</body>
</html>
