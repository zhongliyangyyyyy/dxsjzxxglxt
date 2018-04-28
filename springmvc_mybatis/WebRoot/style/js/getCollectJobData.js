$(function(){
	$.ajax({
		url: getServerUrl('/wscjob'),
		type: "post",
		async: false,
		contentType: "application/json;charset=utf-8",
		success: function(data) {
			console.log(data);
			if(data.success == true) {
				var collectData = data.result.result;
				var html = '';
				for(var i in collectData) {
					html += '<li data-id="'+collectData[i].c_id+'">';
					html += '<a target="_blank" href="h/c/6636.html">';
					html += '<img alt="携程旅行网" src="style/images/ff808081441c19bf01441f9a47190b3a.png">';
					html += '</a>';
					html += '<div class="co_item">';
					html += '<h2 title="'+collectData[i].c_zwmc+'">';
					html += '<a target="_blank" href="h/jobs/133340.html">';
					html += '<em>'+collectData[i].c_zwmc+'</em> ';
					html += '<span>'+collectData[i].n_yx+'</span></a></h2>';
					html += '<span class="co_time">发布时间：'+collectData[i].dt_fbsj+'</span>';
					var gzjy = '';
					if(collectData[i].n_gzjy == 1) {
						gzjy = '有工作经验';
					} else {
						gzjy = '无工作经验';
					}
					var xlyq = '';
					if(collectData[i].n_xlyq == 1) {
						xlyq = '不限';
					} else if (collectData[i].n_xlyq == 2) {
						xlyq = '大专';
					} else if (collectData[i].n_xlyq == 3) {
						xlyq = '本科';
					} else if (collectData[i].n_xlyq == 4) {
						xlyq = '硕士';
					} else if (collectData[i].n_xlyq == 5) {
						xlyq = '博士';
					}
					html += '<div class="co_cate"> 搜狗  / '+collectData[i].c_gzdz+' / '+gzjy+'年 / 本科</div>';
					html += '<span class="co_youhuo c7">'+collectData[i].c_zwms+'</span>';
					html += '<a class="collectionCancel collection_link collected" href="javascript:;">取消收藏<span>已取消收藏</span></a>';
					html += '</div></li>';
				}
				console.log(html);
				$("#js-myCollect").html(html);
			}
		}
	});
});