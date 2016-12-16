<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head> 
	<script language="JavaScript1.2" src="javascript/stm31.js"></script>
	<script src="javascript/common.js" language="JavaScript"></script>
	<script type="text/javascript" src="javascript/prototype.js"></script>		
	<title>密码修改</title> 		
</head>
<script language="javascript">
	String.prototype.trim  =  function(){return  this.replace(/(^\s*)|(\s*$)/g,  "");}
	function ajaxCheck(){
	 new Ajax.Request( 'passwordCheck.action',
	   {
	         method:'post',
	         parameters: {oldPassword: document.forms[0].elements["oldPassword"].value},
	         onSuccess: function(transport){
	         var response = transport.responseText || "";
	         var value = response;
             //document.forms[0].elements["location.code"].value=value;
              if(value.trim()==""){
               document.all("ajax").style.display=""; 
               document.all("ajax").innerHTML="<font color=red>原密码正确！</font>"; 
              }else{
               document.all("ajax").style.display=""; 
               document.all("ajax").innerHTML="<font color=red>原密码错误！</font>"; 
              }
             
	         },
	         onFailure: function(){ alert('重发失败，请稍后再试...') }
	     });
	  }
	  
function changePassword(){
	if (isEmpty(document.forms[0].oldPassword.value)) {
		document.all("ajax").innerHTML="<font color=red>请输入原密码！</font>"; 
		document.forms[0].oldPassword.focus();
		return false;
	}
	else if (isEmpty(document.forms[0].password.value)) {
		document.all("ajax").innerHTML="<font color=red>新密码不能为空！</font>";
		document.forms[0].password.focus();
		return false;
	}else if (document.forms[0].password.value != document.forms[0].password2.value) {
		document.all("ajax").innerHTML="<font color=red>新密码与确认密码不一致！</font>";
		document.forms[0].password.focus();
		return false;		
	}	else if (confirm("确实要修改密码吗?")){
		document.forms[0].submit();
	}
}

function cancel(){	
	document.forms[0].action="waitForCall.action";
	document.forms[0].submit();
}

</script>
<body topmargin='0' leftmargin='0'>  
<form action="modifyPassword.action" method="post">	
<s:if test="hasActionErrors()||hasActionMessages()">
<div id="div-error">
  <table width="100%" border="0" cellpadding="0" class="table-a">
    <tr>
      <th>提示信息 </th>
    </tr>
    <tr>
      <td height="26" bgcolor="#d9d9d9"><span class="redfont"><s:fielderror /><s:actionerror /><s:actionmessage/></span></td>
    </tr>
  </table>
</div>
</s:if>
<div  id="ajax" align="center" style="display:none"></div>
<div id="main"><table width="100%" border="0" cellpadding="0" class="table-a">
    <tr>
      <th>密码修改</th>
    </tr>
  </table>
  <table width="100%" border="0" cellpadding="0" class="table-b">  
    <tr>
      <th width="28%">原密码:</th>
      <td >
   		<input type="password" onblur="ajaxCheck()" name="oldPassword" size="18" maxlength="20" class="input-a"/>   
      </td>
    </tr>
    <tr>
      <th width="28%">新密码:</th>
      <td >
   		<input type="password" name="password" size="18" maxlength="20" class="input-a"/>   
      </td>
    </tr>
    <tr>
      <th width="28%">确认密码:</th>
      <td >
   		<input type="password" name="password2" size="18" maxlength="20" class="input-a"/>
                 
      </td>
    </tr>             
    <tr>
      <th></th>
      <th><input name="B52" type="button" onclick="changePassword()" class="btn-dblue" value="保存" />
      <input name="B53" type="reset" class="btn-dblue" value="重置" />
      <s:if test="#session.sess_user.group.gid==1">
        <input name="B533" type="reset" onclick="cancel()" class="btn-dblue" value="返回" />
      </s:if>
      </th>
    </tr>
  </table>
</div>
</form>
<jsp:include page="bottom.jsp"/>
</body>
</html>