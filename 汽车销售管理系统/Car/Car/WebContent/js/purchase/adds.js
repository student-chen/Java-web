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
function getAll() {
	if ($.inArray("查询汽车品牌", ids) == -1) {
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href = path + "main/main.jsp";
	}
	if ($.inArray("增加汽车品牌", ids) == -1) {
		$("#btn_add").remove();
	}
}

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
				var str2="<tr style='text-align:center;'><td >"+xx.detailid+"</td>";
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
}

function myadd() {
	var allmoney=0;
	var purid=getPurid();
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
		$(".checkbox-grey:checked").each(function(){
			var detailid=$(this).val();
			var caigouprice=$(this).parent().parent().prev().prev().children().val();
			var caigoucount=$(this).parent().parent().prev().children().val();
			var all=caigouprice * caigoucount;
			allmoney+=all;
			$.ajax({
				url : path + "purcarmx.do?method=add",
				type : 'post',
				data :{purchaseid:purid,detailid:detailid,caigouprice:caigouprice,caigoucount:caigoucount},
				dataType : 'json',
				async : false,
				success : function(mydata) {
					layer.msg("保存成功!", {
						icon : 1
					});
				}
			})
		})
		uppMoney(purid,allmoney);
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	});
	
}

//得到外键 purchaseid
function getPurid(){
	var purchaseid;
	$.ajax({
		url : path + "purchase.do?method=last",
		type : 'post',
		data : '',
		dataType : 'json',
		async : false,
		success : function(mydata) {
			purchaseid=mydata
		}
	})
	return purchaseid;
}
//修改预算资金
function uppMoney(purid,allmoney){
	$.ajax({
		url : path + "purchase.do?method=upp",
		type : 'post',
		data :{purchaseid:purid,pmoney:allmoney},
		dataType : 'json',
		async : false,
		success : function(mydata) {
			layer.msg("保存成功!", {
				icon : 1
			});
		}
	})
}
