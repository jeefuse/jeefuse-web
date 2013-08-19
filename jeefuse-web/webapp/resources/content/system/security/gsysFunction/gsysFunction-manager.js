$(function(){
	$('#header').height($('#header').outerHeight(true)+2);
	$('#container').layout({});
	//var w = $("#first-content").width()-2;
	var w = $("#first-content").outerWidth(true);
	var gridpm = 58; //GridHead，toolbar,footer,gridmargin
	//var mainheight = document.documentElement.clientHeight;
	//var h = mainheight - gridpm-$("#header").outerHeight(true);
	var h=$("#center").height()-gridpm;
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/security/gsysFunction/listOutJson.vhtml',
        //url: ctx+'/system/security/gsysFunction/listTreeGridOutJson.vhtml',
        colModel: [
            { display: '权限名称',name: 'name',width: 200, sortable: true, align: 'left',process:formatName}
		   ,{ display: '权限标志',name: 'value',width: 135, sortable: true, align: 'left'}
//		   ,{ display: '描述',name: 'descript',width: 256, sortable: true, align: 'left'}
		   ,{ display: '权限类型',name: 'type',width: 60, sortable: true, align: 'left',process:formatFunctionType}
		   ,{ display: 'url',name: 'url',width: 256, sortable: true, align: 'left'}
//		   ,{ display: '上级',name: 'parentName',width: 60, sortable: true, align: 'left'}
		   ,{ display: '是否有效',name: 'validStatus',width: 50, sortable: true, align: 'left',process:formatValidStatus}
		   ,{ display: '排序',name: 'sortNum',width: 60, sortable: true, align: 'left'}
		   ,{ display: '层次代码',name: 'layerCode',width: 80, sortable: true, align: 'left'}
		],      
		indexId:'id',
		sortname: "layerCode",
		sortorder: "asc",
		searchparam:searchparamsCall,
		autoload: true,
		showcheckbox: true,
		usepager: true,
		showseq:true,
        rowhandler: gridContextmenu,
		rowbinddata: false,
		onRowDblclick:onRowDblclick,
		nowrap:false
		//tree:true,
		//treeFieldName:'displayName',
		//iconspath:ctx+"/resources/style/default/tree/images/"
		//onrowchecked: callme
    };

    //search params
    function searchparamsCall(){
		var params=$("#firstSearchForm").serializeArray();
     	return params;
	}
	//format
	function formatFunctionType(value, row) {
		return FunctionTypeJson[value];
	}
	function formatValidStatus(value,row){
		return InvalidTypeJson[value];
	}
	function formatName(value,row){
		var html='<div class="v-brief-wrap">'+
					'<div class="v-title">'+value+'</div>'+
					'<div class="v-intro">'+(row.descript?row.descript:"&nbsp;")+'</div>'+
				 '</div>';
		return html;
	}
	//grid
    grid = $("#dataGrid").flexigrid(option);
	//cate tree 
   loadCategoryTree();
});
var grid;
var config={
		inputUrl:ctx+'/system/security/gsysFunction/input.vhtml'
};
/******grid contenxt menu process*****/
function gridContextmenu(row) {
	$(row).contextmenu(menu);
} 
function gridContextmenuClick(target,cmd) {
	var domId=$(target).attr("id");
	var id = domId.substr(3);
	//var ch = $(target).attr("ch").substr(3);
	//var cell = ch.split("_FG$SP_");
	var rowIdx = $(target).attr("seq");
	//var cmd = this.data.alias;
	switch(cmd){
		case 'add':
			var title = 'GsysFunction管理>新增';
			openNewWin({title : title});
			break;
		case 'edit':
			var title = 'GsysFunction管理>编辑 (序号:' + rowIdx + ')';
			var url = ctx + '/system/security/gsysFunction/edit.vhtml?id=' + id;
			openEditWin({title : title,url : url});
			break;
		case 'deleteCurrent':
			deleteOutJson(new Array(id));
			break;
		case 'deleteCurrentAndDescendant':
			deleteDescendantOutJson(new Array(id));
			break;
		case 'deleteSels':
			var ids=grid.getCheckedRows();
			deleteOutJson(ids);
			break;
		case 'deleteDecendant':
			var ids=grid.getCheckedRows();
			deleteDescendantOutJson(ids);
			break;
		case 'deleteAll':
			delAllData();
			break;
		default:
			grid.flexReload();
			break;
	}
};

