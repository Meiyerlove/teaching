
$(function() {
	    $("#classroomid").flexigrid({
		        url : 'ClassroomAll.action',
		        dataType : 'json',
		        colModel : [{
			            display : 'ID',
			            name : 'id',
			            width : 30,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '教室编号',
			            name : 'cid',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '校区',
			            name : 'campus',
			            width : 120,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '房间号',
			            name : 'roomid',
			            width : 50,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '类型', 
			            name : 'classroomtype',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            },{
						display : '操作',
						name : 'id',
						width : 100,
						align : 'center',
						process : function(tdDiv){
						$(tdDiv).html("<input type='button' value='修改' onclick='ClassroomUpdate(this)'/>");
						}
					}],
		        searchitems : [{
			            display : '教室编号',
			            name : 'cid',
			            isdefault : true
		            },{
			            display : '校区',
			            name : 'campus'
		            },{
			            display : '房间号',
			            name : 'roomid'
			        },{
			            display : '类型',
			            name : 'type'
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
		        width : 520,
		        height :350
	        });
    });
 function ClassroomUpdate(obj){
	 window.location='ToClassroomUpdate.action?classroomcid='+$(obj).parents('tr').children('td').eq(1).text(); 
	 
 }
 
 
 
 
 
 
 
 