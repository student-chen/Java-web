<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>添加会员</title>
    <link rel="stylesheet" href="common/layui/css/layui.css">
    <script src="../js/jquery-1.8.3.js"></script>
    <script src="common/layui/layui.js"></script>
    <script src="common/js/Addyuangong.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>添加员工</b></h2>
</header>
<section style="border: 0px solid red;width: 500px;margin: 20px auto;">
    <form class="layui-form" action="" method="post" id="frm">
    <input type="text" name="uid" id="uid" value="${Upuser.id}" readonly="readonly" hidden="hidden">
        <div class="layui-form-item">
            <label class="layui-form-label">登录名：</label>
            <div class="layui-input-inline">
                <input type="text" value="${Upuser.ULoginname}" name="loginname" id="loginname" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" <c:if test="${Upuser.URole==1}">
        style="display: none;"
        </c:if>>
            <label class="layui-form-label">密码：</label>
            <div class="layui-input-inline">
                <input type="password" value="${Upuser.UPwd}" name="pwd" id="pwd" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" <c:if test="${Upuser.URole==1}">
        style="display: none;"
        </c:if>>
            <label class="layui-form-label">权限：</label>
            <div class="layui-input-inline">
                <select name="role" id="role" lay-verify="required">
                    <option value="-1">请选择一个类型</option>
                    <option value="1" <c:if test="${Upuser.URole==1}">selected="selected"</c:if>>系统管理员</option>
                    <option value="2" <c:if test="${Upuser.URole==2}">selected="selected"</c:if>>总经理</option>
                    <option value="3" <c:if test="${Upuser.URole==3}">selected="selected"</c:if>>前台</option>
                    <option value="4" <c:if test="${Upuser.URole==4}">selected="selected"</c:if>>员工</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-inline">
                <input type="text" value="${Upuser.UName}" name="uname" id="uname" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别：</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" <c:if test="${Upuser.USex=='男'}">checked="checked"</c:if>>
                <input type="radio" name="sex" value="女" title="女" <c:if test="${Upuser.USex=='女'}">checked="checked"</c:if>>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机：</label>
            <div class="layui-input-inline">
                <input type="tel" value="${Upuser.UPhone}" name="phone" id="phone" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证：</label>
            <div class="layui-input-inline">
                <input type="text" value="${Upuser.UIdcard}" name="idcard" id="idcard" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地址：</label>
            <div class="layui-input-inline">
                <input type="text" value="${Upuser.UAddress}" name="address" id="address" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div style="width: 280px;margin-left: 60px;">
                <button class="layui-btn" id="adduser" type="button">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            	<c:if test="${!empty Upuser}">
                	<button type="button" id="ret"  class="layui-btn layui-btn-primary">返回</button>
                </c:if>
            </div>
        </div>
    </form>
</section>
</body>
</html>
