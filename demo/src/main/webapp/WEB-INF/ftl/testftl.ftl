<html>
	<body>
		<#--<h3>${roles.getRoleid()}<h3>
		<h3>${roles.getRolename()}<h3>-->
		<#-- ftl文件内容填充和jsp差不多,ftl也可以引用js文件-->
		<#list rList as r>
			<h3>${r.getRoleid()}<h3>
			<h3>${r.getRolename()}<h3>
		</#list>
	</body>
</html>