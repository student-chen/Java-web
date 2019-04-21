var path;
var ids='';
$(function() {
	path=$("#path").val();
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	if($.inArray("查询员工管理",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"master/tpart/main.jsp";  
	}
	if($.inArray("设置员工权限",ids)==-1){
		$("#she").replaceWith('<span><i class="fa fa-ban"></i>&nbsp;&nbsp;不可操作</span>'); 
	}
	loadData();
	aa();
});
function loadData() {
	var id=$("#id").val();
	$.ajax({
		url : $("#path").val() + "master.do?method=one",
		type : "post",
		dataType : "json",
		data:{mid:id},
		async : false,
		success : function(data) {
			$("#img").attr("src",path+"upload/"+data[0].mimg);
			$("#mid").text(data[0].mid);
			$("#name").text(data[0].mname);
			$("#realname").text(data[0].mrealname);
			$("#tel").text(data[0].mtel);
			$("#zc").text(data[0].zc.zname);
			$("#pid").text(data[0].dept.zjmc);
			$("#gw").text(data[0].gw.gname);
		}

	});
}

function aa(){
	var id=$("#id").val();
	$("#she").click(function(){
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
		window.location.href=path+"master/mlimit.jsp?id="+id; 
	})
}
