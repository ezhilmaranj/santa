<%!String check1(String user){
	return user!=null? user:" Login ";
}
String check2(String user){
	return user!=null? user:" Register";
}
%>
<%
String user = (String)session.getAttribute("user");
%>
<h2 id="page-crumbs">
	Welcome, <span class="here">Please<a href="loginLinkUserAction"><%=check1(user)%></a>/
		<a href="registerLinkUserAction"><%=check2(user)%></a> To Proceed..
	</span>
</h2>