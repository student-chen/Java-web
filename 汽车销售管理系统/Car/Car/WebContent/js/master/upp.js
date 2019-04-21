var path;
var pids;
var gids;
var zids;
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
		var name = $("#name").val();
		var old = $("#old").val();
		$.ajax({
			url:path+"master.do?method=repeat",
			type:'post',
			data:{mname:name,old:old},
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
		var oldtel = $("#oldtel").val();
		$.ajax({
			url:path+"master.do?method=repeat",
			type:'post',
			data:{mtel:tel,oldtel:oldtel},
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
	var id=$("#id").val();
	$("#zc").empty();
	$.ajax({
		url : $("#path").val() + "master.do?method=one",
		type : "post",
		dataType : "json",
		data:{mid:id},
		success : function(data) {
			$.each(data,function(index, x) {
				if(x.mname!=null){
					$("#name").val(x.mname);
					$("#old").val(x.mname);
					$("#oldtel").val(x.mtel);
					$("#realname").val(x.mrealname);
					$("#tel").val(x.mtel);
					pids=x.pid;
					zids=x.zid;
					gids=x.gid;
				}
				if(x.name!=null){
					if(pids==x.pid){
						$("#parentPart").append(
								"<option value=" + x.pid + " selected='selected'>" + x.zjmc
									+ "</option>");
					}else{
						$("#parentPart").append(
								"<option value=" + x.pid + ">" + x.zjmc
									+ "</option>");
					}
				}
				if(x.zname!=null){
					if(zids==x.zid){
						$("#zc").append(
								"<option value=" + x.zid + " selected='selected'>" + x.zname
									+ "</option>");
					}else{
						$("#zc").append(
								"<option value=" + x.zid + ">" + x.zname
									+ "</option>");
					}
				}
				if(x.gname!=null){
					if(gids==x.gid){
						$("#gw").append(
								"<option value=" + x.gid + " selected='selected'>" + x.gname
									+ "</option>");
					}
				}
			});
		}

	});
}

function bindAdd() {

	$("#add").click(function() {
		var id=$("#id").val();
		var parentPart = $("#parentPart").val();
		var gw = $("#gw").val();
		var name = $("#name").val();
		var psw = $("#psw").val();
		var realname = $("#realname").val();
		var tel = $("#tel").val();
		var zc = $("#zc").val();
		var img = $("#img").val();
		if (gw.trim() == "0") {

			layer.tips('请选择岗位', $("#gw"), {
				tips : [ 2, 'red' ]
			});

			return;
		}
		if (parentPart.trim() == "0") {
			layer.tips('请选择上级', $("#parentPart"), {
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
		if (psw.trim()== "") {
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

		$.ajaxFileUpload({
		    url:path+'master.do?method=upp',
		    secureuri:false,//一般设置为false
		    fileElementId:['img'],//上传对象 
		    data:{
		      "mid":id,
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
		    
		    	     parent.layer.msg('修改成功!!',{icon:1});
			         var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		             parent.layer.close(index);
		    	 }
		    	  ,
	             error: function (data, status, e)//服务器响应失败处理函数
	              {
		    	      
		    	      parent.layer.msg('修改成功!!',{icon:1});
			    	  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		              parent.layer.close(index);
	                                 
	               }
		       });

		/*
		 * var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		 * parent.layer.close(index);
		 */
	});
}