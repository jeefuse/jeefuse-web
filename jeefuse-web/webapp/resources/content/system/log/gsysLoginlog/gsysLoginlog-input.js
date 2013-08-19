
$(document).ready(function() {
		validator=$("#inputForm").validate({
			rules : {
				loginIp:{maxlength:32}//1 登录IP	
				,message:{maxlength:254}//2 信息	
				,userId:{maxlength:32}//3 登入用户	
		},
		errorType: "bftip"
	});
});
var validator;
/*******reset Data******/
function resetData(){
	validator.resetForm();
}
/********saveDataWithNewWin**************/
function newWinSaveData(){
	var submitUrl=ctx+'/system/log/gsysLoginlog/saveOutJson.vhtml';
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
	window.parent.closeNewWin();
}
function newWinCloseAndRefresh(){
	window.parent.closeNewWinAndRefresh();
}
/*******updateDataWithEditWin******/
function editWinUpdateData(){
	var submitUrl=ctx+'/system/log/gsysLoginlog/updateOutJson.vhtml';
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
/********addNewDataWithEditWin*************/
function editWinAddNewData(){
	var submitUrl=ctx+'/system/log/gsysLoginlog/saveOutJson.vhtml';
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
					window.parent.addRowDataWithEditWin(result.data);
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
