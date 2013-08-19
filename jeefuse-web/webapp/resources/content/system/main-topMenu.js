$(function() {
			$('#container').layout({});
			var clientHeight = document.documentElement.clientHeight;
			$('#content').height(clientHeight-$('#header').height()-3);
		    /******category tree ***************/
//			ddsmoothmenu.init( {
//				mainmenuid : "topMenu", //menu DIV id
//				orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
//				classname : 'ddsmoothmenu', //class added to menu's outer DIV
//				//customtheme: ["#1c5a80", "#18374a"],
//				contentsource : "markup"//"markup" or ["container_id", "path_to_menu_file"]
//			});
			$('ul.sf-menu').supersubs({ 
	            minWidth:    12,   // minimum width of sub-menus in em units 
	            maxWidth:    27,   // maximum width of sub-menus in em units 
	            extraWidth:  1     // extra width can ensure lines don't sometimes turn over 
	                               // due to slight rounding differences and font-family 
	        }).superfish({
				delay : 600, // one second delay on mouseout 
				animation : {
					opacity : 'show',
					height : 'show'
				}, // fade-in and slide-down animation 
				speed : 'fast',                          // faster animation speed 
				//autoArrows:  false,                    // disable generation of arrow mark-up 
				disableHI:     true,
				dropShadows: true                      // disable drop shadows 
			});
			//load index iframe
			refreshIndex();
});

function refreshContentIframe(url){
	goolov.loadIFrame("content",url);
}
function refreshIndex(){
	refreshContentIframe(ctx+"/system/index.vhtml");
	$('#subLocate').html('');
}
function menuItemClick(id,text,url,parentId,e){
	if(url&&url!=""&&url!='#'){
		var pathArr=[];
		putParentText($(e),pathArr);
		$('#subLocate').html('>'+pathArr.reverse().join('>')+'><span class="label">'+text+'</span>');
		refreshContentIframe(url);
	}
}
function putParentText($e,pathArr){
	if($e.parent().parent().hasClass("sf-menu"))
		return;
	else{
		var $cure=$e.parent().parent().prev();
		pathArr.push('<span class="nav-item">'+$cure.find('span:first').text()+'</span>');
		putParentText($cure,pathArr);
	}
}

function setIframeHeight(obj)
{
  var cwin=obj;
  if (document.getElementById)
  {
    if (cwin && !window.opera)
    {
      if (cwin.contentDocument && cwin.contentDocument.body.offsetHeight)
        cwin.height = cwin.contentDocument.body.offsetHeight;
      else if(cwin.Document && cwin.Document.body.scrollHeight)
        cwin.height = cwin.Document.body.scrollHeight;
    }
  }
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