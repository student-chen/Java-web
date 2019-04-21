			function check() {
				var logname = $("#logname").val();
                var logpass = $("#logpass").val();
                if(logname==""){
                    layer.msg('请输入用户名', {
                        time: 2000, //2s后自动关闭
                    });
                    return false;
				}else if(logpass==""){
                    layer.msg('请输入密码', {
                        time: 2000, //2s后自动关闭
                    });
                    return false;
				}else{
                    return true;
				}
            }
			$(function () {
				//alert($.cookie('user'));
				if($.cookie('user')=="user1"){
					location.href='admin/index';
					return;
				}
				if($.cookie('user')=="user2"){
					location.href='qtIndex';
					return;
				}
				$("#loginbtn").click(function () {
				    if(!check()){
				        return;
					}
                    var logname = $("#logname").val();
                    var logpass = $("#logpass").val();
					$.post("login","logname="+logname+"&logpass="+logpass,function (res) {
						if(res==-1){
							layer.msg('此用户已登陆', {
		                        time: 2000, //2s后自动关闭
		                    });
							return;
						}
						var json = JSON.parse(res);
						if(res=="null"){
							layer.msg('此用户不存', {
		                        time: 2000, //2s后自动关闭
		                    });
							$("#logname").val("");
							$("#logpass").val("");
							return;
						}
						if(logpass==json.UPwd){
							if(json.URole==1 || json.URole==2){
								$.cookie('user', 'user1', { path: '/' });
								//alert($.cookie('user'));
								location.href='admin/index';
								return;
							}
							if(json.URole==3){
								$.cookie('user', 'user2', { path: '/' });
								location.href='qtIndex';
							}else{
								layer.msg('无权限', {
			                        time: 2000, //2s后自动关闭
			                    });
								$("#logname").val("");
								$("#logpass").val("");
							}
						}else{
							layer.msg('密码错误', {
		                        time: 2000, //2s后自动关闭
		                    });
							$("#logpass").val("");
						}
                    });
                });
            });