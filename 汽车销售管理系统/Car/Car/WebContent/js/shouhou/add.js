var path;
var ids='';
var gid="";
$(function() {
	path=$("#path").val();
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	gid=$("#groupid").val();
	if($.inArray("查询售后管理",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	loadData();
	bindAdd();
});

function loadData(){
	$.ajax({
		url : $("#path").val() + "custom.do?method=allcustom",
		type : 'post',
		dataType : 'json',
		data :{gid:gid},
		success : function(mydata) {
			$.each(mydata,function(index,xx){
				$("#custom").append("<option value='"+xx.customid+"'>"+xx.customname+"("+xx.customtel+")</option>")
			})
		}
	})
}
function bindAdd() {

	$("#add").click(function() {
		var customid=$("#custom").val();
		$.ajax({
			url : $("#path").val() + "shou.do?method=add",
			type : 'post',
			dataType : 'json',
			data : {
				customid:customid
			},
			success : function(mydata) {
				parent.layer.msg("保存成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		});

	});
}