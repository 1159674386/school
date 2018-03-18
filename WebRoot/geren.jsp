<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script>
		$(function(){
			
			
			$('#dg').datagrid({ 
				pagination:true,
				rownumbers:true,
				pageNumber:1,
				pageSize:2,
				toolbar: '#tb',
				onClickCell: onClickCell,
				onEndEdit: onEndEdit,  
				method: 'post',
    			url:'userinfo_selbyid.action',    
			    columns:[[    
			    	{field:'uid',checkbox:true,width:100,align:'center'},
			        {field:'uname',title:'姓名',width:100,align:'center',editor:'textbox'},    
			        {field:'uage',title:'年龄',width:100,align:'center',editor:'textbox'},
			        {field:'usex',title:'性别',width:100,align:'center',editor:'textbox'},
			        {field:'uacc',title:'帐号',width:100,align:'center',editor:'textbox'},
			        {field:'upwd',title:'密码',width:100,align:'center',editor:'textbox'},
			        {field:'r.rname',title:'角色',width:100,align:'center',editor:'textbox'},
			        {field:'b.bname',title:'班级',width:100,align:'center',editor:'textbox'},    
			        {field:'uaddress',title:'籍贯',width:100,align:'center',editor:'textbox'}    
			    ]]    
			});  
		});
		
		
		
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#dg').datagrid('validateRow', editIndex)){
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickCell(index, field){
			if (editIndex != index){
				if (endEditing()){
					$('#dg').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					var ed = $('#dg').datagrid('getEditor', {index:index,field:field});
					if (ed){
						($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
					}
					editIndex = index;
				} else {
					setTimeout(function(){
						$('#dg').datagrid('selectRow', editIndex);
					},0);
				}
			}
		}
		function onEndEdit(index, row){
			var ed = $(this).datagrid('getEditor', {
				index: index,
				field: 'sname'
			});
			row.productname = $(ed.target).combobox('getText');
		}
		function append(){
			if (endEditing()){
				$('#dg').datagrid('appendRow',{status:'P'});
				editIndex = $('#dg').datagrid('getRows').length-1;
				$('#dg').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);
			}
			
			
			
		}
		
		var ids="";
		function removeit(){
			//if (editIndex == undefined){return}
			var objs = $('#dg').datagrid("getChecked");
			$.each(objs,function(i,n){
				ids+=n.uid+",";
				var index = $("#dg").datagrid("getRowIndex",n);
				$('#dg').datagrid('cancelEdit', index).datagrid('deleteRow', index);
			});
			alert(ids);
			
			editIndex = undefined;
		}
		function accept(){
			
			if (endEditing()){
				//$('#dg').datagrid('acceptChanges');
				var add = $('#dg').datagrid('getChanges','inserted');
				var update = $('#dg').datagrid('getChanges','updated');
				var del = $('#dg').datagrid('getChanges','deleted');
				
				if(add.length){
					var adds = JSON.stringify(add);
					$.post("userinfo_addUserinfo.action",{"adds":adds},function(data){
						$('#dg').datagrid('reload');
					},"text");
				}
				
				if(update.length){
					var update = JSON.stringify(update);
					$.post("userinfo_updateUserinfo.action",{"adds":update},function(data){
						$('#dg').datagrid('reload');
					},"text");
				}
				
				if(del.length){
					var del = JSON.stringify(del);
					$.post("userinfo_delUserinfo.action",{"ids":ids},function(data){
						$('#dg').datagrid('reload');
					},"text");
				}
				
				
			}
			
			
			
		}
		function reject(){
			$('#dg').datagrid('rejectChanges');
			editIndex = undefined;
		}
		function getChanges(){
			var rows = $('#dg').datagrid('getChanges');
			alert(rows.length+' rows are changed!');
		}

		
		
	</script>
	
  </head>
  
  <body>
    <table id="dg" width="100%"></table> 
    
    <div id="tb" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">修改</a>
	
	</div>
	

  </body>
</html>
