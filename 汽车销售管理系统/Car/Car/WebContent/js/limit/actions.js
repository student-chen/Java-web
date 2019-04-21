var path="";
var ids="";
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
	if($.inArray("查询模块具体操作",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}else{
		 //分页并查询
		getAllByPage();	
	}
});


function getAllByPage()
{
      $('#tb_departments').bootstrapTable({
            url: path+"action.do?method=allaction",         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            dataType:'json',
            toolbar: false,                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            pagination: true,                   //是否显示分页（*）
            
            
            queryParams: function (params) {
                var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                   limit: params.limit,   //页面大小(每一页要显示多少条)
                   offset: params.offset  //从数据库第几条记录开始 
                };
             return temp;
            },//传递参数（*）
            
            
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [5,10, 25, 50, 100],       //可供选择的每页的行数（*）
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            clickToSelect: false,                //是否启用点击选中行
            rowStyle:function rowStyle(row, index) {
            	if(row.actionid!=null){
            		return {
                 	   css: {"line-height": "30px"}
                 	 };
            	}
            },
            
            height: heg-100,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "actionid",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            iconsPrefix: 'fa',
            columns: [{
                field: 'actionid',
                title: '操作编号',
                align : 'center'
            }, {
                field: 'actionname',
                title: '操作名称',
                align : 'center'
             },
            {
                field: 'module.modulename',
                title: '模块名称',
                align : 'center'
             }, {
                 field: 'mode',
                 title: '可见状态',
                 align : 'center',
                 cellStyle: function cellStyle(value, row, index, field) { 
	                	if(value=='可见'){
	                		return { css: {'color': 'green','font-weight':'bold'} } 
	                	}else{
	                		return { css: {'color': 'red','font-weight':'bold'} } 
	                	}
             	}
              }]
        });
}

