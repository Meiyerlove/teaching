<%@ page contentType="text/html; charset=gb2312" language="java" import="java.util.*" errorPage="" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%
List list_s=(List)request.getAttribute("singleQue");
//int s=40/list_s.size();
//List list_m=(List)request.getAttribute("moreQue");
//int m=60/list_m.size();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<title>�������߿���</title>
<link rel="stylesheet" href="../CSS/style.css"/>
<script language="javascript" src="../JS/AjaxRequest.js">
</script>
<script language="javascript">
timer = window.setInterval("showStartTime();showRemainTime();",1000); 
//�˴���Ҫ��&nocache="+new Date().getTime()�����򽫳���ʱ�䲻�Զ��߶������
function showStartTime(){
	var loader=new net.AjaxRequest("startExam.do?action=showStartTime&nocache="+new Date().getTime(),deal_s,onerror,"GET");
}
function showRemainTime(){
	var loader1=new net.AjaxRequest("startExam.do?action=showRemainTime&nocache="+new Date().getTime(),deal_r,onerror,"GET");
}
function onerror(){
window.open('../index.jsp','','toolbar,menubar,scrollbars,resizable,status,location,directories,copyhistory,height=600,width=778');
window.close();
}
function deal_s(){
	showStartTimediv.innerHTML=this.req.responseText;
}
function deal_r(){
	showRemainTimediv.innerHTML=this.req.responseText;
	if(this.req.responseText=="00:00:00"){
		questionsForm.submit.click();
	}
}
</script>
<script language=javascript>
function keydown(){
	if(event.keyCode==8){
		event.keyCode=0;
		event.returnValue=false;
		alert("��ǰ���ò�����ʹ���˸��");
	  }if(event.keyCode==13){
		event.keyCode=0;
		event.returnValue=false;
		alert("��ǰ���ò�����ʹ�ûس���");
	  }if(event.keyCode==116){
		event.keyCode=0;
		event.returnValue=false;
		alert("��ǰ���ò�����ʹ��F5ˢ�¼�");
	  }if((event.altKey)&&((window.event.keyCode==37)||(window.event.keyCode==39))){
		event.returnValue=false;
		alert("��ǰ���ò�����ʹ��Alt+��������������");
	  }if((event.ctrlKey)&&(event.keyCode==78)){
	   event.returnValue=false;
	   alert("��ǰ���ò�����ʹ��Ctrl+n�½�IE����");
	  }if((event.shiftKey)&&(event.keyCode==121)){
	   event.returnValue=false;
	   alert("��ǰ���ò�����ʹ��shift+F10");
	  }
}
function click() {
 event.returnValue=false;
	 alert("��ǰ���ò�����ʹ���Ҽ���");
}
document.oncontextmenu=click;

function doSubmit() {
   var size = ${size};
   for(var i = 0 ;i < size; i++){
      var answer = document.getElementsByName("answerArrS["+i+"]");
      var ischeck = 0;
      for(var j=0;j<answer.length-1;j++){
                    if(answer[j].checked){
                        ischeck = 1;
                    }
                }
      if(ischeck == 0){
         alert("����δ���꣬ �����ύ");
         return false;
      }
   }
   
   document.forms[0].method = "POST";
   document.forms[0].action = "/teaching/manage/startExam.do?action=submitTestPaper";
   document.forms[0].submit();

}
</script>

</head>

