<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>全部菜谱</title>
<link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.css">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="js/bootbox.min.js"></script>
<style type="text/css">
	#menuView p{
		margin-top: 10px;
	}
</style>
<script src="js/OrderMenu.js"></script>
</head>
<body>
	<div class="container">
	<div class="row">
			<div class="col-md-12"><h2>订单信息</h2></div>
		</div>
	<div class="row">
		<div class="col-md-12">
			<form class="form-horizontal" role="form">
				<fieldset>
					<!--disabled 禁用属性-->
					<legend>生成订单</legend>
					<div class="form-group">
						<label class="col-sm-2 control-label">餐桌号码</label>
						<div class="col-sm-4">
							<select id="table_id" name="table_id" class="form-control">
								<option value="-1">请选择餐桌编号</option>
								<c:if test="${empty dtList}">
									<option value="-1">无人就坐</option>
								</c:if>
								<c:if test="${!empty dtList}">
								<c:forEach items="${dtList}" var="dtList">
									<option value="${dtList.tableNum}">${dtList.tableNum}</option>
								</c:forEach>
								</c:if>
							</select>
						</div>
						<label class="col-sm-2 control-label">操作人员编号</label>
						<div class="col-sm-4">
							<input class="form-control" id="userCode" name="userCode"
								type="text" placeholder="下单人Code" autocomplete="off" />
						</div>
					</div>
					<div class="form-group">
						<div style="margin-top: 10px;">
							<label class="col-sm-2 control-label">用餐人数</label>
							<div class="col-sm-4">
								<input class="form-control" id="personNum" name="personNum"
									type="text" placeholder="用餐人数" autocomplete="off" />
							</div>
						</div>
					</div>
					<div class="form-group" style="margin-top:10px;">
						<div style="width: 210px;margin: 0px auto;">
							<input type="button" id="jiesuan" value="确定下单" class="btn btn-success">
							<input type="button" id="outOrder" value="清空全部信息" class="btn btn-danger" style="margin-left:10px;">
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		</div>
		<div class="row">
			<div class="col-md-12"><h2>菜谱</h2></div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<ul id="myTab" class="nav">
				<c:forEach items="${mtlist}" var="mtlist">
	   				<li><a href="#${mtlist.id}" data-toggle="tab">
	      				${mtlist.typeName}</a>
	   				</li>
	   			</c:forEach>
				</ul>
			</div>
			<div class="col-sm-9">
				<div id="myTabContent" class="tab-content">
					<c:forEach items="${mtlist}" var="mtlist">
				   		<div class="tab-pane fade" id="${mtlist.id}">
							<div class="row">
								<c:if test="${empty mtlist.menuList}">
									<div class="col-md-12">
										<h3 class="text-center">无数据</h3>
									</div>
								</c:if>
								<c:if test="${!empty mtlist.menuList}">
									<c:forEach items="${mtlist.menuList}" var="menulist">
										<div class="col-md-3" style="margin: 10px 0px 10px 50px;">
											<div class="thumbnail">
												<img
													src="<%=request.getContextPath() %>${'/upload/'}${menulist.imagePath}" />
											</div>
											<div id="menuView" class="caption text-center">
												<h3>
													${menulist.MName}
												</h3>
												<p style="margin-left: 10px;font: 20px/25px 宋体;color: red;">
													￥：${menulist.MPrice}元
												</p>
												<p>描述：${menulist.remark}</p>
												<section>
												<p>
													<button type="button" name="jiancount" style="background-color: transparent;border: 0px;">
											        	<span class="glyphicon glyphicon-minus"></span>
											        </button>
											        <input type="text" value="1" name="count" readonly="readonly" style="width: 20px;text-align: center;border: 0px;">
        											<button type="button" name="jiacount" style="background-color: transparent;border: 0px;">
											        	<span class="glyphicon glyphicon-plus"></span>
											        </button>
												</p>
												<p>
													备注（忌口）：<input type="text" value="无" name="rank" style="width: 70px;border: 0px;border-bottom: 1px solid #000;">
												</p>
												<p>
													<button type="button" name="isok" class="btn btn-primary">
														点餐 <input type="checkbox" name="id" value="${menulist.id}"
															style="display: none;">
													</button>
													<button type="button" name="res" class="btn btn-default">
														取消</button>
												</p>
												</section>
											</div>
										</div>
									</c:forEach>
								</c:if>
							</div>
				   		</div>
			   		</c:forEach>
				</div>
			</div>
		</div>
		<!-- 以下内容为原菜单页面 -->
		<%-- <div class="col-md-12" style="margin-top: 20px;">
			<h2>菜谱</h2>
			<div class="panel-group" id="accordion" style="margin:0px;">
				<c:forEach items="${mtlist}" var="mtlist">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title text-center" data-toggle="collapse"
								data-parent="#accordion" href="#collapse${mtlist.id}">
								${mtlist.typeName}</h3>
						</div>
						<div id="collapse${mtlist.id}"
							class="panel-collapse collapse <c:if test="${mtlist.id==1}">in</c:if>">
							<div class="row">
								<c:if test="${empty mtlist.menuList}">
									<div class="col-md-12">
										<h3 class="text-center">无数据</h3>
									</div>
								</c:if>
								<c:if test="${!empty mtlist.menuList}">
									<c:forEach items="${mtlist.menuList}" var="menulist">
										<div class="col-md-3" style="margin: 10px 0px 10px 50px;">
											<div class="thumbnail">
												<img
													src="<%=request.getContextPath() %>${'/upload/'}${menulist.imagePath}" />
											</div>
											<div id="menuView" class="caption text-center">
												<h3>
													${menulist.MName} <span
														style="margin-left: 10px;font: 20px/25px 宋体;color: red;">
														￥：${menulist.MPrice} </span>
												</h3>
												<p>描述：${menulist.remark}</p>
												<section>
												<p>
													<button type="button" name="jiancount" style="background-color: transparent;border: 0px;">
											        	<span class="glyphicon glyphicon-minus"></span>
											        </button>
											        <input type="text" value="1" name="count" readonly="readonly" style="width: 20px;text-align: center;border: 0px;">
        											<button type="button" name="jiacount" style="background-color: transparent;border: 0px;">
											        	<span class="glyphicon glyphicon-plus"></span>
											        </button>
												</p>
												<p>
													备注（忌口）：<input type="text" value="无" name="rank" style="width: 70px;border: 0px;border-bottom: 1px solid #000;">
												</p>
												<p>
													<button type="button" name="isok" class="btn btn-primary">
														点餐 <input type="checkbox" name="id" value="${menulist.id}"
															style="display: none;">
													</button>
													<button type="button" name="res" class="btn btn-default">
														取消</button>
												</p>
												</section>
											</div>
										</div>
									</c:forEach>
								</c:if>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div> --%>
	</div>
</body>
</html>