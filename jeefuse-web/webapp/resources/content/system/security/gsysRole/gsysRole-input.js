$(document).ready(function() {
	//定义tabs
	$("#firstTabs").tabs({fit:true,border:false});
	//relGSysFunctionCheckTree
	var relGSysFunctionCheckTreeOptions = { data: relGsysFunctionShowCheckJson,theme: "bbit-tree-lines",showcheck: true,iconspath:ctx+"/resources/style/default/tree/images/" };
    $("#relGSysFunctionCheckTree").treeview(relGSysFunctionCheckTreeOptions);
	//validate
	validator=$("#inputForm").validate({
		rules : {
			name:{required:true,maxlength:40,letterUnderline:true}	
			,displayName:{maxlength:40}	
			,descript:{maxlength:255}	
		},
		errorType: "bftip"
	});
	$('#inputForm').submit(function(){
			var submitUrl=saveOrUpdateUrl;
			//relGsysFunctionCheckIds
			var relGSysFunctionCheckTreeSelectIds=$("#relGSysFunctionCheckTree").getSelectedIds(true);
			var relGsysFunctionCheckIds=relGSysFunctionCheckTreeSelectIds.join(",");
            //$('#relGsysFunctionCheckIds').val(relGsysFunctionCheckIds);
			
			//relGsysResourceCheckIds
            var relGsysResourceCheckIdArray=[];
            $("input[name='relGsysResourceCheckboxs']:checked").each(function(){
            	relGsysResourceCheckIdArray.push($(this).val());
			 });
    		//$('#relGsysResourceCheckIds').val(relGsysResourceCheckIds);
            var relGsysResourceCheckIds=relGsysResourceCheckIdArray.join(",");
			//send
	        $(this).ajaxSubmit({
				 type : 'post',
				 dataType:'json', 
				 data:{relGsysFunctionCheckIds:relGsysFunctionCheckIds,relGsysResourceCheckIds:relGsysResourceCheckIds},
				 url:submitUrl,
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
var RelGsysFunctionCheckTree;
function onSelectTab(tab){
	if(tab=='分配功能'){
		if(!RelGsysFunctionCheckTree){
			var url=ctx+'/system/security/gsysRole/listRelGsysFunctionCheckOutJson.vhtml';
	    	var options = { url:url,theme: "bbit-tree-arrows",showcheck: true,iconspath:ctx+"/resources/style/default/tree/images/" };
			RelGsysFunctionCheckTree=$('#relGSysFunctionCheckTree').ajaxTree(options);
		}
	}
}
var validator;
var saveOrUpdateUrl;
/*******save Data******/
function saveData(){
	saveOrUpdateUrl=ctx+'/system/security/gsysRole/saveOutJson.vhtml';
	$("#inputForm").submit();
}
function updateData(){
	saveOrUpdateUrl=ctx+'/system/security/gsysRole/updateOutJson.vhtml';
	$("#inputForm").submit();
}
/*******save rel gsysFunction******/
function saveGsysRoleRelFunction(){
	//$("#inputForm").submit();
}
/*******reset Data******/
function resetData(){
	validator.resetForm();
}
/*******close new win******/
function closeNewWin(){
	window.parent.closeNewWin();
}
function closeNewWinAndRefresh(){
	window.parent.closeNewWinAndRefresh();
}
/*******close edit win******/
function closeEditWin(){
	window.parent.closeEditWin();
}
function closeEditWinAndRefresh(){
	window.parent.closeEditWinAndRefresh();
}
/*******保存关联的系统功能************/
function relGsysFunctionCheckSave(){
	var checkIds=RelGsysFunctionCheckTree.getSelectedValues();
	$.ajax({
		type : 'post',
		url:ctx+'/system/security/gsysRole/listRelGsysFunctionCheckSaveOutJson.vhtml',
		data : {relGsysFunctionCheckIds:checkIds.join(',')},
		dataType:'json',
		beforeSend :function() {
			goolov.growl.waiting('正在保存中...');
		},
		success : function(result) {
			goolov.growl.unwaiting();
			if (result&&result.success) {
				goolov.growl.success(result.message);
			}else if(result&&result.message){
				goolov.growl.error(result.message);
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