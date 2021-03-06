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

	       
	<link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/xenon-core.css">
	<link rel="stylesheet" href="assets/css/xenon-forms.css">
	<link rel="stylesheet" href="assets/css/xenon-components.css">
	<link rel="stylesheet" href="assets/css/xenon-skins.css">
	<link rel="stylesheet" href="assets/css/custom.css">

    <script src="js/commonnew.js"></script>
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	
  <style type="text/css">
 	.blurry{
 	  filter:alpha(opacity=50);  
      -moz-opacity:0.5;  
      -khtml-opacity: 0.5;  
      opacity: 0.5;
 	}
 	</style>
 <script type="text/javascript">
  function openCommentDiv(id,param){
	    document.getElementById('commentdiv').style.display="block";
	    $("#sty").addClass("blurry");
	    $("#param").val(id);
	    $("#param1").val(param)
	 }	
	  function closeCommentDiv(){
	    document.getElementById('commentdiv').style.display="none";
	    $("#sty").removeClass("blurry");
	 }
 
 
 </script>
</head>
<body class="page-body">
<form>
	<div class="copyrights"></div>
	<div class="page-container">
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
								${tuser.user}
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
								
							</section>
						</div>
					</div>
				</div>
			</div>
			 <c:if test="${tuser.userType==3||tuser.userType==4||tuser.userType==7}">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">系统通知列表</h3>
				</div>
				
				<div class="panel-body" >
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
								<th>ID</th>
								<th>上课班级</th>
								<th>课程名称</th>
								<th>上课老师</th>
								<th>原日期</th>
								<th>原开始时间</th>
								<th>原结束时间</th>
								<th>调整后日期</th>
								<th>调整后教室</th>
								<th>调整后开始时间</th>
								<th>调整后结束时间</th>
								<th>调课原因</th>	
							</tr>
						</thead>
						
						<tbody class="middle-align">
						  <c:forEach items="${adjustList}" var="adjust" varStatus="status">
							<tr>
								<td>${adjust.id}</td>
								<td>${adjust.classname}</td>
								<td>${adjust.subjectname}</td>
								<td>${adjust.teachername}</td>
								<td>${adjust.datebefore}</td>
								<td>${adjust.starttimebefore}</td>
								<td>${adjust.endtimebefore}</td>
								<td>${adjust.dateafter}</td>
								<td>${adjust.newlcassroom}</td>
								<td>${adjust.starttimeafter}</td>
								<td>${adjust.endtimeafter}</td>
								<td>${adjust.reason}</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
					
				</div>
			</div>
			 </c:if> 
			<c:if test="${tuser.userType==6||tuser.userType==8}">
			<div class="panel panel-default" id="sty">
				<div class="panel-heading">
					<h3 class="panel-title">系统通知列表</h3>
				</div>
				
				<div class="panel-body" >
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
								<th>ID</th>
								<th>上课班级</th>
								<th>课程名称</th>
								<th>上课老师</th>
								<th>原日期</th>
								<th>原开始时间</th>
								<th>原结束时间</th>
								<th>调整后日期</th>
								<th>调整后教室</th>
								<th>调整后开始时间</th>
								<th>调整后结束时间</th>	
							</tr>
						</thead>
						
						<tbody class="middle-align">
						  <c:forEach items="${adjustList}" var="adjust" varStatus="status">
							<tr>
								<td>${adjust.id}</td>
								<td>${adjust.classname}</td>
								<td>${adjust.subjectname}</td>
								<td>${adjust.teachername}</td>
								<td>${adjust.datebefore}</td>
								<td>${adjust.starttimebefore}</td>
								<td>${adjust.endtimebefore}</td>
								<td>${adjust.dateafter}</td>
								<td>${adjust.newlcassroom}</td>
								<td>${adjust.starttimeafter}</td>
								<td>${adjust.endtimeafter}</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
					
				</div>
			</div>
			</c:if> 
			
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
	<input type="hidden" name="adjustid" id="adjustid" value=""/>
</form>
</body>
<script type="text/javascript">
/* function approveAdjust(adjustid){
                document.getElementById("adjustid").value = adjustid;
				document.forms[0].action = "ApproveAdjust.action";
				document.forms[0].submit();	
		} */
function approveAdjust(){
                 var content=$("#content").val();
                 if(null==content || content==""){
                    alert("请你填写审批理由!");
                    return;
                 }
                //document.getElementById("adjustid").value = adjustid;
				document.forms[0].action = "ApproveAdjust.action";
				document.forms[0].submit();	
		}
		
/* function rejectAdjust(adjustid){
                document.getElementById("adjustid").value = adjustid;
				document.forms[0].action = "RejectAdjust.action";
				document.forms[0].submit();	
		} */
		
		
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
</html>