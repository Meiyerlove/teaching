<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>编辑课信息</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><td align="right">老师工号:</td><td align="left"><s:hidden name="cs.id"/>
    <s:textfield name="cs.teaid"/></td></tr>
    <tr><td align="right">老师名字:</td><td align="left"><s:textfield name="tea.teaname"/></td></tr>
    <tr><td align="right">星期</td><td align="left"><s:textfield name="cs.weekday"/></td></tr>
    <tr><td align="right">第几节课</td><td align="left"><s:textfield name="cs.sequenceNumber"/></td></tr>
    <tr><td align="right">开始时间</td><td align="left"><s:textfield name="cs.fromtime"/></td></tr>
    <tr><td align="right">结束时间</td><td align="left"><s:textfield name="cs.totime"/></td></tr>
    <tr><td align="right">课程</td><td align="left"><s:textfield name="cs.subject"/></td></tr>
    <tr><td align="right">教室号</td><td align="left"><s:textfield name="cs.roomNO"/></td></tr>
    <tr><td align="right"><input name="save" type="button" onclick="saveLesson()" value="保存"/></td>
    <td align="right"><input name="save" type="button" onclick="returnList()" value="返回列表"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveLesson(){
    	    document.forms[0].action = "SaveLesson.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
      function returnList(){
    	    document.forms[0].action = "ListTeacher.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>