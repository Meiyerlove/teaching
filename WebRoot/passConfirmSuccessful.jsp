<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>手动输入学生上课记录</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<s:if test="hasActionErrors()||hasActionMessages()">
<div id="div-error">
  <table width="100%" border="0" cellpadding="0" class="table-a">
    <tr>
      <th>提示信息 </th>
    </tr>
    <tr>
      <td height="26" align="center" bgcolor="#d9d9d9"><span class="redfont"><s:fielderror /><s:actionerror /><s:actionmessage/></span></td>
    </tr>
  </table>
</div>
</s:if>
<table> 
    <tr><th>上课学生的信息</th></tr>  
		<tr>
            <td align="center"><s:property value="mr.emplID"/><s:hidden id="emplID" name="mr.emplID"/><s:hidden id="emplIDs" name="emplID" value="${list.emplID}"/> </td>
			<td align="center"><s:property value="mr.emplName"/><s:hidden id="emplName" name="mr.emplName"/></td>
		</tr>
	<tr>
	    <td align="center">上课日期</td><td align="center"><s:property value="mr.lessonDate"/><s:hidden id="lessonDate" name="mr.lessonDate"/></td>
	</tr>
	<tr>
	    <td align="center">第几节课: </td>
	    <td align="center">第<s:property value="mr.lessonNumber"/>节课<s:hidden label="教室号" id="lessonNumber" name="mr.lessonNumber"/></td>
	</tr>
	<tr>
	    <td align="center">教室号:</td>
	    <td align="center"><s:property value="mr.roomNO"/><s:hidden label="教室号" id="roomNO" name="mr.roomNO"/></td></tr>
    <tr>
        <td align="center">老师号和姓名:</td>
        <td align="center"><s:property value="mr.teacherID"/><s:property value="mr.teacherName"/><s:hidden id="roomNO" name="mr.teacherID"/>
                         <s:hidden id="roomNO" name="mr.teacherName"/></td>
    </tr>
    <tr>
      <td align="center">课程名称:</td>
      <td align="center"><s:property value="mr.subject"/><s:hidden label="课程名称" id="subject"  name="mr.subject"/></td></tr>
    <tr>
    </tr>
    </table>
    <table>
    
    <tr>
        <td align="center"><input name="save" type="button" onclick="returnList()" value="返回"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveManualRecord(){

    	    document.forms[0].action = "SaveManualRecordUser.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
     function returnList(){
    	    document.forms[0].action = "NoCardHandle.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>