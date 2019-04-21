<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>会员列表</title>
    <script src="common/layui/layui.all.js"></script>
    <link rel="stylesheet" href="common/layui/css/layui.css">
    <script src="../js/jquery-1.8.3.js"></script>
    <script src="common/layui/layui.js"></script>
    <script src="common/js/huiyuan.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>会员列表</b></h2>
</header>
<section style="width: 600px;height: 45px;margin-left: 25px;margin-top: 17px;">
    <form class="layui-form">
        手机号：
        <div class="layui-inline" style="margin-right: 15px;">
            <input class="layui-input" name="phone" id="phone" placeholder="请输入手机号" autocomplete="off">
        </div>
        类型：
        <div class="layui-inline" style="width: 130px;">
            <select name="mtype" id="mtype" class="layui-select">
                <option value="-1">请选择类型</option>
                <c:forEach items="${membertypelist}" var="membertypelist">
                	<option value="${membertypelist.id}">${membertypelist.typeName}</option>
                </c:forEach>
            </select>
        </div>
        <button id="search" type="button" class="layui-btn" style="margin-left: 10px;">搜索</button>
    </form>
</section>
<table class="layui-hide" id="tabs" lay-filter="tab"></table>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="memberType">
{{d.memberType.typeName}}
</script>
</body>
</html>