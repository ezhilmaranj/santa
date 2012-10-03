<%@page contentType="application/vnd.ms-excel" pageEncoding="UTF-8"%>
<%response.setHeader("Content-Disposition", "attachment;filename=OrderReport.xls"); %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" bordercolor="black">
		<thead>
			<tr>
				<th>SR-NUMBER</th>
				<th>OPENED ON</th>
				<th>COMMITED ON</th>
				<th>W-REFRENCE</th>
				<th>TYPE</th>
				<th>CATEGORY</th>
				<th>BOLT STATUS</th>
				<th>SR-STATUS</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="serviceRequestList" step="i">
				<tr class="${(i % 2) == 0 ? 'even' : 'odd'}${i}">
					<td><s:property value="srNumber" /></td>
					<td><s:property value="createdDate" /></td>
					<td><s:property value="commitedDate" /></td>
					<td><s:property value="wrefrenceNumber" /></td>
					<td><s:property value="requestType" /></td>
					<td><s:property value="category" /></td>
					<td><s:property value="boltStatus" /></td>
					<td><s:property value="srStatus" /></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>