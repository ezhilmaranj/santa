<%@page import="org.apache.struts2.components.ActionError"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = application.getContextPath();
%>

<script type="text/javascript">
	$(function() {
		$("#login").validationEngine();
	});
</script>

<div class="prefix_5 grid_6 suffix_5">
	<div class="box">
		<h2>
			<a href="#" id="toggle-login-forms">UPLOAD SERVICE REQUESTS</a>
		</h2>
		<div class="block" id="login-forms">
			<s:form action="uploadServiceRequestAction" theme="simple" id="login"  enctype="multipart/form-data" method="post">
				<fieldset class="login">
					<legend>Service Request</legend>
					<div class="sixteen_column section">
						<div class="sixteen column">
							<div class="column_content">
								<label>SR-DOCUMENT </label>
								<s:file name="srFile" accept="application/vnd.ms-excel"
									cssClass="validate[required] text-input" />
							</div>
						</div>
					</div>
					<div class="sixteen_column section">
						<div class="ten column">
							<div class="column_content"></div>
						</div>
						<div class="prefix_2 six column">
							<div class="column_content">
								<s:submit value="Upload"></s:submit>
							</div>
						</div>
					</div>
					<div></div>
				</fieldset>
			</s:form>
		</div>
	</div>
</div>