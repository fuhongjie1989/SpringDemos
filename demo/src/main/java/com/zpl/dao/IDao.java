package com.zpl.dao;

import java.util.Map;
/**
 * 
 * @author zhangpengliang
 *
 */
public interface IDao {
	/**
	 * 查询库表中的第一条数据
	 * @return
	 */
	public Map<String, Object> query();
	/**
	 * 根据条件查询
	 * @param info
	 * @return
	 */
	public Map<String, Object> queryByCondition(SqlInfo info);
	
	public void insert(SqlInfo info);
	
	/**
	 * 查询数据库表中的所有数据
	 * @return
	 */
	/*public List<Map<String, Object>> queryList();
	*//**
	 * 分页查询
	 * @param pagination
	 * @return
	 *//*
	public List<Map<String, Object>> queryList(boolean pagination);
	*//**
	 * 获取表名
	 * @return
	 */
	public String getTableName();
	/**
	 * 添加插入或修改的值
	 * @param key 列名称
	 * @param value 值
	 */
	public void add(String key,Object value);
	/**
	 * 添加等式条件
	 * @param key 列名
	 * @param value 值
	 */
	public void addEq(String key,Object value);
	/**
	 * 表更新操作
	 */
	public void update();
	/**
	 * 数据删除操作
	 */
	public void delete();
	
	
}
