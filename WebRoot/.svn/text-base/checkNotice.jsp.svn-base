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
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
 .table_id{width:50px;text-align:center}
 .table_name{width:100px;text-align:center}
 .table_title{width:150px;text-align:center}
 .table_content,.table_publishdate{width:200px;text-align:center}
 .table_check{width:103px;text-align:center}
 #table_caozuo{text-align:center}
</style>
</head>
<body class="page-body">
<form>
    <div class="copyrights"></div>
	<div class="page-container">
		<div class="sidebar-menu-inner" style="display:none;">
			
			<div class="sidebar-menu-inner">	
				
				<header class="logo-env">
					
					<!-- logo -->
					<div class="logo">
						<a href="javascript:to('ToLogin.action');" class="logo-expanded">
							<img src="assets/images/logo3.png" width="160" alt="" />
						</a>
					</div>
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
					          <li class="active" style="height:30px;">
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
			<div class="panel panel-default";>
				<div class="panel-heading">
					<h3 class="panel-title">通知数据</h3>
				</div>
				
				<div class="panel-body">
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
								<th >通知类型</th>
							</tr>
						</thead>
						
						<tbody class="middle-align">

				<!-- <tr onclick="displayDiv();"> -->
				   
					<td style="position: relative;cursor:pointer; min-height:200px;">
					<span onclick="displayDiv()">查看全部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
					<c:if test="${totaljwCount<10}">
				      <div style="position: absolute;width:14px; height:15px; background-color:#F00; border-radius:35px;left:170px;top:7px;">
                         <span style="height:15px; line-height:15px; display:block; color:#FFF; text-align:center;">
                            ${totaljwCount}</span>
                   	     </div>
                   	</c:if>
                   	<c:if test="${totaljwCount>=10}">
				      <div style="position: absolute;width:18px; height:18px; background-color:#F00; border-radius:35px;left:170px;top:7px;">
                         <span style="height:15px; line-height:18px; display:block; color:#FFF; text-align:center;">
                            ${totaljwCount}</span>
                   	     </div>
                   	</c:if>           
                   	        
							<span onclick="jiaowuDisplay()">查看教务通知 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
					<c:if test="${totalfdCount<10}">
			              <div style="position: absolute;width:15px; height:15px; background-color:#F00; border-radius:35px;left:290px;top:7px;">
                             <span style="height:15px; line-height:15px; display:block; color:#FFF; text-align:center;">
                            ${totalfdCount}</span>
                   	        </div>
                       </c:if>
					<c:if test="${totalfdCount>=10}">
			              <div style="position: absolute;width:18px; height:18px; background-color:#F00; border-radius:35px;left:290px;top:7px;">
                             <span style="height:15px; line-height:18px; display:block; color:#FFF; text-align:center;">
                            ${totalfdCount}</span>
                   	        </div>
                       </c:if>
						  <span onclick="assistantDisplay()">查看辅导员通知 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						  <c:if test="${tuser.userType==3 || tuser.userType==4}">
						      <span onclick="systemDisplay()">查看系统通知(${size}) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>	
								通知总数量(${totalCount})
						  </c:if>
						 <c:if test="${tuser.userType==6 ||tuser.userType==7||tuser.userType==8}">
						  <c:if test="${totallsCount<10}">
						     <div style="position: absolute;width:14px; height:15px; background-color:#F00; border-radius:35px;left:398px;top:7px;">
                             <span style="height:15px; line-height:15px; display:block; color:#FFF; text-align:center;">
                            ${totallsCount}</span>
                   	        </div>
						  </c:if>
						   <c:if test="${totallsCount>=10}">
						     <div style="position: absolute;width:18px; height:18px; background-color:#F00; border-radius:35px;left:398px;top:7px;">
                             <span style="height:15px; line-height:18px; display:block; color:#FFF; text-align:center;">
                            ${totallsCount}</span>
                   	        </div>
						  </c:if>
						  <span onclick="teacherDisplay()">查看老师通知 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						  <span onclick="systemDisplay()">查看系统通知(${size}) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>	
								通知总数量(${totalCount1})
							</c:if>	
						 <c:if test="${tuser.userType==5}">
						  <c:if test="${totallsCount<10}">
						     <div style="position: absolute;width:14px; height:15px; background-color:#F00; border-radius:35px;left:398px;top:7px;">
                             <span style="height:15px; line-height:15px; display:block; color:#FFF; text-align:center;">
                            ${totallsCount}</span>
                   	        </div>
						  </c:if>
						   <c:if test="${totallsCount>=10}">
						     <div style="position: absolute;width:18px; height:18px; background-color:#F00; border-radius:35px;left:398px;top:7px;">
                             <span style="height:15px; line-height:18px; display:block; color:#FFF; text-align:center;">
                            ${totallsCount}</span>
                   	        </div>
						  </c:if>
						  <span onclick="teacherDisplay()">查看老师通知 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
								通知总数量(${totalCount1})
							</c:if>	
						</td>
				     <!-- </tr> -->
						</tbody>
					</table>
				<div style="display:block;" id="hiddenDiv" >
				  <div style="display:block;" id="jiaowuDiv"><br/>
				 	<c:if test="${not empty noticelists}">
				      <h3 class="panel-title" style="color:black">教务通知:未读</h3>
				          <table class="gridtable" style="font-weight:bold">
							 <thead>
							      <tr>
								<th class="table_id">序号</th>
								<th class="table_name">发送人</th>
								<th class="table_title">通知标题</th>
								<th class="table_content">通知内容</th>
								<th class="table_publishdate">发布日期</th>
								<th class="table_check">操作</th>
							  </tr>
						     </thead>
								<c:forEach items="${noticelists}" var="notice" varStatus="status">
							  <tr class="tr_table">
								<td class="table_id">${status.count}</td>
								<td class="table_name">${notice.username}</td>
								<td class="table_title">${notice.title}</td>
								<td class="table_content" style="height:20px">${notice.content}</td>
								<td class="table_publishdate">${notice.publishdate}</td>
								<td id="table_caozuo">
								 <a href="javascript:jiaoNotice('${notice.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">具体查看</a>	           
								</td>
							</tr>
							</c:forEach>			
					    </table><br/>
					    </c:if>
                          <c:if test="${not empty noticelists1}">
			                <h3 class="panel-title" style="color:black">教务通知:已读</h3>
						 <table class="gridtable">
							 <thead>
							      <tr>
								<th class="table_id">序号</th>
								<th class="table_name">发送人</th>
								<th class="table_title">通知标题</th>
								<th class="table_content">通知内容</th>
								<th class="table_publishdate">发布日期</th>
								<th class="table_check">操作</th>
							  </tr>
						     </thead>
							  <c:forEach items="${noticelists1}" var="notices" varStatus="status">
							 <tr>
								<td class="table_id">${status.count}</td>
								<td class="table_name">${notices.username}</td>
								<td class="table_title">${notices.title}</td>
								<td class="table_content">${notices.content}</td>
								<td class="table_publishdate">${notices.publishdate}</td>
								<td id="table_caozuo">
								 <a href="javascript:_jiaoNotice('${notices.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">具体查看</a>	           
								</td>
							 </tr>
							</c:forEach>			
					   </table>
					  </c:if>
					  </div><br/>
				       <div style="display:block;" id="assistantDiv">
				        <c:if test="${not empty noticelistsfd}">
				          <h3 class="panel-title" style="color:black">辅导员通知:未读</h3>
				         <table class="gridtable" style="font-weight:bold">
							 <thead>
							  <tr>
								<th class="table_id">序号</th>
								<th class="table_name">发送人</th>
								<th class="table_title">通知标题</th>
								<th class="table_content">通知内容</th>
								<th class="table_publishdate">发布日期</th>
								<th class="table_check">操作</th>
							  </tr>
						     </thead>
								 <c:forEach items="${noticelistsfd}" var="notices" varStatus="status">
							<tr>
								<td class="table_id">${status.count}</td>
								<td class="table_name">${notices.username}</td>
								<td class="table_title">${notices.title}</td>
								<td class="table_content">${notices.content}</td>
								<td class="table_publishdate">${notices.publishdate}</td>
								<td id="table_caozuo">
								 <a href="javascript:assistantNotice('${notices.id}');" class="btn btn-secondary btn-sm btn-icon icon-left" style="text-align:center">具体查看</a>	           
								</td>
							 </tr>
							</c:forEach>			
							 </table><br>
							 </c:if>
							 <c:if test="${not empty noticelistsfd1}">
							   <h3 class="panel-title" style="color:black">辅导员通知:已读</h3>
							 <table class="gridtable">
							 <thead>
							      <tr>
								<th class="table_id">序号</th>
								<th class="table_name">发送人</th>
								<th class="table_title">通知标题</th>
								<th class="table_content">通知内容</th>
								<th class="table_publishdate">发布日期</th>
								<th class="table_check">操作</th>
							  </tr>
						     </thead>
								  <c:forEach items="${noticelistsfd1}" var="noticesfd1" varStatus="status">
							 <tr>
								<td class="table_id">${status.count}</td>
								<td class="table_name">${noticesfd1.username}</td>
								<td class="table_title">${noticesfd1.title}</td>
								<td class="table_content">${noticesfd1.content}</td>
								<td class="table_publishdate">${noticesfd1.publishdate}</td>
								<td id="table_caozuo">
						   <a href="javascript:_assistantNotice('${noticesfd1.id}');" class="btn btn-secondary btn-sm btn-icon icon-left" style="text-align:center">具体查看</a>	           
								</td>
							</tr>
							</c:forEach>			
							 </table>
					    </c:if>
						</div>
						<br/>
						
				       <c:if test="${tuser.userType==5||tuser.userType==6||tuser.userType==7 ||tuser.userType==8}">
				          <div style="display:block;" id="teacherDiv">
				          <c:if test="${not empty noticeliststea }">
				         <h3 class="panel-title" style="color:black">老师通知:未读</h3>
				 	     <table class="gridtable" style="font-weight:bold">
							 <thead>
							   <tr>
								<th class="table_id">序号</th>
								<th class="table_name">发送人</th>
								<th class="table_title">通知标题</th>
								<th class="table_content">通知内容</th>
								<th class="table_publishdate">发布日期</th>
								<th class="table_check">操作</th>
							  </tr>
						     </thead>
								 <c:forEach items="${noticeliststea}" var="noticesea" varStatus="status" >
							<tr>
								<td class="table_id">${status.count}</td>
								<td class="table_name">${noticesea.username}</td>
								<td class="table_title">${noticesea.title}</td>
								<td class="table_content">${noticesea.content}</td>
								<td class="table_publishdate">${noticesea.publishdate}</td>
								<td id="table_caozuo">
								 <a href="javascript:teacherNotice('${noticesea.id}');" class="btn btn-secondary btn-sm btn-icon icon-left" style="text-align:center">具体查看</a>	           
								</td>
							   </tr>
							 </c:forEach>		
					     </table><br>
					     </c:if> 
					      <c:if test="${not empty noticelists_tea }">
					      <h3 class="panel-title" style="color:black">老师通知:已读</h3>
				 	     <table class="gridtable">
							 <thead>
							      <tr>
								<th class="table_id">ID</th>
								<th class="table_name">发送人</th>
								<th class="table_title">通知标题</th>
								<th class="table_content">通知内容</th>
								<th class="table_publishdate">发布日期</th>
								<th class="table_check">操作</th>
							  </tr>
						     </thead>
								 <c:forEach items="${noticelists_tea}" var="notice_sea" varStatus="status" >
							  <tr>
								<td class="table_id">${status.count}</td>
								<td class="table_name">${notice_sea.username}</td>
								<td class="table_title">${notice_sea.title}</td>
								<td class="table_content">${notice_sea.content}</td>
								<td class="table_publishdate">${notice_sea.publishdate}</td>
								<td id="table_caozuo">
								 <a href="javascript:_teacherNotice('${notice_sea.id}');" class="btn btn-secondary btn-sm btn-icon icon-left" style="text-align:center">具体查看</a>	           
								</td>
							</tr>
							</c:forEach>		
					 </table>
					 </c:if> 
				 	 </div>
				</c:if> 
				   <c:if test="${tuser.userType!=5}">
				    <div style="display:block;" id="systemDiv"><br>
				  <c:if test="${not empty notice_list }">
				      <h3 class="panel-title" style="color:black">系统通知:</h3>
				 	     <table class="gridtable">
							 <thead>
							      <tr>
							    <th style="text-align:center">序号</th>
								<th style="text-align:center">发送人</th>
								<th style="text-align:center">通知标题</th>
								 <c:if test="${tuser.userType!=3 && tuser.userType!=8}"><th style="text-align:center">通知状态</th></c:if>
								<th style="text-align:center">发布日期</th>
							  </tr>
						     </thead>

						      <c:forEach items="${notice_list}" var="notice" varStatus="status">
							<tr>
								<td class="table_id">${status.count}</td>
								<td class="table_name">${notice.title}</td>							
								<td class="table_">${notice.content}</td>
								 <c:if test="${tuser.userType!=3 && tuser.userType!=8}">
								<td class="">
								    <c:if test="${notice.status==1}">
								        教导主管同意
								    </c:if>
								    <c:if test="${notice.status==2}">
								        教导主管不同意
								    </c:if>
								    <c:if test="${notice.status==3}">
								        院长同意
								    </c:if>
								    <c:if test="${notice.status==4}">
								        院长不同意
								    </c:if>
								</td>
								</c:if>						
								<td class="table_publishdate">${notice.publishdate}</td>							
							</c:forEach>	     			 
					  </table> 
					 </c:if>
			  </div>
			  </c:if>
			  </div>
			  <div id="blank" style="height:500px;display:block;"></div>
			<footer class="main-footer sticky footer-type-1">
				
				<div class="footer-inner">
				
					<!-- Add your copyright text here -->
					<div class="footer-text">
						&copy; 2015 
						<strong>上海财经大学 国际教育学院</strong> 	
					</div>
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
  <input type="hidden" name="roleid" id="roleid" value=""/>
