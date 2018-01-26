<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
td{
	text-align:center;
	text-shadow: green;
	background-color: #97FFFF;
}
.rMenus {
	position: absolute;
}
.min_height {
	min-height: 100px;
}
</style>

<script type="text/javascript">
var zTree;
var setting = {
		callback:{
			onRightClick:function rightClick(event,treeId,treeNode){
				var nodes = zTree.getSelectedNodes()[0];
				if(nodes.child && nodes.child.length > 0){//有子节点
    				showRMenu(nodes.pId, event.clientX, event.clientY,'YES');
    			}else{//没有子节点
    				//alert("没有子节点");
    				showRMenu(nodes.pId, event.clientX, event.clientY,'NO');
    			}
			},
			onClick:function onclick(event,treeId,treeNode){
				var nodes=zTree.getSelectedNodes()[0];
				if(treeNode&&treeNode.type==1){
					//是库表
					console.log(treeNode.code);
					getData(treeId,treeNode);
				}
			}
		},		
		view:{
			dblClickExpand: false,//双击是否展开
			showLine: true,//是否显示线条
			showIcon: true,//是否显示图片
            selectedMulti: false,       //禁止多点选中 
            showTitle:true
		},
		
	data : {
			simpleData : {
				enable : true,
				idKey : "id", //节点数据中保存唯一标识的属性名称
				pIdKey : "pId",//节点数据中保存其父节点唯一标识的属性名称  
				rootPId : null,//用于修正根节点父节点数据，即 pIdKey 指定的属性值
			},
			key : {
				children : "child",
				name : "name",
				title : "title",
				type:"type"
			}
		}

	};


	function getData(id,treeNode){
		var jsonData = str2json("{funcID:'goQueryTreeNode.do',nodeno:'"+treeNode.code+"',InitPageType:'false'}");
		$.ajax( {
			  url: "goQueryTreeNode.do",  
	          type: "POST",  
	          data:jsonData,  
	          dataType:"json",
	          timeout: 1000,  
	          success: function (data, status) {  
	            console.log(data);  
	          },  
	          error: function (err, status) {  
	            console.log(err);  
	          }  
		}); 
	}
	function clicks(event, treeId, treeNode, clickFlag) {
		debugger;
		alert(treeId + "\\" + treeNode.name + "\\" + treeNode.children + "\\"
				+ clickFlag + "\\" + treeNode.noR);
	}
	var zNodes=${json}.data;
	
	 var rmenu=$("#rMenus");
	 function showRMenu(type, x, y,isParent) {
			$("#rMenus #rMenus ul").show();
			//alert(isParent);
			if (type==null || isParent == 'YES') {
				$("#rMenus #m_del").hide();
				$("#rMenus #m_add").show();
				$("#rMenus #m_upd").show();
				$("#rMenus #m_query").show();
			} else{
				$("#rMenus #m_del").show();
				$("#rMenus #m_add").show();
				$("#rMenus #m_upd").show();
				$("#rMenus #m_query").show();
			}
			rmenu.css({"top":y+"px", "left":x+"px", "display":"block"});
			$("html").bind("mousedown", onBodyMouseDown);
		}
	 
	function onBodyMouseDown(event) {
		if (!(event.target.id == "rMenus" || $(event.target).parents(
				"#treeDemo #rMenus").length > 0)) {
			rmenu.css({
				"display" : "none"
			});
		}
	}

	function hideRMenu() {//隐藏右边菜单
		if (rMenu)
			rMenu.css({
				"visibility" : "hidden"
			});
		$("html").unbind("mousedown", onBodyMouseDown);
	}
	$(document).ready(function() {
		debugger;
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		zTree = $.fn.zTree.getZTreeObj("treeDemo");
		debugger;
		rmenu.css("display", "none");
	});
</script>
</head>
<body>
<div class="row">
	<div class="col-lg-10">
		<div class="row">
			<div class="col-lg-1"></div>
			<div id="buttonCtrl" class="col-lg-11">
				<div class="btn-toolbar">
						<button type="button" class="btn btn-default">新增</button>
						<button type="button" class="btn btn-default" style="float: left; margin-left: 10px">修改</button>
						<button type="button" class="btn btn-default" style="float: left; margin-left: 10px">删除</button>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-1"></div>
			<div id="tree" class="col-lg-2">
					<div>
						<ul id="treeDemo" class="ztree"></ul>
						<!-- calss值必须为小写 -->
					</div>
				</div>
			<div id="console" class="col-lg-9">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<td>NO.</td>
							<td>FieldName</td>
							<td>Type</td>
							<td>size</td>
							<td>Primary Key</td>
							<td>Nullable</td>
							<td>Desc</td>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<div id="rMenus" class="rMenus">
	<ul class="list-group">
		<a id="m_add" class="list-group-item" onclick="" href="#">菜单增加</a>
		<a id="m_upd" class="list-group-item" onclick="" href="#">菜单修改</a>
		<a id="m_del" class="list-group-item" onclick="" href="#">菜单删除</a>
		<a id="m_query" class="list-group-item" onclick="" href="#">信息详情</a>
	</ul>
</div>
</body>
</html>