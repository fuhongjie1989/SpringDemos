Redis安装步骤：
		1、安装redis服务器  https://yq.aliyun.com/articles/46130
		包在：D:/redis下
		2、添加依赖
		3、配置dispatcher-servlet.xml(spring的配置文件)
		4、调试
		5、问题：使用注解无法装配实例。如：cacheManage中的Cache实例没法装配解决办法--添加set 方法并在xml里添加配置
		
		6、RedisTemplate的包引用版本问题，我用最新的，不能用会报错。 
		
		--------------------------------------------------
		需要做的
		1、安装redis服务器，windows上无法安装，寻找Linux环境并安装
		2、redis特性功能使用