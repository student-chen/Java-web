<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<LINK href="../res/css/main.css" rel=stylesheet>
<title>选修考试</title>

</head>
<!-- 一进页面就开始记时 -->
<body onload="beginTimer()">
<h1 align="center">选修考试</h1>
<form name="testForm" id="TestForm" method="post"
	action="Cexam_giveElectiveScore" target="mainFrame">
<table  width="534" align="center">
	<caption>课程号:${courseId}</caption>
	<tr>
		<td><input type="hidden" name="courseId" value="${courseId}" /></td>
	</tr>
	<tr>
		<td width="109">${sessionScope.student.s_name
		}你的学号是:${sessionScope.student.s_id }</td>
		<td width="403">单选:${countOfChoose1}个,多选:${countOfChoose2}个,填空:${countOfText}个,剩余时间:<input
			name="Btime" type="text" id="Btime" readonly="readonly"
			align="bottom" size="5" /></td>
		<td><input type="submit" name="submit" value="交卷" /></td>
	</tr>
</table>
<table width="534"  align="center">
	<tr>
		<td width="516" height="23">一、单选题 :(每题 2分)</td>
	</tr>
</table>

 <%int i = 0;
			int j = 0;
			int k = 0;

			%> <c:forEach end="${countOfChoose1-1}" begin="0"
	items="${compulsoryPaper}" var="Choose1">
	<table  width="534"  align="center">
		<%i++;

				%>


		<tr>
			<td height="90">题目<%=i%>: ${Choose1.ch_question}</td>
		</tr>
		<tr>
			<td height="25">A选项: ${Choose1.keya}</td>
		</tr>
		<tr>
			<td height="25">B选项: ${Choose1.keyb}</td>
		</tr>
		<tr>
			<td height="25">C选项: ${Choose1.keyc}</td>
		</tr>
		<tr>
			<td height="25">D选项: ${Choose1.keyd}</td>
		</tr>

		<tr>
			<td height="25"><label><font class="BODY">A</font><input type="radio"
				name="Key1<%=i%>" value="a" /></label>&nbsp;&nbsp; <label><font
				class="BODY">B</font><input type="radio" name="Key1<%=i%>" value="b" /></label>
			&nbsp;&nbsp;<label><font class="BODY">C</font><input type="radio"
				name="Key1<%=i%>" value="c" /></label>&nbsp;&nbsp; <label><font
				class="BODY">D</font><input type="radio" name="Key1<%=i%>" value="d" /></label></td>
		</tr>
		<tr><td>
		<input type="hidden" name="choose1id<%=i%>" value="${Choose1.ch_id}" /></td></tr>
	</table>
</c:forEach>
<table  width="534" align="center">
	<tr>
		<td height="23">二、多选题:(每题 4分)</td>
	</tr>
</table>
<c:forEach end="${countOfChoose1+countOfChoose2-1}"
	begin="${countOfChoose1}" items="${compulsoryPaper}" var="Choose2">
	<table class="TH" width="534" height="435" border="3" align="center">
		<%j++;

				%>
<tr><td>
		<input type="hidden" name="choose2id<%=j%>" value="${Choose2.ch_id}" /></td></tr>

		<tr>
			<td height="90">题目<%=j%>: ${Choose2.ch_question}</td>
		</tr>
		<tr>
			<td height="25">A选项: ${Choose2.keya}</td>
		</tr>
		<tr>
			<td height="25">B选项: ${Choose2.keyb}</td>
		</tr>
		<tr>
			<td height="25">C选项: ${Choose2.keyc}</td>
		</tr>
		<tr>
			<td height="25">D选项: ${Choose2.keyd}</td>
		</tr>

		<tr>
			<td height="25"><label><font class="BODY">A</font><input
				type="checkbox" name="Key2<%=j%>" value="a" /></label>&nbsp;&nbsp;
			<label><font class="BODY">B</font><input type="checkbox"
				name="Key2<%=j%>" value="b" /></label> &nbsp;&nbsp;<label><font
				class="BODY">C</font><input type="checkbox" name="Key2<%=j%>"
				value="c" /></label>&nbsp;&nbsp; <label><font class="BODY">D</font><input
				type="checkbox" name="Key2<%=j%>" value="d" /></label></td>
		</tr>
		<tr><td>
		<input type="hidden" name="choose2id<%=j%>" value="${Choose2.ch_id}" /></td></tr>
	</table>
</c:forEach>
<table  width="534" align="center">
	<tr>
		<td>三、填空题:(每题 4分)</td>
	</tr>
</table>
<c:forEach begin="${countOfChoose1+countOfChoose2}"
	items="${compulsoryPaper}" var="Text">
	<table width="534"  align="center">
		<%k++;

				%>

		<input type="hidden" name="textid<%=k%>" value="${Text.text_id}" />

		<tr>
			<td height="92">题目<%=k%>: ${Text.text_question}</td>
		</tr>

		<tr>
			<td height="25"><input type="text" name="text<%=k%>" size="80" /></td>
		</tr>
	</table>
</c:forEach></form>
</body>
</html>
<script>
<!--
var limit = "60:00";
if(document.images){
var parseLimit = limit.split(":");
parseLimit = parseLimit[0] * 60 + parseLimit[1] * 1;
}
function beginTimer(){
if(!document.images) return;
if(parseLimit == 1){
//下面是限制时间到了后面的连接的页面,可以手动修改
window.location="Cexam_giveElectiveScore";
}else{
parseLimit -= 1;
curmin = Math.floor(parseLimit/60);
cursec = parseLimit%60;
curtime = curmin + ":" + cursec;
setTimeout("beginTimer()",1);
//在文本框中显示剩余的时间
document.testForm.Btime.value=curtime;
}
}

//-->
</script>
