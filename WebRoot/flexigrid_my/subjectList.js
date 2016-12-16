
$(function() {
	    $("#subjectid").flexigrid({
		        //url : 'TeacherAll.action',
		        url : 'SubjectAll.action',
		        dataType : 'json',
		        colModel : [{
			            display : 'ID',
			            name : 'id',
			            width : 30,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '课程名',
			            name : 'name',
			            width : 400,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '课程编号',
			            name : 'subid',
			            width : 60,
			            sortable : true,
			            align : 'center'
		            },{
						display : '操作',
						name : 'id',
						width : 100,
						align : 'center',
						process : function(tdDiv){
						$(tdDiv).html("<input type='button' value='修改' onclick='SubjectUpdate(this)'/>");
						}
					}],
		        searchitems : [{
			            display : '课程编号',
			            name : 'subid',
			            isdefault : true
		            },{
			            display : '课程名',
			            name : 'name'
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
		        width : 610,
		        height :350
	        });

    });
 function SubjectUpdate(obj){
	 window.location='DoSubjectUpdate.action?subjectid='+$(obj).parents('tr').children('td').eq(0).text(); 
	 
 }
 
 
 
 
 
 
 
 