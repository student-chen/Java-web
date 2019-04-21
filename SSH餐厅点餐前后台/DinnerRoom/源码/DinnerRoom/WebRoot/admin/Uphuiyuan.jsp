<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改会员</title>
    <link rel="stylesheet" href="common/layui/css/layui.css">
    <script src="../js/jquery-1.8.3.js"></script>
    <script src="common/layui/layui.js"></script>
    <script src="common/js/Uphuiyuan.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>修改会员</b></h2>
</header>
<section style="border: 0px solid red;width: 500px;margin: 20px auto;">
    <form class="layui-form" id="frm" method="post" action="UpdateMember">
    <input type="text" id="id" name="id" value="${upid}" readonly="readonly" hidden="hidden"/>
        <div class="layui-form-item">
            <label class="layui-form-label">会员名字：</label>
            <div class="layui-input-inline">
                <input type="text" value="${memberInfo.name}" name="upname" id="mname" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号：</label>
            <div class="layui-input-inline">
                <input type="text" value="${memberInfo.phone}" name="upphone" id="phone" placeholder="请输入手机号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">会员类型：</label>
            <div class="layui-input-inline">
                <select id="mtype" name="uptypeId" lay-verify="required">
                    <option value="-1">请选择一个类型</option>
                    <c:forEach items="${membertypelist}" var="membertypelist">
                		<option value="${membertypelist.id}" <c:if test="${memberInfo.memberType.id==membertypelist.id}">selected="selected"</c:if>>${membertypelist.typeName}</option>
                	</c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">会员积分：</label>
            <div class="layui-input-inline">
                <input type="text" value="${memberInfo.mcode}" id="mcode" name="upmcode" placeholder="请输入会员积分" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div style="width: 280px;margin-left: 60px;">
                <button class="layui-btn" type="submit">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <button type="button" id="ret"  class="layui-btn layui-btn-primary">返回</button>
            </div>
        </div>
    </form>
</section>
</body>
</html>
