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
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<style>
	.selectstyle{ 
		width:17%; 
		white-space:nowrap; 
		height:25px;
} 
	</style>
	
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
			<c:if test="${tuser.userType==5||tuser.userType==7 || tuser.userType==6 }">
				<div class="row">
					<div class="col-md-12">	
						<div class="tocify-content">
								<div class="icon-collection">
									<section id="web-application">
										<div class="fontawesome-icon-list">
											<div class="fa-hover"><i class="fa fa-plus-square" onclick="addAbsence('${tuser.userType}');"></i><span>去考勤</span></div>
										</div>
									</section>
								</div>
						</div>
					</div>
				</div>
		   </c:if>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
                                                             学生缺勤记录    
					</h3>
				</div>
				<div style="height:20px;"></div>
					<div class="panel-heading">
							班级：<select style="outline:none;" name="classid" id="classid" class="selectstyle">
										<option value="">...</option>
									<c:forEach items="${classList}" var="classes">
										<option value="${classes.id}" <c:if test="${classes.id==classid}">selected</c:if>>${classes.name}</option>
									</c:forEach>
								  </select>&nbsp;
							学号：<input type="text" name="sid" id="sid" class="selectstyle" value="${sid}" style="position:absolute;"  maxlength="12"/>&nbsp;
							<span  style="margin-left:180px;">姓名：</span>
							<input type="text" name="name" id="name" class="selectstyle" value="${name}" style="position:absolute;" maxlength="7"/>&nbsp;
							<br/>
							<br/>
							<span>
							科目：</span><select style="outline:none;" name="subjectid" id="subjectid" class="selectstyle"> 
										<option value="">...</option>
									<c:forEach items="${subjectList}" var="subject">
										<option value="${subject.id}" <c:if test="${subject.id==subjectid}">selected</c:if>>${subject.name}</option>
									</c:forEach>
								  </select>&nbsp;
							状态：<select style="outline:none;" name="status" id="status" class="selectstyle"> 
										<option value="">...</option>
										<option value="1" <c:if test="${status==1}">selected</c:if>>迟到</option>
										<option value="2" <c:if test="${status==2}">selected</c:if>>旷课</option>
										<option value="4" <c:if test="${status==4}">selected</c:if>>早退</option>
										<c:if test="${tuser.userType==6 }">
										 <option value="4" <c:if test="${status==3}">selected</c:if>>请假</option>
										</c:if>
								  </select>&nbsp;
						 考勤时间：<input name="date" id="date" class="Wdate selectstyle" type="text" onClick="WdatePicker()" value="${date}"/>  
						  <input type="button" value="查询" onclick="findAbsenceByCondition();">
					</div>
					<!--<div onclick="findAbsenceByCondition();" 
					style="height:25px;background-color:#68B828;color:#fff;width:65px;text-align:center;line-height:25px;margin-left:86.4%;cursor:pointer;">
					查询
					</div>-->
					
				    <c:if test="${empty condition}">
					<div class="panel-body">
						<table class="table table-bordered table-striped" id="example-2">
							<thead>
								<tr>
									<th>
										ID
									</th>
									<th>
										学号
									</th>
									<th>
										姓名
									</th>
									<th>
										班级
									</th>
									<th>
										缺勤课程
									</th>
									<th>
										考勤老师
									</th>
									<th>
										缺勤类别
									</th>
									<th>
										缺勤日期
									</th>
									<c:if test="${tuser.userType==5 || tuser.userType==6}">
									<th>
										操作
									</th>
									</c:if>
								</tr>
							</thead>						
							<tbody class="middle-align">
							<c:forEach items="${absenceList}" var="absence" varStatus="status">
								<tr>
								<td>
									<input type="checkbox" class="cbr" name="classcheckbox"  value="${absence.id}">
								</td>
									<td>${absence.sid}</td>	
									<td>${absence.studentname}</td>
									<td>${absence.classname}</td><%--
									<td>${absence.student.classname}</td>
									--%><td>${absence.subjectname}</td>
									<td>${absence.teachername}</td>
									<td>
									    <c:if test="${absence.type == 1}">
									   迟到
									    </c:if>
									    <c:if test="${absence.type == 2}">
									  旷课
									    </c:if>
									    <c:if test="${absence.type == 3}">
									  请假
									    </c:if>
									    <c:if test="${absence.type == 4}">
									  早退
									    </c:if><%--
									    <c:if test="${absence.type == 5}">
									  迟到-早退
									    </c:if>
									--%></td>
									<td>${absence.absencedate}</td>
									<c:if test="${tuser.userType==5 || tuser.userType==6 }">
									<td>
										<a href="javascript:toEditAbsence('${absence.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										           修改 
										</a>
										<c:if test="${tuser.userType==5}">
										<a href="javascript:doDeleteAbsence('${absence.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
											删除
										</a>
										</c:if>
									</td>
									</c:if>
								</tr>
							</c:forEach>
							</tbody>
						</table>					
					</div>
				</c:if>						
				
				<c:if test="${not empty condition&&condition=='filter'}">
					<div class="panel-body">
						<table class="table table-bordered table-striped" id="example-2">
							<thead>
								<tr>
									<th>
										学号
									</th>
									<th>
										姓名
									</th>
									<th>
										班级
									</th>
									<th>
										旷课统计
									</th>
									<th>
										迟到统计
									</th>
									<th>
										早退统计
									</th>
									<c:if test="${tuser.userType==6 }">
									<th>
										请假统计
									</th>
									</c:if>
									<th>
										操作
									</th>
								</tr>
							</thead>						
							<tbody class="middle-align">
								<c:forEach items="${absenceList}" var="absence" varStatus="status">
									<tr>
										<td>${absence.sid}</td>								
										<td>${absence.studentname}</td>
										<%--<td>${absence.student.classname}</td>
										--%>
										<td>${absence.classname}</td>
										<td>${absence.truant}</td>
										<td>${absence.late}</td>
										<td>${absence.early}</td>
										<c:if test="${tuser.userType==6 }">
										<td>${absence.leave}</td>								
										</c:if>
										<td>
										 <a href="javascript:lookAbsenceDetail('${absence.student.sid}','${absence.classname}');" class="btn btn-secondary btn-sm btn-icon icon-left">
											查看详情
										 </a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>					
					</div>				
				</c:if>
				
				<c:if test="${not empty condition&&condition=='detail'}">
					<div class="panel-body">
						<table class="table table-bordered table-striped" id="example-2">
							<thead>
								<tr>
									<th>
										学号
									</th>
									<th>
										姓名
									</th>
									<th>
										班级
									</th>
									<th>
										缺勤课程
									</th>
									<th>
										考勤老师
									</th>									
									<th>
										缺勤类别
									</th>
									<th>
										缺勤日期
									</th>
								</tr>
							</thead>						
							<tbody class="middle-align">
							    <c:if test="${tuser.userType==6 || tuser.userType==7}">
								<c:forEach items="${absenceList}" var="absence" varStatus="status">
									<tr>
										<td>${absence.student.sid}</td>								
										<td>${absence.student.name}</td>
										<td>${absence.classname}</td>
										<td>${absence.subjectname}</td>
										<td>${absence.teachername}</td>
										<td>
										    <c:if test="${absence.type == 1}">
										   迟到
										    </c:if>
										    <c:if test="${absence.type == 2}">
										  旷课
										    </c:if>
										    <c:if test="${absence.type == 3}">
										  请假
										    </c:if>
										    <c:if test="${absence.type == 4}">
										  早退
										    </c:if>
										 </td>
										<td>${absence.absencedate}</td>
									</tr>
								</c:forEach>
								</c:if>
							    <c:if test="${tuser.userType==5}">
								<c:forEach items="${absenceList}" var="absence" varStatus="status">
								 <c:if test="${absence.type != 3 }">
									<tr>
										<td>${absence.student.sid}</td>								
										<td>${absence.student.name}</td>
										<td>${absence.classname}</td>
										<td>${absence.subjectname}</td>
										<td>${absence.teachername}</td>
										<td>
										    <c:if test="${absence.type == 1}">
										   迟到
										    </c:if>
										    <c:if test="${absence.type == 2}">
										  旷课
										    </c:if>
										    <c:if test="${absence.type == 4}">
										    早退
										    </c:if>
										</td>
										<td>${absence.absencedate}</td>
									</tr>
									</c:if>
								</c:forEach>
								</c:if>
							</tbody>
						</table>					
					</div>
					<!--<div onclick="javascript:history.go(-1);" style="margin-left:35%;width:80px;height:30px;background-color:#5CA323;color:#FFF;line-height:30px;text-align:center;cursor:pointer;" >
					返&nbsp;&nbsp;&nbsp;回
					</div>				
					-->
				</c:if>
				<div style="width:100%;height:35px;float:left;"></div>
					<div>
						<table>
							<tr>
								<td width="140px">导出班级考勤记录:</td>
								<td width="80px"><input type="button" name="button" value="导出" onclick="exportAbsenceExcel('class');"></td>
								<td width="200px">(文件格式为*.xlsx)</td>
								<td width="140px">导出学生考勤记录:</td>
								<td width="80px"><input type="button" name="button" value="导出" onclick="exportAbsenceExcel('student');"></td>
								<td width="150px">(文件格式为*.xlsx)</td>
							</tr>
						</table>
					</div>
				
			<div class="form-group-separator"></div>
				<div class="form-group">
					<div class="col-sm-10"></div>
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
	<input type="hidden" name="studentsid" id="studentsid" value=""/>
	<input type="hidden" name="classid_" id="classid_" value=""/>
	<input type="hidden" name="subjectid_" id="subjectid_" value=""/>
	<input type="hidden" name="status_" id="status_" value=""/>
	<input type="hidden" name="times" id="times" value=""/>
	<input type="hidden" name="absenceid" id="absenceid" value=""/>
	<input type="hidden" name="studentname" id="studentname" value=""/>
