<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ page import="com.jeefuse.base.utils.uuid.UUIDGenerator" %>
<%@ page import="com.jeefuse.system.session.UserSessionHolder" %>
<%@ page import="com.jeefuse.system.session.SessionConstantKey" %>
<%
String clientCode = UUIDGenerator.generate();
UserSessionHolder.setSessionAttr(request, SessionConstantKey.CLIENT_CODE, clientCode);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>系统登录</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|button', ctx, theme);
	importJsFile('jquery|common|ui|validate|encrypt', ctx);
	importJsFile('/resources/content/system/login.js', ctx);	
</script>
<style type="text/css">
	html{background: url("${ctx}/resources/style/default/images/login/desk.jpg");}
	#loginBox{margin:135px auto auto auto;width: 480px;height:280px; background: url("${ctx}/resources/style/default/images/login/login.png");}
	#systemBanner{margin: 0 auto;padding-top: 15px;text-align: center;color:#15428B;font-size:28px;font-weight:bold;}
	#loginForm{padding-top: 5px;}
	#loginForm td.label{text-align: right;}
</style>
</head>
<body>
	<div id="loginBox">
		<div id="systemBanner">
			jeefuse 快速开发平台
		</div>
		<form id="loginForm" action="${ctx}/goolov_security_check" method="post" class="v-form">
				<table>
					<tr>
						<td colspan="1" width="35%"></td>
						<td colspan="1">
						        <%if ("true".equals(request.getParameter("error"))) {%>
									<span class="error"> 用户名或密码错误,请重试.</span>
					   	       	 <%}if ("1".equals(request.getParameter("error"))) {%>
									<span class="error"> 用户名或密码错误,请重试.</span>
								<%}if ("2".equals(request.getParameter("error"))) {%>
									<span class="error"> 验证码错误,请重试.</span>
								<%}if ("3".equals(request.getParameter("error"))) {%>
									<span class="error"> 此帐号已从别处登录.</span>
								<%}%>
								<s:actionerror theme="simple"/>
						</td>
					</tr>
					<tr>
						<td class="label">
							<label>用户名:</label>
						</td>
						<td class="field">
							<input type='text' id='j_username' name='j_username' class="text required" tabindex="1" clien="<%=clientCode%>"
							<%
								String lastUserName=(String)session.getAttribute("SPRING_SECURITY_LAST_USERNAME");
								if(null!=lastUserName&&!"".equals(lastUserName)){
							%>
								 value='<%=lastUserName%>'
							<% }%>
							 />
						</td>
					</tr>
					<tr>
						<td class="label">
							<label>密码:</label>
						</td>
						<td class="field">
							<input type='password' id='j_password' name='j_password' class="text required" tabindex="2"/>
						</td>
					</tr>
					<tr>
						<td class="label">
							<label>验证码:</label>
						</td>
						<td class="field">
							<input  type="text" name="j_captcha"  class="text code" size="5" tabindex="3" />&nbsp;
							<img id="codeImg" title="点击更换" src="${ctx}/security/jcaptcha" alt="" align="middle" width="100" height="30" onclick="javascript:refreshCode(this);"/>
						</td>
					</tr>
					<tr>
						<td class="label"></td>
						<td class="field">					
							<input type="checkbox" name="_spring_security_remember_me" class="chk" tabindex="4" id="_spring_security_remember_me"/>
							<label for="_spring_security_remember_me" class="text" >两周内记住我</label>
						</td>
					</tr>
					<tr>
						<td></td>
						<td  align="left">
							<input type="submit" class="button-primary"  tabindex="5" onclick="submiLogin();return false"  value="登  &nbsp; 录"/> 
							(用户名：admin,密码：admin)
						</td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>

