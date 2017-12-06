package com.zpl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 用于组织SQL
 * <p>
 * 1、查询的时候用于产生一个QuerySqlInfo类,该类包含所有要查询所需要的东西
 * 
 * @author zhangpengliang
 *
 */
public abstract class AbsDaoImp implements IDao {
	@Autowired
	@Qualifier("QuerySqlHandler")
	private QuerySqlHandler handler;

	/**
	 * 查询一条数据
	 */
	public Map<String, Object> query() {
		QuerySqlInfo sqlInfo = getQueryInfo();
		return handler.query(sqlInfo);
	}

	/**
	 * 目前是简单的查询所有的不需要写SQL
	 * 
	 * @return
	 */
	private QuerySqlInfo getQueryInfo() {
		QuerySqlInfo info = new QuerySqlInfo();
		List<String> columsFields = new ArrayList<String>();
		if (null != this.getBaseColums()) {
			columsFields.addAll(this.getBaseColums());
		}
		if (null != this.getNewColums()) {
			columsFields.addAll(this.getNewColums());
		}
		info.setColumsFields(columsFields);
		info.setTableName(this.getTableName());
		info.createSqlByAllInfos();
		return info;
	}

	/**
	 * 获取该表的基本列
	 * 
	 * @return
	 */
	public abstract List<String> getBaseColums();

	/**
	 * 获取新创建的列
	 * 
	 * @return
	 */
	public abstract List<String> getNewColums();

}
