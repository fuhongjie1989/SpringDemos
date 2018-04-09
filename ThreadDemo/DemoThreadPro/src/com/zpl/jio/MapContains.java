package com.zpl.jio;

import java.util.HashMap;
import java.util.Map;

public class MapContains {

	public static Map<String, Object> map=new HashMap<String,Object>();
	
	public static void put(String key,Object o){
		map.put(key, o);
	}
	
	public  static int size(){
		return map.size();
	}
	
	public static String getKey(){
		String str1="";
		for(String str:map.keySet()){
			str1=str1+str;
		}
		return str1;
	}
}
