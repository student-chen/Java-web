<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加餐桌</title>
    <link rel="stylesheet" href="common/layui/css/layui.css">
    <script src="../js/jquery-1.8.3.js"></script>
    <script src="common/layui/layui.js"></script>
    <script src="common/js/Addcanzhuo.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>添加餐桌位</b></h2>
</header>
<section style="position: relative;border: 0px solid red;width: 500px;margin: 20px auto;">
    <form id="frm" class="layui-form" action="">
    <input type="text" name="upid" id="upid" value="${diningTable.id}" readonly="readonly" hidden="hidden">
        <div class="layui-form-item">
            <label class="layui-form-label">座位号：</label>
            <div class="layui-input-inline">
                <input type="text" value="${diningTable.tableNum}" name="tablenum" id="table_num" placeholder="请输入座位号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">可座人数：</label>
            <div class="layui-input-inline">
                <input type="text" value="${diningTable.tablePernum}" name="tablePernum" id="table_Pernum" placeholder="请输入餐桌可座人数" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div style="width: 280px;margin-left: 60px;">
                <button class="layui-btn" id="addtable" type="button">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <c:if test="${!empty diningTable}">
                	<button type="button" id="ret"  class="layui-btn layui-btn-primary">返回</button>
                </c:if>
            </div>
        </div>
    </form>
</section>
</body>
</html>