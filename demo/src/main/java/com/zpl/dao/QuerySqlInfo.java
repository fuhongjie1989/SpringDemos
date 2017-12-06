package com.zpl.dao;

import java.util.List;

public class QuerySqlInfo implements ISqlInfo {

	private String sql;

	private List<String> columsFields;

	private String tableName;


	public List<String> getColumsFields() {
		return columsFields;
	}

	public void setColumsFields(List<String> columsFields) {
		this.columsFields = columsFields;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public String getSql() {
		return this.sql;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * 根据信息拼接查询的SQL
	 */
	public void createSqlByAllInfos() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select ");
		if (null == columsFields || columsFields.size() == 0) {
			System.out.println("没有可查询的列信息...");
		}
		if (null==this.getTableName()||this.getTableName().equals("")){
			System.out.println("要查询的表名为空...");
		}
		for(int i=0;i<columsFields.size();i++){
			if(i==columsFields.size()-1){
				sb.append(" t."+columsFields.get(i)+" from "+this.getTableName()+" t");
			}else{
				sb.append(" t."+columsFields.get(i)+", ");
			}
		}
		if(!sb.toString().equals(""))
			this.setSql(sb.toString());
		System.out.println(sb.toString());
	}

}
