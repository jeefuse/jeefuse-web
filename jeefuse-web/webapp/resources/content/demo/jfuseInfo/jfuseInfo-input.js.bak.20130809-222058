
$(document).ready(function() {
		//定义tabs
		$("#firstTabs").tabs({fit:true,border:false});
		validator=$("#inputForm").validate({
			rules : {
				title:{required:true,maxlength:200}//1 标题	
				,brief:{maxlength:250}//2 摘要	
				,audit:{required:true,maxlength:1}//3 审核	
				,mark:{maxlength:100}//4 标签	
				,userId:{required:true,maxlength:32}//5 发布用户	
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
	var submitUrl=ctx+'/demo/jfuseInfo/saveOutJson.vhtml';	
	var content=FCKeditorAPI.GetInstance('fck_content').GetHTML(true);		
    $('#inputForm').ajaxSubmit({ 
		 type : 'post',
		 dataType:'json', 
		 data:{content:content},
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
/*******updateDataWithEditWin******/
function editWinUpdateData(){
	var submitUrl=ctx+'/demo/jfuseInfo/updateOutJson.vhtml';
	var content=FCKeditorAPI.GetInstance('fck_content').GetHTML(true);
    $('#inputForm').ajaxSubmit({ 
		 type : 'post',
		 dataType:'json', 
		 data:{content:content},
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