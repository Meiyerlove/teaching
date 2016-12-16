<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>添加用户</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><th>添加用户</th></tr>  
    <tr><td align="right">用户名:</td><td align="left"><s:textfield name="user.user"/></td></tr>
    <tr><td align="right">初始密码:</td><td align="left"><s:textfield name="user.pass"/></td></tr>
    <tr><td align="right">用户类型（必选） </td><td align="left"><s:select label="第几节课" id="userType" name="user.userType" 
	list="#{2:'老师用户',3:'信息录入员',4:'体验课录入员',5:'活动课录入员'}"
       headerKey="-1" headerValue="请选择用户类型"/></td></tr>
    <tr><td align="right">email:</td><td align="left"><s:textfield name="user.email"/></td></tr>
    <tr><td align="right">中文名字</td><td align="left"><s:textfield name="user.chineseName"/></td></tr>
    <tr><td align="right"><input name="save" type="button" onclick="saveUser()" value="保存"/></td>
        <td align="right"><input name="save" type="button" onclick="returnList()" value="返回列表"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveUser(){
      var userType = document.forms[0].userType.value;
      if(userType == -1){
        alert('用户类型必填！');
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