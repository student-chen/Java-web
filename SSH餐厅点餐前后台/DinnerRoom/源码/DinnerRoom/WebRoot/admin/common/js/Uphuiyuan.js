$(function() {
    		layui.use('form', function(){
    	        var form = layui.form;
    	    });
			$("#ret").click(function() {
				location.href='showMember';
			});
			$("#frm").submit(function() {
				var flag = true;
				if(!check()) flag=false;
				return flag;
			});
		});
    	function check() {
			var mname = $("#mname").val();
			var phone = $("#phone").val();
			var mtype = $("#mtype").val();
			var mcode = $("#mcode").val();
			var regcode = /^[0-9]*$/;
			var regphone = /^1[3|4|5|8|9|6|7][0-9]\d{4,8}$/;
			if(!mname){
				layer.msg('请输入姓名');
				return false;
			}else if(!phone){
				layer.msg('请输入手机号');
				return false;
			}else if(!regphone.test(phone)){
				layer.msg('手机号格式有误');
				return false;
			}else if(mtype==-1){
				layer.msg('请选择会员类型');
				return false;
			}else if(!mcode){
				layer.msg('请输入会员积分');
				return false;
			}else if(!regcode.test(mcode)){
				layer.msg('会员积分为整数');
				return false;
			}else{
				return true;
			}
		}