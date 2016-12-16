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
	<link href="assets/css/bootstrapNew.css" rel="stylesheet">

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
			<div>
					<div class="panel panel-default" >
						<div class="panel-heading" >
							<h3 class="panel-title">
					           <div style="float:left;width:250px;">
					           		考试名称:${exam.title}
					           	</div>
					           <div style="float:left;width:250px;">
					           		考试阶段:<c:if test="${exam.phaseid == 0}">
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
											 </c:if>
								</div>							           							           
					           <div style="float:left;">考试科目:${exam.subjectname}</div>
					           <br><br>
					            <div style="float:left;width:250px;">分数类型:${exam.scoreTypeName}</div>    
					           <div style="float:left;width:250px;">考试类型:${exam.examTypeName}</div>							           	
					           <div>内审员:${exam.neishenyuanname}</div>
							</h3>
						</div>
						
						<div class="table-responsive panel-body">
							<table class="table table-bordered table-striped" id="example-2">
								<thead>
									<tr>
										<th>学号</th>
										<th>姓名</th>
										<th>班级</th>
										<th>第一次输入成绩</th>
										<th>第二次输入成绩</th>
										</tr>
								</thead>
								
								<tbody class="middle-align">
								  <c:forEach items="${studentList}" var="student" varStatus="status">
									<tr>
										<td>${student.sid}</td>
										<td>${student.name}</td>
										<td>${student.classname}</td>
										<c:if test="${student.examstatus!=1}">
												<td></td>
												<td></td>
										</c:if>
										<c:if test="${exam.examtype==1&&exam.scoretype==1}">										
											<c:if test="${student.examstatus==1}">
													<td>
													<input class="form-control" type="text" value="${student.zk}" id="score${student.sid}" name="score${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>"/>
													</td>
													<td>
													<input class="form-control" type="text" value="${student.tempResult}" id="scoreone${student.sid}" name="scoreone${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>"/>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==1&&exam.scoretype==2}">										
											<c:if test="${student.examstatus==1}">
													<td>													
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
																<option>${student.zk}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==1&&exam.scoretype==4}">										
											<c:if test="${student.examstatus==1}">
													<td>													
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
																<option>${student.zk}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==1&&exam.scoretype==3}">										
											<c:if test="${student.examstatus==1}">
													<td>
													<input class="form-control" type="text" value="${student.zk}" id="score${student.sid}" name="score${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" />
													<select class="form-control" name="selectScore${student.sid}" id="selectScore${student.sid}" style="width:20px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" onchange="changevalue('${student.sid}','score');">																	
														<option value="">...</option>
														<option value="ABS">ABS</option>
														<option value="DISQ">DISQ</option>
														<option value="CHT">CHT</option>																																			
													</select>
													</td>
													<td>
													<input class="form-control" type="text" value="${student.tempResult}" id="scoreone${student.sid}" name="scoreone${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" />
													<select class="form-control" name="selectScoreOne${student.sid}" id="selectScoreOne${student.sid}" style="width:20px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" onchange="changevalue('${student.sid}','scoreone');">																	
														<option value="">...</option>
														<option value="ABS">ABS</option>
														<option value="DISQ">DISQ</option>
														<option value="CHT">CHT</option>																																			
													</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==2}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
																<option>${student.zkbz}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==3&&exam.scoretype==2}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
																<option>${student.zkbk}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==3&&exam.scoretype==4}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
																<option>${student.zkbk}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>">
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==3&&exam.scoretype==3}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<input class="form-control" type="text" value="${student.zkbk}" id="score${student.sid}" name="score${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" />
													</td>
													<td>
														<input class="form-control" type="text" value="${student.tempResult}" id="scoreone${student.sid}" name="scoreone${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" />														
												  	</td>	
											</c:if>																																						
										</c:if>										
										<c:if test="${exam.examtype==4}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.zkbkbz}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==5}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.cx}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==6}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.cxbz}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==7&&exam.scoretype==2}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.bqk}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==7&&exam.scoretype==3}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<input class="form-control" type="text" value="${student.bqk}" id="score${student.sid}" name="score${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" />
													</td>
													<td>
														<input class="form-control" type="text" value="${student.tempResult}" id="scoreone${student.sid}" name="scoreone${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" />														
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==8}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.bqkbz}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==9&&exam.scoretype==2}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.qt}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==9&&exam.scoretype==3}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<input class="form-control" type="text" value="${student.qt}" id="score${student.sid}" name="score${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" />
													</td>
													<td>
														<input class="form-control" type="text" value="${student.tempResult}" id="scoreone${student.sid}" name="scoreone${student.sid}" style="width:100px;display:inline;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" />														
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==10}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.qtbz}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==20}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.decbk}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==21}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.qt2}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
										<c:if test="${exam.examtype==22}">										
											<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="scoreone${student.sid}" id="scoreone${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
																<option>${student.qt2bk}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
													</td>
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:100px;<c:if test="${not empty student.tempColor}">border:1px solid red</c:if>" >
															<option>${student.tempResult}</option>
															<c:forEach items="${resultList}" var="result">
																<option>${result}</option>
															</c:forEach>
														</select>
												  	</td>	
											</c:if>																																						
										</c:if>
									</tr>
								 </c:forEach>
									
								</tbody>
							</table>
						
						<div class="form-group-separator"></div>
							
						</div>
							<div class="form-group">
								<div class="col-sm-10">
									<input type="button" class="form-control" style="margin-left:500px;width:110px;background:#e4393c;color:white;" id="field-6" value="提交" onclick="doScoreHandle();">
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
	<input type="hidden" name="examid" id="examid" value="${exam.id}"/>
	<input type="hidden" name="sid" id="sid" value="${sid}"/>
</form>
</body>
<script type="text/javascript">

function changevalue(sid,param){
	if(param=='score'){
		$("#score"+sid).val($("#selectScore"+sid).val());
	}else{
		$("#scoreone"+sid).val($("#selectScoreOne"+sid).val());
	}
}
		
function doScoreHandle(){
    var sid = '${sid}';//判断所有正考
    var sidNew = '${sidNewOther}';//判断所有正考之外的
    if(null!=sidNew&&sidNew!=""){
	    var sidarrayNew = sidNew.split(',');
	    for(i = 0; i < sidarrayNew.length-1; i++){
	       var tempone= "scoreone"+sidarrayNew[i];
	       var temptwo= "score"+sidarrayNew[i];
	       var scoretempone = document.getElementById(tempone).value;
	       var scoretemptwo = document.getElementById(temptwo).value;
	       if(scoretempone!=scoretemptwo){
	         alert('学生两次成绩不一致，请核实所有学生的成绩');
	         return false;
	       }
	    }
    }
    else{
    	var sidarray = sid.split(',');
	    for(i = 0; i < sidarray.length-1; i++){
	       var tempone= "scoreone"+sidarray[i];
	       var temptwo= "score"+sidarray[i];
	       var scoretempone = document.getElementById(tempone).value;
	       var scoretemptwo = document.getElementById(temptwo).value;
	       if(scoretempone!=scoretemptwo){
	         alert('学生两次成绩不一致，请核实所有学生的成绩');
	         return false;
	       }
	    }
    	
    }
                alert('成绩提交成功');
				document.forms[0].action = "DoScoreHandle.action";
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