<%@ page contentType="text/html; charset=utf-8"%>
<% String user =(String) session.getAttribute("user"); %>
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<div id="top">
      <form>
        <table>
            <tr>
                <td valign="middle">
                    <%=user %>,欢迎您登录系统&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <img src="images/jbr_logo_1.gif" />
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <img src="images/cut-line.gif" />
                    <a href="javascript:doPassword()">修改密码</a>
                    <img src="images/cut-line.gif"/>
                    <a href="javascript:logout()">退出</a>
                </td>
            </tr>
        </table>
        </form>
</div>
<script>
function logout(){
			if (confirm("您确定要退出吗?")){
				document.forms[0].action = "logoff.action";
				document.forms[0].target = "_parent";
				document.forms[0].submit();
			}	
		}
		
function doPassword(){
			if(!confirm("确认要修改密码吗?"))return ;
			document.forms[0].action = "password.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
		}
</script>
