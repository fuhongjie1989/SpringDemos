package com.zpl.dao.callback;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
/**
 * 行回调
 * @author zhangpengliang
 *
 */
public class RowMapResult implements RowMapper<Map<String, Object>>{

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, Object> map=new HashMap<String,Object>();
		int fields=rs.getMetaData().getColumnCount();
		for(int i=1;i<=fields;i++){
			map.put(rs.getMetaData().getColumnName(i), rs.getString(i));
		}
		return map;
	}

	public RowMapResult() {
		super();
		// TODO Auto-generated constructor stub
	}

}
