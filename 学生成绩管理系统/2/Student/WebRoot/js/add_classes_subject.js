// AJAX异步查询可选班级课程
$(function()
{
	$("#cla_id").change(function()
	{
		if ($("#cla_id").val() == "0")
			$("#select_able>div,#select_unable>div").remove();
		else
			showData();
	});
});

// 根据条件查询数据，并显示分页查询数据
function showData()
{
	var url = "";
	url += "/Student/SearchCla2Sub_exServlet" + "?value=" + $("#cla_id").val();
	$.post(url, null, function(rs)		
	{	
		$("#select_able>div,#select_unable>div").remove();
		var str = "";
		for ( var i = 0; i < rs[0].length; i++)
		{
			str = "<div class='s2'>";
			str += "<input type='checkbox' name='sub_ids' value=" + rs[0][i].id + " />";
			str += "<div class='s3'>" + rs[0][i].name + "</div></div>";
			$("#select_able").append(str);
		}
		//alert(str);
		for ( var i = 0; i < rs[1].length; i++)
		{
			str = "<div class='s2'>";
			str += "<input type='checkbox' disabled='disabled' checked='checked' />";
			str += "<div class='s3'>" + rs[1][i].name + "</div></div>";
			$("#select_unable").append(str);
		}
	}, "json");
}