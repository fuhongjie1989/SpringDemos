package com.zpl.util.http;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.zpl.logs.LogUtil;
import com.zpl.util.string.StrUtil;

/**
 * http链接请求工具
 * @author zhangpengliang
 *
 */
public class HttpUtil {
	/**
	 * 发送post请求默认是json格式
	 * @param urlPath
	 * @param content
	 * @return
	 */
	public static String post(String urlPath,String content){
		return HttpUtil.post(urlPath, content,HttpConst.HTTP_JSON);
	}

	/**
	 * POST 发送请求
	 * @param urlPath 链接地址URL
	 * @param content 报文内容content
	 * @param contentType 设置报文内容类型 类型查看{@link HttpConst}
	 * @return
	 */
	public static String post(String urlPath, String content,String contentType){
		OutputStreamWriter  out = null;
		if(StrUtil.isNull(urlPath)){
			return null;
			//需要抛出一个错误
		}
		try {
			URL url = new URL(urlPath);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setConnectTimeout(4000);
			//下面就是添加头信息
			connection.setRequestProperty("Content-Type",contentType);
			connection.setRequestProperty("charset", "UTF-8");
			connection.connect();
			out = new OutputStreamWriter(connection.getOutputStream());
			out.write(content);
			out.flush();
			out.close();
			
		     //读取响应
			InputStream inputStream = connection.getInputStream();//真正发送请求
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(),"UTF-8");
                sb.append(lines);
            }
            LogUtil.info("获取到的请求报文信息："+sb.toString());
            reader.close();
            
            // 断开连接
            connection.disconnect();
			return sb.toString();
		}catch(MalformedURLException ee){
			System.out.println(ee);
		}catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
}
