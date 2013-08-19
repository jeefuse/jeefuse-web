<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GsysUser Input</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui', ctx, theme);
	importJsFile('jquery|blockUI|ui|common|form|validate|encrypt', ctx);
	importJsFile('/resources/content/system/security/gsysUser/gsysUser-modifyMyPassword.js', ctx);
</script>
</head>
<body class="easyui-layout">
 	<div id="first-box" class="v-box" region="center" border="false">
 		<div class="v-form">
 			<form id="inputForm" method="post">
		      	<table>
					<tr>	
		      			<td class="label">
		      				<label>用户名:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				${mo.username}
		      			</td>	
					</tr>						
						<tr>	
			      			<td class="label">
			      				<label>新密码:</label>
			      			</td>
			      			<td class="field" colspan="1">
			      				<input type="hidden" name="password" id="password" maxlength="32" class="text" />
			      				<input type="password" name="inpass" id="inpass" maxlength="32" class="text" />
			      			</td>
						</tr>
						<tr>
			      			<td class="label">
			      				<label>确认密码:</label>
			      			</td>
			      			<td class="field" colspan="1">
			      				<input type="password" name="inpassConfirm" id="inpassConfirm" maxlength="32" class="text" onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>
			      			</td>									
						
						
						</tr>						
				</table>
			</form>
			<div class="v-buttons">
			   		<div class="v-buttons">
						<a class=" l-btn" href="javascript:saveData();">
							<span class="l-btn-left"><span class="l-btn-text">保存</span></span>
						</a>
						<a class=" l-btn" href="javascript:resetData();">
							<span class="l-btn-left"><span class="l-btn-text">重置</span></span>
						</a>
						<a class=" l-btn" href="javascript:closeEditWin();">
							<span class="l-btn-left"><span class="l-btn-text">关闭</span></span>
						</a>
					 </div>
			</div>
		</div>
	</div>
</body>
</html>