//return the times of multibox checked
function getTimes(multiBox){
  var times = 0;
  var len = document.forms[0].elements[multiBox].length;
  for(i=0;i<len;i++){
        if(document.forms[0].elements[multiBox][i].checked){
          times ++;
        }
  }
  return times;
}

function getCheckValue(multiBox){//val 1,2,3
  var len = document.forms[0].elements[multiBox].length;
  var str = "" ;
  for(i=0;i<len;i++){
        if(document.forms[0].elements[multiBox][i].checked){
          str += ","+document.forms[0].elements[multiBox][i].value;
        }
  }
  
  if(str.length>1){
    return str.substring(1);
  }
  return "";
}
function clearRadioOrCheckbox(name){
  if(document.forms[0].elements[name]==null)
    return;
  var len = document.forms[0].elements[name].length;
  for(i=0;i<len;i++){
       document.forms[0].elements[name][i].checked=false;
  }
}
function checkAll(name){
  if(document.forms[0].elements[name]==null)
    return;
  var len = document.forms[0].elements[name].length;
  for(i=0;i<len;i++){
       document.forms[0].elements[name][i].checked=true;
  }
	
}
function disableSpecialCheckbox(name,val){
  var values = val+ ",";
  var len = document.forms[0].elements[name].length;
  for(i=0;i<len;i++){
       if(values.indexOf(document.forms[0].elements[name][i].value+",")!=-1){
         document.forms[0].elements[name][i].disabled = true;
       }
  }
}

function checkValue(multiBox,val,equal){
  if(equal==""||equal==null){
    equal ="==";
  }

  if(equal=="=="){
    if(getCheckValue(multiBox)==val){
          return true;
    }
  }else if(equal=="!="){
    if(getCheckValue(multiBox)!=val){
          return true;
    }
  }

  return false;
}


function isHasChecked(name){
  var check=false;
 var allDisabled=true;
  for(i=0;i<document.forms[0].elements[name].length;i++){
    if(document.forms[0].elements[name][i].disabled==false){
       allDisabled=false;
       if( document.forms[0].elements[name][i].checked){
  	     check=true;
      	 break;
	       }
      }
  }
  if(allDisabled) return true;
  return check;
}

function getRadioValue(name){
  for(i=0;i<document.forms[0].elements[name].length;i++){
     if(document.forms[0].elements[name][i].checked){
	    return document.forms[0].elements[name][i].value;
	 }
  }
  return "";
}
function setRadioValue(name,value){
  for(i=0;i<document.forms[0].elements[name].length;i++){
     if(document.forms[0].elements[name][i].value==value){
	    document.forms[0].elements[name][i].checked=true;
	    break;
	 }
  }

}

function checkInput(obj,canEmpty,type){
   if(canEmpty&&isEmpty(obj.value)) return;
	if(!canEmpty&&isEmpty(obj.value)){
		  alert("????????.");
		  obj.focus();
	 }
	if(type=="int"){
	  if(!isInt(obj.value)){
		  alert("??????????.");
		  obj.focus();
	  }

	}

}

//????????????
function checkphone(sString)
{ 
var Letters = "1234567890-()"; 
for (i=0; i < sString.length; i++) 
  { 
   var CheckChar = sString.charAt(i); 
   if (Letters.indexOf(CheckChar) == -1) 
   { 
    return false; 
   } 
  } 
  return true;
} 

function confirmIt
(dbMsg,okURL,cancelURL,aOkMsg,aCancelMsg,okTyp,cancelTyp,okWin,cancelWin) {
		if (confirm (dbMsg)) {
			if (okTyp=="u"){
				if(okWin=="Self") location.href=okURL;
				if(okWin=="Parent") parent.location.href=okURL;
			}
			else {
				if (aOkMsg!=="") alert(aOkMsg);
			}
		}
		else {
			if (cancelTyp=="u") {
				if(cancelWin=="Self") location.href=cancelURL;
				if(cancelWin=="Parent") parent.location.href=cancelURL;
			}
			else {
				if (aCancelMsg!=="") alert(aCancelMsg);
			}
		}
}

function openWindow(url, width, height, resizable, scrollbars)
{
	var pop=null;
	pop=window.open('','','width=' + width + ',height=' + height + ',top=100,left=100,resizable=' + resizable + ',scrollbars=' + scrollbars + ',copyhistory=0',1);
    pop.document.write("<form name=temp method=post action=\"" + url+ "\"></form>");
    pop.document.write("<script>document.temp.submit();</script>");
}

function openNewWindow(url, name, width, height, resizable, scrollbars)
{
	var pop=null;
	pop=window.open(url, name, 'width=' + width + ',height=' + height + ',top=100,left=100,resizable=' + resizable + ',scrollbars=' + scrollbars + ',copyhistory=1');
	pop.opener=self;
    return pop;
}

