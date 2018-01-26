/**
 * 用于获取当前页签的内容页《因为我们的页面可能包含多个页签》
 * @param btn
 * @returns
 */
function _namespcePage(){
	var page=$("#index_Content_List>div[class='tab-pane active']").last();
	return page;
}


/**
 * 将json字符串转换为josn对象
 * 
 * @param strJson
 *            json字符串
 * @returns json对象
 */
function str2json(strJson) {
	console.log(strJson);
	try {
		return JSON.parse(strJson);//转换成json对象
	} catch (e) {
		try {
			return (new Function("return " + strJson))();
		} catch (e) {
			try {
				var j = "(" + strJson + ")"; // 用括号将json字符串括起来
				return eval(j); // 返回json对象
			} catch (e) {
				updateTips("转换录入信息出错，请升级浏览器\n" + strJson);
			}
		}
	}
}

/**
 * 填充表格
 */
function fillTable(){
	
}



