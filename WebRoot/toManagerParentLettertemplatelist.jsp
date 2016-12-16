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
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body class="page-body"  onload="cutStr(5)">
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
								
							</section>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-9">	
					<div class="tocify-content">
						<div class="icon-collection">
							<section id="web-application">
								<div class="fontawesome-icon-list">
									<div class="fa-hover"><i class="fa fa-plus-square" onclick="addParentLetterTemplate()"></i> <span>增加家长信息模板</span></div>
								</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">模板列表</h3>
				</div>
                <div class="panel-body" >
					<table class="table table-bordered table-striped" id="example-2">
					<thead>
							<tr>
								<th>姓名</th>
								<th>模板主题题</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
						</thead>			
						<tbody class="middle-align">
						   <c:forEach items="${lettertemplatelist}" var="lettertemplate" varStatus="status">
							<tr>
								<td>${lettertemplate.name}</td>
								<td>${lettertemplate.title}<b style="color:#979898;font-weight:bold;font-size:10px;">${lettertemplate.content}</b>&nbsp;</td>
								<td>${lettertemplate.createdate}</td>
								<td>
	      
	                             <a href="javascript:toLetterTemplatelook('${lettertemplate.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">查看</a>
	                             <a href="javascript:toLetterTemplateDelete('${lettertemplate.id}','1');" class="btn btn-secondary btn-sm btn-icon icon-left">删除</a>
								</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
					
				</div>
			</div>
			 <div style="min-height:390px"></div> 
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
    <input type="hidden" name="lettertemplateid" id="lettertemplateid"/>
    <input type="hidden" name="deleteid" id="deleteid"/>
</form>
</body>
<script type="text/javascript">
   window.onload=function(){
	 var con= document.getElementsByTagName('b');
	  for(var i=0;i<con.length;i++){
		  var str= document.getElementsByTagName('b')[i].innerHTML;
		   str = str.replace(/<\/?[^>]*>/g,'');
           str = str.replace(/[ | ]*\n/g,'\n'); 
           str = str.replace(/\n[\s| | ]*\r/g,'\n');
           str=str.replace(/ /ig,''); 
           str=str.substring(0,40)+'......';
		   con[i].innerHTML="--"+str;
	  }
   }

function addParentLetterTemplate(){
		 window.location.href="addparentlettertemplate.jsp";
		}
function toLetterTemplatelook(id){
       $("#lettertemplateid").val(id);
       document.forms[0].action = "ToLetterTemplatelook.action";
	   document.forms[0].submit();   
}
function toLetterTemplateDelete(id,deletes){
     $("#lettertemplateid").val(id);
      $("#deleteid").val(deletes);
     if(confirm("是确定删除吗?")){
       document.forms[0].action = "ToLetterTemplatelook.action";
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