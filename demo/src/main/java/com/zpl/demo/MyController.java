package com.zpl.demo;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zpl.dao.IDao;

@Controller
public class MyController {
	private static final Logger logger=LoggerFactory.getLogger(MyController.class);
	@Autowired
	@Qualifier("Sm_UserDao")
	private IDao dao;
	/*@Autowired
	@Qualifier("defaultJdbcTemplate")
	private JdbcTemplate jdbcTemplate;*/
	
	@RequestMapping("login")
	public String sayHello(){
		dao.addEq("recid", "40DB0F880BBC65DCC0CDF987EAD43DBA");
		dao.add("name", "老子");
		dao.add("title", "开始");
		dao.update();
		return "张三ddd";
	}
	/*@RequestMapping("/fetch")
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
		
	}*/
	
	@RequestMapping("getData")
	public void getdata(){
		Map<String, Object> map=this.dao.query();
		System.out.println(map.get("RECID").toString());
		Object obj=map.get("RECID");
		if(obj instanceof String){
			System.out.println("1");
		}else if(obj instanceof Byte){
			System.out.println(2);
		}
		dao.addEq("recid",obj);
		//dao.delete();
		System.out.println(map.size());
	}
}
