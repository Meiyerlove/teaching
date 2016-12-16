<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>添加老师</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><th>添加老师</th></tr>  
    <tr><td align="right">老师工号:</td><td align="left"><s:hidden name="tea.id"/>
    <s:textfield name="tea.teaid" label="老师工号"/></td></tr>
    <tr><td align="right">老师名字:</td><td align="left"><s:textfield name="tea.teaname"/></td></tr>
    <tr><td align="right">电话:</td><td align="left"><s:textfield name="tea.teacell"/></td></tr>
    <tr><td align="right">email:</td><td align="left"><s:textfield name="tea.email"/></td></tr>
    <tr><td align="right"><input name="save" type="button" onclick="saveTeacher()" value="保存"/></td>
        <td align="right"><input name="save" type="button" onclick="returnList()" value="返回列表"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function saveTeacher(){
    	    document.forms[0].action = "SaveTeacher.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
     function returnList(){
    	    document.forms[0].action = "ListTeacher.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>