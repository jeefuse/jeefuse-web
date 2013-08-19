$(document).ready(function() {
		validator=$("#inputForm").validate({
		rules : {
			name:{maxlength:20}	
			,value:{maxlength:50}	
			,descript:{maxlength:100}
			,'gsysCode.cid':{required:true}
		},
		errorType: "bftip"
	}); 
	$('#inputForm').submit(function(){ 
	        $(this).ajaxSubmit({
				 type : 'post',
				 dataType:'json', 
				 url:ctx+'/system/code/gsysCodevalue/saveOutJson.vhtml',
				 beforeSubmit:function(formData, jqForm, options) {
				 		var invalideNum=validator.numberOfInvalids();
					    if(invalideNum>0){
					    	goolov.growl.success('有<font class=warn> '+invalideNum+'</font>个选项未填写正确!');
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