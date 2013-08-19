$(document).ready(function() {

});
function submitData(){
	var idcardAuthen=$('#idcardAuthen').val();
	var auditReason=$('#auditReason').val();
	var userId=$('#userId').val();
	if(!idcardAuthen){
		alert("请选择审核!");
		return ;
	}
	if(idcardAuthen=='C'){
		if(!auditReason||$.trim(auditReason)==''){
			alert("请填写审核不通过原因!");
			return ;
		}
	}
    $.ajax({
		 type : 'post',
		 dataType:'json', 
		 url:ctx+'/system/security/gsysUser/identityAuditSubmit.vhtml',
		 data:{idcardAuthen:idcardAuthen,auditReason:auditReason,userId:userId},
		 beforeSend:function(formData, jqForm, options) {
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
}
function closeWin(){
	window.parent.verifyWinClose();
}
