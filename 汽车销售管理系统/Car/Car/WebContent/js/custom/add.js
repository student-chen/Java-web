var path;
$(function() {
	path=$("#path").val();
	$("#name").focus();
	onblur();
	bindAdd();
});
function onblur() {
	$("#tel").blur(function(){
		var tel = $("#tel").val();
		$.ajax({
			url:path+"custom.do?method=repeat",
			type:'post',
			data:{customtel:tel},
			dataType: 'json',
			success: function(mydata){
				if(mydata==1){
					layer.tips('手机号已存在！', $("#tel"), {
						tips : [ 2, 'red' ]
					});
					$("#tel").focus();
					$("#add").attr("disabled","disabled");
				}else{
					$("#add").attr("disabled",false);
				}
			}
		})
		if (tel.trim() == "") {
			layer.tips('手机号不能为空!', $("#tel"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (!(/^[1][3,4,5,7,8][0-9]{9}$/.test(tel))) {
			layer.tips('手机号格式不正确!', $("#tel"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	
	$("#name").blur(function(){
		var name = $("#name").val();
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
		var tel=$("#tel").val();
		var name = $("#name").val();
		if (name.trim() == "") {
			layer.tips('名称不能为空!', $("#name"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url:path+"custom.do?method=repeat",
			type:'post',
			data:{customtel:tel},
			dataType: 'json',
			success: function(mydata){
				if(mydata==1){
					layer.tips('手机号已存在！', $("#tel"), {
						tips : [ 2, 'red' ]
					});
					$("#tel").focus();
					$("#add").attr("disabled","disabled");
				}else{
					$("#add").attr("disabled",false);
				}
			}
		})
		if (tel.trim() == "") {
			layer.tips('手机号不能为空!', $("#tel"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (!(/^[1][3,4,5,7,8][0-9]{9}$/.test(tel))) {
			layer.tips('手机号格式不正确!', $("#tel"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : $("#path").val() + "custom.do?method=add",
			type : 'post',
			dataType : 'json',
			data : {
				customname : name.trim(),
				customtel: tel.trim()
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