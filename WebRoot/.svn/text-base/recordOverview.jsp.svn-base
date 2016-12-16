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
   <tr>
	    <td align="center">日期</td><td align="center"><s:datetimepicker name="todayStartDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
		<td align="center"><input name="new" type="button" value="查询" onclick="onSearch()"/><br/></td>
	</tr></table>
	<!--  
	<s:iterator id="list" value="stuList" status="sta">
		<tr>
            <td width="16%" align="center">${list.teaName}</td>
            <td width="16%" align="center">${list.weekDay}.${list.subject}</td>
			<td width="16%" align="center">${list.stuID}</td>
			<td width="20%" align="center">${list.sdate} &nbsp;${list.stime}</td>
            <td width="16%" align="center">${list.stuName}</td>
			<td width="16%" align="center">=</td>
		</tr>
	</s:iterator>-->
	<div align="center"><table>
	<tr>
        <th><s:property value="#request.fullDateFormat"/>上课老师学生总览</th>
        </tr></table></div>

    
	<!--
	<s:iterator id="list" value="#request.recordSet" status="sta">
		<tr>
		    <td width="4%" align="center"><s:property value="#sta.index+1"/></td>
		    <td>11</td>
		    <s:iterator value="#list.record" id="record">
		    <td>
		        <s:property value="{record.cell.teaID}"/> 
                <s:property value="{record.cell.subject}"/></td>
                <td width="16%" align="center">${record.cell.teaID}</td>
                <td width="16%" align="center">${record.cell.subject}</td>
            </s:iterator>
		</tr>
	</s:iterator>
	
	-->
	<table border="1">
	<tr>
	  <th>第几节课/教室</th>
	  <th>上课时间</th>
	<s:iterator id="list" value="#request.roomList" status="sta">
	  <th width="8%" align="center"><s:hidden name="roomID" value="${list.id}"/>${list.roomno}</th>
	</s:iterator>
	</tr>
	<s:iterator id="row" value="#request.recordSet" status="sta">
		<tr>
		    <td width="5%" align="center"><s:property value="#sta.index+1"/></td>
		    <td width="6%" align="center">${row.lessonTime}</td>
		    <s:iterator value="#row.cellList" id="cell">
		    <td width="8%" align="center">${cell.teaName}&nbsp; ${cell.recordNumber}<s:if test="${cell.recordNumber}!=null">人</s:if> &nbsp;${cell.subject}
                 <s:if test="${cell.lessonno}!=0">
                 <a href="javascript:lessonRecordDetail('<s:property value="#request.fullDateFormat"/>','${cell.roomID}','${cell.roomno}','${cell.lessonno}')">上课学生明细</a>
                 </s:if>
                 </td>
		    </s:iterator>
		</tr>
		
	</s:iterator>
	<!--<s:iterator id="list" value="#request.roomList" status="sta">
		<tr>
            <td width="16%" align="center">${list.id}</td>
            <td width="16%" align="center">${list.roomno}</td>
			<td width="16%" align="center">=</td>
		</tr>
	</s:iterator>
	  
--></table>
	<div align="center"><table>
	<tr>
        <th><s:property value="#request.fullDateFormat"/>活动课上课记录</th>
        </tr></table></div>
<table>
	<tr>
	    <th>序号</th>
	    <th>老师ID</th>
	    <th>老师名字</th>
	    <th>学生ID 名字</th>
	    <th>上课日期</th>
	    <th>备注</th>
		<th>记录时间</th>
	</tr>
	<s:iterator id="list" value="manualRecordList" status="sta">
		<tr>
		    <td width="8%" align="center"><s:property value="#sta.index+1"/></td>
            <td width="12%" align="center">${list.teacherID}</td>
            <td width="12%" align="center">${list.teacherName}</td>
			<td width="16%" align="center">${list.emplID} &nbsp;${list.emplName}</td>
			<td width="16%" align="center">${list.lessonDate}</td>
			<td width="18%" align="center">${list.note}</td>
            <td width="16%" align="center">${list.recordTimeFormat}</td>
		</tr>
	</s:iterator>
	</table>
		<div align="center"><table>
	<tr>
        <th><s:property value="#request.fullDateFormat"/>体验课上课记录</th>
        </tr></table></div>
	<table>
	<tr>
	    <th>序号</th>
	    <th>上课日期</th>
	    <th>开始时间</th>
	    <th>结束时间</th>
	    <th>老师ID名字</th>
	    <th>顾问</th>
	    <th>上课学生数</th>
	    <th>课程名称</th>
	    <th>教室</th>
	    <th>备注</th>
		<th>记录时间</th>
	</tr>
	<s:iterator id="list" value="exClassRecordList" status="sta">
		<tr>
		    <td width="6%" align="center"><s:property value="#sta.index+1"/></td>
            <td width="8%" align="center">${list.classDate}</td>
            <td width="8%" align="center">${list.startTime}</td>
            <td width="8%" align="center">${list.endTime}</td>
			<td width="12%" align="center">${list.teacherID} &nbsp;${list.teacherName}</td>
			<td width="6%" align="center">${list.consultant}</td>
			<td width="6%" align="center">${list.stuNumber}</td>
			<td width="6%" align="center">${list.subject}</td>
			<td width="6%" align="center">${list.roomNo}</td>
			<td width="10%" align="center">${list.note}</td>
            <td width="10%" align="center">${list.recordTimeFormat}</td>
		</tr>
	</s:iterator>
	</table>
</s:form>
</div>
</body>
</html>
<script>   
        function onSearch(){
    	    document.forms[0].action = "SelectRecord.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
          function lessonRecordDetail(specifiedDate, roomid, roomno, lessonno){
    	    document.forms[0].action = "LessonRecordDetail.action?specifiedDate="+specifiedDate+"&roomid="+roomid+"&roomno="+roomno+"&lessonno="+lessonno;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>