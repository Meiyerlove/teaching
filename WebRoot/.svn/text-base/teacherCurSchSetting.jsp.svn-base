<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<title>老师课程表设置</title>
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="list">
<s:form theme="simple">
<table >
<tr><td></td><td></td>
        <td width="20%" align="center"></td>
        <td></td>
        <td align="center"><input name="new" type="button" value="新增课" onclick="addLesson('<s:property value="tea.teaid"/>')"/></td>
	</tr>
    <tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
	<tr>
	    <th>老师工号</th>
	    <th>星期</th>
		<th>第几节课</th>
		<th>开始时间</th>
		<th>结束时间</th>
		<th>课程</th>
		<th>教室号</th>
	</tr>
	   <s:iterator id="list" value="#request.csl" status="sta">
		<tr>
            <td width="10%" align="center">${list.teaid}</td>
			<td width="10%" align="center">${list.weekday}</td>
			<td width="10%" align="center">${list.sequenceNumber}</td>
			<td width="10%" align="center">${list.fromtime}</td>
			<td width="10%" align="center">${list.totime}</td>
			<td width="10%" align="center">${list.subject}</td>
			<td width="10%" align="center">${list.roomNO}</td>
			<td width="16%" align="center">
			<input name="edit" type="button" value="修改" onclick="editLesson('${list.id}')"/>
			<input name="delete" type="button" value="删除" onclick="deleteLesson('${list.id}','<s:property value="tea.teaid"/>')"/></td>
		</tr>
	</s:iterator>
</table>
</s:form>
</div>
</body>
</html>
<script>   
        function addLesson(teaid){
    	    document.forms[0].action = "AddLesson.action?teaid="+teaid;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
        function editLesson(id){
    	    document.forms[0].action = "EditLesson.action?id="+id;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function deleteLesson(id, teaid){
    	    document.forms[0].action = "DeleteLesson.action?id="+id+"&teaid="+teaid;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>