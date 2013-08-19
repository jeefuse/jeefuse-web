
$(function(){
	var w = $("#first-content").outerWidth(true);
	var mainheight = document.documentElement.clientHeight;
	var gridpm = 58; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm-$("#header").outerHeight(true);
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/security/gsysUser/listOutJson.vhtml',
        colModel: [
		   { display: '用户名',name: 'username',width: 80, sortable: true, align: 'center'}
		   ,{ display: '登录名',name: 'loginName',width: 80, sortable: true, align: 'center'}
//		   ,{ display: '密码',name: 'password',width: 128, sortable: true, align: 'center'}
		   ,{ display: 'Email',name: 'email',width: 170, sortable: true, align: 'center'}
		   ,{ display: '电话',name: 'telephone',width: 110, sortable: true, align: 'center'}
		   ,{ display: '性别',name: 'sex',width: 60, sortable: true, align: 'center',process:formatSexType}
//		   ,{ display: '用户类型',name: 'level',width: 60, sortable: true, align: 'center',process:formatLevel}
		   ,{ display: '有效性',name: 'enabled',width: 60, sortable: true, align: 'center',process:formatEnabled}
		   ,{ display: '创建时间',name: 'createTime',width: 77, sortable: true, align: 'center'}
//		   ,{ display: '登录次数',name: 'logincount',width: 77, sortable: true, align: 'center'}
		   ,{ display: '备注',name: 'remark',width: 257, sortable: false, align: 'center'}
		   ,{ display: '更新时间',name: 'updateTime',width: 77, sortable: true, align: 'center'}
		   ,{ display: '最后登录时间',name: 'lastLoginTime',width: 77, sortable: true, align: 'center'}
		],      
		indexId:'id',
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
		showseq:true,
		gridClass: "bbit-grid",
        rowhandler: gridContextmenu,
		rowbinddata: false,
		onRowDblclick:onRowDblclick
    };
    
	//format
	function formatSexType(value, row) {
		return SexJson[value];
	}
	function formatLevel(value,row){
		return UserKindJson[value];
	}
	function formatEnabled(value,row){
		return EnabledJson[value];
	}
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
    inputUrl=ctx+'/system/security/gsysUser/input.vhtml';
    editUrl=ctx+'/system/security/gsysUser/edit.vhtml';
    deleteOutJsonUrl=ctx+'/system/security/gsysUser/deleteOutJson.vhtml';
    deleteOutJsonAllUrl=ctx+'/system/security/gsysUser/deleteAllOutJson.vhtml';
    modifyPasswordUrl=ctx+'/system/security/gsysUser/modifyPassword.vhtml';
});
var grid;
var searchFormValidator;
var baseTitle="用户管理";
var inputUrl;
var editUrl;
var deleteOutJsonUrl;
var deleteOutJsonAllUrl;
var modifyPasswordUrl;
/******contenxtmenu*****/
var menu = {
		width : 150,
		items : [ {
			text : "新增",
			icon : ctx+"/resources/style/default/contextmenu/images/view.png",
			alias : "add",
			action : contextmenuClick
		}, {
			text : "编辑",
			icon : ctx+"/resources/style/default/contextmenu/images/edit.png",
			alias : "edit",
			action : contextmenuClick
		},{
			text : "修改密码 ",
			icon : ctx+"/resources/style/default/contextmenu/images/edit.png",
			alias : "modifyPassword",
			action : contextmenuClick
		},  {
			text : "删除该行记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "deleteCurrent",
			action : contextmenuClick
		},  {
			text : "删除所选记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "deleteSels",
			action : contextmenuClick
		},  {
			text : "删除所有记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "deleteAll",
			action : contextmenuClick
		},{
			text : "刷新",
			icon : ctx+"/resources/style/default/contextmenu/images/table_refresh.png",
			alias : "refresh",
			action : contextmenuClick
		}]
	};
function contextmenuClick(target) {
	var id = $(target).attr("id").substr(3);
	var rowIdx = $(target).attr("seq");
	var cmd = this.data.alias;
	switch(cmd){
		case 'add':
			var title=baseTitle+'->新增';
			newWinOpen({title:title});
			break;
		case 'edit':
			var title = baseTitle+'->编辑 (序号:' + rowIdx + ')';
			var url=goolov.addUrlParams(editUrl,"id="+id);
			editWinOpen( {title:title,url:url});
			break;
		case 'modifyPassword':
			var title = baseTitle+'->修改密码 (序号:' + rowIdx + ')';
			var url=goolov.addUrlParams(modifyPasswordUrl,"id="+id);
			editWinOpen( {title:title,url:url});
			break;
		case 'deleteCurrent':
			deleteOutJson(new Array(id));
			break;
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
function newWinInit(){
	if(!newWin){
		var title=baseTitle+'->新增';
		var url=inputUrl;
		newWin=new goolov.winbox({
			width:goolov.winWidth(650),
			height:goolov.winHeight(510),
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
			width:goolov.winWidth(650),
			height:goolov.winHeight(510)
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
	var title=baseTitle+'->编辑 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(editUrl,"id="+id);
	var opts={title:title,url:url};
	editWinOpen(opts);
}
/**
 * 修改密码
 */
function modifyPassword(){
	var ids=grid.getCheckedRows();
	var selCount=ids.length;
	if (selCount== 0) {
		goolov.growl.info('请选择需要修改密码的用户');
		return;
	}
	if(selCount>1){
		goolov.growl.info('一次只能选择修改一项记录.');
		return;
	}
	var id=ids[0];
	var title = baseTitle+'->修改密码 (序号:' + rowIdx + ')';
	var url=goolov.addUrlParams(modifyPasswordUrl,"id="+id);
	editWinOpen( {title:title,url:url});
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
	var title=baseTitle+'->编辑 (序号:'+rowIdx+')';
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
		goolov.msgbox.confirm('删除确认','您确认删除所有记录吗?删除后将不可恢复!',function(r){
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
