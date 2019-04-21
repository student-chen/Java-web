var rr=false;
$(function(){
	$("#name").focus();
	init();
	getPwd();
	getSub();
})

function init(){
	var name=$("#name").val();
	$("#name").bind("blur",function(){
		var name=$("#name").val();
		var path=$("#path").val();
		var myemp="mname="+name;
		if(name.length==0){
			layer.tips('对不起，请输入账号！','#name',{tips:[2,'red']});
			$("#name").focus();
		}else{
			return checkName();
		}
		
	})
}

function getPwd(){
	$("#pwd").bind("blur",function(){
		var name=$("#name").val();
		var pwd=$("#pwd").val();
		var path=$("#path").val();
		if(name.length==0){
			layer.tips('对不起，请输入登录名！','#name',{tips:[2,'red']});
		}else if(pwd.length==0){
			layer.tips('对不起，请输入密码！','#pwd',{tips:[2,'red']});
		}else{
			var path=$("#path").val();
			$.ajax({
				url:path+'master.do?method=login',
				data:{mname:name,mpsw:pwd},
				datatype:'json',
				type:'post',
				async: false,
				success:function(mydata){
					if(mydata==1){
						layer.tips('账号不存在,请重新输入！','#name',{tips:[2,'red']});
						rr=false;
					}else if(mydata==2){
						layer.tips('密码错误,请重新输入！','#pwd',{tips:[2,'red']});
						rr=false;
					}else{
						rr=true;
					}
				}
			})
		}
	})
};

function getSub(){
	$("#login").bind("click",function(){
		var ff;
		var name=$("#name").val();
		var pwd=$("#pwd").val();
		var path=$("#path").val();
		if(name.length==0){
			layer.tips('对不起，请输入账号！','#name',{tips:[2,'red']});
			return false;
		}else if(pwd.length==0){
			layer.tips('对不起，请输入密码！','#pwd',{tips:[2,'red']});
			return false;
		}else if(pwd.length!=0 && name.length!=0){
			return check();
		}
	})
};
function checkName(){
	var name=$("#name").val();
	var path=$("#path").val();
	$.ajax({
		url:path+'master.do?method=find',
		data:{mname:name},
		datatype:'json',
		type:'post',
		async: false,
		success:function(mydata){
			if(mydata==0){
				layer.tips('账号不存在,请重新输入！','#name',{tips:[2,'red']});
				$("#name").focus();
				rr=false;
			}else{
				rr=true;
			}
		}
	})
	return rr;
}

function check(){
		var name=$("#name").val();
		var pwd=$("#pwd").val();
		var emp="emp.ename="+name+"&emp.epsw="+pwd;
		var path=$("#path").val();
		$.ajax({
			url:path+'master.do?method=login',
			data:{mname:name,mpsw:pwd},
			datatype:'json',
			type:'post',
			async: false,
			success:function(mydata){
				if(mydata==1){
					layer.tips('账号不存在,请重新输入！','#name',{tips:[2,'red']});
					rr=false;
				}else if(mydata==2){
					layer.tips('密码错误,请重新输入！','#pwd',{tips:[2,'red']});
					rr=false;
				}else{
					rr=true;
				}
			}
		})
		return rr;
}
