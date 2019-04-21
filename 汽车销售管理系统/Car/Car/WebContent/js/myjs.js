var path="";
$(function(){

	path=$("#path").val();
     //分页并查询
	getAllByPage();
	//增加
	myadd();
	//修改
	myupp();
	//删除
	mydel();
});


function getAllByPage()
{
      $('#tb_departments').bootstrapTable({
            url: path+'user_all.action',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            dataType:'json',
            toolbar: '#toolbar',                //工具按钮用哪个容器
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
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 1,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "uid",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'uid',
                title: '员工编号'
            }, {
                field: 'uname',
                title: '员工姓名'
            }, {
                field: 'upsw',
                title: '员工密码'
            },
             {
            	 title : '操作',  
                 field : 'uid',  
                 align : 'center',
                 formatter : function(value, row, index) {  
                    var e = '<a href="#"  onclick="edit(\''+ value + '\')">编辑</a> ';  
                    var d = '<a href="#"  onclick="del(\''+ value + '\')">删除</a> ';  
                    return e + d;
                  }
             }
            ]});
}

function edit(obj)
{
   alert(obj);	
}

function del(obj)
{
	alert(obj);
}

function myadd()
{
	$("#btn_add").click(function(){
		alert("增加动作");
	});
	
}

function myupp()
{
	$("#btn_edit").click(function(){
		 //得到你要修改的记录的编号(数组)！
		   var tt=$.map($('#tb_departments').bootstrapTable('getSelections'),function(row) {
			   return row.uid; 
           });
		if(tt.length>1)
			{
			   alert("每次只能修改一个");
			}
		else if(tt.length==0)
			{
			   alert("请选择一个你要修改的对象");
			}
		else
			{
			   alert(tt[0]);
		       alert("修改对象");
			}
		  
	});
	
}

function mydel()
{
	$("#btn_delete").click(function(){
	
		 //得到你要删除的记录的编号(数组)！
		   var tt=$.map($('#tb_departments').bootstrapTable('getSelections'), function(row) {
			   return row.uid;
           });
		 if(tt.length<=0)
			 {
			    alert("请选择一个你要删除的对象");
			 }
		 else
			 {
			    alert(tt);
		        alert("删除动作");
			 }
		
	});
	
}

