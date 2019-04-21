var path="";
var ids='';
var flags;
var heg;
$(function(){
	heg=$(window).height();
	$("#divbody").css("height",heg);
	path=$("#path").val();
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	getAll();
	back();
     //分页并查询
	loadData();
});
function getAll(){
	if($.inArray("查询赠品销售统计",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
}
function back(){
	$("#back").click(function(){
		history.back();
	})
}
function loadData(){
	$.ajax({
		url : path + "sort.do?method=alls",
		type : 'post',
		data :'',
		dataType : 'json',
		success : function(mydata) {
			$.each(mydata,function(index,xx){
				$("#sort1").append("<option value='"+xx.sortid+"'>"+xx.sortname+"</option>");
				$("#sort2").append("<option value='"+xx.sortid+"'>"+xx.sortname+"</option>");
			})
		}
	})
}


