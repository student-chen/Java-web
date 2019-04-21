// JavaScript Document
$(function(){
	$(".big").click(function(){
		$(".box").hide(300);
		$(this).next().show(300);
	})
	.hover(
		function(){$(this).addClass("hightLight");},
		function(){$(this).removeClass("hightLight");}
	);
});