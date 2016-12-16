
$(function() {
	    $("#teacherid").flexigrid({
		        url : 'TeacherAll.action',
		        dataType : 'json',
		        colModel : [{
			            display : 'ID',
			            name : 'id',
			            width : 30,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '工号',
			            name : 'tid',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '名称',
			            name : 'name',
			            width : 120,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '性别',
			            name : 'tempsex',
			            width : 50,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '手机', 
			            name : 'cellphone',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : 'Email',
			            name : 'email',
			            width : 200,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '所教课程',
			            name : 'subjectname',
			            width : 400,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '在线状态',
			            name : 's_status',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            },{
						display : '操作',
						name : 'id',
						width : 100,
						align : 'center',
						process : function(tdDiv){
						$(tdDiv).html("<input type='button' value='修改' onclick='TeacherUpdate(this)'/>");
						}
					}],
		        searchitems : [{
			            display : '工号',
			            name : 'tid',
			            isdefault : true
		            },{
			            display : '名称',
			            name : 'name'
		            },{
			            display : '性别',
			            name : 'sex'
			        },{
			            display : '手机',
			            name : 'cellphone'
			        },{
			            display : '状态',
			            name : 's_status'
			        },{
			            display : 'Email',
			            name : 'email'
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
		        width : 1220,
		        height :350
	        });

    });
 function TeacherUpdate(obj){
	 window.location='ToTeacherUpdate.action?teachertid='+$(obj).parents('tr').children('td').eq(1).text(); 
	 
 }
 
 
 
 
 
 
 
 