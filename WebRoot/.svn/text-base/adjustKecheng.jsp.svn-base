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
<link rel="stylesheet"
	href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/bootstrap.css">
<link rel="stylesheet" href="assets/css/xenon-core.css">
<link rel="stylesheet" href="assets/css/xenon-forms.css">
<link rel="stylesheet" href="assets/css/xenon-components.css">
<link rel="stylesheet" href="assets/css/xenon-skins.css">
<link rel="stylesheet" href="assets/css/custom.css">

<script src="js/commonnew.js"></script>
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script language="javascript" type="text/javascript"
	src="My97DatePicker/WdatePicker.js"></script>
</head>
<body class="page-body">
	<div class="copyrights"></div>
	<div class="page-container">
		<!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->

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
						<a href="#" data-toggle="user-info-menu"> <i class="fa-bell-o"></i>
							<span class="badge badge-success">7</span>
						</a> <a href="#" data-toggle="mobile-menu"> <i class="fa-bars"></i>
						</a>
					</div>

				</header>



				<ul id="main-menu" class="main-menu">
					<!-- add class "multiple-expanded" to allow multiple submenus to open -->
					<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
					<li class="active opened active">
						<%--<i class="linecons-cog"></i>--%> <span class="title"
						style="color:white">${role.desc}</span>
						<ul>
							<c:forEach items="${menuList}" var="right" varStatus="status">
								<li class="active" style="height:40px;"><a
									href="javascript:to('${right.righturl}');"> <span
										class="title">${right.righttext}</span>
								</a></li>
							</c:forEach>
						</ul>
					</li>
				</ul>

			</div>

		</div>

		<%@include file="common.jsp"%><div
			class="main-content">


			<!-- User Info, Notifications and Menu Bar -->
			<nav class="navbar user-info-navbar" role="navigation">

				<!-- Left links for user info navbar -->
				<ul class="user-info-menu left-links list-inline list-unstyled">

					<li class="hidden-sm hidden-xs"><a href="#"
						data-toggle="sidebar"> <i class="fa-bars"></i>
					</a></li>
				</ul>


				<!-- Right links for user info navbar -->
				<ul class="user-info-menu right-links list-inline list-unstyled">
					<li class="dropdown user-profile"><a href="#"
						data-toggle="dropdown"> <img src="assets/images/user-4.png"
							alt="user-image" class="img-circle img-inline userpic-32"
							width="28" /> <span> ${user} <i class="fa-angle-down"></i>
						</span>
					</a>

						<ul class="dropdown-menu user-profile-menu list-unstyled">
							<li class="last"><a href="javascript:logout();"> <i
									class="fa-lock"></i> 安全退出
							</a></li>
						</ul>

						<ul class="dropdown-menu user-profile-menu list-unstyled">
							<li class="last"><a href="javascript:logout()"> <i
									class="fa-lock"></i> 安全退出
							</a></li>
						</ul></li>

				</ul>

			</nav>

			<s:if test="hasActionErrors()||hasActionMessages()">
				<div id="div-error" style="vertical-align:middle;padding-top:5px;">
					<table width="100%" border="0" cellpadding="0" class="table-a">
						<tr>
							<th>提示信息</th>
						</tr>
						<tr>
							<td height="26" align="center" bgcolor="#d9d9d9"><span
								class="redfont" style="padding-top:5px;"><s:fielderror />
									<s:actionerror /> <s:actionmessage /> </span></td>
						</tr>
					</table>
				</div>
			</s:if>
			<div class="row">
				<div class="col-sm-12">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">课程调整</h3>
							<select id="version" name="version"
								style="float:right;margin-top:-5px" ; onchange="check();">
								<c:forEach items="${kechengversionList }" var="kechengversion">
									<option value="${kechengversion.id }"
										${sa==kechengversion.id?'selected':'' }>--${kechengversion.vid }--</option>
								</c:forEach>
							</select>
							<h3 class="panel-title" style="float:right">版本号:&nbsp;&nbsp;</h3>
						</div>
						<div class="panel-body">

							<form role="form" class="form-horizontal">

								<div class="form-group">
									<label class="col-sm-2 control-label">原课程教室、课程、班级</label>

									<div class="col-sm-10">
										<select class="form-control" name="classrooms" id="classrooms">
											<option value="">--请选择--</option>
											<c:forEach items="${kechengList}" var="kecheng"
												varStatus="status">
												<option value="">${kecheng.classroom}|${ kecheng.subjectname}|${kecheng.classname}|${kecheng.id}</option>
											</c:forEach>

										</select> <input type="hidden" name="classRoom" id="classRoom">
										<input type="hidden" name="classSubject" id="classSubject">
										<input type="hidden" name="className" id="className">
										<input type="hidden" name="kcversions" id="kcversions">
									</div>
								</div>

								<div class="form-group-separator"></div>
								<div class="form-group">
									<label class="col-sm-2 control-label">原上课日期</label>

									<div class="col-sm-10">
										<input type="text" name="datebefore" id="datebefore"
											class="Wdate" style="margin-top:3px;height:26px;"
											onClick="WdatePicker({minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'dateafter\')}'})">

									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">原上课开始时间</label>

									<div class="col-sm-10" style="width:50px">
										<!-- <input type="text" id="starttimebefore" class="form-control" name="starttimebefore"
										     onfocus="WdatePicker({dateFmt:'HH:mm',minDate:'00:00',maxDate:'23:00'})" pattern="yyyy-MM-dd"
										     value=''/>  -->
										<select id="startTime" name="starttime">
											<option value="">请选择时间</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">原上课结束时间</label>

									<div class="col-sm-10" style="width:50px">
										<!-- <input type="text" id="starttimebefore" class="form-control" name="starttimebefore"
										     onfocus="WdatePicker({dateFmt:'HH:mm',minDate:'00:00',maxDate:'23:00'})" pattern="yyyy-MM-dd"
										     value=''/>  -->
										<select id="endtime" name="endtime" disabled="disabled">
											<option value="0">请选择时间</option>
										</select>
									</div>
								</div>
								<div class="form-group-separator"></div>

								<div class="form-group">
									<label class="col-sm-2 control-label">调整后教室</label>
									<div class="col-sm-10">
										<!--  <input type="text" name="classnewroom" id="classnewroom">  -->
										<select name="classnewroom" id="classnewroom">
											<option value="">请选择教室</option>
											<c:forEach items="${classrooms }" var="cls">
												<option value="${cls.roomname}">${cls.roomname }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">调整后上课日期</label>

									<div class="col-sm-10">
										<input name="dateafter" id="dateafter" class="Wdate"
											style="margin-top:3px;height:26px;" type="text"
											onClick="WdatePicker({minDate:'#F{$dp.$D(\'datebefore\',{d:-5});}'})"
											pattern="yyyy-MM-dd">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">调整后上课开始时间</label>

									<div class="col-sm-10">
										<input type="text" id="starttimeafter" class="form-control"
											name="starttimeafter"
											onfocus="WdatePicker({dateFmt:'HH:mm',minDate:'00:00',maxDate:'23:00'})"
											value='' />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">调整后上课结束时间</label>

									<div class="col-sm-10">
										<input type="text" id="endtimeafter" class="form-control"
											name="endtimeafter"
											onfocus="WdatePicker({dateFmt:'HH:mm',minDate:'00:00',maxDate:'23:00'})"
											value='' />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">申请理由</label>
									<div class="col-sm-10">
										<input type="text" id="reason" class="form-control"
											name="reason" value='' />
									</div>
								</div>


								<div class="form-group-separator"></div>

								<div class="form-group">
									<div class="col-sm-10">
										<input type="button" class="form-control"
											style="margin-left:300px;width:80px;background:#e4393c;color:white;"
											value="返回" onclick="javascript:history.go(-1);"> <input
											type="button" class="form-control"
											style="margin-left:600px;width:80px;background:#e4393c;color:white;margin-top:-32px;"
											id="field-6" value="申请调整" onclick="doAdjustAdd();">
									</div>
								</div>

								<div class="form-group-separator"></div>

								<input type="hidden" name="classid" id="classid" value="">
								<input type="hidden" name="tidStr" id="tidStr" value="">
								<input type="hidden" name="enteringdateStr" id="enteringdateStr"
									value=""> <input type="hidden"
									name="enteringenddateStr" id="enteringenddateStr" value="">
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
						&copy; 2015 <strong>上海财经大学 国际教育学院</strong>

					</div>


					<!-- Go to Top Link, just add rel="go-top" to any link to add this functionality -->
					<div class="go-up">

						<a href="#" rel="go-top"> <i class="fa-angle-up"></i>
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

  function splitSelect(){
    var classroom=$("#classrooms");
    	$("#classRoom").val(classroom.find("option:selected").text().split('|')[0]);
    	$("#classSubject").val(classroom.find("option:selected").text().split('|')[1]);
    	$("#className").val(classroom.find("option:selected").text().split('|')[2]);
    	
    }
  $(function(){
      $("#classrooms").change(function(){
        var classroom=$("#classrooms");
    	$("#classRoom").val(classroom.find("option:selected").text().split('|')[0]);
    	$("#classSubject").val(classroom.find("option:selected").text().split('|')[1]);
    	$("#className").val(classroom.find("option:selected").text().split('|')[2]);
    	var kechengid = classroom.find("option:selected").text().split('|')[3];
          var classroomsid=$("#classrooms").val();
          var className=$("#className").val();
          //var kechengid=$("#classrooms").val();
          var classSubject=$("#classSubject").val();
          var classRoom=$("#classRoom").val();
          var version=$("#version").val();
           if(className!="" && classSubject!="" && classRoom!="" ){
              // $.post("ToAdjustKechengcheck.action",{classroomsid:classroomsid,version:version},
              //$.post("ToAdjustKechengcheck.action",{className:className,classSubject:classSubject,classRoom:classRoom,version:version},
               $.post("ToAdjustKechengcheck.action",{kechengid:kechengid},
               function(data){
                 $("#startTime").empty();
                 $("#endtime").empty();
                  if(data){
                  // $("#startTime").append('<option value="'+data.starttime+'">'+data.starttime+'</option>');
                  // $("#endtime").append('<option value="'+data.endtime+'">'+data.endtime+'</option>');   
               
                   for(var i=0;i<data.length;i++){
                   $("#startTime").append('<option value="'+data[i].starttime+'">'+data[i].starttime+'</option>');
                   $("#endtime").append('<option value="'+data[i].endtime+'">'+data[i].endtime+'</option>');   
                  } 
               }
               });
           } else{
                    $("#startTime").empty();
                    $("#endtime").empty();
                    $("#startTime").append('<option value="">请选择时间</option>');
                    $("#endtime").append('<option value="">请选择时间</option>');   
                 }
      });
    
    $("#startTime").change(function(){
          var className=$("#className").val();
          var classSubject=$("#classSubject").val();
          var classRoom=$("#classRoom").val();
          var version=$("#version").val();
          var startTime= $("#startTime").val();
            if(className!="" && classSubject!="" && classRoom!="" ){
             $.post("Getendtime.action",{className:className,classSubject:classSubject,classRoom:classRoom,version:version,startTime:startTime},
             function(data){
               $("#endtime").empty();
               $("#endtime").append('<option value="'+data.endtime+'">'+data.endtime+'</option>'); 
             }
            )    
        }
    })  
      
      
  })
     function check(){
       var version=$("#version").val();
        $("#kcversions").val(version);
         var content="";
         var contentimes="";
        if(version!=""){
        $.post("ToReplaceAdjustKecheng.action",{versionid:version},
         function(data){
           if(data){
             $("#classrooms").empty();
              content+='<option value="">--请选择--</option>';
              $("#startTime").empty();
              $("#endtime").empty();
             $("#startTime").append('<option value="">请选择时间</option>');
             $("#endtime").append('<option value="">请选择时间</option>');
            for(var i=0;i<data.length;i++){
                content+='<option value="">'+data[i].classroom+'|'+data[i].subjectname+'|'+data[i].classname+'</option>';
             }
              $("#classrooms").append(content);         
           }else{
              alert("有问题!");   
           }
         });
          
       }
     }
