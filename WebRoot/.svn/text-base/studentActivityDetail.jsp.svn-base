<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>活动课学生上课记录</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
    <tr><th>参加活动的学生</th></tr>  
    <s:iterator id="list" value="heList" status="sta">
		<tr>
            <td align="center"><s:hidden name="emplID" value="${list.emplID}"/> ${list.emplID}</td>
			<td align="center">${list.emplName}</td>
		</tr>
	</s:iterator>
	<tr><td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td></tr>
	<tr>
      <td align="center">上课日期</td>
      <td align="center"><s:datetimepicker name="todayStartDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
    </tr>
    <tr><td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td></tr>
    <tr><td align="center">老师号和姓名（必选）</td>
       <td align="center">
          <s:select label="老师号" id="teacherIDAndName" name="teacherIDAndName" list="#request.teaStringList" 
          headerKey="-1" headerValue="请选择老师"/>
       </td></tr>
       <tr><td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td></tr>
       <tr><td>备注</td>
        <td><s:textarea label="老师号" id="noteid" name="note" rows="5"/></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
    <tr><td align="right"><input name="save" type="button" onclick="saveActicityManualRecord()" value="保存"/></td>
        <td align="right"><input name="save" type="button" onclick="returnActivityList()" value="取消处理并返回"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveActicityManualRecord(){
      var tmp = document.forms[0].teacherIDAndName.value;
      if(tmp == -1){
        alert('老师名字必填！');
        return false;
      }
    	    document.forms[0].action = "SaveActicityManualRecord.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
     function returnActivityList(){
    	    document.forms[0].action = "ActivityHandle.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>