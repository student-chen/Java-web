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
	inits();
     //分页并查询
	getAllByPage();
	//增加
	myadd();
	//修改
});

function inits(){
	 $.ajax({
         url:path+'purchase.do?method=examine',
         type:'post',
         data:'',
         dataType:'json',
         async: false,
           success:function(data){
			 flags=data;
           }
   	});
	if(flags==1){
		$("#btn_add").hide();
		$("#sel option:eq(1)").hide();
	}
}

function getAll(){
	if($.inArray("查询采购申请",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	if($.inArray("增加采购申请",ids)==-1){
		$("#btn_add").remove();
	}
}

function getAllByPage()
{
	  $('#tb_departments').bootstrapTable({
            url: path+'purchase.do?method=all',         //请求后台的URL（*）
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
            	return {
            	   css: {"line-height": "30px"}
            	 };
            },
            
            height: heg-300,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "pmxid",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            iconsPrefix: 'fa',
            onPostBody:function(){
            	oneinfo();
            	opera();
            },
            columns: [{
                field: 'purchaseid',
                title: '编号',
                align : 'center'
            }, {
                field: 'purtitle',
                title: '申请标题',
                align : 'center',
                formatter : function(value, row, index) {
               	 	var e="<a href='javascript:void(0)' class='oneinfo'>\'"+value+"\'</a>";
               	 	return e;
                }
            }, {
                field: 'pmoney',
                title: '预算资金（/万）',
                align : 'center'
            }, {
                field: 'deptname',
                title: '申请分销点',
                align : 'center'
            }, {
                field: 'mname',
                title: '申请人',
                align : 'center'
            }, {
                field: 'ptime',
                title: '申请时间',
                align : 'center'
            }, {
                field: 'flag',
                title: '审批状态',
                align : 'center',
                cellStyle: function cellStyle(value, row, index, field) { 
	                	if(value=='审批已通过'){
	                		return { css: {'color': 'green','font-weight':'bold',"line-height": "30px"} } 
	                	}else if(value=='审批未通过'){
	                		return { css: {'color': 'red','font-weight':'bold',"line-height": "30px"} } 
	                	}else if(value=='审批之中'){
	                		return { css: {'color': 'blue','font-weight':'bold',"line-height": "30px"} } 
	                	}else if(value=='审批未发送'){
	                		return { css: {'color': 'blue','font-weight':'bold',"line-height": "30px"} } 
	                	}
                	}
            }, {
                field: 'suggestion',
                title: '审批意见',
                align : 'center'
            }, {
                field: 'mrealname',
                title: '审批人',
                align : 'center'
            },
             {
            	 title : '操作',  
                 field : 'purchaseid',  
                 align : 'center',
                 formatter : function(value, row, index) {  
                	 var e="";
                	 if(flags==1){
                		 //总经理
                		 if(row.purchaseflag==1){
                    		 e='<div class="check"><button type="button" class="btn btn-outline btn-default">'
                     			+'<span><a href="javascript:void(0)">审核</a></span></button></div>';
                    	 }else{
                    		 e='<div class="look"><button type="button" class="btn btn-outline btn-default">'
                      			+'<span><a href="javascript:void(0)">查看</a></span></button></div>';
                    	 }
                	 }else{
                		 //部门经理
                		 if(row.purchaseflag==0){
                			 //发送权限
                			 if($.inArray("发送采购申请",ids)!=-1){
                				 e='<div><button type="button" class="btn btn-outline btn-default">'
                          			+'<span class="send"><a href="javascript:void(0)">发送审批</a></span></button></div>';
                			 }else{
                				 e='<div><button type="button" class="btn btn-outline btn-default">'
                          			+'<span><i class="fa fa-ban"></i>&nbsp;&nbsp;不可操作</span></button></div>';
                			 }
                    	 }else if(row.purchaseflag==1 || row.purchaseflag==3 || row.purchaseflag==4){
                    		 e='<div class="look"><button type="button" class="btn btn-outline btn-default">'
                      			+'<span><a href="javascript:void(0)">查看审批</a></span></button></div>';
                    	 }else if(row.purchaseflag==2){
                    		 e='<div><button type="button" class="btn btn-outline btn-default">';
                    		 //修改权限
                    		 if($.inArray("修改采购申请",ids)!=-1){
                    			 e+='<span class="update"><a href="javascript:void(0)">修改</a></span></button>&nbsp;&nbsp;';
                    		 }else{
                    			 e+='<span><i class="fa fa-ban"></i>&nbsp;&nbsp;不可操作</span></button>&nbsp;&nbsp;'
                    		 }
                    		 e+='<button type="button" class="btn btn-outline btn-default">';
                    		 //发送权限
                    		 if($.inArray("发送采购申请",ids)!=-1){
                    			 e+='<span class="send"><a href="javascript:void(0)">发送审批</a></span></button></div>';
                    		 }else{
                    			 e+='<span><i class="fa fa-ban"></i>&nbsp;&nbsp;不可操作</span></button></div>'
                    		 }
                    	 }
                	 }
                	 return e; 
                  }
             }]
        });
	  	function queryParams(params) {
	  		var purchaseflag;
	  		if($("#flag").val()==1){
	  			purchaseflag=$("#flag").val();
	  			$(".panel-body").hide();
	  		}else{
	  			purchaseflag=$("#sel").val();
	  		}
	  		var mids=$("#mids").val();
			  return {
				  limit: params.limit,   //页面大小(每一页要显示多少条)
	              offset: params.offset,
				  purchaseflag: purchaseflag,
				  mid:mids
			  };
		  }
	  	
	  	$("#btn_query").click(function() {
		  $('#tb_departments').bootstrapTable('refresh');
		});
	  	getAll();
}

function oneinfo(){
	$(".oneinfo").click(function(){
		var id=$(this).parent().prev().text();
		var index = layer.open({
			type : 2,
			title : '采购申请明细',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '900px', '600px' ],
			content : path + "purchase/upp.jsp?id="+id,
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				window.location.href=path+"purchase/purchase.jsp"; 
			}
		});
		
	})
}

