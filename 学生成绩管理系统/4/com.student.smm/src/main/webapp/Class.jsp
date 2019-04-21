<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    </script>
     <style type="text/css">
    .one{
        text-align:center;
        font-size:30px;
    }
    </style>
  </head>
  <!-- 员工修改的模态框 -->
 <div class="modal fade" id="Studentupdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">班级信息修改</h4>
      </div>
      <form class="form-horizontal" action="Classupdate" name="id" method="post">
      <div class="modal-body">
        
		  <div class="form-group">
		    <label class="col-sm-2 control-label">班级编号:</label>
		    <div class="col-sm-10">
		      <input type="hidden" id="id" name="id"/>
		      <input type="text" name="classid" id="ids"class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">班级名称:</label>
		    <div class="col-sm-10">
		      <input type="text" name="classname" id="sids" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>	   
		   <div class="form-group">
		    <label class="col-sm-2 control-label">班级说明:</label>
		    <div class="col-sm-10">
		      <input type="text" name="classexplain" id="names" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>	   
      </div>
      <div class="modal-footer">       
        <button type="submit" class="btn btn-primary">保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>    
      </form>
    </div>
  </div>
</div>
<!-- 员工添加的模态框 -->
 <div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">班级信息添加</h4>
      </div>
      <form class="form-horizontal" action="saveClass" method="post">   
		  <div class="form-group">
		    <label class="col-sm-2 control-label">班级编号:</label>
		    <div class="col-sm-10">
		      <input type="text" name="classid"  class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">班级名称:</label>
		    <div class="col-sm-10">
		      <input type="text" name="classname" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 control-label">班级说明:</label>
		    <div class="col-sm-10">
		      <input type="text" name="classexplain" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>		   		 
      <div class="modal-footer">       
        <button type="submit" class="btn btn-primary">保存</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
      
      </form>
    </div>
  </div>
