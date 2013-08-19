$(function(){
	//var mainheight = document.documentElement.clientHeight;
	var mainheight=$("#relGsysCodevalue-content").height();
	var w = $("#relGsysCodevalue-content").width() -3;
	var gridpm = 25+30+2; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm;
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/code/gsysCodevalueByGsysCode/listOutJson.vhtml',
        colModel: [
		   { display: 'name',name: 'name',width: 80, sortable: true, align: 'center'}
		   ,{ display: 'value',name: 'value',width: 170, sortable: true, align: 'center'}
		   ,{ display: '开发',name: 'descript',width: 256, sortable: true, align: 'center'}
		   //,{ display: 'gsysCode',name: 'gsysCode.',width: 120, sortable: false, align: 'center'}
		],      
 		sortname: "id",
		sortorder: "desc",
		searchparam:relGsysCodevalue_searchparamsCall,
		//title: '数据例表',
		minColToggle: 1, 
		showTableToggleBtn: false,
		autoload: false,
		resizable: false, 
		showcheckbox: true,
		usepager: true,
		indexId:'id',
		showseq:true,
		gridClass: "bbit-grid",
        rowhandler: relGsysCodevalue_gridContextmenu,
		rowbinddata: false,
		onRowDblclick:relGsysCodevalue_onRowDblclick
		//onrowchecked: callme
    };
    //search params
    function relGsysCodevalue_searchparamsCall(){
		var params=$("#relGsysCodevalue-searchForm").serializeArray();
     	return params;
	}
	//format
    relGsysCodevalue_grid = $("#relGsysCodevalue-dataGrid").flexigrid(option);
    var relGsysCodeId=$('#relGsysCodeId').val();
    relGsysCodevalue_inputUrl=ctx+'/system/code/gsysCodevalueByGsysCode/input.vhtml?relGsysCodeId='+relGsysCodeId;
    relGsysCodevalue_editUrl=ctx+'/system/code/gsysCodevalueByGsysCode/edit.vhtml?relGsysCodeId='+relGsysCodeId;
    relGsysCodevalue_deleteOutJsonUrl=ctx+'/system/code/gsysCodevalue/deleteOutJson.vhtml?relGsysCodeId='+relGsysCodeId;
    relGsysCodevalue_deleteOutJsonAllUrl=ctx+'/system/code/gsysCodevalueByGsysCode/deleteAllOutJson.vhtml?relGsysCodeId='+relGsysCodeId;
});
var relGsysCodevalue_grid;
var relGsysCodevalue_baseTitle="GsysCode管理->";
var relGsysCodevalue_inputUrl;
var relGsysCodevalue_editUrl;
var relGsysCodevalue_deleteOutJsonUrl;
var relGsysCodevalue_deleteOutJsonAllUrl;
/******contenxtmenu*****/
var menu = {
		width : 150,
		items : [ {
			text : "新增",
			icon : ctx+"/resources/style/default/contextmenu/images/view.png",
			alias : "contextmenu-add",
			action : relGsysCodevalue_gridContextmenuClick
		}, {
			text : "编辑",
			icon : ctx+"/resources/style/default/contextmenu/images/edit.png",
			alias : "contextmenu-edit",
			action : relGsysCodevalue_gridContextmenuClick
		},  {
			text : "删除所选记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "contextmenu-deleteSels",
			action : relGsysCodevalue_gridContextmenuClick
		},  {
			text : "删除所有记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "contextmenu-deleteAll",
			action : relGsysCodevalue_gridContextmenuClick
		},{
			text : "刷新",
			icon : ctx+"/resources/style/default/contextmenu/images/table_refresh.png",
			alias : "contextmenu-refresh",
			action : relGsysCodevalue_gridContextmenuClick
		}]
	};
function relGsysCodevalue_gridContextmenuClick(target) {
	var id = $(target).attr("id").substr(3);
	//var ch = $(target).attr("ch").substr(3);
	//var cell = ch.split("_FG$SP_");
	var rowIdx = $(target).attr("seq");
	var cmd = this.data.alias;
	switch(cmd){
		case 'contextmenu-add':
			relGsysCodevalue_openNewWin();
			break;
		case 'contextmenu-edit':
			var title=relGsysCodevalue_baseTitle+'->编辑 (序号:' + rowIdx + ')';
			var url=goolov.addUrlParams(editUrl,"id="+id);
			relGsysCodevalue_openEditWin( title,url);
			break;
		case 'contextmenu-deleteSels':
			relGsysCodevalue_delData();
			break;
		case 'contextmenu-deleteAll':
			relGsysCodevalue_delAllData();
			break;
		default:
			relGsysCodevalue_grid.flexReload();
	}
};
function relGsysCodevalue_gridContextmenu(row) {
	$(row).contextmenu(menu);
} 
/******add data window **********/
var relGsysCodevalue_newWin;
function relGsysCodevalue_newWinInit(){
	if(!relGsysCodevalue_newWin){
		relGsysCodevalue_newWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(330),
			url:inputUrl
			//modal:true
		});
	}
}
function relGsysCodevalue_newWinOpen(settings){
	relGsysCodevalue_newWinInit();
	relGsysCodevalue_newWin.open(settings);
}
function relGsysCodevalue_newWinClose(){
	relGsysCodevalue_newWin.close();
}
function relGsysCodevalue_newWinCloseAndRefresh(){
	relGsysCodevalue_newWinClose();
	relGsysCodevalue_refresh();
}
function relGsysCodevalue_newData(){
	var title=relGsysCodevalue_baseTitle+'->新增';
	relGsysCodevalue_newWinOpen({title:title});
}

