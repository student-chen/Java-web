<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title></title>
  </head>
<body bgcolor="#8dd8f8" >
<table align="center">
<tr height="200"><td></td></tr>
<tr><td><div align="center"> 
<script>
if (document.layers)
var ns4def=''
</script> 
</div><h2 id="flyin" style="position:relative;left:-400;font-style:italic" style=&{ns4def}; align="center"><font face="幼圆" size="7" color="#0080ff"><i>欢迎使用学生成绩管理系统！</i></font></h2>
<script language="JavaScript1.2">
if (document.getElementById||document.all)
var crossheader=document.getElementById? document.getElementById("flyin").style : document.all.flyin.style

function animatein(){
if (parseInt(crossheader.left)<0)
crossheader.left=parseInt(crossheader.left)+20
else{
crossheader.left=0
crossheader.fontStyle="normal"
clearInterval(start)
}
}
if (document.getElementById||document.all)
start=setInterval("animatein()",50)
</script>
</td></tr></table>

 </body>
</html>
