<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<!-- 提示信息区  -->
	<h1>角色信息02</h1>
	<div id="roleid">${role.getRoleid()}</div>
	<div id="roldcode">${role.getRolecode()}</div>
	<div id="rolename">${role.getRolename()}</div>
	<h1>角色信息03</h1>
	<div id="roleid">${roleList.get(1).getRoleid()}</div>
	<div id="roldcode">${roleList.get(1).getRolecode()}</div>
	<div id="rolename">${roleList.get(1).getRolename()}</div>
	<div id="str">${string}</div>
</body>
</html>
