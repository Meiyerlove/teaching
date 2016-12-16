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
                                                             学生奖励记录
					</h3>
					<a href="javascript:toRewardAdd();" class="btn btn-secondary btn-sm btn-icon icon-left">
									           增加奖励
					</a>
				</div>
				<div class="panel-body">
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
										<th>
											学号
										</th>
										<th>
											名字
										</th>
										<th>
											获得时间
										</th>
										<th>
											奖励名称
										</th>
										<th>
											奖励原由
										</th>
										<th>
											操作
										</th>
									</tr>
						</thead>
						
						<tbody class="middle-align">
						<c:forEach items="${rewardList}" var="reward" varStatus="status">
							<tr>
								<td>${reward.sid}</td>
								<td>${reward.name}</td>
								<td>${reward.rdate}</td>
								<td>
								   ${reward.title}
								</td>
								<td>
								   ${reward.reason}
								</td>
								<td>
								    <a href="javascript:toRewardEdit('${reward.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
									           修改 
									</a>
									<a href="javascript:deleteReward('${reward.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										删除
									</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
				</div>
				
				<div><table><tr><td width=150>请选择要导入的文件:</td><td width=150><input type="file" name="upload"></td><td width=150>(文件格式为*.xls)</td><td width=150><input type="button" name="button1" value="奖励数据导入" onclick="importReward();"></td></tr></table></div>
				
				<div class="form-group-separator"></div>
				
				<div class="panel-heading">
					<h3 class="panel-title">
                                                             学生惩罚记录
					</h3>
					<a href="javascript:toPunishAdd();" class="btn btn-secondary btn-sm btn-icon icon-left">
									           增加处分
					</a>
				</div>
				<div class="panel-body">
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
										<th>
											学号
										</th>
										<th>
											名字
										</th>
										<th>
											处分时间
										</th>
										<th>
											处分名称
										</th>
										<th>
											处分原由
										</th>
										<th>
										    
											是否撤销
										</th>
										<th>
											撤销时间
										</th>
										<th width="25%">
											操作
										</th>
									</tr>
						</thead>
						
						<tbody class="middle-align">
						<c:forEach items="${punishList}" var="punish" varStatus="status">
							<tr>
								<td>${punish.sid}</td>
								<td>${punish.name}</td>
								<td>${punish.pdate}</td>
								<td>
								   ${punish.title}
								</td>
								<td>
								   ${punish.reason}
								</td>
								<td>
								   <c:if test="${punish.iscancel}">
								     已撤销
								   </c:if>
								    <c:if test="${not punish.iscancel}">
								     未撤销
								   </c:if>
								</td>
								<td>
								   ${punish.canceldate}
								</td>
								<td>
								    <a href="javascript:toPunishEdit('${punish.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
									           修改 
									</a>
									<a href="javascript:deletePunish('${punish.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										删除
									</a>
									<a href="javascript:cancelPunish('${punish.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										撤销处分
									</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					
				</div>
				<div><table><tr><td width=150>请选择要导入的文件:</td><td width=150><input type="file" name="upload1"></td><td width=150>(文件格式为*.xls)</td><td width=150><input type="button" name="button1" value="处分数据导入" onclick="importPunish();"></td></tr></table></div>
								
								<div class="form-group">
									<div class="col-sm-10">
									
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
	<input type="hidden" name="punishid" id="punishid" value=""/>
	<input type="hidden" name="rewardid" id="rewardid" value=""/>
	<input type="hidden" name="examid" id="examid" value="${exam.id}"/>
	<input type="hidden" name="sid" id="sid" value="${sid}"/>
</form>
</body>
<script type="text/javascript">	
function toRewardAdd(){
				document.forms[0].action = "ToRewardAdd.action";
				document.forms[0].submit();	
		}
function toRewardEdit(rewardid){
                document.getElementById('rewardid').value = rewardid;
				document.forms[0].action = "ToRewardEdit.action";
				document.forms[0].submit();	
		}
function deleteReward(rewardid){
        if (confirm("您确定要删除吗?")){
                document.getElementById('rewardid').value = rewardid;
				document.forms[0].action = "DeleteReward.action";
				document.forms[0].submit();	
				}
		}
		
function toPunishAdd(){
				document.forms[0].action = "ToPunishAdd.action";
				document.forms[0].submit();	
		}
function toPunishEdit(punishid){
                document.getElementById('punishid').value = punishid;
				document.forms[0].action = "ToPunishEdit.action";
				document.forms[0].submit();	
		}
		
function toExamListTea(){
				document.forms[0].action = "ToExamListTea.action";
				document.forms[0].submit();	
		}
function deletePunish(punishid){
        if (confirm("您确定要删除吗?")){
                document.getElementById('punishid').value = punishid;
				document.forms[0].action = "DeletePunish.action";
				document.forms[0].submit();	
				}
		}
function cancelPunish(punishid){
        if (confirm("您确定要撤销此处分吗?")){
                document.getElementById('punishid').value = punishid;
				document.forms[0].action = "CancelPunish.action";
				document.forms[0].submit();	
				}
		}
		
function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].submit();
			}	
		}
function importReward(){
				document.forms[0].action = "ImportReward.action";
				document.forms[0].submit();	
		}
function importPunish(){
				document.forms[0].action = "ImportPunish.action";
				document.forms[0].submit();	
		}
</script>
</html>