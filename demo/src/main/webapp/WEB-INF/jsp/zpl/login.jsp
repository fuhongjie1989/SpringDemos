<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>
<%
	String path = request.getContextPath();/* /demo */
%>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/component/starlogin/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/component/starlogin/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/component/starlogin/css/component.css" />

<!--[if IE]>
<script src="<%=path%>/component/starlogin/js/html5.js"></script>
<![endif]-->
<!-- /container -->
<script type="text/javascript"
	src="<%=path%>/component/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
<%-- var name=$("input[name='logname']").val();
console.log(name);
var pass=$("input[name='logpass']").val();
var datas={
		"name":name,
		"pass":pass
}
console.log(pass);
$.ajax(	{  url: "<%=path%>/login.do",
		  type: "POST",
		  data:datas,
		  timeout: 1000,
		  success: function (data, status) {
		    console.log(data);
		  },
		  error: function (err, status) {
		    console.log(err);
		  }
}); --%>
$(function(){
	var b;
	if(b==undefined){
		console.log("undefine");
	}else{
		console.log("dsdf");

	}
});
		function login(){
			<%-- var name=$("input[name='logname']").val();
			console.log(name);
			var pass=$("input[name='logpass']").val();
			var datas={
					"name":name,
					"pass":pass
			}
			console.log(pass);
			$.ajax(	{  url: "<%=path%>/login.do",
					  type: "POST",
					  data:datas,
					  timeout: 1000,
					  success: function (data, status) {
					    console.log(data);
					  },
					  error: function (err, status) {
					    console.log(err);
					  }
			}); --%>
		$("form[name='f']").submit();
		
		}
	</script>
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<h3>欢迎登录</h3>
					<form action="<%=path%>/login.do" name="f" method="post">
						<div class="input_outer">
							<span class="u_user"></span> <input name="logname" class="text"
								style="color: #FFFFFF !important" type="text"
								placeholder="请输入账户">
						</div>
						<div class="input_outer">
							<span class="us_uer"></span> <input name="logpass" class="text"
								style="color: #FFFFFF !important; position: absolute; z-index: 100;"
								value="" type="password" placeholder="请输入密码">
						</div>
						<div class="err" style="color: #ff0000" align="center">
							${message}
						</div>
						<div class="mb2">
							<a class="act-but submit" href="#" onclick="login()"
								style="color: #FFFFFF">登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<script src="<%=path%>/component/starlogin/js/TweenLite.min.js"></script>
<script src="<%=path%>/component/starlogin/js/EasePack.min.js"></script>
<script src="<%=path%>/component/starlogin/js/rAF.js"></script>
<script src="<%=path%>/component/starlogin/js/demo-1.js"></script>
</body>
</html>