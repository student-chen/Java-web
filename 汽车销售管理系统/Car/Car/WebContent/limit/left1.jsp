<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pub.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/left.js"></script>
<aside class="sidebar-menu fixed">
				<div class="sidebar-inner scrollable-sidebar">
					<div class="main-menu">
						<ul class="accordion">
							<li class="menu-header">
								Main Menu
							</li>
							<li class="bg-palette1">
								<a href="${pageContext.request.contextPath}/main/main.jsp">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-home fa-lg"></i></span>
										<span class="text m-left-sm">首页</span>
									</span>
									<span class="menu-content-hover block">
										首页
									</span>
								</a>
							</li>
							<li class="openable bg-palette2">
								<a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-desktop fa-lg"></i></span>
										<span class="text m-left-sm">组织结构</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										组织结构
									</span>
								</a>
								<ul class="submenu third-level">
									<li id="zz"><a href="${pageContext.request.contextPath}/dept/dept.jsp"><span class="submenu-label">组织结构</span></a></li>
									<li id="gw"><a href="${pageContext.request.contextPath}/station/station.jsp"><span class="submenu-label">岗位结构</span></a></li>
									<li id="zc"><a href="${pageContext.request.contextPath}/zc/zc.jsp"><span class="submenu-label">职称设置</span></a></li>
								</ul>
							</li>
							<li class="openable bg-palette3 open">
								<a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list fa-group fa-lg"></i></span>
										<span class="text m-left-sm">员工权限</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										员工权限
									</span>
								</a>
								<ul class="submenu third-level">
									<li id="yg"><a href="${pageContext.request.contextPath}/master/master.jsp"><span class="submenu-label">员工管理</span></a></li>
									<li class="openable open" id="qxzx">
										<a href="#"><span class="submenu-label">权限中心</span></a>
									<ul class="submenu fourth-level">							