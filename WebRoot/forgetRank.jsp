<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<title>������ѧ������</title>
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
   <tr>
	    <td align="center">��ʼ����</td><td align="center"><s:datetimepicker name="todayStartDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
	    <td align="center">��������</td><td align="center"><s:datetimepicker name="todayEndDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/> </td>
		<td align="center"><input name="new" type="button" value="��ѯ" onclick="searchForgetRank()"/><br/></td>
	</tr>
	
	<tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
        
      <tr><td></td>
        <td></td>
        <th>������ѧ������</th>
        <td></td>
        <td></td></tr> 
        
        <tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
             
        <tr>
        <th>����</th>
        <th>ѧ��ID</th>
	    <th>ѧ������</th>
	    <th>����������</th>
	    <th>��ϵ��ʽ</th>
	    </tr>
        	<s:iterator value="#request.stuRankList" id="item" status="sta">
        
		<tr>
		    <td width="16%" align="center"><s:property value="#sta.index+1"/></td>
            <td width="16%" align="center"><s:property value="#item[1].trim()" /></td>
            <td width="16%" align="center"><s:property value="#item[2].trim()" /></td>
            <td width="16%" align="center"><s:property value="#item[0]" /></td>
            <td width="16%" align="center"><s:property value="#item[3].trim()" /></td>
		</tr>
	</s:iterator>
	  
</table>
</s:form>
</div>
</body>
</html>
<script>   
        function searchForgetRank(){
    	    document.forms[0].action = "SearchForgetRank.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>