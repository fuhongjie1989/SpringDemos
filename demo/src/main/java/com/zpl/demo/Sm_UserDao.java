package com.zpl.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.zpl.dao.AbsDaoImp;

@Repository("Sm_UserDao")
@Scope("request")
public class Sm_UserDao extends AbsDaoImp {
	private static List<String> newColums=new ArrayList<String>();
	private static List<String> baseColums=new ArrayList<String>();
	private static String tableName;
	static{
		tableName="sm_user";
		baseColums.add("recid");
		baseColums.add("creator");
		baseColums.add("createdtime");
		newColums.add("name");
		newColums.add("title");
		newColums.add("phone");
		
	}

	@Override
	public List<String> getBaseColums() {
		// TODO Auto-generated method stub
		return Sm_UserDao.baseColums;
	}

	@Override
	public List<String> getNewColums() {
		// TODO Auto-generated method stub
		return Sm_UserDao.newColums;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return Sm_UserDao.tableName;
	}


}
