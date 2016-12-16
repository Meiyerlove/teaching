
$(function() {
	    $("#loadingData").flexigrid({
		        url : 'FindAllAdvice.action',
		        dataType : 'json',
		        colModel : [{
			            display : 'ID',
			            name : 'id',
			            width : 120,
			            sortable : true,
			            align : 'center',
			            hide:true	
		            },{
			            display : '发送人',
			            name : 'username',
			            width : 120,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '发送日期',
			            name : 'createdate',
			            width : 200,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '内容',
			            name : 'content',
			            width : 650,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center',
		            }, {
			            display : '操作',
			            width : 100,// 得加上 要不IE报错
			            align : 'center',
			            process : function(tdDiv){
						$(tdDiv).html("<input type='button' value='查看' onclick='lookAdviceContent(this)'/>");
		            							  }
		            }],
		        searchitems : [{
			            display : '发送人',
			            name : 'username',
			            isdefault : true
		            },{
			            display : '发送日期',
			            name : 'createdate'
		            }],
		        sortname : "createdate",
		        sortorder : "desc",
		        usepager : true,
		        title : '',
		        useRp : true,
		        checkbox : false,// 是否要多选框
		        rowId : 'id',// 多选框绑定行的id
		        rp : 10,
		        showTableToggleBtn : true,
		        width : 1070,
			    height :300
	        });
	    var actions="";
	    function action(com, grid) {
		    switch (com) {			
			    case '查看&修改' :
				    selected_count = $('.trSelected', grid).length;
				    if (selected_count == 0) {
					    alert('请选择一条记录!');
					    return;
				    }
				    if (selected_count > 1) {
					    alert('抱歉只能同时修改一条记录!');
					    return;
				    }
				    data = new Array();
				    $('.trSelected td', grid).each(function(i) {
					        data[i] = $(this).children('div').text();
				        });
				    var id=data[0];
				    window.location.href="ToStudentEdit.action?studentid="+id;
					
				   //actions="modify.action";
				    break;
			    case '重置密码' :
				    selected_count = $('.trSelected', grid).length;
				    if (selected_count == 0) {
					    alert('请选择一条记录!');
					    return;
				    }
				    if (selected_count > 1) {
					    alert('抱歉只能同时修改一条记录!');
					    return;
				    }
				    data = new Array();
				    $('.trSelected td', grid).each(function(i) {
					        data[i] = $(this).children('div').text();
				        });
				    var id=data[0];
				    window.location.href="ToChangeStudentPassword.action?studentid="+id;
					
				   //actions="modify.action";
				    break;    
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