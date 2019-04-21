<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>订单管理</title>
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/layui/layui.js"></script>
    <script src="js/OrderInfo.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>订单信息查看</b></h2>
</header>
<table class="layui-hide" id="tabs" lay-filter="tab"></table>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">订单详情</a>
</script>
<script type="text/html" id="isfull">
{{#  if(d.isFull == 0){ }}
	<b style='color:red;'>未上全</b>
{{#  } else if(d.isFull == 1){ }}
	上全
{{#  }  }}
</script>
<script type="text/html" id="ispay">
{{#  if(d.ispay == 0){ }}
	<b style='color:red;'>未支付</b>
{{#  } else if(d.ispay == 1){ }}
	已支付
{{#  }  }}
</script>
</body>
</html>
