<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>updateOrDelete</title>
<script language="javascript">
<!--
//4个链接可以控制四个层的变化
function onClickTestType1(){

       MM_showHideLayers('mustStudyChoose','','show');
 		MM_showHideLayers('mustStudyText','','hide');
		MM_showHideLayers('easyStudyChoose','','hide');
		MM_showHideLayers('easyStudyText','','hide');

}
function onClickTestType2(){

       MM_showHideLayers('mustStudyChoose','','hide');
 		MM_showHideLayers('mustStudyText','','show');
		MM_showHideLayers('easyStudyChoose','','hide');
		MM_showHideLayers('easyStudyText','','hide');

}
function onClickTestType3(){

       MM_showHideLayers('mustStudyChoose','','hide');
 		MM_showHideLayers('mustStudyText','','hide');
		MM_showHideLayers('easyStudyChoose','','show');
		MM_showHideLayers('easyStudyText','','hide');

}
function onClickTestType4(){

       MM_showHideLayers('mustStudyChoose','','hide');
 		MM_showHideLayers('mustStudyText','','hide');
		MM_showHideLayers('easyStudyChoose','','hide');
		MM_showHideLayers('easyStudyText','','show');

}
-->
</script>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<LINK href="../res/css/main.css" rel=stylesheet>
<title>addTest</title>
<style type="text/css">
<!-- 表的外观 -->
.TH {
text-align:left; 
vertical-align:middle;
padding:2px;
font-size:9pt;
font-family:Arial;
cursor:hand;

background-color: #3366cc;
border-bottom: #264e75 solid 1px;
border-left: #71c2ff solid 1px;
border-right: #264e75 solid 1px;
border-top: #71c2ff solid 1px;
color: #ffffff;
text-decoration: none;
}

TD {
vertical-align:top;
background-color:#EEE;
padding:4px;
font-size:9pt;
font-family:Arial;
}
#mustStudyChoose {
	position:absolute;
	width:569px;
	height:800px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#mustStudyText {
	position:absolute;
	width:569px;
	height:800px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#easyStudyChoose {
	position:absolute;
	width:569px;
	height:800px;
	z-index:1;
	left: 9px;
	top: 45px;
}
#easyStudyText {
	position:absolute;
	width:569px;
	height:800px;
	z-index:1;
	left: 9px;
	top: 45px;
}


</style>
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
</head>
<body>



<table border="1" width="480" bgcolor="#E8E8E8" cellpadding="2"
	class="TH">
	<tr bgcolor="#FFFFFF">
		<td width="120" id="onClick1" onClick="onClickTestType1();"><a
			href="#">显示必修课选择题</a></td>
		<td width="120" id="onClick2" onClick="onClickTestType2();"><a
			href="#">显示选修课选择题</a></td>
		<td width="120" id="onClick3" onClick="onClickTestType3();"><a
			href="#">显示必修课填空题</a></td>
		<td width="120" id="onClick4" onClick="onClickTestType4();"><a
			href="#">显示选修课填空题</a></td>
	</tr>
</table>
<!--------------------------------- 1.必修课选择题层 ------------------------->

<div id="mustStudyChoose" style="visibility: visible;">
<table width="700"  >

	<tr>
		<td colspan="5">必修课选择题:</td>
	</tr>
	<tr>
		<td width="54">题目编号</td>
		<td width="58">课程编号</td>
		<td width="46">类型</td>
		<td width="420">提问</td>
		<td width="37">修改</td>
		<td width="41">删除</td>
	</tr>
	<!-------- forEach循环给出必修课的选择题的每一条信息 ------->
	<!-------- 用链接传必修课选择题这个信息把servlet ------->
	<c:forEach items="${choose1List}" var="choose1" begin="0">
		<tr>
			<td>${choose1.ch_id}</td>
			<td>${choose1.l_id}</td>
			<td><c:choose>
				<c:when test="${choose1.type==1}">
单选
</c:when>
				<c:when test="${choose1.type==2}">
多选
</c:when>
				<c:otherwise>
无法识别
</c:otherwise>
			</c:choose></td>
			<td>${choose1.ch_question}</td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteCompulsoryChooseServlet?cType=mustChoose&view=${choose1.ch_id}"
				target="_blank">修改</a></td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteCompulsoryChooseServlet?dType=mustChoose&delete=${choose1.ch_id}">
			删除</a></td>
		</tr>

	</c:forEach>

	<tr>
		<td><input type="hidden" name="choose1Page" value="${choose1Page}" /></td>
	</tr>

