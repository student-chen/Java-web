var path="";
var ids='';
var flags;
var heg;
var counts=0;
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
	back();
     //分页并查询
	getAllByPage();
});

function back(){
	$("#back").click(function(){
		history.back();
	})
}

function getAll(){
	if($.inArray("查询赠品入库",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	if($.inArray("增加赠品入库",ids)==-1){
		$("#btn_add").remove();
	}
}

function getAllByPage(){
	var inhandoutid=$("#id").val();
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
