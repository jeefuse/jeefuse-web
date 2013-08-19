<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>主页-jeefuse快速开发平台</title>
<%@ include file="/common/meta.jsp"%>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui', ctx, theme);
	importJsFile('jquery|common|ui|blockUI', ctx);
</script>
</head>
<body  class="v-container">
	   <!-- 内容区域START --> 
		<div style="padding:20px;">
		   <h1>欢迎您使用jeefuse快速开发平台</h1>
		   <div id="lastLoginTime" class="v-item">
		   	 <span class="label">本次登录时间</span>
		   	 <span class="text">${loginUser.lastLoginTimeToStr}</span>
		   </div>
		</div>
		<!-- 内容区域END -->
</body>
</html>
