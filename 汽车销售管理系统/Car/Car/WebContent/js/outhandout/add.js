var path = "";
var flags;
var ids='';
$(function() {
	var heg = $(window).height();
	path = $("#path").val();
	$("#name").focus();
	 var str=$("#actionids").val();
	 if(str!=null){
		 ids=str.split("、");
	 }else{
		 ids="";
	 }
	// 分页并查询
	loadData();
	myadd();
	myblur();
});



function myblur(){
		$("#handout").blur(function(){
			var id=$(this).val();
			$.ajax({
				url : path + "inhandout.do?method=one",
				type : 'post',
				data :{inhandoutid:id},
				dataType : 'json',
				success : function(xx) {
					$("#num b").text(xx.inhandoutcount);
				}
			})
		})
	
		$("#name").blur(function(){
			var name = $("#name").val();
			if (name.trim() == "") {
				layer.tips('名称不能为空!', $("#name"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		$("#tel").blur(function(){
			var tel = $("#tel").val();
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
		$("#count").blur(function(){
			var count = $("#count").val();
			var cs=parseInt(count);
			var num=$("#num b").text();
			var n=(num);
			if (count.trim() == "") {
				layer.tips('数量不能为空!', $("#count"), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^[1-9]\d*$/.test(count))){
				layer.tips('数量为正整数!', $("#count"), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(cs>n){
				layer.tips('数量大于库存量!', $("#count"), {
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
function getAll() {
	if($.inArray("查询赠品出卖出库",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
}

function loadData() {
	$.ajax({
		url : path + "inhandout.do?method=alls",
		type : 'post',
		data :'',
		dataType : 'json',
		success : function(mydata) {
			$.each(mydata,function(index,xx){
				$("#handout").append("<option value='"+xx.inhandoutid+"'>"+xx.handoutname+"</option>");
				if(index==0){
					$("#num b").text(xx.inhandoutcount);
				}
			})
		}
	})
	getAll();
}

function myadd() {
	$("#adds").click(function() {
		var name = $("#name").val();
		var tel = $("#tel").val()
		var count = $("#count").val();
		var note = $("#note").val();
		var inhandoutid = $("#handout").val();
		var cs=parseInt(count);
		var num=$("#num b").text();
		var n=(num);
		if (name.trim() == "") {
			layer.tips('名称不能为空!', $("#name"), {
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
		if (!(/^[1][3,4,5,7,8][0-9]{9}$/.test(tel))) {
			layer.tips('手机号格式不正确!', $("#tel"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (count.trim() == "") {
			layer.tips('数量不能为空!', $("#count"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if(!(/^[1-9]\d*$/.test(count))){
			layer.tips('数量为正整数!', $("#count"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if(cs>n){
			layer.tips('数量大于库存量!', $("#count"), {
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
			url : path + "salezp.do?method=add",
			type : 'post',
			data :{kehuname:name,kehutel:tel,inhandoutid:inhandoutid,salecount:count,saleremark:note},
			dataType : 'json',
			success : function(mydata) {
				parent.layer.msg("添加成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		})
	});
	
}
