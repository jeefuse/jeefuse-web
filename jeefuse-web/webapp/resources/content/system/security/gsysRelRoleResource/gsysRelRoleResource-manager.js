$(function(){
	var mainheight = document.documentElement.clientHeight;
	//var mainheight=$("#first-box").height();
	var w = $("#first-content").width() -3;
	var gridpm = 80; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm-$("#first-toolbar").height()-$("#first-search").height();
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/security/gsysRelRoleResource/listOutJson.vhtml',
        colModel: [
		  { display: 'gsysRole',name: 'gsysRole.',width: 120, sortable: false, align: 'center'}
		  ,{ display: 'gsysResource',name: 'gsysResource.',width: 120, sortable: false, align: 'center'}
		],      
 		errormsg: 'error occur',
		sortname: "id",
		sortorder: "desc",
		//qop: "LIKE",//搜索的操作符
		searchparam:searchparamsCall,
		usepager: true,
		//title: '用户数据例表',
		pagestat: '显示记录从{from}到{to},总数 {total} 条',
		useRp: true,
		rp: 15,
		rpOptions: [15, 25, 40, 60, 80, 100], 
		nomsg: '没有符合条件的记录存在',
		minColToggle: 1, 
		showTableToggleBtn: true,
		autoload: true,
		resizable: false, 
		procmsg: '加载中, 请稍等 ...',
		hideOnSubmit: true, 
		blockOpacity: 0.5,
		showcheckbox: true,
		indexId:'id',
		showseq:true,
		seqdisplayName:'序号',
		gridClass: "bbit-grid",
       // rowhandler: contextmenu,
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
		height:goolov.winHeight(390),
		closed:true,
		minimizable:false,
		maximizable:false,
		resizable:false
		//modal:true
	});
	editWin=$('#edit-win').window({
		width:goolov.winWidth(560),
		height:goolov.winHeight(280),
		closed:true,
		minimizable:false,
		maximizable:false,
		resizable:false
		//modal:true
	});
});
var grid;
var newWin;
var editWin;

function onRowDblclick(target){
	var id = $(target).attr("id").substr(3);
	editWin.window({zIndex:$.fn.window.defaults.zIndex++});
	editWin.window('open');
	var rowIdx=$(target).attr("seq");
	editWin.window('setTitle','GsysRelRoleResource管理>编辑 (序号:'+rowIdx+')');
	loadingFrame("edit-win-content","edit-win-iframe",ctx+'/system/security/gsysRelRoleResource/edit.vhtml?id='+id);
}
function newData(){
	newWin.window({zIndex:$.fn.window.defaults.zIndex++});
	newWin.window('open');
	newWin.window('setTitle','GsysRelRoleResource管理>新增');
	loadingFrame("new-win-content","new-win-iframe",ctx+'/system/security/gsysRelRoleResource/input.vhtml');
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
	editWin.window({zIndex:$.fn.window.defaults.zIndex++});
	editWin.window('open');
	editWin.window('setTitle','GsysRelRoleResource管理>编辑 (序号:'+rowIdx+')');
	loadingFrame("edit-win-content","edit-win-iframe",ctx+'/system/security/gsysRelRoleResource/edit.vhtml?id='+ids[0]);
}
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
					url : ctx+'/system/security/gsysRelRoleResource/deleteOutJson.vhtml',
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
function delAllData(){
		goolov.msgbox.confirm('删除确认','您确认这删除所有记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
					type : 'get',
					url : ctx+'/system/security/gsysRelRoleResource/deleteAllOutJson.vhtml',
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
function addRowData(row){
	var indexId=grid.getIndexId();
	var rowtr=$('#row' + row[indexId], grid);
	if (rowtr.length==0) {
		grid.flexAddRowData(row);		
	}else{
		grid.flexEditRowData(rowtr[0],row);
	}
}
function editRowData(row){
	grid.flexEditRowData(row);
}
function refresh(){
	grid.flexReload();
}
function clear(){
	//$("form:first")[0].reset();
	document.getElementById('firstSearchForm').reset();
	grid.flexReload({newp: 1});
}
function firstSearch(){
	grid.flexReload();
}
function closeNewWin(){
	newWin.window('close');
}
function closeNewWinAndRefresh(){
	closeNewWin();
	refresh();
}
function closeEditWin(){
	editWin.window('close');
}
function closeEditWinAndRefresh(){
	closeEditWin();
	refresh();
}
function exportExcel(){
	location.href=ctx+'/system/security/gsysRelRoleResource/exportExcelFile.vhtml';
}
var importExcelWin;
function importExcel(){
	if(!importExcelWin){
		importExcelWin=$('#importExcelWin').window({
			width:goolov.winWidth(560),
			height:goolov.winHeight(280),
			closed:true,
			minimizable:false,
			maximizable:false,
			resizable:false
			//modal:true
		});
	}
	importExcelWin.window({zIndex:$.fn.window.defaults.zIndex++});
	importExcelWin.window('open');
	importExcelWin.window('setTitle','GsysRelRoleResource 导入Excel文件数据');
	loadingFrame("importExcelWinContent","importExcelWinContentIframe",ctx+'/system/security/gsysRelRoleResource/importExcelFile.vhtml');
}
function closeImportExcel(){
	importExcelWin.window('close');
}
function closeImportExcelWinAndRefresh(){
	closeImportExcel();
	refresh();
}