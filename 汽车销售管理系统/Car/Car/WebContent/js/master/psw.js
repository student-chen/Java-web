var path;
$(function() {
	path = $("#path").val();
	$("#psw").focus();
	onblur();
	bindAdd();
});
function onblur() {
	$("#psw").blur(function() {
		var psw = $("#psw").val();
		if (psw.trim() == "") {
			layer.tips('登录密码不能为空!', $("#psw"), {
				tips : [ 2, 'red' ]
			});
			$("#psw").focus();
		}
		$.ajax({
			url : path + "master.do?method=checkpsw",
			type : 'post',
			data : {
				psw : psw
			},
			dataType : 'json',
			success : function(mydata) {
				if (mydata == 0) {
					layer.tips('密码不正确！', $("#psw"), {
						tips : [ 2, 'red' ]
					});
					$("#psw").focus();
				}
			}
		})
	})
	$("#psw1").blur(function() {
		var psw1 = $("#psw1").val();
		if (psw1.trim() == "") {
			layer.tips('新密码不能为空!', $("#psw1"), {
				tips : [ 2, 'red' ]
			});
		}
	})
	$("#psw2").blur(function() {
		var psw2 = $("#psw2").val();
		var psw1 = $("#psw1").val();
		if (psw2.trim() == "") {
			layer.tips('确认密码不能为空!', $("#psw2"), {
				tips : [ 2, 'red' ]
			});
		}
		if (psw1 != psw2) {
			layer.tips('密码不一致!', $("#psw2"), {
				tips : [ 2, 'red' ]
			});
		}
	})
}

function bindAdd() {

	$("#add").click(function() {

		var psw = $("#psw").val();
		var psw1 = $("#psw1").val();
		var psw2 = $("#psw2").val();

		if (psw.trim() == "") {
			layer.tips('登录密码不能为空!', $("#psw"), {
				tips : [ 2, 'red' ]
			});
			$("#psw").focus();
			return false;
		}
		$.ajax({
			url : path + "master.do?method=checkpsw",
			type : 'post',
			data : {
				psw : psw
			},
			dataType : 'json',
			async: false,
			success : function(mydata) {
				if (mydata == 0) {
					layer.tips('密码不正确！', $("#psw"), {
						tips : [ 2, 'red' ]
					});
					$("#psw").focus();
					return false;
				}
			}
		})

		if (psw1.trim() == "") {
			layer.tips('新密码不能为空!', $("#psw1"), {
				tips : [ 2, 'red' ]
			});
			return false;
		}
		if (psw2.trim() == "") {
			layer.tips('确认密码不能为空!', $("#psw2"), {
				tips : [ 2, 'red' ]
			});
			return false;
		}
		if (psw1 != psw2) {
			layer.tips('密码不一致!', $("#psw2"), {
				tips : [ 2, 'red' ]
			});
			return false;
		}
		$.ajax({
			url : path + "master.do?method=psw",
			type : 'post',
			data : {
				psw : psw2
			},
			dataType : 'json',
			success : function(mydata) {
				if(mydata==1){
					layer.msg("修改成功!", {
						icon : 3
					});
					window.location.href=path+"master.do?method=exit"; 
				}
			}
		})
	});
}