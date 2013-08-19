
$(function(){
	var mainheight = document.documentElement.clientHeight;
	var gridpm = 58; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm-$("#header").outerHeight(true);
	var w = $("#first-content").outerWidth(true);
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/log/gsysLoginlog/listOutJson.vhtml',
        colModel: [
		   { display: '登录IP',name: 'loginIp',width: 116, sortable: true, align: 'center'}
		   ,{ display: '登录时间',name: 'createdate',width: 60, sortable: true, align: 'center'}
		   ,{ display: '信息',name: 'message',width: 257, sortable: false, align: 'center'}
		   ,{ display: '登入用户',name: 'gsysUser.username',width: 116, sortable: true, align: 'center'}
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
				createdateStart:{dateCN:true}//1 登录时间
				,createdateEnd:{dateCN:true}//2 登录时间	
    	},
    	errorType: "bftip"
	});				

		//process createdate render
	$("#createdateStart,#createdateEnd").datepicker({
			  picker: '<img class="picker" src="'+ctx+'/resources/style/default/tree/images/s.gif" alt="" align="middle">'
			  ,applyrule: createdateRule
	});
	 function createdateRule(id) {
         if (id == 'createdateStart') {
             var v = $("#createdateEnd").val();
             if (v == "") {
                 return null;
             }else {
                 var d = v.match(/^(\d{1,4})(-|\/|.)(\d{1,2})\2(\d{1,2})$/);
                 if (d != null) {
                     var nd = new Date(parseInt(d[1], 10), parseInt(d[3], 10) - 1, parseInt(d[4], 10));
                     return { enddate: nd };
                 }else {
                     return null;
                 }
             }
         } else {
             var v = $("#createdateStart").val();
             if (v == "") {
                 return null;
             }else {
                 var d = v.match(/^(\d{1,4})(-|\/|.)(\d{1,2})\2(\d{1,2})$/);
                 if (d != null) {
                     var nd = new Date(parseInt(d[1], 10), parseInt(d[3], 10) - 1, parseInt(d[4], 10));
                     return { startdate: nd };
                 } else {
                     return null;
                 }
             }
         }
     }			
		

    //variate
    inputUrl=ctx+'/system/log/gsysLoginlog/input.vhtml';
    editUrl=ctx+'/system/log/gsysLoginlog/edit.vhtml';
    deleteOutJsonUrl=ctx+'/system/log/gsysLoginlog/deleteOutJson.vhtml';
    deleteOutJsonAllUrl=ctx+'/system/log/gsysLoginlog/deleteAllOutJson.vhtml';
});
var grid;
var searchFormValidator;
var baseTitle="登入日志管理";
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
			alias : "add",
			action : contextMenuClick
		}, {
			text : "编辑",
			icon : ctx+"/resources/style/default/contextmenu/images/edit.png",
			alias : "edit",
			action : contextMenuClick
		},  {
			text : "删除该行记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "deleteCurrent",
			action : contextMenuClick
		},  {
			text : "删除所选记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "deleteSels",
			
			action : contextMenuClick
		},  {
			text : "删除所有记录",
			icon : ctx+"/resources/style/default/contextmenu/images/rowdelete.png",
			alias : "deleteAll",
			action : contextMenuClick
		},{
			text : "刷新",
			icon : ctx+"/resources/style/default/contextmenu/images/table_refresh.png",
			alias : "refresh",
			action : contextMenuClick
		}]
	};
function contextMenuClick(target) {
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
function newWinInit(){
	if(!newWin){
		var title=baseTitle+'->新增';
		var url=inputUrl;
		newWin=new goolov.winbox({
			width:goolov.winWidth(560),
			height:goolov.winHeight(350),
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
			height:goolov.winHeight(350)
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
