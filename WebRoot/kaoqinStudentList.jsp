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
					<h3 class="panel-title">考勤页面</h3>
				</div>
				
				<div class="panel-body">
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
							    <th class="no-sorting">
									迟到
								</th>
								<th class="no-sorting">
									缺席
								</th>
								<th class="no-sorting">
									早退
								</th>
								<c:if test="${tuser.userType==6}">
								 <th class="no-sorting">
									请假
								 </th>	
								</c:if>
								<th>学号</th>
								<th>姓名</th>
								<th>班级</th>
								<th>辅导员</th>
								
							</tr>
						</thead>
						
						<tbody class="middle-align">
						  <c:forEach items="${studentList}" var="student" varStatus="status">
							<tr>
							    <td>
									<input type="checkbox" name="check_box1" id="check_box1${status.count}" onclick="checkbox1(this,'${status.count}')" value="${student.sid}">
								</td>
								<td>
									<input type="checkbox" name="check_box2" id="check_box2${status.count}" onclick="checkbox2(this,'${status.count}')" value="${student.sid}">
								</td>
								<td>
									<input type="checkbox" name="check_box3" id="check_box3${status.count}"  onclick="checkbox3(this,'${status.count}')"  value="${student.sid}">
								</td>
								<c:if test="${tuser.userType==6 }">
								 <td>
									<input type="checkbox" name="check_box4" id="check_box4${status.count}"  onclick="checkbox4(this,'${status.count}')"  value="${student.sid}">
								 </td>
							    </c:if>
								<td>${student.sid}</td>
								<td>${student.name}</td>
								<td>${student.classname}</td>
								<td>${student.assistant}</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>
					
				</div>
				
				<div class="form-group">
									<div class="col-sm-10">
									  <input type="button" class="form-control" style="margin-left:200px;width:80px;background:#e4393c;color:white;" value="返回" onclick="javascript:history.go(-1);">
									  <input type="button" class="form-control" style="margin-left:450px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="保存" onclick="doKaoqin();">
										<!--<input type="button" class="form-control" style="margin-left:450px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="迟到" onclick="dobelate();">
										<input type="button" class="form-control" style="margin-left:700px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="旷课" onclick="doabsence();">
									-->
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
	<input type="hidden" name="kechengid" id="kechengid" value="${kechengid}"/>
	<input type="hidden" name="agers" id="agers" value="${agers}">
</form>
</body>
<script type="text/javascript">
function toStudentAdd(){
				document.forms[0].action = "ToStudentAdd.action";
				document.forms[0].submit();	
		}
		
function deleteStudent(studentid){
         if (confirm("您确定要删除吗?")){
                document.getElementById("studentid").value = studentid;
				document.forms[0].action = "DeleteStudent.action";
				document.forms[0].submit();	
		    }
		}
		
function toStudentEdit(studentid){
                document.getElementById("studentid").value = studentid;
				document.forms[0].action = "ToStudentEdit.action";
				document.forms[0].submit();	
		}
		
function importStudent(){
				document.forms[0].action = "ImportStudent.action";
				document.forms[0].submit();	
		}
   function checkbox1(obj,param){
      if(obj.checked){
    	$("#check_box2"+param).attr("disabled","disabled");
     }else{
    	 $("#check_box2"+param).removeAttr("disabled");
     } 
   }
   function checkbox3(obj,param){
	     if(obj.checked){
	      $("#check_box2"+param).attr("disabled","disabled");
	     }else{
	      $("#check_box2"+param).removeAttr("disabled");
	     }
	   } 
   
  function checkbox2(obj,param){
        if(obj.checked){
           $("#check_box1"+param).attr("disabled","disabled");
           $("#check_box1"+param).removeAttr("checked");
           $("#check_box3"+param).attr("disabled","disabled");
           $("#check_box3"+param).removeAttr("checked");
           $("#check_box4"+param).attr("disabled","disabled");
           $("#check_box4"+param).removeAttr("checked");
        }else{
        	 $("#check_box1"+param).removeAttr("disabled");
             $("#check_box3"+param).removeAttr("disabled");
             $("#check_box4"+param).removeAttr("disabled");
        }
    } 
  function checkbox4(obj,param){
	   if(obj.checked){
		   $("#check_box2"+param).attr("disabled","disabled"); 
	   }else{
		   $("#check_box2"+param).removeAttr("disabled");
	   }
  }
		
function doKaoqin(){

       var str = document.getElementsByName("check_box1");
		var objarray = str.length;
		var chestr = "";
		for ( var i = 0; i < objarray; i++) {//牛图库JS特效，http://js.niutuku.com/
			if (str[i].checked == true) {
				chestr += str[i].value + ",";
				
			}
		}
		
		var str = document.getElementsByName("check_box2");
		var objarray1 = str.length;
		var chestr2 = "";
		for (var i = 0; i < objarray1; i++) {//牛图库JS特效，http://js.niutuku.com/
			if (str[i].checked == true) {
				chestr2 += str[i].value + ",";
				
			}
		}//牛图库JS特效，http://js.niutuku.com/
	   var str = document.getElementsByName("check_box3");
		var objarray2 = str.length;
		var chestr3 = "";
		for (var i = 0; i < objarray2; i++) {//牛图库JS特效，http://js.niutuku.com/
			if (str[i].checked == true) {
				chestr3 += str[i].value + ",";
				
			}
		} 
		
		var str=document.getElementsByName("check_box4");
		var objarray4 = str.length;
		var chestr4="";
		for(var i=0;i<objarray4;i++){
			if(str[i].checked==true){
				chestr4 += str[i].value + ",";	
			}
		}
		
		
		if (chestr == "" &&  chestr2 == "" && chestr3==""  && chestr4=="") {
			alert("至少选择一个学生～！");
			return false;
		 }
				document.forms[0].action = "DoKaoqin.action";
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