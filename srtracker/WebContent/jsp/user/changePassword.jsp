<%@ taglib uri="/struts-tags" prefix="s"%>

<script>
	$(function() {

		$("#login").validationEngine();

	});
</script>

<div class="prefix_5 grid_6 suffix_5">
	<div class="box">
		<h2>
			<a href="#" id="toggle-login-forms">CHANGE LOGIN INFORMATION</a>
		</h2>
		<div class="block" id="login-forms">
			<s:form action="changePasswordUserInfoAction" theme="simple"
				id="login">
				<fieldset class="login">
					<legend>CHANGE PASSWORD</legend>
					<div class="sixteen_column section">
						<div class="sixteen column">
							<div class="column_content">
								<label>NEW PASSWORD </label>
								<s:password name="password" id="new"
									cssClass="validate[required] text-input" />
							</div>
						</div>
					</div>
					<div class="sixteen_column section">
						<div class="sixteen column">
							<div class="column_content">
								<label>CONFIRM : </label>
								<s:password name="cpassword"
									cssClass="validate[required,equals[new]] text-input" />
							</div>
						</div>
					</div>
					<div class="sixteen_column section">
						<div class="ten column">
							<div class="column_content"></div>
						</div>
						<div class="prefix_2 six column">
							<div class="column_content">
								<s:submit value="Login"></s:submit>
							</div>
						</div>
					</div>
					<div></div>
				</fieldset>
			</s:form>
		</div>
	</div>
</div>
<div class="clear"></div>
<div class="prefix_4 grid_6 suffix_6">
	<div class="grid_8 success msg">
		<p>Message</p>
		<s:actionmessage />
		<s:actionerror />
	</div>
</div>