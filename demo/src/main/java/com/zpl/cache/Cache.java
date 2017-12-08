package com.zpl.cache;

import java.util.Map;
import java.util.Set;

/**
 * 缓存接口
 * @author zhangpengliang
 * 主要是用于提供哪些缓存方法的
 */
public interface Cache {

	/**
	 * 按键值的方式存储
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	void put(String key, Object value);

	/**
	 * 按键值方式存储，可以设置超时
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @param timeout
	 *            超时时间
	 */
	void put(String key, Object value, int timeout);

	/**
	 * 获取key对应的值
	 * 
	 * @param key
	 *            键
	 * @return
	 */
	Object get(String key);

	/**
	 * 获取key对应的值，并转换为指定类型
	 * 
	 * @param key
	 *            键
	 * @param requiredType
	 *            类型
	 * @return
	 */
	<T> T get(String key, Class<T> requiredType);

	/**
	 * 移除对应值
	 * 
	 * @param key
	 *            键
	 */
	void remove(String key);

	/**
	 * 获取所有key
	 * 
	 * @param pattern
	 * @return
	 */
	Set<String> keys(String pattern);

	/**
	 * 以Hash的方式将map存入缓存中
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	void putHash(String key, Map<?, ?> value);

	/**
	 * 以Hash的方式将对象存入缓存中
	 * 
	 * @param key
	 *            缓存中的key
	 * @param hashKey
	 *            hash中的key
	 * @param value
	 *            hash中的value
	 */
	void putHash(String key, String hashKey, Object value);

	/**
	 * 获取Hash对象
	 * 
	 * @param key
	 *            hash对象的key
	 * @return
	 */
	Map<?, Object> getHash(String key);

	/**
	 * 获取hahh对象中的某个key对应的值
	 * 
	 * @param key
	 *            hash对象的key
	 * @param hashKey
	 *            hash中的key
	 * @return
	 */
	Object getHash(String key, String hashKey);

	/**
	 * 获取hash对象中的某个key对应的值，并进行类型转换
	 * 
	 * @param key
	 *            hash对象的key
	 * @param hashKey
	 *            hash中的key
	 * @param requiredType
	 *            类型
	 * @return
	 */
	<T> T getHash(String key, String hashKey, Class<T> requiredType);

	/**
	 * 移除Hash
	 * 
	 * @param key
	 *            hash对象的key
	 */
	void removeHash(String key);

	/**
	 * 移除Hash中多个key
	 * 
	 * @param key
	 *            hash对象的key
	 * @param hashKeys
	 *            hash中的key
	 */
	void removeHash(String key, Object... hashKeys);

	/**
	 * 使用pipLine进行指数据导入
	 * 
	 * @param data
	 */
	void put(Map<String, ?> data);

	/**
	 * 向有序集(Sorted set)中添加值 <br>
	 * 默认按照时间顺序排序
	 * 
	 * @param key
	 *            有序集合的key
	 * @param value
	 *            值
	 * @return
	 */
	boolean zAdd(String key, Object value);

	/**
	 * 向有序集(Sorted set)中添加值 <br>
	 * 按照score排序
	 * 
	 * @param key
	 *            有序集合的key
	 * @param value
	 *            值
	 * @param score
	 *            排序值
	 * @return
	 */
	boolean zAdd(String key, Object value, double score);

	/**
	 * 根据排序区间获取有序集(Sorted set)中的值
	 * 
	 * @param key
	 *            有序集合的key
	 * @param start
	 *            开始区间
	 * @param end
	 *            结束区间
	 * @return
	 */
	Set<Object> zGetByRank(String key, long start, long end);

	/**
	 * 根据排序值获取有序集(Sorted set)中的值
	 * 
	 * @param key
	 *            有序集合的key
	 * @param min
	 *            排序值开始区间
	 * @param max
	 *            排序值结束区间
	 * @return
	 */
	Set<Object> zGetByScore(String key, double min, double max);

	/**
	 * 根据值移动对应的值
	 * 
	 * @param key
	 *            有序集合的key
	 * @param values
	 *            值
	 * @return
	 */
	Long zRemove(String key, Object... values);

	/**
	 * 根据排序区间移除有序集(Sorted set)中的值
	 * 
	 * @param key
	 *            有序集合的key
	 * @param start
	 *            开始区间
	 * @param end
	 *            结束区间
	 * @return
	 */
	Long zRemoveByRank(String key, long start, long end);

	/**
	 * 根据排序值移除有序集(Sorted set)中的值
	 * 
	 * @param key
	 * @param min
	 * @param max
	 * @return
	 */
	Long zRemoveByScore(String key, double min, double max);

	
	
}
