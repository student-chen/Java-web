<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="${pageContext.request.contextPath}/css/owl.theme.default.min.css"
	rel="stylesheet">
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-table.css" type="text/css"></link>
<!-- Simplify -->
<link href="${pageContext.request.contextPath}/css/simplify.min.css" rel="stylesheet">
	<!-- 依赖于jquery包 -->
	 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	  <script src="${pageContext.request.contextPath }/js/bootstrap-table.js"></script>
	   <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	  <script src="${pageContext.request.contextPath }/js/bootstrap-table-zh-CN.js"></script>


<script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
</head>

<body class="overflow-hidden">
	<div class="wrapper preload">		<!-- 右侧消息 -->
		<div class="sidebar-right">
			<div class="sidebar-inner scrollable-sidebar">
				<div class="sidebar-header clearfix">
					<input class="form-control dark-input" placeholder="Search"
						type="text">
				</div>
				<div class="title-block">Group Chat</div>
				<div class="content-block"></div>
				<div class="title-block">Favorites</div>
				<div class="content-block"></div>
				<div class="title-block">More friends</div>
				<div class="content-block"></div>
			</div>
			<!-- sidebar-inner -->
		</div>
		<!-- sidebar-right -->
		<!-- 顶部主体 -->
		<header class="top-nav">
			<div class="top-nav-inner">
				<div class="nav-header">
					<button type="button"
						class="navbar-toggle pull-left sidebar-toggle"
						id="sidebarToggleSM">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

					<ul class="nav-notification pull-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="fa fa-cog fa-lg"></i></a> <span
							class="badge badge-danger bounceIn">1</span>
							<ul class="dropdown-menu dropdown-sm pull-right user-dropdown">
								<li class="user-avatar"><img
									src="${pageContext.request.contextPath}/images/profile/profile1.jpg"
									alt="" class="img-circle">
									<div class="user-content">
										<h5 class="no-m-bottom">&nbsp;Admin</h5>
										<div class="m-top-xs">
											<a href="#" class="m-right-sm">个人信息</a> <a
												href="master.do?method=exit">退出</a>
										</div>
									</div></li>
								<li><a href="inbox.html"> 邮&nbsp;&nbsp;&nbsp;&nbsp;件 <span
										class="badge badge-danger bounceIn animation-delay2 pull-right">1</span>
								</a></li>
								<li><a href="#"> 通&nbsp;&nbsp;&nbsp;&nbsp;知 <span
										class="badge badge-purple bounceIn animation-delay3 pull-right">2</span>
								</a></li>
								<li><a href="#" class="sidebarRight-toggle">
										消&nbsp;&nbsp;&nbsp;&nbsp;息 <span
										class="badge badge-success bounceIn animation-delay4 pull-right">7</span>
								</a></li>
								<li class="divider"></li>
								<li><a href="#">设置</a></li>
							</ul></li>
					</ul>

					<a href="index.html" class="brand"> <i class="fa fa-smile-o"></i><span
						class="brand-name">汽车销售企业管理系统</span>
					</a>
				</div>
				<div class="nav-container">
					<button type="button"
						class="navbar-toggle pull-left sidebar-toggle"
						id="sidebarToggleLG">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<ul class="nav-notification">
						<li class="search-list">
							<div class="search-input-wrapper">
								<div class="search-input">
									<input type="text" class="form-control input-sm inline-block">
									<a href="#" class="input-icon text-normal"><i
										class="ion-ios7-search-strong"></i></a>
								</div>
							</div>
						</li>
					</ul>
					<div class="pull-right m-right-sm">
						<div class="user-block hidden-xs">
							<a href="#" id="userToggle" data-toggle="dropdown"> <img
								src="${pageContext.request.contextPath}/images/profile/profile1.jpg"
								alt="" class="img-circle inline-block user-profile-pic">
								<div class="user-detail inline-block">
									${sessionScope.master.mrealname} &nbsp;&nbsp;<i class="fa fa-angle-down"></i>
								</div>
							</a>
							<div class="panel border dropdown-menu user-panel">
								<div class="panel-body paddingTB-sm">
									<ul>
										<li><a href="profile.html"> <i
												class="fa fa-edit fa-lg"></i><span class="m-left-xs">个人信息</span>
										</a></li>
										<li><a href="inbox.html"> <i
												class="fa fa-inbox fa-lg"></i><span class="m-left-xs">邮件</span>
												<span class="badge badge-danger bounceIn animation-delay3">2</span>
										</a></li>
										<li><a href="${pageContext.request.contextPath}/master.do?method=exit"> <i
												class="fa fa-power-off fa-lg"></i><span class="m-left-xs">退出</span>
										</a></li>
									</ul>
								</div>
							</div>
						</div>
						<ul class="nav-notification">
							<li><a href="#" data-toggle="dropdown"><i
									class="fa fa-envelope fa-lg"></i></a> <span
								class="badge badge-purple bounceIn animation-delay5 active">2</span>
								<ul class="dropdown-menu message pull-right">
									<li><a>你有2条未读消息！</a></li>
									<li><a class="clearfix" href="#"> <img
											src="${pageContext.request.contextPath}/images/profile/profile2.jpg"
											alt="User Avatar">
											<div class="detail">
												<strong>John Doe</strong>
												<p class="no-margin">Lorem ipsum dolor sit amet...</p>
												<small class="text-muted"><i
													class="fa fa-check text-success"></i>27分钟</small>
											</div>
									</a></li>
									<li><a class="clearfix" href="#"> <img
											src="${pageContext.request.contextPath}/images/profile/profile3.jpg"
											alt="User Avatar">
											<div class="detail">
												<strong>Jane Doe</strong>
												<p class="no-margin">Lorem ipsum dolor sit amet...</p>
												<small class="text-muted"><i
													class="fa fa-check text-success"></i> 5小时</small>
											</div>
									</a></li>
									<li><a class="clearfix" href="#"> <img
											src="${pageContext.request.contextPath}/images/profile/profile4.jpg"
											alt="User Avatar">
											<div class="detail m-left-sm">
												<strong>Bill Doe</strong>
												<p class="no-margin">Lorem ipsum dolor sit amet...</p>
												<small class="text-muted"><i class="fa fa-reply"></i>
													昨天</small>
											</div>
									</a></li>
									<li><a class="clearfix" href="#"> <img
											src="${pageContext.request.contextPath}/images/profile/profile5.jpg"
											alt="User Avatar">
											<div class="detail">
												<strong>Baby Doe</strong>
												<p class="no-margin">Lorem ipsum dolor sit amet...</p>
												<small class="text-muted"><i class="fa fa-reply"></i>
													2017年5月31日</small>
											</div>
									</a></li>
								</ul></li>
							<li><a href="#" data-toggle="dropdown"><i
									class="fa fa-bell fa-lg"></i></a> <span
								class="badge badge-info bounceIn animation-delay6 active">4</span>
								<ul class="dropdown-menu notification dropdown-3 pull-right">
									<li><a href="#">你有3条通知！</a></li>
									<li><a href="#"> <span
											class="notification-icon bg-warning"> <i
												class="fa fa-warning"></i>
										</span> <span class="m-left-xs">服务器没有响应</span> <span
											class="time text-muted">刚刚</span>
									</a></li>
									<li><a href="#"> <span
											class="notification-icon bg-success"> <i
												class="fa fa-plus"></i>
										</span> <span class="m-left-xs">新用户注册</span> <span
											class="time text-muted">2分钟</span>
									</a></li>
									<li><a href="#"> <span
											class="notification-icon bg-danger"> <i
												class="fa fa-bolt"></i>
										</span> <span class="m-left-xs">应用程序错误</span> <span
											class="time text-muted">5分钟</span>
									</a></li>
								</ul></li>
							<li class="chat-notification"><a href="#"
								class="sidebarRight-toggle"><i class="fa fa-comments fa-lg"></i></a>
								<span class="badge badge-danger bounceIn">1</span></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- ./top-nav-inner -->
		</header>