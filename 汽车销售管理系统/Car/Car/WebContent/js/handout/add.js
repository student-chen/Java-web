var path;
$(function() {
	path=$("#path").val();
	$("#name").focus();
	onblur();
	bindAdd();
});
function onblur() {
	$("#name").blur(function(){
		var name = $("#name").val();
		$.ajax({
			url:path+"handout.do?method=repeat",
			type:'post',
			data:{name:name},
			dataType: 'json',
			success: function(mydata){
				if(mydata==1){
					layer.tips('名称已存在！', $("#name"), {
						tips : [ 2, 'red' ]
					});
					$("#name").focus();
					$("#add").attr("disabled","disabled");
				}else{
					$("#add").attr("disabled",false);
				}
			}
		})
		if (name.trim() == "") {
			layer.tips('名称不能为空!', $("#name"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	
}
function bindAdd() {

	$("#add").click(function() {
		var flag=$("#flag").val();
		var name = $("#name").val();
		if (name.trim() == "") {
			layer.tips('名称不能为空!', $("#name"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : $("#path").val() + "handout.do?method=add",
			type : 'post',
			dataType : 'json',
			data : {
				handoutname : name.trim(),
				handoutflag: flag.trim()
			},
			success : function(mydata) {
				parent.layer.msg("添加成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);

			}
		});

	});
}