</form>
</body>
<script type="text/javascript">

		function exportAbsenceExcel(param){
				var classid=$("#classid").val();
				var sid=$("#sid").val().replace(/\s+/g,"");
				var varparam='';
				if(param=='class'){
					varparam='class';
					if(null==classid||classid==''){
						alert("请选择班级");
						return;
					}
					else{
						$.post("ExportAbsenceExcel.action",{varparam:varparam,classid:classid,sid:sid},
							function(data){
								var obj=eval("("+data+")");
								if(!obj.bol){
								alert(decodeURI(obj.message));
								}
								else{
									alert("导出成功");	
									window.location.href="DownloadAbsenceExcel.action?content="+decodeURI(obj.message);							
								}
							}
						);
					}
				}else{
					varparam='student';
					if(null==sid||sid==''){
						alert("请填写学号");
						return;
					}
					else{
						$.post("CheckCondition.action",{sid:sid},
							function(data){
								var obj=eval("("+data+")");
								if(!obj.bol){
									alert(decodeURI(obj.message));
									return;
								}
								else{
								
									$.post("ExportAbsenceExcel.action",{varparam:varparam,classid:classid,sid:sid},
										function(data){
											var obj=eval("("+data+")");
											if(!obj.bol){
											alert(decodeURI(obj.message));
											}
											else{
												alert("导出成功");	
												window.location.href="DownloadAbsenceExcel.action?content="+decodeURI(obj.message);							
											}
										}
									);
								}							
							}
						);
					}
				}
		}

		function lookAbsenceDetail(sid,classname){
				$("#studentsid").val(sid);
				$("#studentname").val($("#name").val());
				var classid=$("#classid").val();
				$("#classid_").val(classid);
				var subjectid=$("#subjectid").val()
				$("#subjectid_").val(subjectid);
				var status=$("#status").val();
				$("#status_").val(status);
				var time=$("#date").val();
				$("#times").val(time);
				document.forms[0].action = "LookAbsenceDetail.action";
				document.forms[0].submit();	
		}

		function findAbsenceByCondition(){
			var classid=$("#classid").val(),
				sid=$("#sid").val().replace(/\s+/g,""),
				name=$("#name").val().replace(/\s+/g,""),
				subjectid=$("#subjectid").val(),
				status=$("#status").val(),
				date=$("#date").val().replace(/\s+/g,"");
				if((null==classid||classid=='')&&(null==sid||sid=='')&&(null==name||name=='')&&(null==subjectid||subjectid=='')&&(null==status||status=='')&&(null==date||date=='')){
					document.forms[0].action = "ToMyAbsenceList.action";
					document.forms[0].submit();	
				}
				else{					
					document.forms[0].action = "FindAbsenceByCondition.action";
					document.forms[0].submit();	
				}
			}
		
		
		function addAbsence(roleid){
				if(roleid==5){
						document.forms[0].action = "AddAbsence.action";
				}
				else{
						document.forms[0].action = "ToMyKechengList.action";
				}
				document.forms[0].submit();	
		}
		
		function toEditAbsence(id){
				$("#absenceid").val(id);
				document.forms[0].action = "ToEditAbsence.action";
				document.forms[0].submit();	
		}
		
		function doDeleteAbsence(){
				var str = document.getElementsByName("classcheckbox");
				var objarray = str.length;
				var chestr = "";
				for (i = 0; i < objarray; i++) {
					if (str[i].checked == true) {
						chestr += str[i].value + ",";
					}
				}
				if (chestr == "") {
					alert("至少选择一个考勤～！");
					return false;
				}
				$("#absenceid").val(chestr);
				document.forms[0].action = "DoDeleteAbsence.action";
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