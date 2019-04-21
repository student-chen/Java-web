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
		url:path+"cardetail.do?method=one",
		type:'post',
		data:{detailid:id},
		dataType: 'json',
		success: function(mydata){
			$.each(mydata,function(index,xx){
				if(xx.detailname!=null){
					$("#name").val(xx.detailname);
					$("#guige").val(xx.detailguige);
					$("#time").val(xx.detailtime);
					$("#note").val(xx.detailremark);
					if(xx.detailflag==1){
						$("#flag option:eq(0)").attr('selected','selected');
					}else{
						$("#flag option:eq(1)").attr('selected','selected');
					}
					ssid=xx.sortid;
				}else{
					if(xx.sortname!=null){
						if(xx.sortid==ssid){
							$("#sort").append("<option value='"+xx.sortid+"' selected='selected'>"+xx.sortname+"</option>");
						}else{
							$("#sort").append("<option value='"+xx.sortid+"'>"+xx.sortname+"</option>");
						}
					}
				}
			})
			
		}
	})	
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
		var id=$("#id").val();
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
			url : $("#path").val() + "cardetail.do?method=upp",
			type : 'post',
			dataType : 'json',
			data : {
				detailid : id.trim(),
				detailname : name.trim(),
				sortid: sort.trim(),
				detailguige:guige,
				detailtime:time,
				detailremark:note,
				detailflag:flag
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