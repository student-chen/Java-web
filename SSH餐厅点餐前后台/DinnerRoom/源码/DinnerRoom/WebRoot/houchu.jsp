<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后厨配菜板块</title>
    <script src="js/layui/layui.all.js"></script>
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/layui/layui.js"></script>
    <script src="js/houchu.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>订单</b></h2>
</header>
<table class="layui-hide" id="tabs" lay-filter="tab"></table>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">查看详情</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">完成</a>
</script>

</body>
</html>