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
	 if($.inArray("查询车辆入库明细",ids)==-1){
			layer.msg("你没有权限!", {
				icon : 3
			});
			window.location.href=path+"incar/incar.jsp"; 
	}
	// 分页并查询
	loadData();
});
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
}
