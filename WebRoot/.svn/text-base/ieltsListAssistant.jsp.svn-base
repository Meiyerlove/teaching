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
<form>
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
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">雅思成绩管理</h3>
				</div>	
				 <div class="panel-body">
					<table class="table table-bordered table-striped" id="example-2">
						<thead>
							<tr>
								<th>序号</th>
								<th>学生号</th>
								<th>姓名</th>
								<th>班级</th>
								<th>听</th>
								<th>说</th>
								<th>读</th>
								<th>写</th>
								<th>总分</th>
								<th>账号</th>
								<th>密码</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						
						<tbody class="middle-align">
						  <c:forEach items="${ieltsList}" var="ielts" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td>${ielts.sid}</td>
								<td>${ielts.student.name}</td>
								<td>${ielts.tclass}</td>
								<td>${ielts.listening}</td>
								<td>${ielts.speaking}</td>
								<td>${ielts.reading}</td>
								<td>${ielts.writing}</td>
								<td>${ielts.total}</td>
								<td>${ielts.account}</td>
								<td>${ielts.password}</td>
								<td>
								   <c:if test="${ielts.status == 1}">
								      未审核
								   </c:if>
								   <c:if test="${ielts.status == 2}">
								      通过审核
								   </c:if>
								</td>
								<td>
								  <c:if test="${ielts.status == 1}">
								    <a href="javascript:checkIelts('${ielts.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										审核
									</a>
									<a href="javascript:modifyStudentInfo('${ielts.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										修改
									</a>
								  </c:if>
								  <c:if test="${ielts.status != 1}">
									<a href="javascript:modifyStudentInfo('${ielts.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										修改
									</a>
								  </c:if>
								</td>
								
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<div id="hiddenDiv" style="display:none;">
							<div style="width:20%;height:240px;float:left;">
								学号：<input type="text" id="sid" name="sid"  readonly/><br/><br/>
								姓名：<input type="text"  id="sname" name="sname" readonly/><br/><br/>
								班级：<input type="text" id="sclassname" name="sclassname" readonly/><br/><br/>							
								账号：<input type="text" id="szhanghao" name="szhanghao" readonly/><br/><br/>
								密码：<input type="text" id="spassword" name="spassword" readonly/><br/><br/>
								<input type="button" value="保存" style="margin-left:85px;" onclick="save();"><br/><br/>
							</div>
							<div style="width:20%;height:240px;float:right;margin-right:60%;">
								听：<input type="text" id="slistening" name="slistening" style="outline:none;margin-left:13px;"/><br/><br/>
								说：<input type="text" id="ssay" name="ssay" style="outline:none;margin-left:13px;"/><br/><br/>
								读：<input type="text" id="sread" name="sread" style="outline:none;margin-left:13px;"/><br/><br/>
								写：<input type="text" id="swrite" name="swrite" style="outline:none;margin-left:13px;"/><br/><br/>
								总分：<input type="text" id="sscore" name="sscore" style="outline:none;"/><br/><br/>
								<input type="button" value="取消" style="margin-left:85px;" onclick="cancel();"/><br/><br/>
							</div>
					</div>
					<div style="width:100%;height:35px;float:left;"></div>
					<div>
						<table>
							<tr>
								<td width=150>导出所有未审核的成绩:</td>
								<td width=150><input type="button" name="button" value="导出" onclick="exportExcel();"></td>
								<td width=150>(文件格式为*.xlsx)</td>
							</tr>
						</table>
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
	<input type="hidden" name="ieltsid" id="ieltsid" value=""/>
	<input type="hidden" name="ielts" id="ielts" value=""/>
</form>
</body>
<script type="text/javascript">
function toStudentIeltsAdd(){
				document.forms[0].action = "ToStudentIeltsAdd.action";
				document.forms[0].submit();	
		}
		
function toRoleEdit(roleid){
                document.getElementById("roleid").value = roleid;
				document.forms[0].action = "ToRoleEdit.action";
				document.forms[0].submit();	
		}
function checkIelts(ieltsid){
                document.getElementById("ieltsid").value = ieltsid;
				document.forms[0].action = "DoCheckIelts.action";
				document.forms[0].submit();	
		}
function cancel(){
                //$("#hiddenDiv").css("display","none");
                $("#hiddenDiv").fadeOut(1000);
		}	
function save(){
              	document.forms[0].action = "SaveStudentItelsInfo.action";
				document.forms[0].submit();	
		}			
function modifyStudentInfo(ieltsid){
                $.post("FindIeltsInfoById.action",{ieltsid:ieltsid},
                function(data){
                	if(null!=data){
                		//$("#hiddenDiv").css("display","block");
                		$("#hiddenDiv").fadeIn(1000);
                		$("#ielts").val(data.id);
                		$("#sid").val(data.sid);
                		$("#sname").val(data.sname);
                		$("#sclassname").val(data.tclass);
                		$("#slistening").val(data.listening);
                		$("#ssay").val(data.speaking);
                		$("#sread").val(data.reading);
                		$("#swrite").val(data.writing);
                		$("#sscore").val(data.total);
                		$("#szhanghao").val(data.account);
                		$("#spassword").val(data.password);
                	}
                }
                );	
		}
function exportExcel(){
				$.post("ExportExcel.action",
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
function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].submit();
			}	
		}
</script>
</html>