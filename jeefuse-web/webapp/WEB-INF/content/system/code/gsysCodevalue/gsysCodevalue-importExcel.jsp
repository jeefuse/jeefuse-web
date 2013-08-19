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
	importCssFile('main', ctx, theme);
	importCssFile('easyui', ctx, theme);
	importJsFile('jquery', ctx);
	importJsFile('blockUI',ctx);
	importJsFile('common',ctx);
	importJsFile('easyui', ctx);
	importJsFile('validate', ctx);
	importJsFile('form', ctx);
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
		      				<label>GsysCodevalue数据Excel导入文件:</label>
		      			</td>
		      		</tr>
		      		<tr>
		      			<td class="label">
		      				<input type="file" id="file" name="file" size="50" class="required" onchange="valideteFile(this,'xls');"/>
		      			</td>
		      		</tr>
				</table>
			</form>
			<div class="v-buttons">
					<a href="javascript:void(0)" onclick="importProcess();"  class="easyui-linkbutton" icon="icon-save" tabindex="0">执行导入</a>
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
									 url:ctx+'/system/code/gsysCodevalue/importExcelFileProcess.vhtml',
									 beforeSubmit:function(formData, jqForm, options) {
										    if(validator.numberOfInvalids()>0){
											    return false;
										    }
										    $.growl.waiting('导入数据中...');
									 },
								     success:function(result, statusText, xhr, $form) {
								     		$.growl.unwaiting();
											$.msgbox.confirm('友情提示',result+"<br>您是否需要继续导入?",
														function(r) {
															if (r) {
																window.parent.refresh();
													        }else{
													    	   window.parent.closeImportExcelWinAndRefresh();
													       }
											 });
											       
									 },
									 error:function(request,status,errorThrown) {
									 	$.growl.unwaiting();
										$.msgbox.error();
									}
								}); 
						        return false; 
					    }); 
	});
	function importProcess(){
		$("#inputForm").submit();
	}
</script>
</body>
</html>