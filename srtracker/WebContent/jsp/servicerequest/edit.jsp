<%@ taglib uri="/struts-tags" prefix="s"%>

<script>
	$(function() {
		$("#datepicker").datepicker();
		$("#login").validationEngine();
		$("input:submit, a, button", ".button").button();
	});
</script>

<div class="prefix_2 grid_12 suffix_2">
	<div class="box">
		<h2>
			<a href="#" id="toggle-login-forms">NEW SERVICE REQUEST</a>
		</h2>

		<div class="block" id="login-forms">
			<s:form action="updateServiceRequestAction" theme="simple" id="login">
				<fieldset class="login">
					<div class="sixteen_column section">
						<div class="eight column">
							<div class="column_content">
								<label>SR-NUMBER: </label>
								<s:textfield name="srNumber"
									cssClass="validate[required,minSize[12],maxSize[12]] text-input" />
							</div>
						</div>
						<div class="eight column">
							<div class="column_content">
								<label>OPEN DATE </label>
								<s:textfield name="createdDate"
									cssClass="datepicker validate[required,custom[date]] text-input" />
							</div>
						</div>
					</div>

					<div class="sixteen_column section">
						<div class="eight column">
							<div class="column_content">
								<label>COMMITED DATE: </label>
								<s:textfield name="commitedDate"
									cssClass="datepicker validate[required,custom[date]] text-input" />
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
								<s:select name="srStatus" list="{'OPEN','CLOSE'}" emptyOption=""
									cssClass="validate[required] text-input" />
							</div>
						</div>
					</div>

					<div class="sixteen_column section">
						<div class="eight column">
							<div class="column_content">
								<label>REVIEW DATE </label>
								<s:textfield name="reviewDate"
									cssClass="datepicker validate[required,custom[date]] text-input" />
							</div>
						</div>
						<div class="eight column">
							<div class="column_content">
								<label>CATEGORY: </label>
								<s:select name="category"
									list="{'PROCESS ERROR','OPENREACH DEALY','IN PROGRESS',
								'BAU EXCLUDES','ECOBB PENDING','HAVE TO UPDATE'}"  emptyOption="" />
							</div>
						</div>
					</div>
					<div class="sixteen_column section">
						<div class="eight column">
							<div class="column_content">
								<label>BOLT SATUS </label>
								<s:select name="boltStatus"
									list="{'BOLT ERROR','BOLT TERIMINATED','ECOBB PENDING','SINGULARITY PENDING',
									'FUTURE CAD DATE','NO PENDING ORDER','SINGULARITY CANCELLED','COMPLETED','HAVE TO UPDATE'}"
									emptyOption="" />
							</div>
						</div>
						<div class="eight column">
							<div class="column_content">
								<label>TYPE: </label>
								<s:select name="requestType" list="{'HOME MOVE','RENUMBER','HAVE TO UPDATE'}"
									emptyOption="" />
							</div>
						</div>
					</div>

					<div class="sixteen_column section">
						<div class="sixteen column">
							<div class="column_content">
								<label>COMMENT </label>
								<s:textarea name="srComments" rows="10" cols="30"
									cssClass="validate[required] text-input" />
							</div>
						</div>
					</div>
					<div class="sixteen_column section">
						<div class="six column">
							<div class="column_content"></div>
						</div>
						<div class="four column">
							<div class="column_content">
								<s:submit value="Update" />
							</div>
						</div>
						<div class="six column">
							<div class="column_content"></div>
						</div>
					</div>
				</fieldset>
				<s:hidden name="oldSrStatus" value='<s:property value="srStatus"/>'></s:hidden>
			</s:form>
		</div>
	</div>
	<s:actionmessage />
</div>