<%
	final String queryString = request.getQueryString();
	final String url = request.getContextPath() + "/login.jhtml"
			+ (queryString != null ? "?" + queryString : "");
	response.sendRedirect(response.encodeURL(url));
%>
