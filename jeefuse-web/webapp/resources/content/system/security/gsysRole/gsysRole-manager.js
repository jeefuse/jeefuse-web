$(function(){
	var w = $("#first-content").outerWidth(true);
	var mainheight = document.documentElement.clientHeight;
	var gridpm = 58; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm-$("#header").outerHeight(true);
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/security/gsysRole/listOutJson.vhtml',
        colModel: [
		   { display: '名称',name: 'name',width: 140, sortable: true, align: 'left'}
		   ,{ display: '显示名称',name: 'displayName',width: 140, sortable: true, align: 'left'}
		   ,{ display: '描述',name: 'descript',width: 256, sortable: true, align: 'left'}
		],      
 		sortname: "id",
		sortorder: "desc",
		searchparam:searchparamsCall,
		//title: '数据例表',
		minColToggle: 1, 
		showTableToggleBtn: false,
		autoload: true,
		resizable: false, 
		showcheckbox: true,
		usepager: true,
		indexId:'id',
		showseq:true,
        rowhandler: gridContextmenu,
		rowbinddata: false,
		onRowDblclick:onRowDblclick
		//onrowchecked: callme
    };
    //search params
    function searchparamsCall(){
		var params=$("#firstSearchForm").serializeArray();
     	return params;
	}
	//format
	
    grid = $("#dataGrid").flexigrid(option);
	
	newWin=$('#new-win').window({
   		width:goolov.winWidth(560),
		height:goolov.winHeight(460),
		closed:true,
		minimizable:false,
		maximizable:false,
		resizable:false
		//modal:true
	});
	editWin=$('#edit-win').window({
		width:goolov.winWidth(560),
		height:goolov.winHeight(460),
		closed:true,
		minimizable:false,
		maximizable:false,
		resizable:false
		//modal:true
	});
});
var grid;
var config={
		inputUrl:ctx+'/system/security/gsysRole/edit.vhtml'
};
/******contenxtmenu*****/
var menu = {
		width : 150,
		items : [ {
			text : "新增",
			icon : ctx+"/resources/style/default/contextmenu/images/view.png",
			alias : "contextmenu-add",
			action : gridContextmenuClick
		}, {
			text : "编辑",
			icon : ctx+"/resources/style/default/contextmenu/images/edit.png",
			alias : "contextmenu-edit",
			action : gridContextmenuClick
		},  {
			text : "删除所选记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "contextmenu-deleteSels",
			action : gridContextmenuClick
		},  {
			text : "删除所有记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "contextmenu-deleteAll",
			action : gridContextmenuClick
		},{
			text : "刷新",
			icon : ctx+"/resources/style/default/contextmenu/images/table_refresh.png",
			alias : "contextmenu-refresh",
			action : gridContextmenuClick
		}]
	};
function gridContextmenuClick(target) {
	var id = $(target).attr("id").substr(3);
	var rowIdx = $(target).attr("seq");
	var cmd = this.data.alias;
	switch(cmd){
		case 'contextmenu-add':
			openNewWin();
			break;
		case 'contextmenu-edit':
			var title = 'GsysResource管理>编辑 (序号:' + rowIdx + ')';
			var url=ctx+'/system/security/gsysRole/edit.vhtml?id='+id;
			openEditWin( title,url);
			break;
		case 'contextmenu-deleteSels':
			delData();
			break;
		case 'contextmenu-deleteAll':
			delAllData();
			break;
		default:
			grid.flexReload();
	}
};
function gridContextmenu(row) {
	$(row).contextmenu(menu);
} 
/******Add new data window  *******/
var newWin;
function newData(){
	openNewWin();
}
function openNewWin(title,url){
	newWin.window({zIndex:$.fn.window.defaults.zIndex++});
	newWin.window('open');
	newWin.window('setTitle',title?title:'GsysRole管理>新增');
	goolov.loadIFrame("new-win-content",url?url:ctx+'/system/security/gsysRole/edit.vhtml');
//	var newWin=new goolov.winbox({
//		width:goolov.winWidth(580),
//		height:goolov.winHeight(390),
//		url:config.inputUrl
//		//modal:true
//	});
//	newWin.open({title : title?title:'GsysRole管理>新增'});
}
function closeNewWin(){
	newWin.window('close');
}
function closeNewWinAndRefresh(){
	closeNewWin();
	refresh();
}

