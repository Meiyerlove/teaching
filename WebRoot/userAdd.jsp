<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>����û�</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><th>����û�</th></tr>  
    <tr><td align="right">�û���:</td><td align="left"><s:textfield name="user.user"/></td></tr>
    <tr><td align="right">��ʼ����:</td><td align="left"><s:textfield name="user.pass"/></td></tr>
    <tr><td align="right">�û����ͣ���ѡ�� </td><td align="left"><s:select label="�ڼ��ڿ�" id="userType" name="user.userType" 
	list="#{2:'��ʦ�û�',3:'��Ϣ¼��Ա',4:'�����¼��Ա',5:'���¼��Ա'}"
       headerKey="-1" headerValue="��ѡ���û�����"/></td></tr>
    <tr><td align="right">email:</td><td align="left"><s:textfield name="user.email"/></td></tr>
    <tr><td align="right">��������</td><td align="left"><s:textfield name="user.chineseName"/></td></tr>
    <tr><td align="right"><input name="save" type="button" onclick="saveUser()" value="����"/></td>
        <td align="right"><input name="save" type="button" onclick="returnList()" value="�����б�"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveUser(){
      var userType = document.forms[0].userType.value;
      if(userType == -1){
        alert('�û����ͱ��');
        return false;
      }
      
    	    document.forms[0].action = "SaveUser.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
     function returnList(){
    	    document.forms[0].action = "ListUser.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>