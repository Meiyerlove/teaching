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
							<h3 class="panel-title">学生个人信息页面</h3>
							
						</div>
						<div class="panel-body">
							
							<form role="form" class="form-horizontal">
								<div class="form-group">
									<label class="col-sm-2 control-label"  >姓名</label>
									
									<div class="col-sm-10">
										${student.name}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >学号</label>
									
									<div class="col-sm-10">
										${student.sid}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >身份证</label>
									
									<div class="col-sm-10">
										${student.idcard}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >手机号</label>
									
									<div class="col-sm-10">
										<input type="text" value="${student.cellphone}" name="mobile" id="mobile" style="border:0;outline:none"/>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">班级</label>
									
									<div class="col-sm-10">
										${student.classname}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >年级</label>
									
									<div class="col-sm-10">
										${student.grade}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">性别</label>
									
									<div class="col-sm-10">
									<c:if test="${student.sex == 1}">
										<div class="radio">
											<label>
												<input type="radio" name="sex" checked value="1">
												男
											</label>
										</div>
										<div class="radio">
											<label>
												<input type="radio" name="sex" value="0">
												女
											</label>
										</div>
									</c:if>
									<c:if test="${student.sex == 2}">
										<div class="radio">
											<label>
												<input type="radio" name="sex" value="1">
												男
											</label>
										</div>
										<div class="radio">
											<label>
												<input type="radio" name="sex" checked value="0">
												女
											</label>
										</div>
									</c:if>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">辅导员</label>
									
									<div class="col-sm-10">
										${student.assistant}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >专业</label>
									
									<div class="col-sm-10">
										${student.majorname}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >项目</label>
									
									<div class="col-sm-10">
										${student.program}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >SCN号</label>
									
									<div class="col-sm-10">
										${student.SCN}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >Email</label>
									
									<div class="col-sm-10">
										${student.email}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >出生日期</label>
									
									<div class="col-sm-10">
										${student.birthday}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >拼音姓</label>
									
									<div class="col-sm-10">
										${student.pyxing}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >拼音名</label>
									
									<div class="col-sm-10">
										${student.pyname}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >家长父亲用户号</label>
									
									<div class="col-sm-10">
										${student.jzfid}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >家长父亲名字</label>
									
									<div class="col-sm-10">
										<input type="text" value="${student.jzfname}" name="fatherName" style="border:0;outline:none"/>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >家长父亲手机号</label>
									
									<div class="col-sm-10">
										<input type="text" value="${student.jzfcellphone}" name="fatherMobile" style="border:0;outline:none"/>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >家长母亲用户号</label>
									
									<div class="col-sm-10">
										${student.jzmid}
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >家长母亲名字</label>
									
									<div class="col-sm-10">
										<input type="text" value="${student.jzmname}" name="motherName" style="border:0;outline:none"/>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >家长母亲手机号</label>
									
									<div class="col-sm-10">
										<input type="text" value="${student.jzmcellphone}" name="motherMobile" style="border:0;outline:none"/>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<input type="hidden" name="studentid" value="${student.id}"/>
								
								<div class="form-group">
									<div class="col-sm-10">
									    <input type="button" class="form-control" style="display:inline;margin-left:300px;width:80px;background:#e4393c;color:white;" value="返回" onclick="javascript:history.go(-1);">
									    <input type="button" class="form-control" style="display:inline;float:right;margin-right:300px;width:80px;background:#e4393c;color:white;" value="保存" onclick="saveStudentInfo();">
									</div>
								</div>
								<div class="form-group-separator"></div>
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
function saveStudentInfo(){
     var mobile = document.getElementById("mobile").value;
     if(null == mobile || mobile == ''){
        alert('手机不能为空！');
        return false;
      }
				document.forms[0].action = "SaveStudentInfo.action";
				//alert('用户添加成功');
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