<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>会员板块</title>
<link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="js/layui/css/layui.css">
<script src="js/layui/layui.all.js"></script>
<script src="js/jquery-3.2.1.js"></script>
<script src="js/layui/layui.js"></script>
<script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="js/MemberPlate.js"></script>
<style type="text/css">
#addmemberTable {
	margin: 0px auto;
}

#addmemberTable tr {
	height: 50px;
}
</style>
</head>
<body>
	<header style="width: 100%;height: 40px;background-color: #E3E3E3;">
		<h2
			style="text-align: left;padding-left: 15px;padding-top: 5px;font: 18px/30px 宋体;">
			<b>会员管理</b>
		</h2>
	</header>
	<section
		style="width: 95%;margin-left: 25px;margin-top: 17px;">
		<table width="100%" border="0">
			<tr>
				<td width="33%">
					<form class="layui-form">
						手机号：
						<div class="layui-inline" style="margin-right: 15px;">
							<input class="layui-input" name="phone" id="phone"
								autocomplete="off">
						</div>
						<button id="search" type="button" class="layui-btn"
							style="margin-left: 10px;">搜索</button>
					</form>
				</td>
				<td width="11%">
					<button class="layui-btn" data-toggle="modal"
						data-target="#myModal">添加会员</button>
				</td>
				<td>
					<button id="refresh" type="button" class="layui-btn">刷新会员信息</button>
				</td>
			</tr>
		</table>
	</section>
	<table class="layui-hide" id="tabs" lay-filter="tab"></table>
	<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
	<script type="text/html" id="member">
{{d.memberType.typeName}}
</script>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加会员</h4>
				</div>
				<form id="addmemberfrm" action="" method="post">
					<div class="modal-body">
					<input type="text" id="mid" name="mid" class="form-control" readonly="readonly" style="display: none;">
						<table id="addmemberTable" width="70%">
							<tr>
								<td width="30%" align="right">会员类型：</td>
								<td><select id="memberType" name="memberType"
									class="form-control">
								</select></td>
							</tr>
							<tr>
								<td width="30%" align="right">会员名字：</td>
								<td><input type="text" id="name" name="name"
									class="form-control" placeholder="请输入姓名"></td>
							</tr>
							<tr>
								<td width="30%" align="right">手机号：</td>
								<td><input type="text" id="mphone" name="mphone"
									class="form-control" placeholder="请输入手机号"> 
								</td>
							</tr>
							<tr>
								<td width="30%" align="right">会员积分：</td>
								<td><input type="text" id="mcode" name="mcode"
									class="form-control" placeholder="添加无需填写积分"></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="reset" class="btn btn-default">重置</button>
						<button type="button" id="sub" class="btn btn-primary">
							提交更改</button>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>