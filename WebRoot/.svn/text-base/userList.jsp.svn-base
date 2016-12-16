<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ page contentType="text/html; charset=gbk"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>老师信息列表</title>
		<link href="css/mymain.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="list">
			<s:form theme="simple">
				<table>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td align="center">
							<input name="new" type="button" value="新增用户" onclick="addUser();" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>
							<br></br>
						</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th>
							用户ID
						</th>
						<th>
							用户名
						</th>
						<th>
							用户类型
						</th>
						<th>
							密码
						</th>
						<th>
							email
						</th>
						<th>
							中文名
						</th>
						<th>
							操作
						</th>
					</tr>
					<s:iterator id="list" value="userList" status="sta">
						<tr>
							<td width="8%" align="center">
								${list.id}
							</td>
							<td width="8%" align="center">
								${list.user}
							</td>
							<td width="8%" align="center">
								<s:if test="2 == ${list.userType}">
			                                     老师用户
                                </s:if>
								<s:elseif test="3 == ${list.userType}">录入员</s:elseif>
								<s:elseif test="4 == ${list.userType}">体验课操作员</s:elseif>
								<s:elseif test="5 == ${list.userType}">活动课操作员</s:elseif>
							</td>
							<td width="8%" align="center">
								${list.pass}
							</td>
							<td width="8%" align="center">
								${list.email}
							</td>
							<td width="8%" align="center">
								${list.chineseName}
							</td>
							<td width="16%" align="center">
								<input name="edit" type="button" value="修改"
									onclick="editUser('${list.id}')" />
								<input name="delete" type="button" value="删除"
									onclick="deleteUser('${list.id}')" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:form>
		</div>
	</body>
</html>
<script>
	function addUser() {
		document.forms[0].action = "AddUser.action";
		document.forms[0].target = "main";
		document.forms[0].submit();
	}
	function editUser(userid) {
		document.forms[0].action = "EditUser.action?userid=" + userid;
		document.forms[0].target = "main";
		document.forms[0].submit();
	}
	function deleteUser(userid) {
		if (confirm("确定删除用户吗")) {
			document.forms[0].action = "DeleteUser.action?userid=" + userid;
			document.forms[0].target = "main";
			document.forms[0].submit();
		} else {
			return false;
		}

	}
</script>