<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>体验课处理页面</title>
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
      <td height="26" align="center" bgcolor="#d9d9d9"><span><s:fielderror /><s:actionerror /><s:actionmessage/></span></td>
    </tr>
  </table>
</div>
</s:if>
<table>
    <tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
    <tr><th>体验课信息填写</th></tr>  
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
      <td><s:datetimepicker name="todayStartDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
    </tr>
    <tr><td align="right">教室号（必选）</td><td align="left"><s:select label="教室号" id="roomIDAndNO" name="roomIDAndNO" list="#request.roomIDAndNOList"
       headerKey="-1" headerValue="请选择教室"
       /></td></tr>
    <tr><td align="center">上课人数（必填）:</td><td><s:textfield id="stuNumber" name="ecr.stuNumber"/></td>
      </tr>
    <tr><td align="center">顾问:</td><td><s:textfield id="consultant" name="ecr.consultant"/></td>
      </tr>
    <tr><td align="right">课程名称（必选）</td><td align="left"> <s:select label="课程名称" id="subject"  name="ecr.subject" list="#request.subjectList"
       headerKey="-1" headerValue="请选择课程名称"
       /></td></tr>
    <tr><td align="center">老师号和姓名（必选）</td>
       <td>
          <s:select label="老师号" id="teacherIDAndName" name="teacherIDAndName" list="#request.teaStringList" 
          headerKey="-1" headerValue="请选择老师"/>
       </td></tr>
      <tr><td align="center">开始时间:格式(HH:mm)（必填）</td><td><s:textfield id="startTime" name="ecr.startTime"/></td>
      </tr>
      <tr><td align="center">结束时间:格式(HH:mm)（必填）</td><td><s:textfield id="endTime" name="ecr.endTime"/></td>
      </tr>
       <tr><td align="center">备注</td>
        <td><s:textarea label="老师号" id="noteid" name="ecr.note" rows="5"/></td>
        <td><br></br></td>
       </tr>
    <tr><td align="right"><input name="save" type="button" onclick="saveExClass()" value="保存"/></td>
        </tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveExClass(){
      var roomNo = document.forms[0].roomIDAndNO.value;
      if(roomNo == -1){
        alert('教室必填！');
        return false;
      }
      var stuNumber = document.getElementById("stuNumber").value;
      if(null == stuNumber || stuNumber == ''){
        alert('上课人数必填！');
        return false;
      }
      var consultant = document.getElementById("consultant").value;
      if(null == consultant || consultant == ''){
        alert('顾问必填！');
        return false;
      }
      var subject = document.forms[0].subject.value;
      if(subject == -1){
        alert('课程名称必填！');
        return false;
      }
      var tmp = document.forms[0].teacherIDAndName.value;
      if(tmp == -1){
        alert('老师名字必填！');
        return false;
      }
      var startTime = document.getElementById("startTime").value;
      if(null == startTime || startTime == ''){
        alert('开始时间必填！');
        return false;
      }
      var endTime = document.getElementById("endTime").value;
      if(null == endTime || endTime == ''){
        alert('结束时间必填！');
        return false;
      }
    	    document.forms[0].action = "SaveExClassRecord.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>