<%@ page contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>�û���¼</title>
		<link href="css/mymain.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body >
	  <div id="main">
		<center>
		<h3>�����Ա���ѹ���ϵͳ����ƽ̨</h3>
		<h3>�������û���������</h3>
		<br/>
		<!-- �����û��ע�ᣬ�����˴�<a href="Regist.jsp">ע��</a> -->
		<font color="red"><s:actionerror/></font>
		<s:form action="Login.action" theme="simple">
		 <table>
			<tr><td>�û���:</td><td><s:textfield name="user" label="�û���"/></td></tr>
			<tr><td>����:</td><td><s:password name="pass" label="����"/></td></tr>
			<!-- <s:textfield name="vercode" label="��֤��" value=""/> -->
			
			<tr><br/><td>
			</td>
			<td><s:submit value="��¼"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:reset value="����"/></td></tr>
		 </table>
		</s:form>
		<!-- ��֤����ͼ��<img src="authImg" id="authImg"/>�����壿<a href="#" onClick="refresh()">�����˴�ˢ��</a> -->
		</center>
      </div>
	</body>
	
</html>