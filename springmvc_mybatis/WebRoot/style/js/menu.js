$(function(){
	var user = sessionStorage.getItem("user");
	console.log('user:' + user);
	user = JSON.parse(user);
	//console.log('type:' + user.type);
	var html = '';
	html += '<li class="current"><a href="index.html">首页</a></li>';
	html += '<li ><a href="gerenxinxi.html" >个人信息</a></li>';
	if(user != undefined && user != null) {
		$('#js-user-span').html(user.user + '&nbsp;');
		if(user.type == 1) {
			html += '<li ><a href="jianli.html" rel="nofollow">我的简历</a></li>';
			html += '<li ><a href="collections.html" rel="nofollow">我收藏的职位</a></li>';
			html += '<li ><a href="delivery.html?tag=0" rel="nofollow">我投递的简历</a></li>';
		} else {
//			$('#js-user-span').hide();
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