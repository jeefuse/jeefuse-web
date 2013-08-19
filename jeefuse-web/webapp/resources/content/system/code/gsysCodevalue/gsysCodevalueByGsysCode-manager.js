$(function(){
	var w = $("#first-content").outerWidth(true);
	var mainheight = document.documentElement.clientHeight;
	var gridpm = 58; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm-$("#header").outerHeight(true);
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/code/gsysCodevalueByGsysCode/listOutJson.vhtml',
        colModel: [
		   { display: '属性名',name: 'name',width: 80, sortable: true, align: 'center'}
		   ,{ display: '属性值',name: 'value',width: 170, sortable: true, align: 'center'}
		   ,{ display: '描述',name: 'descript',width: 256, sortable: true, align: 'center'}
		   //,{ display: 'gsysCode',name: 'gsysCode.',width: 120, sortable: false, align: 'center'}
		],      
 		sortname: "name",
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
    var gsysCodeCid=$('#gsysCodeCid').val();
    inputUrl=ctx+'/system/code/gsysCodevalueByGsysCode/input.vhtml?gsysCode.cid='+gsysCodeCid;
    editUrl=ctx+'/system/code/gsysCodevalueByGsysCode/edit.vhtml?gsysCode.cid='+gsysCodeCid;
    deleteOutJsonUrl=ctx+'/system/code/gsysCodevalue/deleteOutJson.vhtml?gsysCode.cid='+gsysCodeCid;
    deleteOutJsonAllUrl=ctx+'/system/code/gsysCodevalueByGsysCode/deleteAllOutJson.vhtml?gsysCode.cid='+gsysCodeCid;

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
	//var ch = $(target).attr("ch").substr(3);
	//var cell = ch.split("_FG$SP_");
	var rowIdx = $(target).attr("seq");
	var cmd = this.data.alias;
	switch(cmd){
		case 'contextmenu-add':
			var title=baseTitle+'->新增';
			openNewWin({title:title});
			break;
		case 'contextmenu-edit':
			var title=baseTitle+'->编辑 (序号:' + rowIdx + ')';
			var url=goolov.addUrlParams(editUrl,"id="+id);
			openEditWin({title:title,url:url});
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
/******add data window **********/
var newWin;
function initNewWin(){
	if(!newWin){
		newWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(330),
			url:inputUrl
			//modal:true
		});
	}
}
function openNewWin(settings){
	initNewWin();
	newWin.open(settings);
}
function closeNewWin(){
	newWin.close();
}
function closeNewWinAndRefresh(){
	closeNewWin();
	refresh();
}
function newData(){
	var title=baseTitle+'->新增';
	openNewWin({title:title});
}

/******edit data window**********/
var editWin;
function initEditWin(){
	if(!editWin){
		editWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(330)
			//modal:true
		});
	}
}
function openEditWin(settings){
	initEditWin();
	editWin.open(settings);
}
function closeEditWin(){
	editWin.close();
}
function closeEditWinAndRefresh(){
	closeEditWin();
	refresh();
}
function onRowDblclick(target){
	var id = $(target).attr("id").substr(3);
	var rowIdx=$(target).attr("seq");
	var title=baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(editUrl,"id="+id);
	openEditWin({title:title,url:url});
}
function editData(){
	var ids=grid.getCheckedRows();
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
	var rowtr=$('#row' + id, grid)[0];
	var rowIdx=$(rowtr).attr("seq");
	var title=baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(editUrl,"id="+id);
	var opts={title:title,url:url};
	openEditWin(opts);
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
		goolov.growl.info('请先选择删除的记录.');
		return;
	}
	var idsStr=ids.join(',');
	goolov.msgbox.confirm('删除确认','您确认删除这'+selCount+'项记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
					type : 'post',
					url : deleteOutJsonUrl,
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
	//$("form:first")[0].reset();
	document.getElementById('firstSearchForm').reset();
	grid.flexReload({newp: 1});
}
/******search*******/
function firstSearch(){
	grid.flexReload();
}