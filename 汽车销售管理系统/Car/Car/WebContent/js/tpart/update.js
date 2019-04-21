var path;
$(function() {
	path = $("#paths").val();
	$("#path").focus();
	getPart();
	onblur();
	bindUpdate();
	
});
function onblur() {
	$("#part").blur(function(){
		var part = $("#part").val();
		var old = $("#old").val();
		var sjid=$("#sjid").val();
		$.ajax({
			url:path+"part.do?method=repeat",
			type:'post',
			data:{zjmc:part,old:old,sjid:sjid},
			dataType: 'json',
			success: function(mydata){
				if(mydata==1){
					layer.tips('名称已存在！', $("#part"), {
						tips : [ 2, 'red' ]
					});
					$("#upp").attr("disabled","disabled");
				}else{
					$("#upp").attr("disabled",false);
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
function getPart() {
	var id=$("#id").val();
	$.ajax({
		url : path + "part.do?method=deptone&zjid="+id,
		type : 'post',
		dataType : 'json',
		data :'',
		success : function(mydata) {
			var x = mydata;
			$("#id").val(x.pid);
			$("#zjid").val(x.zjid);
			$("#sjid").val(x.sjid);
			$("#part").val(x.zjmc);
			$("#old").val(x.zjmc);
			$("#note").val(x.zjjs);
		}
	});
}

function bindUpdate() {
	$("#upp").click(function() {
		var pid = $("#pid").val();
		var zjid = $("#zjid").val();
		var sjid = $("#sjid").val();
		var zjmc = $("#part").val();
		var zjjs = $("#note").val();
		alert(zjmc);
		if (zjmc.length==0) {
			layer.tips('名称不能为空!', $("#part"), {
				tips : [ 2, 'red' ]
			});
			return false;
		}
		if (zjjs.length==0) {
			layer.tips('备注不能为空!', $("#note"), {
				tips : [ 2, 'red' ]
			});
			return false;
		}

		$.ajax({
			url : path + "part.do?method=upp",
			type : 'post',
			dataType : 'json',
			data : {
				pid : pid,
				sjid : sjid,
				zjid : zjid,
				zjmc : zjmc,
				zjjs : zjjs
			},
			success : function(mydata) {
				parent.layer.msg("修改成功", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);

			}
		});
	});
}