<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="<c:url value="/styles/main.css" />" type="text/css"
    rel="stylesheet" />
<title>编辑教师</title>
<base href="<c:url value="/" />" />
</head>
<body>
    <div class="main">
        <h2 class="title">
            <span>编辑教师</span>
        </h2>
        <form:form action="tea/editSave" modelAttribute="entity">
            <fieldset>
                <legend>教师</legend>
               <p>
                <label for="name">教师名称：</label>
                <form:input path="name" size="50"/>
                <form:errors path="name" cssClass="error"></form:errors>
            </p>
            <p>
                <label for="usertype">教师类别：</label>
                <form:select path="usertype">
                     <form:option value="3">普通教师</form:option>
                </form:select>
                <form:errors path="usertype" cssClass="error"></form:errors>
            </p>
            <p>
                <label for="name">登录名：</label>
                <form:input path="loginname" size="50"/>
                <form:errors path="loginname" cssClass="error"></form:errors>
            </p>
            <p>
                <label for="password">密码：</label>
                <form:password path="password" size="50"/>
                <form:errors path="password" cssClass="error"></form:errors>
            </p>
            
            <form:hidden path="id" />
            <input type="submit" value="保存" class="btn out">
            </fieldset>
        </form:form>
        <p style="color: red">${message}</p>
        <form:errors path="*"></form:errors>
        <p>
            <a href="tea/list" class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>