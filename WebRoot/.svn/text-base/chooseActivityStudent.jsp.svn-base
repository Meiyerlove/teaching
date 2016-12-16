<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<title>活动课处理--学生列表</title>
</head>
<body>
<div id="list">
<s:form theme="simple">
<table>
    <tr><td width="30%" align="center">学生号:<s:textfield name="hrEmpl.emplID"/></td>
        <td width="30%" align="center">学生名字:<s:textfield name="hrEmpl.emplName"/></td>
        <td width="40%" align="center"><input name="search" type="button" onclick="searchActivityStudentByIDorName()" value="查询"/></td>
    </tr>
    </table>
    
    <table>

	<tr>
	    <th width="20%">全选/选择</th>
	    <th width="30%">学生号</th>
	    <th width="30%">学生名字</th>
		<th width="30%">操作</th>
	</tr>
	<s:iterator id="list" value="heList" status="sta">
		<tr>
		    <td><s:checkbox theme="simple" id="permisskey" name="permisskey" fieldValue="${list.emplID}"/></td>
            <td align="center">${list.emplID}</td>
			<td align="center">${list.emplName}</td>
			
		</tr>
	</s:iterator>
	<tr><td align="center">
			<input name="edit" type="button" value="下一步" onclick="fillMoreInformation()"/></td></tr>
</table>
</s:form>
</div>
</body>
</html>
<script>   
      function fillMoreInformation(){
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
               document.forms[0].action = "FillMoreInformation.action";
			   document.forms[0].target = "main";
			   document.forms[0].submit();
            }
    	    
         }
         
          function searchActivityStudentByIDorName(){
    	    document.forms[0].action = "SearchActivityStudentByIDorName.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>