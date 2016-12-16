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
	<div class="page-container">
	<div class="sidebar-menu-inner" style="display:none;">
		<div class="sidebar-menu-inner" style="display:none;">				
			<header class="logo-env">
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
						<h3 class="panel-title">课程版本修改</h3>
					</div>
					<div class="panel-body">
						
						<form role="form" class="form-horizontal">
					
							<div class="form-group">
						
								<label class="col-sm-2 control-label">通知类型:</label>
								<div class="col-sm-10">	
								
								    <c:if test="${notice.noticetype==1 }">
									 <input type="text" class="form-control" name="noticetype" id="noticetype" value="教务通知" readonly="readonly"/>  
									 <input type="hidden"  name="noticeType" id="noticeType" value="1"/>  
									 </c:if>
								    <c:if test="${notice.noticetype==2 }">
									 <input type="text" class="form-control" name="noticetype" id="noticetype" value="辅导员通知" readonly="readonly"/>  
									 <input type="hidden"  name="noticeType" id="noticeType" value="2"/>  
									 </c:if>
								    <c:if test="${notice.noticetype==3 }">
									 <input type="text" class="form-control" name="noticetype" id="noticetype" value="教师通知" readonly="readonly"/> 
									 <input type="hidden"  name="noticeType" id="noticeType" value="3"/>   
									 </c:if>
								    <c:if test="${notice.noticetype==4 }">
									 <input type="text" class="form-control" name="noticetype" id="noticetype" value=" 系统通知" readonly="readonly"/> 
									 <input type="hidden"  name="noticeType" id="noticeType" value="4"/>   
									 </c:if>
								</div>
								   
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" >发布人:</label>
								<div class="col-sm-10">
								   <input type="text" class="form-control" name="noticeusername" id="noticeusername" value="${notice.username}" readonly="true" />   
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" >发布日期:</label>
								<div class="col-sm-10">
								   <input type="text" class="form-control" name="noticepublishdate" id="noticepublishdate" value="${notice.publishdate}" readonly="true" />   
								</div>
							</div>
						<c:if test="${notice.type==1}">
							<div class="form-group">
							 <label class="col-sm-2 control-label">通知所有人</label>
							 <input type="checkbox" id="setpeopleallbox" name="setpeopleallbox"  value="${notice.userid }" style="margin-left:15px" checked="checked"/>
							</div>
						</c:if>
						 <c:if test="${notice.type==2 }">
							<div class="form-group">
							 <label class="col-sm-2 control-label">通知老师</label>
							 <table class="gridtable" style="margin-left:15px">
								<tr>
									<th><input type="checkbox" id="setteacherall"  onclick="setteacherAll()" checked="checked">全选</th>
									<th>任课老师</th>					
								</tr>
								  <c:forEach items="${teach}" var="teacher">
								 <tr>
									<td>
									<input type="checkbox" name="setteacherallbox"  value="${teacher.id}" checked="checked"></td>
									<td>${teacher.name}</td>
								</tr>
									</c:forEach>
								</table>
								</div>
							</c:if>
						 <c:if test="${notice.type==3 }">
							<div class="form-group">
							 <label class="col-sm-2 control-label">通知辅导员</label>
							 <table class="gridtable" style="margin-left:15px">
								<tr>
									<th><input type="checkbox" id="setassistantall"  onclick="setassistantAll()" checked="checked">全选</th>
									<th>辅导员</th>					
								</tr>
								  <c:forEach items="${assist}" var="assistant">
								 <tr>
									<td>
									<input type="checkbox" name="setassistantallbox"  value="${assistant.id}" checked="checked"></td>
									<td>${assistant.name}</td>
								</tr>
									</c:forEach>
								</table>
								</div>
							</c:if>
							<c:if test="${notice.type==4}">
							<div class="form-group">
							<label class="col-sm-2 control-label">通知班级</label>
							 <table class="gridtable" style="margin-left:15px">
							    <tr>
									<th><input type="checkbox" id="setclassall"  onclick="setclassAll()" checked="checked">全选</th>
									<th>班级名称</th>					
								</tr>
								<tr>
									<td>
									<input type="checkbox" name="setclassallbox"  value="${tclass.id}" checked="checked"></td>
									<td>${tclass.name}</td>
								</tr>
							 </table>
							</div>
							</c:if>
							<div class="form-group-separator"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label"  >通知标题:</label>								
								<div class="col-sm-10"> 
									<input type="text"  class="form-control" name="noticetitle" id="noticetitle" value="${notice.title }"/>			
								</div> 
							</div>							
							<div class="form-group-separator"></div>
							<div class="form-group">
								<label class="col-sm-2 control-label">通知内容:</label>
								<div class="col-sm-10">
								  <textarea rows="10" cols="40" name="noticecontent" id="noticecontent">${notice.content }</textarea>
								</div>
							</div>
						        <input type="hidden" name="id" id="id" value="${notice.id}">
							    <input type="hidden" name="type" id="type" value="${notice.type}">
							    <input type="hidden" name="classid" id="classid" value="${notice.classid}">
							    <input type="hidden" name="publisherid" id="publisherid" value="${notice.publisherid}">
							    <input type="hidden" name="readstatus" id="readstatus" value="${notice.readstatus}">
							    <input type="hidden" name="status" id="status" value="${notice.status}">
							    <input type="hidden" name="teacherid" id="teacherid" value="">
							    <input type="hidden" name="assistantid" id="assistantid" value="">
							<div class="form-group-separator"></div>
							<div class="form-group">
								<div class="col-sm-10">
								    <input type="button" class="form-control" style="margin-left:300px;width:80px;background:#e4393c;color:white;" value="返回" onclick="javascript:history.go(-1);">
									<input type="button" class="form-control" style="margin-left:600px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="修改" onclick="updateNotice();">
								</div>
							</div>		
							<div class="form-group-separator"></div>
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
  var type=${notice.type};
  if(type!="" && type==2){
   function setteacherAll(){
    var dom=document.getElementById("setteacherall");
    var doms=document.getElementsByName("setteacherallbox");
    for(var i=0;i<doms.length;i++){
       doms[i].checked=dom.checked;
       }
    } 
  }
 function setassistantAll(){
  var dom=document.getElementById("setassistantall");
  var doms=document.getElementsByName("setassistantallbox");
   for(var i=0;i<doms.length;i++){
    doms[i].checked=dom.checked;
   }
 }     
