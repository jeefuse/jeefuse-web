<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GsysRole Input</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	var relGsysFunctionShowCheckJson=${relGsysFunctionShowCheckJson};
	importCssFile('sys|ui|treeview', ctx, theme);
	importJsFile('jquery|blockUI|ui|common|treeview|form|validate', ctx);
	importJsFile('/resources/content/system/security/gsysRole/gsysRole-input.js', ctx);
</script>
</head>
<body class="easyui-layout">
		<div region="center" border="false"><!-- center start -->
			<div id="firstTabs" class="v-tabs"><!-- firstTabs start -->
				<div title="基本信息"  class="v-tab"><!-- firt tab start -->
			 		<form id="inputForm" method="post" class="v-form">
			 			<input type="hidden" id="id" name="id" value="${mo.id}"/>	
						<!--<div id="info" class="v-state-info"></div>-->
					      	<table>
								<tr>
									<td class="label">
										<label>名称:</label>
									</td>
									<td class="field"><input type="text" id="name" name="name" value="${mo.name}" class="text"/></td>						
								</tr>
								<tr>
									<td class="label">
										<label>显示名称:</label>
									</td>
									<td class="field"><input type="text" id="displayName" name="displayName" value="${mo.displayName}" class="text"/></td>						
								</tr>
					      		<tr>
					      			<td class="label">
					      				<label>描述:</label>
					      			</td>
					      			<td class="field" >
					      				<textarea name="descript" rows="3" cols="35" >${mo.descript}</textarea>
					      			</td>
					      		</tr>
							</table>
					 </form>
				</div><!-- first tab end -->
				<div title="分配功能"   class="v-tab"><!--分配功能  tab start-->
					<div class="v-tree-wrap">
						<div class="v-title">选择功能：</div>
						<div class="v-content" id="relGSysFunctionCheckTree" style="height:230px; width:350px; overflow: auto;">
						</div>
					</div>
				</div><!--分配功能 tab end-->
				<div title="分配资源"  class="v-tab"><!--分配资源 tab start-->
					<div class="v-section-wrap v-checkbox-group">
						<div class='v-title'>选择资源：</div>
						<div class="v-content">
							${relGsysResourceCheckboxs}
						</div>
					</div>
				</div><!--分配资源  tab end-->
			</div><!-- firstTabs end -->
		</div><!-- center end -->
		<div region="south" border="false" style="height:50px;"><!-- south start-->
			<div class="v-buttons"><!-- v-buttons start -->
		  	 	<c:choose>
			  	 	<c:when test="${null==model.id}">
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
			 	  </c:when>
			   	<c:otherwise>
						<a class=" l-btn" href="javascript:updateData();">
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
				</c:otherwise>
			</c:choose> 
		</div><!-- v-buttons end-->
	</div><!-- south end -->
</body>
</html>