function openWindowInCenter(url, width, height, resizable, scrollbars)
{
	var pop = window.open(url, "showsus", 'width=' + width + ',height=' + height + ',top=220,left=270,resizable=' + resizable + ',scrollbars=' + scrollbars + ',copyhistory=1');
	pop.opener=self;
    return pop;
}

function trim(sString)
{
    return sString.replace(/(^\s*)|(\s*$)/g, "");
}

function isEmpty(sString)
{  if(sString==null) return true;
	var pat_hd=/^\s*$/;
	return pat_hd.test(sString);
}

function getLength(sString)
{
	if(sString==null) return true;
	return sString.length;
}
function replace(sSource, sFind, sReplace)
{
	var pos1 = sSource.indexOf(sFind);
	while (pos1 > 0)
	{
		if ((pos1 + sFind.length) >= sSource.length)
		{
			sSource = sSource.substring(1, pos1) + sReplace;
		}
		else
		{
			sSource = sSource.substring(0, pos1) + sReplace + sSource.substring(pos1 + sFind.length, sSource.length);
		}

		pos1 = sSource.indexOf(sFind);
	}
	return sSource;
}
function isNumeric(sString)
{
	var s = trim(sString);
	if (isNaN(s) == true)
		return false;
	else
		return true;
}
function isInt(sString)
{	if(sString==null) return false;
	var s = trim(sString);
	var pat_hd=/^[0-9]+$/;
	return pat_hd.test(s);
}
function isPostcode(sString)
{
	if(sString==null) return false;
	var s = trim(sString);
	var pat_pc=/^[1-9]\d{5}(?!\d)/;
	return pat_pc.test(s);
}

function isDateTime(oDateTime)
{
    //?????????????????? ??????2000-2099??  ?????? yyyy-mm-dd[ hh:mi[:ss]]  ????????????????????????????
    //var pat_hd=/^(\d{4}-((0[1-9]{1})|(1[0-2]{1}))-((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))){1}(\s\d{2}:\d{2})(:\d{2})?$/;
    //?????????????????? ??????0000-9999??  ?????? yyyy-mm-dd[ hh:mi[:ss]]  ????????????????????????????
 var pat_hd=/^(\d{4}-((0[1-9]{1})|(1[0-2]{1}))-((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))){1}((\s\d{2}:\d{2})|(\s\d{2}:\d{2}:\d{2}))?$/;
 try{
   if(!pat_hd.test(oDateTime)) throw "invalid";
   var arr_dt=oDateTime.split(" ");
   if(arr_dt[0]=='') throw "invalid";
   var oDate=arr_dt[0];
   var arr_hd=oDate.split("-");
   var dateTmp;
   dateTmp= new Date(arr_hd[0],parseFloat(arr_hd[1])-1,parseFloat(arr_hd[2]));
   if(dateTmp.getFullYear()!=parseFloat(arr_hd[0]) || dateTmp.getMonth()!=parseFloat(arr_hd[1]) -1 || dateTmp.getDate()!=parseFloat(arr_hd[2]))  throw "invalid";
            if(arr_dt[1] && arr_dt[1]!='')
            {
               var oTime=arr_dt[1];
               var arr_ht=oTime.split(":");
			   if(arr_ht.length==2){
					arr_ht[2]="00";
			   }
               dateTmp.setHours(arr_ht[0],arr_ht[1],arr_ht[2]);
      if(dateTmp.getHours()!=parseFloat(arr_ht[0]) || dateTmp.getMinutes()!=parseFloat(arr_ht[1]) || dateTmp.getSeconds()!=parseFloat(arr_ht[2]))  throw "invalid";
            }
  }
 catch(ex)
  {
   if(ex.description)
   {return false;}
   else
    {return false;}
  }
 return true;
}
function isTime(oTime)
{
    // valid time hh:mi[:ss]]  
	if(oTime==null) return false;
	var s = trim(oTime);
    var pat_hd=/^([0-2]{1}[0-3]{1}){1}(:([0-5]{1}[0-9]{1}))(:([0-5]{1}[0-9]{1}))?$/;
	return pat_hd.test(s);

}
function isEmail(address)
{
	if(address==null) return false;
	var s = trim(address);
	var pat_hd=/^[a-zA-Z0-9]+([\._-][\w_-]+)*@[\w_-]+(\.[\w_-]+)*$/;
	return pat_hd.test(s);
}
function isMutiEmail(address)
{
	if(address==null) return false;
	var s = trim(address);
	var pat_hd=/^([a-zA-Z0-9]+(\.[\w_-]+)*@[\w_-]+(\.[\w_-]+)*[,;] ?)*([a-zA-Z0-9]+(\.[\w_-]+)*@[\w_-]+(\.[\w_-]+)*){1}$/;
	return pat_hd.test(s);
}

