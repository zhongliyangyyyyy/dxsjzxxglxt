$(function(){
	console.log(GetQueryString("nr"));
	var nr = GetQueryString("nr");
	$("#search_input").val(nr);
	$('#searchForm').attr('action','list.html').submit();
});