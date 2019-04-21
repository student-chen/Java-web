<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Bluth Company">
    <link rel="shortcut icon" href="assets/ico/favicon.html">
    
    <link href="<%=basePath %>assets/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=basePath %>bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css" />
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">	
    <link href="<%=basePath %>assets/css/theme.css" rel="stylesheet">
    <link href="<%=basePath %>assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=basePath %>assets/css/alertify.css" rel="stylesheet">
    <link rel="Favicon Icon" href="<%=basePath %>assets/favicon.ico">
    <script type="text/javascript" src="<%=basePath %>assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>assets/js/bootstrap.js"></script>
    <script src="<%=basePath %>bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
	<script src="<%=basePath %>bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
	    
    
    <script >
	  var root = "<%=request.getContextPath()%>"
		  var basePath = "<%=request.getScheme()%>"+"://"+"<%=request.getServerName()%>"+":"+<%=request.getServerPort()%>+root;
		  $(document).ready(function () {
			/*   selectUser(); */
			  initUserTable();
			  modalInit("myModal", null,null);
			  modalInit("myModal1", null,null);
			  modalInit("myModal2", null,null);
			  modalInit("myModal3", null,null);
			  
		  });
			function openModel(id,name) {
				$("#poooid").val(id);
				$("#pName").val(name);
				$("#myModal2").modal("show");
			}
			function add() {
				$("#myModal1").modal("show");
			}
			function openModel3(id) {
				$("#ploId").val(id);
				$("#myModal3").modal("show");
			}
			function btn3(){
			  	$.ajax({
							url :  root+"/policestation/del.do",
							type : "post",
							cache : false,
							data: {
								id : $('#ploId').val()
							},
							dataType : "json",
							error : function() {
								alert("暂时无法操作，请刷新后再试！");
							},
							success : function(result) {
								location.reload();
								 $('#myModal3').modal('hide');
								alert("删除成功");
							}
				});
			}
			function update(){
			  	$.ajax({
							url :  root+"/policestation/update.do",
							type : "post",
							cache : false,
							data: {
								id : $('#poooid').val(),
								name : $('#pName').val()
							},
							dataType : "json",
							error : function() {
								alert("暂时无法操作，请刷新后再试！");
							},
							success : function(result) {
								location.reload();
								$('#myModal2').modal('hide');
								alert(result);
							}
				});
			}
			function btn2(){
				var department=$('input:radio[name="department"]:checked').val();
				var typeName=$('input:radio[name="typeName"]:checked').val(); 
			  	$.ajax({
			  				url : root+"/policestation/add.do",
							type : "post",
							cache : false,
							data: {
								name : $('#policestationName').val()
							},
							dataType : "json",
							error : function() {
								alert("暂时无法操作，请刷新后再试！");
							},
							success : function(result) {
								location.reload();
								$('#myModal1').modal('hide');
								
								alert(result);
							}
				});
			}
	
			
			
			
			/**
			 * 初始化模态窗口
			 * @param modalName 模态窗口id
			 * @param showBcak show时执行的方法
			 * @param hideBcak hide时执行的方法
			 */
			function modalInit(modalName,showBcak,hideBcak)
			{
			    var modalName = '#' + modalName;
			  
			    
			    //模态框居中显示
			    function centerModals() {   
			        $(modalName).each(function(i){  
			            var $clone = $(this).clone().css('display', 'block').appendTo('body');
			            //设置modal垂直居中
			            var top = Math.round(($clone.height() - $clone.find('.modal-content').height()) / 2);   
			            top = top > 0 ? top : 0;   
			            $(this).find('.modal-content').css("margin-top", top);
			            $clone.remove();
			           
			        });
			    }
			    //调用show方法时触发
			    $(modalName).on('show.bs.modal', function(){
			        if (null != showBcak && "" != showBcak) {
			            var funcBack = eval(showBcak);
			            new funcBack();
			        }
			        centerModals();
			    });
			    //调用hide方法时触发
			    $(modalName).on('hide.bs.modal', function(){
			        if (null != hideBcak && "" != hideBcak)
			        {
			            var funcBack = eval(hideBcak);
			            new funcBack();
			        }
			        
			    });
			    $(window).on('resize', centerModals);  
			}
			
		  function initUserTable() {  
			    $('#userContent').bootstrapTable({
			    url : root + "/policestation/queryByOrderPage.do",
			    method: 'get',                      //请求方式
				striped: true,                      //是否显示行间隔色
				pagination: true,                   //是否显示分页
				sortable: true,                     //是否启用排序
				sortOrder: "asc",                   //排序方式
				pageNumber:1,                       //初始化加载第一页，默认第一页
				pageSize:10,                        //每页的记录行数
				pageList: [10,20,50,100],        //可供选择的每页的行数
				clickToSelect: true,                //是否启用点击选中行
				sidePagination:'server',
				queryParams : queryParams,
				queryParamsType : "limit",
				uniqueId: "id",                      //每一行的唯一标识，一般为主键列
				cardView: false,                     //是否显示详细视图
				detailView: false,                   //是否显示父子表
				search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端
				showRefresh: false,                  //是否显示刷新按钮
				searchAlign:'left', 
				toolbarAlign:'right',
				columns:[
					{
						title:'id',
						halign:'center',
						field:'id',
						width:35,
						height:35,
						formatter: function (value, row, index) { 
							return index+1; 
			            },
						align:'center'
					},
					{
						title:'派出所',
						width:25,
						halign:'center',
						field:'name',
						align:'center'
					},
					{
						title:'操作',
						halign:'center',
						width:150,
						align:'center',
						formatter: function (value, row, index) { 
							return '<button class="btn btn-primary btn-sm" onclick="openModel(' + row.id + ',\'' + row.name + '\')">修改</button><button class="btn btn-danger btn-sm" onclick="openModel3(' + row.id + ')">删除</button>'; 
			            }
					}
				]
			});
		  }  
			function queryParams(params) {
				return {
					pageSize : this.pageSize,
					pageNo : this.pageNumber,
					selectName : $("#selectName").val(),
				};
			}
			Date.prototype.Format = function (fmt) { 
		 	    var o = {
		 	        "M+": this.getMonth() + 1, //月份 
		 	        "d+": this.getDate(), //日 
		 	        "h+": this.getHours(), //小时 
		 	        "m+": this.getMinutes(), //分 
		 	        "s+": this.getSeconds(), //秒 
		 	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
		 	        "S": this.getMilliseconds() //毫秒 
		 	    };
		 	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		 	    for (var k in o)
		 	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		 	    return fmt;
		 	}
			function selCount(){
		  		$('#userContent').bootstrapTable('refresh');
		  		$("#selectName").val(''),
				$("#start").val(''),
				$("#end").val(''),
				$("#policeStation").val('')
		  	}
			
    </script>
  </head>
  <body>
    <div id="wrap">
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <div class="logo"> 
          	<span style="color: white;font-size: 24px;">公安管理系统</span>
           <!-- <img src="assets/img/logo.png" alt="Realm Admin Template">-->
          </div>
           <a class="btn btn-navbar visible-phone" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
           <a class="btn btn-navbar slide_menu_left visible-tablet">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>

          <div class="top-menu visible-desktop">
            <ul class="pull-right">  
              <li><a href="<%=basePath %>login.jsp"><i class="icon-off"></i> 退出</a></li>
            </ul>
          </div>

        
        </div>
      </div>
    </div>

   
     
      <!-- Side menu -->
      <div class="sidebar-nav nav-collapse collapse">
        <div class="user_side clearfix">
          <img src="<%=basePath %>assets/img/odinn.jpg" alt="无法显示">
          <h5>${ sessionScope.user.name}</h5>
              
        </div>
        <div class="accordion" id="accordion2">
          <div class="accordion-group">
            <div class="accordion-heading">
              <a class="accordion-toggle active b_F79999" href="<%=basePath %>user/index.do" ><i class="icon-dashboard"></i> <span>控制台</span></a>
            </div>
          </div>

          <div class="accordion-group">
            <div class="accordion-heading">
              <a class="accordion-toggle b_F6F1A2" href="<%=basePath %>record/index.do"><i class="icon-tasks"></i> <span>案子列表</span></a>
            </div>
          </div>
        
          <div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="<%=basePath %>policestation/index.do"><i class="icon-tasks"></i> <span>派出所列表</span></a>
            </div> 
          </div>    
          <div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="<%=basePath %>user/password.do"><i class="icon-user"></i> <span>修改密码</span></a>
            </div> 
          </div>        
          <div class="accordion-group">
         <!--    <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="users.html"><i class="icon-user"></i> <span>修改密码</span></a>
            </div> -->
          </div>      
        </div>
      </div>
      <!-- /Side menu -->

      <!-- Main window -->
      <div class="main_container" id="dashboard_page">
 

        <!-- CHARTS  -->
        <div class="row-fluid">
        
 	<div class="tab-pane" style="padding: 20px 20px 10px;">
 			
	    <div style="float: left; font-size: 17px;">
	    	<div class="form-inline">  
				<button onclick="add()" class="btn btn-primary">增加</button>
	    	 </div>
		</div>  
	   
	    <div style="float: right;">
	     <div class="form-inline">  
	   		<input type="text" placeholder="请输入派出所" id="selectName" class="layui-input" style="margin-right:10px"/><button onclick="selCount()" class="btn btn-primary">查询</button>
	     </div>
   		</div>
   	</div>
    <div class="tab-pane" id="pushed-content"  style="padding:25px 15px;">
      <style>
		  .table tr th { text-align:center; background-color:#eee; }
		  .table tr td { text-align:center; }
		</style>
		<table id="userContent"></table>

        </div> <!-- /row-fluid -->
 </div> 

 </div> 

<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">增加派出所</h4>
      </div>
      <div class="modal-body">
			   <input  class="form-control" id="recordId1" name="recordId" type="hidden">
			  <label for="address" class="col-sm-4 control-label">输入派出所名字<span style="color: red;">*</span></label>
					<div class="col-sm-8">
						<input  class="form-control" id="policestationName" name="policestationName"/>
					</div>
			  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="btn2()">保存</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" >修改派出所</h4>
      </div>
      <div class="modal-body">
			   <input  class="form-control" id="poooid" name="poooid" type="hidden" >
			  <label for="address" class="col-sm-4 control-label">输入派出所名字<span style="color: red;">*</span></label>
					<div class="col-sm-8">
						<input  class="form-control" id="pName" name="pName"/>
					</div>
			  
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="update()">保存</button>
      </div>
    </div>
  </div>
</div>


<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">删除操作</h4>
      </div>
      <div class="modal-body">
			   <input  class="form-control" id="ploId" name="ploId" type="hidden">
			   确认删除？
      </div>
      <div class="modal-footer">
     	 <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="btn3()">是</button>
      </div>
    </div>
  </div>
</div>
  </body>
</html>
