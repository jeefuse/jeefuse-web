
$(function(){
	var mainheight = document.documentElement.clientHeight;
	var gridpm = 58; //GridHead，toolbar，footer,gridmargin
	var h = mainheight - gridpm-$("#header").outerHeight(true);
	var w = $("#first-content").outerWidth(true);
    var option = {
        height: h, 
        width: w,
        url: ctx+'/system/systemInfo/onlineSessionListOutJson.vhtml',
        colModel: [
		   { display: '会话ID',name: 'sessionId',width: 240, sortable: true, align: 'left'}
		   ,{ display: '操作用户',name: 'userId',width: 150, sortable: true, align: 'left'}
		   ,{ display: '创建时间',name: 'createDateCn',width: 142, sortable: true, align: 'left'}
		   ,{ display: '最后访问时间',name: 'lastAccessedTimeCn',width: 142, sortable: true, align: 'left'}
		],      
		indexId:'sessionId',
		sortname: "lastAccessedTimeCn",
		sortorder: "desc",
		searchparam:searchparamsCall,
		//title: '数据例表',
		autoload: true,
		showcheckbox: true,
        rowhandler: gridContextmenu,
		rowbinddata: false
    };
    
	//format
	
	function formatLogType(value, pid) {
		return LogTypeJson[value];
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
				createdateStart:{dateCN:true}//1 创建时间
				,createdateEnd:{dateCN:true}//2 创建时间	
    	},
    	errorType: "bftip"
	});				

	//process createdate render
	$("#createdateStart,#createdateEnd").datepickerRange({startEl:'createdateStart',endEl:'createdateEnd'});
	
	 //userId autoComplete
	 $('#userId').autocompleteCombo(ctx+'/system/security/gsysUser/listForSelectOutJson.vhtml',{
			minChars: 0,
			width: 260,
			matchContains: true,
			mustMatch:false,
			selectFirst: false,
			matchSubset:false,
			formatMatch:function(row, i, max){
				return row.username;
			},
			formatResult: function(row) {
				return row.username;
			},
			component:{
				type:"grid",//options value :grid,treegrid,combobox
				gridSetting:{
			        colModel: [
						{ display: '用户名',name: 'username',width: 80, sortable: true, align: 'center'}
						,{ display: '登录名',name: 'loginName',width: 80, sortable: true, align: 'center'}
					]
				}
			}
		});
    //variate
    inputUrl=ctx+'/system/log/gsysOperatelog/input.vhtml';
    editUrl=ctx+'/system/log/gsysOperatelog/edit.vhtml';
    deleteOutJsonUrl=ctx+'/system/log/gsysOperatelog/deleteOutJson.vhtml';
    deleteOutJsonAllUrl=ctx+'/system/log/gsysOperatelog/deleteAllOutJson.vhtml';
});
var grid;
var searchFormValidator;
var baseTitle="操作日志管理";
var inputUrl;
var editUrl;
var deleteOutJsonUrl;
var deleteOutJsonAllUrl;
/******contenxtmenu*****/
var menu = {
		width : 150,
		items : [ {
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
