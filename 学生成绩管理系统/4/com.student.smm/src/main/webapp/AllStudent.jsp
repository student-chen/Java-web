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
        <h4 class="modal-title" id="myModalLabel">学生信息修改</h4>
      </div>
      <form class="form-horizontal" action="Studentupdate" name="id" method="post">
      <div class="modal-body">
        
		  <div class="form-group">
		    <label class="col-sm-2 control-label">学生编号:</label>
		    <div class="col-sm-10">
		      <input type="hidden" id="id" name="id"/>
		      <input type="text" name="sid" id="sids"class="form-control">
		      <span class="help-block" id="ids"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">学生姓名:</label>
		    <div class="col-sm-10">
		      <input type="text" name="name" id="names" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>	   
		  <div class="form-group">
		    <label class="col-sm-2 control-label">学生性别:</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="sex" id="sexs" value="男" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="sex" id="sexs" value="女"> 女
				</label>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">年龄:</label>
		     <div class="col-sm-10">
		      <input type="text" name="age" id="ages" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 control-label">学生电话:</label>
		     <div class="col-sm-10">
		      <input type="text" name="tel" id="tels" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 control-label">学生成绩:</label>
		     <div class="col-sm-10">
		      <input type="text" name="grade" id="grades" class="form-control">
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
        <h4 class="modal-title" id="myModalLabel">学生信息添加</h4>
      </div>
      <form class="form-horizontal" action="saveStudent" method="post">    
		  <div class="form-group">
		    <label class="col-sm-2 control-label">学生编号:</label>
		    <div class="col-sm-10">
		      <input type="text" name="sid" id="one" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">学生姓名:</label>
		    <div class="col-sm-10">
		      <input type="text" name="name" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>	   
		  <div class="form-group">
		    <label class="col-sm-2 control-label">学生性别:</label>
		    <div class="col-sm-10">
		      <label class="radio-inline">
				  <input type="radio" name="sex"value="男" checked="checked"> 男
				</label>
				<label class="radio-inline">
				  <input type="radio" name="sex" value="女"> 女
				</label>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">年龄:</label>
		     <div class="col-sm-10">
		      <input type="text" name="age" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 control-label">学生电话:</label>
		     <div class="col-sm-10">
		      <input type="text" name="tel" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 control-label">学生成绩:</label>
		     <div class="col-sm-10">
		      <input type="text" name="grade" class="form-control">
		      <span class="help-block"></span>
		    </div>
		  </div>
		   <div class="form-group">
		    <label class="col-sm-2 control-label">班主任:</label>
		     <div class="col-sm-10">
		     <select name="classid">
						<option selected="Risk" value="0">---请选择---</option>
						<option value="1">李强</option>
						<option value="2">胡艳东</option>
						<option value="3">王旭峰</option>
				</select>
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
</div> -->
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
                        <tr>
                            <td><strong>学生年龄:</strong></td>
                            <td>
                                &nbsp;&nbsp;&nbsp;<Strong><span id="sex"></span></Strong>
                            </td>                     
                        </tr>
                         <tr>
                          <td><strong>学生电话:</strong></td>
                            <td>
                               &nbsp;&nbsp;&nbsp;<Strong><span id="classnumber"></span></Strong>
                            </td>
                   </tr>
                       <tr>
                            <td><strong>学生成绩:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="type"></span></Strong>
                            </td>                       
                       </tr> 
                       <tr>
                            <td><strong>学生学籍:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="Xueji"></span></Strong>
                            </td>                       
                       </tr> 
                        <tr>
                            <td><strong>班主任:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="teachers"></span></Strong>
                            </td>                       
                       </tr>  
                         <tr>
                            <td><strong>数学:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="yuwen"></span></Strong>
                            </td>                       
                       </tr> 
                        <tr>
                            <td><strong>数学:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="math"></span></Strong>
                            </td>                       
                       </tr> 
                       <tr>
                            <td><strong>英文:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="english"></span></Strong>
                            </td>                       
                       </tr>     
                       <tr>
                            <td><strong>历史:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="histroy"></span></Strong>
                            </td>                       
                       </tr>     
                       <tr>
                            <td><strong>化学:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="huaxue"></span></Strong>
                            </td>                       
                       </tr>     
                       <tr>
                            <td><strong>物理:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="wuli"></span></Strong>
                            </td>                       
                       </tr>     
                       <tr>
                            <td><strong>体育:</strong></td>
                            <td>
                              &nbsp;&nbsp;&nbsp;<Strong><span id="tiyu"></span></Strong>
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
          	<span style="color: white;font-size: 24px;">学生信息管理系统</span>
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
              <form name="form1" method="post" action="AllStduentclass" id="searchForm">
               <input type="hidden" id="pageNo" name="pageNo" value="${pagerBooks.pageNo}"/>
               <input type="hidden" id="pageSize" name="pageSize" value="${pagerBooks.pageSize}"/> 
                  <div class="main_container" id="dashboard_page">      
 	<div class="tab-pane" style="padding: 20px 20px 10px;">			
	    <div style="float: left; font-size: 17px;">  
	    <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <button data-toggle="modal" data-target="#empAddModal">添加学员</button></td>
	    <button type="button" onclick="delet()" class="btn btn-primary">批量删除</button>
	    <a href="xiazai"><button type="button"><span class="am-icon-sign-out"></span>excel导出</button></a>
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
                      <select name="textone" id="text1">
                        <option value="">全部查询</option>
                        <option value="姓名">学生姓名</option>
                        <option value="电话">学生电话</option>
                        <option value="编号">用户编号</option>
                      </select>
                      <input name="texttwo" type="text" id="text2">
                      <input type="submit" name="button" id="button" class="btn btn-primary" value="点击查询"></td>
	     </div>
   		</div>
   	</div>                      
              </form>               
                <table width="100%" border="1" cellspacing="20" cellpadding="3" style="text-align:center">
                  <tr align="center"  class="t1" >
                    <td><input type="checkbox" name="checkAll" id="checkAll" onClick="checkAll()"></td>
                    <td height="25" bgcolor="#D5E4F4"><strong>编号</strong></td>
                    <td height="25" bgcolor="#D5E4F4"><strong>姓名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>性别</strong></td>
                    <td bgcolor="#D5E4F4"><strong>年龄</strong></td>
                    <td bgcolor="#D5E4F4"><strong>电话</strong></td>
                    <td bgcolor="#D5E4F4"><strong>总成绩</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <c:forEach var="list" items="${pagerBooks.entitiesList}" varStatus="status">
                  <tr align="center"<c:if test="${status.index % 2==1}">
                      style="background-color:#D5E4F4;"
                      </c:if>> 
                      <td><input type="checkbox" name="id" value="${list.id}"></td>   
                      <td height="25" align="center">${list.sid}</td>
                      <td height="25" align="center">${list.name}</td>
                      <td>${list.sex}</td>
                      <td>${list.age}</td>
                      <td align="center">${list.tel}</td>
                      <td align="center">${list.grade}</td>
                      <td align="center">
					<button style="height:35px;width:70px;background:#7bbfea;font-size: 20px;" class="layui-btn layui-btn-normal layui-btn-mini" type="button" data-toggle="modal" data-target="#loginForms" onclick="mabi('${list.sid}','${list.name}','${list.sex}','${list.age}','${list.tel}','${list.grade}','${list.xueji}','${list.tname}','${list.yuwen}','${list.math}','${list.english}',${list.histroy},'${list.huaxue}','${list.huaxue}','${list.wuli}','${list.tiyu}')">详情</button>							 		
					<button style="height:35px;width:70px;background:#50b7c1;font-size: 20px;" class="layui-btn layui-btn-mini" type="button" data-toggle="modal" data-target="#Studentupdate" onclick="mabis('${list.id}','${list.sid}','${list.name}','${list.sex}','${list.age}','${list.tel}','${list.grade}')">编辑</button>
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
                
               <%--   <c:set var="pager" value="${pagerBooks}" scope="page"/>
              <%@ include file="/Person/Person.jsp" %> --%>
          </div>
      <script type="text/javascript">
          
	$(function(){
		$('#text2').val("${huixianNames}");
		$('#text1').val("${huixianName}");
		});	
		//删除
 	function batchDeletes(id){
/*  	  alert("第一次："+id);    */
 		var fid=id;
 		$("#id").val(fid);
 	}
 	function batchDelete(){
 		 var id=$.trim($("#id").val()); 
 		window.location="deleteStudent?id="+id;
 	}
 		//查看
	function mabi(sid,name,sex,age,tel,grade,xueji,tname,yuwen,math,english,histroy,huaxue,wuli,tiyu){	
 		$('#userid').text(sid);
 		$('#accountsssss').text(name);
 		$('#name').text(sex);
 		$('#sex').text(age);
 		$('#classnumber').text(tel);
 		$('#type').text(grade);
 		$('#Xueji').text(xueji);
 		$('#teachers').text(tname);
 		$('#yuwen').text(yuwen);
 		$('#math').text(math);
 		$('#english').text(english);
 		$('#histroy').text(histroy);
 		$('#huaxue').text(huaxue);
 		$('#wuli').text(wuli);
 		$('#tiyu').text(tiyu);
 	};
 	//修改传值
	function mabis(id,sid,name,sex,age,tel,grade){
	    $('#id').val(id);
 		$('#sids').val(sid);
 		$('#names').val(name);
 		$('#sexs').val(sex);
 		$('#ages').val(age);
 		$('#tels').val(tel);
 		$('#grades').val(grade);
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
    }
    var msg = "您真的确定要删除吗？";
if (confirm(msg)==true){
 window.location.href="delet?id="+id;
}else{
return false;
}   
  }
  
   
</script>
</html>
