<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<title>�Ͽ�ѧ���б�</title>
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
        <th><s:property value="#request.specifiedDateStr"/>��<s:property value="#request.roomno"/>���� ��<s:property value="#request.lessonno"/>�ڿ��Ͽ�ѧ����ϸ</th>
        </tr>
	<tr>
	    <th>���</th>
	    <th>ѧ���� ѧ������</th>
	    <th>����</th>
	    <th>�Ͽ���ʦ</th>
	    <th>�ڼ��ڿ�</th>
	    <th>�γ�����</th>    
		<th>�ֶ���¼ʱ��</th>
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
	<tr><td align="center"><input name="return" type="button" onclick="returnList('<s:property value="#request.specifiedDateStr"/>')" value="�����б�"/></td></tr>
	
	<!--
	<tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
	<tr><td></td>
        <td></td>
        <th>��<s:property value="todayStartDate"/>��<s:property value="todayEndDate"/>�˹�ѧ����¼</th>
        </tr>
	<tr>
	    <th>ѧ����</th>
	    <th>ѧ������</th>
	    <th>����</th>
	    <th>�Ͽ���ʦ</th>
	    <th>�ڼ��ڿ�</th>
	    <th>�γ�����</th>    
		<th>�ֶ���¼ʱ��</th>
		<th>����</th>
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