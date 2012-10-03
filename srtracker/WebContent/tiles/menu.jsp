<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String user = (String) session.getAttribute("user");
	String role = (String) session.getAttribute("role");
%>
<%!boolean checkLogin(String user) {
		return user != null ? true : false;
	}

	boolean checkRole(String role) {
		if (role != null && role.equals("admin")) {
			return true;
		} else {
			return false;
		}
	}%>

<li class="selected"><a href="homeLinkAction.action">HOME</a></li>


<%
	if (checkLogin(user)) {
%>

<li><a href="listServiceRequestAction.action">SERVICE REQUEST</a></li>
<li><a href="uploadLinkAction.action">UPLOAD DATA</a></li>
<li><a href="#">REPORT</a>
	<ul>
		<li><a href="reviewReportLinkAction.action">REVIEW ORDER
				REPORT</a></li>
		<li><a href="boltStatusReportLinkAction.action">BOLT STATUS
				REPORT</a></li>
		<li><a href="cadReportLinkAction.action">COMMITED ORDER
				REPORT</a></li>
	</ul></li>

<li><a href="#" style="text-transform: uppercase; color: navy;"><%=user%></a>
	<ul>
		<li><a href="changePasswordLinkAction.action">CHANGE PASSWORD</a></li>
		<li><a href="logoutUserInfoAction.action">LOGOUT</a></li>
	</ul></li>
<%
	if (checkRole(role)) {
%>
<li><a href="registerlinkUserInfoAction.action">REGISTER</a></li>
<%
	}
%>
<%
	} else {
%>

<%
	}
%>

