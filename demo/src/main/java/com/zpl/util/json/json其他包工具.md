目前的json工具类里我们引用的是com.fasterxml.jackson这个包。

还有其他的包：org.json包。
使用JsonObject 和JsonArray来实现json的工具类实现。

实现类如下：
public class JsonUtil {
	

	
	public static Map<String, Object> decodeObjectMap(JSONObject objData) {

		Map<String, Object> result = new HashMap<String, Object>();
		Iterator<?> ik = objData.keys();
		while(ik.hasNext()) {
			String key = (String) ik.next();
			Object value = objData.opt(key);
			if(value instanceof JSONObject) {
				value = decodeObjectMap((JSONObject)value);
			} else if(value instanceof JSONArray) {
				value = decodeObjectArray((JSONArray)value);
			}
			result.put(key, value);
		}
		return result;
	}
	
	public static Object[] decodeObjectArray(JSONArray arrayData) {
		if(arrayData==null) return null;
		Object[] objs = new Object[arrayData.length()];
		for(int i = arrayData.length() - 1; i>=0; i--) {
			objs[i] = arrayData.opt(i);
		}
		return objs;
	}
	
	public static String[] decodeStringArray(JSONArray arrayData) {
		if(arrayData==null) return null;
		String[] objs = new String[arrayData.length()];
		for(int i = arrayData.length() - 1; i>=0; i--) {
			objs[i] = arrayData.optString(i);
		}
		return objs;
	}
}