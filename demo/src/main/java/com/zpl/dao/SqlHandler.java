package com.zpl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Component;

import com.zpl.dao.callback.RowMapMetaResult;
import com.zpl.dao.callback.RowMapResult;
import com.zpl.logs.LogUtil;

/**
 * 
 * @author zhangpengliang
 *
 */
@Component("SqlHandler")
public class SqlHandler {
	@Autowired
	@Qualifier("defaultJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	/**
	 * 执行查询
	 * @param info
	 * @return
	 */
	public Map<String, Object> query(SqlInfo info){
		String sql=info.getSql();
		LogUtil.info(sql);
		List<Map<String, Object>> result=null;
		if(null==sql||sql.equals("")){
			System.out.println("SQL拼接报错。。。");
			return null;
		}
		/**
		 * jdbcTemplate.queryForMap(sql).必须能查出一条如果是多条会报错。而且map中的结果有的无法转义如VARBINARY 类型
		 * Map<String, Object> mapResult=jdbcTemplate.queryForMap(sql+" where rownum=1");
		 */
		result=jdbcTemplate.query(sql, new RowMapResult());
		if(null==result||result.isEmpty()){
			return null;
		}
		return result.get(0);
	}
	
	/**
	 * 根据条件查询指带有?的SQL语句
	 * @param info
	 * @return
	 */
	public Map<String, Object> queryByCondition(SqlInfo info){
		String sql=info.getSql();
		LogUtil.info(sql);
		if(null==sql||sql.equals("")){
			System.out.println("SQL拼接报错。。。");
			return null;
		}
		Object [] param=info.getValues().toArray();
		List<Map<String, Object>> result=jdbcTemplate.query(sql, param, new RowMapResult());
		if(null==result)
			return null;
		return result.get(0);
	}
	/**
	 * 查询获取表的元信息
	 * @param info
	 * @return
	 */
	public List<Map<String, Object>> getMetaOfTable(SqlInfo info){
		String sql=info.getSql();
		LogUtil.info(sql);
		List<Map<String, Object>> result=new ArrayList<Map<String, Object>>();
		SqlRowSet sqlRowSet=jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData sRSm=sqlRowSet.getMetaData();
		int columnSize=sRSm.getColumnCount();
		for(int i=1;i<=columnSize;i++){
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("FieldName", sRSm.getColumnName(i));
			map.put("size", sRSm.getColumnDisplaySize(i));
			map.put("type", sRSm.getColumnType(i));
			map.put("label", sRSm.getColumnLabel(i));
			map.put("precision", sRSm.getPrecision(i));
			result.add(map);
		}
		return result;
	}
	
	/**
	 * 获取到所有的查询结果
	 * @param info
	 * @return
	 */
	public List<Map<String, Object>> queryList(SqlInfo info){
		String sql=info.getSql();
		LogUtil.info(sql);
		Object [] param=info.getValues().toArray();
		List<Map<String, Object>> result=null;
		if(param.length==0){
			result=jdbcTemplate.query(sql, new RowMapResult());
		}else{
			result=jdbcTemplate.query(sql, param, new RowMapResult());
		}
		
		if(null==result)
			return null;
		return result;
	}
	/**
	 * 插入操作
	 */
	public void insert(SqlInfo info){
		info.insertSqlSpell();
		String sql=info.getSql();
		LogUtil.info(sql);
		jdbcTemplate.update(sql, info.getValues().toArray());
	}
	
	/**
	 * 更新操作
	 * @param info
	 */
	public void update(SqlInfo info){
		info.UpdateSqlSpell();
		String sql=info.getSql();
		final List<Object> v=info.getValues();
		LogUtil.info(sql);
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				for(int i=0;i<v.size();i++){
					ps.setObject(i+1, v.get(i));
				}
			}
		});
	}
	
	/**
	 * 更新操作
	 * @param info
	 */
	public void delete(SqlInfo info){
		info.deleteSqlSpell();
		String sql=info.getSql();
		final List<Object> v=info.getValues();
		LogUtil.info(sql);
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				for(int i=0;i<v.size();i++){
					ps.setObject(i+1, v.get(i));
				}
			}
		});
	}
	
	
	public void querys(){
		jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				//产生一个Connection链接
				PreparedStatement sta=con.prepareStatement("select * from sm_user where name=?");
				sta.setString(1, "admin");//下标不是从0开始是从1开始的
				return null;
			}
		}, new ResultSetExtractor<Map<String, Object>>() {

			@Override
			public Map<String, Object> extractData(ResultSet rs) throws SQLException, DataAccessException {
				return null;
			}
		});
	}
	
}
