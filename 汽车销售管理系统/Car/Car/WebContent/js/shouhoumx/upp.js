var path = "";
var flags;
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
	 if($.inArray("查询售后管理",ids)==-1){
			layer.msg("你没有权限!", {
				icon : 3
			});
			window.location.href=path+"main/main.jsp"; 
		}
	 loadData();
	// 分页并查询
	myadd();
	myblur();
});

function loadData(){
	var shouhoumxid=$("#id").val();
	$.ajax({
		url : $("#path").val() + "shoumx.do?method=one",
		type : 'post',
		dataType : 'json',
		data : {
			shouhoumxid:shouhoumxid
		},
		success : function(mydata) {
			if(mydata.shouhouflag==0){
				$("#shmoney").prop("disabled",false);
				$(".custom-radio input:eq(0)").prop("checked",true);
			}else{
				$("#shmoney").prop("disabled",true);
				$(".custom-radio input:eq(1)").prop("checked",true);
			}
			$("#shmoney").val(mydata.shmoney);
			$("#time").val(mydata.shtime);
			$("#fwnr").val(mydata.fwnr);
		}
	});
}

function myblur(){
		$(".custom-radio input").click(function(){
			var val = $(this).val();
			if(val==1){
				$("#shmoney").prop("disabled",true);
			}else{
				$("#shmoney").prop("disabled",false);
			}
		})
		$("#fwnr").blur(function(){
			var fwnr = $("#fwnr").val();
			if (fwnr.trim() == "") {
				layer.tips('费用不能为空!', $("#fwnr"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		$("#time").blur(function(){
			var time = $("#time").val();
			if (time.trim() == "") {
				layer.tips('时间不能为空!', $("#time"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
		$("#shmoney").blur(function(){
			var shmoney = $("#shmoney").val();
			if (shmoney.trim() == "") {
				layer.tips('费用不能为空!', $("#shmoney"), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^[1-9]\d*$/.test(shmoney))){
				layer.tips('费用为正整数!', $("#shmoney"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		})
}
function getAll() {
	if ($.inArray("查询售后管理", ids) == -1) {
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href = path + "main/main.jsp";
	}
}

function myadd() {
	$("#add").click(function() {
		var val = $(".custom-radio input:checked").val();
		var shmoney = $("#shmoney").val();
		var time = $("#time").val();
		var fwnr = $("#fwnr").val();
		var shouhoumxid=$("#id").val();
		if(val==0){
			if (shmoney.trim() == "") {
				layer.tips('费用不能为空!', $("#shmoney"), {
					tips : [ 2, 'red' ]
				});
				return;
			}else if(!(/^[1-9]\d*$/.test(shmoney))){
				layer.tips('费用为正整数!', $("#shmoney"), {
					tips : [ 2, 'red' ]
				});
				return;
			}
		}else{
			shmoney=0;
		}
		if (time.trim() == "") {
			layer.tips('时间不能为空!', $("#time"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		if (fwnr.trim() == "") {
			layer.tips('费用不能为空!', $("#fwnr"), {
				tips : [ 2, 'red' ]
			});
			return;
		}
		$.ajax({
			url : $("#path").val() + "shoumx.do?method=upp",
			type : 'post',
			dataType : 'json',
			data : {
				shmoney : shmoney,
				shtime : time,
				fwnr: fwnr,
				shouhoumxid:shouhoumxid,
				shouhouflag:val
			},
			success : function(mydata) {
				parent.layer.msg("修改成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);

			}
		});
		
	})
	
}
