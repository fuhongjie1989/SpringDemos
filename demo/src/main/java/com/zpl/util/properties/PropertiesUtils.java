package com.zpl.util.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**
 * 读取properties配置文件或者ini配置文件
 * @author zhangpengliang
 *
 */
public class PropertiesUtils {

	private static final Map<String, Properties> propMap = new HashMap<String, Properties>();

	
	/**
	 * 读取src目录下的配置文件
	 * 
	 * @param fileName 带后缀.properties/.ini
	 * @return
	 * @throws IOException
	 */
	public static Properties getPropertiesBySrc(String fileName) {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/" + fileName);
		Properties prop = new Properties();
		try {
			String key = fileName.substring(0, fileName.indexOf("."));
			if (propMap.get(key) == null) {
				prop.load(in);
			} else {
				prop = propMap.get(key);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
	/**
	 * 只是将配置信息加载到内容Map中
	 * @param fileName 不带后缀名.properties
	 */
	public static void loadPropFile(String fileName){

		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/" + fileName+"properties");
		Properties prop = new Properties();
		try {
			String key = fileName.substring(0, fileName.indexOf("."));
			if (propMap.get(key) == null) {
				prop.load(in);
			} else {
				prop = propMap.get(key);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	/**
	 * 只是将配置信息加载到内容Map中
	 * @param fileName 不带后缀名.ini
	 */
	public static void loadIniFile(String fileName){

		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/" + fileName+"Ini");
		Properties prop = new Properties();
		try {
			String key = fileName.substring(0, fileName.indexOf("."));
			if (propMap.get(key) == null) {
				prop.load(in);
			} else {
				prop = propMap.get(key);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public static void main(String[] args) {
		Properties p=getPropertiesBySrc("jdbc.properties");
		propMap.get("jdbc");
		System.out.println(p.get("jdbc.username"));
	}
	
	
}
