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
	// 分页并查询
	myadd();
	myblur();
});

function myblur(){
		$(".custom-radio input").click(function(){
			var val = $(this).val();
			if(val==1){
				$("#sf").hide();
				$("#shmoney").prop("disabled",true);
			}else{
				$("#sf").show();
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
		var shouhouid=$("#id").val();
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
			url : $("#path").val() + "shoumx.do?method=add",
			type : 'post',
			dataType : 'json',
			data : {
				shmoney : shmoney,
				shtime : time,
				fwnr: fwnr,
				shouhouid:shouhouid,
				shouhouflag:val
			},
			success : function(mydata) {
				parent.layer.msg("添加成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);

			}
		});
		
	})
	
}
