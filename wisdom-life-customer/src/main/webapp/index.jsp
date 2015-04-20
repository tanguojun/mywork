<%
	final String queryString = request.getQueryString();
	final String url = request.getContextPath() + "/index.jhtml"
			+ (queryString != null ? "?" + queryString : "");
	response.sendRedirect(response.encodeURL(url));
%>
