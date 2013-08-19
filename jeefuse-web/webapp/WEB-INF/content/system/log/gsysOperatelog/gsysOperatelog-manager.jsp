<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>操作日志管理</title>
<%@ include file="/common/meta.jsp" %>
<script src="${ctx}/resources/js/include.js" type="text/javascript"></script>
<script>
	var ctx = '${ctx}';
	var theme = '${theme}';
	var LogTypeJson=${LogTypeJson};
	importCssFile('sys|ui|flexiGrid|contextmenu|datePicker', ctx, theme);
	importJsFile('jquery|blockUI|common|ui|flexiGrid|validate|contextmenu|datePicker|autocomplete', ctx);
	importJsFile('/resources/content/system/log/gsysOperatelog/gsysOperatelog-manager.js', ctx);
</script>

</head>
<body id="container" class="v-container">
	<div id="header" region="north" split="false" border="false"  class="v-header"><!-- header start -->
		<div id="first-title" class="v-title">
			
		</div>
		
		<div id="first-toolbar" class="v-toolbar"><!-- v-toolbar start -->
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
			</div>
		</div><!-- v-toolbar end -->
		
		<div id="first-search" class="v-search"><!-- first-search -->		
		   <form id="firstSearchForm">
				<table>	
						
					<tr>	
		      			<td class="label">
		      				<label>登录IP:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="loginIp" name="loginIp" value="${model.loginIp}"  />
		      			</td>							
		      			<td class="label">
		      				<label>开始创建时间:</label>
		      			</td>
		      			<td class="field">
		      				<input type="text" id="createdateStart" name="createdateStart" value="${model.createdateStart}"  />
		      			</td>

		      			<td class="label">
		      				<label>结束创建时间:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="createdateEnd" name="createdateEnd" value="${model.createdateEnd}"  />
		      			</td>							
		      			<td class="label">
		      				<label>操作用户:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<input type="text" id="userId" name="userId" value="${model.userId}"  />
		      			</td>
					</tr>						
					<tr>	

		      			<td class="label">
		      				<label>类型:</label>
		      			</td>
		      			<td class="field" colspan="1">
		      				<select  id="kind" name="kind" class="text">
								 <option value="" >所有</option>
							     <s:property value="LogTypeHtmlSelect" escape="false"/>
							 </select>
		      			</td>								
						<td>
							<div class="v-buttons">
								<a href="javascript:firstSearch();" class="easyui-linkbutton" icon="icon-search" >查 询</a>
							</div>
						</td>	
						<td colspan="5"></td>
					</tr>	
				</table>
			</form>
		</div><!-- first-search End-->
	</div><!-- header end -->			

	<div id="center" region="center"  border="true">
   		<div id="first-content">
			<div id="dataGrid"  style="display:none;"></div>
		</div>
	</div><!-- center end -->						
</body>
</html>
