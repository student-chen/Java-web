var path = "";
var ids='';
var id='';
var flags;
$(function() {
	var heg = $(window).height();
	path = $("#path").val();
	id=$("#id").val();
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	init();
	// 分页并查询
	loadData();
	myupp();
	myblur();
});
//权限
function init(){
	 $.ajax({
       url:path+'purchase.do?method=checks',
       type:'post',
       data:'',
       dataType:'json',
       async: false,
         success:function(data){
			 flags=data;
         }
 	});
	if(flags==1){
		$("#adds").hide();
	}
	if($.inArray("查询采购申请",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	if($.inArray("修改采购申请",ids)==-1){
		$("#adds").remove();
	}
}

//失去焦点
function myblur(){
	$(".price").each(function(){
		$(this).blur(function(){
			var price = $(this).val();
			if (price.trim() == "") {
				layer.tips('单价不能为空!', $(this), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^\d+(\.\d+)?$/.test(price))){
				layer.tips('单价必须为数字!', $(this), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
	})
	$(".count").each(function(){
		$(".count").blur(function(){
			var count = $(this).val();
			if (count.trim() == "") {
				layer.tips('数量不能为空!', $(this), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^\d+(\.\d+)?$/.test(count))){
				layer.tips('数量必须为数字!', $(this), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
	})
}

//加载表格
function loadData() {
	var str1="<thead><tr class='active'><th style='text-align:center;'>编号</th>";
		str1+="<th style='text-align:center;'>品牌名称</th>";
		str1+="<th style='text-align:center;'>系列名称</th>";
		str1+="<th style='text-align:center;'>汽车车型</th>";
		str1+="<th style='text-align:center;'>采购单价</th>";
		str1+="<th style='text-align:center;'>采购数量</th>";
		str1+="<th style='text-align:center;'>选择</th></tr></thead>";
	$("#tab").append(str1);
	$("#tab").append("<tbody></tbody>");
	$.ajax({
		url : path + "cardetail.do?method=alls",
		type : 'post',
		data : '',
		dataType : 'json',
		async : false,
		success : function(mydata) {
			$.each(mydata, function(index, xx) {
				var str2="<tr style='text-align:center;'><td class='detailid'>"+xx.detailid+"</td>";
					str2+="<td>"+xx.sort.sortname+"</td>";
					str2+="<td>"+xx.detailname+"</td>";
					str2+="<td>"+xx.detailguige+"</td>";
					str2+="<td style='text-align:center;'><input class='form-control price' type='text' style='width:80%' placeholder='请输入单价'/></td>";
					str2+="<td style='text-align:center;'><input class='form-control count' type='text' style='width:80%' placeholder='请输入数量'/></td>";
					str2+="<td><div class='custom-checkbox'>";
					str2+="<input type='checkbox' value='"+xx.detailid+"' id='inlineCheckbox"+xx.detailid+"' class='checkbox-grey'>";
					str2+="<label for='inlineCheckbox"+xx.detailid+"' id='Checkbox"+xx.detailid+"'></label></div></td></tr>";
				$("#tab tbody").append(str2);
			})
		}
	})
	getOne();
}

//得到初始化数据
function getOne(){
	$.ajax({
		url : path + "purcarmx.do?method=one",
		type : 'post',
		data : {purchaseid:id},
		dataType : 'json',
		async : false,
		success : function(mydata) {
			$.each(mydata, function(index, xx) {
				$(".detailid").each(function(){
					if($(this).text()==xx.detailid){
						$(this).parent().find(".price").val(xx.caigouprice);
						$(this).parent().find(".count").val(xx.caigoucount);
						$(this).parent().find("#inlineCheckbox"+xx.detailid+"").prop("checked",true);
					}
					if(xx.purchaseflag==1||xx.purchaseflag==3||xx.purchaseflag==4){
						$("#adds").attr("disabled","disabled");
					}
				})
			})
		}
	})
}
//删除之前数据
function mydel(){
	$.ajax({
		url : path + "purcarmx.do?method=del",
		type : 'post',
		data :{purchaseid:id},
		dataType : 'json',
		async : false,
		success : function(mydata) {
		}
	})
}
function myupp() {
	var allmoney=0;
	$("#adds").click(function() {
		$(".price").each(function(){
			var price = $(this).val();
			if (price.trim() == "") {
				layer.tips('单价不能为空!', $(this), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^\d+(\.\d+)?$/.test(price))){
				layer.tips('单价必须为数字!', $(this), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		$(".count").each(function(){
			var count = $(this).val();
			if (count.trim() == "") {
				layer.tips('数量不能为空!', $(this), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^\d+(\.\d+)?$/.test(count))){
				layer.tips('数量必须为数字!', $(this), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		var s=$(".checkbox-grey:checked").val();
		if(s==null){
			layer.msg("至少选择一个!", {
				icon : 5
			});
			return;
		}
		mydel();
		$(".checkbox-grey:checked").each(function(){
			var detailid=$(this).val();
			var caigouprice=$(this).parent().parent().prev().prev().children().val();
			var caigoucount=$(this).parent().parent().prev().children().val();
			var all=caigouprice * caigoucount;
			allmoney+=all;
			$.ajax({
				url : path + "purcarmx.do?method=add",
				type : 'post',
				data :{purchaseid:id,detailid:detailid,caigouprice:caigouprice,caigoucount:caigoucount},
				dataType : 'json',
				async : false,
				success : function(mydata) {
					layer.msg("保存成功!", {
						icon : 1
					});
				}
			})
		})
		uppMoney(allmoney);
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	});
	
}

//修改预算资金
function uppMoney(allmoney){
	$.ajax({
		url : path + "purchase.do?method=upp",
		type : 'post',
		data :{purchaseid:id,pmoney:allmoney},
		dataType : 'json',
		async : false,
		success : function(mydata) {
			layer.msg("保存成功!", {
				icon : 1
			});
		}
	})
}