function setclassAll(){
  var dom=document.getElementById("setclassall");
  var doms=document.getElementsByName("setclassallbox");
  for(var i=0;i<doms.length;i++){
     doms[i].checked=dom.checked;
  }
}
function updateNotice() { 
    var noticetitle = document.getElementById("noticetitle").value;
	 if(null == noticetitle || noticetitle == ''){
			alert('通知标题不能为空!');
			return false;
		} 
	var noticecontent = document.getElementById("noticecontent").value;
	 if(null == noticecontent || noticecontent == ''){
			alert('通知内容不能为空！');
			return false;
		}
	
  if(confirm("你确定要修改吗")){
      if(type!="" && type==1){
	   var setpeopleallbox=document.getElementById("setpeopleallbox");
	   if(setpeopleallbox.checked==true){
	   //alert("11");
	      $("#setpeopleallbox").val(0);
	   }else{
	  // alert("22");
	      $("#setpeopleallbox").val("");
	   }
	    if(setpeopleallbox.value==""){
	      alert("通知所有人不能为空!");
	       return false;
	    }
	}
       if(type!="" && type==2){
		var str=document.getElementsByName("setteacherallbox");
		var chestr="";
		for(var i=0;i<str.length;i++){
		    if(str[i].checked==true){
		       chestr += str[i].value + ",";
		    }
		 } 
		 if(chestr==""){
		   alert("请至少选择一个任课老师!");
		   return false;
		 }
		 document.getElementById("teacherid").value=chestr;
       }
       if(type!="" && type==3){
		 var str=document.getElementsByName("setassistantallbox");
		 var chestr="";
		 for(var i=0;i<str.length;i++){
		   if(str[i].checked==true){
		      chestr+=str[i].value+",";
		   }
	    }
		 if(chestr==""){
		   alert("请至少选择一个辅导员!");
		  return false;
		 }
		 document.getElementById("assistantid").value=chestr;
        }
        if(type!="" && type==4){
           var str=document.getElementsByName("setclassallbox");
           var chestr="";
           for( var i=0;i<str.length;i++){
              if(str[i].checked==true){
                chestr+=str[i].value+",";
              }
           }
           if(chestr==""){
             alert("通知班级不能为空!");
             return false;
           }
        }
		 document.forms[0].action = "DoNoticeUpdate.action";
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