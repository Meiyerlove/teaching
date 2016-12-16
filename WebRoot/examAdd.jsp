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
							<h3 class="panel-title">安排新的考试</h3>
							
						</div>
						<div class="panel-body">
							
							<form role="form" class="form-horizontal">	
							
							<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">考试名称</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="examtitle" name="examtitle" onchange="defaultSelect('1');">
									</div>
								</div>
									
									<div class="form-group-separator"></div>
															
								<div class="form-group">
									<label class="col-sm-2 control-label">阶段考试</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="phaseid" id="phaseid" onchange="defaultSelect('1');">
											<option value="0">无</option>  
											<option value="1">Assessment1</option>
											<option value="2">Assessment2</option>
											<option value="3">Assessment3</option>
											<option value="4">Assessment4</option>
											<option value="5">Assessment5</option>
										</select>
									</div>
								</div>																
								<div class="form-group-separator"></div>
															
								<div class="form-group">
									<label class="col-sm-2 control-label">考试科目</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="subjectid" id="subjectid" onchange="defaultSelect('1');"> 
											<option value="">...</option>
										    <c:forEach items="${subjectList}" var="subject" varStatus="status">       
											<option value="${subject.id}">${subject.name}</option>
											</c:forEach>
										</select>
									</div>
									
								</div>																								
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >分数类型</label>
									
									<div class="col-sm-10">
										<select class="form-control" name="scoretype" id="scoretype" onchange="switchExamType('1');">
											<option value="">...</option> 
											<option value="1">百分制</option>
											<option value="2">非百分制</option>
											<option value="3">记分单元</option>
										</select>
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group" id="type2">
									<label class="col-sm-2 control-label">考试类型</label>									
									<div class="col-sm-10">
										<select class="form-control" id="examtype1" style="display:block;" onchange="defaultSelect('2');">
										    <option value="">...</option>  
										    <option value="1">正考</option>  
										</select>
										<select class="form-control" id="examtype2" style="display:none;" onchange="defaultSelect('2');">
										    <option value="">...</option>    
											<option value="1">正考</option>
											<option value="2">正考-补做</option>
											<option value="3">正考-补考</option>
											<option value="4">正考-补考-补做</option>
											<option value="5">重修</option>
											<option value="6">重修-补做</option>
											<option value="7">毕前考</option>
											<option value="8">毕前-补做</option>
											<option value="9">其它</option>
											<option value="10">其它补做</option>   
										</select>
										<select class="form-control" id="examtype3" style="display:none;" onchange="defaultSelect('2');">
										    <option value="">...</option>    
											<option value="1">正考</option>
											<option value="3">正考-补考</option>
											<option value="7">毕前考</option>
											<option value="9">其它</option>  
										</select>
										<select class="form-control" id="examtype4" style="display:none;" onchange="defaultSelect('2');">
										    <option value="">...</option>    
											<option value="1">正考</option>
											<option value="2">正考-补做</option>
											<option value="3">正考-补考</option>
											<option value="20">第二次补考</option>
											<option value="21">其他-正考</option>
											<option value="22">其他-补做</option>
										</select>
									</div>
								</div>								
								
								<div class="form-group-separator"></div>
								
								<div class="form-group" >
                                        <label class="col-sm-2 control-label">考试班级</label>
                                        <div style="margin-left:18%;margin-right:1.5%;">
										<table class="table table-bordered table-striped"
											id="example-2">	
                                             <thead>
												<tr>
													<th class="no-sorting">
														
													</th>
													<th width="8%">
														ID
													</th>
													<th>
														班级名称
													</th>
													<th>
														录入成绩老师
													</th>
													<th>
														内审员
													</th>
													<th>
														录入成绩开始日期
													</th>
													<th>
														录入成绩结束日期
													</th>
												</tr>
											</thead>

											<tbody class="middle-align" id="tbody">
												<c:forEach items="${classList}" var="classes" varStatus="status">
													<tr>
														<td>
															<input type="checkbox" class="cbr" name="classcheckbox"  value="${classes.id}">
														</td>
														<td>
															${classes.id}
														</td>
														<td>
															${classes.name}
														</td>
														<td>
															<select class="form-control" name="teacherid${classes.id}" id="teacherid${classes.id}" style="width:120px;">
																<option value="">...</option>
																<c:forEach items="${teacherList}" var="teacher" varStatus="status">
																<option value="${teacher.tid}">
																	${teacher.name}
																</option>
																</c:forEach>
															</select>
														</td>
														<td>
															<select class="form-control" name="teacher${classes.id}" id="teacher${classes.id}" style="width:120px;">
																<option value="">...</option>
																<c:forEach items="${teacherList}" var="teacher" varStatus="status">
																<option value="${teacher.tid}">
																	${teacher.name}
																</option>
																</c:forEach>
															</select>
														</td>
														<td>
														   <input name="enteringdate${classes.id}" id="enteringdate${classes.id}" class="Wdate" style="margin-top:3px;height:26px;width:120px;" type="text" onClick="WdatePicker()">
														</td>
														<td>
														   <input name="enteringenddate${classes.id}" id="enteringenddate${classes.id}" class="Wdate" style="margin-top:3px;height:26px;width:120px;" type="text" onClick="WdatePicker()">
														</td>
														</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>													
								 
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >考试日期</label>
									
									<div class="col-sm-10">
									    <input name="edate" id="edate" class="Wdate" style="margin-top:3px;height:26px;" type="text" onClick="WdatePicker()" value="${exam.temp_var}"/>
									</div>
								</div>
								  
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >开始时间</label>									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="fromtime" name="fromtime" value="${exam.fromtime}" placeholder="格式为 00:00,冒号请用英文半角冒号">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >结束时间</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="totime" name="totime" value="${exam.totime}" placeholder="格式为 00:00 冒号请用英文半角冒号">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >教室</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="classroom" name="classroom" value="${exam.classroom}">
									</div>
								</div>

								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label">年级</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="grade" name="grade" value="${exam.grade}">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<label class="col-sm-2 control-label"  >项目</label>
									
									<div class="col-sm-10">
										<input type="text" class="form-control" id="program" name="program" value="${exam.program}">
									</div>
								</div>																
								
								<div class="form-group-separator"></div>
								
								<div class="form-group">
									<div class="col-sm-10">
									    <input type="button" class="form-control" style="margin-left:300px;width:80px;background:#e4393c;color:white;" value="返回" onclick="javascript:history.go(-1);">
										<input type="button" class="form-control" style="margin-left:600px;width:80px;background:#e4393c;color:white;margin-top:-32px;" id="field-6" value="保存" onclick="doExamAdd();">
									</div>
								</div>
								
								<div class="form-group-separator"></div>
								<input type="hidden" name="classid" id="classid" value="">
								<input type="hidden" name="tidStr" id="tidStr" value="">
								<input type="hidden" name="tidStr2" id="tidStr2" value="">
								<input type="hidden" name="enteringdateStr" id="enteringdateStr" value="">
								<input type="hidden" name="enteringenddateStr" id="enteringenddateStr" value="">
								<input type="hidden" name="hiddenexamtype" id="hiddenexamtype" value="">
								<input type="hidden" name="examtype" id="examtype" value="">
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

