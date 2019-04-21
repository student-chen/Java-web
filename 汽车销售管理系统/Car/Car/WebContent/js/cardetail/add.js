var path;
$(function() {
	path=$("#path").val();
	$("#name").focus();
	loadData();
	onblur();
	bindAdd();
});
function loadData(){
	$.ajax({
		url : $("#path").val() + "sort.do?method=alls",
		type : 'post',
		dataType : 'json',
		data : '',
		success : function(mydata) {
				$.each(mydata,function(index,xx){
					$("#sort").append("<option value='"+xx.sortid+"'>"+xx.sortname+"</option>");
				})
		}
	});
}

function onblur() {
	$("#name").blur(function(){
		var name = $("#name").val();
		if (name.trim() == "") {
			layer.tips('名称不能为空!', $("#name"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	$("#guige").blur(function(){
		var guige = $("#guige").val();
		if (guige.trim() == "") {
			layer.tips('车型不能为空!', $("#guige"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	$("#time").blur(function(){
		var time = $("#time").val();
		if (time.trim() == "") {
			layer.tips('时间不能为空!', $("#time"), {
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
		var flag=$("#flag").val();
		var name = $("#name").val();
		var guige=$("#guige").val();
		var sort = $("#sort").val();
		var time=$("#time").val();
		var note = $("#note").val();
		if (name.trim() == "") {
			layer.tips('名称不能为空!', $("#name"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (guige.trim() == "") {
			layer.tips('车型不能为空!', $("#guige"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (time.trim() == "") {
			layer.tips('时间不能为空!', $("#time"), {
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
			url : $("#path").val() + "cardetail.do?method=add",
			type : 'post',
			dataType : 'json',
			data : {
				detailname : name.trim(),
				sortid: sort.trim(),
				detailguige:guige,
				detailtime:time,
				detailremark:note,
				detailflag:flag
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