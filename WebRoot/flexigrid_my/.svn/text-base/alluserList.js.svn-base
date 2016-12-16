
$(function() {
	    $("#alluserid").flexigrid({
		        url : 'Alluser.action',
		        dataType : 'json',
		        colModel : [{
			            display : 'ID',
			            name : 'id',
			            width : 80,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		            },{
			            display : '用户名',
			            name : 'user',
			            width : 150,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '用户类型',
			            name : 'user_type',
			            width : 150,
			            sortable : true,
			            align : 'center'
		            },{
			            display : '在线状态',
			            name : 's_status',
			            width : 150,
			            sortable : true,
			            align : 'center'
		            },{
						display : '操作',
						name : 'id',
						width : 170,
						align : 'center',
						process : function(tdDiv){
						$(tdDiv).html("<input type='button' value='修改' onclick='touserEdit(this)'/>&nbsp;&nbsp;<input type='button' value='删除' onclick='deleteUser(this)'/>");
						}
					}],
		        searchitems : [{
			            display : '用户名',
			            name : 'user',
			           isdefault : true
		            },{
			            display : '用户类型',
			            name : 'user_type'
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
		        rp : 30,
		        showTableToggleBtn : true,
		        width : 780,
		        height :1020
	        });

    });
 function touserEdit(obj){
	 window.location='ToUserEdit.action?userid='+$(obj).parents('tr').children('td').eq(0).text(); 
 }
 function deleteUser(obj){
	 window.location='DeleteUser.action?userid='+$(obj).parents('tr').children('td').eq(0).text();
 }
 
 
 
 
 
 
 
 