$(document).ready(function() {
	validator=$("#inputForm").validate({
		rules : {
			value:{required:true,maxlength:40,letterUnderline:true}	
			,name:{required:true,maxlength:40}	
			,descript:{maxlength:255}	
			,type:{maxlength:20}	
			,url:{maxlength:255}	
			,parentId:{maxlength:32}	
			,validStatus:{maxlength:1}	
			,sortNum:{digits:true,maxlength:10}	
			,layerCode:{maxlength:20}	
		},
		errorType: "bftip"
	});
	var url=ctx+'/system/security/gsysFunction/listTreeOutForSelParentJson.vhtml?id='+$('#id').val();
	var iconspath=ctx+"/resources/style/default/tree/images/";
	$('#parentName').comboTree({url:url,iconspath:iconspath,keyEl:'parentId'});
});
var validator;
/********reset Data*********************/
function resetData(){
	validator.resetForm();
}
/********saveDataWithNewWin**************/
function saveDataWithNewWin(){
	var submitUrl=ctx+'/system/security/gsysFunction/saveOutJson.vhtml';
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
					$("#updateData").linkbutton('enable');
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
/********updateDataWithNewWin**************/
function updateDataWithNewWin(){
	var submitUrl=ctx+'/system/security/gsysFunction/updateOutJson.vhtml';
    $('#inputForm').ajaxSubmit({ 
		 type : 'post',
		 dataType:'json', 
		 url:submitUrl,
		 beforeSubmit:function(formData, jqForm, options) {
		 		var invalideNum=validator.numberOfInvalids();
			    if(invalideNum>0){
			    	goolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');
				    return false;
			    }
			    goolov.growl.waiting('更新数据中...');
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
function closeNewWin(){
	window.parent.closeNewWin();
}
function closeNewWinAndRefresh(){
	window.parent.closeNewWinAndRefresh();
}

/*******updateDataWithEditWin******/
function updateDataWithEditWin(){
	var submitUrl=ctx+'/system/security/gsysFunction/updateOutJson.vhtml';
    $('#inputForm').ajaxSubmit({ 
		 type : 'post',
		 dataType:'json', 
		 url:submitUrl,
		 beforeSubmit:function(formData, jqForm, options) {
		 		var invalideNum=validator.numberOfInvalids();
			    if(invalideNum>0){
			    	goolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');
				    return false;
			    }
			    goolov.growl.waiting('更新数据中...');
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
function addNewDataWithEditWin(){
	var submitUrl=ctx+'/system/security/gsysFunction/saveOutJson.vhtml';
    $('#inputForm').ajaxSubmit({ 
		 type : 'post',
		 dataType:'json', 
		 url:submitUrl,
		 beforeSubmit:function(formData, jqForm, options) {
		 		var invalideNum=validator.numberOfInvalids();
			    if(invalideNum>0){
			    	goolov.growl.success('有<font color=red> '+invalideNum+'</font> 个选项未填写正确!');
				    return false;
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
function closeEditWin(){
	window.parent.closeEditWin();
}
function closeEditWinAndRefresh(){
	window.parent.closeEditWinAndRefresh();
}
