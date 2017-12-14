<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>开票管理</title>
<meta name="decorator" content="default">

<script type="text/javascript">
	$(document).ready(function(){
		
		
	});
	function page(n,s){
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active" ><a href="${ctx}/invoice/invoice/">开票列表</a></li>
		<shiro:hasPermission name="invoice:invoice:edit"><li><a href="${ctx}/invoice/invoice/form">开票记录添加</a></li></shiro:hasPermission>
	</ul>
	
	<form:form id="searchForm" modelAttribute="invoice" action="${ctx}/invoice/invoice/" method="post" class="breadcrumb form-search">
	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
	<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
	<ul class="ul-form">
		<li>
			<label>订单id:</label>
			<form:input path="orderId" htmlEscape="false" class="input-medium" />
		
		</li>
		<li>
			<label>创建日期</label>
			<input name="beginCreatedAt" type="text" readonly="readonly" class="input-medium Wdate" 
				value="<fmt:formatDate value="${invoice.beginCreatedAt}" pattern="yyyy-MM-dd HH:mm:ss" />"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"
				/>-
			<input name="endCreatedAt" type="text" readonly="readonly" class="input-medium Wdate" 
				value="<fmt:formatDate value="${invoice.endCreatedAt}" pattern="yyyy-MM-dd HH:mm:ss" />"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"
				/>
		</li>
		
		<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询" /></li>
		<li class="clearfix"></li>
	</ul>
	
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>	
				<th>开票id</th>
				<th>订单id</th>
				<th>创建时间</th>
				<shiro:hasPermission name="invoice:invoice:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="invoice">
			<tr>
				<td><a href="${ctx}/invoice/invoice/form?id=${invoice.id}">
					${invoice.id}
				</a></td>
				<td>${invoice.orderId}</td>
				<td>${invoice.createdAt}</td>
				<shiro:hasPermission name="invoice:invoice:edit">
					<td>
						<a href="${ctx}/invoice/invoice/form?id=${invoice.id}">修改</a>
					<a href="${ctx}/invoice/invoice/delete?id=${invoice.id}" onclick="return confirmx('确认要删除该开票记录吗？', this.href)">删除</a>
					
					</td>
				</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	<div class="pagination">${page}</div>
</body>
</html>