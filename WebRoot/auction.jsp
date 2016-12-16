<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<c:set var="task" value="${requestScope.task}" />
<c:set var="user" value="${sessionScope.loginUser}"/>
<html xmlns:wb="http://open.weibo.com/wb">
<head>
<script async="" src="style/js/analytics.js"></script><script type="text/javascript" async="" src="style/js/conversion.js"></script><script src="style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script><style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link  media="handheld" rel="alternate">
<!-- end 云适配 -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>web前端开发-国馆-财之道网-最专业的互联网招聘平台</title>
<meta content="23635710066417756375" property="qc:admins">
<meta name="description" content="web前端开发 广州 大专 3-5年 全职 前端开发 高薪高福利，良好办公空间 国馆 广东国馆酒业有限公司 让文化温暖人心 财之道网-最专业的互联网招聘平台">
<meta name="keywords" content="web前端开发 广州 大专 3-5年 全职 前端开发 高薪高福利，良好办公空间 国馆 广东国馆酒业有限公司 让文化温暖人心 财之道网-最专业的互联网招聘平台">
<meta content="QIQ6KC1oZ6" name="baidu-site-verification">

<!-- <div class="web_root"  style="display:none">http://www. .com</div> -->
<script type="text/javascript">

	function receiveTask() {
		var a = confirm("确认领取此任务吗？");
		if (a == true) {
			document.forms[0].action = "post";
		    document.forms[0].action = "taskData.do?operator=doTaskReceive";
		    document.forms[0].submit();
		} else {
			return false;
		}
	}
	
var ctx = "http://www. .com";
console.log(1);
</script>
<link href="images/favicon.ico" rel="Shortcut Icon">
<link href="style/css/style.css" type="text/css" rel="stylesheet">
<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="style/css/popup.css" type="text/css" rel="stylesheet">

<script src="script/common.js"></script>

<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script src="style/js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="style/js/jquery-hbzx.js"></script>
<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script src="style/js/conv.js" type="text/javascript"></script>
<script src="style/js/ajaxCross.json" charset="UTF-8"></script>

