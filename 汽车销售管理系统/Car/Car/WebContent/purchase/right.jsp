<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/purchase/purchase.js">
	</script>
		<div class="main-container" style="min-height: 800px;">
			<div class="padding-md">
				<ul class="breadcrumb">
					<li>
						<span style="margin-right: 10px;">
						<i class="fa fa-location-arrow fa-lg"></i></span><span class="primary-font">
						<i class="icon-home"></i></span>
						<a href="${pageContext.request.contextPath}/main/main.jsp">首页</a>
					</li>
					<li>核心管理</li>
					<li>采购申请</li>
				</ul>
				<div class="smart-widget widget-dark-blue">
						<div class="smart-widget-header">
							<div id="toolbar" class="btn-group">
						            <button id="btn_add" type="button" class="btn btn-default">
						                <i class="fa fa-edit"></i>   申请
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
								 	<div class="panel-body">
						                <form id="formSearch" class="form-horizontal">
						                    <div class="form-group" style="margin-top:15px">
						                        <label class="control-label col-sm-1" for="txt_search_statu">状态</label>
						                        <div class="col-sm-3">
						                            <select class="form-control" id="sel">
						                            	<option value="5">--请选择--</option>
														<option value="0">审核未发送</option>
														<option value="1">审批之中</option>
														<option value="2">审核未通过</option>
														<option value="3">审核已通过</option>
						                            </select>
						                        </div>
						                        <div class="col-sm-4">
						                            <button type="button"  id="btn_query" class="btn btn-primary">查询</button>
						                        </div>
						                    </div>
						                </form>
						            </div>
								 <div id="tools"></div>
					        	 <table id="tb_departments"></table>
					      	 	 <input type="hidden"  id="path" value="${pageContext.request.contextPath }/">
					      	 	 <input type="hidden"  id="flag" value="<%=request.getParameter("flag")%>">
							</div>
						</div><!-- ./smart-widget-inner -->
					</div><!-- ./smart-widget -->
			</div>
		</div>