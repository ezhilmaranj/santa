<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
	$(function() {
		$("#login").validationEngine();
	});

	function getVal() {
		alert("getval");
		return validateMandateField($("#mf").val());
	}
</script>

<div class="prefix_5 grid_6 suffix_5">
	<div class="box">
		<h2>REPORT</h2>
		<div class="block" id="login-forms">
			<s:form action="cadReportServiceRequestAction" theme="simple"
				name="reportForm">

				<fieldset>
					<legend>COMMITED ORDER REPORT</legend>
					<div class="sixteen_column section">
						<div class="sixteen column">
							<div class="column_content tray">
								<label>COMMITED DATE <= </label>
								<s:textfield name="commitedDate"
									cssClass="datepicker validate[required,custom[date]] text-input" />
							</div>
						</div>
					</div>
					<div class="sixteen_column section">
						<div class="ten column">
							<div class="column_content"></div>
						</div>
						<div class="four column">
							<div class="column_content">
								<s:submit value="REPORT" />
							</div>
						</div>
					</div>
				</fieldset>

			</s:form>
		</div>
	</div>
</div>