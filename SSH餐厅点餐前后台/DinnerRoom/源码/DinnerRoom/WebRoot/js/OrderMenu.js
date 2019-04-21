function check() {
	var table_id = $("#table_id").val();
	var userCode = $("#userCode").val();
	var personNum = $("#personNum").val();
	var regpersonNum = /^[0-9]*$/;
	var count = $("input[name='id']:checked");
	if (table_id==-1) {
		bootbox.alert({
			size : "small",
			title : "系统提示",
			message : "请选择餐桌编号！"
		});
		return false;
	} else if (!userCode) {
		bootbox.alert({
			size : "small",
			title : "系统提示",
			message : "请输入下单人编号！"
		});
		return false;
	} else if (!personNum) {
		bootbox.alert({
			size : "small",
			title : "系统提示",
			message : "请输入用餐人数！"
		});
		return false;
	} else if (!regpersonNum.test(personNum)) {
		bootbox.alert({
			size : "small",
			title : "系统提示",
			message : "请输入整数！"
		});
		return false;
	}else if (count.length == 0) {
		bootbox.alert({
			size : "small",
			title : "系统提示",
			message : "请选择菜肴！"
		});
		return false;
	}else {
		return true;
	}
}
	$(function() {
		$('#myTab li:eq(0) a').tab('show');
		var str = "<span name='aok'>完成</span>";
		$("button[name='isok']").click(function() {
			$(this).find("input[name='id']").attr("checked", "checked");
			$(this).attr("disabled", "disabled");
			$(this).addClass("btn-danger");
			$(this).append(str);
		});
		$("button[name='res']").click(function() {
			$(this).prev().find("input[name='id']").removeAttr("checked");
			$(this).siblings("button[name='isok']").removeAttr("disabled");
			$(this).siblings("button[name='isok']").removeClass("btn-danger");
			$(this).prev().find("span[name='aok']").remove();
		});
		$("#jiesuan").click(function() {
			if(!check()){return;}
			bootbox.confirm({
				size : "small",
				title : "系统提示",
				message : "确定订单？",
				callback : function(result) { /* result is a boolean; true = OK, false = Cancel*/
					if (result) {
						var count = $("input[name='id']:checked");
						var ids=new Array();
						var counts=new Array();
						var ranks=new Array();
						$.each(count, function(index, dom) {
							var ck = $(this).is(":checked");
							if (ck) {
								var id = $(this).val();
								ids.push(id);
							}
							var rank = $(this).parents("section").contents("p").find("input[name='rank']").val();
							if(!rank){
								rank="无";
							}
							ranks.push(rank);
							var count = $(this).parents("section").contents("p").find("input[name='count']").val();
							counts.push(count);
						});
						var table_id = $("#table_id").val();
						var userCode = $("#userCode").val();
						var personNum = $("#personNum").val();
						$.post("dingcan","tableid="+table_id+"&userCode="+userCode+"&personNum="+personNum+"&ids="+ids+"&counts="+counts+"&ranks="+ranks,function(res){
							if(res==1){
								bootbox.alert({
									size : "small",
									title : "系统提示",
									message : "下单成功！",
									callback: function(){ 
										location.reload();  //刷新
									}
								});
							}else{
								bootbox.alert({
									size : "small",
									title : "系统提示",
									message : "下单失败！"
								});
							}
						});
					}
				}
			});
		});
		$("#outOrder").click(function() {
			bootbox.confirm({
				size : "small",
				title : "系统提示",
				message : "清空全部信息？",
				callback : function(result) { /* result is a boolean; true = OK, false = Cancel*/
					if (result) {
						location.reload();
					}
				}
			});
		});
		$("button[name='jiancount']").click(function() {
			var count = parseFloat($(this).siblings("input[name='count']").val());
			if(count<=1){
				return;
			}
			$(this).siblings("input[name='count']").val(parseFloat(count)-1);
		});
		$("button[name='jiacount']").click(function() {
			var count = parseFloat($(this).siblings("input[name='count']").val());
			if(count>=10){
				return;
			}
			$(this).siblings("input[name='count']").val(parseFloat(count)+1);
		});

	});