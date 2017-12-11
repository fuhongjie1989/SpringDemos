package com.zpl.util.request;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zpl.util.string.StrUtil;
public class RequestUtil {
	private RequestUtil() {

	}
	/**
	 * 将请求参数转换成Map类型
	 * @param paramMap
	 * @return
	 */
	public static Map<String, Object> getRequestValue(Map<String, String[]> paramMap) {
		RequestUtil4Value value = new RequestUtil4Value();
		return value.converted2Map(paramMap);
	}
	/**
	 * 获取servelPath
	 * @param request
	 * @return
	 */
	public static String getServletPath(ServletRequest request) {
		String url = StrUtil.trimStr(((HttpServletRequest) request).getServletPath());
		if (url.startsWith("/")) {
			url = url.substring(1, url.length());
		}
		return url;
	}

	public static void setOrigin(ServletRequest request, ServletResponse response) {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String orgin = httpResponse.getHeader("Access-Control-Allow-Origin");
		String credentials = httpResponse.getHeader("Access-Control-Allow-Credentials");
		if (StrUtil.isNull(orgin)) {
			httpResponse.setHeader("Access-Control-Allow-Origin", ((HttpServletRequest) request).getHeader("origin"));
			//Ulog.debug("设置跨域信息[Access-Control-Allow-Origin][" + ((HttpServletRequest) request).getHeader("origin") + "]");
		}
		if (StrUtil.isNull(credentials)) {
			httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
			//Ulog.debug("设置跨域信息[Access-Control-Allow-Credentials][true]");
		}
	}
}
