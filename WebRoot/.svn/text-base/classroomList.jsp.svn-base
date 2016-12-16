<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ include file="/web/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">

		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta name="description" content="Xenon Boostrap Admin Panel" />
		<meta name="author" content="" />

		<title>上海财经大学国际教育学院 - 教务管理系统</title>

		<!--         -->
		<link rel="stylesheet"
			href="assets/css/fonts/linecons/css/linecons.css">
		<link rel="stylesheet"
			href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/bootstrap.css">
		<link rel="stylesheet" href="assets/css/xenon-core.css">
		<link rel="stylesheet" href="assets/css/xenon-forms.css">
		<link rel="stylesheet" href="assets/css/xenon-components.css">
		<link rel="stylesheet" href="assets/css/xenon-skins.css">
		<link rel="stylesheet" href="assets/css/custom.css">

		<script src="js/commonnew.js"></script>
		<script src="assets/js/jquery-1.11.1.min.js"></script>
		<script language="javascript" type="text/javascript"
			src="My97DatePicker/WdatePicker.js"></script>
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->


	</head>
	<body class="page-body">
		<form>
			<div class="copyrights"></div>
			<div class="page-container">
				<!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->

				<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
				<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
				<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->
				<div class="sidebar-menu toggle-others fixed">

					<div class="sidebar-menu-inner">

						<header class="logo-env">

						<!-- logo -->
						<div class="logo">
							<a href="javascript:to('ToLogin.action');" class="logo-expanded">
								<img src="assets/images/logo3.png" width="160" alt="" /> </a>
						</div>

						<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
						<div class="mobile-menu-toggle visible-xs">
							<a href="#" data-toggle="user-info-menu"> <i
								class="fa-bell-o"></i> <span class="badge badge-success">7</span>
							</a>

							<a href="#" data-toggle="mobile-menu"> <i class="fa-bars"></i>
							</a>
						</div>

						</header>



						<ul id="main-menu" class="main-menu">
							<!-- add class "multiple-expanded" to allow multiple submenus to open -->
							<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
							<li class="active opened active">



								<!--<i class="linecons-cog"></i>-->
								<span class="title" style="color: white">${role.desc}</span>

								<ul>
									<c:forEach items="${menuList}" var="right" varStatus="status">
										<li class="active" style="height: 40px;">
											<a href="javascript:to('${right.righturl}');"> <span
												class="title">${right.righttext}</span> </a>
										</li>
									</c:forEach>
								</ul>
							</li>
						</ul>

					</div>

				</div>

				<div class="main-content">

					<!-- User Info, Notifications and Menu Bar -->
					<nav class="navbar user-info-navbar" role="navigation">

					<!-- Left links for user info navbar -->
					<ul class="user-info-menu left-links list-inline list-unstyled">

						<li class="hidden-sm hidden-xs">
						<a href="#" data-toggle="sidebar">
							<i class="fa-bars"></i>
						</a>
					</li>
					</ul>


					<!-- Right links for user info navbar -->
					<ul class="user-info-menu right-links list-inline list-unstyled">
						<li class="dropdown user-profile">
							<a href="#" data-toggle="dropdown"> <img
									src="assets/images/user-4.png" alt="user-image"
									class="img-circle img-inline userpic-32" width="28" /> <span>
									${user} <i class="fa-angle-down"></i> </span> </a>

							<ul class="dropdown-menu user-profile-menu list-unstyled">
								<li class="last">
									<a href="javascript:logout()"> <i class="fa-lock"></i> 安全退出
									</a>
								</li>
							</ul>
						</li>

					</ul>

					</nav>
					<div class="row">
						<div class="col-md-9">
							<div class="tocify-content">
								<div class="icon-collection">
									<section id="web-application">

									</section>
								</div>
							</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								${sapplydate}教室列表
							</h3>
						</div>
						<div class="form-group">
						<form name="form1"  id="form1" class="form-horizontal" action="ToclassroomList.action">
							<label class="col-sm-2 control-label">
								请选择日期，默认为当天
							</label>

							<div class="col-sm-10">
								<input name="applydate" id="applydate" class="Wdate"
									style="margin-top: 3px; height: 26px;" type="text"
									onClick=
	WdatePicker({minDate:'%y-%M-%d'}); onchange="toclassroomList();"  value="${sapplydate}">
	<input type="button" value="查看" onClick="toclassroomList();">
							</div>
							</form>
						</div>

						<div class="panel-body">
							<table class="table table-bordered table-striped" id="example-2">
								<thead>
									<tr>
										<th>
											ID
										</th>
										<th>
											教室名称
										</th>
										<th>
											校区
										</th>
										<th>
											占用情况
										</th>
										<th>
											操作
										</th>
									</tr>
								</thead>

								<tbody class="middle-align">
									<c:forEach items="${classroomList}" var="clr">
										<tr>
											<td>
												${clr.id}
											</td>
											<td>
												${clr.roomname}
											</td>
											<td>
												${clr.campus }
											</td>
											<td>
												<c:forEach items="${kebiaoList}" var="kebiao">
													<c:if test="${kebiao[0].classroom==clr.roomname}">
														<c:set var="tkflag" value="0"></c:set>
														<c:forEach items="${adjustlistbefore}" var="adjlb">
														
															<c:if test="${adjlb.classroom==clr.roomname and adjlb.starttimebefore==kebiao[0].starttime}">
																		<c:set var="tkflag" value="1"></c:set>
															</c:if>
														</c:forEach>
														<c:if test="${tkflag==0}">
														<font title="上课：${kebiao[0].classname}~${kebiao[0].subjectname}~${kebiao[0].teacher}"><c:out value="${kebiao[0].starttime}~${kebiao[0].endtime}"></c:out></font>	
														</c:if>			
									
									</c:if>


												</c:forEach>
												<c:forEach items="${adjustlistafter}" var="adjla">
															<c:if test="${adjla.classroom==clr.roomname}">
																		<font title="调课：${adjla.classname}~${adjla.subjectname}~${adjla.teachername}"><c:out value="${adjla.starttimeafter}~${adjla.endtimeafter}"></c:out></font>
															</c:if>
														</c:forEach>
												<c:forEach items="${applyclassroomList}" var="acrl" varStatus="status">
												<c:if test="${clr.roomname==acrl.roomname}">
												<c:choose>
												<c:when test="${acrl.approvestatus==1}">
												<font color="orange" title="申请中等待审批，原因：${acrl.applyreason }">${acrl.applystarttime}~${acrl.applyendtime}</font>
												</c:when>
												<c:when test="${acrl.approvestatus==2}">
												<font color="green" title="申请并通过审批，原因：${acrl.applyreason }">${acrl.applystarttime}~${acrl.applyendtime}</font>
												</c:when>
												<c:otherwise>
												
												</c:otherwise>
												</c:choose>
												
												</c:if>

												</c:forEach>
											</td>

											<td>
												
													<a
													href="ToClassroomApply.action?clrid=${clr.id }&roomname=${clr.roomname}&campus=${clr.campus}&applydate=${sapplydate}">申请</a>
											</td>

										</tr>
									</c:forEach>
								</tbody>


							</table>

						</div>
					</div>
					<!-- Main Footer -->
					<!-- Choose between footer styles: "footer-type-1" or "footer-type-2" -->
					<!-- Add class "sticky" to  always stick the footer to the end of page (if page contents is small) -->
					<!-- Or class "fixed" to  always fix the footer to the end of page -->
					<footer class="main-footer sticky footer-type-1">

					<div class="footer-inner">

						<!-- Add your copyright text here -->
						<div class="footer-text">
							&copy; 2015
							<strong>上海财经大学 国际教育学院</strong>

						</div>


						<!-- Go to Top Link, just add rel="go-top" to any link to add this functionality -->
						<div class="go-up">

							<a href="#" rel="go-top"> <i class="fa-angle-up"></i> </a>

						</div>

					</div>

					</footer>
				</div>

			</div>


			<div class="page-loading-overlay">
				<div class="loader-2"></div>
			</div>




			<!-- Bottom Scripts -->
			<script src="assets/js/bootstrap.min.js"></script>
			<script src="assets/js/TweenMax.min.js"></script>
			<script src="assets/js/resizeable.js"></script>
			<script src="assets/js/joinable.js"></script>
			<script src="assets/js/xenon-api.js"></script>
			<script src="assets/js/xenon-toggles.js"></script>


			<!-- Imported scripts on this page -->
			<script src="assets/js/xenon-widgets.js"></script>
			<script src="assets/js/devexpress-web-14.1/js/globalize.min.js"></script>
			<script src="assets/js/devexpress-web-14.1/js/dx.chartjs.js"></script>
			<script src="assets/js/toastr/toastr.min.js"></script>


			<!-- JavaScripts initializations and stuff -->
			<script src="assets/js/xenon-custom.js"></script>
			<input type="hidden" name="classid" id="classid" value="" />
		</form>
	</body>
	<script type="text/javascript">
	function toclassroomList()
	{
		document.forms[0].action="ToclassroomList.action"
		document.forms[0].submit();
	}
	function toRoleAdd() {
		document.forms[0].action = "ToRoleAdd.action";
		document.forms[0].submit();
	}
	function toClassAssistant(classid) {
		document.getElementById("classid").value = classid;
		document.forms[0].action = "ToAdjustClassAssistant.action";
		document.forms[0].submit();
	}
	function logout() {
		if (confirm("您确定要退出吗?")) {
			document.forms[0].action = "logoff.action";
			document.forms[0].submit();
		}
	}

</script>
</html>