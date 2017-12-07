package com.zpl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.zpl.dao.callback.RowMapResult;

/**
 * 
 * @author zhangpengliang
 *
 */
@Component("QuerySqlHandler")
public class QuerySqlHandler {
	@Autowired
	@Qualifier("defaultJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	/**
	 * 执行查询
	 * @param info
	 * @return
	 */
	public Map<String, Object> query(QuerySqlInfo info){
		String sql=info.getSql();
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
	public Map<String, Object> queryByCondition(QuerySqlInfo info){
		String sql=info.getSql();
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
