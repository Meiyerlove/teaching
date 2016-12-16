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
			<div class="panel panel-default" style="height:750px;">
				 <div>
				            <div>
			                    <div style="float:left;width:320px;">
					           		考试名称:${exam.title}
					           	</div>
					            <div style="float:left;width:200px;">
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
					            <div style="float:left;width:200px;">考试科目:${exam.subjectname}</div>
					           </div>
					           <div style="clear:both;height:20px;"></div>
					           <div style="clear:both;">
						            <div style="float:left;width:320px;">分数类型:${exam.scoreTypeName}</div>    
						            <div style="float:left;width:200px;">考试类型:${exam.examTypeName}</div>							           	
						            <div style="float:left;width:200px;">内审员:${exam.neishenyuanname}</div>
					           </div>
					           <div style="clear:both;height:20px;"></div>
		        </div>
						
				<div class="panel-body" style="overflow:scroll;width:100%;height:500px;z-index:-100;" >
					<table class="table table-bordered table-striped" id="example-2" style="margin-top:-20px;z-index:-100;">
								<thead>
									<tr>
										<th>学生名字</th>
										<th width="12%">学号</th>										
										<c:forEach items="${titleList}" var="title">
										<th>${title}</th>								
										</c:forEach>
										<c:if test="${buttonStatus!=1&&tuser.userType==7}">
										<th width="6%">百分成绩</th>
										</c:if>
										
										<th>考试班级</th>
										<c:if test="${tuser.userType==7}">
										<th>录入截止日期</th>
										</c:if>
										<th>雅思成绩</th>						
									</tr>
								</thead>
								
								<tbody class="middle-align">
								  <c:forEach items="${studentList}" var="student" varStatus="status">
									<tr>
										<td>${student.name}</td>
										<td>${student.sid}</td>
										

								<c:if test="${buttonStatus!=2}">
											<c:if test="${exam.examtype==1}">
											<td>
												<select class="form-control" name="score${student.sid}" id="score${student.sid}"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
													<c:if test="${empty buttonStatus}"> 
														<c:if test="${not empty student.zk}">
															<option value="${student.zk}">${student.zk}</option>
															<option value="">...</option>
															<c:forEach items="${resultList}" var="result" varStatus="status">
																<option value="${result}">${result}</option>
															</c:forEach>											
														</c:if>
														<c:if test="${empty student.zk}">
															<option value="">...</option>
															<c:forEach items="${resultList}" var="result" varStatus="status">
																<option value="${result}">${result}</option>
															</c:forEach>											
														</c:if>															
													</c:if>
													<c:if test="${not empty buttonStatus}"> 										
															<option value="">...</option>
															<c:forEach items="${resultList}" var="result" varStatus="status">
																<option value="${result}">${result}</option>
															</c:forEach>																										
													</c:if>		
												</select>												
											</td>	
											</c:if>
											<c:if test="${exam.examtype==2}">
												<td>${student.zk}</td>
												<c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
												<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.zkbz}">
																	<option value="${student.zkbz}">${student.zkbz}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.zkbz}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${exam.examtype==3}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
												<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" <c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.zkbk}">
																	<option value="${student.zkbk}">${student.zkbk}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.zkbk}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${exam.examtype==4}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
												<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.zkbkbz}">
																	<option value="${student.zkbkbz}">${student.zkbkbz}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.zkbkbz}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${exam.examtype==5}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
												<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.cx}">
																	<option value="${student.cx}">${student.cx}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.cx}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${exam.examtype==6}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
												<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.cxbz}">
																	<option value="${student.cxbz}">${student.cxbz}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.cxbz}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${exam.examtype==7}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
												<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.bqk}">
																	<option value="${student.bqk}">${student.bqk}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.bqk}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${exam.examtype==8}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <td>${student.bqk}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
											    <c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:150px;"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.bqkbz}">
																	<option value="${student.bqkbz}">${student.bqkbz}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.bqkbz}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${exam.examtype==9}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <td>${student.bqk}</td>
											    <td>${student.bqkbz}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
											    <c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:150px;"
														    <c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.qt}">
																	<option value="${student.qt}">${student.qt}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.qt}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>	
											<c:if test="${exam.examtype==10}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <td>${student.bqk}</td>
											    <td>${student.bqkbz}</td>
											    <td>${student.qt}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
											    <c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" style="width:150px;"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.qtbz}">
																	<option value="${student.qtbz}">${student.qtbz}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.qtbz}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>
												</c:if>												
											</c:if>
											<c:if test="${exam.examtype==20}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
												<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}" 
														<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.decbk}">
																	<option value="${student.decbk}">${student.decbk}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.decbk}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${exam.examtype==21}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.decbk}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
												<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.qt2}">
																	<option value="${student.qt2}">${student.qt2}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.qt2}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${exam.examtype==22}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.decbk}</td>
											    <td>${student.qt2}</td>
											    <c:if test="${student.examstatus!=1}">
												<td></td>
												</c:if>
												<c:if test="${student.examstatus==1}">
													<td>
														<select class="form-control" name="score${student.sid}" id="score${student.sid}"<c:if test="${bol=='false'}">disabled</c:if> style="background-color:#FFF;">
															<c:if test="${empty buttonStatus}"> 
																<c:if test="${not empty student.qt2bz}">
																	<option value="${student.qt2bz}">${student.qt2bz}</option>
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>
																<c:if test="${empty student.qt2bz}">
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>											
																</c:if>															
															</c:if>
															<c:if test="${not empty buttonStatus}"> 										
																	<option value="">...</option>
																	<c:forEach items="${resultList}" var="result" varStatus="status">
																		<option value="${result}">${result}</option>
																	</c:forEach>																										
															</c:if>		
													</select>

													</td>	
												</c:if>
											</c:if>
											<c:if test="${buttonStatus!=1&&tuser.userType==7&&student.examstatus==1}">
											<td>
											<input class="form-control" type="text" id="baifenresult${student.sid}" 
											  name="baifenresult${student.sid}" value="${student.baifenscore}" onkeyup="value=value.replace(/[^\d.]/g,'')" 
											   <c:if test="${bol=='false'}">readonly</c:if> style="background-color:#FFF;width:70px;"/>
											</td>	
											</c:if>
											<c:if test="${buttonStatus!=1&&tuser.userType==7&&student.examstatus!=1}">
											<td>
											</td>	
											</c:if>
																						
										</c:if>																				

							<!--	
							当录入成绩结束时，返回所有录入数据--教务可修改
							-->

							<c:if test="${buttonStatus==2&&(tuser.userType==4||tuser.userType==3)}">
											<c:if test="${exam.examtype==1}">
											<td>
											<c:if test="${not empty student.zk}">
												<select class="form-control" name="score${student.sid}" id="score${student.sid}">
													<option value="${student.zk}">${student.zk}</option>
														<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
														</c:forEach>																																															
												</select>												
											</c:if>
											</td>											
											</c:if>
											<c:if test="${exam.examtype==2}">
												<td>${student.zk}</td>
												<td>
												<c:if test="${not empty student.zkbz}">
													<select class="form-control" name="score${student.sid}" id="score${student.sid}">
														<option value="${student.zkbz}">${student.zkbz}</option>
														<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
														</c:forEach>											
													</select>
												</c:if>
												</td>		
											</c:if>
											<c:if test="${exam.examtype==3}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
												<td>
												<c:if test="${not empty student.zkbk}">
												<select class="form-control" name="score${student.sid}" id="score${student.sid}">														
													<option value="${student.zkbk}">${student.zkbk}</option>
													<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
														</c:forEach>
												</select>
												</c:if>
												</td>												
											</c:if>
											<c:if test="${exam.examtype==4}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
												<td>
												<c:if test="${not empty student.zkbkbz}">
												<select class="form-control" name="score${student.sid}" id="score${student.sid}">											
													<option value="${student.zkbkbz}">${student.zkbkbz}</option>
													<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
													</c:forEach>														
												</select>
												</c:if>
												</td>
											</c:if>
											<c:if test="${exam.examtype==5}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>											
												<td>
												<c:if test="${not empty student.cx}">
													<select class="form-control" name="score${student.sid}" id="score${student.sid}">
														<option value="${student.cx}">${student.cx}</option>
														<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
														</c:forEach>																
													</select>
												</c:if>
												</td>	
											</c:if>
											<c:if test="${exam.examtype==6}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>										
												<td>
												<c:if test="${not empty student.cxbz}">
													<select class="form-control" name="score${student.sid}" id="score${student.sid}">														
														<option value="${student.cxbz}">${student.cxbz}</option>
														<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
														</c:forEach>																
													</select>
												</c:if>
												</td>												
											</c:if>
											<c:if test="${exam.examtype==7}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
												<td>
												<c:if test="${not empty student.bqk}">
													<select class="form-control" name="score${student.sid}" id="score${student.sid}">
														<option value="${student.bqk}">${student.bqk}</option>	
														<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
														</c:forEach>														
													</select>
												</c:if>

												</td>	
											</c:if>
											<c:if test="${exam.examtype==8}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <td>${student.bqk}</td>										
												<td>
												<c:if test="${not empty student.bqkbz}">
													<select class="form-control" name="score${student.sid}" id="score${student.sid}">															
														<option value="${student.bqkbz}">${student.bqkbz}</option>	
														<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
														</c:forEach>														
													</select>
												</c:if>
												</td>	
											</c:if>
											<c:if test="${exam.examtype==9}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <td>${student.bqk}</td>
											    <td>${student.bqkbz}</td>
												<td>
												<c:if test="${not empty student.qt}">
													<select class="form-control" name="score${student.sid}" id="score${student.sid}">														
														<option value="${student.qt}">${student.qt}</option>
														<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
														</c:forEach>															
													</select>
												</c:if>
												</td>	
											</c:if>	
											<c:if test="${exam.examtype==10}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <td>${student.bqk}</td>
											    <td>${student.bqkbz}</td>
											    <td>${student.qt}</td>
												<td>
												<c:if test="${not empty student.qtbz}">
													<select class="form-control" name="score${student.sid}" id="score${student.sid}">
														<option value="${student.qtbz}">${student.qtbz}</option>
														<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
														</c:forEach>																	
													</select>
												</c:if>
												</td>											
											</c:if>
											<c:if test="${exam.examtype==20}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
												<td>
												<c:if test="${not empty student.decbk}">
												<select class="form-control" name="score${student.sid}" id="score${student.sid}">											
													<option value="${student.decbk}">${student.decbk}</option>
													<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
													</c:forEach>														
												</select>
												</c:if>
												</td>
											</c:if>
											<c:if test="${exam.examtype==21}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.decbk}</td>
												<td>
												<c:if test="${not empty student.qt2}">
												<select class="form-control" name="score${student.sid}" id="score${student.sid}">											
													<option value="${student.qt2}">${student.qt2}</option>
													<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
													</c:forEach>														
												</select>
												</c:if>
												</td>
											</c:if>
											<c:if test="${exam.examtype==22}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.decbk}</td>
											    <td>${student.qt2}</td>
												<td>
												<c:if test="${not empty student.qt2bz}">
												<select class="form-control" name="score${student.sid}" id="score${student.sid}">											
													<option value="${student.qt2bz}">${student.qt2bz}</option>
													<c:forEach items="${resultList}" var="result" varStatus="status">
															<option value="${result}">${result}</option>
													</c:forEach>														
												</select>
												</c:if>
												</td>
											</c:if>
										</c:if>	
							<!--	
							当录入成绩结束时，返回所有录入数据--老师
							-->
							<c:if test="${buttonStatus==2&&tuser.userType==7}">
											<c:if test="${exam.examtype==1}">
											<td>
											<c:if test="${not empty student.zk}">
												<select class="form-control">
													<option value="${student.zk}">${student.zk}</option>																																															
												</select>												
											</c:if>
											</td>	
											</c:if>
											<c:if test="${exam.examtype==2}">
												<td>${student.zk}</td>
												<td>
												<c:if test="${not empty student.zkbz}">
													<select class="form-control">
														<option value="${student.zkbz}">${student.zkbz}</option>											
													</select>
												</c:if>
												</td>		
											</c:if>
											<c:if test="${exam.examtype==3}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
												<td>
												<c:if test="${not empty student.zkbk}">
												<select class="form-control">														
													<option value="${student.zkbk}">${student.zkbk}</option>
												</select>
												</c:if>
												</td>												
											</c:if>
											<c:if test="${exam.examtype==4}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
												<td>
												<c:if test="${not empty student.zkbkbz}">
												<select class="form-control">											
													<option value="${student.zkbkbz}">${student.zkbkbz}</option>														
												</select>
												</c:if>
												</td>
											</c:if>
											<c:if test="${exam.examtype==5}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>											
												<td>
												<c:if test="${not empty student.cx}">
													<select class="form-control">
														<option value="${student.cx}">${student.cx}</option>																
													</select>
												</c:if>
												</td>	
											</c:if>
											<c:if test="${exam.examtype==6}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>										
												<td>
												<c:if test="${not empty student.cxbz}">
													<select class="form-control">														
														<option value="${student.cxbz}">${student.cxbz}</option>																
													</select>
												</c:if>
												</td>												
											</c:if>
											<c:if test="${exam.examtype==7}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
												<td>
												<c:if test="${not empty student.bqk}">
													<select class="form-control">
														<option value="${student.bqk}">${student.bqk}</option>															
													</select>
												</c:if>

												</td>	
											</c:if>
											<c:if test="${exam.examtype==8}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <td>${student.bqk}</td>										
												<td>
												<c:if test="${not empty student.bqkbz}">
													<select class="form-control">															
														<option value="${student.bqkbz}">${student.bqkbz}</option>															
													</select>
												</c:if>
												</td>	
											</c:if>
											<c:if test="${exam.examtype==9}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <td>${student.bqk}</td>
											    <td>${student.bqkbz}</td>
												<td>
												<c:if test="${not empty student.qt}">
													<select class="form-control">														
														<option value="${student.qt}">${student.qt}</option>															
													</select>
												</c:if>
												</td>	
											</c:if>	
											<c:if test="${exam.examtype==10}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.zkbkbz}</td>
											    <td>${student.cx}</td>
											    <td>${student.cxbz}</td>
											    <td>${student.bqk}</td>
											    <td>${student.bqkbz}</td>
											    <td>${student.qt}</td>
												<td>
												<c:if test="${not empty student.qtbz}">
													<select class="form-control">
														<option value="${student.qtbz}">${student.qtbz}</option>																	
													</select>
												</c:if>
												</td>											
											</c:if>
											<c:if test="${exam.examtype==20}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
												<td>
												<c:if test="${not empty student.decbk}">
													<select class="form-control">
														<option value="${student.decbk}">${student.decbk}</option>																	
													</select>
												</c:if>
												</td>											
											</c:if>
											<c:if test="${exam.examtype==21}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.decbk}</td>
												<td>
												<c:if test="${not empty student.qt2}">
													<select class="form-control">
														<option value="${student.qt2}">${student.qt2}</option>																	
													</select>
												</c:if>
												</td>											
											</c:if>
											<c:if test="${exam.examtype==22}">
												<td>${student.zk}</td>
											    <td>${student.zkbz}</td>
											    <td>${student.zkbk}</td>
											    <td>${student.decbk}</td>
											    <td>${student.qt2}</td>
												<td>
													<c:if test="${not empty student.qt2bz}">
														<select class="form-control">
															<option value="${student.qt2bz}">${student.qt2bz}</option>																	
														</select>
													</c:if>
												</td>											
											</c:if>
											<c:if test="${buttonStatus!=1&&tuser.userType==7&&student.examstatus==1}">
											<td>
											<input class="form-control" type="text" value="${student.baifenscore}" readonly 
											style="background-color:#FFF;width:70px;"/>
											</td>	
											</c:if>
											<c:if test="${buttonStatus!=1&&tuser.userType==7&&student.examstatus!=1}">
											<td>
											</td>	
											</c:if>
										</c:if>	
									
									<td>${student.classname}</td>
										<c:if test="${tuser.userType==7}">
										<td>${dateNew}</td>
										</c:if>
										<td>${student.ielts}</td>
									
									</tr>
									</c:forEach>
									
								</tbody>
							</table>
						</div>		
						<c:if test="${tuser.userType == 7}">
							<div style="height:30px;color:red;text-align:right;word-spacing: 5px;line-height:30px;">
							（成绩直接提交给内审员，如果被退回，将重新录入）
							</div>
						</c:if>							
							<c:if test="${tuser.userType != 3}">
							
							<div class="form-group" style="margin-top:10px;">
								<label class="col-sm-2 control-label" style="padding-top:5px;" >预计延长时间</label>
								<div class="col-sm-10">
									<input name="enteringupdatedate" id="enteringupdatedate" class="Wdate" style="margin-top:3px;height:26px;" type="text" onClick="WdatePicker()">
								</div>
							</div>
						
						<div class="form-group-separator"></div>
						
						<div class="form-group" style="margin-top:30px;">
							<label class="col-sm-2 control-label" style="padding-top:5px;" >延长理由</label>
							
							<div class="col-sm-10">
								<textarea class="form-control" id="reason" name="reason"></textarea>
							</div>
						</div>
						
						<div class="form-group-separator"></div>
						</c:if>	
							<div class="form-group" style="margin-top:80px;">
								<div class="col-sm-10">
									<c:if test="${tuser.userType == 3}">
									   <input type="button" class="form-control" style="margin-left:200px;width:80px;background:#e4393c;color:white;" value="返回" onclick="javascript:toExamListManage();">
										<input type="button" class="form-control" style="margin-left:450px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="保存" onclick="doScoreInput();">
										<c:if test="${exam.displaystatus==3}">
										<input type="button" class="form-control" style="margin-left:700px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="发布" onclick="doPublicInput();">
										</c:if>
										<c:if test="${exam.displaystatus==4}">
										<input type="button" class="form-control" style="margin-left:700px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="撤回" onclick="doPublicInput();">
										</c:if>											
									</c:if>
									<c:if test="${tuser.userType == 4}">
									   <input type="button" class="form-control" style="margin-left:200px;width:80px;background:#e4393c;color:white;" value="返回" onclick="javascript:toExamListManage();">
										<c:if test="${exam.displaystatus==3}">
										<input type="button" class="form-control" style="margin-left:700px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="发布" onclick="doPublicInput();">
										</c:if>
										<c:if test="${exam.displaystatus==4}">
										<input type="button" class="form-control" style="margin-left:700px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="撤回" onclick="doPublicInput();">
										</c:if>										
									</c:if>
									<c:if test="${tuser.userType == 7&&bol=='true'}">
									    <input type="button" class="form-control" style="margin-left:200px;width:80px;background:#e4393c;color:white;" value="返回" onclick="javascript:toExamListTea();">
										<input type="button" class="form-control" style="margin-left:800px;width:125px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="申请录入延长" onclick="doDelayInput();">	
										<c:if test="${empty buttonStatus&&not empty sidNew}">												
											<input type="button" class="form-control" style="margin-left:400px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="保存" onclick="doScoreInput();">
											<input type="button" class="form-control" style="margin-left:600px;width:110px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="第一次提交" onclick="doHandleInput('currsubmit');">
										</c:if>
										<c:if test="${buttonStatus==1}">												
										<input type="button" class="form-control" style="margin-left:500px;width:110px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="第二次提交" onclick="doHandleInput();">
										</c:if>
										<c:if test="${buttonStatus==2}">												
										<input type="button" class="form-control" style="margin-left:400px;width:130px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="导出本次成绩"; onclick="exportResult('exportCurrResult');">
										<input type="button" class="form-control" style="margin-left:650px;width:130px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="导出科目成绩"; onclick="exportResult('exportCurrSubjectResult');">
										</c:if>										
									</c:if>
									<c:if test="${tuser.userType == 7&&bol=='false'}">
									  <input type="button" class="form-control" style="margin-left:200px;width:80px;background:#e4393c;color:white;" value="返回" onclick="javascript:toExamListTea();">
									  <input type="button" class="form-control" style="margin-left:450px;width:130px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="已截止";>	
									  <input type="button" class="form-control" style="margin-left:800px;width:125px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="申请录入延长" onclick="doDelayInput();">								  					
									</c:if>
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
	<input type="hidden" name="studentid" id="studentid" value=""/>
	<input type="hidden" name="examid" id="examid" value="${exam.id}"/>
	<input type="hidden" name="sid" id="sid" value="${sid}"/>
	<input type="hidden" name="sidNew" id="sidNew" value="${sidNew}"/>
	<input type="hidden" name="buttonStatus" id="buttonStatus" value="${buttonStatus}"/>
