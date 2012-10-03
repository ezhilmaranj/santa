<%!String check1(String user) {
		return user != null ? user : "";
	}%>
<%
	String user = (String) session.getAttribute("user");
%>
<h2 id="page-crumbs">
	Welcome, <span class="here"><%=check1(user)%>
	</span>
</h2>