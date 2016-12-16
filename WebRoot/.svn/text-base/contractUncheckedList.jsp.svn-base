<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ page contentType="text/html; charset=gbk"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>合同信息列表</title>
		<link href="css/mymain.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="list">
			<s:form theme="simple">
				<div align="center">
					<table>
						<tr>
							<th>
								待审核合同信息列表
							</th>
						</tr>
					</table>
				</div>
				<table>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td align="center">
							<input name="new" type="button" value="新增合同"
								onclick="addUncheckedContract()" />
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
				</table>
				<!--<table><tr>    
        <td width="50%" align="center">学生名字:<s:textfield name="he.emplName"/></td>
        <td width="10%" align="center"><input name="new" type="button" value="查询" onclick="onSearchContract()"/><br/></td>
        <td></td>
        <td></td><td></td>
	</tr></table>
	-->
				<table>
					<tr>
						<th>
							序号
						</th>
						<th>
							合同编号
						</th>
						<th>
							学生
						</th>
						<th>
							有效课时数
						</th>
						<th>
							合同金额
						</th>
						<th>
							签约日期
						</th>
						<th>
							合同期限
						</th>
						<th>
							合同付款状态
						</th>
						<th>
							合同类型
						</th>
						<th>
							顾问
						</th>
						<th>
							合同照片
						</th>
						<th>
							操作人
						</th>
						<th>
							功能操作
						</th>
					</tr>
					<s:iterator id="list" value="conList" status="sta">
						<tr>
							<td width="4%" align="center">
								<s:property value="#sta.index+1" />
							</td>
							<td width="7%" align="center">
								${list.contractNO}
							</td>
							<td width="7%" align="center">
								${list.emplName}
							</td>
							<td width="7%" align="center">
								${list.totalLessonAmount}
							</td>
							<td width="7%" align="center">
								${list.amount}
							</td>
							<td width="7%" align="center">
								${list.contractDateFormat}
							</td>
							<td width="7%" align="center">
								${list.expireDateFormat}
							</td>
							<td width="7%" align="center">
								${list.contractPayStatus}
							</td>
							<td width="7%" align="center">
								${list.contractType}
							</td>
							<td width="7%" align="center">
								${list.salesConsultant}
							</td>
							<td width="8%" align="center">
								<s:if test="1 == ${list.isExistImage}">
									<a
										href="${pageContext.request.contextPath}/Contract/${list.contractNO}.jpg"
										target="_blank"> <img
											src="${pageContext.request.contextPath}/images/touxiang1.jpg" />
									</a>
								</s:if>
								<s:else>暂无照片</s:else>
							</td>
							<td width="7%" align="center">
								${list.userName}
							</td>
							<td width="10%" align="center">
								<s:if test="1 != ${attr.displayCheck}">
									<input name="check" type="button" value="审核"
										onclick="checkContract('${list.contractNO}')" />
								</s:if>

								<!--<input name="delete" type="button" value="编辑"
									onclick="editEmployee('${list.emplID}')" disabled="true" />
								--><input name="delete" type="button" value="删除"
									onclick="deleteContract('${list.contractNO}')" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:form>
		</div>
	</body>
</html>
<script><!--   
        function detailEmployee(emplID){
    	    document.forms[0].action = "DetailEmployee.action?emplID="+emplID;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function editEmployee(emplID){
    	    document.forms[0].action = "EditEmployee.action?emplID="+emplID;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
          function addUncheckedContract(){
    	    document.forms[0].action = "AddUncheckedContract.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function checkContract(contractNO){
             if(confirm("审核合同通过确认")){
                     document.forms[0].action = "CheckContract.action?contractNO="+contractNO;
			         document.forms[0].target = "main";
			         document.forms[0].submit();
                 }else{
                        return false;
                }
    	   
         }
         
          function deleteContract(contractNO){
             if(confirm("确定删除合同吗")){
                     document.forms[0].action = "DeleteUncheckedContract.action?contractNO="+contractNO;
			         document.forms[0].target = "main";
			         document.forms[0].submit();
                 }else{
                        return false;
                }
    	   
         }
         
         function sortContractByTotalUp(){
    	    document.forms[0].action = "SortContractByTotalUp.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
          function sortContractByTotalDown(){
    	    document.forms[0].action = "SortContractByTotalDown.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function sortContractByDateUp(){
    	    document.forms[0].action = "SortContractByDateUp.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
          function sortContractByDateDown(){
    	    document.forms[0].action = "SortContractByDateDown.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
          function onSearchContract(){
    	    document.forms[0].action = "SearchContract.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         /*function editTeacher(teaid){
    	    document.forms[0].action = "EditTeacher.action?teaid="+teaid;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function deleteTeacher(teaid){
    	    document.forms[0].action = "DeleteTeacher.action?teaid="+teaid;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function editCurSch(teaid){
    	    document.forms[0].action = "EditCurSch.action?teaid="+teaid;
			document.forms[0].target = "main";
			document.forms[0].submit();
         }*/
--></script>