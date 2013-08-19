<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GsysFunction管理</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	var FunctionTypeJson=${FunctionTypeJson};
	var InvalidTypeJson=${InvalidTypeJson};
	importCssFile('sys|ui|flexiGrid|treeview|contextmenu', ctx, theme);
	importJsFile('jquery|common|blockUI|ui|treeview|flexiGrid|contextmenu',ctx);
	importJsFile('/resources/content/system/security/gsysFunction/gsysFunction-manager.js', ctx);
</script>

</head>
<body  id="container" class="v-container">
    <div id="header" region="north" split="false" border="false"  class="v-header"><!-- header start -->
    		<div id="firstTitle" class="v-title"></div>

			<div id="firstToolbar" class="v-toolbar"><!-- toolbar start -->
				<div class="v-menu">
					<a href="javascript:newData();" class=" l-btn l-btn-plain" >
						<span class="l-btn-left"><span  class="l-btn-text icon-add">新增</span></span>
					</a>
					<a href="javascript:editData()" class=" l-btn l-btn-plain" >
						<span class="l-btn-left"><span  class="l-btn-text icon-reload">编辑</span></span>
					</a>
					<a href="javascript:delData();" class=" l-btn l-btn-plain" >
						<span class="l-btn-left"><span  class="l-btn-text icon-remove">删除</span></span>
					</a>
					<a href="javascript:delDescendantData();" class=" l-btn l-btn-plain" >
						<span class="l-btn-left"><span  class="l-btn-text icon-remove">删除及其子节点</span></span>
					</a>
					<a href="javascript:delAllData();" class=" l-btn l-btn-plain" >
						<span class="l-btn-left"><span  class="l-btn-text icon-remove">删除所有</span></span>
					</a>
					<a href="javascript:refresh()" class=" l-btn l-btn-plain" >
						<span class="l-btn-left"><span  class="l-btn-text icon-reload">刷新</span></span>
					</a>
					<a href="javascript:clear()" class=" l-btn l-btn-plain" >
						<span class="l-btn-left"><span  class="l-btn-text icon-redo">重置</span></span>
					</a>
					<a href="javascript:exportExcel();" class=" l-btn l-btn-plain" >
						<span class="l-btn-left"><span  class="l-btn-text icon-excel">导出EXCEL</span></span>
					</a>
					<a href="javascript:importExcel();" class=" l-btn l-btn-plain" >
						<span class="l-btn-left"><span  class="l-btn-text icon-excel-imp">导入EXCEL</span></span>
					</a>
				</div>
			</div><!-- toolbar end -->
			
			<div id="firstSearch" class="v-search"><!-- first-search -->
				<form id="firstSearchForm">
					<input type="hidden" id="parentId" name="parentId" />
					<table>
						<tr>
			      			<td class="label">
			      				<label>权限标志:</label>
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
			 </div><!-- first-search end-->
     </div><!-- header end -->
     	
    <div id="category" region="west"  border="true" class="v-category"><!-- cate start -->
<!--    		<div class="v-title v-title-panel">权限树</div>-->
    		<div id="firstTree" class="v-tree" ></div>
    </div><!-- cate end -->
    
    <div id="center" region="center"  border="true"><!-- center start -->
    		<div id="firstContent" >
				<div id="dataGrid"  style="display:none;"></div>
			</div>
	</div><!-- center end -->
</body>
</html>