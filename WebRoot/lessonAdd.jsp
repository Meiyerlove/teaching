<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>�ӿ�</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><td align="right">��ʦ����:</td><td align="left"><s:hidden name="tea.teaid"/>
    <s:textfield name="tea.teaid" disabled="true"/></td></tr>
    <tr><td align="right">��ʦ����:</td><td align="left"><s:textfield name="tea.teaname" disabled="true"/></td></tr>
    <tr><td align="right">����</td><td align="left"><s:textfield id="weekdayid" name="cs.weekday"/></td></tr>
    <tr><td align="right">�ڼ��ڿ�</td><td align="left"><s:textfield name="cs.sequenceNumber"/></td></tr>
    <tr><td align="right">��ʼʱ��</td><td align="left"><s:textfield name="cs.fromtime"/></td><td align="left">��ʽhh:mm</td></tr>
    <tr><td align="right">����ʱ��</td><td align="left"><s:textfield name="cs.totime"/></td><td align="left">��ʽhh:mm</td></tr>
    <tr><td align="right">�γ�</td><td align="left"> <s:select id="subjectid" name="cs.subject" list="#request.subjectList"
       headerKey="-1" headerValue="��ѡ��γ�����"/></td></tr>
    <tr><td align="right">���Һ�</td><td align="left"><s:select id="roomid" name="cs.roomNO" list="#request.roomNOList"
       headerKey="-1" headerValue="��ѡ�����"/></td></tr>
    <tr><td align="right"><input name="save" type="button" onclick="saveNewLesson()" value="����"/></td>
    <td align="right"><input name="save" type="button" onclick="returnTeacherCurschList('<s:property value="tea.teaid"/>')" value="�����б�"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveNewLesson(){
      var weekdayid = document.getElementById("weekdayid").value;
      if(null == weekdayid || weekdayid == ''){
        alert('���ڼ����');
        return false;
      }
      var subjectid = document.getElementById("subjectid").value;
      if(subjectid == -1){
        alert('�γ�����ѡ��');
        return false;
      }
      var roomid = document.getElementById("roomid").value;
      if(roomid == -1){
        alert('���Һű�ѡ��');
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