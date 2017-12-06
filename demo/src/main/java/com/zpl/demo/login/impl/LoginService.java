package com.zpl.demo.login.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zpl.dao.IDao;
import com.zpl.dao.QuerySqlInfo;
import com.zpl.demo.login.ILogin;
@Service
public class LoginService implements ILogin {
	@Autowired
	@Qualifier("Sm_UserDao")
	private IDao userDao;
	@Override
	public Map<String, Object> login(String name) {
		String sql ="select t.* from sm_user t where t.name=?";
		QuerySqlInfo info=new QuerySqlInfo();
		info.setSql(sql);
		info.add(name);
		return userDao.queryByCondition(info);
	}

}
