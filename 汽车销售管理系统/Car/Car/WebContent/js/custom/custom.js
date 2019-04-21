var path="";
var ids='';
var gid="";
$(function(){
	var heg=$(window).height();
	$("#divbody").css("height",heg);
	path=$("#path").val();
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	gid=$("#groupid").val();
	if(gid==1){
		 //分页并查询
		getAllByPage();
	}else{
		 //分页并查询
		getAllByPage2();
	}
    
	//增加
	myadd();
});

function getAll(){
	if($.inArray("查询客户管理",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	if($.inArray("增加客户管理",ids)==-1){
		$("#btn_add").remove();
	}
}

function getAllByPage()
{
      $('#tb_departments').bootstrapTable({
            url: path+'custom.do?method=all',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            dataType:'json',
            toolbar: false,                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            pagination: true,                   //是否显示分页（*）
            
            
            queryParams: queryParams,//传递参数（*）
            rowStyle:function rowStyle(row, index) {
            	if(row.customname!=null){
            		return {
                 	   css: {"line-height": "30px"}
                 	 };
            	}
            },
            
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [5,10, 25, 50, 100],       //可供选择的每页的行数（*）
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            clickToSelect: false,                //是否启用点击选中行
            
            
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "customid",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            iconsPrefix: 'fa',
            columns: [{
                field: 'customid',
                title: '编号',
                align : 'center'
            }, {
                field: 'customname',
                title: '客户名称',
                align : 'center'
            },{
                field: 'customtel',
                title: '客户电话',
                align : 'center'
            },{
                field: 'mrealname',
                title: '所属员工',
                align : 'center'
            }
            ]
        });
      	function queryParams(params) {
			  return {
				  limit: params.limit,   //页面大小(每一页要显示多少条)
	              offset: params.offset,
			  };
		  }
      	getAll();
}

//普通员工
function getAllByPage2()
{
      $('#tb_departments').bootstrapTable({
            url: path+'custom.do?method=limit2',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            dataType:'json',
            toolbar: false,                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            pagination: true,                   //是否显示分页（*）
            
            
            queryParams: queryParams,//传递参数（*）
            rowStyle:function rowStyle(row, index) {
            	if(row.customname!=null){
            		return {
                 	   css: {"line-height": "30px"}
                 	 };
            	}
            },
            
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 5,                       //每页的记录行数（*）
            pageList: [5,10, 25, 50, 100],       //可供选择的每页的行数（*）
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            clickToSelect: false,                //是否启用点击选中行
            
            
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "customid",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            iconsPrefix: 'fa',
            columns: [{
                field: 'customid',
                title: '编号',
                align : 'center'
            }, {
                field: 'customname',
                title: '客户名称',
                align : 'center'
            },{
                field: 'customtel',
                title: '客户电话',
                align : 'center'
            },{
                field: 'mrealname',
                title: '所属员工',
                align : 'center'
            }
            ]
        });
      	function queryParams(params) {
      		var mids=$("#mids").val();
			  return {
				  limit: params.limit,   //页面大小(每一页要显示多少条)
	              offset: params.offset,
				  mid:mids
			  };
		  }
      	getAll();
}



function myadd()
{
	$("#btn_add").click(function() {
		var index = layer.open({
			type : 2,
			title : '添加客户',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '500px', '300px' ],
			content : path + "custom/add.jsp",
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				window.location.href=path+"custom/custom.jsp"; 
			}
		});
	});	
	
}


