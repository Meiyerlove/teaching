<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<title>上课学生列表</title>
<script src="javascript/common.js" language="JavaScript"></script>
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="list">
<s:form action="Login.action" theme="simple">
<table>
   <tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
	<tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
        
	<tr><td></td>
        <td></td>
        <th><s:property value="#request.specifiedDateStr"/>日<s:property value="#request.roomno"/>教室 第<s:property value="#request.lessonno"/>节课上课学生明细</th>
        </tr>
	<tr>
	    <th>序号</th>
	    <th>学生号 学生名字</th>
	    <th>教室</th>
	    <th>上课老师</th>
	    <th>第几节课</th>
	    <th>课程名称</th>    
		<th>手动记录时间</th>
	</tr>
	<s:iterator id="list" value="manualRecordList" status="sta">
		<tr>
		    <td width="8%" align="center"><s:property value="#sta.index+1"/></td>
            <td width="12%" align="center">${list.emplID} &nbsp;${list.emplName}</td>
            <td width="12%" align="center">${list.roomNO}</td>
			<td width="12%" align="center">${list.teacherID}&nbsp;${list.teacherName}</td>
			<td width="12%" align="center">${list.lessonNumber}</td>
            <td width="12%" align="center">${list.subject}</td>
            <td width="12%" align="center">${list.recordTimeFormat}</td>
		</tr>
	</s:iterator>
	<tr><td align="center"><input name="return" type="button" onclick="returnList('<s:property value="#request.specifiedDateStr"/>')" value="返回列表"/></td></tr>
	
	<!--
	<tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
	<tr><td></td>
        <td></td>
        <th>从<s:property value="todayStartDate"/>到<s:property value="todayEndDate"/>人工学生记录</th>
        </tr>
	<tr>
	    <th>学生号</th>
	    <th>学生名字</th>
	    <th>教室</th>
	    <th>上课老师</th>
	    <th>第几节课</th>
	    <th>课程名称</th>    
		<th>手动记录时间</th>
		<th>操作</th>
	</tr>
	<s:iterator id="list" value="manualRecordList" status="sta">
		<tr>
            <td width="16%" align="center">${list.teacherID}</td>
            <td width="16%" align="center">${list.teacherName}</td>
			<td width="16%" align="center">${list.subject}</td>
			<td width="20%" align="center">${list.emplID} &nbsp;${list.emplName}</td>
			<td width="20%" align="center">${list.reasonType}</td>
            <td width="16%" align="center">${list.recordTime}</td>
		</tr>
	</s:iterator>
	
	  
--></table>
</s:form>
</div>
</body>
</html>
<script>   
        function onSearch(){
    	    document.forms[0].action = "OnSearch.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function returnList(specifiedDateStr){
    	    document.forms[0].action = "SelectRecord.action?todayStartDate="+specifiedDateStr;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>