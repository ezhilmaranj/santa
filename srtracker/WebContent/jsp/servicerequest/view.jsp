<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="prefix_2 grid_12 suffix_2">

	<div class="box">
		<h2>
			<a href="#" id="toggle-login-forms">NEW SERVICE REQUEST</a>
		</h2>
		<div class="block" id="login-forms">
			<fieldset class="login">
				<div class="sixteen_column section">
					<div class="eight column">
						<div class="column_content">
							<label>SR-NUMBER: </label>
							<s:textfield name="srNumber" readonly="true" />
						</div>
					</div>
					<div class="eight column">
						<div class="column_content">
							<label>OPEN DATE </label>
							<s:textfield name="createdDate" readonly="true" />
						</div>
					</div>
				</div>

				<div class="sixteen_column section">
					<div class="eight column">
						<div class="column_content">
							<label>COMMITED DATE: </label>
							<s:textfield name="commitedDate" readonly="true" />
						</div>
					</div>
					<div class="eight column">
						<div class="column_content">
							<label>W-REFRENCE </label>
							<s:textfield name="wrefrenceNumber" readonly="true" />
						</div>
					</div>
				</div>

				<div class="sixteen_column section">
					<div class="eight column">
						<div class="column_content">
							<label>CUSTOMER NAME: </label>
							<s:textfield name="customerName" readonly="true" />
						</div>
					</div>
					<div class="eight column">
						<div class="column_content">
							<label>CATEGORY: </label>
							<s:textfield name="category" readonly="true" />
						</div>
					</div>
				</div>

				<div class="sixteen_column section">
					<div class="eight column">
						<div class="column_content">
							<label>REVIEW DATE </label>
							<s:textfield name="reviewDate" readonly="true" />
						</div>
					</div>
					<div class="eight column">
						<div class="column_content">
							<label>SR STATUS : </label>
							<s:textfield name="srStatus" readonly="true" />
						</div>
					</div>
				</div>

				<div class="sixteen_column section">
					<div class="sixteen column">
						<div class="column_content">
							<label>COMMENT </label>
							<s:textarea name="srComments" rows="10" cols="30" readonly="true" />
						</div>
					</div>
				</div>
			</fieldset>

			<fieldset>
				<div class="sixteen_column section">
					<div class="six column">
						<div class="column_content"></div>
					</div>
					<div class="four column">
						<div class="column_content">
							<a
								href="editServiceRequestAction.action?srNumber=<s:property value="srNumber"/>">Edit</a>
						</div>
					</div>
					<div class="six column">
						<div class="column_content"></div>
					</div>
				</div>
			</fieldset>
		</div>
	</div>
</div>
<div class="prefix_1 grid_14 suffix_1">
	<div class="grid_3">
		<div class="box">
			<h2>SR HISTORY</h2>
		</div>
	</div>
	<div class="grid_1">
		<div class="box">
			<h2>SR STATUS</h2>
		</div>
	</div>
	<div class="grid_5">
		<div class="box">
			<h2>OLD MESSAGE</h2>
		</div>
	</div>
	<div class="grid_5">
		<div class="box">
			<h2>NEW MESSAGE</h2>
		</div>
	</div>
</div>
<div class="prefix_1 grid_14 suffix_1">
	<s:iterator value="serviceRequest.serviceRequestLogs">
		<div class="grid_3">
			<div class="box">
				<div class="block">
					<s:property value="updatedOn" />
					:
					<s:property value="userInfo.userName" />
				</div>
			</div>
		</div>
		<div class="grid_1">
			<div class="box">
				<div class="block">
					<s:property value="srStatus" />
				</div>
			</div>
		</div>
		<div class="grid_5">
			<div class="box">
				<div class="block">
					<s:property value="oldMessage" />
				</div>
			</div>
		</div>
		<div class="grid_5">
			<div class="box">
				<div class="block">
					<s:property value="newMessage" />
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</s:iterator>
</div>


