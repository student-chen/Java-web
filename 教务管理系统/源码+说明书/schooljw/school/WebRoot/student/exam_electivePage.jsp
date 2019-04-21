<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>进选修考试页面</title>
</head>
<body>
<h1>您进的是选修考试页面</h1>
<p>${student.s_name}您好,您的班级是:${className}</p>

<form action="Cexam_getElectivePaperToElectiveTestPage"
	method="POST" name="selectAcourse"><label>选择可以进行的考试有: <select
	class="INPUT_text" name="course" length="1">
	<c:forEach items="${courseList}" begin="0" var="course">
		<option value="${course[0] }" />${course[1]}
	</c:forEach>
</select></label> <input type="submit" name="submit" value="确定" /></form>
<hr width="1000" size="1" color="#0000FF">

</body>
</html>
