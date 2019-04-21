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
	getAdd();
	getAll();
})

function getAll(){
	if($.inArray("查询岗位结构",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href = path + "main/main.jsp";
	}
	if($.inArray("增加岗位结构",ids)==-1){
		$("#addGw").remove();
	}
}

function getAdd() {
	$("#addGw").click(function() {
		var index = layer.open({
			type : 2,
			title : '添加岗位',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '400px', '350px' ],
			content : path + "station/tpart/add.jsp",
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				window.location.href=path+"station/station.jsp"; 
			}
		});
	});
}