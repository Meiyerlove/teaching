<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>编辑用户信息</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><th>编辑用户</th></tr>  
    <tr><td align="right">用户名:</td><td align="left"><s:hidden name="user.id"/><s:hidden name="user.userType"/><s:textfield name="user.user"/></td></tr>
    <tr><td align="right">初始密码:</td><td align="left"><s:textfield name="user.pass"/></td></tr>
    <tr><td align="right">email:</td><td align="left"><s:textfield name="user.email"/></td></tr>
    <tr><td align="right">中文名字</td><td align="left"><s:textfield name="user.chineseName"/></td></tr>
    <tr><td align="right"><input name="save" type="button" onclick="updateUser()" value="保存"/></td>
        <td align="right"><input name="save" type="button" onclick="returnList()" value="返回列表"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
    function updateUser(){
    	    document.forms[0].action = "UpdateUser.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
     function returnList(){
    	    document.forms[0].action = "ListUser.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>