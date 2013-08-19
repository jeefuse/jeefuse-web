
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>操作日志 Input</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	importCssFile('sys|ui', ctx, theme);
	importJsFile('jquery|blockUI|ui|common|form|validate|fckeditor', ctx);
	importJsFile('/resources/content/system/log/gsysOperatelog/gsysOperatelog-input.js', ctx);
</script>
</head>
<body class="easyui-layout v-container">
 	<div region="center" border="false"><!-- center start -->
		<div id="firstTabs" class="v-tabs"><!-- firstTabs start -->
		  <div title="基本信息"  class="v-tab"><!-- tab one  start -->
 			<form id="inputForm" method="post" class="v-form">
 				<input type="hidden" name="id" value="${mo.id}"/>
 				<!--<div id="inputInfo" class="v-state-info"></div>-->
		      	<table>
					<tr>	
		      			<td class="label">
		      				<label>登录IP:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="loginIp" name="loginIp" value="${mo.loginIp}" class="text" />
		      			</td>
					</tr>						
					<tr>			
		      			<td class="label">
		      				<label>创建时间:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      					${mo.createdateToStr}	
		      			</td>
					</tr>						
					<tr>			
		      			<td class="label">
		      				<label>信息:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<textarea id="message" name="message"  class="textarea" >${mo.message}</textarea>	
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>操作用户:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="userId" name="userId" value="${mo.userId}" class="text" />
		      			</td>
					</tr>						
					<tr>	
		      			<td class="label">
		      				<label>类型:</label>
		      			</td>
						<td class="field" colspan="1">
							 <select  id="kind" name="kind" class="text" " >
							     <s:property value="LogTypeHtmlSelect" escape="false"/>
							 </select>
						</td>
					</tr>							
				</table>
			  </form>
			</div><!-- tab one end -->
	  		<div title="详细说明"><!--详细说明 tab start-->
		  		<div class="v-fckeditor">
		  			<input type="hidden" id="detail" name="detail"/>
		  			<textarea style="width: 90%;"  id="fck_detail">
		      		  ${mo.detail}
		   			</textarea>
				  	<script type="text/javascript">
			             var oFCKeditor = new FCKeditor('fck_detail') ; 
		                 oFCKeditor.BasePath	= '${ctx}/resources/fckeditor/' ;
		                 oFCKeditor.Config["CustomConfigurationsPath"]="${ctx}/resources/fckeditor/customConfig.js";
			             oFCKeditor.ToolbarSet='goolovEditTab';
			             oFCKeditor.Config["TabSpaces"]=2;
			             oFCKeditor.Config["LinkUpload"] = false;
			             oFCKeditor.Config["ImageUpload"] = true;
			             oFCKeditor.Config["FlashUpload"] = false;
			             oFCKeditor.Height	= 430-130;
		                 oFCKeditor.ReplaceTextarea(); 
		            </script>
		          </div>
			</div><!--详细说明 tab end-->									
		  </div><!-- firstTabs end -->
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
