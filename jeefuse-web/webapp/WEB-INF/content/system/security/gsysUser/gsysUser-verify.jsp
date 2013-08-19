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
	var EnabledJson=<%=com.jeefuse.system.code.model.enumeration.EnabledType.toHtmlJSON%>;
	var SexJson=<%=com.jeefuse.system.code.model.enumeration.SexType.toHtmlJSON%>;
	importCssFile('sys|ui|flexiGrid|contextmenu', ctx, theme);
	importJsFile('jquery|blockUI|common|ui|flexiGrid|contextmenu|validate', ctx);
	importJsFile('/resources/content/system/security/gsysUser/gsysUser-verify.js', ctx);
</script>

</head>
<body>
	<div id="header" region="north" split="false" border="false"  class="v-header"><!-- header start -->
		<div id="first-title" class="v-title">
		</div>
		
		<div id="first-toolbar" class="v-toolbar">
			<div class="v-menu">
				<a href="javascript:verifyData()" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-form-edit">身份认证审核</span></span>
				</a>
			</div>
		</div>
		
		<div id="first-search" class="v-search"><!-- first-search -->
		   <form id="firstSearchForm">
				<table>
					<tr>
		      			<td class="label">
		      				<label>用户名:</label>
		      			</td>
		      			<td class="field">
		      				<input type="text" id="username" name="username" value="${model.username}"  />
		      			</td>
		      			<td class="label">
		      				<label>审核状态:</label>
		      			</td>
		      			<td class="field">
		      				 <select name="idcardAuthen" id="idcardAuthen" onchange="firstSearch();">
							     <option value="" >未选择</option>
							     <s:property value="idcardAuthenTypeHtmlSelect" escape="false"/>
							 </select>
		      			</td>
						<td>
							<div class="v-buttons">
								<a class=" l-btn" href="javascript:firstSearch();">
									<span class="l-btn-left"><span class="l-btn-text">查 询</span></span>
								</a>
							</div>
						</td>
						<td colspan="1">
						</td>
					</tr>
				</table>
			</form>
		</div><!-- first-search End-->
		
	</div><!-- header End -->

	<div id="center" region="center"  border="true"><!-- center start -->	
   		<div id="first-content" class="v-content">
			<div id="dataGrid"  style="display:none;"></div>
		</div>
	</div><!-- center end -->			
		
</body>
</html>