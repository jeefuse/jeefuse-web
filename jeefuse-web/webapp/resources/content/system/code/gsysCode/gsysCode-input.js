$(document).ready(function() {
	validator=$("#inputForm").validate({
		rules : {
			cid:{required:true,maxlength:32}	
			,name:{maxlength:100}	
			,descript:{maxlength:200}	
			,kind:{maxlength:1}	
		}
	});
	$('#inputForm').submit(function(){ 
		 $(this).ajaxSubmit({
			 type : 'post',
			 dataType:'json', 
			 url:saveOrUpdateUrl,
			 beforeSubmit:function(formData, jqForm, options) {
				    var invalideNum=validator.numberOfInvalids();
				    if(invalideNum>0){
				    	goolov.growl.success('有<font color=red>'+invalideNum+'</font>个选项未填写正确!');
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
var saveOrUpdateUrl;
/*******save Data******/
function saveData(){
	saveOrUpdateUrl=ctx+'/system/code/gsysCode/saveOutJson.vhtml';
	$("#inputForm").submit();
}
/*******update Data******/
function updateData(){
	saveOrUpdateUrl=ctx+'/system/code/gsysCode/updateOutJson.vhtml';
	$("#inputForm").submit();
}
/*******reset Data******/
function resetData(){
	validator.resetForm();
}
/*******close new win******/
function newWinClose(){
	window.parent.newWinClose();
}
function newWinCloseAndRefresh(){
	window.parent.newWinCloseAndRefresh();
}
/*******close edit win******/
function editWinClose(){
	window.parent.editWinClose();
}
function editWinCloseAndRefresh(){
	window.parent.editWinCloseAndRefresh();
}