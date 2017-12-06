package com.zpl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.zpl.dao.callback.RowMapResult;
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
		result=jdbcTemplate.query(sql, new RowMapResult());
		if(null==result||result.isEmpty()){
			return null;
		}
		return result.get(0);
	}
	
}
