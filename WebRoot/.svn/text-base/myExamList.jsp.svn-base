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
	<style type="text/css">
     th strong {display:block;}
     tr strong {white-space:nowrap;overflow:hidden;}
     td.conter{text-align: center; height:40px}
     #example-2{padding:0px;margin:0px}
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
			
			<%-- <s:if test="hasActionErrors()||hasActionMessages()">
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
									${message}
										<s:actionerror />
										<s:actionmessage />
									</span>
								</td>
							</tr>
						</table>
					</div>
			</s:if> --%>
			<c:if test="${not empty message}">
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
										${message}
									</span>
								</td>
							</tr>
						</table>
					</div>
				</c:if>
			<div class="row">
				<div class="col-md-9">	
					<div class="tocify-content">
						<div class="icon-collection">
							<section id="web-application">
								<div class="fontawesome-icon-list">
									
								</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default" style="min-height:600px;">
				<div class="panel-heading">
					<h3 class="panel-title">学生成绩查看</h3>
				</div>
		    <c:if test="${tuser.userType==6}">
		    <div style="margin-top:17px;height:80px;">
				 <div style="float:left;margin-right:16px;">筛选条件</div>
				 <div class="classname" style="float:left;margin-right:20px;">班级名称:
			           <select id="classid" name="classid">
			              <option value="">---</option>
			            <c:forEach items="${tclassList_}" var="tclass">
			              <option value="${tclass.id}" ${tc==tclass.id?'selected':'' }>${tclass.name}</option>
			            </c:forEach>  
			           </select>
			    </div> 
			       <div class="titlename" style="float:left;margin-right:20px;">考试名称:
                     <select id="title" name="title">
			               <option value="">---</option>
			             <c:forEach items="${scorenewlist}" var="score">
			                <option value="${score.title}" ${sc==score.title?'selected':'' }>${score.title}</option>
			             </c:forEach>
			         </select>
			      </div>
			      <div>导出ABS/Resit/DISQ成绩:
			         <input type="button" id="button" name="button" value="导出" onclick="exportExcel()";/>&nbsp;&nbsp;&nbsp;&nbsp;
			         <span width="150">(文件格式为*.xls)</span>
			      </div>
			      </div>
				<div class="panel-body" style="overflow: scroll;width:100%;height:700px;">
					<table class="table table-bordered table-striped" id="example-2" style="width:1000px;">
						<thead>
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>班级</th>
								<th>通过门数</th>
								<th>操作</th>
							</tr>
						</thead>
						
						<tbody class="middle-align">
						  <c:forEach items="${studentList}" var="student" varStatus="status">
							<tr>
								<td>${student.sid}</td>
								<td>${student.name}</td>
								<td>
								 <c:if test="${student.sex==1}">
								   男
								 </c:if>
								 <c:if test="${student.sex==2}">
								   女
								 </c:if>
								</td>
								<td>${student.classname}</td>
								<td>${student.count}</td>
								<td>
									<a href="javascript:checkStudentScore('${student.sid}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										查看成绩
									</a>
									
									<a href="javascript:checkClassScore('${student.classId}');" class="btn btn-secondary btn-sm btn-icon icon-left">
									   查看班级成绩
									</a>
								</td>
							</tr>
							</c:forEach>
							
						</tbody>
					</table>			
				</div>
			</c:if>
			<c:if test="${tuser.userType==7}">
			 <div>筛选条件</div>
				 <div class="classname" style="float:left;margin-right:20px;">班级名称:
			           <select id="classId" name="classId">
			              <option value="">---</option>
			            <c:forEach items="${tclasslist}" var="tclass">
			              <option value="${tclass.id}" ${tcl==tclass.id?'selected':'' }>${tclass.name}</option>
			            </c:forEach>  
			           </select>
			           
			    </div> 
			       <div class="subjectname" style="float:left;margin-right:20px;">科目名称:
                     <select id="subject" name="subject">
			               <option value="">---</option>
			             <c:forEach items="${subjectlist}" var="sub">
			                <option value="${sub}" ${sb==sub?'selected':'' }>${sub}</option>
			             </c:forEach>
			         </select>
			        <input type="button" name="query" id="query" value="查询" onclick="queryclasssubject()"/>
			      </div>&nbsp;&nbsp;&nbsp;&nbsp;
			    <div style="float:left; margin-left:100px;">导出成绩:
			         <input type="button" id="button" name="button" value="导出" onclick="exportExcelResult()";/>&nbsp;&nbsp;&nbsp;&nbsp;
			         <span width="150">(文件格式为*.xls)</span>
			    </div><br/>
			   <div class="panel-body" style="overflow: scroll;width:100%;height:700px;">
					<table class="table table-bordered table-striped" id="example-2" style="width:1640px;">
						<thead>
							<tr>
								<th>班级名称</th>
								<th>学生ID</th>
								<th>学生姓名</th>
								<th>科目</th>
								<th>阶段</th>
								<th>正考</th>
								<th>正考-补做</th>					
								<th>正考-补考</th>
								<th>正考-补考-补做</th>
								<th>重修</th>
								<th>重修-补做</th>
								<th>毕前考</th>
								<th>毕前-补做</th>
								<th>其它</th>
								<th>其它补做</th>
							</tr>
						</thead>
						
						<tbody class="middle-align">
						  <c:forEach items="${_list}" var="scorenew" varStatus="status">
							<tr>
								<td>${scorenew.classname}</td>
								<td>${scorenew.studentid}</td>
								<td>${scorenew.studentname}</td>
								<td>${scorenew.subjectname} &nbsp;&nbsp;&nbsp;(${scorenew.totalresult})</td>
								<td>${scorenew.phase}</td>
								<td>${scorenew.zkresult }</td>	 
								<td>${scorenew.zkbzresult }</td>	 
								<td>${scorenew.zkbkresult }</td>	 
								<td>${scorenew.zkbkbzresult }</td>	 
								<td>${scorenew.cxresult }</td>	 
								<td>${scorenew.cxbzresult }</td>	 
								<td>${scorenew.bqkresult }</td>	 
								<td>${scorenew.bqkbzresult }</td>	 
								<td>${scorenew.qtresult }</td>	 
								<td>${scorenew.qtbzresult }</td>	 
							</tr>
							</c:forEach>						
						</tbody>
					</table>			
				</div>
			</c:if>
            <c:if test="${tuser.userType==3 || tuser.userType==4 || tuser.userType==5 }">
             <div style="float:left;margin-left:20px;margin-right:20px;">筛选条件:</div>
				 <div class="classname" style="float:left;margin-right:20px;">班级名称:
			           <select id="classId" name="classId">
			              <option value="">---</option>
			            <c:forEach items="${tclasslist}" var="tclass">
			              <option value="${tclass.id}" ${tcl==tclass.id?'selected':'' }>${tclass.name}</option>
			            </c:forEach>  
			           </select>
			    </div> 
			       <div class="subjectname" style="float:left;margin-right:20px;">科目名称:
                     <select id="subject" name="subject" style="width:180px;white-space:nowrap;">
			               <option value="">---</option>
			             <c:forEach items="${subjectlist}" var="subject">
			                <option value="${subject.name}" ${sb==subject.name?'selected':'' }>${subject.name}</option>
			             </c:forEach>
			         </select>
			        <input type="button" name="query" id="query" value="查询" onclick="queryclasssubject()"/>
			      </div>&nbsp;&nbsp;&nbsp;&nbsp;
			    <div style="float:left; margin-left:20px;">导出成绩:
			         <input type="button" id="button" name="button" value="导出" onclick="exportExcelClassResult()";/>&nbsp;&nbsp;&nbsp;&nbsp;
			         <span width="150">(文件格式为*.xls)</span>
			    </div><br/>
		    <div class="panel panel-default" style="margin-top:10px;">
			     <div style="overflow:scroll; height: 400px; margin:auto;"align="left">
				 <!--  <div class="panel-body"> -->
			       <table class=" table-bordered table-striped" id="example-2"  height="100px" align="center" border="1" cellspacing="0" cellpadding="0">
						 ${navCode}
						 ${conter}
                    </table>
                   </div>
				<!-- </div> -->
			</div>
			</c:if>
			</div>
			 
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
	<input type="hidden" name="classId" id="classId" value=""/>
	<input type="hidden" name="param" id="param" value=""/>
	<input type="hidden" name="examid" id="examid" value=""/>
	<input type="hidden" name="subjectName" id="subjectName" value=""/>
