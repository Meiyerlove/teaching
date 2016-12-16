<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
</head>
<body class="page-body">
<!--  <form enctype="multipart/form-data" method="post">-->
	<div class="copyrights"></div>
	<div class="page-container"><!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->
			
		<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
		<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
		<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->
		<div class="sidebar-menu-inner" style="display:none;">
			
			<div class="sidebar-menu-inner" style="position:relative;">	
				
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
					<!-- add class "multiple-expanded"  to allow multiple submenus to open -->
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
		
		<%@include file="common2.jsp" %><div class="main-content">
					
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
								<td height="26" align="center" bgcolor="#d9d9d9">
									<span class="redfont" style="padding-top:5px;"><s:fielderror />
										<s:actionerror />
										<s:actionmessage />
									</span>
								</td>
							</tr>
						</table>
					</div>
			</s:if>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">考试安排（查看）</h3>
				</div>
				<div class="panel-body" style="overflow: scroll;">
					     <table id="loadingData" style="display:none;"></table>						
				</div>
			</div>
			<!-- Main Footer -->
			<!-- Choose between footer styles: "footer-type-1" or "footer-type-2" -->
			<!-- Add class "sticky" to  always stick the footer to the end of page (if page contents is small) -->
			<!-- Or class "fixed" to  always fix the footer to the end of page -->
			<div style="height:200px;"></div>
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
	<input type="hidden" name="examid" id="examid" value=""/>
	<input type="hidden" name="sort" value="${sort}"/>
	<input type="hidden" name="classid" id="classid" value=""/>
</body>
<script type="text/javascript"><%--
function toExamAdd(){
				document.forms[0].action = "ToExamAdd.action";
				document.forms[0].submit();	
		}

function sort_subject(){
				document.forms[0].action = "LookExamList.action";
				document.forms[0].submit();	
		}

function changeclass(){
				var classid=$("#selectclassid").val();
				if(classid==0){
					alert("请选择班级");
					return;
				}
				$("#classid").val(classid);
				document.forms[0].action = "ToExamListByClass.action";
				document.forms[0].submit();	
		}
		
function deleteStudent(studentid){
         if (confirm("您确定要删除吗?")){
                document.getElementById("studentid").value = studentid;
				document.forms[0].action = "DeleteStudent.action";
				document.forms[0].submit();	
		    }
		}
		
function toExamEntering(examid){
				$.post("CheckModifityStatus.action",{examid:examid},
					function(data){
						if(data=="yes"){
			                document.getElementById("examid").value = examid;
							document.forms[0].action = "ToExamEntering.action";
							document.forms[0].submit();	
						}else{
							alert("日期已过，不可修改");
							return;
						}
					}
				);
		}
		
function importStudent(){
				document.forms[0].action = "ImportStudent.action";
				document.forms[0].submit();	
		}
		
function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].submit();
			}	
		}
--%>
function logout(){
	if (confirm("您确定要退出吗?")){
		location = "logoff.action";
	}	
}

</script>
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="flexigrid_my/jquery-1.3.2.min.js"></script>
	<script type="text/javascript" src="flexigrid_my/flexigrid.js"></script>
	<script type="text/javascript" src="flexigrid_my/jqModal/dimensions.js"></script>
	<script type="text/javascript" src="flexigrid_my/jqModal/jqDnR.js"></script>
	<script type="text/javascript" src="flexigrid_my/jqModal/jqModal.js"></script>
	<c:if test="${tuser.userType==6}">
	<script type="text/javascript" src="flexigrid_my/examListFudaoyuan.js"></script>
	</c:if>
	<c:if test="${tuser.userType!=6}">
	<script type="text/javascript" src="flexigrid_my/examList.js"></script>
	</c:if>
</html>