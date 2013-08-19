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
	importCssFile('sys|ui', ctx, theme);
	importJsFile('jquery|blockUI|common|ui|validate|form', ctx);
</script>
</head>
<body class="easyui-layout">
 	<div id="first-box" class="v-box" region="center" border="false">
 		<!--<div id="inputInfo" class="v-state-info"></div>-->
 		<div class="v-form">
 			<form id="inputForm" method="post">
		      	<table>
		      		<tr>
		      			<td class="label">
		      				<label>GsysFunction数据Excel导入文件:</label>
		      			</td>
		      		</tr>
		      		<tr>
		      			<td class="label">
		      				<input type="file" id="file" name="file" size="50" class="required" onchange="goolov.validete.file(this,'xls');"/>
		      			</td>
		      		</tr>
				</table>
			</form>
			<div class="v-buttons">
					<a href="javascript:void(0)" onclick="importProcess();"  class="easyui-linkbutton" icon="icon-save" tabindex="0">执行导入</a>
				   	<a href="javascript:closeAndRefresh();" class="easyui-linkbutton" >关闭并刷新</a>
			</div>
		</div>
	</div>
<script type="text/javascript">
	$(document).ready(function() {
		              var validator=$("#inputForm").validate();
					  $('#inputForm').submit(function() { 
					  	        $(this).ajaxSubmit({
									 type : 'post',
									 dataType:'html', 
									 url:ctx+'/system/security/gsysFunction/importExcelFileProcess.vhtml',
									 beforeSubmit:function(formData, jqForm, options) {
										    if(validator.numberOfInvalids()>0){
											    return false;
										    }
										    goolov.growl.waiting('导入数据中...');
									 },
								     success:function(result, statusText, xhr, $form) {
								     		goolov.growl.unwaiting();
											goolov.msgbox.info('友情提示',result);
									 },
									 error:function(request,status,errorThrown) {
									 	goolov.growl.unwaiting();
										goolov.msgbox.error();
									}
								}); 
						        return false; 
					    }); 
	});
	function importProcess(){
		$("#inputForm").submit();
	}
	function closeAndRefresh(){
		window.parent.closeImportExcelWinAndRefresh();
	}
</script>
</body>
</html>