</form>
</body>
<script type="text/javascript">

  function exportExcelClassResult(){
       $.post("ExportExcelAllClassResult.action",{tclassid:$("#classId").val(),subject:$("#subject").val()},  
         function(data){
		 var obj=eval("("+data+")");
		  if(!obj.bol){
			alert(decodeURI(obj.message));
			}else{
				alert("导出成功");			
				window.location.href="DownloadExcel.action?content="+decodeURI(obj.message);							
			}
        });
  }
 
 


 function checkStudentScore(sid){
    $("#param").val(0);
    document.getElementById("studentid").value=sid;
    document.forms[0].action = "CheckStudentScore.action";
    document.forms[0].submit();	
}
function checkClassScore(classId){
   document.getElementById("classId").value=classId;
   document.forms[0].action="CheckClassScore.action";
   document.forms[0].submit();
}

function exportExcel(){
   var classid=document.getElementById("classid").value;
   var title=document.getElementById("title").value;
   if(classid==''){
    alert("班级不能为空!");
    return false;
   }
   if(title==''){
    alert("考试名称不能为空!");
    return false;
   }
  $.post("ExportExcelScore.action",{classid:classid,title:title},
				function(data){
				var obj=eval("("+data+")");
					if(!obj.bol){
						alert(decodeURI(obj.message));
						}else{
							alert("导出成功");			
							window.location.href="DownloadExcel.action?content="+decodeURI(obj.message);							
							 }
					    }
					  );
                 }	
                 
function queryclasssubject(){
     var classId_=document.getElementById("classId").value;
     $("#classId").val(classId_);
     if(classId_==''){
       alert("班级名称不能为空!");
       return false;
     }
     var subjectname=document.getElementById("subject").value;
     $("#subjectName").val(subjectname);
     if(subjectname==''){
       alert("科目不能为空!");
       return false;
     }
     document.forms[0].action="QueryClassSubject.action";
     document.forms[0].submit();
}	

function exportExcelResult(){
    var classId_=document.getElementById("classId").value;
    var subjectname=document.getElementById("subject").value;
    if(!classId_ || !subjectname){
         alert("请先查询出结果!");
         return false;
    }
    $.post("ExportExcelResult.action",{classId_:classId_,subjectname:subjectname},
       function(data){
          var obj=eval("("+data+")");
					if(!obj.bol){
						alert(decodeURI(obj.message));
						}else{
						   alert("导出成功");			
						   window.location.href="DownloadExcel.action?content="+decodeURI(obj.message);							
			  }
       }
    );
}


function importStudent(){
				document.forms[0].action = "ImportStudent.action";
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