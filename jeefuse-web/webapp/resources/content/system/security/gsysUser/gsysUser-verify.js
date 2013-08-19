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
		   { display: '用户名',name: 'username',width: 80, sortable: true, align: 'left'}
		   ,{ display: '登录名',name: 'loginName',width: 80, sortable: true, align: 'left'}
		   ,{ display: 'Email',name: 'email',width: 160, sortable: true, align: 'left'}
		   ,{ display: '电话',name: 'telephone',width: 80, sortable: true, align: 'left'}
		   ,{ display: '性别',name: 'sex',width: 60, sortable: true, align: 'left',process:formatSexType}
		   ,{ display: '身份认证',name: 'idcardAuthen',width: 77, sortable: true, align: 'left',process:formatIdcardAuthen}
		   ,{ display: '用户类型',name: 'level',width: 60, sortable: true, align: 'left',process:formatLevel}
		   ,{ display: '有效性',name: 'enabled',width: 60, sortable: true, align: 'left',process:formatEnabled}
		   ,{ display: '好评率',name: 'evalRate',width: 60, sortable: true, align: 'left',process:formatEvalRate}
		   ,{ display: '个人说明',name: 'remark',width: 257, sortable: false, align: 'left'}
		   ,{ display: '最后登录时间',name: 'lastLoginTime',width: 100, sortable: true, align: 'left'}
		   ,{ display: '更新时间',name: 'updateTime',width: 100, sortable: true, align: 'left'}
//		   ,{ display: '创建时间',name: 'createTime',width: 77, sortable: true, align: 'left'}
		],      
		indexId:'id',
		sortname: "id",
		sortorder: "desc",
		searchparam:searchparamsCall,
		autoload: true,
		resizable: false, 
		showcheckbox: true,
		usepager: true,
		showseq:true,
        rowhandler: gridContextmenu,
        rowbinddata : true,
		onRowDblclick:onRowDblclick
    };
    
	//format
    function formatIdcardAuthen(value,row){
    	switch (value) {
		case 'N':
			return '<font color="gray">未进行</span>';
		case 'P':
			return '<font color="blue">等待中</span>';
		case 'C':
			return '<font color="red">未通过</span>';
		case 'Y':
			return '<font color="green">已通过</span>';	
		default:
			return '<font color="gray">未知</span>';	
		}
    }
	function formatSexType(value, row) {
		return SexJson[value];
	}
	function formatLevel(value,row){
		return UserKindJson[value];
	}
	function formatEnabled(value,row){
		return EnabledJson[value];
	}
	function formatEvalRate(value,row){
		return '<span class="percentage">'+value+'%</span>';
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
	config.identityAuditUrl=ctx+'/system/security/gsysUser/identityAudit.vhtml';
});
var grid;
var searchFormValidator;
var config={
	identityAuditUrl:null
};
/******contenxtmenu*****/
var menu = {
		width : 150,
		items : [ {
			text : "身份认证审核",
			icon : ctx+"/resources/style/default/contextmenu/images/edit.png",
			alias : "verify",
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
		case 'verify':
			var title = '身份认证审核 (序号:' + rowIdx + ')';
			var url=goolov.addUrlParams(config.identityAuditUrl,"id="+id);
			verifyWinOpen( {title:title,url:url});
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
function onRowDblclick(target){
	var id = $(target).attr("id").substr(3);
	verify(id);
}
/******edit data window**********/
var verifyWin;
function verifyWinOpen(settings){
	if(!verifyWin){
		verifyWin=new goolov.winbox({
			width:goolov.winWidth(650),
			height:goolov.winHeight(510)
		});
	}
	verifyWin.open(settings);
}
function verifyWinClose(){
	verifyWin.close();
}
function verifyWinCloseAndRefresh(){
	verifyWinClose();
	refresh();
}
function verifyData(){
	var ids=grid.getCheckedRows();
	var selCount=ids.length;
	if (selCount== 0) {
		goolov.growl.info('请选择需要修改的记录,或双击需要编辑的行.');
		return;
	}
	if(selCount>1){
		goolov.growl.info('一次只能选择一项记录.');
		return;
	}
	var id=ids[0];
	verify(id);
}
function verify(id){
	if(!id){
		goolov.growl.info('请选择需要修改的记录,或双击需要编辑的行.');
		return;
	}
	var rowtr=$('#row' + id, grid)[0];
	var rowData=$('#row' + id).data('rowData');
	if(rowData.idcardAuthen=='N'){
		alert('该用户未提交身份认证,不能审核!');
		return;
	}
	var rowIdx=$(rowtr).attr("seq");
	var title='用户身份认证审核 (序号:'+rowIdx+')';
	var url=goolov.addUrlParams(config.identityAuditUrl,"id="+id);
	var opts={title:title,url:url};
	verifyWinOpen(opts);
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