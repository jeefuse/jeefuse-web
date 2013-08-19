
$(document).ready(function() {
		validator=$("#inputForm").validate({
			rules : {
				applicantName:{required:true,maxlength:16}//1 申请人姓名	
				,applicantNumber:{required:true,maxlength:26}//2 申请人身份证号码	
				,applicantTel:{maxlength:30}//3 申请人联系电话	
				,idcartPhoto:{required:true,maxlength:120}//4 申请人身份证正面	
				,idcartSavePath:{required:true,maxlength:120}//5 申请人身份证正面照片保存地址	
				,"gsysUser.id":{required:true}//6 gsysUser							
			}
			//,errorType: "bftip"
	});	
});
var validator;
/*******reset Data******/
function resetData(){
	validator.resetForm();
}
/********saveDataWithNewWin**************/
function newWinSaveData(){
	var submitUrl=ctx+'/system/security/gsysUserCertify/saveOutJson.vhtml';		
    $('#inputForm').ajaxSubmit({ 
		 type : 'post',
		 dataType:'json', 
		 url:submitUrl,
		 beforeSubmit:function(formData, jqForm, options) {
		     	if(!$("#inputForm").valid()){
			 		var invalideNum=validator.numberOfInvalids();
				    if(invalideNum>0){
				    	goolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');
					    return false;
				    }
				}
				goolov.growl.waiting('新增数据中...');
		 },
	     success:function(result, statusText, xhr, $form) {
	     		goolov.growl.unwaiting();
				if (result&&result.success) {
					goolov.growl.success(result.message);
					$("#id").val(result.data.id);
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
function newWinClose(){
	window.parent.newWinClose();
}
function newWinCloseAndRefresh(){
	window.parent.newWinCloseAndRefresh();
}
/*******updateDataWithEditWin******/
function editWinUpdateData(){
	var submitUrl=ctx+'/system/security/gsysUserCertify/updateOutJson.vhtml';
    $('#inputForm').ajaxSubmit({ 
		 type : 'post',
		 dataType:'json', 
		 url:submitUrl,
		 beforeSubmit:function(formData, jqForm, options) {
		     	if(!$("#inputForm").valid()){
			 		var invalideNum=validator.numberOfInvalids();
				    if(invalideNum>0){
				    	goolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');
					    return false;
				    }
				}
				goolov.growl.waiting('新增数据中...');
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
/*******close edit win******/
function editWinClose(){
	window.parent.editWinClose();
}
function editWinCloseAndRefresh(){
	window.parent.editWinCloseAndRefresh();
}


/*******rel GsysUser manager**********/
var relGsysUserListForSelectWin;
function relGsysUserListForSelectWinInit(){
	if(!relGsysUserListForSelectWin){
		relGsysUserListForSelectWin=new goolov.winbox({
			width:goolov.winWidth(750),
			height:goolov.winHeight(450),
			modal:true,
			neeedReLoad:false
		});
	}
}
function relGsysUserListForSelectWinOpen(settings){
	relGsysUserListForSelectWinInit();
	relGsysUserListForSelectWin.open(settings);
}
function relGsysUserListForSelectWinClose(){
	relGsysUserListForSelectWin.close();
}
function relGsysUserListForSelect(id,name){
	var title='GsysUser选择';
	var url=ctx+'/system/security/gsysUser/listForSelect.vhtml';
	relGsysUserListForSelectWinOpen({title:title,url:url});
}
function relGsysUserListForSelectProcess(id,name){
	$('#gsysUser_id').val(id);
	$('#gsysUser_null').val(name);
	relGsysUserListForSelectWinClose();
	validator.form();
}
function relGlDiningSiteListForSelectClear(){
	$('#gsysUser_id').val('');
	$('#gsysUser_null').val('');
}