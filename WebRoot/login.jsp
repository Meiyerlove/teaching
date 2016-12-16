<%@ page contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>用户登录</title>
		<link href="css/mymain.css" rel="stylesheet" type="text/css" />
	</head>
	
	<body >
	  <div id="main">
		<center>
		<h3>金博瑞会员消费管理系统操作平台</h3>
		<h3>请输入用户名和密码</h3>
		<br/>
		<!-- 如果还没有注册，单击此处<a href="Regist.jsp">注册</a> -->
		<font color="red"><s:actionerror/></font>
		<s:form action="Login.action" theme="simple">
		 <table>
			<tr><td>用户名:</td><td><s:textfield name="user" label="用户名"/></td></tr>
			<tr><td>密码:</td><td><s:password name="pass" label="密码"/></td></tr>
			<!-- <s:textfield name="vercode" label="验证码" value=""/> -->
			
			<tr><br/><td>
			</td>
			<td><s:submit value="登录"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:reset value="重置"/></td></tr>
		 </table>
		</s:form>
		<!-- 验证码如图：<img src="authImg" id="authImg"/>看不清？<a href="#" onClick="refresh()">单击此处刷新</a> -->
		</center>
      </div>
	</body>
	
</html>