<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</ul>
									</li>
								</ul>
							</li>
							<li class="openable bg-palette4">
								<a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list-alt fa-lg"></i></span>
										<span class="text m-left-sm">常规管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										常规管理
									</span>
								</a>
								<ul class="submenu third-level">
									<li id="pp"><a href="${pageContext.request.contextPath}/carsort/carsort.jsp"><span class="submenu-label">汽车品牌</span></a></li>
									<li id="xl"><a href="${pageContext.request.contextPath}/cardetail/cardetail.jsp"><span class="submenu-label">汽车系列</span></a></li>
									<li id="zp"><a href="${pageContext.request.contextPath}/handout/handout.jsp"><span class="submenu-label">汽车赠品</span></a></li>
									<li id="ck"><a href="${pageContext.request.contextPath}/storehouse/storehouse.jsp"><span class="submenu-label">存储仓库</span></a></li>
								</ul>
							</li>
							<li class="openable bg-palette1">
								<a href="inbox.html">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-bar-chart-o  fa-lg"></i></span>
										<span class="text m-left-sm">核心管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										核心管理
									</span>
								</a>
								<ul class="submenu third-level">
									<li id="cg"><a href="${pageContext.request.contextPath}/purchase/purchase.jsp"><span class="submenu-label">采购申请</span></a></li>
									<li id="zprk"><a href="${pageContext.request.contextPath}/inhandout/inhandout.jsp"><span class="submenu-label">赠品入库</span></a></li>
									<li class="openable" id="zpck">
										<a href="#"><span class="submenu-label">赠品出库</span></a>
										<ul class="submenu fourth-level">
												<li id="cmck"><a href="${pageContext.request.contextPath}/outhandout/handout.jsp"><span class="submenu-label">出卖出库</span></a></li>
												<li id="zsck"><a href="${pageContext.request.contextPath}/outhandout/handout2.jsp"><span class="submenu-label">赠送出库</span></a></li>
										</ul>
									</li>
									<li id="clrk"><a href="${pageContext.request.contextPath}/incar/incar.jsp"><span class="submenu-label">车辆入库</span></a></li>
									<li id="clck"><a href="${pageContext.request.contextPath}/outcar/outcar.jsp"><span class="submenu-label">车辆出库</span></a></li>
								</ul>
							</li>
							<li class="openable bg-palette2">
								<a href="timeline.html">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
										<span class="text m-left-sm">销售管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										销售管理
									</span>
								</a>
								<ul class="submenu third-level">
									<li id="kh"><a href="${pageContext.request.contextPath}/custom/custom.jsp"><span class="submenu-label">客户管理</span></a></li>
									<li class="openable" id="xs">
										<a href="#"><span class="submenu-label">销售统计</span></a>
										<ul class="submenu fourth-level">
												<li id="qcxs"><a href="${pageContext.request.contextPath}/salecar/salecar.jsp"><span class="submenu-label">汽车销售</span></a></li>
												<li id="zpxs"><a href="${pageContext.request.contextPath}/salehandout/salehandout.jsp"><span class="submenu-label">赠品销售</span></a></li>
										</ul>
									</li>
									<li id="sh"><a href="${pageContext.request.contextPath}/aftersale/asale.jsp"><span class="submenu-label">售后管理</span></a></li>
								</ul>
							</li>
							<li class="openable bg-palette4">
								<a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-gears fa-lg"></i></span>
										<span class="text m-left-sm">系统设置</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										系统设置
									</span>
								</a>
								<ul class="submenu third-level">
									<li>
										<a href="${pageContext.request.contextPath}/master/psw.jsp">
											<span class="submenu-label">修改密码</span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>	
					<div class="sidebar-fix-bottom clearfix">
						<div class="user-dropdown dropup pull-left">
							<a href="#" class="dropdwon-toggle font-18" data-toggle="dropdown"><i class="ion-person-add"></i>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="inbox.html">
										邮件
										<span class="badge badge-danger bounceIn animation-delay2 pull-right">1</span>
									</a>
								</li>			  
								<li>
									<a href="#">
										通知
										<span class="badge badge-purple bounceIn animation-delay3 pull-right">2</span>
									</a>
								</li>			  
								<li>
									<a href="#" class="sidebarRight-toggle">
										消息
										<span class="badge badge-success bounceIn animation-delay4 pull-right">7</span>
									</a>
								</li>			  	  
								<li class="divider"></li>
								<li>
									<a href="#">设置</a>
								</li>			  	  
							</ul>
						</div>
						<a href="${pageContext.request.contextPath}/master.do?method=exit" class="pull-right font-18"><i class="ion-log-out"></i></a>
					</div>
				</div><!-- sidebar-inner -->
			</aside>