var path;
$(function() {
	path=$("#path").val();
	$("#name").focus();
	init();
	onblur();
	bindAdd();
});
function init(){
	var id=$("#id").val();
	$.ajax({
		url:path+"zc.do?method=one",
		type:'post',
		data:{zid:id},
		dataType: 'json',
		success: function(mydata){
			var x = mydata;
			$("#id").val(x.zid);
			$("#name").val(x.zname);
			$("#old").val(x.zname);
			$("#note").val(x.zremark);
		}
	})
}

function onblur() {
	$("#name").blur(function(){
		var name = $("#name").val();
		var old = $("#old").val();
		$.ajax({
			url:path+"zc.do?method=repeat",
			type:'post',
			data:{zname:name,old:old},
			dataType: 'json',
			success: function(mydata){
				if(mydata==1){
					layer.tips('名称已存在！', $("#name"), {
						tips : [ 2, 'red' ]
					});
					$("#add").attr("disabled","disabled");
					$("#name").focus();
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

		var name = $("#name").val();
		var note = $("#note").val();
		

		if (name.trim() == "") {
			layer.tips('名称不能为空!', $("#name"), {
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
			url : path + "zc.do?method=upp",
			type : 'post',
			dataType : 'json',
			data : {
				zname : name,
				zremark: note.trim()
			},
			success : function(mydata) {
				parent.layer.msg("修改成功!", {
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