/******edit data window**********/
var relGsysCodevalue_editWin;
function relGsysCodevalue_editWinInit(){
	if(!relGsysCodevalue_editWin){
		relGsysCodevalue_editWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(330)
		});
	}
}
function relGsysCodevalue_editWinOpen(settings){
	relGsysCodevalue_editWinInit();
	relGsysCodevalue_editWin.open(settings);
}
function relGsysCodevalue_editWinClose(){
	relGsysCodevalue_editWin.close();
}
function relGsysCodevalue_editWinCloseAndRefresh(){
	relGsysCodevalue_editWinClose();
	relGsysCodevalue_refresh();
}
function relGsysCodevalue_onRowDblclick(target){
	var id = $(target).attr("id").substr(3);
	var rowIdx=$(target).attr("seq");
	var title=baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(editUrl,"id="+id);
	relGsysCodevalue_editWinOpen({title:title,url:url});
}
function relGsysCodevalue_editData(){
	var ids=relGsysCodevalue_grid.getCheckedRows();
	var selCount=ids.length;
	if (selCount== 0) {
		goolov.growl.info('请先选择修改的记录,或双击需要编辑的行.');
		return;
	}
	if(selCount>1){
		goolov.growl.info('一次只能选择修改一项记录.');
		return;
	}
	var id=ids[0];
	var rowtr=$('#row' + id, relGsysCodevalue_grid)[0];
	var rowIdx=$(rowtr).attr("seq");
	var title=relGsysCodevalue_baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(relGsysCodevalue_editUrl,"id="+id);
	var opts={title:title,url:url};
	relGsysCodevalue_editWinOpen(opts);
}
/**********add row data**************/
function relGsysCodevalue_addRowData(row){
	var indexId=relGsysCodevalue_grid.getIndexId();
	var rowtr=$('#row' + row[indexId], relGsysCodevalue_grid);
	if (rowtr.length==0) {
		relGsysCodevalue_grid.flexAddRowData(row);		
	}else{
		relGsysCodevalue_grid.flexEditRowData(rowtr[0],row);
	}
}
/*******edit row data***********/
function relGsysCodevalue_editRowData(row){
	relGsysCodevalue_grid.flexEditRowData(row);
}
/******del data**********/
function relGsysCodevalue_delData(){
	var ids=relGsysCodevalue_grid.getCheckedRows();
	var selCount=ids.length;
	if (selCount== 0) {
		goolov.growl.info('请先选择删除的记录.');
		return;
	}
	var idsStr=ids.join(',');
	goolov.msgbox.confirm('删除确认','您确认删除这'+selCount+'项记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
					type : 'post',
					url : relGsysCodevalue_deleteOutJsonUrl,
					data : {id:idsStr},
					dataType:'json',
					beforeSend :function() {
						goolov.growl.waiting('正在删除中!请稍后...');
					},
					success : function(result) {
						goolov.growl.unwaiting();
						if (result&&result.success) {
							goolov.growl.success(result.message);
							relGsysCodevalue_refresh();
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
function relGsysCodevalue_delAllData(){
		goolov.msgbox.confirm('删除确认','您确认这删除所有记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
					type : 'get',
					url : relGsysCodevalue_deleteOutJsonAllUrl,
					dataType:'json',
					beforeSend :function() {
						goolov.growl.waiting('正在删除中!请稍后...');
					},
					success : function(result) {
						goolov.growl.unwaiting();
						if (result&&result.success) {
							goolov.growl.success(result.message);
							relGsysCodevalue_refresh();
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
function relGsysCodevalue_refresh(){
	relGsysCodevalue_grid.flexReload();
}
/******reset clear data *******/
function relGsysCodevalue_clear(){
	//$("form:first")[0].reset();
	document.getElementById('relGsysCodevalue-searchForm').reset();
	relGsysCodevalue_grid.flexReload({newp: 1});
}
/******search*******/
function relGsysCodevalue_firstSearch(){
	relGsysCodevalue_grid.flexReload();
}