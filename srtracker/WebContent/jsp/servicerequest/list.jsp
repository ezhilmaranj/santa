<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="grid_16">
	<div class="box">
		<h2>
			<a id="toggle-list" href="#" class="visible">SERVICE REQUEST LIST</a>
		</h2>
		<div class="block" id="list">
			<table cellpadding="0" cellspacing="0" border="0" class="display"
				id="example">
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
						<th>REVIEW ON</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>SR-NUMBER</th>
						<th>OPENED ON</th>
						<th>COMMITED ON</th>
						<th>W-REFRENCE</th>
						<th>TYPE</th>
						<th>CATEGORY</th>
						<th>BOLT STATUS</th>
						<th>SR-STATUS</th>
						<th>REVIEW ON</th>
					</tr>
				</tfoot>
				<tbody>
					<s:iterator value="serviceRequestList" step="i">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}${i}">
							<td><a
								href='viewServiceRequestAction.action?srNumber=<s:property value="srNumber"/>'>
									<s:property value="srNumber" />
							</a></td>
							<td><s:property value="createdDate" /></td>
							<td><s:property value="commitedDate" /></td>
							<td><s:property value="wrefrenceNumber" /></td>
							<td><s:property value="requestType" /></td>
							<td><s:property value="category" /></td>
							<td><s:property value="boltStatus" /></td>
							<td><s:property value="srStatus" /></td>
							<td><s:property value="reviewDate" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

		</div>
	</div>
</div>
<div class="prefix_7 grid_2 suffix_7">
	<s:form action="exportToExcelServiceRequestAction" theme="simple">
		<s:submit value="EXPORT" />
	</s:form>
</div>
