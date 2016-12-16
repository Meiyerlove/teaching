<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<s:head theme="ajax" /> 
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>手动输入学生上课记录</title>
<style>
.input{width:250px;height:50px;font-size:50px; line-height:50px;}
.button{width:180px;height:50px;font-size:20px; line-height:50px;}
.characteristic{font-size:30px;}
</style>
</head>
<body>
<div id="list">
<s:form theme="simple">
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
<div align="center">
<table align="center" class="characteristic"> 
    <tr><th>上课学生的信息</th></tr>  
		<tr>
            <td align="center"><s:property value="mr.emplID"/><s:hidden id="emplID" name="mr.emplID"/><s:hidden id="emplIDs" name="emplID" value="${list.emplID}"/> </td>
			<td align="center"><s:property value="mr.emplName"/><s:hidden id="emplName" name="mr.emplName"/></td>
		</tr>
	<tr>
	    <td align="center">上课日期:</td><td align="center"><s:property value="mr.lessonDate"/><s:hidden id="lessonDate" name="mr.lessonDate"/></td>
	</tr>
	<tr>
	    <td align="center">第几节课: </td>
	    <td align="center">第<s:property value="mr.lessonNumber"/>节课<s:hidden label="教室号" id="lessonNumber" name="mr.lessonNumber"/></td>
	</tr>
	<tr>
	    <td align="center">教室号:</td>
	    <td align="center"><s:property value="mr.roomID"/>&nbsp;<s:property value="mr.roomNO"/><s:hidden label="教室号" id="roomID" name="mr.roomID"/><s:hidden label="教室号" id="roomNO" name="mr.roomNO"/></td></tr>
    <tr>
        <td align="center">老师号和姓名:</td>
        <td align="center"><s:property value="mr.teacherID"/>&nbsp;<s:property value="mr.teacherName"/><s:hidden id="roomNO" name="mr.teacherID"/>
                         <s:hidden id="roomNO" name="mr.teacherName"/></td>
    </tr>
    <tr>
      <td align="center">课程名称:</td>
      <td align="center"><s:property value="mr.subject"/><s:hidden label="课程名称" id="subject"  name="mr.subject"/></td></tr>
    <tr>
    </tr>
    </table></div>
<div align="center">
    <table>
    <tr>
    <td align="center"><font color=red size=10>家长请输入密码</font></td>
      </tr>
    <tr>
      <td align="center"><input id="iniPass" type="password" name="hrEmpl.iniPass" size="20" class="input"/></td></tr>
    
    <tr><td align="center"><input name="save" type="button" class="button" onclick="saveManualRecord()" value="密码确认"/>
    <input name="save" class="button" type="button" onclick="returnList()" value="取消处理并返回"/></td></tr>
</table>
</div>
</s:form>
</div>
</body>
</html>
<script>   
      function saveManualRecord(){
      var iniPass = document.getElementById("iniPass").value;
      if(null == iniPass || iniPass == ''){
        alert('请输入密码！');
        return false;
      }

    	    document.forms[0].action = "SaveManualRecordUser.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
     function returnList(){
    	    document.forms[0].action = "NoCardHandle.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>