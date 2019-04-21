var path;
var id;
$(function() {
	path=$("#path").val();
	id=$("#id").val();
	$("#note").focus();
	onblur();
	bindAdd();
});
function onblur() {
	$("#note").blur(function(){
		var note = $("#note").val();
		if (note.trim() == "") {
			layer.tips('意见不能为空!', $("#note"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	
}
function bindAdd() {

	$("#agree").click(function() {
		var note=$("#note").val();
		if (note.trim() == "") {
			layer.tips('意见不能为空!', $("#note"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : path + "purchase.do?method=uppss",
			type : 'post',
			data : {purchaseid:id,purchaseflag:3,suggestion:note},
			dataType : 'json',
			async : false,
			success : function(mydata) {
				layer.msg("审核成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		})
	});
	
	$("#disagree").click(function() {
		var note=$("#note").val();
		if (note.trim() == "") {
			layer.tips('意见不能为空!', $("#note"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : path + "purchase.do?method=uppss",
			type : 'post',
			data : {purchaseid:id,purchaseflag:4,suggestion:note},
			dataType : 'json',
			async : false,
			success : function(mydata) {
				layer.msg("审核成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		})
	});
	
	$("#back").click(function() {
		var note=$("#note").val();
		if (note.trim() == "") {
			layer.tips('意见不能为空!', $("#note"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : path + "purchase.do?method=uppss",
			type : 'post',
			data : {purchaseid:id,purchaseflag:2,suggestion:note},
			dataType : 'json',
			async : false,
			success : function(mydata) {
				layer.msg("审核成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		})
	});
}