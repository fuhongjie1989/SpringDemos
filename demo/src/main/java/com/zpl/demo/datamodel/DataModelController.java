package com.zpl.demo.datamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zpl.dao.SqlHandler;
import com.zpl.dao.SqlInfo;
import com.zpl.msg.ReturnMsg;
import com.zpl.web.BaseController;
@Controller
public class DataModelController extends BaseController {

	@Autowired
	@Qualifier("SqlHandler")
	private SqlHandler handler;
	
	@RequestMapping("getDataBaseShow.do")
	public ModelAndView getDataBaseView(HttpServletRequest request, HttpServletResponse response){
		SqlInfo info=new SqlInfo();
		String sql="select * from zpl_datamodel";
		info.setSql(sql);
		List<Map<String, Object>>result=handler.queryList(info);
		List<Map<String, Object>> r=new ArrayList<Map<String,Object>>();
		for(Map<String, Object> map:result){
			Map<String, Object> m=new HashMap<String,Object>();
			m.put("id", map.get("recid".toUpperCase()));
			m.put("pId", map.get("parent".toUpperCase()));
			m.put("name", map.get("name".toUpperCase()));
			m.put("code", map.get("code".toUpperCase()));
			m.put("type", map.get("type".toUpperCase()));
			r.add(m);
		}
		ReturnMsg msg=new ReturnMsg();
		msg.setSuccess(true);
		msg.setDatalist(r);
		//return new ModelAndView("/zpl/database/DataModelShow");
		return return2page(response, msg, "/zpl/database/DataModelShow");
	}
	@RequestMapping("goQueryTreeNode.do")
	public ModelAndView getDetailTableInfo(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> params=getRequestMap(request);
		System.out.println(params.size());
		String tableName=(String)params.get("nodeno");
		if(tableName.equals("")||null==tableName){
			return return2page(response, "/zpl/database/DataModelShow");
		}
		SqlInfo info=new SqlInfo();
		String sql="select * from "+tableName+" where rownum=0";//mysql 可以使用select * from table limit 0
		info.setSql(sql);
		List<Map<String, Object>> result=handler.getMetaOfTable(info);
		return null;
	}
	
	
	
	
	
	
}
