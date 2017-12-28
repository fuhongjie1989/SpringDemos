<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- viewport 为视口,设置移动浏览器上的显示配置, width指定宽度，device-width指的是设备宽度,initial-scale是指初始化缩放比例,user-scalable为boolean型，是否允许用户手动缩放，maximun-scale允许用户缩放的最大比例-->
<meta name="viewport" content="width=device-width,initial-scale=1" />
<!-- renderer用于指定浏览器的内核模式 webkit使用极速内核模式,renderer是HTML渲染器 -->
<meta name="renderer" content="webkit">
<title>SpringMVC Demo</title>
<%
	String path = request.getContextPath();/* /demo */
%>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/component/bootstrap-3.3.7/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/component/menu/css/custom-menu.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/component/menu/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/component/zTree/css/zTreeStyle/zTreeStyle.css" />
<%-- 	<script type="text/javascript"
	src="<%=path%>/component/zTree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript"
	src="<%=path%>/component/zTree/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript"
	src="<%=path%>/component/zTree/js/jquery.ztree.exedit.js"></script> --%>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- container-fluid，就是表示一个容器，是一个容器布局,占比为100% 如果是container 是固定宽度 -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<!-- data-toggle 用于告诉相关js 要做什么，collapse:折叠,data-target:指示要切换到哪一个元素，值可以使一个#id或者是一个.class-->
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<div class="navbar-brand dropdown">
				<a href="#" id="menu-toggler" class="dropdown-toggle"
					data-toggle="dropdown"> demo<b class="caret"></b> <!-- caret使用插入符表示下拉功能和方向 -->
				</a>
			</div>

			<!-- ↓↓↓屏幕变小时显示↓↓↓ -->
			<div class="navbar-brand visible-xs pull-right">
				<!-- visible-*用来指定显显示的内容 与hidden-*相对应（隐藏）visible-xs：指定超小屏幕可见，其他屏幕隐藏。-sm 小屏幕显示其他屏幕隐藏 -md 中屏幕显示其他屏幕隐藏 -lg大屏幕显示其他隐藏。hidden-*正好相反 -->
				<!-- pull-right 向右浮动 pull-left 向左浮动 -->
				<li class="dropdown" style="list-style-type: none; font-size: 14px"><a
					href="#" class="dropdown-toggle" data-toggle="dropdown"
					style="color: #777"> 消息 <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#"
							onclick="createTable('查询页面', 'goQueryPage.do')">查询页面</a></li>
						<li><a href="#"
							onclick="createTable('用户管理', 'goUserMgmtQueryPage.do')">用户管理</a></li>
						<li><a href="#"
							onclick="createTable('数据模型','getDataBaseShow.do')">数据模型</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</div>
			<!-- ↑↑↑屏幕变小时显示↑↑↑ -->
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav" id="index_Tab_List">
				<li class="active"><a href="#home" data-toggle='tab'>首页</a></li>
				<!-- 这里显示添加标签 -->
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!--navbar-right 设置导航条内元素向右对齐 -->
				<li class="dropdown visible-sm visible-md visible-lg">
					<!-- visible-sm visible-md visible-lg  小屏幕 中屏幕 大屏幕都显示--> <a
					href="#" class="dropdown-toggle" data-toggle="dropdown"> 消息 <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<!-- dropdown-menu 下拉的菜单 -->
						<li><a href="#"
							onclick="createTable('查询页面', 'goQueryPage.do')">查询页面</a></li>
						<li><a href="#"
							onclick="createTable('用户管理', 'goUserMgmtQueryPage.do')">用户管理</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<!-- class=divider 是个分割线 -->
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul>
				</li>
				<li><a href="#">退出</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div id="sidebar_p"
		style="width: 500px; height: 600px; position: fixed; display: none">
		<div style="width: 43px; z-index: 9999">
			<div class="sidebar menu-min" id="sidebar">
				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>
						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->
				<ul class="nav nav-list">
					<%-- <%
						String file = application.getRealPath("/") + "/WEB-INF/jsp/zpl/";
						File file1 = new File(file);
						String[] fileNames = file1.list();
						File[] fileObjects = file1.listFiles();
						for (int i = 0; i < fileObjects.length; i++) {
							if (!fileObjects[i].isDirectory() && !"index.jsp".equals(fileNames[i])) {
					%>
					<jsp:include page="<%=fileNames[i]%>" />
					<%
						}
						}
					%> --%>

					<li><a href="#" class="dropdown-toggle"> <i
							class="fa fa-desktop">☂</i> <span class="menu-text"> 基础功能
						</span> <b class="arrow fa fa-angle-down"></b>
					</a>
						<ul class="submenu">
							<li><a href="#"
								onclick="createTable('数据模型','getDataBaseShow.do')"> <i
									class="fa-angle-double-right fa"></i> 数据模型
							</a></li>
							<li><a href="#"
								onclick="createTable('常量生成', 'goSysConst.do')"> <i
									class="fa-angle-double-right fa"></i> 常量生成
							</a></li>
							<li><a href="#"
								onclick="createTable('数据库配置', 'dataconfigQuery.do')"> <i
									class="fa-angle-double-right fa"></i> 数据库配置
							</a></li>
							<li><a href="#"
								onclick="createTable('启动设置', 'goStartSysTask.do')"> <i
									class="fa-angle-double-right fa"></i> 启动设置
							</a></li>
							<li><a href="#"
								onclick="createTable('接口测试', 'goTestPage.do')"> <i
									class="fa-angle-double-right fa"></i> 接口测试
							</a></li>
						</ul></li>


					<li><a href="#" class="dropdown-toggle"> <i
							class="fa fa-list">♐</i> <span class="menu-text"> 表格 </span> <b
							class="arrow fa fa-angle-down"></b>
					</a>
						<ul class="submenu">
							<li><a href="#"
								onclick="createTable('文件上传', 'goFileUploader.do')"> <i
									class="fa-angle-double-right fa"></i> 文件上传
							</a></li>
							<li><a href="#"
								onclick="createTable('文件上传Demo', 'goFileUploaderDemo.do')">
									<i class="fa-angle-double-right fa"></i> 其他页面调用
							</a></li>
						</ul></li>


				</ul>
				<!-- /.nav-list -->
				<div class="sidebar-collapse" id="sidebar-collapse"
					onclick="sidebar_collapsed()" style="z-index: 9999">
					<i class="fa-angle-double-right fa"
						data-icon1="fa-angle-double-left fa"
						data-icon2="fa-angle-double-right fa"></i>
				</div>
			</div>
		</div>
		<div id="sidebar_hidden"
			style="width: 500px; height: 600px; position: fixed; display: none">&nbsp</div>
		<!-- 用于指定 sidebar 的空白区域,当点击空白区域时,触发js事件关闭下拉列表-->
	</div>
	<!-- 用于显示页面内容 -->
	<div class="container-fluid">
		<div class="tab-content" id="index_Content_List">
			<div class="tab-pane active" id="home">home</div>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="<%=path%>/component/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/component/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/component/menu/js/custom-menu.js"></script>
<script type="text/javascript" src="<%=path%>/component/core/core.js"></script>
<script type="text/javascript"
	src="<%=path%>/component/jsonview/inone.js"></script>
<script type="text/javascript"
	src="<%=path%>/component/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="<%=path%>/component/zTree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript"
	src="<%=path%>/component/zTree/js/jquery.ztree.exedit.js"></script>

</html>
