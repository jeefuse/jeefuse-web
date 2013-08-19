
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户身份认证 Input</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui', ctx, theme);
	importJsFile('jquery|ui|common|blockUI|form|validate', ctx);
	importJsFile('/resources/content/system/security/gsysUserCertify/gsysUserCertify-input.js', ctx);
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
		      				<label>申请人姓名:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="applicantName" name="applicantName" value="${mo.applicantName}" class="text" />
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>申请人身份证号码:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="applicantNumber" name="applicantNumber" value="${mo.applicantNumber}" class="text" />
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>申请人联系电话:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="applicantTel" name="applicantTel" value="${mo.applicantTel}" class="text" />
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>申请人身份证正面:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="idcartPhoto" name="idcartPhoto" value="${mo.idcartPhoto}" class="title" />							
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>申请人身份证正面照片保存地址:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="idcartSavePath" name="idcartSavePath" value="${mo.idcartSavePath}" class="title" />							
		      			</td>
					</tr>						
					<tr>																
		      			<td class="label">
		      				<label>GsysUsernull:</label>
		      			</td>
						<td class="field" colspan="1">
							 <input type="hidden" id="gsysUser_id" name="gsysUser.id" value="${mo.gsysUser.id}"/>
							 <input type="text" id="gsysUser_null" name="gsysUser.null" value="${mo.gsysUser.null}"  class="text select" onclick="relGsysUserListForSelect();"/>
							 <img class="clear" id="gsysUser_null_clear" src="${ctx}/resources/style/default/tree/images/s.gif" alt="清空" onclick="javascript:relGlDiningSiteListForSelectClear();" align="middle"/>				
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