function ValidIP(ip) {
	if(ip==null) return false;
	var s = trim(ip);
	var pat_hd=/^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)$/;
	return pat_hd.test(s);
}
function ValidMutiIP(ip) {//(ip[,])*(ip)  0.0.255.0,65.56.88.99  or 0.0.255.0, 65.56.88.99
	if(ip==null) return false;
	var s = trim(ip);
	var pat_hd=/^((((\d{1,2})|(1\d{2})|(2[0-5]{2}))\.){3}((\d{1,2})|(1\d{2})|(2[0-5]{2})){1}[,]{1} ?)*((((\d{1,2})|(1\d{2})|(2[0-5]{2}))\.){3}((\d{1,2})|(1\d{2})|(2[0-5]{2})){1}){1}$/;
	return pat_hd.test(s);
}

function haveGB(str) {
//alert(str);
	var edstr = "`1234567890-=\qwertyuiop[]asdfghjkl;'zxcvbnm,./~!@#$%^&*()_+|}{POIUYTREWQASDFGHJKL:\"?><MNBVCXZ ";
	for (var iii=0;iii<str.length;iii++) {
		if (edstr.indexOf(str.charAt(iii))<0) {
			return true;
		}
	}
	return false;
}
//days diff from two date
function dateDiff(fDate,lDate){
	var lDate1 = Date.parse(lDate);
	var fDate1 = Date.parse(fDate);
	var diff= (lDate1-fDate1)/1000/60/60/24;
	return diff;
}
function inDateRange(fDate,lDate,range){
	var r = parseInt(range);
	var lDate1 = Date.parse(lDate);
	var fDate1 = Date.parse(fDate);
	var r1 = (lDate1-fDate1)/1000/60/60/24;
	if(r1>r) return false;
     return true;
}

function transListToStringS(lobj){
	var listvalue = "";
	var size = lobj.length;
	for(var i = 0; i<size; i++){
		if (lobj.options[i].value !="") {
			if (listvalue=="")
				listvalue = lobj.options[i].value
			else
				listvalue = listvalue + "," + lobj.options[i].value
		}
	}
	return listvalue;
}

function transListToStringM(lobj){
	var listvalue = "";
	var size = lobj.length;
	for (var i = 0; i<size; i++) {
		if (lobj.options[i].selected) {
			if (lobj.options[i].value !="") {
				if (listvalue=="")
	    			listvalue = lobj.options[i].value
		    	else
			    	listvalue = listvalue + "," + lobj.options[i].value
			}
		}
	}
	return listvalue;
}

//disable all button on page
function disableAllButton(){
//alert(document.all.length);
    var e=document.all.length;
	for(i=0;i<e;i++){
	if(document.all(i).type!=null&&(document.all(i).type=='button'||document.all(i).type=='submit')){
	document.all(i).disabled=true;
	}
	}
	
}
function disableAllInDiv(id){//disable all elements in div
  var childrens=document.all(id).all;
  var e=childrens.length;
	for(i=0;i<e;i++){
    //alert(childrens[i].tagName);
    if(childrens[i].tagName!=null&&(childrens[i].tagName=="INPUT" ||childrens[i].tagName=="SELECT"||childrens[i].tagName=="TEXTAREA" )){
	     childrens(i).disabled=true;
	   }
	}
}
function enableAllInDiv(id){//enable all elements in div
  var childrens=document.all(id).all;
  var e=childrens.length;
	for(i=0;i<e;i++){
	  if(childrens[i].tagName!=null&&(childrens[i].tagName=="INPUT" ||childrens[i].tagName=="SELECT"||childrens[i].tagName=="TEXTAREA" )){
	   childrens(i).disabled=false;
	 }
	}
}

//
function disableIEShortcut(){//disable arrow key to back or forward
if ((window.event.altKey)&& 
((window.event.keyCode==37)|| //disable Alt+ <-- 
(window.event.keyCode==39))){ //disable Alt+ -->  
//alert("?????ALT+???????????"); 
event.returnValue=false; 
} 
////disable Alt+F4 and CTRL+W to prevent closeing IE

if (((window.event.altKey)&&(window.event.keyCode==115))) 
{ 
window.showModelessDialog("about:blank","","dialogWidth:0px;dialogheight:0px"); 
return false; 
} 
//disable CTRL+W to close IE 
if ((window.event.ctrlKey)&&(window.event.keyCode==87)){ 
event.returnValue=false; 
} 

//if ((event.keyCode==8)|| //??????? 
//(event.keyCode==116)){ //disable F5 to refresh page 
//event.keyCode=0; 
//event.returnValue=false; 
//} 
if ((event.ctrlKey)&&(event.keyCode==78)){ //disable Ctrl+n 
event.returnValue=false; 
} 
if ((event.shiftKey)&&(event.keyCode==121)){ //disable shift+F10 
event.returnValue=false; 
} 
if (event.keyCode==122){ //disable F11 
event.returnValue=false; 
} 

} 

window.history.forward(1); 
document.onkeydown=disableIEShortcut;