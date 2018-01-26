package com.zpl.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zhangpengliang
 *
 */
public class SqlInfo implements ISqlInfo {

	private String sql;

	private List<String> columsFields;

	private String tableName;

	private Map<String, Object> columsMap;

	private Map<String, Object> Eq;

	/**
	 * 参数列表
	 */
	private List<Object> values;

	public void add(Object v) {
		if (null == values) {
			values = new ArrayList<Object>();
		}
		values.add(v);
	}

	public void add(String key, Object value) {
		if (null == columsMap) {
			columsMap = new HashMap<String, Object>();
		}
		columsMap.put(key, value);
	}

	public void addEq(String key, Object value) {
		if (Eq == null) {
			Eq = new HashMap<String, Object>();
		}
		Eq.put(key, value);
	}

	public List<Object> getValues() {
		if (null == values) {
			values = new ArrayList<Object>();
		}
		return values;
	}

	public void setColumsMap(Map<String, Object> columsMap) {
		this.columsMap = columsMap;
	}

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
		if (null == this.getTableName() || this.getTableName().equals("")) {
			System.out.println("要查询的表名为空...");
		}
		for (int i = 0; i < columsFields.size(); i++) {
			if (i == columsFields.size() - 1) {
				sb.append(" t." + columsFields.get(i) + " from " + this.getTableName() + " t");
			} else {
				sb.append(" t." + columsFields.get(i) + ", ");
			}
		}
		if (!sb.toString().equals(""))
			this.setSql(sb.toString());
		System.out.println(sb.toString());
	}

	public void insertSqlSpell() {
		if (values == null)
			values = new ArrayList<Object>();
		values.clear();
		StringBuffer sb = new StringBuffer();
		sb.append(" insert into " + this.getTableName());
		if (null == columsMap || columsMap.size() == 0) {
			System.out.println("没有可查询的列信息...");
		}
		if (null == this.getTableName() || this.getTableName().equals("")) {
			System.out.println("要查询的表名为空...");
		}
		StringBuffer k = new StringBuffer("(");
		StringBuffer t = new StringBuffer("(");
		for (String key : columsFields) {
			if (columsMap.get(key) == null)
				continue;
			k.append(key + ",");
			values.add(columsMap.get(key));
			t.append("?,");
		}

		sb.append(k.substring(0, k.length() - 1)).append(")values").append(t.substring(0, t.length() - 1) + ")");
		if (!sb.toString().equals(""))
			this.setSql(sb.toString());
	}

	/**
	 * 拼接修改
	 */
	public void UpdateSqlSpell() {
		if (values == null)
			values = new ArrayList<Object>();
		values.clear();
		StringBuffer sb = new StringBuffer();
		sb.append(" update " + this.getTableName() + " set ");
		if (null == columsMap || columsMap.size() == 0) {
			System.out.println("没有可查询的列信息...");
		}
		if (null == this.getTableName() || this.getTableName().equals("")) {
			System.out.println("要查询的表名为空...");
		}
		StringBuffer k = new StringBuffer();
		for (String key : columsFields) {
			if (columsMap.get(key) == null)
				continue;
			k.append(key + "=?,");
			values.add(columsMap.get(key));
		}

		sb.append(k.substring(0, k.length() - 1));
		k = null;
		StringBuffer wh = new StringBuffer(" where ");
		if (null != Eq || Eq.size() != 0) {
			int i = 1;
			for (String key : Eq.keySet()) {
				if (i != Eq.size() && i != 1) {
					wh.append(" and ");
				}
				if (columsFields.contains(key))
					if (Eq.get(key) != null) {
						values.add(Eq.get(key));
						wh.append(key + "=?");
					}
			}
		}
		sb.append(wh.toString());
		if (!sb.toString().equals(""))
			this.setSql(sb.toString());
	}
	
	/**
	 * 删除拼接
	 */
	public void deleteSqlSpell() {
		if (values == null)
			values = new ArrayList<Object>();
		values.clear();
		StringBuffer sb = new StringBuffer();
		sb.append(" delete  from " + this.getTableName()+" where ");
			int i = 1;
			for (String key : Eq.keySet()) {
				if (i != Eq.size() && i != 1) {
					sb.append(" and ");
				}
				if (columsFields.contains(key))
					if (Eq.get(key) != null) {
						values.add(Eq.get(key));
						sb.append(key + "=?");
					}
			}
		if (!sb.toString().equals(""))
			this.setSql(sb.toString());
	}
	
	//TODO 最好将where条件之后和字段信息这些提出来，作为公用的。

}
