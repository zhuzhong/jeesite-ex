<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <%@include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>开票新增</title>
<meta name="decorator" content="default">
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#inputForm").validate({
			submitHandler:function(form){
				loading('正在提交，请销等...');
				form.submit();
			},
			errorContainer:"#messageBox",
			errorPlacement:function(error,element){
				$("#messageBox").text("输入错误，请先更正.");
				if(element.is(":checkbox")||element.is(":radio")||element.parent.is(".input-append")
						
				){
					error.appendTo(element.parent().parent());
				}else{
					error.insertAfter(element);
				}
					
			}
			
		});
		
	});
	
</script>
</head>
<body>

	<ul class="nav nav-tabs">
		<li><a href="${ctx}/invoice/invoice/">开票列表</a></li>
		<li class="active">
			<a href="${ctx}/invoice/invoice/form?id=${invoice.id}">开票<shiro:hasPermission name="invoice:invoice:edit">${not empty invoice.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="invoice:invoice:edit">查看</shiro:lacksPermission></a>
		</li>
		
	</ul><br/>
	<form:form id="inputForm" modelAttribute="invoice" action="${ctx}/invoice/save" method="post" class="form-horizontal">
		<form:hidden path="id" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">订单id</label>
			<div class="controls">
				<form:input path="orderId" htmlEscape="false" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font></span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">用户id</label>
			<div class="controls">
				<form:input path="customerId" htmlEscape="false" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font></span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">开票类型</label>
			<div class="controls">
				<form:input path="invoiceType" htmlEscape="false" class="input-xlarge required" />
				<span class="help-inline"><font color="red">*</font></span>
			</div>
		</div>
		
		
		<div class="control-group">
			<label class="control-label">开票日期</label>
			<div class="controls">
				<input name="date" type="text"   readonly="readonly" class="input-medium Wdate required" maxlength="20"
				value="<fmt:formatDate value="${invoice.createdAt}" pattern="yyyy-MM-dd HH:mm:ss" />"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
				<span class="help-inline"><font color="red">*</font></span>
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="invoice:invoice:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保  存" /></shiro:hasPermission>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返   回" onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>