$(function() {
			$("#btn").click(function() {
				var oldpwdre = $("#oldpwdre").val();
				var oldpwd = $("#oldpwd").val();
				var newpwd = $("#newpwd").val();
				var uid = $("#uid").val();
				if(oldpwd==""){
					layer.msg('请输入原密码！');
					return;
				}
				if(newpwd==""){
					layer.msg('请输入新密码！');
					return;
				}
				if(oldpwdre==oldpwd){
					$.post("upuserpwd","uid="+uid+"&Uppwd="+newpwd,function(res){
						if(res==1){
							layer.msg('修改成功！');
							$("#newpwd").val("");
							$("#oldpwd").val("");
						}else{
							layer.msg('修改失败！');
							$("#newpwd").val("");
							$("#oldpwd").val("");
						}
					});
				}else{
					layer.msg('原密码输入错误！');
				}
			});
		});