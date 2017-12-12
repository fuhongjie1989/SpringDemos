package com.zpl.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.zpl.logs.LogUtil;
import com.zpl.msg.MsgInfo;
import com.zpl.msg.ReturnMsg;
import com.zpl.util.json.JSONUtil;
import com.zpl.util.request.RequestUtil;

/**
 * Controller基本类
 * 
 * @author zhangpengliang
 *
 */
public class BaseController {

	public static ModelAndView return2page(HttpServletResponse response,String viewName){
		ReturnMsg msg = new ReturnMsg();
		return return2page(response, msg, viewName);
	}
	
	public static ModelAndView return2page(HttpServletResponse response,ReturnMsg msg,String viewName){
		String jsonStr="";
		if(msg!=null){
			jsonStr=return2json(msg);
		}else{
			msg=new ReturnMsg();
			jsonStr=return2json(msg);
		}
		//ModelAndView(视图名，modelname,Object model)
		LogUtil.info("页面返回参数："+jsonStr);
		return new ModelAndView(viewName, "json", jsonStr);
	}
	
	/**
	 * 获取请求中的数据转成map类型
	 * @param request
	 * @return
	 */
	public Map<String,Object> getRequestMap(HttpServletRequest request){
		Map<String,String[]>params=request.getParameterMap();
		Map<String, Object> map=RequestUtil.getRequestValue(params);
		String json = JSONUtil.formatJSONObject(map);
		LogUtil.info("页面传入参数:" + json);
		return map;
	}
	/**
	 * 将返回的消息转换成json字符串
	 * @param msg
	 * @return
	 */
	public static String return2json(ReturnMsg msg){

		if (msg == null)
			msg = new ReturnMsg();
		Map<String, Object> _retMap = new HashMap<String, Object>();
		_retMap.put("data", msg.getDatalist());// 查询结果list
		if (!msg.getDatatable().isEmpty())
			_retMap.put("defmap", msg.getDatatable());// 明细页面信息map
		_retMap.putAll(initMsg(msg));// 提示信息
		String retJson = "";
		try {
			//将map转成json字符串
			retJson = JSONUtil.formatJSONObject(_retMap);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		/*Ulog.info("共查询到[" + pageCount.getAllRows() + "]条记录");
		SqlLog.info("返回参数:" + retJson);*/
		return retJson;
	
	}
	/**
	 * 初始化消息的一些标识
	 * @param returnMsg
	 * @return
	 */
	private static Map<String, Object> initMsg(ReturnMsg returnMsg) {
		Map<String, Object> _retMap = new HashMap<String, Object>();
		if (returnMsg.isSuccess()) {// 成功信息
			_retMap.put("flag", "success");
			_retMap.put("msg", initMsgArray(returnMsg.getMsgList()));
		}
		if (!returnMsg.isSuccess()) {// 失败信息
			_retMap.put("flag", "fail");
			_retMap.put("msg", initMsgArray(returnMsg.getErrorList()));
		}
		return _retMap;
	}
	
	private static List<Map<String, Object>> initMsgArray(List<MsgInfo> list) {
		List<Map<String, Object>> msgList = new ArrayList<Map<String, Object>>();
		for (MsgInfo msg : list) {
			Map<String, Object> aMsg = new HashMap<String, Object>();
			aMsg.put(msg.getCode(), msg.getInfo());
			msgList.add(aMsg);
		}
		return msgList;
	}
}
