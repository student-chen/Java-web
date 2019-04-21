<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  	<head>
	    <meta charset="utf-8">
	    <title>汽车销售企业管理系统</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">

	    <!-- Bootstrap core CSS -->
	    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Font Awesome -->
		<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">

		<!-- ionicons -->
		<link href="${pageContext.request.contextPath}/css/ionicons.min.css" rel="stylesheet">
		
		<!-- Simplify -->
		<link href="${pageContext.request.contextPath}/css/simplify.min.css" rel="stylesheet">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js">
		</script>
		
		<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/js/master/login.js">
			</script>
  	</head>

  	<body class="overflow-hidden light-background">
		<div class="wrapper no-navigation preload">
			<div class="sign-in-wrapper">
				<div class="sign-in-inner">
					<div class="login-brand text-center">
						<i class="fa fa-smile-o m-right-xs"></i><strong class="text-skin">骏马</strong>销售综合信息平台 
						<br>
					</div>

					<form>
						<input type="hidden" value="${pageContext.request.contextPath}/" id="path">
						<div class="form-group m-bottom-md">
							<input type="text" class="form-control" placeholder="请输入用户名" id="name">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="请输入密码" id="pwd">
						</div>

						<div class="form-group">
							<div class="custom-checkbox">
								<input type="checkbox" id="chkRemember">
								<label for="chkRemember"></label>
							</div>
							记住密码
						</div>

						<div class="m-top-md p-top-sm">
							<a href="${pageContext.request.contextPath}/main/main.jsp" class="btn btn-success block" id="login">登录</a>
						</div>

					</form>
				</div><!-- ./sign-in-inner -->
			</div><!-- ./sign-in-wrapper -->
		</div><!-- /wrapper -->

		<a href="" id="scroll-to-top" class="hidden-print"><i class="icon-chevron-up"></i></a>

	    <!-- Le javascript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
		<!-- Bootstrap -->
	    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
		
		<!-- Slimscroll -->
		<script src='${pageContext.request.contextPath}/js/jquery.slimscroll.min.js'></script>
		
		<!-- Popup Overlay -->
		<script src='${pageContext.request.contextPath}/js/jquery.popupoverlay.min.js'></script>

		<!-- Modernizr -->
		<script src='${pageContext.request.contextPath}/js/modernizr.min.js'></script>
		
		<!-- Simplify -->
		<script src="${pageContext.request.contextPath}/js/simplify/simplify.js"></script>
	
  	</body>
</html>
