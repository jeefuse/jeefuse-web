$(function(){
	var w = $("#first-content").outerWidth(true);
	var mainheight = document.documentElement.clientHeight;
	var gridpm = 58; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm-$("#header").outerHeight(true);
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/code/gsysCode/listOutJson.vhtml',
        colModel: [
           { display: '操作',width: 100, sortable: true, align: 'left',process:formatOperator}         
		   ,{ display: '编号',name: 'cid',width: 116, sortable: true, align: 'left'}
		   ,{ display: '编码类名',name: 'name',width: 256, sortable: true, align: 'left'}
		   ,{ display: '描述',name: 'descript',width: 256, sortable: false, align: 'left'}
		   ,{ display: '类别',name: 'kind',width: 60, sortable: true, align: 'left',process:formatCodeOperateKind}
		],      
		indexId:'cid',
		sortname: "cid",
		sortorder: "desc",
		searchparam:searchparamsCall,
		//title: '数据例表',
		minColToggle: 1, 
		showTableToggleBtn: false,
		autoload: true,
		resizable: false, 
		showcheckbox: true,
		usepager: true,
		showseq:true,
		gridClass: "bbit-grid",
        rowhandler: gridContextmenu,
		rowbinddata: false,
		onRowDblclick:onRowDblclick
    };
    //search params
    function searchparamsCall(){
		var params=$("#firstSearchForm").serializeArray();
     	return params;
	}
    //format operator
    function formatOperator(text,row){
    	return "<a href='javascript:relGsysCodeValueManage(\""+row.cid+"\",\""+row.name+"\");' class='icon-app'>编码值管理</a>";
    }
	//format
	function formatCodeOperateKind(text, row) {
		return CodeOperateKindJson[text];
	}

    grid = $("#dataGrid").flexigrid(option);
    inputUrl=ctx+'/system/code/gsysCode/input.vhtml';
    editUrl=ctx+'/system/code/gsysCode/edit.vhtml';
    deleteOutJsonUrl=ctx+'/system/code/gsysCode/deleteOutJson.vhtml';
    deleteOutJsonAllUrl=ctx+'/system/code/gsysCode/deleteAllOutJson.vhtml';
});
var grid;
var baseTitle="GsysCode管理";
var inputUrl;
var editUrl;
var deleteOutJsonUrl;
var deleteOutJsonAllUrl;
/******contenxtmenu*****/
var menu = {
		width : 150,
		items : [ {
			text : "新增",
			icon : ctx+"/resources/style/default/contextmenu/images/view.png",
			alias : "contextmenu-add",
			action : contextmenuClick
		}, {
			text : "编辑",
			icon : ctx+"/resources/style/default/contextmenu/images/edit.png",
			alias : "contextmenu-edit",
			action : contextmenuClick
		},  {
			text : "删除所选记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "contextmenu-deleteSels",
			action : contextmenuClick
		},  {
			text : "删除所有记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "contextmenu-deleteAll",
			action : contextmenuClick
		},{
			text : "刷新",
			icon : ctx+"/resources/style/default/contextmenu/images/table_refresh.png",
			alias : "contextmenu-refresh",
			action : contextmenuClick
		}]
	};
