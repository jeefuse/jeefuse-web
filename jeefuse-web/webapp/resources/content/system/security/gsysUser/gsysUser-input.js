$(document).ready(function() {
		validator=$("#inputForm").validate({
		rules : {
			username:{maxlength:20,required: true}
			,createTime:{dateCN:true,maxlength:19}	
			,email:{maxlength:50,email:true}	
			,enabled:{maxlength:1}	
			,loginName:{required:true,maxlength:20,letterNum:true,
				remote: ctx+'/system/security/gsysUser/checkLoginName.vhtml?oldLoginName=' + encodeURIComponent($("#oldLoginName").val())
			}
			,logincount:{digits:true,maxlength:19}
			,inpass: {
				required: true,
				minlength:4,
				maxlength:32
			},
			inpassConfirm: {
				equalTo:"#inpass"
			}
			,remark:{maxlength:255}	
			,sex:{maxlength:1}	
			,telephone:{maxlength:30,tel:true}	
			,updateTime:{dateCN:true,maxlength:19}	
			,lastLoginTime:{dateCN:true,maxlength:19}	
		},
		messages: {
			loginName: {
				remote: "用户登录名已存在"
			},
			passwordConfirm: {
				equalTo: "输入与上面相同的密码"
			}
		},
		errorType: "bftip"
	});
	$('#inputForm').submit(function(){
			var cid=$('#cid').val();
			if(!cid||$.trim(cid)==''){
				var inpass=$('#inpass').val();
				if(inpass&&$.trim(inpass)!=''){
					var psenctrypt=goolov.encrypt(inpass);
					$('#password').val(psenctrypt);
				}else{
					goolov.msgbox.alert("请输入新密码!");
					return;
				}
			}
	        $(this).ajaxSubmit({
				 type : 'post',
				 dataType:'json', 
				 url:ctx+'/system/security/gsysUser/saveOutJson.vhtml',
				 beforeSubmit:function(formData, jqForm, options) {
				 		var invalideNum=validator.numberOfInvalids();
					    if(invalideNum>0){
					    	goolov.growl.success('有<font color=red>'+invalideNum+'</font> 个选项未填写正确!');
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