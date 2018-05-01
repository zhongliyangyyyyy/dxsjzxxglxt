$(function(){
	var user = sessionStorage.getItem("user");
	user = JSON.parse(user);
	//console.log('type:' + user.type);
	var html = '';
	html += '<li class="current"><a href="index.html">首页</a></li>';
	html += '<li ><a href="myhome.html" >个人信息</a></li>';
	if(user != undefined && user != null) {
		if(user.type == 1) {
			$('#js-user-span').html(user.user + '&nbsp;');
			html += '<li ><a href="jianli.html" rel="nofollow">我的简历</a></li>';
			html += '<li ><a href="collections.html" rel="nofollow">我收藏的职位</a></li>';
			html += '<li ><a href="delivery.html" rel="nofollow">我投递的简历</a></li>';
		} else {
			html += '<li ><a href="create.html" rel="nofollow">发布职位</a></li>';
			html += '<li ><a href="daichulijianli.html" rel="nofollow">我收到的简历</a></li>';
		}
		$("#navheader").html(html);
		$("#js-loginAndReg").hide();
		$("#js-userDl").show();
	} else {
		$("#js-loginAndReg").show();
		$("#js-userDl").hide();
	}
});