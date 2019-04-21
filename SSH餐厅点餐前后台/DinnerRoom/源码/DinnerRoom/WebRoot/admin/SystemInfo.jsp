<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系统信息</title>
    <script src="common/layui/layui.all.js"></script>
	<link rel="stylesheet" href="common/layui/css/layui.css">
	<script src="../js/jquery-1.8.3.js"></script>
	<script src="common/layui/layui.js"></script>
	<script src="common/js/SystemInfo.js"></script>
</head>
<body>
<table class="layui-table">
  <colgroup>
    <col width="150">
    <col width="200">
  </colgroup>
  <thead>
    <tr>
      <th>检测项目</th>
      <th>信息</th>
    </tr> 
  </thead>
  <tbody>
    <tr>
      <td>系统时间</td>
      <td><div id="time"></div></td>
    </tr>
    <tr>
      <td>浏览器/系统信息</td>
      <td>
      	<div id="browseInfo"></div>
      	<script>
	    	var oCC=new TClientCheck();
	    	var oInfo=document.getElementById('browseInfo');
	    	oInfo.innerHTML='<p>您使用的是浏览器是：<b>'+oCC.getBrowse()+'</b></p><p>您使用的浏览器的内核是：<b>'+oCC.browseKernel+'</b></p><p>您使用的操作系统是：<b>'+oCC.getOS()+'</b></p><p>User Agent:'+oCC.userAgent+'</p>';
		</script>
      </td>
    </tr>
    <tr>
      <td>本机ip</td>
      <td>
		<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
		<script type="text/javascript">
		    document.write('本机ip：'+returnCitySN["cip"]+','+returnCitySN["cname"]);
		</script>
      </td>
    </tr>
    <tr>
  </tbody>
</table>
</body>
</html>