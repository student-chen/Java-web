<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>           
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8" />
    <title>报警系统</title>
		<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!-- Latest compiled and minified CSS -->
	 <style type="text/css">
     body{
         width:1000px;
         height :800px;
      }

     table{
         border-collapse :collapse ;
     }
     th,td{
         width:500px;
         height:40px;
         border :1px solid black;
         font-size:12px;
         text-align :center;
     }
table{
         border-collapse :collapse ;
     }
    </style>
	</head>
	<body>

<body>
<div style="margin-left: 50% ;margin-top: 10%">
  <table>
<p style="text-align:center ;font-size: 36px ">报案列表</p>
 	<tr>
      <th>id</th>
      <td>处理人</td>
      <td>状态</td>
      <td>分配部门</td>
      <td>时间</td>
      <td>操作</td>
    </tr>
    
    <c:forEach var="item"   items="${recordList}">

           <tr>
		      <th>${item.id}</th>
		      <td>暂无</td>
		      <td>未审理</td>
		      <td>未分配</td>
		      <td> <fmt:formatDate value="${item.time}" pattern="yyyy:MM:dd  HH:mm:ss" />  </td>
		      <td><button type="button" class="btn btn-primary" data-toggle="modal" onclick="show_modal(${item.id});" >修改</button></td>
		      
    	  </tr>                  

          </c:forEach>
   
      
  </table>
     <br></br>
 
   <table>

<p style="text-align:center;font-size: 36px ">处理列表</p>
 	<tr>
      <th>id</th>
      <td>处理人</td>
      <td>状态</td>
      <td>分配部门</td>
      <td>时间</td>
      <td>操作</td>
    </tr>
    
    <c:forEach var="item"   items="${processList}">

           <tr>
		      <th>${item.id}</th>
		      <td>${item.handle}</td>
		      <td>${item.state}</td>
		      <td>${item.department}</td>
		      <td> <fmt:formatDate value="${item.date}" pattern="yyyy:MM:dd  HH:mm:ss" />  </td>
		      <td><button type="button" class="btn btn-primary" data-toggle="modal" onclick="show_modal1(${item.id});" > <span class="glyphicon  glyphicon-pencil" aria-hidden="true"></span></button>
		      <button type="button" class="btn btn-primary" data-toggle="modal" onclick="show_modal2(${item.id});" >
		      <span class="glyphicon  glyphicon-trash" aria-hidden="true"></span></button></td>
    	  </tr>                  

          </c:forEach>
   
      
  </table>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">操作</h4>
      </div>
      <div class="modal-body">
			 <form>
			  <div class="form-group">
			     <input  class="form-control" id="recordId" name="recordId" type="hidden">
			    <input  class="form-control" id="department" placeholder="分配部门">
			  </div>
			  <div class="form-group">
			    <input class="form-control" id="state" placeholder="状态">
			  </div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="btn">保存</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">操作</h4>
      </div>
      <div class="modal-body">
			 <form>
			  <div class="form-group">
			     <input  class="form-control" id="id" name="id" type="hidden">
			    <input  class="form-control" id="department1" placeholder="分配部门">
			  </div>
			  <div class="form-group">
			    <input class="form-control" id="state1" placeholder="状态">
			  </div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="btn1">保存</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">删除</h4>
      </div>
      <div class="modal-body">
       <input  class="form-control" id="id1" name="id" type="hidden">
			 确定删除？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="btn2">删除</button>
      </div>
    </div>
  </div>
</div>
<%-- <script >
var root="<%=basePath %>";
$(document).ready(function(){  
	modalInit("myModal", null,null);
	modalInit("myModal1", null,null);
	modalInit("myModal2", null,null);
});  

function show_modal(id) {
	  $('#recordId').val(id);
    $('#myModal').modal('show');
}
function show_modal1(id) {
	  $('#id').val(id);
  $('#myModal1').modal('show');
}
function show_modal2(id) {
	  $('#id1').val(id);
  $('#myModal2').modal('show');
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

$("#btn").click(function(){
  	$.ajax({
				url :  root+"process/add.do",
				type : "post",
				cache : false,
				data: {
					recordId : $('#recordId').val() ,
					department : $('#department').val(),
					state :  $('#state').val()
				},
				dataType : "json",
				error : function() {
					
					alert("暂时无法操作，请刷新后再试！");
				},
				success : function(result) {
					location.reload();
					  $('#myModal').modal('hide');
					alert("修改成功");
					
				}
	});
});
$("#btn1").click(function(){
  	$.ajax({
				url :  root+"process/update.do",
				type : "post",
				cache : false,
				data: {
					id : $('#id').val() ,
					department : $('#department1').val(),
					state :  $('#state1').val()
				},
				dataType : "json",
				error : function() {
					
					alert("暂时无法操作，请刷新后再试！");
				},
				success : function(result) {
					location.reload();
					  $('#myModal1').modal('hide');
					alert("修改成功");
					
				}
	});
});
    $("#btn2").click(function(){
  	$.ajax({
				url :  root+"process/del.do",
				type : "post",
				cache : false,
				data: {
					id : $('#id1').val()
				},
				dataType : "json",
				error : function() {
					
					alert("暂时无法操作，请刷新后再试！");
				},
				success : function(result) {
					location.reload();
					  $('#myModal2').modal('hide');
					alert("删除成功");
					
				}
	});
});
</script> --%>
	</body>
</html>
