<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script language="JavaScript" src="../images/main.js"> 
</script> 


<script type="text/javascript">
<!--
//这是单选,多选,填空三个层的显隐效果的函数
function changeTestType(){
 if(document.all("TestType").selectedIndex==0){
        MM_showHideLayers('head','','show');
 		MM_showHideLayers('choose1','','show');
		MM_showHideLayers('choose2','','hide');
		MM_showHideLayers('text','','hide');
 }else if(document.all("TestType").selectedIndex==1){
 		  MM_showHideLayers('head','','show');
 		MM_showHideLayers('choose1','','hide');
		MM_showHideLayers('choose2','','show');
		MM_showHideLayers('text','','hide');
 }else{
   MM_showHideLayers('head','','show');
 		MM_showHideLayers('choose1','','hide');
		MM_showHideLayers('choose2','','hide');
		MM_showHideLayers('text','','show');
 }
}
-->
</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>增加必修课的试题--包括单选,多选,填空</title>

<script type="text/JavaScript">
<!--
function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_showHideLayers() { //v6.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}
//-->
</script>
<!-- 层的固定 -->
<style type="text/css">
<!--
#choose1 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#choose2 {
		position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#text {
	position:absolute;
	width:200px;
	height:115px;
	z-index:1;
	left: 9px;
	top: 45px;
}
-->
</style>
</head>
<body>

<!------------------------------- 表单项 ----------------------------------->
<form name=exam_addTest action=Cexam_uploadTestServlet method=post>
<div id="head"  style="visibility: visible;"
	onload="MM_showHideLayers('head','','show','choose1','','show','choose2','','hide','text','','hide');MM_showHideLayers('head','','show','choose1','','hide','choose2','','show','text','','hide');MM_showHideLayers('head','','show','choose1','','hide','choose2','','hide','text','','show')">
<table width="700" >
	<tr>
		<td class="BODY">您教的必修课有:</td>
		<td width=><select id="sub" class="INPUT_text" name="course"
			length="1">
        
			<c:forEach items="${requestScope.courseList}" var="course">
				<option value="${course}">${course}   <!-- 从Cexam_addtestServlet来的变量 -->
			</c:forEach>

		</select></td>
		<td class="BODY">题目类型</td>
		<td><select id="TestType" class="INPUT_text" name="testType"
			length="1" onchange="changeTestType();">  <!-- onchange调用层的显隐函数 -->
			<option value="1" selected>单选</option>
			<option value="2">多选</option>
			<option value="3">填空题</option>
		</select></td>
		<td><input type="submit" neme="" value="提交" /></td>
	</tr>
</TABLE>
</div>
<br>
<!----------------------------- 单选中的题目头 ------------------------>
<div id="choose1" style="visibility: visible;">
<table width="700" >
	<tr>
		<td><textarea name="choose1_head" clos="" rows="10" cols="75">
        请将题目按缩进格式输入此区域
  </textarea></td>
	</tr>
</table>
<!----------------------------- 单选中的选项和答案 ------------------------>
<table width="700" >

	<tr>
		<td width="50" class="BODY">选项A:</td>
		<td width="450" class="BODY"><input type="text" name="choose1_Keya"
			size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">选项B:</td>
		<td><input type="text" name="choose1_Keyb" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">选项C:</td>
		<td><input type="text" name="choose1_Keyc" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">选项D:</td>
		<td><input type="text" name="choose1_Keyd" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">答案:</td>
		<td><label><font class="BODY">A</font><input type="radio" name="Key1"
			value="a" /></label>&nbsp;&nbsp; <label><font class="BODY">B</font><input
			type="radio" name="Key1" value="b" /></label> &nbsp;&nbsp;<label><font
			class="BODY">C</font><input type="radio" name="Key1" value="c" /></label>&nbsp;&nbsp;
		<label><font class="BODY">D</font><input type="radio" name="Key1"
			value="d" /></label></td>
	</tr>
</TABLE>
</div>
<!----------------------------- 多选中的题目头 ------------------------>
<div id="choose2" style="visibility: hidden;">
<table width="700" >
	<tr>
		<td><textarea name="choose2_head" clos="" rows="10" cols="75">
        请将题目按缩进格式输入此区域
  </textarea></td>
	</tr>
</table>
<!----------------------------- 多选中的选项和答案 ------------------------>
<table width="700" >

	<tr>
		<td width="50" class="BODY">选项A:</td>

		<td width="450" class="BODY"><input type="text" name="choose2_Keya"
			size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">选项B:</td>
		<td><input type="text" name="choose2_Keyb" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">选项C:</td>
		<td><input type="text" name="choose2_Keyc" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">选项D:</td>
		<td><input type="text" name="choose2_Keyd" size="80" /></td>
	</tr>
	<tr>
		<td class="BODY">答案:</td>
		<td><label><font class="BODY">A</font><input type="checkbox"
			name="Key2" value="a" /></label>&nbsp;&nbsp; <label><font
			class="BODY">B</font><input type="checkbox" name="Key2" value="b" /></label>
		&nbsp;&nbsp;<label><font class="BODY">C</font><input type="checkbox"
			name="Key2" value="c" /></label>&nbsp;&nbsp; <label><font
			class="BODY">D</font><input type="checkbox" name="Key2" value="d" /></label></td>
	</tr>
</TABLE>
</div>
<!----------------------------- 填空中的题目头 ------------------------>
<div id="text" style="visibility: hidden;">
<table width="700" >
	<tr>
		<td><textarea name="text_head" clos="" rows="10" cols="60">
        请将题目按缩进格式输入此区域
  </textarea></td>
	</tr>
</table>
<!----------------------------- 填空中的答案 ------------------------>
<table width="700" >

	<tr>
		<td class="BODY">答案:</td>
		<td><input type="text" name="Key" size="80" /></td>

	</tr>
</TABLE>
</div>
</form>
</body>
</html>






