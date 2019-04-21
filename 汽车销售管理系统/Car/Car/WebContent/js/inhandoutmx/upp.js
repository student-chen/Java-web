var path = "";
var flags;
// var ids='';
$(function() {
	var heg = $(window).height();
	path = $("#path").val();
	// var str=$("#actionids").val();
	// if(str!=null){
	// ids=str.split("、");
	// }else{
	// ids="";
	// }
	// 分页并查询
	loadData();
	myadd();
	myblur();
});



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
		$("#size").blur(function(){
			var size = $("#size").val();
			if (size.trim() == "") {
				layer.tips('尺寸不能为空!', $("#size"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		$("#num").blur(function(){
			var num = $("#num").val();
			if (num.trim() == "") {
				layer.tips('数量不能为空!', $("#num"), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^[1-9]\d*$/.test(num))){
				layer.tips('数量为正整数!', $("#num"), {
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
	if ($.inArray("查询赠品入库", ids) == -1) {
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href = path + "main/main.jsp";
	}
}

function loadData() {
	var sid;
	var id=$("#id").val();
	$.ajax({
		url : path + "inhandoutmx.do?method=one",
		type : 'post',
		data :{inhandoutmxid:id},
		dataType : 'json',
		success : function(mydata) {
			$.each(mydata,function(index,xx){
				if(xx.handoutcolor!=null){
					$("#color").val(xx.handoutcolor);
					$("#size").val(xx.handoutsize)
					$("#num").val(xx.inhandoutnum);
					$("#note").val(xx.handoutremark);
					sid=xx.storeid;
				}else{
					if(sid==xx.storeid){
						$("#house").append("<option value='"+xx.storeid+"' selected='selected'>"+xx.storename+"</option>");
					}else{
						$("#house").append("<option value='"+xx.storeid+"'>"+xx.storename+"</option>");
					}
				}
				
			})
		}
	})
}

function myadd() {
	$("#adds").click(function() {
		var color = $("#color").val();
		var size = $("#size").val()
		var img = $("#img").val();
		var num = $("#num").val();
		var note = $("#note").val();
		var handoutid = $("#hid").val();
		var storeid = $("#house").val();
		var inhandoutid=$("#ihid").val();
		var id=$("#id").val();
		check(inhandoutid,num);
		if (color.trim() == "") {
			layer.tips('颜色不能为空!', $("#color"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (size.trim() == "") {
			layer.tips('尺寸不能为空!', $("#size"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (num.trim() == "") {
			layer.tips('数量不能为空!', $("#num"), {
				tips : [ 2, 'red' ]
			});
			return;
		}else if(!(/^[1-9]\d*$/.test(num))){
			layer.tips('数量为正整数!', $("#num"), {
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
		alert(inhandoutid)
		$.ajaxFileUpload({
		    url:path+'inhandoutmx.do?method=upp',
		    secureuri:false,//一般设置为false
		    fileElementId:['img'],//上传对象 
		    data:{
		      inhandoutmxid:id,
		      inhandoutid:inhandoutid,
		      handoutid:handoutid,
		      storeid:storeid,
			  handoutcolor:color,
			  handoutsize:size,
			  inhandoutnum:num,
			  handoutremark:note			  
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


function check(inhandoutid){
	$.ajax({
		url : path + "inhandoutmx.do?method=getCount",
		type : 'post',
		data :{inhandoutid:inhandoutid},
		dataType : 'json',
		async: false,
		success : function(mydata){
			if(mydata!=null){
				$("#counts").text(mydata.zong);
				$("#now").text(mydata.now);
				$("#handout").text(mydata.fui);
				$("#buy").text(mydata.buy);
			}
		}
	})
}

