$(function(){
	$.ajax({
		url: getServerUrl('/jobtype'),
		type: "post",
		async: false,
		contentType: "application/json;charset=utf-8",
		success: function(data) {
			console.log(data);
			if(data.success == true) {
				var leftMenuData = data.result.result;
				console.log(leftMenuData);
				var html = '';
				for(var i in leftMenuData) {
					html += '<div class="menu_box">';
					html += '<div class="menu_main">';
					html += '<h2>' + leftMenuData[i].name + ' <span></span></h2>';
					var types = leftMenuData[i].type;
					for(var i in types) {
						html += '<a href="list.htmlJava?labelWords=label">' + types[i].name + '</a>';
					}
					html += '</div>';
					html += '<div class="menu_sub dn">';
					for(var i in types) {
						html += '<dl class="reset"><dt><a href="list.html后端开发?labelWords=label">'+ types[i].name +'</a></dt>';
						var childTypes = types[i].type;
						for(var i in childTypes) {
							html += '<dd><a href="list.htmlJava?labelWords=label" class="curr">' + childTypes[i].name + '</a></dd>';
						}
						html += '</dl>';
					}
					html += '</div>';
					html += '</div>';
				}
				$("#js-left-navs").html(html);
			}
		}
	});
	
	$.ajax({
		url: getServerUrl('/hotjob'),
		type: "post",
		async: false,
		contentType: "application/json;charset=utf-8",
		success: function(data) {
			if(data.success == true) {
				var hotJobData = data.result.result;
				var html = '';
				for(var i in hotJobData) {
					console.log((parseInt (i) + 1) % 2 == 0);
					if(((parseInt (i) + 1) % 2 == 0) == true) {
						html += '<li class="odd clearfix">';
					} else {
						html += '<li class="clearfix">';
					}
					
					html += '<div class="hot_pos_l"><div class="mb10"><a href="jobdetail.html" target="_blank">'+hotJobData[i].c_zwmc+'</a>&nbsp;';
					html += '</div><span><em class="c7">月薪： </em>'+hotJobData[i].n_yx+'/小时</span><br />';
					html += '<span><em class="c7">经验：</em> '+hotJobData[i].n_gzjy+'</span><br />';
					html += '<span><em class="c7">最低学历： </em>'+hotJobData[i].n_xlyq+'</span><br />';
					html += '<span><em class="c7">工作地址： </em>'+hotJobData[i].c_gzdz+'</span><br />';
					html += '<span>'+hotJobData[i].dt_fbsj+'发布</span></div>';
					html += '</li>';
				}
				html += '<a href="list.html" class="btn fr" target="_blank">查看更多</a>';
				$("#js-hot-pos").html(html);
			}
		}
	});
	
	$.ajax({
		url: getServerUrl('/newjob'),
		type: "post",
		async: false,
		contentType: "application/json;charset=utf-8",
		success: function(data) {
			if(data.success == true) {
				var newJobData = data.result.result;
				var html = '';
				for(var i in newJobData) {
					html += '<li class="clearfix">';
					html += '<div class="hot_pos_l"><div class="mb10"><a href="jobdetail.html" target="_blank">'+newJobData[i].c_zwmc+'</a>&nbsp;';
					html += '</div><span><em class="c7">月薪： </em>'+newJobData[i].n_yx+'/小时</span><br />';
					html += '<span><em class="c7">经验：</em> '+newJobData[i].n_gzjy+'</span><br />';
					html += '<span><em class="c7">最低学历： </em>'+newJobData[i].n_xlyq+'</span><br />';
					html += '<span><em class="c7">工作地址： </em>'+newJobData[i].c_gzdz+'</span><br />';
					html += '<span>'+newJobData[i].dt_fbsj+'发布</span></div>';
					html += '</li>';
				}
				html += '<a href="list.html?city=%E5%85%A8%-%9B%BD" class="btn fr" target="_blank">查看更多</a>';
				$("#js-hotPosition").html(html);
			}
		}
	});
});