/******Edit data window  *******/
var editWin;
function openEditWin(title,url){
	editWin.window({zIndex:$.fn.window.defaults.zIndex++});
	editWin.window('open');
	editWin.window('setTitle',title);
	goolov.loadIFrame("edit-win-content",url);
}
function closeEditWin(){
	editWin.window('close');
}
function closeEditWinAndRefresh(){
	closeEditWin();
	refresh();
}

function onRowDblclick(target){
	var id = $(target).attr("id").substr(3);
	var rowIdx=$(target).attr("seq");
	var title='GsysRole管理>编辑 (序号:'+rowIdx+')';
	var url=ctx+'/system/security/gsysRole/edit.vhtml?id='+id;
	openEditWin(title,url);
}

function editData(){
	var ids=grid.getCheckedRows();
	var selCount=ids.length;
	if (selCount== 0) {
		goolov.msgbox.show('请先选择修改的记录,或双击需要编辑的行.');
		return;
	}
	if(selCount>1){
		goolov.msgbox.show('一次只能选择修改一项记录.');
		return;
	}
	var id=ids[0];
	var rowtr=$('#row' + id, grid)[0];
	var rowIdx=$(rowtr).attr("seq");
	var title='GsysRole管理>编辑 (序号:'+rowIdx+')';
	var url=ctx+'/system/security/gsysRole/edit.vhtml?id='+id;
	openEditWin(title,url);
}
/******del data   *******/
function delData(){
	var ids=grid.getCheckedRows();
	var selCount=ids.length;
	if (selCount== 0) {
		goolov.msgbox.show('请先选择删除的记录.');
		return;
	}
	goolov.msgbox.confirm('删除确认','您确认删除这'+selCount+'项记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
					type : 'post',
					url : ctx+'/system/security/gsysRole/deleteOutJson.vhtml',
					data : {id:ids.join(',')},
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
		goolov.msgbox.confirm('删除确认','您确认这删除所有记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
					type : 'get',
					url : ctx+'/system/security/gsysRole/deleteAllOutJson.vhtml',
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
/******add row data   *******/
function addRowData(row){
	var indexId=grid.getIndexId();
	var rowtr=$('#row' + row[indexId], grid);
	if (rowtr.length==0) {
		grid.flexAddRowData(row);		
	}else{
		grid.flexEditRowData(rowtr[0],row);
	}
}
/******edit row data  *******/
function editRowData(row){
	grid.flexEditRowData(row);
}
/******refresh data *******/
function refresh(){
	grid.flexReload();
}
/******reset clear data *******/
function clear(){
	//$("form:first")[0].reset();
	document.getElementById('firstSearchForm').reset();
	grid.flexReload({newp: 1});
}
/******search*******/
function firstSearch(){
	grid.flexReload();
}
/******export excel*******/
function exportExcel(){
	var paramSerialize=grid.getParamsString();
	location.href=ctx+'/system/security/gsysRole/exportExcelFile.vhtml?'+paramSerialize;
}

/******import importExcel**********/
var importExcelWin;
function initImportExcelWin(){
	if(!importExcelWin){
		importExcelWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(390),
			url:ctx+'/system/security/gsysRole/importExcelFile.vhtml'
			//modal:true
		});
	}
}
function openImportExcelWin(settings){
	initImportExcelWin();
	importExcelWin.open(settings);
}
function closeImportExcelWin(){
	importExcelWin.close();
}
function closeImportExcelWinAndRefresh(){
	closeImportExcelWin();
	refresh();
}
function importExcel(){
	var title='GsysRole 导入Excel文件数据';
	openImportExcelWin({title:title});
}