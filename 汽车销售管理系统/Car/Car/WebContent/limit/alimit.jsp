<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet" type="text/css"/>
<!-- Font Awesome -->
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	rel="stylesheet">
<!-- ionicons -->
<link href="${pageContext.request.contextPath}/css/ionicons.min.css"
	rel="stylesheet">

<!-- Morris -->
<link href="${pageContext.request.contextPath}/css/morris.css"
	rel="stylesheet" />

<!-- Datepicker -->
<link href="${pageContext.request.contextPath}/css/datepicker.css"
	rel="stylesheet" />

<!-- Animate -->
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">

<!-- Owl Carousel -->
<link href="${pageContext.request.contextPath}/css/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/owl.theme.default.min.css"
	rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-table.css" type="text/css"></link>
<!-- Simplify -->
<link href="${pageContext.request.contextPath}/css/simplify.min.css" rel="stylesheet">
	<!-- 依赖于jquery包 -->
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	  <script src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>
	   <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	  <script src="${pageContext.request.contextPath }/js/bootstrap-table-zh-CN.js"></script>

	  <script type="text/javascript" src="${pageContext.request.contextPath}/js/limit/alimit.js">
	  </script>
<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
</head>

<body class="overflow-hidden">
		<div class="main-container">
			<input type="hidden" value="${pageContext.request.contextPath}/" id="path">
			<input type="hidden" value="<%=request.getParameter("moduleid") %>" id="mid">
			<input type="hidden" value="<%=request.getParameter("groupid") %>"  id="gid">
			<div class="smart-widget">
						<div class="smart-widget-header" style="margin-top: 0px; padding-top: 10px;">
							<h4 style="margin-top: 0px; padding-top: 10px;">
								<span id="gg"><%=new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8") %>|</span>
								<span id="mm"></span>
							</h4>
						</div>
						<div class="smart-widget-inner" style="height: 100%;">
							<div class="smart-widget-body" id="divbody">
							</div>
						</div><!-- ./smart-widget-inner -->
					</div><!-- ./smart-widget -->
			</div>
		<!-- Bootstrap -->
	  
		<!-- Flot -->
		<script src='${pageContext.request.contextPath}/js/jquery.flot.min.js'></script>

		<!-- Slimscroll -->
		<script src='${pageContext.request.contextPath}/js/jquery.slimscroll.min.js'></script>
		

		<!-- Datepicker -->
		<script src='${pageContext.request.contextPath}/js/uncompressed/datepicker.js'></script>

		<!-- Sparkline -->
		<script src='${pageContext.request.contextPath}/js/sparkline.min.js'></script>

		<!-- Skycons -->
		<script src='${pageContext.request.contextPath}/js/uncompressed/skycons.js'></script>
		
		<!-- Popup Overlay -->
		<script src='${pageContext.request.contextPath}/js/jquery.popupoverlay.min.js'></script>

		<!-- Easy Pie Chart -->
		<script src='${pageContext.request.contextPath}/js/jquery.easypiechart.min.js'></script>

		<!-- Sortable -->
		<script src='${pageContext.request.contextPath}/js/uncompressed/jquery.sortable.js'></script>

		<!-- Owl Carousel -->
		<script src='${pageContext.request.contextPath}/js/owl.carousel.min.js'></script>

		<!-- Modernizr -->
		<script src='${pageContext.request.contextPath}/js/modernizr.min.js'></script>
		
		<!-- Simplify -->
		<script src="${pageContext.request.contextPath}/js/simplify/simplify.js"></script>


		<script>
			$(function()	{
				$('.chart').easyPieChart({
					easing: 'easeOutBounce',
					size: '140',
					lineWidth: '7',
					barColor: '#7266ba',
					onStep: function(from, to, percent) {
						$(this.el).find('.percent').text(Math.round(percent));
					}
				});

				$('.sortable-list').sortable();

				$('.todo-checkbox').click(function()	{
					
					var _activeCheckbox = $(this).find('input[type="checkbox"]');

					if(_activeCheckbox.is(':checked'))	{
						$(this).parent().addClass('selected');					
					}
					else	{
						$(this).parent().removeClass('selected');
					}
				
				});

				//Delete Widget Confirmation
				$('#deleteWidgetConfirm').popup({
					vertical: 'top',
					pagecontainer: '.container',
					transition: 'all 0.3s'
				});
			});
			
		</script>
	
  	</body>
</html>
