<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>必修课打分</title>
</head>
<body>
<center><h1>您的成绩如下</h1></center>
<p>${student.s_name}您好,</p>
<p>您的单选题分数为:${choose1Mark}</p>
<p>您的多选题分数为:${choose2Mark}</p>
<p>您的填空题分数为:${textMark}</p>
<p>您的考试分数为:${s_mark}</p>
<a href="Cexam_getStudentCourseTocompulsoryPage" >返回考试页面</a>
</body>
</html>