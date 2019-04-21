var path="";
var ids='';
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
	if($.inArray("查询用户权限设计",ids)==-1){
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
            url: path+'group.do?method=all',         //请求后台的URL（*）
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
            
            
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "groupid",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            iconsPrefix: 'fa',
            columns: [{
                checkbox: true
            }, {
                field: 'groupid',
                title: '组别编号',
                align : 'center'
            }, {
                field: 'groupname',
                title: '组别名称',
                align : 'center'
            },
             {
            	 title : '操作',  
                 field : 'groupid',  
                 align : 'center',
                 formatter : function(value, row, index) {
                	 var e = '';
                	 if($.inArray("修改用户权限设计",ids)==-1){
                			$("#btn_edit").remove();
                			e='<div class="aa"><button type="button" class="btn btn-outline btn-default">'
	                    			+'<span><i class="fa fa-ban"></i>&nbsp;&nbsp;不可操作</span>'+
	                    		'</button></div>';  
                	 }else{
	                   e='<div class="aa" onclick="edits('+ value + ')"><button type="button" class="btn btn-outline btn-default">'
	                    			+'<span>设置权限</span>'+
	                    		'</button></div>'; 
                	 }
                    return e;
                  }
             }]
        });
}
function edits(obj)
{	
	window.location.href=path+"limit/limit.jsp?id="+obj; 
}




