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
        <form action="<c:url value="/stu/semycou"/>" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th><input type="checkbox" id="chbAll"></th>
                <th>课程名称</th>
                <th>代课教师</th>
                <!-- <th>操作</th> -->
            </tr>
            <c:forEach var="entity" items="${colist}" varStatus="status">
                <tr>
                   <td>
                     <input type="checkbox" name="cou" value="${entity.id}_${entity.tId}"/>
                   </td>
                   <td>
                     <label>${entity.name}@@@@@@@@@@@${entity.id}_${entity.tId}</label>
                   </td>
                   <td>
                     <label>${entity.tname}</label>
                   </td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <input type="submit" value="提交"/>
        </p>
        <p style="color: red">${message}</p>
        <!--分页 -->
        <script type="text/javascript" src="<c:url value="/scripts/jquery-1.10.2.min.js"/>" ></script>
    </form>
    </div>
</body>
</html>
