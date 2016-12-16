
$(function() {
	    $("#loadingData").flexigrid({    	
		        url : 'FindExamInfo.action',
		        dataType : 'json',
		        colModel : [{
		            display : 'id',
		            name : 'id',
		            sortable : true,
		            align : 'center',
		            hide:true
	            },{
		            display : '考试名称',
		            name : 'title',
		            width : 100,// 得加上 要不IE报错
		            //sortable : true,
		            align : 'center',
	            }, {
		            display : '考试科目',
		            name : 'subjectname',
		            width : 150,
		            sortable : true,
		            align : 'center'
	            }, {
		            display : '考试阶段',
		            name : 'phasename',
		            width : 100,
		            sortable : true,
		            align : 'center'
	            }, {
	            	display : '分数类型', 
	            	name : 'scoreTypeName',
	            	width : 100,
//	            	sortable : true,
	            	align : 'center'
	            }, {
		            display : '考试类型',
		            name : 'examTypeName',
		            width : 150,
//		            sortable : true,
		            align : 'center'
	            }, {
		            display : '考试班级',
		            name : 'classname',
		            width : 150,
		            sortable : true,
		            align : 'center'
	            },{
	            	display : '考试日期',
	            	name : 'time',
	            	width : 100,
//	            	sortable : true,
	            	align : 'center'
	            }, {
	            	display : '考试时间',
	            	name : 'fromtime',
	            	width : 100,
	            	sortable : true,
	            	align : 'center'
	            },{
	            	display : '考试地点',
	            	name : 'classroom',
	            	width : 150,
	            	sortable : true,
	            	align : 'center'
	            }],
		        sortname : "edate",
		        sortorder : "desc",
		        usepager : true,
		        title : '',
		        useRp : true,
		        checkbox : true,// 是否要多选框
		        rowId : 'id',// 多选框绑定行的id
		        rp : 10,
		        showTableToggleBtn : true,
		        width : 1100,
			    height :320
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
				    if(roleid=='3'){
				    	 window.location.href="ToStudentEdit.action?studentid="+id;
				    }
				    if(roleid=='5'){
				    	 window.location.href="ToStudentEdit.action?studentid="+id;
				    }
					
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