<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>订单管理</title>
    <link rel="stylesheet" href="common/layui/css/layui.css">
    <script src="../js/jquery-1.8.3.js"></script>
    <script src="common/layui/layui.js"></script>
    <script src="common/js/dingdan.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>订单信息管理</b></h2>
</header>
<section style="width: 95%;height: 45px;padding-left: 25px;margin-top: 17px;border:0px solid red;">
    <form action="" method="post" style="width: 100%;">
        订单号：
        <div class="layui-inline" style="margin-right: 15px;">
            <input class="layui-input" name="id" id="id" placeholder="请输入订单编号" autocomplete="off">
        </div>
        订单日期：
        <div class="layui-inline" style="margin-right: 15px;">
            <input type="text" name="startTime" id="startTime" placeholder="开始时间" autocomplete="off" class="layui-input">
        </div>
        -
        <div class="layui-inline" style="margin-left: 15px;">
            <input type="text" name="endTime" id="endTime" placeholder="结束时间" autocomplete="off" class="layui-input">
        </div>
        <button id="search" type="button" class="layui-btn" style="margin-left: 10px;">搜索</button>
    </form>
</section>
<table class="layui-hide" id="tabs" lay-filter="tab"></table>
<footer style="width: 250px;text-align: right;color: red;font: 20px/35px 宋体;float: left;margin-right: 20px;">
    <b>￥本页订单总额：<span id="sumprice">0</span>元</b>
</footer>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">订单详情</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
</html>
