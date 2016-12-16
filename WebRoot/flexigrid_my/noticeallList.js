
$(function() {
	if(roleid=='3' || roleid=='4'){
	    $("#noticeallid").flexigrid({
		        url :'Noticeall.action',
		        dataType : 'json',
		        colModel : [{
			            display : 'ID',
			            name : 'id',
			            width : 50,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		            }, {
	            	   display : '发送者', 
			            name : 'username',
			            width : 150,
			            sortable : true,
			            align : 'center'			            
		            },{
		            	display : '发送时间',
			            name : 'publishdate',
			            width : 150,
			            sortable : true,
			            align : 'center' 
		            }, {
	            	    display : '通知标题', 
			            name : 'title',
			            width : 150,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '通知内容',
			            name : 'content',
			            width : 300,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '通知类别',
			            name : 'noticetype',
			            width : 160,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '接受对象',
			            name : 'classname',
			            width : 160,
			            sortable : true,
			            align : 'center'
		            }],
		          buttons : [{
			            name : '教务通知',
			            bclass : 'jiaowunotice',
			            onpress : action
		            }, {
			            // 设置分割线
			            separator : true
		            }, {
			            name : '辅导员通知',
			            bclass : 'assistantnotice',
			            onpress : action
		            }, {
			            separator : true
		            }, {
			            name : '老师通知',
			            bclass : 'teachernotice',
			            onpress : action
		            }, {
			            separator : true
		            }],
		        searchitems : [{
			            display : '发送者',
			            name : 'username',
			            isdefault : true
		            },{
			            display : '发送时间',
			            name : 'publishdate',
			            isdefault : true
		            },{
			            display : '通知标题',
			            name : 'title'
		            },{
			            display : '通知内容',
			            name : 'content'
			        }],
		        sortname : "id",
		        sortorder : "desc",
		        usepager : true,
		        title : '',
		        useRp : true,
		        checkbox : true,// 是否要多选框
		        rowId : 'id',// 多选框绑定行的id
		        rp : 50,
		        showTableToggleBtn : true,
		        width : 1141,
		        height :800,
	        });

	    function action(com, grid) {
		    switch (com) {
			    case '教务通知' :
				    	 window.location.href="JiaowuSelfnotice.action";
				     break;
	            case '辅导员通知' :
	    	          window.location.href="JiaowuAssistant.action";
	            break;
	            case '老师通知' :
	    	          window.location.href="JiaowuTeacher.action";
	            break;
	          } 
		    }
		 }
	if(roleid=='5'){
	    $("#noticeallid").flexigrid({
		        url :'Noticeall.action',
		        dataType : 'json',
		        colModel : [{
			            display : 'ID',
			            name : 'id',
			            width : 50,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		            }, {
	            	   display : '发送者', 
			            name : 'username',
			            width : 150,
			            sortable : true,
			            align : 'center'			            
		            },{
		            	display : '发送时间',
			            name : 'publishdate',
			            width : 150,
			            sortable : true,
			            align : 'center' 
		            }, {
	            	    display : '通知标题', 
			            name : 'title',
			            width : 150,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '通知内容',
			            name : 'content',
			            width : 300,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '通知类别',
			            name : 'noticetype',
			            width : 160,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '接受对象',
			            name : 'classname',
			            width : 160,
			            sortable : true,
			            align : 'center'
		            }],
		          buttons : [{
			            name : '辅导员通知',
			            bclass : 'assistantnotice',
			            onpress : action2
		            }, {
			            separator : true
		            }, {
			            name : '老师通知',
			            bclass : 'teachernotice',
			            onpress : action2
		            }, {
			            separator : true
		            }],
		        searchitems : [{
			            display : '发送者',
			            name : 'username',
			            isdefault : true
		            },{
			            display : '发送时间',
			            name : 'publishdate',
			            isdefault : true
		            },{
			            display : '通知标题',
			            name : 'title'
		            },{
			            display : '通知内容',
			            name : 'content'
			        }],
		        sortname : "id",
		        sortorder : "desc",
		        usepager : true,
		        title : '',
		        useRp : true,
		        checkbox : true,// 是否要多选框
		        rowId : 'id',// 多选框绑定行的id
		        rp : 50,
		        showTableToggleBtn : true,
		        width : 1140,
		        height :800,
	        });

	    function action2(com, grid) {
		    switch (com) {
	            case '辅导员通知' :
	    	          window.location.href="JiaowuAssistant.action";
	            break;
	            case '老师通知' :
	    	          window.location.href="JiaowuTeacher.action";
	            break;
	          } 
		    }
		 }
	/*if(roleid=='5'){
		 $("#assistnoticeid").flexigrid({
		        url :'Assistantnotice.action',
		        dataType : 'json',
		        colModel : [{
			            display : 'ID',
			            name : 'id',
			            width : 50,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		            },{
	            	   display : '发送者', 
			            name : 'username',
			            width : 150,
			            sortable : true,
			            align : 'center'			            
		            },{
		            	display : '发送时间',
			            name : 'publishdate',
			            width : 150,
			            sortable : true,
			            align : 'center' 
		            }, {
	            	    display : '通知标题', 
			            name : 'title',
			            width : 150,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '通知内容',
			            name : 'content',
			            width : 300,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '通知类别',
			            name : 'noticetype',
			            width : 160,
			            sortable : true,
			            align : 'center'
		            },{
						display : '操作',
						name : 'id',
						width : 100,
						align : 'center',
						process : function(tdDiv){
						$(tdDiv).html("<input type='button' value='查看' onclick='StudentLeadershowDetail(this)'/>");
						}
					}],
		            buttons : [{
			            name : '辅导员通知',
			            bclass : 'assistantnotice',
			            onpress : action1
		            }, {
			            separator : true
		            }, {
			            name : '老师通知',
			            bclass : 'teachernotice',
			            onpress : action1
		            }, {
			            separator : true
		            }],
		        searchitems : [{
			            display : '发送者',
			            name : 'username',
			            isdefault : true
		            },{
			            display : '发送时间',
			            name : 'publishdate',
			            isdefault : true
		            },{
			            display : '通知标题',
			            name : 'title'
		            },{
			            display : '通知内容',
			            name : 'content'
			        }],
		        sortname : "id",
		        sortorder : "desc",
		        usepager : true,
		        title : '',
		        useRp : true,
		        checkbox : true,// 是否要多选框
		        rowId : 'id',// 多选框绑定行的id
		        rp : 50,
		        showTableToggleBtn : true,
		        width : 1100,
		        height :1470,
		        width : 980,
		        height :800,
	        });
		   function action1(com, grid) {
			    switch (com) {
	                 case '辅导员通知' :
	   	               window.location.href="JiaowuAssistant.action";
	              break;
	                case '老师通知' :
	   	              window.location.href="JiaowuTeacher.action";
	             break;
		          } 
			    }
			  }*/
	if(roleid=='6'){
		$("#noticeallid").flexigrid({
			url :'Assistantnotice.action?username='+username+'&roleid='+roleid,
			dataType : 'json',
			colModel : [{
				display : 'ID',
				name : 'id',
				width : 50,// 得加上 要不IE报错
				sortable : true,
				align : 'center'
			}, {
				display : '发送者', 
				name : 'username',
				width : 150,
				sortable : true,
				align : 'center'			            
			},{
				display : '发送时间',
				name : 'publishdate',
				width : 150,
				sortable : true,
				align : 'center' 
			}, {
				display : '通知标题', 
				name : 'title',
				width : 150,
				sortable : true,
				align : 'center'
			},{
				display : '通知内容',
				name : 'content',
				width : 300,
				sortable : true,
				align : 'center'
			}, {
				display : '通知类别',
				name : 'noticetype',
				width : 160,
				sortable : true,
				align : 'center'
			},{
	            display : '接受对象',
	            name : 'classname',
	            width : 160,
	            sortable : true,
	            align : 'center'
            },{
				display : '操作',
				name : 'id',
				width : 100,
				align : 'center',
				process : function(tdDiv){
				$(tdDiv).html("<input type='button' value='查看' onclick='assistantshowDetail(this)'/>");
				}
			}],
			searchitems : [{
				display : '发送者',
				name : 'username',
				isdefault : true
			},{
				display : '发送时间',
				name : 'publishdate',
				isdefault : true
			},{
				display : '通知标题',
				name : 'title'
			},{
				display : '通知内容',
				name : 'content'
			}],
			sortname : "id",
			sortorder : "desc",
			usepager : true,
			title : '',
			useRp : true,
			checkbox : true,// 是否要多选框
			rowId : 'id',// 多选框绑定行的id
			rp : 50,
			showTableToggleBtn : true,
			width : 1129,
			/*height :1470,
			width : 980,
*/	        height :800,
		});
	} 
	 if(roleid=='7'){
		$("#noticeallid").flexigrid({
			url :'Teachernotice.action?username='+username+'&roleid='+roleid,
			dataType : 'json',
			colModel : [{
				display : 'ID',
				name : 'id',
				width : 50,// 得加上 要不IE报错
				sortable : true,
				align : 'center'
			}, {
				display : '发送者', 
				name : 'username',
				width : 150,
				sortable : true,
				align : 'center'			            
			},{
				display : '发送时间',
				name : 'publishdate',
				width : 150,
				sortable : true,
				align : 'center' 
			}, {
				display : '通知标题', 
				name : 'title',
				width : 150,
				sortable : true,
				align : 'center'
			},{
				display : '通知内容',
				name : 'content',
				width : 300,
				sortable : true,
				align : 'center'
			}, {
				display : '通知类别',
				name : 'noticetype',
				width : 160,
				sortable : true,
				align : 'center'
			},{
	            display : '接受对象',
	            name : 'classname',
	            width : 160,
	            sortable : true,
	            align : 'center'
            },{
				display : '操作',
				name : 'id',
				width : 100,
				align : 'center',
				process : function(tdDiv){
				$(tdDiv).html("<input type='button' value='查看' onclick='TeachershowDetail(this)'/>");
				}
			}],
			searchitems : [{
				display : '发送者',
				name : 'username',
				isdefault : true
			},{
				display : '发送时间',
				name : 'publishdate',
				isdefault : true
			},{
				display : '通知标题',
				name : 'title'
			},{
				display : '通知内容',
				name : 'content'
			}],
			sortname : "id",
			sortorder : "desc",
			usepager : true,
			title : '',
			useRp : true,
			checkbox : true,// 是否要多选框
			rowId : 'id',// 多选框绑定行的id
			rp : 50,
			showTableToggleBtn : true,
			/*width : 1100,
	        height :1470,*/
			width : 1140,
	        height :800,
		});
	}
      
    });
function StudentLeadershowDetail(obj){
	window.location = 'JiaoWuCheckRoile.action?id='+$(obj).parents('tr').attr('id');
}
 function assistantshowDetail(obj){
	 window.location = 'JiaoWuCheckRoile.action?id='+$(obj).parents('tr').attr('id');
 }
 function TeachershowDetail(obj){
	 window.location = 'JiaoWuCheckRoile.action?id='+$(obj).parents('tr').attr('id');
 }