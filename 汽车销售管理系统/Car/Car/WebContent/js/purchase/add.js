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
	if($.inArray("查询采购申请",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	$("#title").focus();
	onblur();
	bindAdd();
});
function onblur() {
	$("#title").blur(function(){
		var title = $("#title").val();
		if (title.trim() == "") {
			layer.tips('标题不能为空!', $("#title"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	
	$("#note").blur(function(){
		var note = $("#note").val();
		if (note.trim() == "") {
			layer.tips('备注不能为空!', $("#note"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	
}
function bindAdd() {

	$("#add").click(function() {
		var note=$("#note").val();
		var title = $("#title").val();
		if (title.trim() == "") {
			layer.tips('标题不能为空!', $("#title"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (note.trim() == "") {
			layer.tips('备注不能为空!', $("#note"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : $("#path").val() + "purchase.do?method=add",
			type : 'post',
			dataType : 'json',
			data : {
				purtitle : title.trim(),
				purremark: note.trim()
			},
			success : function(mydata) {
				parent.layer.msg("保存成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.open({
					type : 2,
					title : '选择采购项',
					fix : false,
					shadeClose : true,
					maxmin : true,
					area : [ '900px', '600px' ],
					content : path + "purchase/adds.jsp",
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