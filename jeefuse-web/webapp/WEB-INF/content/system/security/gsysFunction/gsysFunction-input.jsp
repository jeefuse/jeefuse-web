<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GsysFunction Input</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui|treeview', ctx, theme);
	importJsFile('jquery|ui|common|validate|form|blockUI|combotree|treeview', ctx);
	importJsFile('/resources/content/system/security/gsysFunction/gsysFunction-input.js', ctx);
</script>
</head>
<body class="v-container">
 	<div  region="center" border="false">
 		<!--<div id="inputInfo" class="v-state-info"></div>-->
 			<form id="inputForm" method="post" class="v-form">
 				<input type="hidden" id="id" name="id" value="${mo.id}"/>
		      	<table>
					<tr>
						<td class="label">
							<label class="required">权限标志:</label>
						</td>
						<td class="field" colspan="3">
							<input type="text" id="value" name="value" value="${mo.value}" class="title"/>
						</td>						
					</tr>
					<tr>
						<td class="label">
							<label class="required">权限名称:</label>
						</td>
						<td class="field" colspan="3">
							<input type="text" id="name" name="name" value="${mo.name}" class="text"/>
						</td>
					</tr>	
					<tr>
						<td class="label">
							<label>权限类型:</label>
						</td>
						<td class="field">
							<select name="type" id="type" class="text" >
							     <s:property value="functionTypeHtmlSelect" escape="false"/>
							 </select>
						</td>						
						<td class="label">
							<label>上级ID:</label>
						</td>
						<td class="field">
							 <input type="hidden" id="parentId" name="parentId" value="${mo.parentId}" />
							 <input type="text" id="parentName" name="parentName" value="${mo.parentName}" class="text" readonly="readonly"/>
						</td>						
					</tr>
					<tr>
						<td class="label">
							<label>是否有效:</label>
						</td>
						<td class="field">
							<select name="validStatus" id="validStatus" class="text" >
							     <s:property value="InvalidTypeHtmlSelect" escape="false"/>
							 </select>
						</td>						
						<td class="label">
							<label>排序:</label>
						</td>
						<td class="field">
							<input type="text" id="sortNum" name="sortNum" value="${mo.sortNum}" class="text"/>
						</td>						
					</tr>
<!--					<tr>-->
<!--						<td class="label">-->
<!--							<label>层次代码:</label>-->
<!--						</td>-->
<!--						<td class="field">-->
<!--							<input type="text" id="layerCode" name="layerCode" value="${mo.layerCode}" class="text"/>-->
<!--						</td>							-->
<!--						<td class="label"></td>-->
<!--					    <td class="field"></td>-->
<!--					</tr>					-->
		      		<tr>
		      			<td class="label">
		      				<label>描述:</label>
		      			</td>
		      			<td class="field" colspan="3">
		      				<textarea name="descript" rows="3" cols="60" >${mo.descript}</textarea>
		      			</td>
		      		</tr>
		      		<tr>
		      			<td class="label">
		      				<label>url:</label>
		      			</td>
		      			<td class="field" colspan="3">
		      				<textarea name="url" rows="3" cols="60">${mo.url}</textarea>
		      			</td>
		      		</tr>
				</table>
			</form>
			<div class="v-buttons">
			   	<c:choose>
				   <c:when test="${null==model.id}">
				   			<a href="javascript:saveDataWithNewWin();" class="easyui-linkbutton">新增</a>
				   			<a id="updateData" href="javascript:updateDataWithNewWin();" disabled="true" class="easyui-linkbutton">修改</a>
				   			<a href="javascript:resetData();" class="easyui-linkbutton" >重置</a>
				   			<a href="javascript:closeNewWin();" class="easyui-linkbutton" >关闭</a>
				   			<a href="javascript:closeNewWinAndRefresh();" class="easyui-linkbutton" >关闭并刷新</a>
				   </c:when>
				   <c:otherwise>
				   			<a href="javascript:updateDataWithEditWin();" class="easyui-linkbutton" >修改</a>
							<a href="javascript:addNewDataWithEditWin();" class="easyui-linkbutton">添加为新记录</a>
							<a href="javascript:resetData();" class="easyui-linkbutton" >重置</a>
							<a href="javascript:closeEditWin();" class="easyui-linkbutton" >关闭</a>
							<a href="javascript:closeEditWinAndRefresh();" class="easyui-linkbutton" >关闭并刷新</a>
				   </c:otherwise>
				</c:choose> 
			</div>
	</div>
</body>
</html>