<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="com.jeefuse.system.security.service.spring.SecurityHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui|superfish', ctx, theme);
	importJsFile('jquery|common|ui|blockUI|superfish', ctx);
	importFile('/resources/content/system/main-topMenu.js', ctx);
</script>
<style>
body {
	overflow: hidden;
}
#main {
	margin: 0px auto;
	height:100%;
	width: 100%;
}
#header{}
#banner .v-title{}
</style>
</head>
<body id="container">
	<div region="center" border="false">
		<div id="main">
			<div id="header" region="north" border="false">
				<div id="banner">
					<div id="logo">
						<a target="_top" class="logo" href="#" title="jeefuse快速开发平台">
							<img src="${ctx}/resources/style/base/images/jeefuse_logo.png" width="160" height="56"/>
						</a>
					</div>

					<div id="sysInfo">
						<div id="helper">
							<ul	class="nav">
								<li><a href="${ctx}/goolov_security_logout">安全退出</a></li>
								<li><a href="#">设置</a></li>
								<li><a href="#">建议反馈</a></li>
								<li><a href="#">帮助</a></li>
							</ul>
							<br class="clear"/>
						</div>
						<div id="welcome">
							<span id="greeting"></span><span class="greetingName"><%=SecurityHolder.getLoginUserName()%></span>
							<span id="dailyTime" style="width: 200px;">
								<script>
									dailyTimeCall();
				                    setInterval("dailyTimeCall();",1000);
			                    </script>
		                    </span>
						</div>
					</div>
				</div>
				
				<div id="topMenu" class="v-menuNav">
					<ul class="sf-menu">${systemMenuUIHrefMethod}</ul>
					<div class="clear"></div>
				</div>
				
				<div id="navigate" class="v-navigate">
					<span class="caption">当前位置:</span>
					<span id="locate" class="locate">
						<a href="javascript:void(0)" onclick="refreshIndex()">首页</a>
					</span>				
					<span id="subLocate"></span>
				</div>
			</div>
			
			
			<div id="content"  class="content">
				 <iframe id="contentFrame" frameborder="0"  src=""  height="100%" width="100%" marginwidth="0" marginheight="0" scrolling="auto"></iframe>
			</div>
			
		</div>
	</div>
</body>
</html>
