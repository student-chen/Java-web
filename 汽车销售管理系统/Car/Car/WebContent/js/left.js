var path;
$(function(){
	init();
})
function init() {
	var str=$("#actionids").val();
	var ids=str.split("、");
	if($.inArray('查询组织结构',ids)==-1){
		$("#zz").remove();
	}
	if($.inArray('查询职称设置',ids)==-1){
		$("#zc").remove();
	}
	if($.inArray('查询岗位结构',ids)==-1){
		$("#gw").remove();
	}
	if($.inArray('查询员工管理',ids)==-1){
		$("#yg").remove();
	}
	if($.inArray('查询系统模块',ids)==-1 
			&& $.inArray('查询模块具体操作',ids)==-1 
			&& $.inArray('查询用户组设置',ids)==-1 
			&& $.inArray('查询用户权限设计',ids)==-1){
		$("#qxzx").remove();
	}
	if($.inArray('查询系统模块',ids)==-1){
		$("#mk").remove();
	}
	if($.inArray('查询模块具体操作',ids)==-1){
		$("#cz").remove();
	}
	if($.inArray('查询用户组设置',ids)==-1){
		$("#yh").remove();
	}
	if($.inArray('查询用户权限设计',ids)==-1){
		$("#qx").remove();
	}
	if($.inArray('查询汽车品牌',ids)==-1){
		$("#pp").remove();
	}
	if($.inArray('查询汽车系列',ids)==-1){
		$("#xl").remove();
	}
	if($.inArray('查询汽车赠品',ids)==-1){
		$("#zp").remove();
	}
	if($.inArray('查询存储仓库',ids)==-1){
		$("#ck").remove();
	}
	if($.inArray('查询采购申请',ids)==-1){
		$("#cg").remove();
	}
	if($.inArray('查询赠品入库',ids)==-1){
		$("#zprk").remove();
	}
	if($.inArray('查询车辆入库',ids)==-1){
		$("#clrk").remove();
	}
	if($.inArray('查询赠送出库',ids)==-1 
			&& $.inArray('查询赠品出卖出库',ids)==-1){
		$("#zpck").remove();
	}
	if($.inArray('查询赠送出库',ids)==-1){
		$("#zsck").remove();
	}
	if($.inArray('查询赠品出卖出库',ids)==-1){
		$("#cmck").remove();
	}
	if($.inArray('查询车辆出库',ids)==-1){
		$("#clck").remove();
	}
	if($.inArray('查询客户管理',ids)==-1){
		$("#kh").remove();
	}
	if($.inArray('查询汽车销售统计',ids)==-1
			&& $.inArray('查询赠品销售统计',ids)==-1){
		$("#xs").remove();
	}
	if($.inArray('查询汽车销售统计',ids)==-1){
		$("#qcxs").remove();
	}
	if($.inArray('查询赠品销售统计',ids)==-1){
		$("#zpxs").remove();
	}
	if($.inArray('查询售后管理',ids)==-1){
		$("#sh").remove();
	}
	if($.inArray('查询查询中心',ids)==-1){
		$("#zhcx").remove();
	}
}