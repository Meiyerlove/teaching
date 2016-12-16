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
	<meta name="author" content="" />
	
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
				<div class="col-sm-12">
					
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">课程增加页面</h3>
							
						</div>
						<div class="panel-body">
							
							<form role="form" class="form-horizontal">
								<div class="form-group">
									<label class="col-sm-2 control-label"  >年级</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="grade" name="grade">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >班级</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="classid" id="classid">
										    <option value="">...</option>
										    <c:forEach items="${classList}" var="cla" varStatus="status">       
											<option value="${cla.id}">${cla.name}</option>
											</c:forEach>
											
										</select>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >课程</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="subjectid" id="subjectid">
										    <option value="">...</option>
										    <c:forEach items="${subjectList}" var="subject" varStatus="status">       
											<option value="${subject.id}">${subject.name}</option>
											</c:forEach>
											
										</select>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >星期</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="weekday" id="weekday">
										    <option value="">...</option>
										    <option value="Monday">Monday</option>
											<option value="Tuesday">Tuesday</option>
											<option value="Wednesday">Wednesday</option>
											<option value="Thursday">Thursday</option>
											<option value="Friday">Friday</option>
										</select>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<!-- <div class="form-group">
									<label class="col-sm-2 control-label">上课时间</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="starttime" name="starttime">
									</div>
								</div> -->
								<div class="form-group">
									<label class="col-sm-2 control-label"  >上课时间</label>
									
									<div class="col-sm-10">
										<!-- <input type="text" id="starttime" class="form-control" name="starttime"
										    onfocus="WdatePicker({dateFmt:'HH:mm',minDate:'00:00',maxDate:'23:00'})" 
										     value=''/> -->
										   <select id="starttime" class="form-control" name="starttime">
										       <option value="">--请选择--</option>
										       <option value="8:00">8:00</option>
										       <option value="10:00">10:00</option>
										       <option value="13:20">13:20</option>
										       <option value="15:10">15:10</option>
										       <option value="18:00">18:00</option>
										   </select>
									</div>
								</div>
								<div class="form-group-separator"></div>
								
								<div class="form-group-separator"></div>
								
								<!-- <div class="form-group">
									<label class="col-sm-2 control-label"  >下课时间</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="endtime" name="endtime">
									</div>
								</div> -->
								<div class="form-group">
									<label class="col-sm-2 control-label"  >下课时间</label>
									
									<div class="col-sm-10">
										<input type="text" id="endtime" class="form-control" name="endtime"
										    onfocus="WdatePicker({dateFmt:'HH:mm',minDate:'00:00',maxDate:'23:00'})" 
										     value=''/>
									</div>
								</div>
								
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">任课老师</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="teacherid" id="teacherid">
										    <option value="">...</option>
										    <c:forEach items="${teacherList}" var="teacher" varStatus="status">       
											<option value="${teacher.id}">${teacher.name}</option>
											</c:forEach>
											
										</select>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">辅导员</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="assistantid" id="assistantid">
										    <option value="">...</option>
										    <c:forEach items="${assistantList}" var="assistant" varStatus="status">       
											<option value="${assistant.id}">${assistant.name}</option>
											</c:forEach>
											
										</select>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >校区</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="campus" name="campus">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >教室</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="classroom" name="classroom">
									</div>
								</div>
								<div class="form-group-separator"></div>
								<div class="form-group">
									<label class="col-sm-2 control-label"  >第几周</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="week" name="week">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >学期</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="semester" name="semester">
									</div>
								</div>
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<div class="col-sm-10">
									    <input type="button" class="form-control" style="margin-left:300px;width:80px;background:#e4393c;color:white;" id="field-4" value="返回" onclick="javascript:history.go(-1);">
										<input type="button" class="form-control" style="margin-left:600px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="保存" onclick="doKechengAdd()">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								 <input type="hidden" name="versions" id="versions" value="${versions}"/> 
							</form>
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
</body>
<script type="text/javascript">
function doKechengAdd(){

     var grade = document.getElementById("grade").value;
     if(null == grade || grade == ''){
        alert('年级不能为空！');
        return false;
      }
     var classid = document.getElementById("classid").value;
     if(null == classid || classid == ''){
        alert('班级不能为空！');
        return false;
      }
      
      var subjectid = document.getElementById("subjectid").value;
     if(null == subjectid || subjectid == ''){
        alert('课程不能为空！');
        return false;
      }
      var weekday = document.getElementById("weekday").value;
     if(null == weekday || weekday == ''){
        alert('星期不能为空！');
        return false;
      }
       var starttime = document.getElementById("starttime").value;
     if(null == starttime || starttime == ''){
        alert('上课开始时间不能为空！');
        return false;
      }
      var endtime = document.getElementById("endtime").value;
     if(null == endtime || endtime == ''){
        alert('上课结束时间不能为空！');
        return false;
      }
      var teacherid = document.getElementById("teacherid").value;
      var assistantid = document.getElementById("assistantid").value;
     if(null == teacherid || teacherid == ''){
	     if(null == assistantid || assistantid == ''){
	        alert('上课教师不能为空！');
	        return false;
	      }
      }
      if(null != teacherid && teacherid != ''){
	     if(null != assistantid && assistantid != ''){
	        alert('上课教师只能选择任课老师和辅导员角色之一！');
	        return false;
	      }
      }
      
     var campus = document.getElementById("campus").value;
     if(null == campus || campus == ''){
        alert('校区不能为空！');
        return false;
      }
      
      var semester = document.getElementById("semester").value;
     if(null == semester || semester == ''){
        alert('学期不能为空！');
        return false;
      }
      var classroom = document.getElementById("classroom").value;
     if(null == classroom || classroom == ''){
        alert('教室不能为空！');
        return false;
      }
      var week = document.getElementById("week").value;
     if(null == week || week == ''){
        alert('周数不能为空！');
        return false;
      }          
               if(confirm("你确定要提交申请吗")){
				document.forms[0].action = "DoKechengAdd.action";
				$("#field-6").attr("disabled","disabled");
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