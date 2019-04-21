<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!------------------- javaScript ---------------->
<script language="JavaScript" src="../res/js/main.js"> 
</script> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>单选题的显示和修改</title>

</head>
<body>
<form action="Cexam_newPageUpdateChoose1" method=post>
<table width="700" >
	<tr>
		<td>${requestScope.type}</td>
	</tr>
	<tr>
		<td><textarea name="choose1_head" "
			clos="" rows="10" cols="75">${choose1.ch_question}
  </textarea></td>
	</tr>
</table>
<!----------------------------- 单选中的选项和答案 ------------------------>
<input value="${choose1.ch_id }" name="choose1_id" type="hidden"/>
<table width="700" >

	<tr>
		<td width="50" class="BODY">选项A:</td>
		<td width="450" class="BODY"><input value="${requestScope.choose1.keya }"
			type="text" name="choose1_keya" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">选项B:</td>
		<td><input type="text" name="choose1_keyb" size="80"
			value="${choose1.keyb }" /></td>
	</tr>
	<tr>
		<td class="BODY">选项C:</td>
		<td><input type="text" name="choose1_keyc" size="80"
			value="${choose1.keyc }" /></td>
	</tr>
	<tr>
		<td class="BODY">选项D:</td>
		<td><input type="text" name="choose1_keyd" size="80"
			value="${choose1.keyd }" /></td>
	</tr>
	<tr>
		<td class="BODY">答案:</td>
		<td><input type="text" name="choose1_answer" size="80"
			value="${choose1.answer }" /></td>
		<td><input type="submit" name="update" value="修改" /></td>
		<td><input type="reset" name="reset" value="重置" /></td>
	</tr>
</TABLE>
</body>
</html>
