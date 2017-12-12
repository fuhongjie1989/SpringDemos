解释说明下：
HttpMessageConverter<T>
负责将htp请求消息转换成一个<T>类型对象。或者将<T>转换成响应

1、在我实践过程中发型应用的时候报错，可能是哪里配置不到位，也是参考书籍操作的，
2、报错信息：
类：HttpMessageConverterTest.java
信息： Failed to read HTTP message: org.springframework.http.converter.HttpMessageNotReadableException: Required request body is missing