$(document).ready(function() {
		validator=$("#inputForm").validate({
		rules : {
		}
	});
	$('#inputForm').submit(function(){ 
	        $(this).ajaxSubmit({
				 type : 'post',
				 dataType:'json', 
				 url:ctx+'/system/security/gsysRelRoleFunction/saveOutJson.vhtml',
				 beforeSubmit:function(formData, jqForm, options) {
					    if(validator.numberOfInvalids()>0){
						    return false;
					    }
					    goolov.growl.waiting('保存数据中...');
				 },
			     success:function(result, statusText, xhr, $form) {
			     		goolov.growl.unwaiting();
						if (result&&result.success) {
							goolov.growl.success(result.message);
							window.parent.addRowData(result.data);
						}else if(result&&result.message){
							goolov.msgbox.error(result.message);
						}else{
							goolov.msgbox.error();
						}
				 },
				 error:function(request,status,errorThrown) {
				 	goolov.growl.unwaiting();
					goolov.msgbox.error();
				}
			}); 
	        return false; 
	}); 
});
var validator;
function saveData(){
	$("#inputForm").submit();
}
function resetData(){
	//document.getElementById('inputForm').reset();
	validator.resetForm();
}
function closeNewWin(){
	window.parent.closeNewWin();
}
function closeNewWinAndRefresh(){
	window.parent.closeNewWinAndRefresh();
}
function closeEditWin(){
	window.parent.closeEditWin();
}
function closeEditWinAndRefresh(){
	window.parent.closeEditWinAndRefresh();
}