<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	
  	</head>

  	<body class="overflow-hidden light-background">
		<div class="wrapper no-navigation preload">
			<div class="error-wrapper">
				<div class="error-inner">
					<div class="error-type">404</div>
					<h1>你还没有登录！</h1>
					<p>登录后才可以访问该网站</p>
					<div class="m-top-md">
						<a href="${pageContext.request.contextPath}/login.jsp" class="btn btn-default btn-lg text-upper">返回登录</a>
					</div>
				</div><!-- ./error-inner -->
			</div><!-- ./error-wrapper -->
		</div><!-- /wrapper -->

		<a href="" id="scroll-to-top" class="hidden-print"><i class="icon-chevron-up"></i></a>

	    <!-- Le javascript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
		
		<!-- Jquery -->
		<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
		
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

		<script>
			$(function()	{
				setTimeout(function() {
					$('.error-type').addClass('animated');
				},100);
			});
		</script>
		
  	</body>
</html>
