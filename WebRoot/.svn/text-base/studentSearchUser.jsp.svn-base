<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>查找学生</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><td align="center">学生号:<s:textfield name="hrEmpl.emplID"/></td>
        <td align="center">学生名字:<s:textfield name="hrEmpl.emplName"/></td>
        <td align="right"><input name="search" type="button" onclick="searchStudent()" value="查询"/></td>
    </tr>
    
    <tr><td></td>
        <td></td>
        <td><br></br></td>
        <td></td>
        <td></td></tr>
	<tr>
	    <th>操作</th>
	    <th>学生号</th>
	    <th>学生名字</th>
		
	</tr>
	<s:iterator id="list" value="heList" status="sta">
		<tr>
		    <td align="center"><s:checkbox theme="simple" id="permisskey" name="permisskey" fieldValue="${list.emplID}"/></td>
            <td align="center">${list.emplID}</td>
			<td align="center">${list.emplName}</td>
			
		</tr>
	</s:iterator>
	<tr><td align="center">
			<input name="edit" type="button" value="下一步" onclick="fillMoreLessonInformation()"/></td></tr>
	<!-- <s:iterator id="list" value="heList" status="sta">
		<tr>
            <td width="16%" align="center">${list.emplID}</td>
			<td width="16%" align="center">${list.emplName}</td>
			<td width="16%" align="center">
			<input name="edit" type="button" value="选择" onclick="chooseStudent('${list.emplID}')"/></td>
		</tr>
	</s:iterator> -->
	
</table>
</s:form>
</div>
</body>
</html>
<script>   
       function fillMoreLessonInformation(){
            var r=document.getElementsByName("permisskey");  
            var counter = 0
             for(var i=0;i<r.length;i++){
                if(r[i].checked){
                           counter = counter + 1;
                           }
                }     
            if(counter <= 0){
               alert('请选中要操作的学生!');
            }else{
               document.forms[0].action = "FillMoreLessonInformation.action";
			   document.forms[0].target = "main";
			   document.forms[0].submit();
            }
    	    
         }
      function searchStudent(){
    	    document.forms[0].action = "SearchStudent.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
      function chooseStudent(emplID){
    	    document.forms[0].action = "ChooseStudent.action?emplID="+emplID;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>