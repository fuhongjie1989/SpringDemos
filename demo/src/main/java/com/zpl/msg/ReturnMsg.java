package com.zpl.msg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回的消息数据
 * 
 * @author zhangpengliang
 *
 */
public class ReturnMsg {
	/**
	 * 是否成功默认为true
	 */
	private boolean isSuccess = true;
	/**
	 * 数据列表
	 */
	private List<Map<String, Object>> Datalist;
	/**
	 * 数据Map
	 */
	private Map<String, Object> Datatable;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public List<Map<String, Object>> getDatalist() {
		if(null==Datalist)
			Datalist=new ArrayList<Map<String, Object>>();
		return Datalist;
	}

	public void setDatalist(List<Map<String, Object>> datalist) {
		Datalist = datalist;
	}

	public Map<String, Object> getDatatable() {
		if(Datatable==null)
			Datatable=new HashMap<String,Object>();
		return Datatable;
	}

	public void setDatatable(Map<String, Object> datatable) {
		Datatable = datatable;
	}

}
