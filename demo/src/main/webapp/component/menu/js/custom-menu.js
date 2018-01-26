function cancelActiveTab() {
	var aActLi = $("#index_Tab_List li[class='active']"); // 当前活动li标签
	var aActDiv = $("#index_Content_List div[class='tab-pane active']").first(); // 当前活动div标签
	if (aActLi[0] != undefined) // 存在活动li标签则取消
		aActLi.removeAttr("class");
	if (aActDiv[0] != undefined) // 存在活动div标签则取消只能是tab-pane
		aActDiv.attr("class", "tab-pane");
}

function createActiveTab(id, name) {
	// 判断数量，确定是否能够新加，以及新的位置，暂不实现
	// 创建新标签
	var tabList = $("#index_Tab_List");
	tabList.append("<li class='active'><a href='#"
					+ id
					+ "' data-toggle='tab'>"
					+ name
					+ "</a><div style='position:absolute;top:15.5px;right:0px;' class='pull-right'><b class='close' onclick='removeTable(\""
					+ id + "\")'>&times;</b></div></li>");
	//&times;是乘号
	var contentList = $("#index_Content_List");
	contentList.append("<div class='tab-pane active' id='" + id + "'></div>");
	loadTabContent(contentList, id);
}
/**
 * 加载链接地址
 * @param list juery对象 用于找到相应的区域并加载这里使用了load方法
 * @param id
 */
function loadTabContent(list, id) {
	list.find("div[id='" + id + "']").load(id + ".do?funcName=" + id + ".do");//这里是加载链接url
}
/**
 * 去掉当前活跃得页签,前面的页签变为活跃的
 * @param id
 */
function removeTable(id) {
	var li = $("#index_Tab_List a[href='#" + id + "']").parent();
	var div = $("#index_Content_List div[id='" + id + "']");
	if (li.attr("class") == "active") {
		li.prev().attr("class", "active");
		div.prev().attr("class", "tab-pane active");
	}
	li.remove();
	div.remove();
}

function createTable(title, url) {
	var id = url.substring(0, url.length - 3);//login.do--->id=login
	var aA = $("#index_Tab_List a[href='#" + id + "']"); // 当前要生效的a标签
	var aDiv = $("#index_Content_List div[id='" + id + "']"); // 当前要生效的DIV标签
	if (aA[0] != undefined) { // 表示已存在，则直接显示
		var parentLi = aA.parent();//找到外围的<li class=??></li>
		if (parentLi.attr("class") == "active") // 如果class属性等于active, 不变化
			return;
		cancelActiveTab();// 如果不是active,那就取消掉当前是active的对象
		parentLi.attr("class", "active"); // 将当前设置成活动标签
		if (aDiv[0] != undefined)//如果内容页签存在，那就直接让内容页签变为active
			aDiv.attr("class", "tab-pane active");
		return;
	}
	//如果要生成的标签是不存在的
	cancelActiveTab();// 先取消掉当前active的页签属性
	createActiveTab(id, title);//在创建要生成的页签
	if (!$("#sidebar").hasClass("menu-min"))
		$("#sidebar").addClass("menu-min");
	sidebar_hidden();//隐藏下拉列表
}

function sidebar_collapsed() {
	var c = $("#sidebar").hasClass("menu-min");
	var e = $("#sidebar");
	var d = $("#sidebar-collapse").find("i");
	var b = d.attr("data-icon1");
	var a = d.attr("data-icon2");
	if (!c) {
		e.attr("class", e.attr("class") + " menu-min");
		d.attr("class", a);
	} else {
		e.attr("class", e.attr("class").replace(" menu-min", ""));
		d.attr("class", b);
	}
}

function sidebar_hidden(){
	if($("#sidebar").css("display")=="none"){
		$("#sidebar").css("display","block");
		$("#sidebar_p").css("display","block");
		$("#sidebar_hidden").css("display","block");
	}else{
		$("#sidebar").css("display","none");
		$("#sidebar_p").css("display","none");
		$("#sidebar_hidden").css("display","none");
	}
}
/**
 * 页面加载的时候加载
 */
$(function (){
	$(".nav-list").on("click", function(h){
		var g = $(h.target).closest("a");
		if (!g || g.length == 0) {
			return
		}
		var c = $("#sidebar").hasClass("menu-min");
		if (!g.hasClass("dropdown-toggle")) {
			return
		}
		var f = g.next().get(0);
		if (!$(f).is(":visible")) {
			var d = $(f.parentNode).closest("ul");
			if (c && d.hasClass("nav-list")) {
				return
			}
			d.find("> .open > .submenu").each(function() {
				if (this != f && !$(this.parentNode).hasClass("active")) {
					$(this).slideUp(200).parent().removeClass("open");
				}
			});
		} else {}
		if (c && $(f.parentNode.parentNode).hasClass("nav-list")) {
			return false;
		}
		$(f).slideToggle(200).parent().toggleClass("open");
		return false;
	});
	$("#menu-toggler").on("click", function() {
		sidebar_hidden();//定位logo位置,切换显示下拉列表
	});
	$("#sidebar_hidden").on("click", function() {
		sidebar_hidden();//点击空白区域就直接关闭下拉列表
	});
});
