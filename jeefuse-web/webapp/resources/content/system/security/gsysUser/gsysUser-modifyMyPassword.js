$(document).ready(function() {
		validator=$("#inputForm").validate({
		rules : {
			inpass: {
				required: true,
				minlength:4,
				maxlength:32
			},
			inpassConfirm: {
				equalTo:"#inpass"
			}
		},
		messages: {
			passwordConfirm: {
				equalTo: "输入与上面相同的密码"
			}
		},
		errorType: "bftip"
	});
	$('#inputForm').submit(function(){
			var inpass=$('#inpass').val();
			if(inpass&&$.trim(inpass)!=''){
				var psenctrypt=goolov.encrypt(inpass);
				$('#password').val(psenctrypt);
			}else{
				goolov.msgbox.alert("请输入新密码!");
			}
	        $(this).ajaxSubmit({
				 type : 'post',
				 dataType:'json', 
				 url:ctx+'/system/security/gsysUser/modifyMyPasswordSave.vhtml',
				 beforeSubmit:function(formData, jqForm, options) {
				 		var invalideNum=validator.numberOfInvalids();
					    if(invalideNum>0){
					    	goolov.growl.success('有<font color=red>'+invalideNum+'</font> 个选项未填写正确!');
						    return false;
					    }
					    goolov.growl.waiting('修改密码中...');
				 },
			     success:function(result, statusText, xhr, $form) {
			     		goolov.growl.unwaiting();
						if (result&&result.success) {
							goolov.growl.success(result.message);
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
	window.parent.newWinClose();
}
function closeNewWinAndRefresh(){
	window.parent.newWinCloseAndRefresh();
}
function closeEditWin(){
	window.parent.editWinClose();
}
function closeEditWinAndRefresh(){
	window.parent.editWinCloseAndRefresh();
}