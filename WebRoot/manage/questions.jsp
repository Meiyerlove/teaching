<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<jsp:useBean id="taoTi" class="com.wgh.dao.QuestionsDAO" scope="page"/>
<html>
<head>
<title>网络在线考试――后台管理</title>
<link href="../css/style.css" rel="stylesheet">
<script language="javascript">
function CheckAll(elementsA,elementsB){
	for(i=0;i<elementsA.length;i++){
		elementsA[i].checked = true;
	}
	if(elementsB.checked ==false){
		for(j=0;j<elementsA.length;j++){
			elementsA[j].checked = false;
		}
	}
}
//判断用户是否选择了要删除的记录，如果是，则提示“是否删除”；否则提示“请选择要删除的记录”
function checkdel(delid,formname){
	var flag = false;
	for(i=0;i<delid.length;i++){
		if(delid[i].checked){
			flag = true;
			break;
		}
	}
	if(!flag){
		alert("请选择要删除的记录！");
		return false;
	}else{
			if(confirm("确定要删除吗？")){
				formname.submit();
		}
	}
}
</script>

</head>
<body>
<%@ include file="top.jsp"%>
<table width="778" border="0" align="center" cellspacing="0" cellpadding="0">
  <tr>
    <td width="176" align="center" valign="top" bgcolor="#FFFFFF"><%@ include file="left.jsp"%></td>
    <td width="602" valign="top" bgcolor="#FFFFFF"><table width="99%" height="487"  border="0" cellpadding="0" cellspacing="0" align="right">
      <tr>
        <td height="30" bgcolor="#EEEEEE" class="tableBorder_thin"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="50%" class="word_grey">&nbsp;当前位置：<span class="word_darkGrey">评教题目管理  &gt;&gt;&gt;</span></td>
              <td align="right"><img src="../images/m_ico1.gif" width="3" height="9">&nbsp;当前用户：&nbsp;${tuser.user }</td>
              </tr>
          </table></td>
        </tr>
      <tr>
        <td align="center" valign="top">
<table width="96%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="70%" height="27" align="right"><img src="../images/add.gif" width="19" height="18">&nbsp;</td>
    <td width="20%" align="right"><html:link page="/manage/questions.do?action=questionsAddQuery">添加评教试题</html:link> </td>
  </tr>
</table>
<html:form action="/manage/questions.do?action=questionsDel" method="post">
<table width="96%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#FFFFFF" bordercolorlight="#67A8DB">

  <tr align="center" bgcolor="#A8D8FC">
	<td width="33%" bgcolor="#B2D6F1">评教题目</td>
	<td width="9%" bgcolor="#B2D6F1">试题类型</td>
	<td width="6%" bgcolor="#B2D6F1">修改</td>
	<td width="6%" bgcolor="#B2D6F1">选项</td>
  </tr>
	<logic:iterate id="questions" name="questionsQuery" type="com.wgh.actionForm.QuestionsForm" scope="request">
	<bean:define id="lessonID" name="questions" property="lessonId" type="Integer"/>
	<bean:define id="taoTiID" name="questions" property="taoTiId" type="Integer"/>
  <tr>
	<td align="center"><bean:write name="questions" property="subject" filter="true"/></td>
	<td align="center"><bean:write name="questions" property="type" filter="true"/></td>	
	<td align="center"><html:link page="/manage/questions.do?action=questionsModifyQuery" paramId="id" paramName="questions" paramProperty="ID">修改</html:link></td>
    <td align="center"><html:multibox property="delIdArray" styleClass="noborder"><bean:write name="questions" property="ID"/></html:multibox></td>
  </tr>
  </logic:iterate> 
</table>
<table width="94%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
	<td width="60%" height="24">&nbsp;</td>
	<td width="40%" align="right"><input name="checkbox" type="checkbox" class="noborder" onClick="CheckAll(questionsForm.delIdArray,questionsForm.checkbox)">
	  [全选/反选] [<a style="color:red;cursor:hand;" onClick="checkdel(questionsForm.delIdArray,questionsForm)">删除</a>]
	  <div id="ch">
		<input name="delid" type="checkbox" class="noborder" value="0">
	  </div></td>
	<!--层ch用于放置隐藏的checkbox控件，因为当表单中只是一个checkbox控件时，应用javascript获得其length属性值为undefine-->
	<script language="javascript">ch.style.display="none";</script>
  </tr>

</table>
  </html:form>
</td>
      </tr>
    </table></td>
  </tr>
</table>
<%@ include file="copyright.jsp"%>
</body>
</html>