//function checkExam(classid){
	//var phaseid=$("#phaseid").val();
	//var subjectid=$("#subjectid").val();
	//var scortype=$("#scortype").val();
	//var examtype=$("#examtype").val();
	//var datas = {phaseid:phaseid,subjectid:subjectid,scortype:scortype,examtype:examtype,classid:classid};
	//var url="CheckExam.action";
	//$.post(url,datas,
			//function(data){
				
			//}
	//);
//}

var bol='false';

function defaultSelect(param){
		var phaseid=$("#phaseid").val(),
			subjectid=$("#subjectid").val(),
			scoretype=$("#scoretype").val(),
			hiddenexamtype=$("#hiddenexamtype").val(),
			examtype=$("#"+hiddenexamtype).val();
			if(param==1&&bol=='false'){
				return;
			}
			else{
					if(subjectid==''){
						alert("请选择科目");
						return;
					}
					if(scoretype==''){
						alert("请选择分数类型");
						return;
					}
					if(examtype==''){
						alert("请选择考试类型");
						return;
					}
				}
		$.post("DefaultSelect.action",{phaseid:phaseid,subjectid:subjectid,scoretype:scoretype,examtype:examtype},
			function(data){
						if(data==false){
							$("#tbody").empty();
							alert("请先安排正考");
							return;
						}
						var content='';					
						$("#tbody").empty();
						for(var i=0;i<data.length;i++){
						var teacher_list=data[i].teacher_list
								content+='<tr>';
								content+='<td><input type="checkbox" class="cbr" name="classcheckbox" value="'+data[i].id+'"></td>';
								content+='<td>'+data[i].id+'</td>';
								content+='<td>'+data[i].name+'</td>';
								content+='<td>';
								content+='<select class="form-control" style="width:120px;" name="teacherid'+data[i].id+'" id="teacherid'+data[i].id+'">';
								//content+='<option value="">...</option>';
								for(var j=0;j<teacher_list.length;j++){
									content+='<option value="'+teacher_list[j].tid+'">'+teacher_list[j].name+'</option>';									
								}
								content+='</select>';
								content+='</td>';
								content+='<td>';
								content+='<select class="form-control" style="width:120px;"  name="teacher'+data[i].id+'" id="teacher'+data[i].id+'">';
								//content+='<option value="">...</option>';
								for(var j=0;j<teacher_list.length;j++){
									content+='<option value="'+teacher_list[j].tid+'">'+teacher_list[j].name+'</option>';									
								}
								content+='</select>';
								content+='</td>';
								content+='<td><input name="enteringdate'+data[i].id+'" id="enteringdate'+data[i].id+'" class="Wdate" style="margin-top:3px;height:26px;width:120px;" type="text" onClick="WdatePicker()"></td>';
								content+='<td><input name="enteringenddate'+data[i].id+'" id="enteringenddate'+data[i].id+'" class="Wdate" style="margin-top:3px;height:26px;width:120px;" type="text" onClick="WdatePicker()"></td>';
								content+='</tr>';
						}
						bol='true';
						$("#tbody").append(content);
				}
		);	
}