/******category tree ***************/
function loadCategoryTree(){
	var url=ctx+'/system/security/gsysFunction/listTreeOutJson.vhtml';
    var options = { url:url,onnodeclick:treeNodeClick,/*rowhandler:treeRowHandler,*/showcheck: false,iconspath:ctx+"/resources/style/default/tree/images/",theme: "bbit-tree-lines"};
    $('#firstTree').ajaxTree(options);
}
function treeNodeClick(item) {
    if(!item.id||'root'==item.id){
    	$("#parentId").val('');
    }else{
    	$("#parentId").val(item.id);
    }
	grid.flexReload();
}
/******category tree context menu************/
var treeRowDomIdPrefix="firstTree_";
function treeRowHandler(row) {
	var domId = $(row).attr("id");
	if (!domId || domId.indexOf(treeRowDomIdPrefix) == -1)
		return;
	$(row).contextmenu(menu);
}
function treeContextmenuClick(target,cmd) {
	var domId=$(target).attr("id");
	var id = domId.substring("firstTree_".length);
	var tpath=$(target).attr("tpath");
	var item=$('#firstTree').getTreeViewItem(tpath);
	switch(cmd){
		case 'add':
			var title = 'GsysFunction管理>新增';
			var url=ctx+'/system/security/gsysFunction/input.vhtml?parentId='+id;
			openNewWin({title : title,url:url});
			break;
		case 'edit':
			if (!id || id == '') {
				goolov.growl.info('请您选择需要编辑的记录!');
			}
			var title = 'GsysFunction管理>编辑'+(item?"("+item.text+")":"");
			var url = ctx + '/system/security/gsysFunction/edit.vhtml?id=' + id;
			openEditWin({title : title,url : url});
			break;
		case 'deleteCurrent':
			deleteOutJson(new Array(id));
			break;
		case 'deleteCurrentAndDescendant':
			deleteDescendantOutJson(new Array(id));
		case 'deleteAll':
			delAllData();
			break;
		default:
			loadCategoryTree();
	}
};
/******context menu*****/
var imgPath=ctx+"/resources/style/default/contextmenu/images/";
var menu = {
		width : 150
		,items : [{text : "新增",icon :imgPath+"view.png",alias : "add",action :contextMenuClick}
				,{text : "编辑",icon : imgPath+"edit.png",alias : "edit",action : contextMenuClick}
				,{type: "splitLine" }
				,{text : "删除该项记录",icon : imgPath+"rowdelete.png",alias : "deleteCurrent",action : contextMenuClick}
				,{text : "删除该项及子节点",icon : imgPath+"rowdelete.png",alias : "deleteCurrentAndDescendant",action : contextMenuClick}
				,{text : "删除所选记录",icon : imgPath+"rowdelete.png",alias : "deleteSels",action : contextMenuClick}
				,{text : "删除所选及子节点",icon : imgPath+"rowdelete.png",alias : "deleteDescendant",action : contextMenuClick}
				,{text : "删除所有记录",icon : imgPath+"rowdelete.png",alias : "deleteAll",action : contextMenuClick}
				,{type: "splitLine" }
				,{text : "刷新",icon : imgPath+"table_refresh.png",alias : "refresh",action : contextMenuClick
				}]
		, onShow: menuApplyRule
};
function contextMenuClick(target){
	var domId=$(target).attr("id");
	var cmd = this.data.alias;
	if(domId.indexOf('row')!=-1){//process for grid
		gridContextmenuClick(target,cmd);
	}else if(domId.indexOf(treeRowDomIdPrefix)!=-1){//process for tree
		treeContextmenuClick(target,cmd);
	}
}
function menuApplyRule(menu) {
	var domId=this.id;
	if(domId.indexOf("firstTree_")!=-1){//process for tree
 		var id = this.id.substring(treeRowDomIdPrefix.length);
		if(!id||id==''){
			menu.applyrule({
						disable : true,
						items : ["edit", "deleteCurrent", "deleteCurrentAndDescendant","deleteSels","deleteDescendant"]
			});
		}else{
			 menu.applyrule({ 
				 disable: true,
				 items: ["deleteSels","deleteDescendant"]
			}); 
		}
	}else if(domId.indexOf('row')!=-1){//process for grid
		menu.applyrule({ 
				 disable: true,
				 items: []
		}); 
	}else{//process for default
		menu.applyrule({ 
				 disable: true,
				 items: ["edit", "deleteCurrent", "deleteCurrentAndDescendant","deleteSels","deleteDescendant"]
		}); 
	}
} 
/******refresh*****/
function refresh(){
	grid.flexReload();
	loadCategoryTree();
}
function clear(){
	document.getElementById('firstSearchForm').reset();
	grid.flexReload({newp: 1});
}
function firstSearch(){
	grid.flexReload();
}
/******add data window**********/
var newWin;
function initNewWin(){
	if(!newWin){
		newWin=new goolov.winbox({
			width:goolov.winWidth(580),
			height:goolov.winHeight(390),
			url:config.inputUrl
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
	var title='GsysFunction管理>新增';
	var parentId=$('#parentId').val();
	var url=goolov.addUrlParams(config.inputUrl,"parentId="+parentId);
	openNewWin({title : title,url:url});
}

/******edit data window**********/
var editWin;
function initEditWin(){
	if(!editWin){
		editWin=new goolov.winbox({
			width:goolov.winWidth(580),
			height:goolov.winHeight(390)
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
	var title='GsysFunction管理>编辑 (序号:'+rowIdx+')';
	var url=ctx+'/system/security/gsysFunction/edit.vhtml?id='+id;
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
	var title='GsysFunction管理>编辑 (序号:'+rowIdx+')';
	var url=ctx+'/system/security/gsysFunction/edit.vhtml?id='+id;
	var opts={title:title,url:url};
	openEditWin(opts);
}
/******del data with tree**********/
function delData(){
	var ids=grid.getCheckedRows();
	deleteOutJson(ids);
}
/*******del data***********/
function deleteOutJson(idsArray){
	if (!idsArray||idsArray.length==0) {
		goolov.growl.info('请选择需要删除的记录.');
		return;
	}
	var selCount=idsArray.length;
	var idsStr=idsArray.join(',');
	goolov.msgbox.confirm('删除确认','您确认删除这<span class="highlight ">'+selCount+'</span>项记录吗?删除后将不可恢复!',function(r){
			if(r){
				$.ajax({
					type : 'post',
					url : ctx+'/system/security/gsysFunction/deleteOutJson.vhtml',
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
/*******del deleteDescendant***/
function delDescendantData(){
	var ids=grid.getCheckedRows();
	deleteDescendantOutJson(ids);
}
function deleteDescendantOutJson(idsArray){
	if (!idsArray||idsArray.length==0) {
		goolov.growl.info('请选择需要删除的记录.');
		return;
	}
	var selCount=idsArray.length;
	var idsStr=idsArray.join(',');
	goolov.msgbox.confirm('删除确认','您确认删除这<span class="highlight ">'+selCount+'</span>项记录及其后代记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
				type : 'post',
				url : ctx+'/system/security/gsysFunction/deleteDescendantOutJson.vhtml',
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
/*******del all data**********/
function delAllData(){
		goolov.msgbox.confirm('删除确认','您确认这删除所有记录吗?删除后将不可恢复!',function(r){
		if(r){
			$.ajax({
					type : 'get',
					url : ctx+'/system/security/gsysFunction/deleteAllOutJson.vhtml',
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
/******add row data****/
function addRowData(row){
	var indexId=grid.getIndexId();
	var rowtr=$('#row' + row[indexId], grid);
	if (rowtr.length==0) {
		grid.flexAddRowData(row);
	}else{
		//for update Descendant need refresh grid
		grid.flexEditRowData(rowtr[0],row);
		//refresh();
	}
	loadCategoryTree();
}
/**********add new row data with edit win**************/
function addRowDataWithEditWin(row){
	var indexId=grid.getIndexId();
	var rowtrs=$('#row' + row[indexId], grid);
	if (rowtrs.length==0) {
		grid.flexAddRowData(row);		
	}else{
		grid.flexEditRowData(rowtrs[0],row);
	}
	var rowtr=$('#row' + row[indexId], grid)[0];
	var rowIdx=$(rowtr).attr("seq");
	var title='GsysFunction管理>编辑 (序号:'+rowIdx+')';
	editWin.setTitle(title);
	loadCategoryTree();
}

/******exportExcel*********/
function exportExcel(){
	var paramSerialize=grid.getParamsString();
	var exportExcelFileUrl=ctx+'/system/security/gsysFunction/exportExcelFile.vhtml';
	location.href=goolov.addUrlParams(exportExcelFileUrl,paramSerialize);
}
/******importExcel**********/
var ImportExcelWin;
function initImportExcelWin(){
	if(!ImportExcelWin){
		ImportExcelWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(390)
			//modal:true
		});
	}
}
function openImportExcelWin(settings){
	initImportExcelWin();
	ImportExcelWin.open(settings);
}
function closeImportExcelWin(){
	ImportExcelWin.close();
}
function closeImportExcelWinAndRefresh(){
	closeImportExcelWin();
	refresh();
}
function importExcel(){
	var title='GsysFunction 导入Excel文件数据';
	var url=ctx+'/system/security/gsysFunction/importExcelFile.vhtml';
	openImportExcelWin({title:title,url:url});
}
