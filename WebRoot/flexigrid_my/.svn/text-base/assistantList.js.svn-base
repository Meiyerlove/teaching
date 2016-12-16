
$(function() {
	    $("#assistantid").flexigrid({
		        url : 'AssistantAll.action',
		        dataType : 'json',
		        colModel : [{
			            display : 'ID',
			            name : 'id',
			            width : 30,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '工号',
			            name : 'aid',
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
			            width : 130,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '办公电话', 
			            name : 'oph',
			            width : 130,
			            sortable : true,
			            align : 'center'
		            },{
			            display : 'Email', 
			            name : 'email',
			            width : 180,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '所带班级',
			            name : 'classname',
			            width : 200,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '在线状态',
			            name : 's_status',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            },{
						display : '设置班级',
						name : 'id',
						width : 200,
						align : 'center',
						process : function(tdDiv){
						$(tdDiv).html("<input type='button' value='修改' onclick='AssistantUpdate(this)'/>&nbsp;&nbsp;<input type='button' value='班级辅导员调整' onclick='AssistantClassUpdate()'/>");
						}
					}],
		        searchitems : [{
			            display : '工号',
			            name : 'aid',
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
			            display : '办公电话',
			            name : 'oph'
			        },{
			            display : 'Email',
			            name : 'email'
			        },{
			            display : '状态',
			            name : 's_status'
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
		        width : 1130,
		        height :350
	        });

    });
 function AssistantUpdate(obj){
	 window.location='ToAssistantUpdate.action?assistantid='+$(obj).parents('tr').children('td').eq(1).text(); 
 }
 function AssistantClassUpdate(){
	 window.location='ToClassList.action';
 }
 
 
 
 
 
 
 
 