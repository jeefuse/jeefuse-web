<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GsysUser管理</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	//code kind define
	importCssFile('site|ui', ctx, theme);
	importJsFile('jquery|blockUI|common|ui', ctx);
	importJsFile('/resources/content/system/security/gsysUser/gsysUser-identityAudit.js', ctx);
</script>
<style type="text/css">
html:{overflow: auto;}
body {overflow: auto;}
</style>
</head>
<body>
			<div id="contentWrap" style="width: 600px;margin: 20px auto">
			 	<form id="inputForm" action="#" method="post" class="v-form">
			 	<input type="hidden" name="userId" value="${model.id}" id="userId"/>
		      	<table class="v-table">
					<tr>	
		      			<td class="label" width="30%">
		      				<label>申请人姓名:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				${gsysUserCertify.applicantName}
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>申请人身份证号码:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				${gsysUserCertify.applicantNumber}
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>申请人联系电话:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				${gsysUserCertify.applicantTel}
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>申请人身份证正面:</label>
		      			</td>
		      			<td class="field" colspan="1">
			 	         	  <div class="imageWrap">
			                	<!-- uploaded image -->
								<div id="idcartPhoto_image_uploaded" class="imagePreview">
						        	 <img src="${gsysUserCertify.idcartPhotoUrl}"  width="350px" height="250px" /><br/>
			   					</div>
								<div class="tip">申请人身份证正面照片预览</div>
	   						</div>
		      			</td>
					</tr>
					
					<tr>	
		      			<td class="label">
		      				<label>审核:</label>
		      			</td>
		      			<td class="field" colspan="1">
	      					<select name="idcardAuthen" id="idcardAuthen">
		      					<option value="C" ${"C"==idcardAuthen?"selected='selected'":""} >不通过</option>
		      					<option value="Y" ${"Y"==idcardAuthen?"selected='selected'":""}>通过</option>
		      				</select>
		      			</td>			      			
					</tr>
					
					<tr id="idcartAuditNoPassReason">	
		      			<td class="label">
		      				<label>原因:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<textarea rows="3" cols="50" name="auditReason" id="auditReason">${gsysUserCertify.auditReason}</textarea>
		      				<div class="tip">审核不通过必需填写.</div>
		      			</td>
					</tr>
					<tr>	
		      			<td class="label">
		      			</td>
		      			<td class="field" colspan="1">
							<div class="v-button-wrap" style="text-align: left;"><!-- v-buttons start -->
								<a href="javascript:submitData();" class="easyui-linkbutton" >提交</a>
								<a href="javascript:closeWin();" class="easyui-linkbutton" >关闭</a>
							</div><!-- v-buttons end-->		 	         	  
		      			</td>
					</tr>
				</table>
			  </form>
	 	</div><!-- contentWrap -->
</body>
</html>