
$(function(){
	var mainheight = document.documentElement.clientHeight;
	var gridpm = 58; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm-$("#header").outerHeight(true);
	var w = $("#first-content").width();
    var option = {
        height: h, 
        width: w,
        url: ctx+'/demo/jfuseInfo/listOutJson.vhtml',
        colModel: [
		   { display: '标题',name: 'title',width: 257, sortable: false, align: 'left'}
		   ,{ display: '摘要',name: 'brief',width: 257, sortable: false, align: 'left'}
		   ,{ display: '创建时间',name: 'createDate',width: 138, sortable: true, align: 'left'}
		   ,{ display: '更新时间',name: 'updateDate',width: 138, sortable: true, align: 'left'}
		   ,{ display: '审核',name: 'audit',width: 60, sortable: true, align: 'left'}
		   ,{ display: '标签',name: 'mark',width: 257, sortable: true, align: 'left'}
		   ,{ display: '发布用户',name: 'userId',width: 229, sortable: true, align: 'left'}
		],      
		indexId:'id',//获取每行唯一标识值的属性名,(前缀row+该属性值)组成每行DOM元素的唯一标识,通过grid.getIndexId()获取.
		sortname: "id",//默认排序属性名
		sortorder: "desc",//默认排序方向
		autoload: true,//是否初始时加载数据
		showcheckbox: true,//是否显示checkbox
		usepager: true,//是否显示分页
		rowbinddata: false,//是否每行绑定对象.设置为true,可通过$(rowDom).data('rowData')取得该行的对象
        rowhandler: gridContextmenu,//右键菜单
		searchparam:searchparamsCall,//搜索参数,数组或键值对
		onRowDblclick:onRowDblclick//左键双击执行
    };
    
	//format
	

    //search params
    function searchparamsCall(){
		var params=$("#firstSearchForm").serializeArray();
     	return params;
	}
	
	//grid
    grid = $("#dataGrid").flexigrid(option);
    
    //validate    
	searchFormValidator=$("#firstSearchForm").validate({
		rules : {
				createDateStart:{dateCN:true}//1 创建时间
				,createDateEnd:{dateCN:true}//2 创建时间	
				,updateDateStart:{dateCN:true}//3 更新时间
				,updateDateEnd:{dateCN:true}//4 更新时间	
    	},
    	errorType: "bftip"
	});		

	//process createDate render
	$("#createDateStart,#createDateEnd").datepickerRange({startEl:'createDateStart',endEl:'createDateEnd'});		

	//process updateDate render
	$("#updateDateStart,#updateDateEnd").datepickerRange({startEl:'updateDateStart',endEl:'updateDateEnd'});							
	
    //variate
    config.inputUrl=ctx+'/demo/jfuseInfo/input.vhtml';    
    config.editUrl=ctx+'/demo/jfuseInfo/edit.vhtml';    
    config.deleteOutJsonUrl=ctx+'/demo/jfuseInfo/deleteOutJson.vhtml';   
    config.deleteOutJsonAllUrl=ctx+'/demo/jfuseInfo/deleteAllOutJson.vhtml';
});
var grid;
var searchFormValidator;
var config={
	baseTitle:"信息管理",
	inputUrl:null,
	editUrl:null,
	deleteOutJsonUrl:null,
	deleteOutJsonAllUrl:null
};
/******contenxtmenu*****/
var imgPath=ctx+"/resources/style/default/contextmenu/images/";
var menu = {
		width : 150
		,items : [
				{text : "刷新",icon : imgPath+"table_refresh.png",alias : "refresh",action : contextMenuClick}
				,{type: "splitLine" }
				,{text : "新增",icon :imgPath+"view.png",alias : "add",action :contextMenuClick}
				,{text : "编辑",icon : imgPath+"edit.png",alias : "edit",action : contextMenuClick}
				,{type: "splitLine" }
				,{text : "删除该项记录",icon : imgPath+"rowdelete.png",alias : "deleteCurrent",action : contextMenuClick}
				,{text : "删除所选记录",icon : imgPath+"rowdelete.png",alias : "deleteSels",action : contextMenuClick}
				]
	};
function contextMenuClick(target) {
	var id = $(target).attr("id").substr(3);
	var rowIdx = $(target).attr("seq");
	var cmd = this.data.alias;
	switch(cmd){	
		case 'add':
			var title=config.baseTitle+'->新增';
			newWinOpen({title:title});
			break;
		case 'edit':
			var title = config.baseTitle+'->编辑 (序号:' + rowIdx + ')';
			var url=goolov.addUrlParams(config.editUrl,"id="+id);
			editWinOpen( {title:title,url:url});
			break;
		case 'deleteCurrent':
			deleteOutJson(new Array(id));
		case 'deleteSels':
			delData();
			break;
		case 'refresh':
			refresh();
			break;
	}
};
function gridContextmenu(row) {
	$(row).contextmenu(menu);
} 	

