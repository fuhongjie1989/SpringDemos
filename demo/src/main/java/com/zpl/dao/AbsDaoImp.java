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
	@Qualifier("SqlHandler")
	private SqlHandler handler;

	private SqlInfo sqlInfo=new SqlInfo();
	
	/**
	 * 查询一条数据
	 */
	public Map<String, Object> query() {
		getQueryInfo();
		sqlInfo.createSqlByAllInfos();
		return handler.query(sqlInfo);
	}
	
	public Map<String, Object> queryByCondition(SqlInfo info){
		return handler.queryByCondition(info);
	}

	/**
	 * 插入
	 */
	public void insert(SqlInfo info){
		List<String> columsFields = new ArrayList<String>();
		if (null != this.getBaseColums()) {
			columsFields.addAll(this.getBaseColums());
		}
		if (null != this.getNewColums()) {
			columsFields.addAll(this.getNewColums());
		}
		info.setColumsFields(columsFields);
		info.setTableName(this.getTableName());
		handler.insert(info);
	}
	
	/**
	 * 删除操作
	 */
	public void delete(){
		getQueryInfo();
		handler.delete(sqlInfo);
	}
	
	
	public void update(){
		getQueryInfo();
		handler.update(sqlInfo);
	}
	
	public void addEq(String key,Object value){
		sqlInfo.addEq(key, value);
	}
	
	public void add(String key,Object value){
		sqlInfo.add(key, value);
	}
	
	/**
	 * 目前是简单的查询所有的不需要写SQL
	 * 
	 * @return
	 */
	private void getQueryInfo() {
		List<String> columsFields = new ArrayList<String>();
		if (null != this.getBaseColums()) {
			columsFields.addAll(this.getBaseColums());
		}
		if (null != this.getNewColums()) {
			columsFields.addAll(this.getNewColums());
		}
		sqlInfo.setColumsFields(columsFields);
		sqlInfo.setTableName(this.getTableName());
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
