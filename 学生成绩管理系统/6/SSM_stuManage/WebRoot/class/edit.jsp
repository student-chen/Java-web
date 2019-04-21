<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="<c:url value="/styles/main.css" />" type="text/css"
    rel="stylesheet" />
<title>编辑班级</title>
<base href="<c:url value="/" />" />
</head>
<body>
    <div class="main">
        <h2 class="title">
            <span>编辑班级</span>
        </h2>
        <form:form action="cla/editSave" modelAttribute="entity">
            <fieldset>
                <legend>班级</legend>
               <p>
                <label for="name">班级名称：</label>
                <form:input path="name" size="50"/>
                <form:errors path="name" cssClass="error"></form:errors>
            </p>
            <p>
                <label for="type">班级类别：</label>
                <form:select path="type">
                     <form:option value="0">普通版</form:option>
                     <form:option value="1">实验班</form:option>
                </form:select>
                <form:errors path="type" cssClass="error"></form:errors>
            </p>
            <form:hidden path="id" />
            <input type="submit" value="保存" class="btn out">
            </fieldset>
        </form:form>
        <p style="color: red">${message}</p>
        <form:errors path="*"></form:errors>
        <p>
            <a href="cla/list" class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>