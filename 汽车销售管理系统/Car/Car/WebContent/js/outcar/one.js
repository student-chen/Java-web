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
//	 if($.inArray("查询车辆入库明细",ids)==-1){
//			layer.msg("你没有权限!", {
//				icon : 3
//			});
//			window.location.href=path+"incar/incar.jsp"; 
//	}
//	if($.inArray("查询车辆详细信息",ids)==-1){
//			layer.msg("你没有权限!", {
//				icon : 3
//			});
//			window.location.href=path+"incar/incar.jsp"; 
//	}
	// 分页并查询
	loadData();
	check();
});
function check(){
	$("#tab tr:gt(10)").each(function(){
		if($(this).find("td").length<2){
			var size=2-$(this).find("td").length;
			for (var i = 0; i < size; i++) {
				$(this).append("<td colspan='2'>---</td>");
			}
		}
	})
}
function loadData() {
	var id=$("#id").val();
	$.ajax({
		url : path + "incarmx.do?method=one",
		type : 'post',
		data :{incarmxid:id},
		dataType : 'json',
		success : function(xx) {
					$("#color").text(xx.carcolor);
					$("#detailname").text(xx.detailname);
					$("#price").text(xx.incarprice);
					$("#newprice").text(xx.outcarprice);
					$("#guige").text(xx.detailguige);
					$("#shouzi").text(xx.carshouzi);
					$("#cjh").text(xx.carcjh);
					$("#hgz").text(xx.carhgz);
					$("#fdjh").text(xx.carfdjh);
					$("#storename").text(xx.storename);
					$("#img").attr("src",path+'upload/'+xx.carimg);
					$("#chanshu").text(xx.carchanshu);
					
					$("#color").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#detailname").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#price").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#newprice").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#guige").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#shouzi").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#cjh").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#hgz").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#fdjh").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#storename").css({"color":"#4b5f6f","font-weight":"bold"});
					$("#chanshu").css({"color":"#4b5f6f","font-weight":"bold"});
		}
	})
	$.ajax({
		url : path + "fujian.do?method=alls",
		type : 'post',
		data :{incarmxid:id},
		dataType : 'json',
		async: false,
		success : function(mydate) {
			var str="";
			$.each(mydate,function(index,xx){
				$("#customname").text(xx.customname);
				$("#customtel").text(xx.customtel);
				$("#customname").css({"color":"#4b5f6f","font-weight":"bold"});
				$("#customtel").css({"color":"#4b5f6f","font-weight":"bold"});
				if(index%2==0){
					str+="<tr><td colspan='2'>"+xx.handoutname+"</td>";
				}else{
					str+="<td colspan='2'>"+xx.handoutname+"</td></tr>";
				}
			})
			$("#tab").append(str);
		}
	})
}
