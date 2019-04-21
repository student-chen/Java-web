<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

			<footer class="footer">
				<span class="footer-brand">
					<strong class="text-danger">Simplify</strong> Anna
				</span>
				<p class="no-margin">
					&copy; 2017 <strong>Simplify Anna</strong>. 版权所有. 
				</p>	
			</footer>
		</div><!-- /wrapper -->

		<a href="#" class="scroll-to-top hidden-print"><i class="fa fa-chevron-up fa-lg"></i></a>

		<!-- Delete Widget Confirmation -->
		<div class="custom-popup delete-widget-popup delete-confirmation-popup" id="deleteWidgetConfirm">
			<div class="popup-header text-center">
				<span class="fa-stack fa-4x">
				  <i class="fa fa-circle fa-stack-2x"></i>
				  <i class="fa fa-lock fa-stack-1x fa-inverse"></i>
				</span>
			</div>
			<div class="popup-body text-center">
				<h5>Are you sure to delete this widget?</h5>
				<strong class="block m-top-xs"><i class="fa fa-exclamation-circle m-right-xs text-danger"></i>This action cannot be undone</strong>
			
				<div class="text-center m-top-lg">
					<a class="btn btn-success m-right-sm remove-widget-btn">Delete</a>
					<a class="btn btn-default deleteWidgetConfirm_close">Cancel</a>
				</div>
			</div>
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
