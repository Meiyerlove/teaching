<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<s:head theme="ajax" />
<title>添加合同</title>
    <link href="css/mymain.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="development-bundle/themes/base/jquery.ui.all.css">
	<script type="text/javascript">var jQuery=$;</script>   
	<script src="development-bundle/jquery-1.10.2.js"></script>
	<script src="development-bundle/ui/jquery.ui.core.js"></script>
	<script src="development-bundle/ui/jquery.ui.widget.js"></script>
	<script src="development-bundle/ui/jquery.ui.position.js"></script>
	<script src="development-bundle/ui/jquery.ui.menu.js"></script>
	<script src="development-bundle/ui/jquery.ui.autocomplete.js"></script>
	<!--<link rel="stylesheet" href="development-bundle/demos/demos.css">
	-->
	<script src="javascript/stm31.js"></script>
    <script src="javascript/common.js"></script>
    <script src="javascript/prototype.js"></script>	
	<script>
	
	jQuery(function() {
	    var nameStr = "${attr.nameStr}"
	    var names = new Array(); 
	    names = nameStr.split(",");
	    //for(var i = 0; i < names.length-1; i++){
	    //alert(names[i]);
	    //}
	    var availableTags = names;
		//var availableTags = [
		//    names
		//];
		jQuery( "#emplName" ).autocomplete({
			source: availableTags
		});
	});
	</script>
</head>

<body>
<div id="list">
<s:form theme="simple" enctype="multipart/form-data" method="post">
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
<div  id="ajax" align="center" style="display:none"></div>
<div><table align="center"><tr><th>添加合同</th></tr></table></div>

<!--<font color="red"><s:actionerror/></font>
--><div><table align="center" border="1">
    <tr>
        <td align="right">合同编号:</td><td align="left"><s:textfield id="contractNO" name="con.contractNO" onblur="ajaxCheck()"/></td>
        <td align="right">学生姓名:</td><td align="left"><input id="emplName" name="con.emplName" onblur="ajaxEmplNameCheck()"/></td>
    </tr>
     <tr>       
        <td align="right">有效课时数:</td><td align="left"><s:textfield id="totalLessonAmount"  name="con.totalLessonAmount"/></td>  
        <td align="right">合同付款状态:</td><td align="left">
          <s:select id="contractPayStatus" name="con.contractPayStatus" list="{'已付款'}"
          headerKey="未付款" headerValue="未付款"/>
       </td>
    </tr>
    
    <tr>
        <td align="right">合同金额:</td><td align="left"><s:textfield id="amount" name="con.amount"/></td>
        <td align="right">合同类型:</td><td align="left">
          <s:select id="contractType" name="con.contractType" list="{'续约','转课'}"
          headerKey="新约" headerValue="新约"/>
       </td>
    </tr>
    <tr>
        <td align="right">签约日期:</td><td align="center"><s:datetimepicker name="contractDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
        <td align="right">合同期限:</td><td align="center"><s:datetimepicker name="expireDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
    </tr>
     <tr>
        <td align="right">顾问</td><td align="left"><s:textfield id="consultant" name="con.salesConsultant"/></td>
        <td align="right">合同照片</td><td align="left">文件:<input type="file" name="image"></td>    
    </tr>
    <!-- 
     <tr>
	    <td align="center">开始日期</td><td align="center"><s:datetimepicker language="zh-cn"  name="todayStartDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/></td>
	    <td align="center">结束日期</td><td align="center"><s:datetimepicker language="zh-cn"  name="todayEndDate" label="Format (yyyy-MM-dd)" displayFormat="yyyy-MM-dd"/> </td>
	</tr>
    
   <tr>
         <td align="right">合同状态:</td><td align="left"><s:textfield id="contractStatus" name="con.contractStatus"/></td> 
           
    </tr>  -->
</table></div>
<div><HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1/></div>
<div><table width="100%"> <tr><td align="right"><input name="save" type="button" onclick="saveContract()" value=" 保  存"/></td>
    <td align="left"><input name="save" type="button" onclick="returnList()" value="返回列表"/></td></tr></table></div>
</s:form>
</div>
</body>
</html>
<script>   
    //var name = ocument.forms[0].elements["emplName"].value;
    //name=encodeURI(name); 
    //name=encodeURI(name); //最重要的部分,两次调用encodeURI ,就是编码两次
    String.prototype.trim  =  function(){return  this.replace(/(^\s*)|(\s*$)/g,  "");}
	function ajaxCheck(){
	 new Ajax.Request( 'contractNOCheck.action',
	   {
	         method:'post',
	         parameters: {contractNO: document.forms[0].elements["contractNO"].value},
	         onSuccess: function(transport){
	         var response = transport.responseText || "";
	         var value = response;
             //document.forms[0].elements["location.code"].value=value;
              if(value.trim()==""){
               document.all("ajax").style.display=""; 
               document.all("ajax").innerHTML="<font color=green>合同号可用！</font>"; 
              }else{
               document.all("ajax").style.display=""; 
               document.all("ajax").innerHTML="<font color=red>合同号已经存在，不能使用此号码！</font>"; 
              }
             
	         },
	         onFailure: function(){ alert('重发失败，请稍后再试...') }
	     });
	  }
	  
	 function ajaxEmplNameCheck(){
	 var name = escape(escape(document.forms[0].elements["emplName"].value));
	 new Ajax.Request( 'emplNameCheck.action',
	   {
	         method:'post',
	         //setRequestHeader:{"Content-Type", "text/html;charset=gbk"},  
	         parameters: {emplName: escape(document.forms[0].elements["emplName"].value)},
	         onSuccess: function(transport){
	         var response = transport.responseText || "";
	         var value = response;
             //document.forms[0].elements["location.code"].value=value;
              if(value.trim()==""){
               document.all("ajax").style.display=""; 
               document.all("ajax").innerHTML="<font color=green>学生姓名存在，可用!</font>"; 
              }else{
               document.all("ajax").style.display=""; 
               document.all("ajax").innerHTML="<font color=red>此学生姓名不存在，不可用!</font>"; 
              }
             
	         },
	         onFailure: function(){ alert('重发失败，请稍后再试...') }
	     });
	  }
	  
      function saveContract(){
      var contractNO = document.getElementById("contractNO").value;
      if(null == contractNO || contractNO == ''){
        alert('合同编号必填！');
        return false;
      }
      if(null != contractNO && contractNO.length > 16){
        alert('合同编号不能大于16位！');
        return false;
      }
      var emplName = document.getElementById("emplName").value;
      if(null == emplName || emplName == ''){
        alert('学生姓名必填！');
        return false;
      }
      var totalLessonAmount = document.getElementById("totalLessonAmount").value;
      if(null == totalLessonAmount || totalLessonAmount == ''){
        alert('有效课时数必填！');
        return false;
      }
      var amount = document.getElementById("amount").value;
      if(null == amount || amount == ''){
        alert('合同金额必填！');
        return false;
      }
      //var totalLessonAmount = document.getElementById("totalLessonAmount").value;
      //if(null == totalLessonAmount || totalLessonAmount == ''){
        //alert('有效课时数必填！');
        //return false;
      //}
    	    document.forms[0].action = "SaveContract.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
         
      function returnList(){
    	    document.forms[0].action = "ListContract.action";
			document.forms[0].target = "main";
			document.forms[0].submit();
         }
</script>