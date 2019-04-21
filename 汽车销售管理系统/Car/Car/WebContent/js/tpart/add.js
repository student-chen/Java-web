var path;
$(function() {
	path=$("#path").val();
	$("#part").focus();
	loadData();
	onblur();
	bindAdd();
});
function onblur() {
	$("#part,#parentPart").blur(function(){
		var parentPart = $("#parentPart").val();
		var p=parentPart.split("、");
		var pid=p[0];
		var zjid=p[1];
		var part = $("#part").val();
		var note = $("#note").val();
		$.ajax({
			url:path+"part.do?method=repeat",
			type:'post',
			data:{zjmc:part,sjid:zjid},
			dataType: 'json',
			success: function(mydata){
				if(mydata==1){
					layer.tips('名称已存在！', $("#part"), {
						tips : [ 2, 'red' ]
					});
					$("#add").attr("disabled","disabled");
				}else{
					$("#add").attr("disabled",false);
				}
			}
			
		})
		if (part.trim() == "") {
			layer.tips('名称不能为空!', $("#part"), {
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
function loadData() {

	$.ajax({
		url : $("#path").val() + "/part.do?method=all",
		type : "post",
		dataType : "json",
		async : false,
		success : function(data) {

			$.each(data,
					function(index, x) {
						$("#parentPart").append(
								"<option value=" + x.zjid + "、"+x.zjid+">" + x.zjmc
										+ "</option>");

					});

		}

	});
}

function bindAdd() {

	$("#add").click(function() {
		var part = $("#part").val();
		var note = $("#note").val();
		var parentPart = $("#parentPart").val();
		var p=parentPart.split("、");
		var pid=p[0];
		var zjid=p[1];
		if (parentPart.trim() == "-1") {

			layer.tips('请选择上级', $("#parentPart"), {
				tips : [ 2, 'red' ]
			});

			return;
		}

		if (part.trim() == "") {
			layer.tips('名称不能为空!', $("#part"), {
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
			url : $("#path").val() + "/part.do?method=add",
			type : 'post',
			dataType : 'json',
			data : {

				sjid : pid.trim(),
				zjmc : part.trim(),
				zjjs : note.trim()
			},
			success : function(mydata) {
				parent.layer.msg("添加成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);

			}
		});

		/*
		 * var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		 * parent.layer.close(index);
		 */
	});
}