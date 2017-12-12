package com.zpl.util.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zpl.util.date.DateUtil;
import com.zpl.util.string.StrUtil;
/**
 * 工具类：用于处理Map<String,String[]>类型数据转换成Map<String,Object>
 * @author zhangpengliang
 *
 */
public class RequestUtil4Value {
	private Map<String, Object> allData = new HashMap<String, Object>();

	RequestUtil4Value() {

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> converted2Map(Map<String, String[]> paramMap) {
		Object map = null;
		String befKey = "";
		for (String key : paramMap.keySet()) {
			if (!key.endsWith("]")) {// 不是从Map中取出的值
				this.initValue(key, StrUtil.trimStr(paramMap.get(key)[0]), this.allData);
				continue;
			}
			if (map == null || !befKey.equals(key)) {
				befKey = key.substring(0, key.lastIndexOf("["));
				map = initMap(key);
			}
			if (key.endsWith("[]")) {// key:list<String>
				List list = ((List) map);
				String listKey = key.substring(0, key.lastIndexOf("["));
				for (String listValue : paramMap.get(key)) {
					list.add(this.initValue(listKey, listValue));
				}
				continue;
			}
			this.initValue(key.substring(key.lastIndexOf("[") + 1, key.length() - 1), StrUtil.trimStr(paramMap.get(key)[0]), (Map) map);
		}
		return this.allData;
	}

	private void initValue(String key, String value, Map<String, Object> map) {
		map.put(key, initValue(key, value));
		return;
	}

	private Object initValue(String key, String value) {
		// date结尾，转换为日期类型
		if (key.toLowerCase().endsWith("date") && !StrUtil.isNull(value) && DateUtil.isValidDate(value)) {
			return DateUtil.string2Date(value);
		}
		value = StrUtil.trimStr(value);
		if (value.startsWith("undefined"))
			return "";
		return value;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object initMap(String allKey) {
		if (allKey.endsWith("[]"))
			allKey = allKey.substring(0, allKey.length() - 2) + "[-1]";// 数组自动拼接一个，不然会少一级
		String keyArray[] = allKey.replaceAll("]", "").replace("[", "＃").split("＃");
		Object o = null;
		for (int i = 0; i < keyArray.length; i++) {
			if (i == keyArray.length - 1) {// 表示是最后一个，肯定是个map
				continue;
			}
			if (StrUtil.isNum(keyArray[i])) {// 当前节点为数字，表示当前key对应的对象为list
				int index = Integer.parseInt(keyArray[i]);
				List oList = (List) o; // 为数字，肯定为list类型，所以将o转换为list类型
				if (i + 1 < keyArray.length && StrUtil.isNum(keyArray[i + 1])) {
					// 存在下一个节点,并且下一个节点也是数值，则表示是list<list>类型，需要初始化为list而不是map
					this.initListList(oList, index);
				} else {
					this.initListMap(oList, index);
				}
				o = oList.get(index);
				continue;
			}
			// 不为数字，表示当前key对应的对象为Map
			if (o == null) // map为空，表示是本条记录的第一个
				o = this.allData.get(keyArray[i]);// 则从总集合中取
			if (o == null) {// 取完还为空，则初始化一个，并将初始化的放到总集合中，之后再对这个集合操作，总集合中的就会变化
				o = this.initNewObject(keyArray, i, this.allData);// 将总集合传入，初始化方法会负责将新初始化的放到总集合中
				continue;
			}
			// 以下为o不为空的情况
			if (o instanceof List) {// map中value类型为list类型时，会从o中取出来list类型
				// o为list，则对list进行初始化操作，避免其他地方使用时数组越界
				if (i + 2 < keyArray.length && StrUtil.isNum(keyArray[i + 2])) {
					// 存在下一个节点,并且下一个节点也是数值，则表示是list<list>类型，需要初始化为list而不是map
					this.initListList((List) o, Integer.parseInt(keyArray[i + 1]));
				} else {
					this.initListMap((List) o, Integer.parseInt(keyArray[i + 1]));
				}
				continue;
			}
			// o为map，从o中取值
			if (o instanceof Map) {
				if (((Map) o).get(keyArray[i]) != null) {
					o = ((Map) o).get(keyArray[i]);
					continue;
				}
				if (i == 0 && !StrUtil.isNum(keyArray[i + 1])) {// 当前是第0个节点，表示已经初始化过，下一个节点不是数字类型，表示就是往当前的这个map中存值，就不需要再传新值了
					continue;
				}
				// 当前非第0个节点，当前的o还是上一个节点的，所以需要重新初始化一个map
				o = this.initNewObject(keyArray, i, o);
				continue;
			}
		}
		return o;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object initNewObject(String[] keyArray, int i, Object o) {
		// 判断下一个节点是什么类型的，数值就创建List，非数值就创建Map
		if (StrUtil.isNum(keyArray[i + 1])) {
			int nextIndex = Integer.parseInt(keyArray[i + 1]);
			List list = new ArrayList();
			if (i + 2 < keyArray.length) {
				// 存在下一个节点,并且下一个节点也是数值，则表示是list<list>类型，需要初始化为list而不是map
				if (StrUtil.isNum(keyArray[i + 2])) {
					this.initListList(list, nextIndex);
					if (o instanceof Map) {
						((Map) o).put(keyArray[i], list);// 并放到总集合中
					}
					if (o instanceof List) {
						((List) o).set(nextIndex, list);// 并放到总集合中
					}
					return list;
				}
			}
			this.initListMap(list, nextIndex);
			((Map) o).put(keyArray[i], list);// 并放到总集合中
			return list;
		}
		// 非数值创建Map
		Map<String, Object> aMap = new HashMap<String, Object>();
		((Map) o).put(keyArray[i], aMap);// 并放到总集合中
		return aMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initListList(List list, int index) {
		if (index < list.size()) // index从0开始记数,size从1开始记数
			return;
		while (list.size() <= index) {
			list.add(new ArrayList());
		}
	}

	private void initListMap(List<Map<String, Object>> list, int index) {
		if (index < list.size()) // index从0开始记数,size从1开始记数
			return;
		while (list.size() <= index) {
			list.add(new HashMap<String, Object>());
		}
	}
}
