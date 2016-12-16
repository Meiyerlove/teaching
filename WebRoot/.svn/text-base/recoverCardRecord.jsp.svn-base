<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>老师信息列表</title>
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><td width="30%" align="center">学生号:<s:textfield name="hrEmpl.emplID"/></td>
        <td width="30%" align="center">学生名字:<s:textfield name="hrEmpl.emplName"/></td>
        <td width="40%" align="center"><input name="search" type="button" onclick="searchForgetStudent()" value="查询"/></td>
    </tr>
</table>
    
    <table>
    <tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td></tr>
	<tr>
	    <th>学生号</th>
	    <th>学生名字</th>
	    <th>老师号</th>
	    <th>老师名字</th>
	    <th>课程名称</th>
	    <th>记录时间</th>
		<th>手机号码</th>
		<th>补刷类型</th>
		<th>操作</th>
	</tr>
	<s:iterator id="list" value="mrl" status="sta">
		<tr>
            <td width="10%" align="center">${list.emplID}</td>
			<td width="10%" align="center">${list.emplName}</td>
			<td width="10%" align="center">${list.teacherID}</td>
			<td width="10%" align="center">${list.teacherName}</td>
			<td width="10%" align="center">${list.subject}</td>
			<td width="10%" align="center">${list.recordTime}</td>
			<td width="10%" align="center">${list.cellPhone}</td>
			<td width="10%" align="center">${list.reasonType}</td>
			<td width="10%" align="center">${list.contained}</td>
			<td width="10%" align="center">
			<s:if
				test="${list.contained}==true">
			<input name="edit" type="button" value="补刷" onclick="saveRecoverRecord('${list.id}')"/></s:if>
			<s:else>
			<input name="edit" type="button" disabled value="补刷" onclick="saveRecoverRecord('${list.id}')"/>
			</s:else>
			</td>
		</tr>
	</s:iterator>
</table>
</s:form>
</div>
</body>
</html>
<script>   
         function searchForgetStudent(){
    	    document.forms[0].action = "SearchForgetStudent.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function saveRecoverRecord(id){
    	    document.forms[0].action = "SaveRecoverRecord.action?id="+id;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }

</script>