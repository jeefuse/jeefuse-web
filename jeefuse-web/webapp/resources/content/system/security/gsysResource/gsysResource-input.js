$(document).ready(function() {
		validator=$("#inputForm").validate({
		rules : {
			name:{required:true,maxlength:32}	
			,descript:{maxlength:255}	
			,value:{required:true,maxlength:200}	
			,type:{maxlength:32}	
		},
		errorType: "bftip"
	});
	$('#inputForm').submit(function(){ 
	        $(this).ajaxSubmit({
				 type : 'post',
				 dataType:'json', 
				 url:ctx+'/system/security/gsysResource/saveOutJson.vhtml',
				 beforeSubmit:function(formData, jqForm, options) {
				 		var invalideNum=validator.numberOfInvalids();
					    if(invalideNum>0){
					    	goolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');
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