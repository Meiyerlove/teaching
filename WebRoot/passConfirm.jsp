<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>�ֶ�����ѧ���Ͽμ�¼</title>
<style>
.input{width:250px;height:50px;font-size:50px; line-height:50px;}
.button{width:180px;height:50px;font-size:20px; line-height:50px;}
.characteristic{font-size:30px;}
</style>
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
      <td height="26" align="center" bgcolor="#d9d9d9"><span class="redfont"><s:fielderror /><s:actionerror /><s:actionmessage/></span></td>
    </tr>
  </table>
</div>
</s:if>
<div align="center">
<table align="center" class="characteristic"> 
    <tr><th>�Ͽ�ѧ������Ϣ</th></tr>  
		<tr>
            <td align="center"><s:property value="mr.emplID"/><s:hidden id="emplID" name="mr.emplID"/><s:hidden id="emplIDs" name="emplID" value="${list.emplID}"/> </td>
			<td align="center"><s:property value="mr.emplName"/><s:hidden id="emplName" name="mr.emplName"/></td>
		</tr>
	<tr>
	    <td align="center">�Ͽ�����:</td><td align="center"><s:property value="mr.lessonDate"/><s:hidden id="lessonDate" name="mr.lessonDate"/></td>
	</tr>
	<tr>
	    <td align="center">�ڼ��ڿ�: </td>
	    <td align="center">��<s:property value="mr.lessonNumber"/>�ڿ�<s:hidden label="���Һ�" id="lessonNumber" name="mr.lessonNumber"/></td>
	</tr>
	<tr>
	    <td align="center">���Һ�:</td>
	    <td align="center"><s:property value="mr.roomID"/>&nbsp;<s:property value="mr.roomNO"/><s:hidden label="���Һ�" id="roomID" name="mr.roomID"/><s:hidden label="���Һ�" id="roomNO" name="mr.roomNO"/></td></tr>
    <tr>
        <td align="center">��ʦ�ź�����:</td>
        <td align="center"><s:property value="mr.teacherID"/>&nbsp;<s:property value="mr.teacherName"/><s:hidden id="roomNO" name="mr.teacherID"/>
                         <s:hidden id="roomNO" name="mr.teacherName"/></td>
    </tr>
    <tr>
      <td align="center">�γ�����:</td>
      <td align="center"><s:property value="mr.subject"/><s:hidden label="�γ�����" id="subject"  name="mr.subject"/></td></tr>
    <tr>
    </tr>
    </table></div>
<div align="center">
    <table>
    <tr>
    <td align="center"><font color=red size=10>�ҳ�����������</font></td>
      </tr>
    <tr>
      <td align="center"><input id="iniPass" type="password" name="hrEmpl.iniPass" size="20" class="input"/></td></tr>
    
    <tr><td align="center"><input name="save" type="button" class="button" onclick="saveManualRecord()" value="����ȷ��"/>
    <input name="save" class="button" type="button" onclick="returnList()" value="ȡ����������"/></td></tr>
</table>
</div>
</s:form>
</div>
</body>
</html>
<script>   
      function saveManualRecord(){
      var iniPass = document.getElementById("iniPass").value;
      if(null == iniPass || iniPass == ''){
        alert('���������룡');
        return false;
      }

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