</form>
</body>
<script type="text/javascript">
function doScoreInput(){
                alert('成绩保存成功');
				document.forms[0].action = "DoScoreInput.action";
				document.forms[0].submit();	
		}
function exportResult(param){
	var examid=$("#examid").val();
	$.post("ExportResultExcel.action",{examid:examid,param:param},
		function(data){
			if(data=="false"){
				alert("导出失败");
				}else{
					alert("导出成功");						
					window.location.href="DownloadExcel.action?content="+data;
					
					}
		}
	);
}

function doHandleInput(param){
    var sid = '${sid}';
    var sidNew = '${sidNew}';
    var buttonStatus = '${buttonStatus}';
    if(null!=sidNew&&sidNew!=""){
		    var sidarrayNew = sidNew.split(',');
		    for(i = 0; i < sidarrayNew.length-1; i++){
			       var tempNew = "score"+sidarrayNew[i];
			       var scoretempNew = document.getElementById(tempNew).value;
				       if(null == scoretempNew || scoretempNew == ''){
				         alert('请录入所有学生的成绩');
				         return false;
				       }
		       //if(null==buttonStatus||buttonStatus==''){
			       	//var baifenresultid = "baifenresult"+sidarrayNew[i];
			       	//var baifenresult = document.getElementById(baifenresultid).value;
				       	//if(null==baifenresult||baifenresult==''){
				       	//alert('请录入所有学生的百分成绩');
				         //return false;
				       	//}
		       //}
		    }
    }else{
		    var sidarray = sid.split(',');
		    for(i = 0; i < sidarray.length-1; i++){
			       var temp = "score"+sidarray[i];
			       var scoretemp = document.getElementById(temp).value;
				       if(null == scoretemp || scoretemp == ''){
				         alert('请录入所有学生的成绩');
				         return false;
				       }
		       //if(null==buttonStatus||buttonStatus==''){
			       	//var baifenresultid = "baifenresult"+sidarrayNew[i];
			       //	var baifenresult = document.getElementById(baifenresultid).value;
				       //	if(null==baifenresult||baifenresult==''){
				       	//alert('请录入所有学生的百分成绩');
				        // return false;
				       	//}
		       //}
		    }
    }
		    if(param=="currsubmit"){
		   	 alert('成绩第一次录入成功,请第二次录入');
		   }else{
		   	 alert('成绩录入成功');
		   }
				document.forms[0].action = "DoHandleInput.action";
				document.forms[0].submit();	
		}
		
