<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stuScore.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
.div_list {
	width: 700px;
	height: 500px;
	margin: auto;
	margin-top: 50px;
}

font {
	color: red;
	font-weight: bold;
	text-align: center;
}

table {
	margin: 0 auto;
}

table tr td {
	text-align: center;
	width: 150px;
	height: 40px;
}

a {
	text-decoration: none;
	cursor: pointer;
}
</style>
<script type="text/javascript">

function ajaxSum(num){
	/* var xmlHttpRequest=null;
	if(XMLHttpRequest){
		xmlHttpRequest=new XMLHttpRequset();
	}else{
		xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(xmlHttpRequest!=null){
		var stuNum=document.getElementById("stunum").value;
		var url="ServletStuAllScore?stunum="+stuNum;
		xmlHttpRequest.open("get",url,true);
		xmlHttpRequest.send();
		xmlHttpRequest.
	} */
	var xmlHttpRequest=null;
		if(XMLHttpRequest){
			xmlHttpRequest=new XMLHttpRequest();
		}else{
			xmlHttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
		}
		if(xmlHttpRequest!=null){
			//拿到账号
			//var stuNum=document.getElementById("stunum");
			
				var url="ServletStuAllScore?stunum="+num;
				xmlHttpRequest.open("get",url,true);
				
				xmlHttpRequest.send();
				xmlHttpRequest.onreadystatechange=function(){
					if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
						var text = xmlHttpRequest.responseText;
						//alert(text);
						document.getElementById("sum"+num).innerHTML = text;
					}
				};
			}
		}
	


function page(s){
	var frm=document.getElementById("frm");
	var pageNo=document.getElementById("pageNo");
	pageNo.value=s;
	frm.submit();
}
</script>
</head>

<body>
	<form action="ServletStuSum" method="post" id="frm">
		<div class="div_list">
			<font>${msg}</font>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td>学号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>班级</td>
					<td>专业</td>
					<td>院系</td>
					<td>总分</td>
				</tr>
				<c:forEach var="list" items="${list.pbjs }">
					<tr>
						<td>${list.getStuNum() }</td>
						<td>${list.getStuName() }</td>
						<td>${list.getStuSex() }</td>
						<td>${list.getStuAge() }</td>
						<td>${list.getStuClass() }</td>
						<td>${list.getMajor() }</td>
						<td>${list.getDepartment() }</td>
						<td id="sum${list.getStuNum() }"><a onclick="ajaxSum(${list.getStuNum() });" >查询</a></td>

					</tr>
				</c:forEach>
				<tr>
					<td colspan="8">
						<a onclick="page(1);">首页</a> 
						<c:if test="${list.isPrevious() }">
							<a onclick="page(${list.pageNo-1});">上一页</a>
						</c:if> 
						<c:if test="${(list.pageNo+1)<list.totalPage }">
						<a onclick="page(${list.pageNo+1 });">${list.pageNo+1 }</a>
						</c:if> 
						<c:if test="${(list.pageNo+2)<list.totalPage }">
						<a onclick="page(${list.pageNo+2 });">${list.pageNo+2 }</a>
						</c:if> 
						<c:if test="${list.isNext() }">
							<a onclick="page(${list.pageNo+1});">下一页</a>
						</c:if> 
						<a onclick="page(${list.totalPage });">最后一页</a> <br /> 
						跳转到：<input
						id="pageNo" type="text" name="pageNo" value="${list.pageNo }" />
						每页记录数：<input type="text" name="pageCount"
						value="${list.pageCount }" /> 
						
						<input
						type="submit" value="跳转" /> 共有${list.totalPage }页</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
