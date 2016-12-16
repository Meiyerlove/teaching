<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*,org.yeeku.model.*;" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="/web/taglibs.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
</head>
<body class="page-body">
<form enctype="multipart/form-data" method="post">
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
			
			<s:if test="hasActionErrors()||hasActionMessages()">
					<div id="div-error" style="vertical-align:middle;padding-top:5px;">
						<table width="100%" border="0" cellpadding="0" class="table-a">
							<tr>
								<th>
									提示信息
								</th>
							</tr>
							<tr>
								<td height="26" align="center" bgcolor="#d9d9d9">mp
									<span class="redfont" style="padding-top:5px;">
										
										
									</span>
								</td>
							</tr>
						</table>
					</div>
			</s:if>
			
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
					           考试名称:${exam.title }&nbsp;&nbsp;&nbsp;
					           考试类型:<c:if test="${exam.examtype == 1}">
									  正考
									 </c:if>
									 <c:if test="${exam.examtype == 2}">
									  补做
									 </c:if>
									 <c:if test="${exam.examtype == 3}">
									  补考
									 </c:if>
									 <c:if test="${exam.examtype == 4}">
									  重修
									 </c:if>
									 <c:if test="${exam.examtype == 5}">
									  重修补做
									 </c:if>
									 <c:if test="${exam.examtype == 6}">
									  毕前
									 </c:if>
									 <c:if test="${exam.examtype == 7}">
									  毕前补做
									 </c:if>
									 <c:if test="${exam.examtype == 8}">
									  其他
									 </c:if>&nbsp;&nbsp;&nbsp;
					           阶段考试:<c:if test="${exam.phaseid == 0}">
									  无
									 </c:if>
									 <c:if test="${exam.phaseid == 1}">
									 Assessment1
									 </c:if>
									 <c:if test="${exam.phaseid == 2}">
									 Assessment2
									 </c:if>
									 <c:if test="${exam.phaseid == 3}">
									 Assessment3
									 </c:if>
									 <c:if test="${exam.phaseid == 4}">
									 Assessment4
									 </c:if>
									 <c:if test="${exam.phaseid == 5}">
									 Assessment5
									 </c:if>
									 <c:if test="${exam.phaseid == 6}">
									 Assessment6
									 </c:if>&nbsp;&nbsp;&nbsp;
					           
					           
					           分数类型:<c:if test="${exam.scoretype == 1}">
									  百分制
									 </c:if>
									 <c:if test="${exam.scoretype == 2}">
									  非百分制
									 </c:if>
									 <c:if test="${exam.scoretype == 3}">
									  记分单元
									 </c:if>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					           
					           
					           考试科目:${exam.subjectname}
					</h3>
				</div>
				
				<div class="panel-body">
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
								<th>学生名字</th>
								<th>考试班级</th>
								<!--<th>正考</th>
								<th>补做</th>
								<th>补考</th> 
								<th>重修</th> 
								<th>重修补做</th> 
								<th>毕前</th> 
								<th>毕前补做</th>  
								<th>其他</th>
										-->
								<c:forEach items="${indexList}" var="ind" varStatus="status">
											<c:if test="${ind == 1}">
									  <th>正考</th>
									 </c:if>
											<c:if test="${ind == 2}">
									  <th>补做</th>
									 </c:if>
											<c:if test="${ind == 3}">
									 <th>补考</th> 
									 </c:if>
											<c:if test="${ind == 4}">
									  <th>重修</th> 
									 </c:if>
											<c:if test="${ind == 5}">
									  <th>重修补做</th> 
									 </c:if>
											<c:if test="${ind == 6}">
									  <th>毕前</th> 
									 </c:if>
											<c:if test="${ind == 7}">
									 <th>毕前补做</th>  
									 </c:if>
											<c:if test="${ind == 8}">
									  <th>其他</th>
									 </c:if>
										</c:forEach>
								</tr>
						</thead>
						
						<tbody class="middle-align">
						  <c:forEach items="${studentListScore}" var="student" varStatus="status">
							<tr>
								<td>${student.name}</td>
								<td>${student.classname}</td>
								<!--<td>${student.score.exam1}</td>
								<td>${student.score.exam2}</td>
								<td>${student.score.exam3}</td>
								<td>${student.score.exam4}</td>
								<td>${student.score.exam5}</td>
								<td>${student.score.exam6}</td>
								<td>${student.score.exam7}</td>
								<td>${student.score.exam8}</td>
								-->
								<c:forEach items="${indexList}" var="ind" varStatus="status">
									<c:if test="${ind == 1}">
									 <td>
									      ${student.score.exam1}
									  </td>
									 </c:if>
									<c:if test="${ind == 2}">
									  <td>
									    ${student.score.exam2}
									  </td>
									 </c:if>
											<c:if test="${ind == 3}">
											<td>
									    ${student.score.exam3}
									  </td>
									 </c:if>
											<c:if test="${ind == 4}">
									  <td>
									     ${student.score.exam4}
									  
									  </td>
									 </c:if>
											<c:if test="${ind == 5}">
									  <td>
									     ${student.score.exam5}
									  </td>
									 </c:if>
											<c:if test="${ind == 6}">
									  <td>
									      ${student.score.exam6}
									  
									  </td>
									 </c:if>
											<c:if test="${ind == 7}">
									 <td>
									      ${student.score.exam7}
									 
									  </td>
									 </c:if>
											<c:if test="${ind == 8}">
									  <td>
									      ${student.score.exam8}
									  </td>
									 </c:if>		
										</c:forEach>
	
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
					
				</div>
				
				<div class="form-group-separator"></div>
				
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
	<input type="hidden" name="studentid" id="studentid" value=""/>
	<input type="hidden" name="examid" id="examid" value="${exam.id}"/>
	<input type="hidden" name="sid" id="sid" value="${sid}"/>
</form>
</body>
<script type="text/javascript">
function doScoreInput(){
                alert('成绩保存成功');
				document.forms[0].action = "DoScoreInput.action";
				document.forms[0].submit();	
		}
		
function toExamListTea(){
				document.forms[0].action = "ToExamListTea.action";
				document.forms[0].submit();	
		}
		
function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].submit();
			}	
		}
</script>
</html>