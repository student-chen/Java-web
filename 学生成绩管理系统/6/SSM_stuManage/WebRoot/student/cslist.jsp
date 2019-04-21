<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/styles/main.css"/>"  type="text/css" rel="stylesheet" />
<title>查看课程</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>课程管理</span></h2>
        <form action="<c:url value="/cou/deletes?pageNO=${pageNO}"/>" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th>课程名称</th>
                <th>课程类别</th>
                <th>代课老师</th>
            </tr>
            <c:forEach var="entity" items="${ctlist}" varStatus="status">
                <tr>
                    <td>${entity.name}</td>
                    <td>
                      <c:if test="${entity.type==1}">
                                                   选修课
                      </c:if>
                      <c:if test="${entity.type==0}">
                                                    必修课
                      </c:if>
                    </td>
                    <td>${entity.tname}</td>
                    
                </tr>
            </c:forEach>
        </table>
        <script type="text/javascript" src="<c:url value="/scripts/jquery-1.10.2.min.js"/>" ></script>
    </form>
    </div>
</body>
</html>
