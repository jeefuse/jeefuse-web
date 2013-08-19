$(document).ready(function() {
	validator=$("#loginForm").validate( {
		rules : {
			j_username : {
				required : true,
				rangelength:[4,20]
			},
			j_password : {required : true,rangelength:[4,26]}
		},
		messages : {
			j_username : {
				remote : "该登录名已经存在!",
				rangelength:"登录名在4-20个字符之间"
			},
			j_password:{
				rangelength:"密码在8-26个字符之间"
			}
		}
	});
	$("input[name='j_captcha']").val("");
});
var validator;
function refreshCode(_this) {
	$(_this).hide().attr('src',ctx+'/security/jcaptcha?' + Math.floor(Math.random()*100)).fadeIn();
}
function submiLogin(){
	if(!$("#loginForm").valid()){
 		var invalideNum=validator.numberOfInvalids();
	    if(invalideNum>0){
		    return ;
	    }
	}
 	var digest=goolov.encrypt($('#j_password').val());
 	var digest2=digest+$('#j_username').attr("clien");
 	var psenctrypt=goolov.encrypt(digest2);	
    $('#j_password').val(psenctrypt);
    document.forms["loginForm"].submit();
}