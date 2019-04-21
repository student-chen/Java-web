<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>添加/修改菜谱</title>
	<link rel="stylesheet" href="common/layui/css/layui.css"  media="all">
	<script src="../js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="common/layui/layui.js"></script>
	<style type="text/css">
		.file{
			position: relative;
			width: 100px;
			height: 130px;
			border: 1px solid #C0C0C0;
		}
		.file img{
			width: 100%;
			height: 100%;
		}
		.file input{
			position: absolute;
			display: inline;
			width: 100%;
			height: 100%;
			opacity: 0;
			-moz-opacity: 0;
			filter:alpha(opacity=0);
			outline: medium none;
			font-size:0px;
			top:0px;
			left: 0px;
		}
	</style>
	<script type="text/javascript" src="common/js/Addcaipu.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
	<h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>添加菜谱</b></h2>
</header>
<section style="border: 0px solid red;width: 500px;margin: 20px auto;">
<form id="frm" class="layui-form" enctype="multipart/form-data" method="post" action="addMenu">
	<input type="text" value="${updateMenuInfo.id}" id="menuid" name="menuid" readonly="readonly" hidden="hidden">
<input type="text" value="${updateMenuInfo.imagePath}" name="oldimagePath" readonly="readonly" hidden="hidden">
	<div class="layui-form-item">
		<label class="layui-form-label">菜名：</label>
		<div class="layui-input-inline">
			<input type="text" value="${updateMenuInfo.MName}" name="mname" id="mname" placeholder="请输入" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">价格：</label>
		<div class="layui-input-inline">
			<input type="text" value="${updateMenuInfo.MPrice}" name="mprice" id="mprice" placeholder="请输入价格" autocomplete="off" class="layui-input">
		</div>
		<div class="layui-form-mid layui-word-aux">价格为整数</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">菜肴种类：</label>
		<div class="layui-input-inline">
			<select name="typeid" id="typeid" lay-verify="required">
				<option value="-1"></option>
				<c:if test="${empty updateMenuInfo}">
					<c:forEach items="${mtlist}" var="mtlist">
					<option value="${mtlist.id}">${mtlist.typeName}</option>
					</c:forEach>
				</c:if>
				<c:if test="${!empty updateMenuInfo}">
					<c:forEach items="${mtlist}" var="mtlist">
					<option value="${mtlist.id}" <c:if test="${updateMenuInfo.menuType.id==mtlist.id}">selected="selected"</c:if>>${mtlist.typeName}</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">图片：</label>
		<div class="layui-input-inline file">
			<img id="images" src="common/icon/image.png"/>
			<input type="file" id="image_path" name="upload" onchange="handleFiles(this)">
		</div>

	</div>
	<div class="layui-form-item layui-form-text">
		<label class="layui-form-label">说明：</label>
		<div class="layui-input-inline">
			<textarea name="remark" id="remark" placeholder="请输入内容" class="layui-textarea">${updateMenuInfo.remark}</textarea>
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" id="btn" type="button">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>
</section>
</body>
</html>
