<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>GsysCode Input</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui', ctx, theme);
	importJsFile('jquery|blockUI|ui|common|form|validate', ctx);
	importJsFile('/resources/content/system/code/gsysCode/gsysCode-input.js', ctx);
</script>
</head>
<body class="easyui-layout">
 	<div id="first-box" class="v-box" region="center" border="false">
 		<!--<div id="inputInfo" ></div>-->
 		<div class="v-form">
 			<form id="inputForm" method="post">
		      	<table>
					<tr>
						<td class="label">
							<label>编号:</label>
						</td>
						<td class="field">
					  	 	<c:choose>
						  	 	<c:when test="${null==model.id}">
									<input type="text" id="cid" name="cid" value="${mo.cid}" class="text"/>
						 	    </c:when>
						   	    <c:otherwise>
									<input type="text" id="cid" name="cid" value="${mo.cid}" class="text readonly" readonly='readonly' />
									<input type="hidden" id="oldId" name="oldId" value="${mo.cid}"/>
							    </c:otherwise>
							</c:choose> 
						</td>						
					</tr>
		      		<tr>
		      			<td class="label">
		      				<label>名称:</label>
		      			</td>
		      			<td class="field" colspan="3">
		      				<input type="text" id="name" name="name" value="${mo.name}" class="text"  />
		      			</td>
		      		</tr>	
					<tr>
						<td class="label">
							<label>类别:</label>
						</td>
						<td class="field">
							<select id="kind" name="kind"  class="text">
							     <s:property value="CodeOperateKindHtmlSelect" escape="false"/>
							 </select>
						</td>						
					</tr>
		      		<tr>
		      			<td class="label">
		      				<label>描述:</label>
		      			</td>
		      			<td class="field" >
		      				<textarea name="descript" rows="3" cols="60" >${mo.descript}</textarea>
		      			</td>
		      		</tr>
				</table>
			</form>
			<div class="v-buttons">
		  	 	<c:choose>
			  	 	<c:when test="${null==model.id}">
			   			<div class="v-buttons">
							<a class=" l-btn" href="javascript:saveData();">
								<span class="l-btn-left"><span class="l-btn-text">保存</span></span>
							</a>
							<a class=" l-btn" href="javascript:resetData();">
								<span class="l-btn-left"><span class="l-btn-text">重置</span></span>
							</a>
							<a class=" l-btn" href="javascript:newWinClose();">
								<span class="l-btn-left"><span class="l-btn-text">关闭</span></span>
							</a>
							<a class=" l-btn" href="javascript:newWinCloseAndRefresh();">
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
						<a class=" l-btn" href="javascript:editWinClose();">
							<span class="l-btn-left"><span class="l-btn-text">关闭</span></span>
						</a>
						<a class=" l-btn" href="javascript:editWinCloseAndRefresh();">
							<span class="l-btn-left"><span class="l-btn-text">关闭并刷新</span></span>
						</a>
					 </div>
				   </c:otherwise>
				</c:choose> 
			</div>
		</div>
	</div>
</body>
</html>