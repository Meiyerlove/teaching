
$(function() {
	    $("#loadingData").flexigrid({    	
		        url : 'FindStudentInfo.action?roleid='+roleid,
		        dataType : 'json',
		        colModel : [{
		            display : 'id',
		            name : 'id',
		            sortable : true,
		            align : 'center',
		            hide:true
	            },{
		            display : '学号',
		            name : 'sid',
		            width : 120,// 得加上 要不IE报错
		            sortable : true,
		            align : 'center',
	            }, {
		            display : '姓名',
		            name : 'name',
		            width : 110,
		            sortable : true,
		            align : 'center'
	            }, {
		            display : '性别',
		            name : 'tempsex',
		            width : 100,
		            //sortable : true,
		            align : 'center'
	            }, {
		            display : '班级',
		            name : 'classname',
		            width : 160,
		            sortable : true,
		            align : 'center'
	            }, {
		            display : '专业', 
		            name : 'majorname',
		            width : 160,
		            sortable : true,
		            align : 'center'
	            }, {
		            display : '项目',
		            name : 'program',
		            width : 160,
		            sortable : true,
		            align : 'center'
	            },{
	            	display : '手机',
	            	name : 'cellphone',
	            	width : 160,
	            	sortable : true,
	            	align : 'center'
	            },{
	            	display : '辅导员',
	            	name : 'assistant',
	            	width : 160,
	            	sortable : true,
	            	align : 'center'
	            },{
	            	display : '辅导员手机',
	            	name : 'a_cellphone',
	            	width : 160,
	            	sortable : true,
	            	align : 'center'
	            },{
	            	display : '办公电话',
	            	name : 'office_phone',
	            	width : 160,
	            	sortable : true,
	            	align : 'center'
	            }, {
	            	display : '在线状态',
	            	name : 'status',
	            	width : 110,
	            	sortable : true,
	            	align : 'center'
	            }],
	            buttons : [{
		            name : '查看&修改',
		            bclass : 'edit',
		            onpress : action
	            }],
		        searchitems : [{
			            display : '学号',
			            name : 'sid',
			            isdefault : true
		            },{
			            display : '姓名',
			            name : 'name'
		            },{
			            display : '性别',
			            name : 'tempsex'
			        },{
			            display : '班级',
			            name : 'classname'
			        },{
			            display : '专业',
			            name : 'majorname'
			         },{
			            display : '项目',
			            name : 'program'
			        },{
			            display : '手机',
			            name : 'cellphone'
			        },{
			        	display : '辅导员',
			        	name : 'assistant'
			        },{
			        	display : '辅导员手机',
			        	name : 'a_cellphone'
			        },{
			        	display : '办公电话',
			        	name : 'office_phone'
			        },{
			            display : '在线状态',
			            name : 'status'
			        }],
		        sortname : "id",
		        sortorder : "asc",
		        usepager : true,
		        title : '', 
		        useRp : true,
		        checkbox : true,// 是否要多选框
		        rowId : 'id',// 多选框绑定行的id
		        rp : 10,
		        showTableToggleBtn : true,
		        width : 1100,
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