function contextmenuClick(target) {
	var id = $(target).attr("id").substr(3);
	var rowIdx = $(target).attr("seq");
	var cmd = this.data.alias;
	switch(cmd){
		case 'contextmenu-add':
			var title=baseTitle+'->新增';
			newWinOpen({title:title});
			break;
		case 'contextmenu-edit':
			var title = baseTitle+'->编辑 (序号:' + rowIdx + ')';
			var url=goolov.addUrlParams(editUrl,"id="+id);
			editWinOpen( {title:title,url:url});
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
/******add data**********/
var newWin;
function newWinInit(){
	if(!newWin){
		var title=baseTitle+'->新增';
		var url=inputUrl;
		newWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(390),
			title:title,
			url:url
		});
	}
}
function newWinOpen(settings){
	newWinInit();
	newWin.open(settings);
}
function newWinClose(){
	newWin.close();
}
function newWinCloseAndRefresh(){
	newWinClose();
	refresh();
}
function newData(){
	newWinOpen();
}
/******edit data window**********/
var editWin;
function editWinInit(){
	if(!editWin){
		editWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(390)
		});
	}
}
function editWinOpen(settings){
	editWinInit();
	editWin.open(settings);
}
function editWinClose(){
	editWin.close();
}
function editWinCloseAndRefresh(){
	editWinClose();
	refresh();
}
function onRowDblclick(target){
	var id = $(target).attr("id").substr(3);
	var rowIdx=$(target).attr("seq");
	var title=baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(editUrl,"id="+id);
	editWinOpen({title:title,url:url});
}
function editData(){
	var ids=grid.getCheckedRows();
	var selCount=ids.length;
	if (selCount== 0) {
		goolov.growl.info('请先选择需要修改的记录,或双击需要编辑的行.');
		return;
	}
	if(selCount>1){
		goolov.growl.info('一次只能选择修改一项记录.');
		return;
	}
	var id=ids[0];
	var rowtr=$('#row' + id, grid)[0];
	var rowIdx=$(rowtr).attr("seq");
	var title=baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(editUrl,"id="+ids[0]);
	var opts={title:title,url:url};
	editWinOpen(opts);
}
/**********add row data**************/
function addRowData(row){
	var indexId=grid.getIndexId();
	var rowtr=$('#row' + row[indexId], grid);
	if (rowtr.length==0) {
		grid.flexAddRowData(row);		
	}else{
		grid.flexEditRowData(rowtr[0],row);
	}
}
/*******edit row data***********/
function editRowData(row){
	grid.flexEditRowData(row);
}
/******del data**********/
function delData(){
	var ids=grid.getCheckedRows();
	var selCount=ids.length;
	if (selCount== 0) {
		//goolov.msgbox.show('请先选择需要删除的记录.');
		goolov.growl.info('请先选择需要删除的记录.');
		return;
	}
	goolov.msgbox.confirm('删除确认','您确认删除这<span class="highlight ">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
					type : 'post',
					url : deleteOutJsonUrl,
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
					url : deleteOutJsonAllUrl,
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
/******refresh data *******/
function refresh(){
	grid.flexReload();
}
/******reset clear data *******/
function clear(){
	document.getElementById('firstSearchForm').reset();
	grid.flexReload({newp:1});
}
/******search*******/
function firstSearch(){
	grid.flexReload();
}
/******export excel*******/
function exportExcel(){
	var paramSerialize=grid.getParamsString();
	var exportExcelFileUrl=ctx+'/system/code/gsysCode/exportExcelFile.vhtml';
	location.href=goolov.addUrlParams(exportExcelFileUrl,paramSerialize);
}
/******import importExcel**********/
var importExcelWin;
function importExcelWinInit(){
	if(!importExcelWin){
		importExcelWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(390),
			url:ctx+'/system/code/gsysCode/importExcelFile.vhtml'
		});
	}
}
function importExcelWinOpen(settings){
	importExcelWinInit();
	importExcelWin.open(settings);
}
function importExcelWinClose(){
	importExcelWin.close();
}
function importExcelWinCloseAndRefresh(){
	importExcelWinClose();
	refresh();
}
function importExcel(){
	var title=baseTitle+'->导入Excel文件数据';
	importExcelWinOpen({title:title});
}
/*******rel GsysCodevalue manager**********/
var relGsysCodeValueWin;
function relGsysCodeValueWinInit(){
	if(!relGsysCodeValueWin){
		relGsysCodeValueWin=new goolov.winbox({
			width:goolov.winWidth(750),
			height:goolov.winHeight(450),
			modal:true
		});
	}
}
function relGsysCodeValueWinOpen(settings){
	relGsysCodeValueWinInit();
	relGsysCodeValueWin.open(settings);
}
function relGsysCodeValueWinClose(){
	relGsysCodeValueWin.close();
}
function relGsysCodeValueManage(id,name){
	var title=baseTitle+'->编码值('+name+')->管理';
	var url=ctx+'/system/code/gsysCodevalueByGsysCode/manage.vhtml?gsysCode.cid='+id;
	relGsysCodeValueWinOpen({title:title,url:url});
}
