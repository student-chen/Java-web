var path;
var pids;
$(function() {
	path=$("#path").val();
	$("#name").focus();
	loadData();
	onblur();
	bindAdd();
});
function onblur() {
	$("#name,#parentPart").blur(function(){
		var parentPart = $("#parentPart").val();
		var name = $("#name").val();
		var old = $("#old").val();
		var note = $("#note").val();
		$.ajax({
			url:path+"gw.do?method=repeat",
			type:'post',
			data:{name:name,pid:parentPart,old:old},
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
	var id=$("#id").val();
	$.ajax({
		url : $("#path").val() + "gw.do?method=one",
		type : "post",
		dataType : "json",
		async : false,
		data:{gid:id},
		success : function(data) {
			$.each(data,function(index, x) {
				if(x.gid!=0){
					$("#name").val(x.gname);
					$("#old").val(x.gname);
					$("#note").val(x.gremark);
					pids=x.pid;
				}else{
					if(pids==x.pid){
						$("#parentPart").append("<option value=" + x.pid + " selected='selected'>" + x.zjmc+ "</option>");
					}else{
						$("#parentPart").append("<option value=" + x.pid + ">" + x.zjmc+ "</option>");
					}
				}
			});

		}

	});
}

function bindAdd() {

	$("#add").click(function() {
		var id = $("#id").val();
		var parentPart = $("#parentPart").val();
		var name = $("#name").val();
		var note = $("#note").val();
		
		if (parentPart.trim() == "-1") {

			layer.tips('请选择上级', $("#parentPart"), {
				tips : [ 2, 'red' ]
			});

			return;
		}

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
			url : $("#path").val() + "gw.do?method=upp",
			type : 'post',
			dataType : 'json',
			data : {
				gid:id.trim(),
				pid : parentPart.trim(),
				gname : name.trim(),
				gremark: note.trim()
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