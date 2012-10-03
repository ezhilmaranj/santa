<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
	$(function() {
		$("#login").validationEngine();
	});
	
	function getVal(){
		alert("getval");
		return validateMandateField($("#mf").val());
	}
</script>

<div class="prefix_3 grid_5">
	<div class="box">
		<h2>AVAILABLE COLUMN</h2>
		<div class="sixteen_column section" id="fields">
			<div class="sixteen column">
				<div class="column_content tray">
					<label>OPEN DATE > </label>
					<s:textfield name="creratedDate"
						cssClass="datepicker validate[required,custom[date]] text-input check" />
				</div>
			</div>
			<div class="sixteen column">
				<div class="column_content tray">
					<label>COMMITED DATE = </label>
					<s:textfield name="commitedDate"
						cssClass="datepicker validate[required,custom[date]] text-input check" />
				</div>
			</div>
			<div class="sixteen column">
				<div class="column_content tray">
					<label>REVIEW DATE = </label>
					<s:textfield name="reviewDate" id="reviewDate"
						cssClass="datepicker validate[required,custom[date]] text-input check" />
				</div>
			</div>
			<div class="sixteen column">
				<div class="column_content tray">
					<label>CATEGORY = </label>
					<s:select name="category" list="{'PROCESS ERROR','OPENREACH DEALY','IN PROGRESS',
								'BAU EXCLUDES','ECOBB PENDING','HAVE TO UPDATE'}" emptyOption="" cssClass="check"/>
				</div>
			</div>
			<div class="sixteen column">
				<div class="column_content tray">
					<label>SR STATUS = </label>
					<s:select name="srStatus" list="{'OPEN','CLOSE'}"
						cssClass="validate[required] text-input check" />
				</div>
			</div>
		</div>
	</div>
</div>
<div class="grid_5">
	<div class="box">
		<h2>REPORT</h2>
		<div class="block" id="login-forms">
			<s:form action='<s:property value="reportType"/>' theme="simple" name="reportForm">
				<div class="sixteen_column section">
					<fieldset id="droppable">
						<legend>REPORT</legend>

					</fieldset>
					<fieldset>
						<div class="sixteen column  draggable">
							<div class="column_content">
								<s:submit value="REPORT" onclick="return getVal()"/>
							</div>
						</div>
					</fieldset>
				</div>
			</s:form>
			<input type="hidden" id="mf" value="<s:property value="mandateField"/>"/>
		</div>
	</div>
</div>
