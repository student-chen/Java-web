var path;
var ids='';
$(function(){
	path=$("#path").val();
	var heg=$(window).height();
	var wth=$(window).width();
	if(wth<=1000){
		heg=1000;
	}else{
		heg-=300;
	}
	$("#divbody").css("height",heg);
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	var heg=$(window).height();
	$("#divbody").css("height",heg);
	getAll();
})
function getAll(){
	if($.inArray("查询员工管理",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp";  
	}
	if($.inArray("增加员工管理",ids)==-1){
		$("#btn_add").remove();
	}
}