<script>try {  for(var lastpass_iter=0; lastpass_iter &lt; document.forms.length; lastpass_iter++){    var lastpass_f = document.forms[lastpass_iter];    if(typeof(lastpass_f.lpsubmitorig)=="undefined"){      if (typeof(lastpass_f.submit) == "function") {        lastpass_f.lpsubmitorig = lastpass_f.submit;        lastpass_f.submit = function(){          var form = this;          try {            if (document.documentElement &amp;&amp; 'createEvent' in document)            {              var forms = document.getElementsByTagName('form');              for (var i=0 ; i&lt;forms.length ; ++i)                if (forms[i]==form)                {                  var element = document.createElement('lpformsubmitdataelement');                  element.setAttribute('formnum',i);                  element.setAttribute('from','submithook');                  document.documentElement.appendChild(element);                  var evt = document.createEvent('Events');                  evt.initEvent('lpformsubmit',true,false);                  element.dispatchEvent(evt);                  break;                }            }          } catch (e) {}          try {            form.lpsubmitorig();          } catch (e) {}        }      }    }  }} catch (e) {}</script></head>
<body>
<div id="body">
    <jsp:include page="common/topsj.jsp" />
    <!-- end #header -->
    <div id="container">
    <form>
    <input type="hidden" id="userid" name="receiver" value="${user.usrId}">
    <input type="hidden" id="id" name="id" value="${task.id}">
    <input type="hidden" id="taskid" name="taskid" value="${task.taskid}">
    <input type="hidden" name="operator" value="doTaskReceive">
          <div class="clearfix">
            <div
									style="color: #FF0000; text-align: left; margin-left: 1px; margin-top: 15px; margin-bottom: 25px;font-size: 20px;">
									<html:messages id="message">
										<bean:write name="message" />
									</html:messages>
			 </div>
            <div class="content_new">
            	 <dl class="job_detail">
                    <dt>
                        <h1>
                            <em></em>
                                                        	<div>最新最热任务</div>
                           	                           ${taskReceive.task.taskname}
                        </h1>
                        <c:if test="${user.usrId != task.userid}">
										<c:if test="${isReceived == 1}">
                                           &nbsp;&nbsp;&nbsp;&nbsp;<font color=red size=5>此任务已经领取过</font>
										</c:if>
									</c:if>
                                               	
                <div class="jd_collection" id="jobCollection">
                       	    <div class="jd_collection_success">
								<a class="jd_collection_page" href="mycenter/collections.html">查看全部</a>								
								<a class="jd_collection_x" href="javascript:;"></a>
							</div>
               </div>
               
              </dt>
                   
                    <dd class="job_request">
                    	 <c:if test="${task.type == 1}">
								       <font color=red size=4>悬赏金额: ${task.money}</font>
							       </c:if>
							       <c:if test="${task.type == 2}">
								       <font color=red size=4>功能任务: ${task.authoritycontent}</font>
							       </c:if>
							       <c:if test="${task.type == 3}">
								       <font color=red size=4>礼品任务: ${task.giftname}</font><br>
								       <span>礼品介绍: ${task.giftintroduction}</span><br>
							       <span>礼品数量: ${task.giftnumber}</span><br>
							       </c:if>
							       <c:if test="${task.type == 4}">
								       <font color=red size=4>竞价任务: ${task.giftname}</font>
							       </c:if>
							       <c:if test="${task.type == 5}">
								       <font color=red size=4>收费金额: ${-task.price}</font><br>
								       <span>授课老师: ${task.teacher}</span><br>
								       <span>授课老师经历: ${task.resume}</span><br>
								       <span>授课时间: 从${task.lessonstarttime}到${task.lessonendtime}</span><br>
								       <span>是否接受预约:<c:if test="${task.isbook == true}">接受预约</c:if><c:if test="${task.isbook == false}">不接受预约</c:if></span><br>
							       </c:if>
							       <br>
							       
                       	<span>任务类别：${task.catname} -- ${task.catsname}</span><br>
                      	<div>发布时间：${task.createtime}发布</div>
                      	<div>任务描述：${task.taskcontent}</div>
                    </dd>
                    <dd class="job_bt">
                        <h3 class="description">任务报价</h3>
                        <input style="margin-top:2px;padding-top:0px;padding-bottom:0px;font-size:14px;height:35px;" type="text" name="url" id="url" value="">
                    </dd>
                    <dd class="job_bt">
                        <h3 class="description">完成工时</h3>
                        <input style="margin-top:2px;padding-top:0px;padding-bottom:0px;font-size:14px;height:35px;" type="text" name="url" id="url" value="">
                    </dd>
                    <dd class="job_bt">
                       <h3 class="description">任务方案</h3>
                       <textarea name="creativetext"  rows="3" cols="12"></textarea>
                    </dd>
                    
                     
                   
                </dl>      
            </div>	         
       	</div>                    
	
	  <div id="tipOverlay"></div>


<script src="style/js/job_detail.js" type="text/javascript"></script>
<script src="style/js/count.js" type="text/javascript"></script>

<script>
$(function(){
	$('#weibolist .cookietxte').text('推荐本职位给好友');
	$(document).bind('cbox_complete', function(){ 
		hbzxJQ("#gaosutapt .pttui a").trigger("click"); 
		hbzxJQ("#mepingpt .pttui a").trigger("click"); 
	});
	$('#cboxOverlay').bind('click',function(){
		top.location.reload();
	});
	$('#colorbox').on('click','#cboxClose',function(){
		if($(this).siblings('#cboxLoadedContent').children('div').attr('id') == 'deliverResumesSuccess' || $(this).siblings('#cboxLoadedContent').children('div').attr('id') == 'uploadFileSuccess'){
			top.location.reload();
		}
	});
			popQR();
	})
</script>

<script src="http://api.map.baidu.com/api?v=2.0&amp;ak=3d6a9f4b807441569414b01eecc20959" type="text/javascript"></script><script src="http://api.map.baidu.com/getscript?v=2.0&amp;ak=3d6a9f4b807441569414b01eecc20959&amp;services=&amp;t=20140617153133" type="text/javascript"></script>

			<div class="clear"></div>
			<input type="hidden" value="6c401d88d0e34445a3482fa27afe4d77" id="resubmitToken">
	    	<a rel="nofollow" title="回到顶部" id="backtop" style="display: inline;"></a>
	    	</form>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<div class="copyright">&copy;2013-2014   <a href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">京ICP备14023790号-2</a></div>
		</div>
	</div>

<script src="style/js/core.min.js" type="text/javascript"></script>
<script src="style/js/popup.min.js" type="text/javascript"></script>
<script src="style/js/tongji.js" type="text/javascript"></script>
<!--  -->
<script src="style/js/analytics01.js" type="text/javascript"></script><script type="text/javascript" src="style/js/h.js"></script>

<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div></body></html>