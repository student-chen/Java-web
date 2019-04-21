<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="common/layui/layui.all.js"></script>
    <link rel="stylesheet" href="common/layui/css/layui.css">
    <script src="../js/jquery-1.8.3.js"></script>
    <script src="common/layui/layui.js"></script>
    <script src="common/js/UpdataPwd.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>修改密码</b></h2>
</header>
<section style="width: 350px;margin-left: 150px;margin-top: 17px;border: 0px solid red;">
    <form class="layui-form layui-form-pane" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名：</label>
            <div class="layui-input-inline">
            <input type="text" value="${user.id}" name="uid" id="uid" readonly="readonly" hidden="hidden">
                <input type="text" name="title" value="${user.ULoginname}" readonly autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">原密码：</label>
            <div class="layui-input-inline">
            <input type="text" value="${user.UPwd}" name="oldpwdre" id="oldpwdre" readonly="readonly" hidden="hidden">
                <input type="password" name="oldpwd" id="oldpwd" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码：</label>
            <div class="layui-input-inline">
                <input type="password" name="newpwd" id="newpwd" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" id="btn">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</section>
</body>
</html>