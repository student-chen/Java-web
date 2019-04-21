<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>排课第一步-选择班级和第几阶段</title>
</head>
<body>
排课第一步-选择班级和第几阶段
<br>
<form name="" action="CautoMakeScheme_getCalssAndPhaseTosession" method="POST">
<table width="400">
	<tr>
		<td><label>班级:<SELECT id="class" name="class">

			<c:forEach items="${myClassList}" var="myClass">
				<option value="${myClass.name}"/>${myClass.name}
			</c:forEach>
		</SELECT></label></td>
		<td><label>阶段:<SELECT id="phase" name="phase">
			<option value="A" />A阶段
			
		</SELECT></label></td>
		<td><input name="" type="submit" value="确定" /></td>
	</tr>
</table>
<font color="red">${warnMessage}</font>
</body>
</html>
