
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登入日志 Input</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui', ctx, theme);
	importJsFile('jquery|blockUI|ui|common|form|validate', ctx);
	importJsFile('/resources/content/system/log/gsysLoginlog/gsysLoginlog-input.js', ctx);
</script>
</head>
<body class="easyui-layout v-container">
 	<div region="center" border="false"><!-- center start -->
 			<form id="inputForm" method="post" class="v-form">
 				<input type="hidden" name="id" value="${mo.id}"/>
 				<!--<div id="inputInfo" class="v-state-info"></div>-->
		      	<table>
					<tr>	
		      			<td class="label">
		      				<label>登录IP:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="loginIp" name="loginIp" value="${mo.loginIp}" class="text" />
		      			</td>
					</tr>						
					<tr>			
		      			<td class="label">
		      				<label>登录时间:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      					${mo.createdateToStr}	
		      			</td>
					</tr>						
					<tr>			
		      			<td class="label">
		      				<label>信息:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<textarea id="message" name="message"  class="textarea" >${mo.message}</textarea>	
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>登入用户:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="userId" name="userId" value="${mo.userId}" class="text" />
		      			</td>
					</tr>							
				</table>
			  </form>
		</div><!-- center end -->
		<div region="south" border="false" style="height:50px;"><!-- south start-->
			<div class="v-buttons"><!-- v-buttons start -->
		  	 	<c:choose>
			  		<c:when test="${null==model.id}">
			   			<a href="javascript:newWinSaveData();" class="easyui-linkbutton">新增</a>
			   			<a href="javascript:resetData();" class="easyui-linkbutton" >重置</a>
			   			<a href="javascript:newWinClose();" class="easyui-linkbutton" >关闭</a>
			   			<a href="javascript:newWinCloseAndRefresh();" class="easyui-linkbutton" >关闭并刷新</a>
			 		</c:when>
			   		<c:otherwise>
		   				<a href="javascript:editWinUpdateData();" class="easyui-linkbutton" >更新</a>
						<a href="javascript:resetData();" class="easyui-linkbutton" >重置</a>
						<a href="javascript:editWinClose();" class="easyui-linkbutton" >关闭</a>
						<a href="javascript:editWinCloseAndRefresh();" class="easyui-linkbutton" >关闭并刷新</a>
					</c:otherwise>
			   </c:choose> 
			</div><!-- v-buttons end-->
		</div><!--	south end -->
</body>
</html>
