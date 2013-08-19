<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GsysCodevalue Input</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui|treeview', ctx, theme);
	importJsFile('jquery|blockUI|ui|common|treeview|form|validate', ctx);
	importJsFile('/resources/content/system/code/gsysCodevalue/gsysCodevalueByGsysCode-input.js', ctx);
</script>
</head>
<body class="easyui-layout">
 	<div id="first-box" class="v-box" region="center" border="false"><!-- first-box -->
 		<!--<div id="inputInfo" class="v-state-info"></div>-->
 		<div class="v-form"><!-- v-form start -->
 			<form id="inputForm" method="post">
 				<input type="hidden" id="id" name="id" value="${mo.id}"/>
		      	<table>
		      		<tr>
		      			<td class="label">
		      				<label class="requied">编码类别:</label>
		      			</td>
		      			<td class="field">
		      				<input type="text" id="gsysCode_cid" name="gsysCode.cid" value="${model.gsysCode.cid}" class="text readonly" readonly="readonly"/>
		      			</td>
		      		</tr>
					<tr>
						<td class="label">
							<label>属性名:</label>
						</td>
						<td class="field"><input type="text" id="name" name="name" value="${mo.name}" class="text"/></td>						
					</tr>
					<tr>
						<td class="label">
							<label>属性值:</label>
						</td>
						<td class="field"><input type="text" id="value" name="value" value="${mo.value}" class="text"/></td>						
					</tr>
		      		<tr>
		      			<td class="label">
		      				<label>描述:</label>
		      			</td>
		      			<td class="field" >
		      				<input type="text" id="descript" name="descript" value="${mo.descript}" class="title" />
		      			</td>
		      		</tr>	
				</table>
			</form>
			<div class="v-buttons"><!-- v-buttons start-->
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
					 </div>
				   </c:otherwise>
				</c:choose> 
			</div><!-- v-buttons end-->
		</div><!-- v-form end -->
	</div><!-- first-box -->
</body>
</html>