<body onLoad="showStartTime();showRemainTime();" onkeydown="keydown()">
<table width="770" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>
    <td width="40" height="39" background="../images/startExam_leftTop.jpg">&nbsp;</td>
    <td width="667" align="right" background="../images/startExam_top.jpg">&nbsp;	
	</td>
    <td width="19" background="../images/startExam_top.jpg">&nbsp;</td>
    <td width="44" background="../images/startExam_rightTop.jpg">&nbsp;</td>
  </tr>
  <tr>
    <td height="435" rowspan="2" background="../images/startExam_left.jpg">&nbsp;</td>
    <td height="43" colspan="2"><img src="../images/startExam_ico.jpg" width="117" height="43"></td>
    <td rowspan="2" background="images/startExam_right.jpg">&nbsp;</td>
  </tr>
  <tr>
    <td height="600" colspan="2" valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td colspan="2" align="center" class="title"> &nbsp;&nbsp;���̾�
          </td>
        </tr>
        <tr>
          <td width="64%">&nbsp;</td>
          <td width="36%">&nbsp;����<font color="red">100</font>��&nbsp;&nbsp;&nbsp;<font color="red"></font></td>
        </tr>
      </table>
	  <html:form action="/manage/startExam.do?action=submitTestPaper" method="post">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td>
<table id="single" width="90%"  border="0" cellspacing="0" cellpadding="0" align=center>

  <tr>
    <td colspan="4" height=23 style="font-size:11pt;">һ����<font color=red>��10�⣬ÿ��10�֣�A(10��)--B(7��)--C(4��)--D(1��)</font>��</td>
  </tr>
<logic:iterate id="questions" name="singleQue" type="com.wgh.actionForm.QuestionsForm" scope="request" indexId="ind">
  <tr>
    <td height=23 colspan="4" align=center nowrap>
	  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="8%" align=right height=23>[&nbsp;${ind+1}&nbsp;]</td>
		  <td width="2%">&nbsp;</td>
		  <td width="90%" align=left nowrap style="font-size:11pt;"><bean:write name="questions" property="subject" filter="true"/>
		  <html:hidden property="idArrS[${ind}]" name="questions"/>
		  </td>
        </tr>
      </table>
	</td>
  </tr>
  <tr>
    <td width="8%" height=23 nowrap>&nbsp;</td>
    <td width="3%" align=center nowrap><html:radio property="answerArrS[${ind}]" styleClass="noborder" value="A"/></td>
    <td width="3%" align=center nowrap>A.</td>
    <td width="86%" align=left nowrap><bean:write name="questions" property="optionA" filter="true"/></td>
  </tr>
  <tr>
    <td width="8%" height=23 nowrap>&nbsp;</td>
    <td width="3%" align=center nowrap><html:radio property="answerArrS[${ind}]" styleClass="noborder" value="B"/></td>
    <td width="3%" align=center nowrap>B.</td>
    <td width="86%" align=left nowrap><bean:write name="questions" property="optionB" filter="true"/></td>
  </tr>
  <tr>
    <td width="8%" height=23 nowrap>&nbsp;</td>
    <td width="3%" align=center nowrap><html:radio property="answerArrS[${ind}]" styleClass="noborder" value="C"/></td>
    <td width="3%" align=center nowrap>C.</td>
    <td width="86%" align=left nowrap><bean:write name="questions" property="optionC" filter="true"/></td>
  </tr>
  <tr>
    <td width="8%" height=23 nowrap>&nbsp;</td>
    <td width="3%" align=center nowrap><html:radio property="answerArrS[${ind}]" styleClass="noborder" value="D"/></td>
    <td width="3%" align=center nowrap>D.</td>
    <td width="86%" align=left nowrap><bean:write name="questions" property="optionD" filter="true"/></td>
  </tr>
  </logic:iterate>
</table>
		</td>
	  </tr>
        <tr>
		  <td align="center"><input type="hidden" name="examid" value="${examid}"><html:button property="button" styleClass="btn_grey" value="����" onclick="doSubmit();"/>		  </td>
        </tr>
      </table>
	  </html:form>
	  </td>
  </tr>
  <tr>
    <td width="40" height="40" background="../images/startExam_leftBottom.jpg">&nbsp;</td>
    <td colspan="2" background="../images/startExam_bottom.jpg">&nbsp;</td>
    <td background="../images/startExam_rightBottom.jpg">&nbsp;</td>
  </tr>
</table>
</body>
</html>
