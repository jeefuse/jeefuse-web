<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GsysResource管理</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	
	//code kind define
	var ResourceTypeJson=${ResourceTypeJson};
	importCssFile('sys|ui|flexiGrid|contextmenu', ctx, theme);
	importJsFile('jquery|blockUI|common|ui|flexiGrid|contextmenu', ctx);
	importJsFile('/resources/content/system/security/gsysResource/gsysResource-manager.js', ctx);
</script>

</head>
<body id="container">
 	<div id="header" region="north" split="false" border="false"  class="v-header"><!-- header start -->
			<div id="first-title" class="v-title">
			</div>
			<div id="first-toolbar" class="v-toolbar">
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
			</div>
			
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
			<div class="clear"/>
		</div><!-- header End -->
		
		<div id="center" region="center"  border="true"><!-- center start -->
	   		<div id="first-content" class="v-content">
				<div id="dataGrid"  style="display:none;"></div>
			</div>
		</div><!-- center end -->	
		
		<div id="new-win" icon="icon-new" title="GsysResource>新增" style="width:0px;height:0px" >
			<div id="new-win-content" style="width:100%;height:100%;">
				<iframe id="new-win-iframe" frameborder="0"  src="about:blank"  width="100%" height="100%" marginwidth="0" marginheight="0" scrolling="auto"></iframe>
			</div>
		</div>

		<div id="edit-win" icon="icon-edit" title="GsysResource>编辑" style="width:0px;height:0px" >
			<div id="edit-win-content" style="width:100%;height:100%;">
			 	<iframe id="edit-win-iframe" frameborder="0"  src="about:blank"  width="100%" height="100%" marginwidth="0" marginheight="0" scrolling="auto"></iframe>
			</div>
		</div>
					
		<div id="importExcelWin" icon="icon-edit" title="GsysUser>导入Excel数据" style="width:0px;height:0px" >
			<div id="importExcelWinContent" style="width:100%;height:100%;">
			 	<iframe id="importExcelWinContentIframe" frameborder="0"  src="about:blank"  width="100%" height="100%" marginwidth="0" marginheight="0" scrolling="auto"></iframe>
			</div>
		</div>
</body>
</html>