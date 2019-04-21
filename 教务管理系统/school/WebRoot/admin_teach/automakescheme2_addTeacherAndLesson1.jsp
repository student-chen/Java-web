<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>排课第二步-为这个班级选择老师和课程</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<LINK href="../res/css/main.css" rel=stylesheet>
<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>
<script type="text/javascript">
 function getResult(stateVal) {
         var url = "CautoMakeScheme_selectTeacherServlet?state="+stateVal; 
         if (window.XMLHttpRequest) { 
                 req = new XMLHttpRequest(); 
         }else if (window.ActiveXObject) { 
                 req = new ActiveXObject("Microsoft.XMLHTTP"); 
         } 
         if(req){ 
                 req.open("GET",url, true); 
                 req.onreadystatechange = complete; 
                 req.send(null); 
         } 
 } 
 function complete(){
         if (req.readyState == 4) { 
                 if (req.status == 200) { 
                         var teacher = req.responseXML.getElementsByTagName("teacher"); 
                         //alert(teacher.length);
                         var str=new Array();
                         for(var i=0;i<teacher.length;i++){
                                 str[i]=teacher[i].firstChild.data;
                         }
                         //alert(document.getElementById("teacher"));
                         buildSelect(str,document.getElementById("teacher"));
                 }
         }
 }
 function buildSelect(str,sel) {
         sel.options.length=0;
         for(var i=0;i<str.length;i++) {
                 sel.options[sel.options.length]=new Option(str[i],str[i])
         }
 }
 </script>
<body>
排课第二步-为这个班级选择老师和课程
<br>
在一个班里老师和课程是一对一的关系
<form method="post" action="CautoMakeScheme_getLesson1AndTeacherInfo">

<table width="596" height="210" class="tableborder">
	<tr>
		<!--------------------- 选择课程和班级 --------------------->
		<td width="156">
		<table width="147" class="tableborder">
			<caption>班级:${className} 阶段:${phase}</caption>
			<tr>
				<td>选择必修课程:</td>
			</tr>
			<tr>
				<td><SELECT name="state" onChange="getResult(this.value)">
					<c:forEach items="${lesson1List}" var="lesson1">
						<option value="${lesson1.lessonName}" />${lesson1.lessonName}
					</c:forEach>
				</SELECT></td>
			</tr>

			<tr>
				<td>对应的老师:</td>
			</tr>
			<tr>
				<td><SELECT id="teacher" name="teacher">
					<option value="-1" selected />==========
				</SELECT></td>
			</tr>
		</table>

		<!--------------------- 确定按钮 ---------------------></td>
		<td width="28" bordercolor="#00FF00" align="justify"><input
			type="submit" name="Submit" value="=>" align="middle"></td>
		<!--------------------- 显示老师,课程,班级 --------------------->
		<td width="396" valign="top">
		<table width="397" height="55" class="tableborder">
			<tr>
				<td height="32">编号</td>
				<td>老师</td>
				<td>课程</td>
				<td>班级</td>
				<td>删除</td>
			</tr>
			<c:forEach items="${c_l_t_list}" var="c_l_t">
				<tr>
				<c:forEach items="${c_l_t}" var="info">
					<td>${info}</td>
				</c:forEach>
				<c:forEach items="${c_l_t}" var="clt" begin="0" end="0">
				<td><a href="CautoMakeScheme_deleteClassAndTeacherForClasses?action=${clt}">删除</a></td>	
				</c:forEach>
				</tr>
			</c:forEach>
		</table>
		</td>
	<tr>
</table>
<c:if
	test='${(warnMessage != null)|| (warnMessage != "") || (warnMessage != "null") || (warnMessage != "NULL") }'><font color="red">${warnMessage}</font></c:if>
</form>
<p><input type="button" onclick="window.history.go(-1)" value="开始自动排课"></p>
</body>
</html>
