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
     //分页并查询
	getAllByPage();
	myadd();
});

function getAll(){
	if($.inArray("查询赠品入库",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	if($.inArray("增加赠品出卖出库",ids)==-1){
		$("#btn_add").remove();
	}
	if($.inArray("查询赠品出卖出库",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
}

function getAllByPage()
{
	  $('#tb_departments').bootstrapTable({
            url: path+'salezp.do?method=alls',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            dataType:'json',
            toolbar: false,                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            pagination: true,                   //是否显示分页（*）
            
            
            queryParams: queryParams,
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [5,10, 25, 50, 100],       //可供选择的每页的行数（*）
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            clickToSelect: false,                //是否启用点击选中行
            rowStyle:function rowStyle(row, index) {
            	if(row.inhandoutid!=null){
            		return {
                 	   css: {"line-height": "30px"}
                 	 };
            	}
            },
            
            height: heg-300,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "inhandoutid",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            iconsPrefix: 'fa',
            onPostBody:function(){
            },
            columns: [{
                field: 'inhandoutid',
                title: '编号',
                align : 'center'
            }, {
                field: 'handoutname',
                title: '赠品名称',
                align : 'center',
            },
             {
            	 title : '查看详细',  
                 field : 'inhandoutid',  
                 align : 'center',
                 formatter : function(value, row, index) {  
                	 var e="";
                	 e='<div class="ckinfo"><a href="'+path+'outhandout/sale.jsp?hid='+value+'"><button type="button" class="btn btn-outline btn-default">'
              			+'<span>查看详细</span></button></a></div>';
                	 return e; 
                  }
             }]
        });
	  	function queryParams(params) {
			  return {
				  limit: params.limit,   //页面大小(每一页要显示多少条)
	              offset: params.offset,
			  };
		  }
	  	getAll();
}


function myadd(){
	$("#btn_add").click(function() {
		layer.open({
			type : 2,
			title : '赠品出卖',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '400px', '550px' ],
			content : path + "outhandout/add.jsp",
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				$('#tb_departments').bootstrapTable('refresh');
			}
		});
	});	
}
