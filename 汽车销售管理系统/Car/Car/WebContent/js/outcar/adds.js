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
});
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
		str1+="<th style='text-align:center;'>赠品名称</th>";
		str1+="<th style='text-align:center;'>选择</th></tr></thead>";
	$("#tab").append(str1);
	$("#tab").append("<tbody></tbody>");
	$.ajax({
		url : path + "inhandout.do?method=alls",
		type : 'post',
		data : '',
		dataType : 'json',
		async : false,
		success : function(mydata) {
			$.each(mydata, function(index, xx) {
				var str2="<tr style='text-align:center;'><td >"+xx.inhandoutid+"</td>";
					str2+="<td>"+xx.handoutname+"</td>";
					str2+="<td><div class='custom-checkbox'>";
					str2+="<input type='checkbox' value='"+xx.inhandoutid+"' id='inlineCheckbox"+xx.inhandoutid+"' class='checkbox-grey'>";
					str2+="<label for='inlineCheckbox"+xx.inhandoutid+"' id='Checkbox"+xx.inhandoutid+"'></label></div></td></tr>";
				$("#tab tbody").append(str2);
			})
		}
	})
}

function myadd() {
	$("#adds").click(function() {
		var s=$(".checkbox-grey:checked").val();
		if(s==null){
			layer.msg("至少选择一个!", {
				icon : 5
			});
			return;
		}
		$(".checkbox-grey:checked").each(function(){
			var inhandoutid=$(this).val();
			var caroutmxid=getcaroutid();
			$.ajax({
				url : path + "fujian.do?method=add",
				type : 'post',
				data :{inhandoutid:inhandoutid,caroutmxid:caroutmxid},
				dataType : 'json',
				async : false,
				success : function(mydata) {
					layer.msg("保存成功!", {
						icon : 1
					});
				}
			})
		})
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	});
	
}

//得到外键 caroutmxid
function getcaroutid(){
	var caroutmxid;
	$.ajax({
		url : path + "outcar.do?method=last",
		type : 'post',
		data : '',
		dataType : 'json',
		async : false,
		success : function(mydata) {
			caroutmxid=mydata
		}
	})
	return caroutmxid;
}