<!-- 分页控件 -->
<tr><td colspan="6">
${choose1PageStr}
</td>
</tr>
<tr><td colspan="6">
${choose1ToString}
</td>
</tr>
</table>

</div>

<!--------------------------------- 2.选修课选择题层 ------------------------->
<div id="mustStudyText" style="visibility: hidden;">

<table width="700" >


	<tr>
		<td colspan="5">选修课选择题:</td>
	</tr>
	<tr>
		<td width="54">题目编号</td>
		<td width="58">课程编号</td>
		<td width="46">类型</td>
		<td width="420">提问</td>
		<td width="37">修改</td>
		<td width="41">删除</td>
	</tr>
	<!-------- forEach循环给出选修课的选择题的每一条信息 ------->
	<!-------- 用链接传选修课选择题这个信息把servlet ------->
	<c:forEach items="${choose2List}" var="choose2" begin="0">
		<tr>
			<td>${choose2.ch_id}</td>
			<td>${choose2.l_id}</td>
			<td><c:choose>
				<c:when test="${choose2.type==1}">
单选
</c:when>
				<c:when test="${choose2.type==2}">
多选
</c:when>
				<c:otherwise>
无法识别
</c:otherwise>
			</c:choose></td>
			<c:set value="${choose2}" var="choose2" scope="session"></c:set>
			<td>${choose2.ch_question}</td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteElectiveChooseServlet?cType=easyChoose&view=${choose2.ch_id}"
				target="_blank">修改</a></td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteElectiveChooseServlet?dType=easyChoose&delete=${choose2.ch_id}">
			删除</a></td>
		</tr>
	</c:forEach>

	<!-- 分页控件 -->
<tr><td colspan="6">
${choose2PageStr}
</td>
</tr>
<tr><td colspan="6">
${choose2ToString}
</td>
</tr>
</table>

</div>
<!--------------------------------- 3.必修课填空题层 ------------------------->

<div id="easyStudyChoose" style="visibility: hidden;">
<table width="700" >


	<tr>
		<td colspan="5">必修课填空题:</td>
	</tr>
	<tr>
		<td width="54">题目编号</td>
		<td width="58">课程编号</td>
		<td width="466">提问</td>
		<td width="37">修改</td>
		<td width="41">删除</td>
	</tr>
	<!-------- forEach循环给出必修课的填空题的每一条信息 ------->
	<!-------- 用链接传必修课填空题这个信息把servlet ------->
	<c:forEach items="${text1List}" var="text1" begin="0">
		<tr>
			<c:set value="${text1}" var="text1" scope="session"></c:set>
			<td>${text1.text_id}</td>
			<td>${text1.l_id }</td>
			<td>${text1.text_question}</td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteCompulsoryTextServlet?cType=mustText&view=${text1.text_id}"
				target="_blank">修改</a></td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteCompulsoryTextServlet?dType=mustText&delete=${text1.text_id}">
			删除</a></td>
		</tr>
	</c:forEach>

	<!-- 分页控件 -->
<tr><td colspan="6">
${text1PageStr}
</td>
</tr>
<tr><td colspan="6">
${text1ToString}
</td>
</tr>
</table>
</div>
<!--------------------------------- 4.选修课填空题层 ------------------------->
<div id="easyStudyText" style="visibility: hidden;">
<table width="700" >

	<tr>
		<td colspan="5">选修课填空题:</td>
	</tr>
	<tr>
		<td width="54">题目编号</td>
		<td width="58">课程编号</td>
		<td width="466">提问</td>
		<td width="37">修改</td>
		<td width="41">删除</td>
	</tr>
	<!-------- forEach循环给出必修课的填空题的每一条信息 ------->
	<!-------- 用链接传必修课填空题这个信息把servlet ------->
	<c:forEach items="${text2List}" var="text2" begin="0">
		<tr>
			<c:set value="${text2}" var="text2" scope="session"></c:set>
			<td>${text2.text_id}</td>
			<td><c:out value="${text2.l_id}" default="null"></c:out></td>
			<td>${text2.text_question}</td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteElectiveTextServlet?cType=easyText&view=${text2.text_id}"
				target="_blank">修改</a></td>
			<td class="BODY"><a
				href="Cexam_uploadOrDeleteElectiveTextServlet?dType=easyText&delete=${text2.text_id}">
			删除</a></td>

		</tr>
	</c:forEach>

	<!-- 分页控件 -->
<tr><td colspan="6">
${text2PageStr}
</td>
</tr>
<tr><td colspan="6">
${text2ToString}
</td>
</tr>
</table>

</div>


</body>
</html>
