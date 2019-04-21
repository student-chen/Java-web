var path = "";
var flags;
var f1=false;
var f2=false;
var f3=false;
var ids='';
$(function() {
	var heg = $(window).height();
	path = $("#path").val();
	 var str=$("#actionids").val();
	 if(str!=null){
		 ids=str.split("、");
	 }else{
		 ids="";
	 }
	if($.inArray("查询车辆入库明细",ids)==-1){
			layer.msg("你没有权限!", {
				icon : 3
			});
			window.location.href=path+"incar/incar.jsp"; 
	}
	if($.inArray("增加车辆入库明细",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"incar/incar.jsp"; 
	}
	// 分页并查询
	loadData();
	myadd();
	myblur();
});

function check(){
	if(f1 && f2 && f3){
		$("#adds").attr("disabled",false);
	}else{
		$("#adds").attr("disabled",true);
	}
}


function myblur(){
		$("#color").blur(function(){
			var color = $("#color").val();
			if (color.trim() == "") {
				layer.tips('颜色不能为空!', $("#color"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		$("#shouzi").blur(function(){
			var size = $("#shouzi").val();
			if (size.trim() == "") {
				layer.tips('型号不能为空!', $("#shouzi"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		$("#img").blur(function(){
			var img = $("#img").val();
			if (img.length == 0) {
				layer.tips('请选择图片!', $("#img"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		$("#price").blur(function(){
			var price = $("#price").val();
			if (price.trim() == "") {
				layer.tips('价格不能为空!', $("#price"), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^[1-9]\d*$/.test(price))){
				layer.tips('价格为正整数!', $("#price"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		$("#newprice").blur(function(){
			var price = $("#newprice").val();
			if (price.trim() == "") {
				layer.tips('价格不能为空!', $("#newprice"), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^[1-9]\d*$/.test(price))){
				layer.tips('价格为正整数!', $("#newprice"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		
		$("#cjh").blur(function(){
			var cjh = $("#cjh").val();
			if (cjh.trim() == "") {
				layer.tips('车架号不能为空!', $("#cjh"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
			$.ajax({
				url : path + "incarmx.do?method=rea",
				type : 'post',
				data :{carcjh:cjh},
				dataType : 'json',
				async: false,
				success : function(mydata) {
					if(mydata!=0){
						layer.tips('车架号已存在!', $("#cjh"), {
							tips : [ 2, 'red' ]
						});
						$("#cjh").focus();
						f1=false;
					}else{
						f1=true;
					}
				}
			})
			check();
		})
		$("#hgz").blur(function(){
			var hgz = $("#hgz").val();
			if (hgz.trim() == "") {
				layer.tips('合格证不能为空!', $("#hgz"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
			$.ajax({
				url : path + "incarmx.do?method=rea",
				type : 'post',
				data :{carhgz:hgz},
				dataType : 'json',
				async: false,
				success : function(mydata) {
					if(mydata!=0){
						layer.tips('合格证已存在!', $("#hgz"), {
							tips : [ 2, 'red' ]
						});
						$("#hgz").focus();
						f2=false;
					}else{
						f2=true;
					}
				}
			})
			check();
		})
		$("#fdjh").blur(function(){
			var fdjh = $("#fdjh").val();
			if (fdjh.trim() == "") {
				layer.tips('发动机号不能为空!', $("#fdjh"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
			$.ajax({
				url : path + "incarmx.do?method=rea",
				type : 'post',
				data :{carfdjh:fdjh},
				dataType : 'json',
				async: false,
				success : function(mydata) {
					if(mydata!=0){
						layer.tips('发动机号已存在!', $("#fdjh"), {
							tips : [ 2, 'red' ]
						});
						$("#fdjh").focus();
						f3=false;
					}else{
						f3=true;
					}
				}
			})
			check();
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
function getAll() {
	if ($.inArray("查询赠品入库", ids) == -1) {
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href = path + "main/main.jsp";
	}
}

function loadData() {
	$.ajax({
		url : path + "storehouse.do?method=alls",
		type : 'post',
		data :'',
		dataType : 'json',
		success : function(mydata) {
			$.each(mydata,function(index,xx){
				$("#house").append("<option value='"+xx.storeid+"'>"+xx.storename+"</option>");
			})
		}
	})
}

function myadd() {
	var f1=false;
	var f2=false;
	var f3=false;
	$("#adds").click(function() {
		var color = $("#color").val();
		var size = $("#shouzi").val();
		var img = $("#img").val();
		var price = $("#price").val();
		var newprice = $("#newprice").val();
		var note = $("#note").val();
		var did = $("#did").val();
		var storeid = $("#house").val();
		var incarid=$("#id").val();
		var hgz = $("#hgz").val();
		var cjh = $("#cjh").val();
		var fdjh = $("#fdjh").val();
		if (fdjh.trim() == "") {
			layer.tips('发动机号不能为空!', $("#fdjh"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : path + "incarmx.do?method=rea",
			type : 'post',
			data :{carfdjh:fdjh},
			dataType : 'json',
			async: false,
			success : function(mydata) {
				if(mydata!=0){
					layer.tips('发动机号已存在!', $("#fdjh"), {
						tips : [ 2, 'red' ]
					});
					f3=false;
				}else{
					f3=true;
				}
			}
		})
		if (hgz.trim() == "") {
			layer.tips('合格证不能为空!', $("#hgz"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : path + "incarmx.do?method=rea",
			type : 'post',
			data :{carhgz:hgz},
			dataType : 'json',
			async: false,
			success : function(mydata) {
				if(mydata!=0){
					layer.tips('合格证已存在!', $("#hgz"), {
						tips : [ 2, 'red' ]
					});
					f2=false;
				}else{
					f2=true;
				}
			}
		})
		
		if (cjh.trim() == "") {
			layer.tips('车架号不能为空!', $("#cjh"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : path + "incarmx.do?method=rea",
			type : 'post',
			data :{carcjh:cjh},
			dataType : 'json',
			async: false,
			success : function(mydata) {
				if(mydata!=0){
					layer.tips('车架号已存在!', $("#cjh"), {
						tips : [ 2, 'red' ]
					});
					f1=false;
				}else{
					f1=true;
				}
			}
		})
		if (newprice.trim() == "") {
			layer.tips('价格不能为空!', $("#newprice"), {
				tips : [ 2, 'red' ]
			});
			return;
		}else if(!(/^[1-9]\d*$/.test(newprice))){
			layer.tips('价格为正整数!', $("#newprice"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (color.trim() == "") {
			layer.tips('颜色不能为空!', $("#color"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		
		if (price.trim() == "") {
			layer.tips('价格不能为空!', $("#price"), {
				tips : [ 2, 'red' ]
			});
			return;
		}else if(!(/^[1-9]\d*$/.test(price))){
			layer.tips('价格为正整数!', $("#price"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (size.length == 0) {
			layer.tips('型号不能为空!', $("#shouzi"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (img.length == 0) {
			layer.tips('请选择图片!', $("#img"), {
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
//		if(f1 && f2 && f3){
//			$("#adds").attr("disabled",false);
//		}else{
//			$("#adds").attr("disabled",true);
//		}
		$.ajaxFileUpload({
		    url:path+'incarmx.do?method=add',
		    secureuri:false,//一般设置为false
		    fileElementId:['img'],//上传对象 
		    data:{
		      carcolor:color,
		      carshouzi:size,
		      storeid:storeid,
			  incarprice:price,
			  outcarprice:newprice,
			  carchanshu:note,
			  incarid:incarid,
		      carcjh:cjh,
		      carhgz:hgz,
			  carfdjh:fdjh,
			  detailid:did			  
			 }, //上传控件以外的控件对应的参数
		    dataType: 'json', 
		    success:function(mydata,status)
		    	 {
		    		parent.layer.msg('增加成功!!',{icon:1});
		    		var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		    		parent.layer.close(index); 
		    	 },
	             error: function (data, status, e)//服务器响应失败处理函数
	              {
		    	      
		    	      parent.layer.msg('成功!!',{icon:1});
			    	  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
		              parent.layer.close(index);
	               }
		       });
	});
	
}
