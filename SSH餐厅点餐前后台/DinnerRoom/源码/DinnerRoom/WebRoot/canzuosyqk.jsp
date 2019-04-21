<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>餐桌使用情况</title>
<link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="js/layui/css/layui.css">
<script src="js/layui/layui.all.js"></script>
<script src="js/jquery-3.2.1.js"></script>
<script src="js/layui/layui.js"></script>
<script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="js/canzuosyqk.js"></script>
</head>
<body>
	<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
		<h2
			style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;">
			<b>餐桌使用情况</b>
		</h2>
	</header>
	<section style="width: 143px;margin-top: 10px;margin-left: 10px;">
		<button id="refresh" type="button" class="btn btn-default btn-sm">
			<span class="glyphicon glyphicon-refresh"></span> 刷新餐桌使用情况
		</button>
	</section>
	<section class="col-md-12">
		<c:forEach items="${dtableList}" var="dtableList">
		<div class="col-sm-6 col-md-2" style="margin-top:20px;">
			<div class="thumbnail">
				<img src="img/cz.png" class="img-circle" />
			</div>
			<div class="caption text-center">
				<h3>餐桌号：${dtableList.tableNum}</h3>
				<h3 style="color: red;margin-top: 5px;">可坐人数：${dtableList.tablePernum}</h3>
				<p style="margin-top: 10px;">
					<button type="button" name="jz" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-ok"></span> 就坐
					</button>
					<input type="text" name="tabid" value="${dtableList.id}" readonly="readonly" hidden="hidden">
				</p>
			</div>
		</div>
		</c:forEach>
	</section>
</body>
</html>