$(function() {
	console.log(GetQueryString("nr"));
	var nr = GetQueryString("nr");
	$("#search_input").val(nr);
	// $('#searchForm').attr('action','list.html').submit();
	var total = 0;
	layui.use('laypage', function() {
		var laypage = layui.laypage;
		getSearchjob(1, 4);
		// 执行一个laypage实例
		
		$(".workplace dd").not('.more').children('a').click(function(){
			$('#lc').val(1);
			editForm("cityInput" , $(this).html());
		});
		
		$("#box_expectCity dd span").click(function(){
			$('#lc').val(1);
			editForm("cityInput" , $(this).html());
		});
		
		$('#options dd div').click(function(){
			var firstName = $(this).parents('dl').children('dt').text();
			console.log('333'+firstName);  
			var fn = $.trim(firstName);
			if (fn=="月薪范围"){
				editForm("yxInput" , $(this).html());
			}
			else if(fn=="工作经验"){
				editForm("gjInput" , $(this).html());
			}
			else if(fn=="最低学历"){
				editForm("xlInput" , $(this).html());
			}
			else if(fn=="工作性质"){
				editForm("gxInput" , $(this).html());
			}
			else if(fn=="发布时间"){
				editForm("stInput" , $(this).html());
			}
		});
		
		$("#search_button").click(function(){
			getSearchjob(1, 4);
		});
		
		$('#selected ul').delegate('li span.select_remove','click',function(event){
			var firstName = $(this).parent('li').find('strong').text();
			var fn = $.trim(firstName);
			if (fn=="月薪范围")
				editForm("yxInput" , "");
			else if(fn=="工作经验")
				editForm("gjInput" , "");
			else if(fn=="最低学历")
				editForm("xlInput" , "");
			else if(fn=="工作性质")
				editForm("gxInput" , "");
			else if(fn=="发布时间")
				editForm("stInput" , "");
		});
		
		function editForm(inputId,inputValue){
			$("#"+inputId).val(inputValue);
			getSearchjob(1, 4);
		}
		
		function getSearchjob(page, pagesize) {
			var yxInput = $("#yxInput").val();
			var yxend = 0;
			var yxstart = 0;
			if(yxInput == '1000以下') {
				yxend = 1000;
			} else if (yxInput == '1000-2000') {
				yxend = 2000;
				yxstart = 1000;
			} else if (yxInput == '2000-3000') {
				yxend = 3000;
				yxstart = 2000;
			} else if (yxInput == '3000以上') {
				yxstart = 3000;
				yxend = 20000;
			}
			var gzjyInput = $("#gjInput").val();
			var gzjy = 0;
			if(gzjyInput == '无限制') {
				gzjy = 1;
			} else if (gzjyInput == '有经验') {
				gzjy = 2;
			} else if (gzjyInput == '无经验') {
				gzjy = 3;
			}
			var gxInput = $("#gxInput").val();
			var gzxz = 0;
			if(gxInput == '兼职') {
				gzxz = 1;
			} else if(gxInput == '全职') {
				gzxz = 2;
			}
			var stInput = $("#stInput").val();
			var fbsj = 100;
			if(stInput == '今天') {
				fbsj = 0;
			} else if (stInput == '3天内'){
				fbsj = 3;
			} else if (stInput == '一周内'){
				fbsj = 7;
			}
			var xlInput = $("#xlInput").val();
			var zdxl = 0;
			if(xlInput == '不限') {
				zdxl = 1;
			} else if (xlInput == '大专'){
				zdxl = 2;
			} else if (xlInput == '本科'){
				zdxl = 3;
			} else if (xlInput == '硕士'){
				zdxl = 4;
			} else if (xlInput == '博士'){
				zdxl = 5;
			}
			var paramMap = {
				"bt": {
					'nr': $.trim($('#search_input').val()),
					'yxstart': yxstart,
					'gzjy': gzjy,
					'zdxl': zdxl,
					'gzxz': gzxz == 0 ? '' : gzxz,
					'fbsj': fbsj == 100 ? '' : fbsj,
					'yxend': yxend == 0 ? '' : yxend
				},
				"page": page,
				"pagesize": pagesize,
			};
			$.ajax({
				url: getServerUrl('/searchjob'),
				type: "post",
				data: JSON.stringify(paramMap),
				async: true,
				contentType: "application/json;charset=utf-8",
				success: function(data) {
					console.log(data);
					var resultData = data.result;
					console.log(resultData.total);
					total = resultData.total;
					if(total == 0) {
						$("#js-layui-pagination").hide()
					}
					var html = '';
					var hotJobData = resultData.result;
					for(var i in hotJobData) {
						if(((parseInt (i) + 1) % 2 == 0) == true) {
							html += '<li class="clearfix" style="float: right;padding: 13px 0;">';
						} else {
							html += '<li class="clearfix" style="float: left;padding: 13px 0;">';
						}
						var id=hotJobData[i].c_id;
						html += '<div class="hot_pos_l"><div class="mb10"><a href="jobdetail.html?id='+id+'" target="_blank">'+hotJobData[i].c_zwmc+'</a>&nbsp;';
						html += '</div><span><em class="c7">月薪： </em>'+hotJobData[i].n_yx+'</span><br />';
						html += '<span><em class="c7">经验：</em> '+hotJobData[i].n_gzjy+'</span><br />';
						html += '<span><em class="c7">最低学历： </em>'+hotJobData[i].n_xlyq+'</span><br />';
						html += '<span><em class="c7">工作地址： </em>'+hotJobData[i].c_gzdz+'</span><br />';
						html += '<span>'+hotJobData[i].dt_fbsj+'发布</span></div>';
						html += '</li>';
					}
					$("#js-joblist").html(html);
					laypage.render({
						elem : 'js-layui-pagination'
						,
						count : total,
						limit: 4,
						curr: location.hash.replace('#!fenye=', ''),
						hash: 'fenye',
						jump: function(obj, first){
							if(!first){
								console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
							    console.log(obj.limit); //得到每页显示的条数
							    getSearchjob(obj.curr, obj.limit);
							}
						}
					});
				}
			});
			
		}
		
	});
});