<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<title>列表</title>
<script src="javascript/common.js" language="JavaScript"></script>
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<style type="text/css"> 
body{ font-size:24px; line-height:24px;} 
.exp1{font-size:24px;} 
.exp2{font-size:xx-small;} 
</style> 
</head>
<body>
<div id="list">
<s:form action="Login.action" theme="simple">
<table><tr>    
	    <td width="7%" align="center">学生号:</td>
	    <td width="7%" align="center"><s:textfield name="hrEmpl.emplID"/></td>
        <td width="7%"align="center">学生名字:</td>
        <td width="7%"align="center"><s:textfield name="hrEmpl.emplName"/></td>
        <td width="10%"></td>
	</tr>
   <tr>
	    <td width="7%" align="center">开始日期</td>
	    <td width="7%" align="center"><s:datetimepicker name="todayStartDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd" cssStyle="exp1"/></td>
	    <td width="7%" align="center">结束日期</td>
	    <td width="7%" align="center"><s:datetimepicker name="todayEndDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/> </td>
	    <td width="10%" align="center"><input name="new" type="button" value="查询" onclick="onSearch()"/><br/></td>
	</tr>
 </table>
 		<div align="center"><table>
	<tr>
        <th>从<s:property value="todayStartDate"/>到<s:property value="todayEndDate"/>学生上课记录</th>
        </tr></table></div>
 <table>
    <tr>
	    <th>序号</th>
	    <th>上课日期</th>
	    <th>名字</th>
	    <th>第几节课</th>
	    <th>老师ID 老师名字</th>
	    <th>教室</th>
	    <th>课程</th>
	    <th>记录类型</th>
		<th>记录时间</th>
		<th>记录操作人</th>
	</tr>       
	<s:iterator id="list" value="manualRecordList" status="sta">
		<tr>
		    <td width="4%" align="center"><s:property value="#sta.index+1"/></td>
		    <td width="13%" align="center">${list.lessonDate}</td>
		    <td width="10%" align="center">${list.emplName}</td>
		    <td width="10%" align="center">${list.lessonNumber}</td>
            <td width="10%" align="center">${list.teacherID}${list.teacherName}</td>
            <td width="10%" align="center">${list.roomNO}</td>
			<td width="10%" align="center">${list.subject}</td>
			<td width="10%" align="center">${list.reasonType}</td>
			<td width="10%" align="center">${list.recordTimeFormat}</td>
			<td width="10%" align="center">${list.operBy}</td>
		</tr>
	</s:iterator>
	
	  
</table>
</s:form>
</div>
</body>
</html>
<script>   
        function onSearch(){
    	    document.forms[0].action = "SelectManualRecord.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>