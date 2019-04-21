var path;
$(function() {
	path=$("#path").val();
	$("#name").focus();
	loadData();
	onblur();
	bindAdd();
});
function loadData(){
	var id=$("#id").val();
	$.ajax({
		url:path+"group.do?method=one",
		type:'post',
		data:{groupid:id},
		dataType: 'json',
		success: function(mydata){
			$("#name").val(mydata.groupname);
			$("#old").val(mydata.groupname);
			$("#info").val(mydata.groupinfo);
		}
	})	
	
}
function onblur() {
	$("#name").blur(function(){
		var name = $("#name").val();
		var old = $("#old").val();
		$.ajax({
			url:path+"group.do?method=repeat",
			type:'post',
			data:{name:name,old:old},
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
		var info=$("#info").val();
		var name = $("#name").val();
		var id = $("#id").val();
		if (name.trim() == "") {
			layer.tips('名称不能为空!', $("#name"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : $("#path").val() + "group.do?method=upp",
			type : 'post',
			dataType : 'json',
			data : {
				groupid:id,
				groupname : name.trim(),
				groupinfo: info.trim()
			},
			success : function(mydata) {
				parent.layer.msg("修改成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);

			}
		});

	});
}