function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].submit();
			}	
		}

	function doAdjustAdd() {
          var version=$("#version").val();
         $("#kcversions").val(version);
	     splitSelect();
		 var classrooms = document.getElementById("classrooms").value;
		 
		  var className=$("#className").val();
          var classSubject=$("#classSubject").val();
          var classRoom=$("#classRoom").val();
		if( className=="" || classSubject =="" || classRoom=="")
		{
			alert('原课程教室、课程、班级不能为空!');
			return false;
		} 
		var datebefore = document.getElementById("datebefore").value;
		if(null == datebefore || datebefore == '')
		{
			alert('原上课日期不能为空！');
			return false;
		}
		var starttime=document.getElementById("startTime").value;
		if(starttime==null ||starttime==""){
		    alert('原上课开始时间不能为空!');
		    return false;
		}
		var endtime=document.getElementById("endtime").value;
		//var endtime=$("#endtime").val();
		if(endtime==null ||endtime==""){
		  alert('原上课结束时间不能为空!');
		  return false;
		   
		}
		var dateafter=document.getElementById("dateafter").value;
		if(null==dateafter || dateafter==''){
		   alert('调整后上课日期');
		   return false;
		}
		var starttimeafter = document.getElementById("starttimeafter").value;
		if(null == starttimeafter || starttimeafter == '')
		{
			alert('调整后上课开始时间不能为空');
			return false;
		}
		var endtimeafter = document.getElementById("endtimeafter").value;
		if (null == startTime || startTime == '') {
			alert('调整后上课结束时间不能为空');
			return false;
		}
         if(confirm("你确定要提交申请吗")){
		 document.forms[0].action = "DoAdjustAdd.action"
         $("#field-6").attr("disabled","disabled");
		 document.forms[0].submit();
         
         }
	}
</script>
</html>