function doDelayInput(){
    var enteringupdatedate = document.getElementById("enteringupdatedate").value;
    if(null == enteringupdatedate || enteringupdatedate == '')
		{
			alert('延长日期不能为空！');
			return false;
		}
		
	var reason = document.getElementById("reason").value;
    if(null == reason || reason == '')
		{
			alert('延长理由不能为空！');
			return false;
		}
    
                alert('延长申请成功');
				document.forms[0].action = "DoDelayInput.action";
				document.forms[0].submit();	
}

function doPublicInput(){
    var sid = '${sidNew}';
    var sidarray = sid.split(',');
    for(i = 0; i < sidarray.length-1; i++){
       var temp = "score"+sidarray[i];
       var scoretemp = document.getElementById(temp).value;
       if(null == scoretemp || scoretemp == ''){
          alert('请录入所有学生的成绩');
          return false;
       }
    }
                alert('成绩发布成功');
				document.forms[0].action = "DoPublicInput.action";
				document.forms[0].submit();	
		}
		
function toExamListManage(){
				document.forms[0].action = "ToExamListManage.action";
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

function switchSelect(sid){
			var score=$("#score"+sid).val();
			if(score=="Resit"||score=="ABS"||score=="CHT"||score=="DQRS"){
				$("#scoreSuffix"+sid).css("display","inline");
				$("#scoreSuffix"+sid).css("width","50px");
				$("#score"+sid).css("width","50px");
			}
			else{
				$("#scoreSuffix"+sid).css("display","none");
			}
}
		
</script>
</html>