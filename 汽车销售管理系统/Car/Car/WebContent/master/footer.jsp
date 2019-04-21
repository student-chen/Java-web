<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

			<a href="#" class="scroll-to-top hidden-print"><i class="fa fa-chevron-up fa-lg"></i></a>
		
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
				$('.inbox-check').click(function()	{
					var activeRow = $(this).parent().parent().parent();

					activeRow.toggleClass('active');			
				});

				
				$('#inboxCollapse').click(function()	{
					$('.inbox-menu-inner').slideToggle();
				});

				$('#chkAll').click(function()	{
					if($(this).prop('checked'))	{
						$('.inbox-check').prop('checked',true);
						$('.inbox-check').parent().parent().parent().addClass('active');
					}
					else	{
						$('.inbox-check').prop('checked',false);
						$('.inbox-check').parent().parent().parent().removeClass('active');
					}
				});

				$(window).resize(function() {
					if (Modernizr.mq('(min-width: 980px)')) {
						$('.inbox-menu ul').show();
					}
				});
			});
		</script>
	
  	</body>
</html>
