<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/styles/main.css"/>"  type="text/css" rel="stylesheet" />
<title>学生管理</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>学生管理</span></h2>
        <form action="<c:url value="/stu/deletes?pageNO=${pageNO}"/>" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th><input type="checkbox" id="chbAll"></th>
                <th>学生编号</th>
                <th>学生姓名</th>
                <th>电话</th>
                <th>地址</th>
                <th>所在班级</th>
            </tr>
            <c:forEach var="entity" items="${slist}" varStatus="status">
                <tr>
                    <th><input type="checkbox" name="id" value="${entity.id}"></th>
                    <td>${entity.id}</td>
                    <td>${entity.name}</td>
                    <td>${entity.tel}</td>
                    <td>${entity.address}</td>
                    <td>${entity.classname}</td>
                </tr>
            </c:forEach>
        </table>
        <p style="color: red">${message}</p>
        <!--分页 -->
        <script type="text/javascript" src="<c:url value="/scripts/jquery-1.10.2.min.js"/>" ></script>
        <link href="<c:url value="/scripts/pagination.css"/>"  type="text/css" rel="stylesheet" />
        <script type="text/javascript" src="<c:url value="/scripts/jquery.pagination.js"/>" ></script>
    </form>
    </div>
</body>
</html>
