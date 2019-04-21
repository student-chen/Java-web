<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单结算</title>
    <link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <script src="js/layui/layui.all.js"></script>
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/layui/layui.js"></script>
    <script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script src="js/orderJieSuan.js"></script>
</head>
<body>
<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
    <h2 style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;"><b>订单结算</b></h2>
</header>
<section style="width: 95%;height: 45px;padding-left: 25px;margin-top: 17px;border:0px solid red;">
    <form action="" method="post" style="width: 100%;">
        是否支付：
        <div class="layui-inline" style="margin-right: 15px;">
           <select name="ispay" id="ispay" class="layui-select">
                <option value="-1">请选择</option>
                <option value="0">未支付</option>
                <option value="1">已支付</option>
            </select>
        </div>
        订单日期：
        <div class="layui-inline" style="margin-right: 15px;">
            <input type="text" name="startTime" id="startTime" placeholder="开始时间" autocomplete="off" class="layui-input">
        </div>
        -
        <div class="layui-inline" style="margin-left: 15px;">
            <input type="text" name="endTime" id="endTime" placeholder="结束时间" autocomplete="off" class="layui-input">
        </div>
        <button id="search" type="button" class="layui-btn" style="margin-left: 10px;">搜索</button>
        <button id="refresh" type="button" class="layui-btn" style="margin-left: 10px;">刷新订单信息</button>
    </form>
</section>
<table class="layui-hide" id="tabs" lay-filter="tab"></table>
<script type="text/html" id="bar">
{{#  if(d.ispay == 0){ }}
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">结算订单</a>
{{#  } else if(d.ispay == 1){ }}
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看订单</a>
{{#  }  }}
</script>
<script type="text/html" id="ispaytmp">
{{#  if(d.ispay == 0){ }}
	<b style='color:red;'>未支付</b>
{{#  } else if(d.ispay == 1){ }}
	已支付
{{#  }  }}
</script>
</body>
</html>