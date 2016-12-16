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
.form-horizontal .control-label,table.gridtable {
    float: left;
}
</style>
	
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
							<h3 class="panel-title">发送新通知</h3>
							
						</div>
						<div class="panel-body">
							
							<form role="form" class="form-horizontal">
								<div class="form-group">
									<label class="col-sm-2 control-label">通知名称</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="title" name="title">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">通知内容</label>
									
									<div class="col-sm-10">
										<textarea class="form-control" id="content" name="content"></textarea>
									</div>
								</div>
								
								<c:if test="${tuser.userType == 3 ||tuser.userType == 5 || tuser.userType==4}">
								<label class="col-sm-2 control-label"> 通知所有人</label>
								<input type="checkbox" id="allpeople" name="allpeople"   onclick="allpeoples(this)" >
								<div class="form-group-separator"></div>
								<label class="col-sm-2 control-label">通知班级</label>
								   <table class="gridtable">
									<tr>
										<th><input type="checkbox"  id="setclassall"  onclick="setclassAll()">全选</th>
										<th>班级名称</th>
									</tr>
									  <c:forEach items="${classList }" var ="clas1">
									<tr>
										<td><input type="checkbox" name="setclassallbox" value="${clas1.id}"></td>
										<td>${clas1.name }</td>
									</tr>
										</c:forEach>			
									</table>									
								 <label class="col-sm-2 control-label">通知老师</label>
								  <table class="gridtable">
									<tr>
										<th><input type="checkbox" id="setteacherall"  onclick="setteacherAll()">全选</th>
										<th>任课老师</th>					
									</tr>
									  <c:forEach items="${teacherList }" var="teacher">
									 <tr>
										<td><input type="checkbox" name="setteacherallbox" value="${teacher.id}"></td>
										<td>${teacher.name}</td>
									</tr>
										</c:forEach>
									</table>
									<label class="col-sm-2 control-label">辅导员</label>
									<table class="gridtable">
									<tr>	
										<th><input type="checkbox" id="setassistantall"  onclick="setassistantAll()">全选</th>
										<th>辅导员</th>
									</tr>
										<c:forEach items="${assistantList}" var="assistant">
									<tr>
										<td><input type="checkbox" name="setassistantallbox" value="${assistant.id}"></td>
										<td>${assistant.name}</td>
									</tr>
										</c:forEach>
									</table>
								<!-- <div class="form-group-separator"></div> -->
								</c:if>
								<c:if test="${tuser.userType==6}">
								   <label class="col-sm-2 control-label">通知班级</label>
								   <table class="gridtable">
									<tr>
										<th><input type="checkbox"  id="setclassall"  onclick="setclassAll()">全选</th>
										<th>班级名称</th>
									</tr>
									  <c:forEach items="${tclassList}" var ="clas1">
									<tr>
										<td><input type="checkbox" name="setclassallbox" value="${clas1.id}"></td>
										<td>${clas1.name }</td>
									</tr>
										</c:forEach>			
									</table>	
								</c:if>
								<c:if test="${tuser.userType==7}">
								   <label class="col-sm-2 control-label">通知班级</label>
								   <table class="gridtable">
									<tr>
										<th><input type="checkbox"  id="setclassall"  onclick="setclassAll()">全选</th>
										<th>班级名称</th>
									</tr>
									  <c:forEach items="${list }" var ="clas1">
									<tr>
										<td><input type="checkbox" name="setclassallbox" value="${clas1.id}"></td>
										<td>${clas1.name }</td>
									</tr>
										</c:forEach>			
									</table>	
								</c:if>
								
								<div class="form-group-separator" style="clear:both;"></div>
								<div class="form-group">
									<div class="col-sm-10">
									    <input type="button" class="form-control" style="margin-left:200px;width:80px;background:#e4393c;color:white;" value="返回" onclick="javascript:history.go(-1);">
										<input type="button" class="form-control" style="margin-left:700px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="保存" onclick="doNoticeAdd();">
									</div>
								</div>
								
								<input type="hidden" name="checkboxall" id="checkboxall" value="">
								<input type="hidden" name="assistantid" id="assistantid" value="">
								<input type="hidden" name="classid" id="classid" value="">
								<input type="hidden" name="teacherid" id="teacherid" value="">
							</form>
						</div>
					</div>
					
				</div>
			</div>
			<footer class="main-footer sticky footer-type-1">			
				<div class="footer-inner">
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
    function allpeoples(obj){
        if(obj.checked){//
           $("#checkboxall").val(1);
           $("#setclassall").attr("disabled","disabled");
           $("input[name=setclassallbox]").attr("disabled","disabled");
           $("#setteacherall").attr("disabled","disabled");
           $("input[name=setteacherallbox]").attr("disabled","disabled");
           $("#setassistantall").attr("disabled","disabled");
           $("input[name=setassistantallbox]").attr("disabled","disabled");
        }else{
           $("#checkboxall").val("");
           $("#setclassall").removeAttr("disabled");
           $("input[name=setclassallbox]").removeAttr("disabled");
           $("#setteacherall").removeAttr("disabled");
           $("input[name=setteacherallbox]").removeAttr("disabled");
           $("#setassistantall").removeAttr("disabled");
           $("input[name=setassistantallbox]").removeAttr("disabled");
        }
    }
   
    function setclassAll(){
      var dom=document.getElementById("setclassall");
      var doms=document.getElementsByName("setclassallbox");
      for(var i=0;i<doms.length;i++){
        doms[i].checked=dom.checked;
      }
    } 
    function setassistantAll(){
      var dom=document.getElementById("setassistantall");
      var doms=document.getElementsByName("setassistantallbox");
      for(var i=0;i<doms.length;i++){
        doms[i].checked=dom.checked;
      }
    } 
    function setteacherAll(){
      var dom=document.getElementById("setteacherall");
      var doms=document.getElementsByName("setteacherallbox");
      for(var i=0;i<doms.length;i++){
        doms[i].checked=dom.checked;
      }
    }
	function doNoticeAdd() {
		var title = document.getElementById("title").value;
		if(null == title || title == '')
		{
			alert('通知名称不能为空！');
			return false;
		}
		var content = document.getElementById("content").value;
		if(null == content || content == '')
		{
			alert('通知内容不能为空！');
			return false;
		}
		
		var usertype = ${tuser.userType};
		if(usertype == 3 ||usertype == 4||usertype == 5 ){
		    var str = document.getElementsByName("setassistantallbox");
		    var objarray = str.length;
		    var chestr = "";
		for (i = 0; i < objarray; i++) {//牛图库JS特效，http://js.niutuku.com/
			if (str[i].checked == true) {
				chestr += str[i].value + ",";
			}
		}//牛图库JS特效，http://js.niutuku.com/
		document.getElementById("assistantid").value = chestr;
		    var str = document.getElementsByName("setclassallbox");
		    var objarray = str.length;
		    var chestr = "";
		for (i = 0; i < objarray; i++) {
			if (str[i].checked == true) {
				chestr += str[i].value + ",";
			}
		}
		document.getElementById("classid").value = chestr;
		
		 var str = document.getElementsByName("setteacherallbox");
		    var objarray = str.length;
		    var chestr = "";
		for (i = 0; i < objarray; i++) {
			if (str[i].checked == true) {
				chestr += str[i].value + ",";
			}
		}
		document.getElementById("teacherid").value = chestr;
		var peopleall=document.getElementById("checkboxall").value;
		var classall=document.getElementById("classid").value;
		var teacherall=document.getElementById("teacherid").value;
		var assistant=document.getElementById("assistantid").value;
		if(peopleall=="" && assistant=="" && classall=="" && teacherall==""){
		    alert("请选择要通知的人!")
		    return false;    
		}
		if(peopleall!=""){
		   if(assistant!=""|| classall!=""|| teacherall!=""){
		    alert("选择通知所有人无需再选择其他类型!")
		    return false;
		    }
		}
	}	
	if(usertype==6 || usertype==7){
		    var str = document.getElementsByName("setclassallbox");
		    var objarray = str.length;
		    var chestr = "";
		for (i = 0; i < objarray; i++) {
			if (str[i].checked == true) {
				chestr += str[i].value + ",";
			}
		}
		if (chestr == "") {
			alert("至少选择一个班级!");
			return false;
		} 
		document.getElementById("classid").value = chestr;
	}
        alert('发布新通知成功');
		document.forms[0].action = "DoNoticeAdd.action";
		$("#field-6").attr("disabled","disabled");
		document.forms[0].submit();
	}
</script>
</html>