</div>
    <!-- 删除框模板 -->
     <div class="modal  fade bs-example-modal-sm" id="delForm" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal" aria-label="Close">
                        <span>&times;</span>
                    </button>
                    <h3 align="center">删除</h3>
                </div>
                <div class="modal-body">
					<div class="row">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="hidden" name="id" id="id"/><br/>
					<input type="hidden" name="studentid" id="studentid" value="${user.stuinfo.studentid}"/>
						<div class="one">确定删除此信息吗?</div>
					</div>
				</div>
                <div class="modal-footer">
                    <button class="btn btn-primary" onclick="batchDelete()">确认</button>
                    <button class="btn btn-danger" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div> 
    <!--查看框模板-->
  <div class="container" align="center">
    <div class="modal fade" id="loginForms" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                    <h3>浏览信息</h3>
                </div>
                <div class="modal-body">
                    <form action="" class="form-horizontal">
                        <table>
                        <tr>
                            <td><strong>学生编号:</strong></td>                    
                                <td>&nbsp;&nbsp;&nbsp;<Strong><span id="userid"></span></Strong>
                            </td>
                            </tr>
                        <tr>
                            <td><strong>学生姓名:</strong></td>
                            <td>
                                &nbsp;&nbsp;&nbsp;<Strong><span id="accountsssss"></span></Strong>
                            </td>                         
                        </tr>
                        <tr>
                            <td><strong>学生性别:</strong></td>
                            <td>
                               &nbsp;&nbsp;&nbsp;<Strong><span id="name"></span></Strong>                     
                            </td>                       
                       </tr>              
                        </table>
                    </form>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary">确认</button>
                    <button class="btn btn-danger" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    </div>
  <body>
    <div id="wrap">
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <div class="logo"> 
          	<span style="color: white;font-size: 24px;">班级信息管理系统</span>
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
          <img src="<%=basePath %>assets/img/u=2193226168,4120396026&fm=27&gp=0.jpg" alt="无法显示">
          <h5>欢迎您，进入学校信息管理系统!</h5>
              
        </div>
        <div class="accordion" id="accordion2">
          <div class="accordion-group">
            <div class="accordion-heading">
              <a class="accordion-toggle active b_F79999" href="LogOAselect" ><i class="icon-dashboard"></i> <span>控制台</span></a>
            </div>
          </div>

          <div class="accordion-group">
            <div class="accordion-heading">
              <a class="accordion-toggle b_F6F1A2" href="StudentOAselect"><i class="icon-tasks"></i> <span>学生信息列表</span></a>
            </div>
          </div>
        
          <div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="ClassOAselect"><i class="icon-tasks"></i> <span>班级信息列表</span></a>
            </div> 
          </div>    
           <div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="TeacherSelect"><i class="icon-tasks"></i> <span>老师信息列表</span></a>
            </div> 
          </div>    
          <div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="password.jsp"><i class="icon-user"></i> <span>修改密码</span></a>
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
              <form name="form1" method="post" action="ClassOAselect" id="searchForm">
               <input type="hidden" id="pageNo" name="pageNo" value="${pagerBooks.pageNo}"/>
               <input type="hidden" id="pageSize" name="pageSize" value="${pagerBooks.pageSize}"/> 
                  <div class="main_container" id="dashboard_page">      
 	<div class="tab-pane" style="padding: 20px 20px 10px;">			
	    <div style="float: left; font-size: 17px;">  
	    <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <button data-toggle="modal" data-target="#empAddModal">添加班级</button></td>
	    <button type="button" onclick="delet()" class="btn btn-primary">批量删除</button>
	    <a href="xiazais"><button type="button"><span class="am-icon-sign-out"></span>excel导出</button></a>
					<!-- 上传excel文件 -->
					<form name="fileupload" enctype="multipart/form-data"
						action="kechengbiao" method="post">
						<p style="font-size: 16px;">请选择正确的excel文件上传</p>
						<input id="txt" class="input" type="text" disabled="disabled"
							value="文件域" name="txt"> <input class="liulan"
							type="button" onclick="file.click()" size="30" value="上传文件"
							onmousemove="file.style.pixelLeft=event.x-60;file.style.pixelTop=this.offsetTop;">
						<input id="file1" class="files" type="file" size="1"
							style="height: 26px;" name="file" onchange="txt.value=this.value">
						<br /> <input type="button" onclick="checkSuffix();" value="提交上传"
							style="height: 26px; width: 100px">
						<p style="color: red;">支持的excel格式为：xls、xlsx、xlsb、xlsm、xlst！</p>

					</form>
		</div>  
	    <div style="float: right;">
	     <div class="form-inline">  
	   		 <td width="10%">查询：
                      <select name="text3" id="text3">
                        <option value="">全部</option>
                        <option value="班级编号">班级编号</option>
                        <option value="班级名称">班级名称</option>
                      </select>
                      <input name="text4" type="text" id="text4">
                      <input type="submit" name="button" id="button" class="btn btn-primary" value="点击查询"></td>
	     </div>
   		</div>
   	</div>                      
              </form>               
                <table width="100%" border="1" cellspacing="20" cellpadding="3" style="text-align:center">
                  <tr align="center"  class="t1" >
                    <td><input type="checkbox" name="checkAll" id="checkAll" onClick="checkAll()"></td>
                    <td height="25" bgcolor="#D5E4F4"><strong>班级编号</strong></td>
                    <td height="25" bgcolor="#D5E4F4"><strong>班级名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>班级说明</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <c:forEach var="list" items="${pagerBooks.entitiesList}" varStatus="status">
                  <tr align="center"<c:if test="${status.index % 2==1}">
                      style="background-color:#D5E4F4;"
                      </c:if>> 
                      <td><input type="checkbox" name="id" value="${list.id}"></td>   
                      <td height="25" align="center">${list.classid}</td>
                      <td height="25" align="center"><a href="AllStduentclass?id=${list.id}">${list.classname}</a></td>
                      <td>${list.classexplain}</td>
                      <td align="center">
					<button style="height:35px;width:70px;background:#7bbfea;font-size: 20px;" class="layui-btn layui-btn-normal layui-btn-mini" type="button" data-toggle="modal" data-target="#loginForms" onclick="mabi('${list.classid}','${list.classname}','${list.classexplain}')">详情</button>							 		
					<button style="height:35px;width:70px;background:#50b7c1;font-size: 20px;" class="layui-btn layui-btn-mini" type="button" data-toggle="modal" data-target="#Studentupdate" onclick="mabis('${list.id}','${list.classid}','${list.classname}','${list.classexplain}')">编辑</button>
					<button style="height:35px;width:70px;background:#ed1941;font-size: 20px;" class="layui-btn layui-btn-danger layui-btn-mini" type="button" data-toggle="modal" data-target="#delForm" onclick="batchDeletes('${list.id}')">删除</button>
					</td> 
                    </tr>        
                 </c:forEach>  
                 <tr> 
                 <td colspan="8" align="center">
               <div style="color: red; text-align: center;"><Strong>${deletes}${mywo}${msg}</Strong></div>
               </td> 
           </tr>         
                </table>          
                 <c:set var="pager" value="${pagerBooks}" scope="page"/>
              <%@ include file="/Person/Person.jsp" %>
          </div>
          <script type="text/javascript">        
	$(function(){
		$('#text3').val("${huixianName}");
		$('#text4').val("${huixianNames}");
		});	
		//删除
 	function batchDeletes(id){
/*  	  alert("第一次："+id);    */
 		var fid=id;
 		$("#id").val(fid);
 	}
 	function batchDelete(){
 		 var id=$.trim($("#id").val()); 
 		window.location="deleteClass?id="+id;
 	}
 		//查看
	function mabi(classid,classname,classexplain){	
 		$('#userid').text(classid);
 		$('#accountsssss').text(classname);
 		$('#name').text(classexplain);
 	};
 	//修改传值
	function mabis(id,classid,classname,classexplain){	
	    $('#id').val(id);     
	    $('#ids').val(classid);
 		$('#sids').val(classname);
 		$('#names').val(classexplain);
 		};
 $(function() {
$("#checkAll").click(function() {
$('input[name="id"]').not("[disabled]").attr("checked",this.checked);
});
var $id = $("input[name='id']");
$id.click(function(){
$("#checkAll").attr("checked",$id.length == $("input[name='id']:checked").length ? true : false);
});
});
function delet(){
    	var array=$("[name='id']");
    	var id=new Array();
    	for(var i=0;i<array.length;i++){
    		if(array[i].checked){
    		id +=$(array[i]).val()+",";
    	}
    };
    var msg = "您真的确定要删除吗？";
if (confirm(msg)==true){
 window.location.href="deletss?id="+id;
}else{
return false;
}   
    };
</script>
</html>
