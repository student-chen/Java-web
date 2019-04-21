<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet"
	href="<%=basePath %>bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
<link href="<%=basePath %>assets/css/theme.css" rel="stylesheet">
<link href="<%=basePath %>assets/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<%=basePath %>assets/css/alertify.css" rel="stylesheet">
<link rel="Favicon Icon" href="<%=basePath %>assets/favicon.ico">
<script type="text/javascript"
	src="<%=basePath %>assets/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath %>assets/js/bootstrap.js"></script>
<script
	src="<%=basePath %>bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script
	src="<%=basePath %>bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script>			
    </script>
<style type="text/css">
.one {
	text-align: center;
	font-size: 30px;
}
</style>
</head>
<!-- 教师修改的模态框 -->
<div class="modal fade" id="Studentupdate" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">教师信息修改</h4>
			</div>
			<form class="form-horizontal" action="Teacherupdate" name="id"
				method="post">
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-2 control-label">教师姓名:</label>
						<div class="col-sm-10">
							<input type="hidden" id="tid" name="tid" /> <input type="text"
								name="tid" id="sids" class="form-control"> <span
								class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">省份证号:</label>
						<div class="col-sm-10">
							<input type="text" name="tname" id="names" class="form-control">
							<span class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">教师性别:</label>
						<div class="col-sm-10">
							<label class="radio-inline"> <input type="radio"
								name="tcard" id="sexs" value="男" checked="checked"> 男 </label> <label
								class="radio-inline"> <input type="radio" name="tcard"
								id="sexs" value="女"> 女 </label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">家庭住址</label>
						<div class="col-sm-10">
							<input type="text" name="age" id="ages" class="form-control">
							<span class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">专业:</label>
						<div class="col-sm-10">
							<input type="text" name="tlesson" id="tels" class="form-control">
							<span class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">技术:</label>
						<div class="col-sm-10">
							<input type="text" name="ttext" id="grades" class="form-control">
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
<!-- 教师添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">教师信息添加</h4>
			</div>
			<form class="form-horizontal" action="saveTeacher" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label">教师姓名:</label>
					<div class="col-sm-10">
						<input type="text" name="tname" class="form-control"> <span
							class="help-block"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">性别:</label>
					<div class="col-sm-10">
						<label class="radio-inline"> <input type="radio"
							name="tsex" value="男" checked="checked"> 男 </label> <label
							class="radio-inline"> <input type="radio" name="tsex"
							value="女"> 女 </label>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">省份证:</label>
					<div class="col-sm-10">
						<input type="text" name="tcard" class="form-control"> <span
							class="help-block"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">地址:</label>
					<div class="col-sm-10">
						<input type="text" name="tadd" class="form-control"> <span
							class="help-block"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">专业:</label>
					<div class="col-sm-10">
						<input type="text" name="tlesson" class="form-control"> <span
							class="help-block"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">技术:</label>
					<div class="col-sm-10">
						<select name="ttext">
							<option selected="Risk" value="0">---请选择---</option>
							<option value="java">java</option>
							<option value="html5">html5</option>
							<option value="UI">UI</option>
						</select> <span class="help-block"></span>
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
<div class="modal  fade bs-example-modal-sm" id="delForm" tabindex="-1"
	role="dialog">
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
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="hidden" name="tid" id="tids" /><br />						
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
								<td><strong>编号:</strong>
								</td>
								<td>&nbsp;&nbsp;&nbsp;<Strong><span id="userid"></span>
								</Strong></td>
							</tr>
							<tr>
								<td><strong>姓名:</strong>
								</td>
								<td>&nbsp;&nbsp;&nbsp;<Strong><span id="accountsssss"></span>
								</Strong></td>
							</tr>
							<tr>
								<td><strong>省份证:</strong>
								</td>
								<td>&nbsp;&nbsp;&nbsp;<Strong><span id="name"></span>
								</Strong></td>
							</tr>
							<tr>
								<td><strong>性别:</strong>
								</td>
								<td>&nbsp;&nbsp;&nbsp;<Strong><span id="sex"></span>
								</Strong></td>
							</tr>
							<tr>
								<td><strong>地址:</strong>
								</td>
								<td>&nbsp;&nbsp;&nbsp;<Strong><span id="tadd"></span>
								</Strong></td>
							</tr>
							<tr>
								<td><strong>专业:</strong>
								</td>
								<td>&nbsp;&nbsp;&nbsp;<Strong><span id="classnumber"></span>
								</Strong></td>
							</tr>
							<tr>
								<td><strong>技术:</strong>
								</td>
								<td>&nbsp;&nbsp;&nbsp;<Strong><span id="types"></span>
								</Strong></td>
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
					<a class="btn btn-navbar visible-phone" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> </a> <a
						class="btn btn-navbar slide_menu_left visible-tablet"> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> </a>

					<div class="top-menu visible-desktop">
						<ul class="pull-right">
							<li><a href="<%=basePath %>login.jsp"><i
									class="icon-off"></i> 退出</a>
							</li>
						</ul>
					</div>


				</div>
			</div>
		</div>
		<!-- Side menu -->
		<div class="sidebar-nav nav-collapse collapse">
			<div class="user_side clearfix">
				<img
					src="<%=basePath %>assets/img/u=2193226168,4120396026&fm=27&gp=0.jpg"
					alt="无法显示">
				<h5>欢迎您，进入学校信息管理系统!</h5>
			</div>
			<div class="accordion" id="accordion2">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle active b_F79999" href="LogOAselect"><i
							class="icon-dashboard"></i> <span>控制台</span>
						</a>
					</div>
				</div>

				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle b_F6F1A2" href="StudentOAselect"><i
							class="icon-tasks"></i> <span>学生信息列表</span>
						</a>
					</div>
				</div>
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle b_F5C294" href="ClassOAselect"><i
							class="icon-tasks"></i> <span>班级信息列表</span>
						</a>
					</div>
				</div>
				<div class="accordion-group">
             <div class="accordion-heading">
              <a class="accordion-toggle b_F5C294" href="TeacherSelect"><i class="icon-tasks"></i> <span>老师信息列表</span></a>
            </div> 
          </div>  
				<div class="accordion-group">
					<div class="accordion-heading">
						<a class="accordion-toggle b_F5C294"
							href="password.jsp"><i class="icon-user"></i>
							<span>修改密码</span>
						</a>
					</div>
				</div>
				<div class="accordion-group"></div>
			</div>
		</div>
		<!-- /Side menu -->

		<!-- Main window -->
		<form name="form1" method="post" action="TeacherSelect" id="searchForm">		
			<input type="hidden" id="pageNo" name="pageNo"
				value="${pagerBooks.pageNo}" /> <input type="hidden" id="pageSize"
				name="pageSize" value="${pagerBooks.pageSize}" />
			<div class="main_container" id="dashboard_page">
				<div class="tab-pane" style="padding: 20px 20px 10px;">
					<div style="float: left; font-size: 17px;">
						<td width="28%" height="30" style="padding-left:20px;">功能导航：
							<button data-toggle="modal" data-target="#empAddModal">添加教师</button>
						</td>
						<button type="button" onclick="delet()" class="btn btn-primary">批量删除</button>
						 <a href="xiazaiss"><button type="button"><span class="am-icon-sign-out"></span>excel导出</button></a>
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
							<td width="10%">查询： <select name="text5" id="text5">
									<option value="">全部查询</option>
									<option value="教师姓名">教师姓名</option>
									<option value="省份证">省份证</option>
							</select> <input name="text6" type="text" id="text6"> <input
								type="submit" name="button" id="button" class="btn btn-primary"
								value="点击查询">
							</td>
						</div>
					</div>
				</div>
		</form>
		<table width="100%" border="1" cellspacing="20" cellpadding="3"
			style="text-align:center">
			<tr align="center" class="t1">
				<td><input type="checkbox" name="checkAll" id="checkAll"
					onClick="checkAll()">
				<td height="25" bgcolor="#D5E4F4"><strong>姓名</strong>
				</td>
				<td bgcolor="#D5E4F4"><strong>性别</strong>
				</td>
				<td bgcolor="#D5E4F4"><strong>省份证</strong>
				</td>
				<td bgcolor="#D5E4F4"><strong>地址</strong>
				</td>
				<td bgcolor="#D5E4F4"><strong>专业</strong>
				</td>
				<td bgcolor="#D5E4F4"><strong>技术</strong>
				</td>
				<td bgcolor="#D5E4F4"><strong>操作</strong>
				</td>
			</tr>
			<c:forEach var="list" items="${pagerBooks.entitiesList}"
				varStatus="status">
				<tr align="center"
					<c:if test="${status.index % 2==1}">
                      style="background-color:#D5E4F4;"
                      </c:if>>
					<td><input type="checkbox" name="id" value="${list.tid}">
					</td>
					<td height="25" align="center">${list.tname}</td>
					<td>${list.tsex}</td>
					<td height="25" align="center">${list.tcard}</td>				
					<td>${list.tadd}</td>
					<td align="center">${list.tlesson}</td>
					<td align="center">${list.ttext}</td>
					<td align="center">
						<button
							style="height:35px;width:70px;background:#7bbfea;font-size: 20px;"
							class="layui-btn layui-btn-normal layui-btn-mini" type="button"
							data-toggle="modal" data-target="#loginForms"
							onclick="mabi('${list.tid}','${list.tname}','${list.tcard}','${list.tsex}','${list.tadd}','${list.tlesson}','${list.ttext}')">详情</button>
						<button
							style="height:35px;width:70px;background:#50b7c1;font-size: 20px;"
							class="layui-btn layui-btn-mini" type="button"
							data-toggle="modal" data-target="#Studentupdate"
							onclick="mabis('${list.tid}','${list.tname}','${list.tcard}','${list.tsex}','${list.tadd}','${list.tlesson}','${list.ttext}')">编辑</button>
						<button
							style="height:35px;width:70px;background:#ed1941;font-size: 20px;"
							class="layui-btn layui-btn-danger layui-btn-mini" type="button"
							data-toggle="modal" data-target="#delForm"
							onclick="batchDeletes('${list.tid}')">删除</button></td>
				</tr>
				
			</c:forEach>
			<tr>
				<td colspan="8" align="center">
					<div style="color: red; text-align: center;">
						<Strong>${deletes}${mywo}${msg}</Strong>
					</div></td>
			</tr>
		</table>

		<c:set var="pager" value="${pagerBooks}" scope="page" />
		<%@ include file="/Person/Person.jsp"%>
	</div>
	<script type="text/javascript">
          
	$(function(){
		$('#text5').val("${huixianName}");
		$('#text6').val("${huixianNames}");
		});	
		//删除
 	function batchDeletes(tid){
 	    //alert(tid);   
 		var fid=tid;
 		$("#tids").val(fid);
 	}
 	function batchDelete(){
 		 var tid=$.trim($("#tids").val()); 
 		window.location="deleteTeacher?tid="+tid;
 	}
 		//查看
	function mabi(tid,tname,tcard,tsex,tadd,tlesson,ttext){	
 		$('#userid').text(tid);
 		$('#accountsssss').text(tname);
 		$('#name').text(tcard);
 		$('#sex').text(tsex);
 		$('#tadd').text(tadd);
 		$('#classnumber').text(tlesson);
 		$('#types').text(ttext);
 	};
 	//修改传值
	function mabis(tid,tname,tcard,tsex,tadd,tlesson,ttext){
	    $('#id').val(tid);
 		$('#sids').val(tname);
 		$('#names').val(tcard);
 		$('#sexs').val(tsex);
 		$('#ages').val(tadd);
 		$('#tels').val(tlesson);
 		$('#grades').val(ttext);
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
 window.location.href="deletTeachers?tid="+id;
}else{
return false;
}   
    }
</script>
</html>