function myadd(){
	$("#btn_add").click(function() {
		var index = layer.open({
			type : 2,
			title : '采购申请',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '400px', '300px' ],
			content : path + "purchase/add.jsp",
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				window.location.href=path+"purchase/purchase.jsp"; 
			}
		});
	});	
}

function opera(){
	$(".send").click(function(){
		var id=$(this).parent().parent().parent().parent().find("td:eq(0)").text();
		var money=$(this).parent().parent().parent().parent().find("td:eq(2)").text();
		if(money==0){
			layer.msg("您还没有填写采购项!", {
				icon : 2
			});
			return false;
		}
		$.ajax({
			url : path + "purchase.do?method=upps",
			type : 'post',
			data : {purchaseid:id,purchaseflag:1},
			dataType : 'json',
			async : false,
			success : function(mydata) {
				layer.msg("发送成功!", {
					icon : 1
				});
				window.location.href=path+"purchase/purchase.jsp"; 
			}
		})
	})
	$(".check").click(function(){
		var id=$(this).parent().parent().find("td:eq(0)").text();
		var index = layer.open({
			type : 2,
			title : '采购申请审核',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '400px', '300px' ],
			content : path + "purchase/check.jsp?id="+id,
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				window.location.href=path+"purchase/purchase.jsp?flag=1"; 
			}
		});
	})
	$(".look").click(function(){
		var id=$(this).parent().parent().find("td:eq(0)").text();
		var index = layer.open({
			type : 2,
			title : '采购申请明细',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '900px', '600px' ],
			content : path + "purchase/upp.jsp?id="+id,
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				window.location.href=path+"purchase/purchase.jsp"; 
			}
		});
	})
	$(".update").click(function(){
		var id=$(this).parent().parent().parent().parent().find("td:eq(0)").text();
		var index = layer.open({
			type : 2,
			title : '采购申请明细',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '900px', '600px' ],
			content : path + "purchase/upp.jsp?id="+id,
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				window.location.href=path+"purchase/purchase.jsp"; 
			}
		});
	})
}