/******searchForm validate check******/
function searchFormValidCheck(){
	searchFormValidator.form();
	if(!searchFormValidator.valid()){
 		var invalideNum=searchFormValidator.numberOfInvalids();
	    if(invalideNum>0){
	    	goolov.growl.success('有<font color=red> '+invalideNum+'</font> 个查询选项未填写正确!');
		    return false;
	    }
	}
	return true;
}
/******refresh grid *******/
function reloadGrid(setting){
	if(searchFormValidCheck()){
		grid.flexReload(setting?setting:{});
	}
}
/******refresh  *******/
function refresh(){
	reloadGrid();
}
/******reset clear *******/
function clear(){
	document.getElementById('firstSearchForm').reset();
	searchFormValidator.resetForm();
	reloadGrid({newp:1});
}
/******search*******/
function firstSearch(){
	reloadGrid({newp:1});
}
/******add data**********/
var newWin;
function newWinOpen(settings){
	if(!newWin){
		var title=config.baseTitle+'->新增';
		var url=config.inputUrl;
		newWin=new goolov.winbox({
			width:goolov.winWidth(650),
			height:goolov.winHeight(510),
			title:title,
			url:url
		});
	}
	newWin.open(settings);
}
function newWinClose(){
	newWin.close();
}
function newData(){
	newWinOpen();
}
/******edit data window**********/
var editWin;
function editWinOpen(settings){
		if(!editWin){
		editWin=new goolov.winbox({
			width:goolov.winWidth(650),
			height:goolov.winHeight(510)
		});
	}
	editWin.open(settings);
}
function editWinClose(){
	editWin.close();
}
function onRowDblclick(target){
	var id = $(target).attr("id").substr(3);
	var rowIdx=$(target).attr("seq");
	var title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(config.editUrl,"id="+id);
	editWinOpen({title:title,url:url});
}
function editData(){
	var ids=grid.getCheckedRows();
	var selCount=ids.length;
	if (selCount== 0) {
		goolov.growl.info('请选择需要修改的记录,或双击需要编辑的行.');
		return;
	}
	if(selCount>1){
		goolov.growl.info('一次只能选择修改一项记录.');
		return;
	}
	var id=ids[0];
	edit(id);
}
function edit(id){
	if(!id){
		goolov.growl.info('请选择需要修改的记录,或双击需要编辑的行.');
		return;
	}
	var rowtr=grid.getRowDom(id);//获取该ID的行元素.ID的行元素.
	var rowIdx=$(rowtr).attr("seq");
	var title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(config.editUrl,"id="+id);
	var opts={title:title,url:url};
	editWinOpen(opts);
}
/**********add row data**************/
function addRowData(row){
	var indexId=grid.getIndexId();
	var rowtr=grid.getRowDom(row[indexId]);////获取该ID的行元素.
	if (rowtr.length==0) {
		grid.flexAddRowData(row);		
	}else{
		grid.flexEditRowData(rowtr[0],row);
	}
} 
/******del data**********/
function delData(){
	var ids=grid.getCheckedRows();
	deleteOutJson(ids);
}
function del(id){
	if(!id){
		goolov.growl.info('当前选择无效!');
		return;
	}
	var ids=new Array(id);
	deleteOutJson(ids);
}
/******del data process**********/
function deleteOutJson(idsArray){
	if (!idsArray||!$.isArray(idsArray)) {
		goolov.growl.info('当前选择无效!');
		return;
	}
	if (idsArray.length==0) {
		goolov.growl.info('请选择需要删除的记录.');
		return;
	}
	var selCount=idsArray.length;
	var idsStr=idsArray.join(',');
	goolov.msgbox.confirm('删除确认','您确认删除这<span class="highlight">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){
			if(r){
				$.ajax({
					type : 'post',
					url : config.deleteOutJsonUrl,
					data : {id:idsStr},
					dataType:'json',
					beforeSend :function() {
						goolov.growl.waiting('正在删除中!请稍后...');
					},
					success : function(result) {
						goolov.growl.unwaiting();
						if (result&&result.success) {
							goolov.growl.success(result.message);
							refresh();
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
	});
}
/******del all data   *******/
function delAllData(){
		goolov.msgbox.confirm('删除确认','您确认删除所有记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
					type : 'get',
					url : config.deleteOutJsonAllUrl,
					dataType:'json',
					beforeSend :function() {
						goolov.growl.waiting('正在删除中!请稍后...');
					},
					success : function(result) {
						goolov.growl.unwaiting();
						if (result&&result.success) {
							goolov.growl.success(result.message);
							refresh();
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
	});
}
/******export excel*******/
function exportExcel(){
	var paramSerialize=grid.getParamsString();
	var exportExcelFileUrl=ctx+'/demo/jfuseInfo/exportExcelFile.vhtml';
	location.href=goolov.addUrlParams(exportExcelFileUrl,paramSerialize);
}
/******import importExcel**********/
var importExcelFormValidator;
var importExcelWin;
$(document).ready(function() {
	importExcelWin=$('#importExcelWin').window({
		title: config.baseTitle+'->导入Excel文件数据',
		width: 450,
		height: 300,
		modal: true,
		shadow: true,
		closed: true,
		collapsible:false,
		minimizable:false,
		maximizable:false
	});
	//表单验证
	importExcelFormValidator=$("#importExcelForm").validate({
		rules : {
		}
	});	
});
//打开导入Excel文件窗口
function importExcel(){
	importExcelWin.window('open');
}
//关闭导入Excel文件窗口
function importExcelWinClose(){
	importExcelWin.window('close');
	refresh();
}
/**
 * 导入excel文件提交处理.
 */
function importExcelSubmit(){
	$("#importExcelForm").ajaxSubmit({
		 type : 'post',
		 dataType:'html', 
		 url:ctx+'/demo/jfuseInfo/importExcelFileProcess.vhtml',
		 beforeSubmit:function(formData, jqForm, options) {
			    if(importExcelFormValidator.numberOfInvalids()>0){
				    return false;
			    }
			    goolov.growl.waiting('导入数据中...');
		 },
	     success:function(result, statusText, xhr, $form) {
	    	 	goolov.growl.unwaiting();
				goolov.msgbox.info('友情提示',result?result:"请求出现错误,请查看网络是否连接!");
		 },
		 error:function(request,status,errorThrown) {
			 goolov.growl.unwaiting();
			 goolov.msgbox.error();
		}
	}); 
}

