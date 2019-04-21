var path;
$(function() {
	path=$("#path").val();
	$("#name").focus();
	loadData();
	onblur();
	bindAdd();
});
function onblur() {
	$("#parentPart").blur(function(){
		var parentPart = $("#parentPart").val();
		$("#gw").empty();
		$.ajax({
			url:path+"gw.do?method=allgw",
			type:'post',
			data:{pid:parentPart},
			dataType: 'json',
			success: function(mydata){
				$.each(mydata,function(index,xx){
						$("#gw").append(
								"<option value='"+xx.gid+"'>"
									+xx.gname+"</option>");
					
				})
			}
		})
	})
	$("#name").blur(function(){
		var parentPart = $("#parentPart").val();
		var name = $("#name").val();
		var note = $("#note").val();
		$.ajax({
			url:path+"master.do?method=repeat",
			type:'post',
			data:{mname:name},
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
	$("#tel").blur(function(){
		var tel = $("#tel").val();
		$.ajax({
			url:path+"master.do?method=repeat",
			type:'post',
			data:{mtel:tel},
			dataType: 'json',
			success: function(mydata){
				if(mydata==1){
					layer.tips('手机号已存在！', $("#tel"), {
						tips : [ 2, 'red' ]
					});
					$("#tel").focus();
					$("#add").attr("disabled","disabled");
				}else{
					$("#add").attr("disabled",false);
				}
			}
		})
		if (tel.trim() == "") {
			layer.tips('手机号不能为空!', $("#tel"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (!(/^[1][3,4,5,7,8][0-9]{9}$/.test(tel))) {
			layer.tips('手机号格式不正确!', $("#tel"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	$("#psw").blur(function(){
		var psw = $("#psw").val();
		if (psw.trim() == "") {
			layer.tips('密码不能为空!', $("#psw"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	$("#realname").blur(function(){
		var realname = $("#realname").val();
		if (realname.trim() == "") {
			layer.tips('真实姓名不能为空!', $("#realname"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
	})
	
}
function loadData() {

	$.ajax({
		url : $("#path").val() + "part.do?method=all",
		type : "post",
		dataType : "json",
		async : false,
		success : function(data) {
			$.each(data,function(index, x) {
				$("#parentPart").append(
					"<option value=" + x.pid + ">" + x.zjmc
						+ "</option>");
				});
		}

	});
	$.ajax({
		url : $("#path").val() + "zc.do?method=allzc",
		type : "post",
		dataType : "json",
		async : false,
		success : function(data) {
			$.each(data,function(index, x) {
				$("#zc").append(
					"<option value=" + x.zid + ">" + x.zname
						+ "</option>");
				});
		}

	});
}

function bindAdd() {

	$("#add").click(function() {

		var parentPart = $("#parentPart").val();
		var gw = $("#gw").val();
		var name = $("#name").val();
		var psw = $("#psw").val();
		var realname = $("#realname").val();
		var tel = $("#tel").val();
		var img = $("#img").val();
		var zc = $("#zc").val();
		if (gw.trim() == "-1") {

			layer.tips('请选择岗位', $("#gw"), {
				tips : [ 2, 'red' ]
			});

			return;
		}
		if (gw==0) {
			layer.tips('请选择上级', $("#gw"), {
				tips : [ 2, 'red' ]
			});

			return;
		}
		if (name.trim() == "") {
			layer.tips('登录名不能为空!', $("#name"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (psw.trim() == "") {
			layer.tips('密码不能为空!', $("#psw"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		
		if (realname.trim() == "") {
			layer.tips('真实名不能为空!', $("#realname"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (!(/^[1][3,4,5,7,8][0-9]{9}$/.test(tel))) {
			layer.tips('手机号格式不正确!', $("#tel"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (tel.trim() == "") {
			layer.tips('手机号不能为空!', $("#tel"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (img.trim() == "") {
			layer.tips('请选择头像!', $("#img"), {
				tips : [ 2, 'red' ]
			});
			return;
		}

		$.ajaxFileUpload({
		    url:path+'master.do?method=add',
		    secureuri:false,//一般设置为false
		    fileElementId:['img'],//上传对象 
		    data:{
		      "pid":parentPart,
		      "gid":gw,
		      "zid":zc,
			  "mname":name,
			  "mpsw":psw,
			  "mrealname":realname,
			  "mtel":tel			  
			 }, //上传控件以外的控件对应的参数
		    dataType: 'json', 
		    success:function(mydata,status)
		    	 {
		    
		    	     parent.layer.msg('增加成功!!',{icon:1});
			         var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		             parent.layer.close(index);
		             window.location.href=path+"master/master.jsp"; 
		    	 }
		    	  ,
	             error: function (data, status, e)//服务器响应失败处理函数
	              {
		    	      
		    	      parent.layer.msg('增加成功!!',{icon:1});
			    	  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		              parent.layer.close(index);
		              window.location.href=path+"master/tpart/main.jsp"; 
	                                 
	               }
		       });

		/*
		 * var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		 * parent.layer.close(index);
		 */
	});
}