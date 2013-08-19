
$(function(){
	var mainheight = document.documentElement.clientHeight;
	var gridpm = 58; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm-$("#header").outerHeight(true);
	var w = $("#first-content").width();
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/security/gsysUserCertify/listOutJson.vhtml',
        colModel: [
		   { display: '申请人姓名',name: 'applicantName',width: 117, sortable: true, align: 'left'}
		   ,{ display: '申请人身份证号码',name: 'applicantNumber',width: 187, sortable: true, align: 'left'}
		   ,{ display: '申请人联系电话',name: 'applicantTel',width: 215, sortable: true, align: 'left'}
		   ,{ display: '申请人身份证正面',name: 'idcartPhoto',width: 257, sortable: true, align: 'left'}
		   ,{ display: '申请人身份证正面照片保存地址',name: 'idcartSavePath',width: 257, sortable: true, align: 'left'}
		   ,{ display: 'GsysUsernull',name: 'gsysUser.null',width: 120, sortable: true, align: 'left'}
		],      
		indexId:'id',
		sortname: "id",
		sortorder: "desc",
		searchparam:searchparamsCall,
		autoload: true,
		showcheckbox: true,
		usepager: true,
        rowhandler: gridContextmenu,
		rowbinddata: false,
		onRowDblclick:onRowDblclick
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
    	},
    	errorType: "bftip"
	});											
	
    //variate
    config.inputUrl=ctx+'/system/security/gsysUserCertify/input.vhtml';
    config.editUrl=ctx+'/system/security/gsysUserCertify/edit.vhtml';
    config.deleteOutJsonUrl=ctx+'/system/security/gsysUserCertify/deleteOutJson.vhtml';
    config.deleteOutJsonAllUrl=ctx+'/system/security/gsysUserCertify/deleteAllOutJson.vhtml';
});
var grid;
var searchFormValidator;
var config={
	baseTitle:"用户身份认证管理",
	inputUrl:null,
	editUrl:null,
	deleteOutJsonUrl:null,
	deleteOutJsonAllUrl:null
};
/******contenxtmenu*****/
var imgPath=ctx+"/resources/style/default/contextmenu/images/";
var menu = {
		width : 150
		,items : [{text : "新增",icon :imgPath+"view.png",alias : "add",action :contextMenuClick}
				,{text : "编辑",icon : imgPath+"edit.png",alias : "edit",action : contextMenuClick}
				,{type: "splitLine" }
				,{text : "删除该项记录",icon : imgPath+"rowdelete.png",alias : "deleteCurrent",action : contextMenuClick}
				,{text : "删除所选记录",icon : imgPath+"rowdelete.png",alias : "deleteSels",action : contextMenuClick}
				,{text : "删除所有记录",icon : imgPath+"rowdelete.png",alias : "deleteAll",action : contextMenuClick}
				,{type: "splitLine" }
				,{text : "刷新",icon : imgPath+"table_refresh.png",alias : "refresh",action : contextMenuClick}
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
		case 'deleteAll':
			delAllData();
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
			width:goolov.winWidth(560),
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
function newWinCloseAndRefresh(){
	newWinClose();
	refresh();
}
function newData(){
	newWinOpen();
}
/******edit data window**********/
var editWin;
function editWinOpen(settings){
		if(!editWin){
		editWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(510)
		});
	}
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
	var rowtr=$('#row' + id, grid)[0];
	var rowIdx=$(rowtr).attr("seq");
	var title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(config.editUrl,"id="+id);
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
	var title=config.baseTitle+'->编辑 (序号:'+rowIdx+')';
	editWin.setTitle(title);
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
