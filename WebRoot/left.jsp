<%@ page contentType="text/html; charset=utf-8"%>
<link href="css/mymain.css" rel="stylesheet" type="text/css" />
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="left">
<s:form action="Select.action">
        <table>
            <tr>
                <td>
                                   基本数据录入
                </td><td></td>
            </tr>
            <tr>
            <td></td>
                <td>
                    <a href="javascript:ListUser()">用户管理</a>
                </td>
            </tr>
            <tr>
            <td></td>
                <td>
                    <a href="javascript:ListEmployee()">学生信息管理</a>
                </td>
            </tr>
             <tr>
            <td></td>
                <td>
                    <a href="javascript:ListUncheckedEmployee()">待审核学生信息</a>
                </td>
            </tr>
            <tr>
            <td></td>
                <td>
                    <a href="javascript:ListContract()">合同信息管理</a>
                </td>
            </tr>
            <tr>
            <td></td>
                <td>
                    <a href="javascript:ListUncheckedContract()">待审核合同</a>
                </td>
            </tr>
            <tr>
            <td></td>
                <td>
                    <a href="javascript:ListTeacher()">老师信息</a>
                </td>
            </tr>
            <tr>
            <td></td>
                <td>
                    <a href="javascript:ListRoom()">教室信息</a>
                </td>
            </tr>
            <tr>
                <td>
                                   查询功能
                </td><td></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="javascript:selectStudentByTeacher()">查询老师的上课学生记录</a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="javascript:selectStudentRecord()">查询学生的上课记录</a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="javascript:noCardHandle()">手动批量输入上课记录</a>
                </td>
            </tr>
             <tr>
                <td></td>
                <td>
                    <a href="javascript:dropCourseHandle()">退课处理</a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="javascript:activityHandle()">活动课处理</a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="javascript:exClassHandle()">体验课处理</a>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <a href="javascript:forgetRank()">忘带卡排名</a>
                </td>
            </tr>
        </table>
</s:form>
</div>
<script>
    	function selectStudentByTeacher(){
    	    document.forms[0].action = "SelectRecord.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function selectStudentRecord(){
    	    document.forms[0].action = "SelectManualRecord.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function ListUser(){
    	    document.forms[0].action = "ListUser.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function ListTeacher(){
    	    document.forms[0].action = "ListTeacher.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function ListRoom(){
    	    document.forms[0].action = "ListRoom.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function ListEmployee(){
    	    document.forms[0].action = "ListEmployee.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function ListUncheckedEmployee(){
    	    document.forms[0].action = "ListUncheckedEmployee.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function ListUncheckedContract(){
    	    document.forms[0].action = "ListUncheckedContract.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function ListContract(){
    	    document.forms[0].action = "ListContract.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
         function noCardHandle(){
    	    document.forms[0].action = "NoCardHandle.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function dropCourseHandle(){
    	    document.forms[0].action = "DropCourseList.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function activityHandle(){
    	    document.forms[0].action = "ActivityHandle.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function exClassHandle(){
    	    document.forms[0].action = "ExClassHandle.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function forgetRank(){
    	    document.forms[0].action = "ForgetRank.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         function recoverCardRecord(){
    	    document.forms[0].action = "RecoverCardRecord.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>