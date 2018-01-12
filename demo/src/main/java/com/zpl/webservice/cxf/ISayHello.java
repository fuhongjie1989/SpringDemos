package com.zpl.webservice.cxf;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * webservice接口
 * @author zhangpengliang
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ISayHello {

	public String say();
	
	public void write(String a);
}
