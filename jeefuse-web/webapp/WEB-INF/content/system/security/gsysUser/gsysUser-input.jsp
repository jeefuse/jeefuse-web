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
	importJsFile('/resources/content/system/security/gsysUser/gsysUser-input.js', ctx);
</script>
</head>
<body class="easyui-layout">
 	<div id="first-box" class="v-box" region="center" border="false">
 		<!--<div id="inputInfo" class="v-state-info"></div>-->
 		<div class="v-form">
 			<form id="inputForm" method="post">
 				<input type="hidden" id="cid" name="id" value="${mo.id}"/>
		      	<table>
					<tr>	
		      			<td class="label">
		      				<label>用户名:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="username" name="username" value="${mo.username}" class="text" />
		      			</td>	
		      			<td class="label">
		      				<label>有效性:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<select name="enabled" id="enabled" class="text">
							     <s:property value="EnabledHtmlSelect" escape="false"/>
							 </select>
		      			</td>								
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>登录名:</label>
		      			</td>
		      			<td class="field" colspan="3">
		      				<input type="hidden" id="oldLoginName" name="oldLoginName" value="${mo.loginName}"/>
		      				<input type="text" id="loginName" name="loginName" value="${mo.loginName}" class="text" />
		      			</td>
					</tr>	
					<c:if test="${null==model.id}">
						<tr>	
			      			<td class="label">
			      				<label>登录密码:</label>
			      			</td>
			      			<td class="field" colspan="1">
			      				<input type="hidden" name="password" id="password" maxlength="32" class="text" />
			      				<input type="password" name="inpass" id="inpass" maxlength="32" class="text" />
			      			</td>
			      			<td class="label">
			      				<label>确认密码:</label>
			      			</td>
			      			<td class="field" colspan="1">
			      				<input type="password" name="inpassConfirm" id="inpassConfirm" maxlength="32" class="text" onpaste="return false" oncontextmenu="return false" oncopy="return false" oncut="return false"/>
			      			</td>									
						</tr>						
					</c:if>							
					<tr>	
		      			<td class="label">
		      				<label>性别:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				 <select name="sex" id="sex" class="text">
							     <s:property value="SexHtmlSelect" escape="false"/>
							 </select>
		      			</td>	
		      			<td class="label">
		      				<label>电话:</label>
		      			</td>
		      			<td class="field" colspan="3">
		      				<input type="text" id="telephone" name="telephone" value="${mo.telephone}" class="text" />
		      			</td>						
					</tr>
					<tr>	
		      			<td class="label">
		      				<label>Email:</label>
		      			</td>
		      			<td class="field" colspan="3">
		      				<input type="text" id="email" name="email" value="${mo.email}" class="title" />
		      			</td>							
					</tr>
					<c:if test="${null!=model.id}">
						<tr>	
			      			<td class="label">
			      				<label>创建时间:</label>
			      			</td>
			      			<td class="field" colspan="1">
			      					${mo.createTimeToStr}	
			      			</td>
			      			<td class="label">
			      				<label>更新时间:</label>
			      			</td>
			      			<td class="field" colspan="1">
			      					${mo.updateTimeToStr}	
			      			</td>									
						</tr>						
						<tr>			
			      			<td class="label">
			      				<label>最后登录时间:</label>
			      			</td>
			      			<td class="field" colspan="1">
			      					${mo.lastLoginTime}
			      			</td>
						</tr>							
					</c:if>					
					<tr>			
		      			<td class="label">
		      				<label>简介:</label>
		      			</td>
		      			<td class="field" colspan="3">
		      				<textarea id="remark" name="remark"  class="textarea" >${mo.remark}</textarea>	
		      			</td>
					</tr>						
		      		<tr>
		      			<td colspan="4">
		      				<div class="v-fieldset-wrap">
			      				<fieldset>
					              <legend>
					                 	分配角色:
					              </legend>
					              <div class="v-fieldset-content">
					                	${relGsysRoleCheckboxs}
							      </div>
					            </fieldset>
		      				</div>
		      			</td>
		      		</tr>
				</table>
			</form>
			<div class="v-buttons">
		  	 	<c:choose>
			  	 	<c:when test="${null==model.id}">
			   			<div class="v-buttons">
							<a class=" l-btn" href="javascript:saveData();">
								<span class="l-btn-left"><span class="l-btn-text">保存</span></span>
							</a>
							<a class=" l-btn" href="javascript:resetData();">
								<span class="l-btn-left"><span class="l-btn-text">重置</span></span>
							</a>
							<a class=" l-btn" href="javascript:closeNewWin();">
								<span class="l-btn-left"><span class="l-btn-text">关闭</span></span>
							</a>
							<a class=" l-btn" href="javascript:closeNewWinAndRefresh();">
								<span class="l-btn-left"><span class="l-btn-text">关闭并刷新</span></span>
							</a>
					 </div>
			 	  </c:when>
			   	<c:otherwise>
			   		<div class="v-buttons">
						<a class=" l-btn" href="javascript:saveData();">
							<span class="l-btn-left"><span class="l-btn-text">更新</span></span>
						</a>
						<a class=" l-btn" href="javascript:resetData();">
							<span class="l-btn-left"><span class="l-btn-text">重置</span></span>
						</a>
						<a class=" l-btn" href="javascript:closeEditWin();">
							<span class="l-btn-left"><span class="l-btn-text">关闭</span></span>
						</a>
						<a class=" l-btn" href="javascript:closeEditWinAndRefresh();">
							<span class="l-btn-left"><span class="l-btn-text">关闭并刷新</span></span>
						</a>
					 </div>
				   </c:otherwise>
				</c:choose> 
			</div>
		</div>
	</div>
</body>
</html>