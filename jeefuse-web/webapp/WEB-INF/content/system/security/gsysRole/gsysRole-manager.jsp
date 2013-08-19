<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GsysRole管理</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui|flexiGrid|contextmenu', ctx, theme);
	importJsFile('jquery|blockUI|common|ui|flexiGrid|contextmenu', ctx);
	importJsFile('/resources/content/system/security/gsysRole/gsysRole-manager.js', ctx);
</script>

</head>
<body id="container" class="v-container">
 	<div id="header" region="north" split="false" border="false"  class="v-header"><!-- header start -->
 	
   		<div id="first-title" class="v-title"></div>
   		
		<div id="first-toolbar" class="v-toolbar"><!-- toolbar start -->
			<div class="v-menu">
				<a href="javascript:newData();" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-add">新增</span></span>
				</a>
				<a href="javascript:editData()" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-form-edit">编辑</span></span>
				</a>
				<a href="javascript:delData();" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-remove">删除</span></span>
				</a>
				<a href="javascript:delAllData();" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-remove">删除所有</span></span>
				</a>
				<a href="javascript:refresh()" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-reload">刷新</span></span>
				</a>
				<a href="javascript:clear()" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-reset">重置</span></span>
				</a>
				<a href="javascript:exportExcel();" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-excel-exp">导出EXCEL</span></span>
				</a>
				<a href="javascript:importExcel();" class=" l-btn l-btn-plain" >
					<span class="l-btn-left"><span  class="l-btn-text icon-excel-imp">导入EXCEL</span></span>
				</a>
			</div>
		</div><!-- toolbar end -->
		
		<div id="first-search" class="v-search"><!-- first-search -->
		   <form id="firstSearchForm">
				<table>
					<tr>
		      			<td class="label">
		      				<label>名称:</label>
		      			</td>
		      			<td class="field">
		      				<input type="text" id="name" name="name" value="${mo.name}"  />
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
	</div><!-- header end -->
	
	 <div id="center" region="center"  border="true"><!-- center start -->
   		<div id="first-content" class="v-content">
			<div id="dataGrid"  style="display:none;"></div>
		</div>
	</div><!-- center end -->	
	
	<div id="new-win" icon="icon-new" title="GsysRole>新增" style="width:580px;height:300px;">
		<div id="new-win-content" style="width:100%;height:100%;">
			<iframe id="new-win-iframe" frameborder="0"  src=""  width="100%" height="100%" marginwidth="0" marginheight="0" scrolling="no"></iframe>
		</div>
	</div>

	<div id="edit-win" icon="icon-form-edit" title="GsysRole>编辑" style="width:580px;height:300px;">
		<div id="edit-win-content" style="width:100%;height:100%;">
		 	<iframe id="edit-win-iframe" frameborder="0"  src=""  width="100%" height="100%" marginwidth="0" marginheight="0" scrolling="no"></iframe>
		</div>
	</div>
</body>
</html>