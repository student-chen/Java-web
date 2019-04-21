var path;
var ids='';
var mids='';
var gids='';
$(function() {
	path=$("#path").val();
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	mids=$("#mids").val();
	gids=$("#groupid").val();
//	if($.inArray("查询车辆出库",ids)==-1){
//		layer.msg("你没有权限!", {
//			icon : 3
//		});
//		window.location.href=path+"main/main.jsp"; 
//	}
	if(gids==1){
		loadData();
	}else{
		loadData2();
	}
	
	bindAdd();
});
//管理员
function loadData(){
	$.ajax({
		url : $("#path").val() + "custom.do?method=allcustom",
		type : 'post',
		dataType : 'json',
		data :'',
		success : function(mydata) {
			$.each(mydata,function(index,xx){
				$("#cus").append("<option value='"+xx.customid+"'>"+xx.customname+"("+xx.customtel+")</option>")
			})
		}
	})
}
//普通
function loadData2(){
	$.ajax({
		url : $("#path").val() + "custom.do?method=limitcustom",
		type : 'post',
		dataType : 'json',
		data :{mid:mids},
		success : function(mydata) {
			$.each(mydata,function(index,xx){
				$("#cus").append("<option value='"+xx.customid+"'>"+xx.customname+"("+xx.customtel+")</option>")
			})
		}
	})
}

function bindAdd() {
	$("#add").click(function() {
		var incarmxid=$("#id").val();
		var customid=$("#cus").val();
		var note=$("#note").val();
		$.ajax({
			url : $("#path").val() + "outcar.do?method=add",
			type : 'post',
			dataType : 'json',
			data : {
				incarmxid:incarmxid,
				caroutremark:note,
				customid:customid
			},
			success : function(mydata) {
				parent.layer.msg("保存成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.open({
					type : 2,
					title : '选择赠品',
					fix : false,
					shadeClose : true,
					maxmin : true,
					area : [ '500px', '400px' ],
					content : path + "outcar/adds.jsp",
					skin : 'layui-layer-lan',
					shift : 4, // 0-6的动画形式，-1不开启
					end : function() {
						parent.layer.close(index);
					}
				});
			}
		});

	});
}