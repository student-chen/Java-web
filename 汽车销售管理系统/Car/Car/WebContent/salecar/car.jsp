<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../main/top.jsp"%>
<%@ include file="../salecar/left.jsp"%>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/salecar/car.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/highcharts.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/highcharts-3d.src.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/exporting.src.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/report/zxt.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/laydate/laydate.js"></script>
		<div class="main-container" style="min-height: 800px;">
			<div class="padding-md">
				<ul class="breadcrumb">
					<li>
						<span style="margin-right: 10px;">
						<i class="fa fa-location-arrow fa-lg"></i></span><span class="primary-font">
						<i class="icon-home"></i></span>
						<a href="${pageContext.request.contextPath}/main/main.jsp">首页</a>
					</li>
					<li>销售管理</li>
					<li>销售统计</li>
					<li>汽车销售统计</li>
				</ul>
				<div class="smart-widget widget-dark-blue">
						<div class="smart-widget-header">
							<div class="row">
								<div class="col-md-2">
									<div class="input-group">
										<span class="input-group-addon" style="background-color:white;">
											品牌 :
										</span> 
										<select class="form-control" id="sort1">
											<option value="0" selected="selected">--请选择--</option>
										</select>
									</div>	
								</div>
								<div class="col-md-2">
									<div class="input-group">
										<span class="input-group-addon" style="background-color:white;">
											品牌 :
										</span> 
										<select class="form-control" id="sort2">
											<option value="0" selected="selected">--请选择--</option>
										</select>
									</div>	
								</div>
								<div class="col-md-2">
									<div class="input-group">
										<span class="input-group-addon" style="background-color:white;">
											年份 :
										</span> 
										<input type="text" class="form-control" id="year"/>
									</div>	
								</div>
								<script type="text/javascript">
									//执行一个laydate实例
									  laydate.render({
										  elem: '#year'
										 ,type: 'year'
										});
								</script> 
								<div class="col-md-4">
									<button id="mybtn" type="button" class="btn btn-default">
						                <i class="fa fa-search"></i>   分析
						            </button>	
						            <button id="back" type="button" class="btn btn-default">
						                <i class="fa fa-reply"></i>   返回
						            </button>
								</div>
							</div>
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
								<br><br>
								 <input type="hidden" value="${pageContext.request.contextPath}/" id="path">
								 <div class="row">
								 	<div class="col-md-1"></div>
								 	<div class="col-md-10">
								 		<div id="container" style="width:100%;" align="center"></div>
								 	</div>
								 	<div class="col-md-1"></div>
								 </div>
								  
							</div>
						</div><!-- ./smart-widget-inner -->
					</div><!-- ./smart-widget -->
			</div>
		</div>
<%@ include file="../main/footer.jsp"%>		
