package com.zpl.freemarker;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
/**
 * 代码实现FreeMarker配置信息
 * @author zhangpengliang
 *
 */
/*@Component*/
public class FreeMarkerConfiger extends FreeMarkerConfigurer{
	
	
	/*public FreeMarkerConfiger(Map<String, TemplateModel> _variables) {
		super.setTemplateLoaderPath("/WEB-INF/ftl/");
		Map<String, Object> variables = new HashMap<String, Object>();
		for (String key : _variables.keySet()) {
			variables.put(key, _variables.get(key));
		}
		super.setFreemarkerVariables(variables);
		super.setDefaultEncoding("UTF-8");
	}

	@Override
	public void afterPropertiesSet() throws IOException, TemplateException {
		// TODO Auto-generated method stub
		super.afterPropertiesSet();
	}*/

}