function switchExamType(param){
		var scoretype=$("#scoretype").val();
		if(scoretype==1){
			$("#hiddenexamtype").val("examtype1");
			$("#examtype1").css("display","block");
			$("#examtype2").css("display","none");
			$("#examtype3").css("display","none");
			$("#examtype4").css("display","none");
		}	
		else if(scoretype==2){
			$("#hiddenexamtype").val("examtype2");
			$("#examtype1").css("display","none");
			$("#examtype2").css("display","block");
			$("#examtype3").css("display","none");
			$("#examtype4").css("display","none");
		}
		else if(scoretype==3){
			$("#hiddenexamtype").val("examtype3");
			$("#examtype1").css("display","none");
			$("#examtype2").css("display","none");
			$("#examtype3").css("display","block");
			$("#examtype4").css("display","none");
		}
		else if(scoretype==4){
			$("#hiddenexamtype").val("examtype4");
			$("#examtype1").css("display","none");
			$("#examtype2").css("display","none");
			$("#examtype3").css("display","none");
			$("#examtype4").css("display","block");
		}
		else{
			$("#hiddenexamtype").val("");
		}
		defaultSelect(param);
}

function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].submit();
			}	
		}

	function doExamAdd() {
		var examtitle = document.getElementById("examtitle").value;
		if(null == examtitle || examtitle == '')
		{
			alert('考试名称不能为空！');
			return false;
		}
		
		var subjectid = document.getElementById("subjectid").value;
		if (null == subjectid || subjectid == '') {
			alert('考试科目不能为空！');
			return false;
		}
		
		var scoretype = document.getElementById("scoretype").value;
		if (null == scoretype || scoretype == "") {
			alert('分数类型不能为空！');
			return false;
		}
		var examtype1 = document.getElementById("examtype1").value;
		var examtype2 = document.getElementById("examtype2").value;
		var examtype3 = document.getElementById("examtype3").value;
		var examtype4 = document.getElementById("examtype4").value;
		if(null!=scoretype&&scoretype ==1){
			if(null == examtype1 || examtype1 == '')
			{
				alert('考试类型不能为空！');
				return false;
			}
			else{
				$("#examtype").val(examtype2);
			}
		}
		else if(null!=scoretype&&scoretype ==2){
			if(null == examtype2 || examtype2 == '')
			{
				alert('考试类型不能为空！');
				return false;
			}
			else{
				$("#examtype").val(examtype2);
			}
		}
		else if(null!=scoretype&&scoretype ==3){
			if(null == examtype3 || examtype3 == '')
			{
				alert('考试类型不能为空！');
				return false;
			}
			else{
			$("#examtype").val(examtype3);
			}
		}
		else if(null!=scoretype&&scoretype ==4){
			if(null == examtype4 || examtype4 == '')
			{
				alert('考试类型不能为空！');
				return false;
			}
			else{
			$("#examtype").val(examtype4);
			}
		}
		
		var str = document.getElementsByName("classcheckbox");
		var objarray = str.length;
		var chestr = "";
		for (i = 0; i < objarray; i++) {//牛图库JS特效，http://js.niutuku.com/
			if (str[i].checked == true) {
				chestr += str[i].value + ",";
			}
		}//牛图库JS特效，http://js.niutuku.com/
		if (chestr == "") {
			alert("至少选择一个班级～！");
			return false;
		}

	    var classarray = chestr.split(',');
        
        var tidStr = "";
        var tidStr2 = "";
		for (j = 0; j < classarray.length-1; j++) {
		    var abc = "teacherid" + classarray[j];
		    var abc2 = "teacher" + classarray[j];
			var tid = document.getElementById(abc).value;
			var tid2 = document.getElementById(abc2).value;
			if (null == tid || tid == "") {
				alert('请为班级选择录入成绩的老师！');
				return false;
			}
			if (null == tid2 || tid2 == "") {
				alert('请为班级选择内审员！');
				return false;
			}
			tidStr = tidStr + tid + ",";
			tidStr2 = tidStr2 + tid2 + ",";
		}
		
		var edate = document.getElementById("edate").value;
		if(null == edate || edate == '')
		{
			alert('考试日期不能为空！');
			return false;
		}
		
		var fromtime = document.getElementById("fromtime").value;
		var reg=/^(?:(?:0?|1)\d|2[0-3]):[0-5]\d$/;
		if (null == fromtime || fromtime == '') {
			alert('考试开始时间不能为空！');
			return false;
		}
		else if(!reg.test(fromtime)){
			alert('格式错误！');
			return false;
		}
		var totime = document.getElementById("totime").value;
		if (null == totime || totime == '') {
			alert('考试结束时间不能为空！');
			return false;
		}
		else if(!reg.test(totime)){
			alert('格式错误！');
			return false;
		}
		var classroom = document.getElementById("classroom").value;
		if (null == classroom || classroom == '') {
			alert('考试地点不能为空！');
			return false;
		}
		
		
		var enteringdateStr = "";
		for (m = 0; m < classarray.length-1; m++) {
		    var abc = "enteringdate" + classarray[m];
			var enteringdate = document.getElementById(abc).value;
			if (null == enteringdate || enteringdate == "") {
				enteringdateStr = enteringdateStr + "dt,";
			}else{
			    enteringdateStr = enteringdateStr + enteringdate + ",";
			}
		}
		
		var enteringenddateStr = "";
		for (n = 0; n < classarray.length-1; n++) {
		    var abc = "enteringenddate" + classarray[n];
			var enteringenddate = document.getElementById(abc).value;
			if (null == enteringenddate || enteringenddate == "") {
				enteringenddateStr = enteringenddateStr + "dt,";
			}else{
			    enteringenddateStr = enteringenddateStr + enteringenddate + ",";
			}
		}
		document.getElementById("classid").value = chestr;
		document.getElementById("tidStr").value = tidStr;
		document.getElementById("tidStr2").value = tidStr2;
		document.getElementById("enteringdateStr").value = enteringdateStr;
		document.getElementById("enteringenddateStr").value = enteringenddateStr;
        alert('增加考试安排成功');
		document.forms[0].action = "DoExamAdd.action";
		document.forms[0].submit();
	}
</script>
</html>