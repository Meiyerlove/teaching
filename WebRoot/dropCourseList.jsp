<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<title>列表</title>
<script src="javascript/common.js" language="JavaScript"></script>
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div id="list">
<s:form action="Login.action" theme="simple">
<s:if test="hasActionErrors()||hasActionMessages()">
<div id="div-error">
  <table width="100%" border="0" cellpadding="0" class="table-a">
    <tr>
      <th>提示信息 </th>
    </tr>
    <tr>
      <td height="26" align="center" bgcolor="#d9d9d9"><span class="redfont"><s:fielderror /><s:actionerror /><s:actionmessage/></span></td>
    </tr>
  </table>
</div>
</s:if>
<table><tr>    
	    <td width="7%" align="center">学生号:<s:textfield name="hrEmpl.emplID"/></td>
        <td width="7%"align="center">学生名字:<s:textfield name="hrEmpl.emplName"/></td>
        <td width="7%"></td>
	</tr></table>
<table>
   <tr>
	    <td width="7%" align="center">开始日期</td>
	    <td width="7%" align="center"><s:datetimepicker name="todayStartDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
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
        <!--<th>勾选</th>
	    --><th>序号</th>
	    <th>上课日期</th>
	    <th>学生ID 名字</th>
	    <th>第几节课</th>
	    <th>老师ID 老师名字</th>
	    <th>教室</th>
	    <th>课程</th>
	    <th>记录类型</th>
		<th>记录时间</th>
		<th>功能操作</th>
	</tr>       
	<s:iterator id="list" value="manualRecordList" status="sta">
		<tr>
		    <!--<td align="center"><s:checkbox theme="simple" id="permisskey" name="permisskey" fieldValue="${list.emplID}"/></td>
		    --><td width="4%" align="center"><s:property value="#sta.index+1"/></td>
		    <td width="15%" align="center">${list.lessonDate}</td>
		    <td width="10%" align="center">${list.emplID}${list.emplName}</td>
		    <td width="10%" align="center">${list.lessonNumber}</td>
            <td width="10%" align="center">${list.teacherID}${list.teacherName}</td>
            <td width="10%" align="center">${list.roomNO}</td>
			<td width="10%" align="center">${list.subject}</td>
			<td width="10%" align="center">${list.reasonType}</td>
			<td width="12%" align="center">${list.recordTimeFormat}</td>
			<td width="12%" align="center"><input name="delete" type="button" value="退课" onclick="dropCourse('${list.id}')"/></td>
			
		</tr>
	</s:iterator>
	
	  
</table>
</s:form>
</div>
</body>
</html>
<script>   
        
        function dropCourse(id){
        if(confirm("确定退课吗")){
                     document.forms[0].action = "DropCourse.action?id="+id;
			         document.forms[0].target = "main";
			         document.forms[0].submit();
                 }else{
                        return false;
                }
            //var r=document.getElementsByName("permisskey");  
            //var counter = 0
             //for(var i=0;i<r.length;i++){
                //if(r[i].checked){
                //           counter = counter + 1;
                //           }
                //}     
            //if(counter <= 0){
             //  alert('请选中要操作的学生!');
            //}else{    
            //}
         }
        function onSearch(){
    	    document.forms[0].action = "DropCourseList.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>