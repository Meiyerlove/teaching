<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/web/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Xenon Boostrap Admin Panel" />
	<meta name="author" content=""/>
    <title>上海财经大学国际教育学院 - 教务管理系统</title>
	<script src="assets/js/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="flexigrid_my/css/flexigrid_gray.css">
	<link rel="stylesheet" type="text/css" href="flexigrid_my/jqModal/css/jqModal_gray.css">	
           
	<link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/xenon-core.css">
	<link rel="stylesheet" href="assets/css/xenon-forms.css">
	<link rel="stylesheet" href="assets/css/xenon-components.css">
	<link rel="stylesheet" href="assets/css/xenon-skins.css">
	<link rel="stylesheet" href="assets/css/custom.css">
    <script src="js/commonnew.js"></script> 
</head>
<body class="page-body">
<form>
	<div class="copyrights"></div>
	<div class="page-container"><!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->
			
		<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
		<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
		<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->
		<div class="sidebar-menu-inner" style="display:none;">
			
			<div class="sidebar-menu-inner" style="display:none;">	
				
				<header class="logo-env">
					
					<!-- logo -->
					<div class="logo">
						<a href="javascript:to('ToLogin.action');" class="logo-expanded">
							<img src="assets/images/logo3.png" width="160" alt="" />
						</a>
					</div>
					
					<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
					<div class="mobile-menu-toggle visible-xs">
						<a href="#" data-toggle="user-info-menu">
							<i class="fa-bell-o"></i>
							<span class="badge badge-success">7</span>
						</a>
						
						<a href="#" data-toggle="mobile-menu">
							<i class="fa-bars"></i>
						</a>
					</div>
						
				</header>
						
				
						
				<ul id="main-menu" class="main-menu">
					<!-- add class "multiple-expanded" to allow multiple submenus to open -->
					<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
					<li class="active opened active">
					    
					    
						
							<%--<i class="linecons-cog"></i>--%>
							<span class="title" style="color:white">${role.desc}</span>
						
						<ul>
						   <c:forEach items="${menuList}" var="right" varStatus="status">       
					          <li class="active" style="height:40px;">
								<a href="javascript:to('${right.righturl}');">
									<span class="title">${right.righttext}</span>
								</a>
							 </li>
					       </c:forEach>
						</ul>
					</li>
				</ul>
						
			</div>
			
		</div>
		
		<%@include file="common.jsp" %><div class="main-content">
					
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
						<a href="#" data-toggle="dropdown">
							<img src="assets/images/user-4.png" alt="user-image" class="img-circle img-inline userpic-32" width="28" />
							<span>
								${user}
								<i class="fa-angle-down"></i>
							</span>
						</a>
						
						<ul class="dropdown-menu user-profile-menu list-unstyled">
							<li class="last">
								<a href="javascript:logout()">
									<i class="fa-lock"></i>
									安全退出
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
								<div class="fontawesome-icon-list">
									<div class="fa-hover"><i class="fa fa-plus-square" onclick="toUserAdd()"></i> <span>增加用户</span></div>
								</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">用户数据管理</h3>
				</div>
				
				<%-- <div class="panel-body">
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
								<th class="no-sorting" width="20%">
									<input type="checkbox" class="cbr">
								</th>
								<th width="20%">ID</th>
								<th width="20%">用户名</th>
								<th width="20%">用户类型</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						
						<tbody class="middle-align">
						  <c:forEach items="${userList}" var="user" varStatus="status">
							<tr>
								<td>
									<input type="checkbox" class="cbr">
								</td>
								<td>${user.id}</td>
								<td>${user.user}</td>
								<c:if test="${user.userType==2}">
								<td>院长</td>
								</c:if>
								<c:if test="${user.userType==3}">
								<td>教务主管</td>
								</c:if>
								<c:if test="${user.userType==4}">
								<td>教务员</td>
								</c:if>
								<c:if test="${user.userType==5}">
								<td>学生主管</td>
								</c:if>
								<c:if test="${user.userType==6}">
								<td>辅导员</td>
								</c:if>
								<c:if test="${user.userType==7}">
								<td>老师</td>
								</c:if>
								<c:if test="${user.userType==8}">
								<td>学生</td>
								</c:if>
								<c:if test="${user.userType==9}">
								<td>办公室</td>
								</c:if>
								
								<td>
									<a href="javascript:toUserEdit('${user.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										修改 
									</a>
									<a href="javascript:deleteUser('${user.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										删除
									</a>
								</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
					
				</div> --%>
				<div class="panel-body" style="overflow:scroll;width:100%;" >
					 <table id="alluserid" style="display:none;"></table>		
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
					
						<a href="#" rel="go-top">
							<i class="fa-angle-up"></i>
						</a>
						
					</div>
					
				</div>
				
			</footer>
		</div>
		
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
	<input type="hidden" name="userid" id="userid" value=""/>
</form>
</body>
<script type="text/javascript">
function toUserAdd(){
				document.forms[0].action = "ToUserAdd.action";
				document.forms[0].submit();	
		}
function toUserEdit(userid){
                document.getElementById("userid").value = userid;
				document.forms[0].action = "ToUserEdit.action";
				document.forms[0].submit();	
		}
function deleteUser(userid){
         if (confirm("您确定要删除吗?")){
                document.getElementById("userid").value = userid;
				document.forms[0].action = "DeleteUser.action";
				document.forms[0].submit();	
		    }
		}
function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].submit();
			}	
		}
</script>
<script type="text/javascript" src="flexigrid_my/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="flexigrid_my/flexigrid.js"></script>
		<script type="text/javascript" src="flexigrid_my/jqModal/dimensions.js"></script>
		<script type="text/javascript" src="flexigrid_my/jqModal/jqDnR.js"></script>
		<script type="text/javascript" src="flexigrid_my/jqModal/jqModal.js"></script>
		<script type="text/javascript" src="flexigrid_my/alluserList.js"></script>
</html>