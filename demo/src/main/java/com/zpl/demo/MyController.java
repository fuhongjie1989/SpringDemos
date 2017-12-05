package com.zpl.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@Autowired
	@Qualifier("defaultJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("login")
	public String sayHello(){
		System.out.println("12345");
		return "张三ddd";
	}
	@RequestMapping("/fetch")
	public List<String> getList(){
		List<String> list=new ArrayList<String>();
		String sql="select t.name from sm_user t";
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				while(rs.next()){
					System.out.println(rs.getString(1));
					ResultSetMetaData rsmd=rs.getMetaData();
					System.out.println(rsmd.getColumnCount());
					System.out.println(rsmd.getColumnLabel(1));
					System.out.println(rsmd.getColumnType(1));
					System.out.println(Types.VARCHAR);
					System.out.println(rsmd.getColumnName(1));
				}
			}
		});
		return list;
		
	}
}
