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
	
	private List<MsgInfo> MsgList;
	
	private List<MsgInfo> ErrorList;

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

	public List<MsgInfo> getMsgList() {
		if(MsgList==null)
			MsgList=new ArrayList<MsgInfo>();
		return MsgList;
	}

	public void setMsgList(List<MsgInfo> msgList) {
		MsgList = msgList;
	}

	public List<MsgInfo> getErrorList() {
		if(ErrorList==null)
			ErrorList=new ArrayList<MsgInfo>();
		return ErrorList;
	}

	public void setErrorList(List<MsgInfo> errorList) {
		ErrorList = errorList;
	}
	
	public void addMsg(MsgInfo msginfo){
		if(MsgList==null)
			MsgList=new ArrayList<MsgInfo>();
		MsgList.add(msginfo);
	}
	
	public void addError(MsgInfo msginfo){
		if(ErrorList==null)
			ErrorList=new ArrayList<MsgInfo>();
		ErrorList.add(msginfo);
	}
	

}
