<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>�ֶ�����ѧ���Ͽμ�¼</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table> 
    <tr><th>Ҫ�ֶ���¼�Ͽε�ѧ��</th></tr>  
    <s:iterator id="list" value="heList" status="sta">
		<tr>
            <td align="center"><s:hidden name="emplID" value="${list.emplID}"/> ${list.emplID}</td>
			<td align="center">${list.emplName}</td>
		</tr>
	</s:iterator>
	<tr>
	    <td align="center">�Ͽ�����</td><td align="center"><s:datetimepicker name="todayStartDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
	</tr>
	<tr><td align="right">�ڼ��ڿΣ���ѡ�� </td><td align="left"><s:select label="�ڼ��ڿ�" id="lessonNumber" name="mr.lessonNumber" 
	list="#{2:'2_10:00-10:45',3:'3_11:00-11:45',4:'4_12:00-12:45',5:'5_13:00-13:45',6:'6_14:00-14:45',7:'7_15:00-15:45',
	8:'8_16:00-16:45',9:'9_17:00-17:45',10:'10_18:00-18:45',11:'11_18:30-19:15',12:'12_19:00-19:45'}"
       headerKey="1" headerValue="1_09:00-09:45"/></td></tr>
	<tr><td align="right">���Һţ���ѡ��</td><td align="left"><s:select label="���Һ�" id="roomIDAndNO" name="roomIDAndNO" list="#request.roomIDAndNOList"
       headerKey="-1" headerValue="��ѡ�����"
       /></td></tr>
    <tr><td align="right">��ʦ�ź���������ѡ��</td><td align="left">
    <s:select label="��ʦ��" id="teacherIDAndName" name="teacherIDAndName" list="#request.teaStringList" 
       headerKey="-1" headerValue="��ѡ����ʦ"/></td></tr>
    <tr><td align="right">�γ����ƣ���ѡ��</td><td align="left"> <s:select label="�γ�����" id="subject"  name="mr.subject" list="#request.subjectList"
       headerKey="-1" headerValue="��ѡ��γ�����"
       /></td></tr>
    
    <tr><td align="right"><input name="save" type="button" onclick="saveManualRecord()" value="ȷ��"/></td>
        <td align="right"><input name="save" type="button" onclick="returnList()" value="ȡ����������"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveManualRecord(){
      var roomNO = document.forms[0].roomIDAndNO.value;
      if(roomNO == -1){
        alert('���Һű��');
        return false;
      }
      var teacherIDAndName = document.forms[0].teacherIDAndName.value;
      if(teacherIDAndName == -1){
        alert('��ʦ���');
        return false;
      }
      var subject = document.forms[0].subject.value;
      if(subject == -1){
        alert('�γ̱��');
        return false;
      }
    	    document.forms[0].action = "SaveManualRecord.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         
     function returnList(){
    	    document.forms[0].action = "NoCardHandle.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>