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
	
	
</head>
<body class="page-body">
<form enctype="multipart/form-data" method="post">
	<div class="copyrights"></div>
	<div class="page-container">
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
								<div class="fontawesome-icon-list">
									<div class="fa-hover"><i class="fa fa-plus-square" onclick="toKechengAdd()"></i> <span>增加课程表记录</span></div>
								</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			
			 <div class="panel panel-default" style="min-height:700px">
				<div class="panel-heading">
					<h3 class="panel-title">课程数据管理</h3>
				<select id="version" name="version" style="float:right;margin-top:-5px"; onchange="check();">
				     <c:forEach items="${kechengversionList }" var="kechengversion">
					 <option value="${kechengversion.id }" ${sa==kechengversion.id?'selected':'' }>--${kechengversion.vid }--</option>
			         </c:forEach>
				</select> 
				<h3 class="panel-title" style="float:right">版本号:&nbsp;&nbsp;</h3>
				</div>
				<div class="panel-body" style="overflow:scroll;width:100%;height:500px;z-index:-100;" >
					<table class="table table-bordered table-striped" id="example-2" style="width:1500px;margin-top:-20px;z-index:-100;">
						<thead>
							<tr>
								<th>ID</th>
								<th>年级</th>
								<th>班级</th>
								<th>课程</th>
								<th>星期</th>
								<th>上课时间</th>
								<th>下课时间</th>
								<th>任课老师</th>
								<th>校区</th>
								<th>教室</th>
								<th>教学周</th>
								<th>操作</th>
							</tr>
						</thead>
						
						<tbody class="middle-align" id="middle-align">
						  <c:forEach items="${kechengList}" var="kecheng" varStatus="status"> 
							<tr>
								<td>${kecheng.id}</td>
								<td>${kecheng.grade}</td>
								<td>${kecheng.classname}</td>
								<td>${kecheng.subjectname}</td>
								<td>${kecheng.weekday}</td>
								<td>${kecheng.starttime}</td>
								<td>${kecheng.endtime}</td>
								<td>${kecheng.teacher}</td>
								<td>${kecheng.campus}</td>
								<td>${kecheng.classroom}</td>
								<td>${kecheng.week}</td>
								<td>
									<a href="javascript:deleteKecheng('${kecheng.id}');" class="btn btn-secondary btn-sm btn-icon icon-left">
										删除
									</a>
								</td>
							</tr>
							 </c:forEach> 
							
						</tbody>
					</table>
					
				</div><br><br><br>
				<div style="float:left; margin-right:30px;" >
			   版本号:
			<select id="reversion" name="reversion"; onchange="checkversion();">
		     <c:forEach items="${kechengversionList }" var="kechengversion">
			    <option value="${kechengversion.id }" ${sa==kechengversion.id?'selected':'' }>--${kechengversion.vid }--</option>
			 </c:forEach>
		   </select>
		   </div>
			<div style="float:left;"><table><tr><td width=150>请选择要导入的文件:</td><td width=150><input type="file" name="upload"></td>
			<td width=150>(文件格式为*.xls)</td>
			<td width=150><input type="button" name="button1" value="课程数据导入" onclick="importKecheng();"></td>
			<td>
			 
			 
			</td>
			</tr></table></div>
			</div> 
		 <div>
			
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
	 <input type="hidden" name="kechengid" id="kechengid" value=""/>
	 <input type="hidden" name="reversion" id="reversion"/> 
	 <input type="hidden" name="versions" id="versions"/> 
</form>
</body>
<script type="text/javascript">
      
    
    
	   function check(){
        var version=$("#version").val();
       // $("#versions").val(version);
        var content=""
        if(version!=""){
         $.post("GetVersionKecheng.action",{version:version},
           function(data){
              if(data!=null){
                $("#middle-align").empty();
                for(var i=0;i<data.length;i++){
                content+="<tr><td>"+data[i].id+"</td><td>"+data[i].grade+"</td>";
                content+="<td>"+data[i].classname+"</td><td>"+data[i].subjectname+"</td>";
                content+="<td>"+data[i].weekday+"</td><td>"+data[i].starttime+"</td>";
                content+="<td>"+data[i].endtime+"</td><td>"+data[i].teacher+"</td>";
                content+="<td>"+data[i].campus+"</td><td>"+data[i].classroom+"</td>";
                content+="<td>"+data[i].week+"</td>";
                content+="<td><a href='javascript:deleteKecheng("+data[i].id+")' class='btn btn-secondary btn-sm btn-icon icon-left'>删除</a></td></tr>";
             }
              $("#middle-align").append(content);
            
            }
           }
         );                    
         
      }
	}
 
 function checkversion(){
     var reversion=$("#reversion").val();
       $("#reversion").val(reversion);     
 }


 function toKechengAdd(){
                 //var reversion=$("#reversion").val();
                 //$("#versions").val(reversion);
                  var version=$("#version").val();
                  $("#versions").val(version);
				document.forms[0].action = "ToKechengAdd.action";
				document.forms[0].submit();	
		}
		 
function importKecheng(){
                var upload=$("input[name='upload']").val();
                if(upload==""){
                  alert("请选择导入的课程Excel表");
                  return;
                }
				document.forms[0].action = "ImportKecheng.action";
				document.forms[0].submit();	
		}
function deleteKecheng(kechengid){
         if (confirm("您确定要删除吗?")){
                 var version=$("#version").val();
                 $("#versions").val(version);
                document.getElementById("kechengid").value = kechengid;
				document.forms[0].action = "DeleteKecheng.action";
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