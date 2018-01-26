<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.error {
	background: #FBE3E4;
	color: #D12F19;
	border-color: #FBC2C4;
}

.success {
	background: green;
	color: white;
	border-color: #FBC2C4;
}
</style>
</head>
<!-- 一定要添加 label 标签如果你没有为每个输入控件设置 label 标签，屏幕阅读器将无法正确识别。
对于这些内联表单，你可以通过为 label 设置 .sr-only 类将其隐藏。
还有一些辅助技术提供label标签的替代方案，比如 aria-label、aria-labelledby 或 title 属性。
如果这些都不存在，
屏幕阅读器可能会采取使用 placeholder 属性，如果存在的话，
使用占位符来替代其他的标记，但要注意，这种方法是不妥当的 -->
<body>
	<form id="form1" class="form-horizontal" style="margin-top: 12px;">
		<!-- form-horizontal 表示水平排列的表单 .form-inline 可以使内容坐对齐并表现为inline-block 级别的控件-->
		<div class="form-group">
			<div class="row">
				<label for="path" class="col-sm-2 control-label"> <span
					class="not-null">*</span>请求路径
				</label>
				<div class="col-sm-7 has-feedback">
					<input type="text" class="form-control" id="requestPath"
						name="requestPath" placeholder="请求路径">
				</div>
				<button type="button" class="btn btn-primary"
					onclick="doRequest(this)">提 交</button>
			</div>
		</div>

		<div class="form-group">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<textarea class="form-control" rows="25" id="request_json"
						name="request_json" placeholder="请求JSON"></textarea>
						<!--.form-control 类的input textarea select 元素都将设置元素宽度默认为 width:100%-->
				</div>
				<div class="col-md-4">
					<textarea class="form-control" rows="25" id="return_json"
						name="return_json" placeholder="返回JSON" readonly="readonly"></textarea>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<pre id="request_json_results" style="display: none;"></pre>
				</div>
				<div class="col-md-4">
					<pre id="return_json_results" style="display: none;"></pre>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
		<div class="form-group">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<button type="button" name="validate" id="validate"
						class="btn btn-primary" onclick="validateJson('request_json')">格式化</button>
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	function doRequest(btn) {
		var requestPath = _namespcePage().find("#requestPath").val();//获取请求路径
		 if (!validateJson('request_json')) {
			return;
		} 
		var request_json = _namespcePage().find("#request_json").val();//获取请求的值
		var jsonData = str2json(request_json);//转成json对象
		jsonData.rqstType = "AJAX";
		$.ajax({
			type : "POST",
			url : requestPath,
			data : jsonData,
			dataType : "json",
			success : function(data) {
				debugger;
				if (data.flag == "success") {// 保存成功
					_namespcePage().find("#return_json").val(JSON.stringify(data));
					 validateJson('return_json');
					return;
				}
				//alertMsg4Modal(data, _namespcePage());// 提示失效信息
				_namespcePage().find("#return_json").val(JSON.stringify(data));/* //失败信息回写 */
				 validateJson('return_json'); // 校验返回的失败信息
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				updateTips("status = " + XMLHttpRequest.status
						+ " | readyState = " + XMLHttpRequest.readyState
						+ " | textStatus = " + textStatus + " | errorThrown = "
						+ errorThrown);
				btn.disabled = false;
			}
		});
	}
</script>
</html>