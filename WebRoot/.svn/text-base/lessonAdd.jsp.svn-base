<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>加课</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><td align="right">老师工号:</td><td align="left"><s:hidden name="tea.teaid"/>
    <s:textfield name="tea.teaid" disabled="true"/></td></tr>
    <tr><td align="right">老师名字:</td><td align="left"><s:textfield name="tea.teaname" disabled="true"/></td></tr>
    <tr><td align="right">星期</td><td align="left"><s:textfield id="weekdayid" name="cs.weekday"/></td></tr>
    <tr><td align="right">第几节课</td><td align="left"><s:textfield name="cs.sequenceNumber"/></td></tr>
    <tr><td align="right">开始时间</td><td align="left"><s:textfield name="cs.fromtime"/></td><td align="left">格式hh:mm</td></tr>
    <tr><td align="right">结束时间</td><td align="left"><s:textfield name="cs.totime"/></td><td align="left">格式hh:mm</td></tr>
    <tr><td align="right">课程</td><td align="left"> <s:select id="subjectid" name="cs.subject" list="#request.subjectList"
       headerKey="-1" headerValue="请选择课程名称"/></td></tr>
    <tr><td align="right">教室号</td><td align="left"><s:select id="roomid" name="cs.roomNO" list="#request.roomNOList"
       headerKey="-1" headerValue="请选择教室"/></td></tr>
    <tr><td align="right"><input name="save" type="button" onclick="saveNewLesson()" value="保存"/></td>
    <td align="right"><input name="save" type="button" onclick="returnTeacherCurschList('<s:property value="tea.teaid"/>')" value="返回列表"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveNewLesson(){
      var weekdayid = document.getElementById("weekdayid").value;
      if(null == weekdayid || weekdayid == ''){
        alert('星期几必填！');
        return false;
      }
      var subjectid = document.getElementById("subjectid").value;
      if(subjectid == -1){
        alert('课程名必选！');
        return false;
      }
      var roomid = document.getElementById("roomid").value;
      if(roomid == -1){
        alert('教室号必选！');
        return false;
      }
    	    document.forms[0].action = "SaveNewLesson.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
      function returnTeacherCurschList(teaid){
    	    document.forms[0].action = "EditCurSch.action?teaid="+teaid;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>