</form>
</body>
<script type="text/javascript">
function jiaoNotice(id){
 	$("#roleid").val(id);
   document.forms[0].action="NoticeDetails.action";
   document.forms[0].submit();
}

function _jiaoNotice(id){
  $("#roleid").val(id);
  document.forms[0].action="NoticeDetails.action";
  document.forms[0].submit();
}
function assistantNotice(id){
  $("#roleid").val(id);
  document.forms[0].action="NoticeDetails.action";
  document.forms[0].submit();
 
}
function _assistantNotice(id){
  $("#roleid").val(id);
  document.forms[0].action="NoticeDetails.action";
  document.forms[0].submit();
}
function teacherNotice(id){
  $("#roleid").val(id);
  document.forms[0].action="NoticeDetails.action";
  document.forms[0].submit();
}
function _teacherNotice(id){
  $("#roleid").val(id);
  document.forms[0].action="NoticeDetails.action";
  document.forms[0].submit();
}

function toNoticeAdd(){
				document.forms[0].action = "ToNoticeAdd.action";
				document.forms[0].submit();	
		}
function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].submit();
			}	
		}
function displayDiv(){
	/* var param=$("#hiddenDiv").css("display");
	alert(param);
	if(param=="none"){
		$("#hiddenDiv").fadeIn(1000);
	}else{
		$("#hiddenDiv").fadeOut(1000);
	} */
	//$("#hiddenDiv").slideToggle("slow");
   $("#jiaowuDiv").show();
   $("#assistantDiv").show();
   $("#teacherDiv").show();
   $("#systemDiv").show();
   $("#blank").show();
}
function jiaowuDisplay(){
/* <div id="blank" style="height:400px;"></div> */
    $("#jiaowuDiv").show();
   $("#assistantDiv").hide();
   $("#teacherDiv").hide();
   $("#systemDiv").hide();
   $("#blank").show();
  // $("#hiddenDiv").slideToggle("slow");
}
function assistantDisplay(){
   $("#jiaowuDiv").hide();
   $("#assistantDiv").show();
   $("#teacherDiv").hide();
   $("#systemDiv").hide();
   $("#blank").show();
}
function teacherDisplay(){
   $("#jiaowuDiv").hide();
   $("#assistantDiv").hide();
   $("#teacherDiv").show();
   $("#systemDiv").hide();
   $("#blank").show();
}
function systemDisplay(){
 
   $("#jiaowuDiv").hide();
   $("#assistantDiv").hide();
   $("#teacherDiv").hide();
   $("#systemDiv").show();
   $("#blank").show();
}
		
</script>
</html>


