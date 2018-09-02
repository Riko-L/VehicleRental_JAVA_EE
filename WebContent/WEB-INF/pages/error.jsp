<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
    <%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
	<jsp:include page="/WEB-INF/pages/header.jsp">
		<jsp:param name="title" value="Error" />
	</jsp:include>
	<body>
		<jsp:include page="/WEB-INF/pages/nav.jsp" />
		<br/>
		Message: <%=exception.getMessage()%>

StackTrace:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%>
		
		
<jsp:include page="/WEB-INF/pages/footer.jsp"/>
</body>
</html>