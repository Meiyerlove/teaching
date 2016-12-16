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
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
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
						
				
						
				<ul id="main-menu" class="main-menu" style="z-index:1000;">
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
								<td height="26" align="center" bgcolor="#d9d9d9">
									<span class="redfont" style="padding-top:5px;"><s:fielderror />
										<s:actionerror/>
										<s:actionmessage/>
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
			
			<div class="panel panel-default" style="display:block;" id="mainDiv">
				<div class="panel-heading">
					<h3 class="panel-title">延长录入时间申请列表</h3>
				</div>
				
				<div class="panel-body">
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
								
								<th>ID</th>
								<th>考试名称</th>
								<th width="10%;">考试科目</th>
								<th width="10%;">考试班级</th>
								<th>申请老师</th>
								<th>申请时间</th>
								<th>延长时间</th>
								<th width="10%;">申请原因</th>
								<th width="10%;">审批意见</th>
								<th>审批状态</th>
								<th>操作</th>
							</tr>
						</thead>
						
						<tbody class="middle-align">
						  <c:forEach items="${delayList}" var="delay" varStatus="status">
							<tr>
								<td>${delay.id}</td>
								<td>${delay.exam.title}</td>
								<td>${delay.exam.subjectname}</td>
								<td>${delay.exam.classname}</td>
								<td>${delay.username}</td>
								<td>${delay.applytime}</td>
								<td>${delay.updatedate}</td>
								<td>${delay.reason}</td>
								<td>${delay.advice}</td>
								<td>
								<c:if test="${delay.status == 0}">
								  等待教务/教务主管审批
								</c:if>
								<c:if test="${delay.status == 2}">
								  等待审批
								</c:if>
								<c:if test="${delay.status == 1}">
								  审批通过
								</c:if>
								</td>
								<td>
								<c:if test="${delay.status == 2}">
									<a href="javascript:switchDiv('${delay.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										同意
									</a>
								</c:if>
								</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
					
				</div>
			</div>
			<div class="panel panel-default" style="display:none;" id="addInfo">
						<div class="panel-heading">
							<h3 class="panel-title">审批意见</h3>							
						</div>
						<div class="form-group" style="margin-top:10px;">
							<label class="col-sm-2 control-label" style="padding-top:5px;color:#979898;">预计延长时间</label>
							<div class="col-sm-10">
								<input name="enteringupdatedate" id="enteringupdatedate" class="Wdate" style="margin-top:3px;height:26px;" type="text"  onClick="WdatePicker()">
							</div>
						</div>
						<div class="panel-body">							
								<div class="form-group">
									<label class="col-sm-2 control-label">审批意见</label>
									
									<div class="col-sm-10">
										<textarea class="form-control" id="content" name="content" style="height:300px;" placeholder="请填写审批意见..." maxlength="500"></textarea>
									</div>
								</div>
								<div style="height:20px;clear:both;"></div>
								<div class="form-group">
									<div class="col-sm-10">
									    <input type="button" class="form-control" style="margin-left:300px;width:80px;background:#e4393c;color:white;" value="关闭" onclick="closeDiv();">
										<input type="button" class="form-control" style="margin-left:600px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="保存" onclick="approveDelay();">
									</div>
								</div>
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
	<input type="hidden" name="delayid" id="delayid" value=""/>
</form>
</body>
<script type="text/javascript">
function approveDelay(){
				document.forms[0].action = "ApproveDelay.action";
				document.forms[0].submit();	
		}
function switchDiv(delayid){
                document.getElementById("delayid").value = delayid;
                $.post("GetUpdateTime.action",{delayid:delayid},
                	function(data){
                		$("#enteringupdatedate").val(data);
                	}
                );
				$("#mainDiv").css("display","none");
				$("#addInfo").css("display","block");	
		}
function closeDiv(){
				$("#mainDiv").css("display","block");
				$("#addInfo").css("display","none");	
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