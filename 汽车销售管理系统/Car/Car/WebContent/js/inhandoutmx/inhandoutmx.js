var path="";
var ids='';
var flags;
var heg;
var counts=0;
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
	back();
     //分页并查询
	getAllByPage();
	myadd();
});

function back(){
	$("#back").click(function(){
		history.back();
	})
}

function getAll(){
	if($.inArray("查询赠品入库",ids)==-1){
		layer.msg("你没有权限!", {
			icon : 3
		});
		window.location.href=path+"main/main.jsp"; 
	}
	if($.inArray("增加赠品入库",ids)==-1){
		$("#btn_add").remove();
	}
}

function getAllByPage()
{
	  $('#tb_departments').bootstrapTable({
            url: path+'inhandoutmx.do?method=all',         //请求后台的URL（*）
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
            		counts+=row.inhandoutnum;
            		return {
                 	   css: {"line-height": "30px"}
                 	 };
            	}
            },
            
            height: heg-300,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "inhandoutmxid",                     //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            iconsPrefix: 'fa',
            onPostBody:function(){
            	myupp();
            },
            columns: [{
                field: 'inhandoutmxid',
                title: '编号',
                align : 'center'
            }, {
                field: 'handoutimg',
                title: '赠品图片',
                align : 'center',
                formatter : function(value, row, index) {  
	               	 var e="";
	               	 e='<img src="'+path+'upload/'+value+'" alt="'+row.handoutname+'" width="50px" height="50px">';
	               	 return e; 
                 }
            }, {
                field: 'handoutname',
                title: '赠品名称',
                align : 'center'
            },
            {
                field: 'handoutcolor',
                title: '赠品颜色',
                align : 'center'
            }, 
            {
                field: 'handoutsize',
                title: '赠品尺寸',
                align : 'center'
            }, 
            {
                field: 'inhandoutnum',
                title: '赠品数量',
                align : 'center'
            }, 
            {
                field: 'storename',
                title: '所在仓库',
                align : 'center'
            }, 
            {
                field: 'handouttime',
                title: '入库时间',
                align : 'center'
            }, 
            {
                field: 'zjmc',
                title: '经办人单位',
                align : 'center'
            },
            {
                field: 'mrealname',
                title: '经办人',
                align : 'center'
            },
            {
            	 field: 'inhandoutmxid',
                 title: '操作',
                 align : 'center',
                 formatter : function(value, row, index) {  
                	 var e="";
                	 if($.inArray("修改赠品入库",ids)==-1){
                		 e='<div><button type="button" class="btn btn-outline btn-default">'
                    			+'<span><i class="fa fa-ban"></i>&nbsp;&nbsp;不可操作</span></button></div>';
                	 }else{
                		 e='<div class="upp"><input type="hidden" value="'+row.handoutid+'"><input type="hidden" value="'+row.inhandoutid+'"><button type="button" class="btn btn-outline btn-default">'
               				+'<span><a href="javascript:void(0)">修改</a></span></button></div>';
                	 }
                	 return e; 
                  }
             }]
        });
	  	function queryParams(params) {
	  		var id=$("#id").val();
			  return {
				  limit: params.limit,   //页面大小(每一页要显示多少条)
	              offset: params.offset,
	              inhandoutid:id
			  };
		  }
	 getAll();
}

function myupp(){
	$("#tools span b").empty();
	$("#tools span b").append(counts);
	counts=0;
	$(".upp").click(function(){
		var id=$(this).parent().parent().find("td:eq(0)").text();
		var name=$(this).parent().parent().find("td:eq(2)").text();
		var hid=$(this).find("input:eq(0)").val();
		var ihid=$(this).find("input:eq(1)").val();
		var index = layer.open({
			type : 2,
			title : '入库明细',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '400px', '550px' ],
			content : path + "inhandoutmx/upp.jsp?id="+id+"&hid="+hid+"&ihid="+ihid+"&name="+name,
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				$('#tb_departments').bootstrapTable('refresh');
			}
		});
		
	})
}

function myadd(){
	$("#btn_add").click(function() {
		var name=$("#name").val();
		var id=$("#id").val();
		var hid=$("#hid").val();
		layer.open({
			type : 2,
			title : '填写入库详细信息',
			fix : false,
			shadeClose : true,
			maxmin : true,
			area : [ '400px', '550px' ],
			content : path + "inhandoutmx/add.jsp?name="+name+"&id="+id+"&hid="+hid,
			skin : 'layui-layer-lan',
			shift : 4, // 0-6的动画形式，-1不开启
			end : function() {
				$('#tb_departments').bootstrapTable('refresh');
			}
		});
	});	
}

