<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>����δ���ҳ��</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<s:if test="hasActionErrors()||hasActionMessages()">
<div id="div-error">
  <table width="100%" border="0" cellpadding="0" class="table-a">
    <tr>
      <th>��ʾ��Ϣ </th>
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
    <tr><th>�������Ϣ��д</th></tr>  
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
      <td align="center">�Ͽ�����</td>
      <td><s:datetimepicker name="todayStartDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
    </tr>
    <tr><td align="right">���Һţ���ѡ��</td><td align="left"><s:select label="���Һ�" id="roomIDAndNO" name="roomIDAndNO" list="#request.roomIDAndNOList"
       headerKey="-1" headerValue="��ѡ�����"
       /></td></tr>
    <tr><td align="center">�Ͽ����������:</td><td><s:textfield id="stuNumber" name="ecr.stuNumber"/></td>
      </tr>
    <tr><td align="center">����:</td><td><s:textfield id="consultant" name="ecr.consultant"/></td>
      </tr>
    <tr><td align="right">�γ����ƣ���ѡ��</td><td align="left"> <s:select label="�γ�����" id="subject"  name="ecr.subject" list="#request.subjectList"
       headerKey="-1" headerValue="��ѡ��γ�����"
       /></td></tr>
    <tr><td align="center">��ʦ�ź���������ѡ��</td>
       <td>
          <s:select label="��ʦ��" id="teacherIDAndName" name="teacherIDAndName" list="#request.teaStringList" 
          headerKey="-1" headerValue="��ѡ����ʦ"/>
       </td></tr>
      <tr><td align="center">��ʼʱ��:��ʽ(HH:mm)�����</td><td><s:textfield id="startTime" name="ecr.startTime"/></td>
      </tr>
      <tr><td align="center">����ʱ��:��ʽ(HH:mm)�����</td><td><s:textfield id="endTime" name="ecr.endTime"/></td>
      </tr>
       <tr><td align="center">��ע</td>
        <td><s:textarea label="��ʦ��" id="noteid" name="ecr.note" rows="5"/></td>
        <td><br></br></td>
       </tr>
    <tr><td align="right"><input name="save" type="button" onclick="saveExClass()" value="����"/></td>
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
        alert('���ұ��');
        return false;
      }
      var stuNumber = document.getElementById("stuNumber").value;
      if(null == stuNumber || stuNumber == ''){
        alert('�Ͽ��������');
        return false;
      }
      var consultant = document.getElementById("consultant").value;
      if(null == consultant || consultant == ''){
        alert('���ʱ��');
        return false;
      }
      var subject = document.forms[0].subject.value;
      if(subject == -1){
        alert('�γ����Ʊ��');
        return false;
      }
      var tmp = document.forms[0].teacherIDAndName.value;
      if(tmp == -1){
        alert('��ʦ���ֱ��');
        return false;
      }
      var startTime = document.getElementById("startTime").value;
      if(null == startTime || startTime == ''){
        alert('��ʼʱ����');
        return false;
      }
      var endTime = document.getElementById("endTime").value;
      if(null == endTime || endTime == ''){
        alert('����ʱ����');
        return false;
      }
    	    document.forms[0].action = "SaveExClassRecord.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>