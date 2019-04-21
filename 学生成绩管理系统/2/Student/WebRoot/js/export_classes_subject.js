// 全局变量，总页数，当前页数
var countPages = 1;
var currentPage = 1;

// AJAX异步查询班级课程
$(function() {
	$("#search_classes_subject").click(function() {
		if ($.trim($("#value").val()) == "")
			alert("请输入关键字。");
		else {
			// 查询总页数并赋值到全局变量中
			countPages = getCountPage();
			// 默认查询第一页数据
			showData(currentPage);
			// 根据当前页数构建分页按钮
			showPage(currentPage);
		}
	});
});

// 整体调用函数
function show(page) {
	showData(page);
	showPage(page);
}
// 根据条件查询数据，并显示分页查询数据
function showData(page) {
	var url = "";
	url += "/Student/SearcCla2SubServlet?search_type="
			+ $("#search_type").val();
	url += "&value=" + encodeURI(encodeURI($("#value").val())) + "&page="
			+ page;
	$.post(url, null, function(rs) {
		$("#table>tbody>tr").not(":first").remove();
		var str = "";
		for ( var i = 0; i < rs.length; i++) {
			str = "<tr class='change' align='center'>";
			str += "<td>" + rs[i].classes.name + "</td>";
			str += "<td>" + rs[i].subject.name + "</td>";
			str += "<td>" + rs[i].teacher.name + "</td>";
			str += "</tr>";
			var stra = "<a href='/Student/ExportCal_subServlet?search_type="
					+ $("#search_type").val() + "&value="
					+ encodeURI(encodeURI($("#value").val()))
					+ " 'style='font-size: 16px'>导出课程表</a>";

			$("#sta").append(stra);
			$("#table").append(str);
		}
	}, "json");
}

// 查询总页数,只返回一个总页数
function getCountPage() {
	var url = "", rt = "";
	url += "/Student/GetCla2SubCountPageServlet?search_type="
			+ $("#search_type").val();
	url += "&value=" + encodeURI(encodeURI($("#value").val()));
	$.ajax( {
		type : "post",
		url : url,
		async : false, // 设置成同步，不然回调函数无法按正确顺序执行
		dataType : "text",
		success : function(rs) {
			rt = rs;
		}
	});
	return rt;
}

// 构建分页按钮链接组件
function showPage(page) {
	$("#center>p,#center>br").remove();
	var str = "<br/><p>";

	if (page <= 1)
		str += "<a class='a_3'>上一页</a>";
	else
		str += "<a class='a_3' href='###' onclick='javascript:show("
				+ (page - 1) + ")'>上一页</a>";

	for ( var i = 1; i <= countPages; i++) {
		if (i == page)
			str += "<a class='a_4 select'>" + i + "</a>";
		else
			str += "<a class='a_4' href='###' onclick='javascript:show(" + i
					+ ")'>" + i + "</a>";
	}

	if (page >= countPages)
		str += "<a class='a_3'>下一页</a>";
	else
		str += "<a class='a_3' href='###' onclick='javascript:show("
				+ (page + 1) + ")'>下一页</a>";

	$("#center").append(str);
}