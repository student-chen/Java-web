var path;
var ids='';
$(function() {
	path=$("#path").val();
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	if($.inArray("查询赠品入库",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	loadData();
	bindAdd();
});

function loadData(){
	$.ajax({
		url : $("#path").val() + "inhandout.do?method=allh",
		type : 'post',
		dataType : 'json',
		data :'',
		success : function(mydata) {
			$.each(mydata,function(index,xx){
				$("#handout").append("<option value='"+xx.handoutid+"'>"+xx.handoutname+"</option>")
			})
		}
	})
}
function bindAdd() {

	$("#add").click(function() {
		var handoutid=$("#handout").val();
		$.ajax({
			url : $("#path").val() + "inhandout.do?method=add",
			type : 'post',
			dataType : 'json',
			data : {
				handoutid:handoutid
			},
			success : function(mydata) {
				parent.layer.msg("保存成功!", {
					icon : 1
				});
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			}
		});

	});
}