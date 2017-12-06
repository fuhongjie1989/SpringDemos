package com.zpl.dao;

import java.util.Map;

public interface IDao {
	/**
	 * 查询库表中的第一条数据
	 * @return
	 */
	public Map<String, Object> query();
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
	
}
