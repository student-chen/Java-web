<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML>
<html>
  <head>
	<meta charset="utf-8">
    <title>首页</title>
	  <script src="common/layui/layui.all.js"></script>
	  <link rel="stylesheet" href="common/layui/css/layui.css">
	  <script src="../js/jquery-1.8.3.js"></script>
	  <script src="common/layui/layui.js"></script>
	  <script type="text/javascript">

	  </script>
  </head>
  <body>
  <header style="width: 100%;height: 40px;background-color: #E3E3E3;">
	  <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>报表</b></h2>
  </header>
  <section style="display:flex;padding: 15px;">
	  <section style="width: 50%;margin-right: 20px;">
		  <table class="layui-table">
			  <thead>
				  <tr>
					  <th colspan="2">昨日</th>
				  </tr>
			  </thead>
			  <tbody>
				  <tr>
					  <td>收入</td>
					  <td>${yesterdaySr}</td>
				  </tr>
				  <tr>
					  <td>接待人数</td>
					  <td>${yesterdayJdNum}</td>
				  </tr>
				  <tr>
					  <td>订单数目</td>
					  <td>${yesterdayorderNum}</td>
				  </tr>
				  </tbody>
			  </table>
		  </section>
		  <section style="width: 50%;">
			  <table class="layui-table">
				  <thead>
				  <tr>
					  <th colspan="2">今日</th>
				  </tr>
				  </thead>
				  <tbody>
				  <tr>
					  <td>当前收入</td>
					  <td>${todaySr}</td>
				  </tr>
				  <tr>
					  <td>接待人数</td>
					  <td>${toddayJdNum}</td>
				  </tr>
				  <tr>
					  <td>订单数目</td>
					  <td>${toddayorderNum}</td>
				  </tr>
				  </tbody>
			  </table>
		  </section>
  </section>
  <section style="display:flex;padding: 10px;">
	  <section style="width: 100%;">
		  <table class="layui-table">
			  <thead>
			  <tr>
				  <th colspan="2">人流量</th>
			  </tr>
			  </thead>
			  <tbody>
			  <tr>
				  <td align="center" width="50%">8：00 - 10：00</td>
				  <td align="center"><f:formatNumber type="percent" value="${rll1}"/></td>
			  </tr>
			  <tr>
				  <td align="center">10：00 - 14：00</td>
				  <td align="center"><f:formatNumber type="percent" value="${rll2}"/></td>
			  </tr>
			  <tr>
				  <td align="center">17：00 - 19：00</td>
				  <td align="center"><f:formatNumber type="percent" value="${rll3}"/></td>
			  </tr>
			  <tr>
				  <td align="center">19：00 - 24：00</td>
				  <td align="center"><f:formatNumber type="percent" value="${rll4}"/></td>
			  </tr>
			  </tbody>
		  </table>
	  </section>
  </section>
  </body>
</html>
