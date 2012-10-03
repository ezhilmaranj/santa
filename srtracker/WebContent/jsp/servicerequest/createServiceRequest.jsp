<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
	$(function() {
		$("#login").validationEngine();
	});
</script>

<div class="prefix_2 grid_12 suffix_2">
	<div class="box">
		<h2>
			<a href="#" id="toggle-login-forms">NEW SERVICE REQUEST</a>
		</h2>

		<div class="block" id="login-forms">
			<s:form action="createServiceRequest" theme="simple">
				<fieldset class="login">
					<div class="sixteen_column section">
						<div class="eight column">
							<div class="column_content">
								<label>SR-NUMBER: </label>
								<s:textfield name="userName"
									cssClass="validate[required] text-input" />
							</div>
						</div>
						<div class="eight column">
							<div class="column_content">
								<label>OPEN DATE </label>
								<s:textfield name="createdOn"
									cssClass="validate[required,custom[date]] text-input" />
							</div>
						</div>
					</div>

					<div class="sixteen_column section">
						<div class="eight column">
							<div class="column_content">
								<label>COMMITED DATE: </label>
								<s:textfield name="commitedDate"
									cssClass="validate[required] text-input" />
							</div>
						</div>
						<div class="eight column">
							<div class="column_content">
								<label>W-REFRENCE </label>
								<s:textfield name="wrefrenceNumber"
									cssClass="validate[required] text-input" />
							</div>
						</div>
					</div>

					<div class="sixteen_column section">
						<div class="eight column">
							<div class="column_content">
								<label>CUSTOMER NAME: </label>
								<s:textfield name="customerName"
									cssClass="validate[required] text-input" />
							</div>
						</div>
						<div class="eight column">
							<div class="column_content">
								<label>SR-STATUS : </label>
								<s:textfield name="srStatus"
									cssClass="validate[required] text-input" />
							</div>
						</div>
					</div>

					<div class="sixteen_column section">
						<div class="eight column">
							<div class="column_content">
								<label>REVIEW DATE </label>
								<s:textfield name="reviewDate"
									cssClass="validate[required] text-input" />
							</div>
						</div>
						<div class="eight column">
							<div class="column_content">
								<label>UPDATED ON : </label>
								<s:textfield name="updatedOn"
									cssClass="validate[required] text-input" />
							</div>
						</div>
					</div>

					<div class="sixteen_column section">
						<div class="sixteen column">
							<div class="column_content">
								<label>COMMENT </label>
								<s:textarea name="reviewDate" rows="10" cols="30"
									cssClass="validate[required] text-input" />
							</div>
						</div>
					</div>
				</fieldset>
			</s:form>
		</div>
	</div>
</div>