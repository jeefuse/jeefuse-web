$(function() {
	var options={fit:true,border:true,idSeed:tabIdBase,onClose:mainTabClose};
	$('#mainTabs').tabs(options);
    /******category tree ***************/
    loadCategoryTree();
});
function loadCategoryTree(){
	var url=ctx+'/system/listTreeMenuOutJson.vhtml';
    var options = { url:url,onnodeclick:treeNodeClick,showcheck: false,iconspath:ctx+"/resources/style/default/tree/images/",theme: "bbit-tree-arrows" };
    $('#sysMenuTree').ajaxTree(options);
}
function treeNodeClick(item) {
    if(item.url&&''!=$.trim(item.url)&&'#'!=item.url){
    	addTab(item.text,item.url);
    }
}
var tabIndex=1;
var tabIdBase='main-tab-gen-';
function addTab(title, href) {
	var mainTabs = $('#mainTabs');
	if (mainTabs.tabs('exists', title)) {
		mainTabs.tabs('select', title);
	} else {
		var tabId=tabIdBase+tabIndex;
		var tabContenId=tabId+"Content";
		var tabIframeId=tabContenId+'Iframe';
		tabIndex++;
		if (href) {
			var content = '<div id="'+tabContenId+'" style="width:100%;height:100%;"><iframe id="'+tabIframeId+'" frameborder="0" border="0" src="about:blank"  width="100%" height="100%" marginwidth="0" marginheight="0" scrolling="auto"></iframe></div>';
		    mainTabs.tabs('add', {id:tabId,title : title,closable :true,content:content});
		    goolov.loadIFrame(tabContenId,href);
		} else {
			var content = '<div id="'+tabContenId+'" style="width:100%;height:100%;">未实现</div>';
			mainTabs.tabs('add', {id:tabId,title : title,closable :true,content:content});
		}
	}
}
function mainTabClose(){
	$('iframe', this).attr('src', '');
}
function dailyTimeCall(){
	document.getElementById('dailyTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
    $('#greeting').html(getDayGreeting());
}
function getDayGreeting() {
	var now = new Date(), hour = now.getHours();
	if (hour < 6) {
		return "凌晨好:";
	} else if (hour < 9) {
		return "早上好:";
	} else if (hour < 12) {
		return "上午好:";
	} else if (hour < 14) {
		return "中午好:";
	} else if (hour < 17) {
		return "下午好:";
	} else if (hour < 19) {
		return "傍晚好:";
	} else if (hour < 22) {
		return "晚上好:";
	} else {
		return "夜里好:";
	}
}