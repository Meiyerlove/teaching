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
								<a href="javascript:logout();">
									<i class="fa-lock"></i>
									安全退出
								</a>
							</li>
						</ul>
						
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
							<h3 class="panel-title">指定成绩录入老师或日期</h3>
							
						</div>
						<div class="panel-body">
							
							<form role="form" class="form-horizontal">
								<div class="form-group">
									<label class="col-sm-2 control-label">考试名称</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="examtitle" name="examtitle" value="${exam.title}" readonly style="background-color:#FFF;">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">阶段考试</label>
									<div class="col-sm-10">
									<select class="form-control" name="phaseid" id="phaseid">
										 <c:if test="${exam.phaseid == 0}">
										 	<option value="0">无</option> 
										 </c:if>
										 <c:if test="${exam.phaseid == 1}">
										 	<option value="1">Assessment1</option>
										 </c:if>
										 <c:if test="${exam.phaseid == 2}">
										 	<option value="2">Assessment2</option>
										 </c:if>
										 <c:if test="${exam.phaseid == 3}">
											<option value="3">Assessment3</option>
										 </c:if>
										 <c:if test="${exam.phaseid == 4}">
										 	<option value="4">Assessment4</option>
										 </c:if>
										 <c:if test="${exam.phaseid == 5}">
										 	<option value="5">Assessment5</option>
										 </c:if>
									 </select>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">考试科目</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="subjectid" id="subjectid">       
											<option value="${exam.subjectid}">${exam.subjectname}</option>
										</select>
									</div>
									
								</div>																								
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >分数类型</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="scoretype" id="scoretype">
											<option value="">${exam.scoreTypeName}</option> 											
										</select>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">考试类型</label>
									
									<div class="col-sm-10">
										 <select class="form-control" id="examtype1" style="display:block;">
											    <option value=""> ${exam.examTypeName}</option>   
										 </select>
									</div>
								</div>
								
								
								<div class="form-group-separator"></div>
																																				
																								
								<div class="form-group" >
                                        <label class="col-sm-2 control-label">考试班级</label>
                                        <div style="margin-left:18%;margin-right:1.5%;">
										<table class="table table-bordered table-striped"
											id="example-2">	
                                             <thead>
												<tr>
													<th>
														班级名称
													</th>
													<th>
														指定录入成绩老师
													</th>
													<th>
														内审员
													</th>
													<th>
														录入成绩开始日期
													</th>
													<th>
														录入成绩结束日期
													</th>

												</tr>
											</thead>

											<tbody class="middle-align">
													<tr>
														<td>
															${exam.classname}
														</td>
														<td>
															<select class="form-control" name="teacherid" id="teacherid">
																	<option value="${exam.teacherid}">
																		${exam.teachername}
																	</option>
																	<c:forEach items="${teacherList}" var="teacher">
																	<option value="${teacher.tid}">
																		${teacher.name}
																	</option>
																	</c:forEach>
																</select>
														</td>
														<td>
															<select class="form-control" name="teacher" id="teacher">
																	<option value="${exam.neishenyuanid}">
																		${exam.neishenyuanname}
																	</option>
																	<c:forEach items="${teacherList}" var="teacher">
																	<option value="${teacher.tid}">
																		${teacher.name}
																	</option>
																	</c:forEach>
																</select>
														</td>
														
														<td>
														   <input name="enteringdate" value="${exam.enteringdate}" id="enteringdate" class="Wdate" style="margin-top:3px;height:26px;" type="text" onClick="WdatePicker()">
														</td>
														<td>
														   <input name="enteringenddate" value="${exam.enteringenddate}" id="enteringenddate" class="Wdate" style="margin-top:3px;height:26px;" type="text" onClick="WdatePicker()">
														</td>
														</tr>
											</tbody>
										</table>
									</div>
								</div>

								<div class="form-group-separator"></div>
								
									<div class="form-group">
									<label class="col-sm-2 control-label"  >考试日期</label>
									
									<div class="col-sm-10">
									    <input name="edate" id="edate" class="Wdate" style="margin-top:3px;height:26px;" type="text"  value="${exam.edate}"  onClick="WdatePicker()"  style="background-color:#FFF; "/>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >开始时间</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="fromtime" name="fromtime" value="${exam.fromtime}"  placeholder="格式为 00:00">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >结束时间</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="totime" name="totime" value="${exam.totime}"  placeholder="格式为 00:00">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">教室</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="classroom" name="classroom" value="${exam.classroom}">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">年级</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="grade" name="grade" value="${exam.grade}">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >项目</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="program" name="program" value="${exam.program}">
									</div>
								</div>																
								
								<div class="form-group">
									<div class="col-sm-10">
									    <input type="button" class="form-control" style="margin-left:300px;width:110px;background:#e4393c;color:white;" value="返回考试列表" onclick="javascript:toExamList();">
										<input type="button" class="form-control" style="margin-left:600px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="保存" onclick="doExamUpdate();">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								<input type="hidden" name="examid" id="examid" value="${exam.id}"/>
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
function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].submit();
			}	
		}

function toExamList() {
		document.forms[0].action = "ToExamList.action";
		document.forms[0].submit();
	}

function doExamUpdate() {
	var fromtime=$("#fromtime").val().replace;
	var totime=$("#totime").val();
	var classroom=$("#classroom").val();
	var enteringdate=$("#enteringdate").val();
	var enteringenddate=$("#enteringenddate").val();
	if(null==enteringdate||enteringdate==""){
		alert('录入成绩开始时间不能为空！');
		return false;
	}
	if(null==enteringenddate||enteringenddate==""){
		alert('录入成绩结束时间不能为空！');
		return false;
	}
	var edate = document.getElementById("edate").value;
	if(null == edate || edate == '')
	{
		alert('考试日期不能为空！');
		return false;
	}
	
	var fromtime = document.getElementById("fromtime").value;
	var reg=/^(?:(?:0?|1)\d|2[0-3]):[0-5]\d$/;
	if (null == fromtime || fromtime == '') {
		alert('考试开始时间不能为空！');
		return false;
	}
	else if(!reg.test(fromtime)){
		alert('考试开始时间格式错误！');
		return false;
	}
	var totime = document.getElementById("totime").value;
	if (null == totime || totime == '') {
		alert('考试结束时间不能为空！');
		return false;
	}
	else if(!reg.test(totime)){
		alert('考试结束时间格式错误！');
		return false;
	}
	var classroom = document.getElementById("classroom").value;
	if (null == classroom || classroom == '') {
		alert('考试地点不能为空！');
		return false;
	}
	alert('保存成功');
	document.forms[0].action = "DoExamUpdate.action";
	//alert('用户添加成功');
	document.forms[0].submit();
}
</script>
</html>