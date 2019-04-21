// JavaScript Document
$(function() {
	
	//当添加数据成功后弹出提示框
	var message = $("#message").val();
	if (message != null) {
		alert(message);
	}

	// 实时查看个人图片,仅在IE6的渣渣中有效
	$("input[name=pic]").change(function() {
		$("img").attr("src", $(this).val());
	});

	// 表格鼠标经过样式，动态添加的数据无法绑定，已失效
	$(".change").mouseover(function() {
		$(this).addClass("mouseover");
	}).mouseout(function() {
		$(this).removeClass("mouseover");
	});
});