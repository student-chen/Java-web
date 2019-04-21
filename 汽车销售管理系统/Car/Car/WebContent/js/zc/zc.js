var path;
var heg;
var ids='';
$(function(){
	path=$("#path").val();
	heg=$(window).height()/7;
	heg=heg*6;
	var str=$("#actionids").val();
	if(str!=null){
		ids=str.split("、");
	}else{
		ids="";
	}
	getAllByPage();
	getAdd();
	myupp();
	init();
})
function getAll(){
	if($.inArray("查询职称设置",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href = path + "main/main.jsp";
	}
	if($.inArray("增加职称设置",ids)==-1){
		$("#btn_add").remove();
	}
}
function getAllByPage(){
	$('#tb_departments').bootstrapTable({
        url: path+'zc.do?method=all',         //请求后台的URL（*）
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
        
        
        height: heg,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "zid",                     //每一行的唯一标识，一般为主键列
        showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
        iconsPrefix: 'fa',
        columns: [{
            checkbox: true
        }, {
            field: 'zid',
            title: '职称编号',
            align : 'center'
        },{
            field: 'zname',
            title: '职称名称',
            align : 'center'
        },
        {
            field: 'zremark',
            title: '职称备注',
            align : 'center'
        }, 
         {
        	 title : '操作',  
             field : 'zid',  
             align : 'center',
             formatter : function(value, row, index) { 
            	 var e = '';
            	 if($.inArray("修改职称设置",ids)==-1){
            			$("#btn_edit").remove();
            			e='<div class="aa"><button type="button" class="btn btn-outline btn-default">'
                    			+'<span><i class="fa fa-ban"></i>&nbsp;&nbsp;不可操作</span>'+
                    		'</button></div>';  
            	 }else{
                   e='<div class="aa" onclick="edit('+ value + ')"><button type="button" class="btn btn-outline btn-default">'
                    			+'<span>编辑</span>'+
                    		'</button></div>'; 
            	 }
                 return e;
              }
         }]
    });
  getAll();
}

//增加
function   getAdd(){
	
	$("body").on("click","#btn_add",function(){
		//弹出一个层
		layer.open({
			type : 2,
			title : '添加职称',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '400px', '350px' ],
			content : path + "zc/add.jsp",
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				 getAll(1);
			}
		});
	});
}

function myupp()
{
	$("#btn_edit").click(function(){
		 //得到你要修改的记录的编号(数组)！
		   var tt=$.map($('#tb_departments').bootstrapTable('getSelections'),function(row) {
			   return row.zid; 
           });
		if(tt.length>1)
			{
			   layer.msg("每次只能修改一个!", {
					icon : 3
				});
			}
		else if(tt.length==0)
			{
			   layer.msg("请选择一个你要修改的对象!", {
					icon : 3
				});
			}
		else
			{
			   edit(tt[0])
			}
		  
	});
	
}


function edit(obj)
{
		var index = layer.open({
			type : 2,
			title : '修改职称',
			fix : false,     //此层是否固定(false--i不固定)
			shadeClose : true, //关闭按钮是否有(true有)
			maxmin : true,
			skin: 'layui-layer-lan', //加上边框
			area : [ '400px', '350px' ], //开始进来的面积
			content : path+'zc/upp.jsp?id='+obj, //包含的页面
			anim: 4, //动画类型
			end : function() {
				window.location.href=path+"zc/zc.jsp"; 
			}
		});
}
