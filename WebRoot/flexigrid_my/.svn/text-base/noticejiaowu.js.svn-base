
$(function() {
	 if(roleid=='3'||roleid=='4'){
	    $("#noticejiaowuid").flexigrid({
		        url :'JiaowuNotice.action',
		        dataType : 'json',
		        colModel : [{
		        	 display : 'ID',
			            name : 'id',
			            width : 50,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		               },{
		            	display : '接受类型', 
			            name : 'type',
			            width : 150,
			            sortable : true,
			            hide: true,
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
						$(tdDiv).html("<input type='button' value='查看' onclick='jiaowushowDetail(this)'/>");
					 }
					}],
		      
		          buttons :
		        	  [{
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
		            }]
		        	   ,
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
		        width : 1242,
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
	    $("#goods").jqm({
		    // trigger : 'a.showDialog',// 触发
		    // ajax: '@href',//ajax读取方式
		    // ajaxText:'',//提示语言
		    modal : true,// 限制输入（鼠标点击，按键）的对话
		    overlay : 60 // 遮罩程度%
		      // target : t,// 提示
		      // onHide : function(h) {
		      // // // t.html('Please Wait...'); // Clear Content HTML on Hide.
		      // h.o.remove(); // remove overlay
		      // // h.w.fadeOut(888); // hide window
		      // }
	      }).jqmAddClose('.close')// 添加触发关闭的selector
	      .jqDrag('.drag');// 添加拖拽的selector
		
	    function delUser(ids) {
		    $.ajax({
			        url : 'delete.action',
			        data : {
				        ids : ids
			        },
			        type : 'POST',
			        dataType : 'json',
			        success : function() {
				        $('#flex').flexReload();//表格重载
			        }
		        });
	    }
	    $("#submit").click(function(){
	    	 $.ajax({
			        url : actions,
			        data : $("#savegoods").serialize(),
			        type : 'POST',
			        dataType : 'json',
			        success : function(data) {
				    	$("#goods").jqmHide();
				        $('#flex').flexReload();
			        }
		        });
	    })
    });
function jiaowushowDetail(obj){
	 var type=$(obj).parents('tr').children('td').eq(1).children().html();
	 if(type=='2' || type=='3'){
		 alert("此条通知学生没有权限查看!");
		 return false;
	 }
 	 window.location = 'JiaoWuCheckRoile.action?id='+$(obj).parents('tr').attr('id');
}




