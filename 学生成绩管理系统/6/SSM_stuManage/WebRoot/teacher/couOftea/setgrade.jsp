<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="<c:url value="/styles/main.css" />" type="text/css" rel="stylesheet" />
<title>录入成绩</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>录入成绩</span></h2>
        <form:form action="${pageContext.request.contextPath}/tea/saveGrade" modelAttribute="entity">
        <fieldset>
            <legend>成绩</legend>
            <p>
                <label for="name">信息</label>
                <label for="name">${sname}</label>
            </p>
            <p>
                <label for="type">平时成绩</label>
                <form:input path="pgrade" size="50"/>
                <form:errors path="pgrade" cssClass="error"></form:errors>
            </p>
            <p>
                <label for="type">考试成绩</label>
                <form:input path="kgrade" size="50"/>
                <form:errors path="kgrade" cssClass="error"></form:errors>
            </p>
            
            <p>
              <form:hidden path="sid"/>
              <form:hidden path="cid"/>
              <input type="submit" value="保存" class="btn out">
            </p>
        </fieldset>
        </form:form>
        <p style="color: red">${message}</p>
        <form:errors path="*"></form:errors>
    </div>
</body>
</html>
