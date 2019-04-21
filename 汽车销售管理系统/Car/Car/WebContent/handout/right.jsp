<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/handout/handout.js">
	</script>
	<input type="hidden" value="${pageContext.request.contextPath}/" id="path">
		<div class="main-container" style="min-height: 800px;">
			<div class="padding-md">
				<ul class="breadcrumb">
					<li>
						<span style="margin-right: 10px;">
						<i class="fa fa-location-arrow fa-lg"></i></span><span class="primary-font">
						<i class="icon-home"></i></span>
						<a href="${pageContext.request.contextPath}/main/main.jsp">首页</a>
					</li>
					<li>常规管理</li>
					<li>汽车赠品</li>
				</ul>
				<div class="smart-widget widget-dark-blue">
						<div class="smart-widget-header">
							<div id="toolbar" class="btn-group">
						            <button id="btn_add" type="button" class="btn btn-default" >
						                <i class="fa fa-edit"></i>新增
						            </button>
						            <button id="btn_edit" type="button" class="btn btn-default" >
						                <i class="fa fa-edit"></i>修改
						            </button>
					        </div>
							<span class="smart-widget-option">
								<span class="refresh-icon-animated">
									<i class="fa fa-circle-o-notch fa-spin"></i>
								</span>
	                            <a href="#" class="widget-toggle-hidden-option">
	                                <i class="fa fa-cog"></i>
	                            </a>
	                            <a href="#" class="widget-collapse-option" data-toggle="collapse">
	                                <i class="fa fa-chevron-up"></i>
	                            </a>
	                        </span>
						</div>
						<div class="smart-widget-inner" style="height: 100%;">
							<div class="smart-widget-hidden-section">
								<ul class="widget-color-list clearfix">
									<li style="background-color:#20232b;" data-color="widget-dark"></li>
									<li style="background-color:#4c5f70;" data-color="widget-dark-blue"></li>
									<li style="background-color:#23b7e5;" data-color="widget-blue"></li>
									<li style="background-color:#2baab1;" data-color="widget-green"></li>
									<li style="background-color:#edbc6c;" data-color="widget-yellow"></li>
									<li style="background-color:#fbc852;" data-color="widget-orange"></li>
									<li style="background-color:#e36159;" data-color="widget-red"></li>
									<li style="background-color:#7266ba;" data-color="widget-purple"></li>
									<li style="background-color:#f5f5f5;" data-color="widget-light-grey"></li>
									<li style="background-color:#fff;" data-color="reset"></li>
								</ul>
							</div>
							<div class="smart-widget-body" id="divbody">
								 <div id="tools"></div>
					        	 <table id="tb_departments"></table>
					      	 	 <input type="hidden"  id="path" value="${pageContext.request.contextPath }/">
							</div>
						</div><!-- ./smart-widget-inner -->
					</div><!-- ./smart-widget -->
			</div>
		</div>