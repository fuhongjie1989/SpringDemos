package com.zpl.dao.callback;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class RowMapMetaResult implements RowMapper<Map<String, Object>> {

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, Object> map=new HashMap<String,Object>();
		int fields=rs.getMetaData().getColumnCount();
		ResultSetMetaData metaData=rs.getMetaData();
		
		for(int i=1;i<=fields;i++){
			map.put("FieldName", metaData.getColumnName(i));
			map.put("size", metaData.getColumnDisplaySize(i));
			map.put("type", metaData.getColumnType(i));
			map.put("Catalog", metaData.getCatalogName(i));
		}
		return map;
	}

}
