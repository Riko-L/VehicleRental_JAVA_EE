<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/pages/header.jsp">
	<jsp:param name="title" value="Select Vehicle" />
</jsp:include> 
<body>
	<jsp:include page="/WEB-INF/pages/nav.jsp" />
	<br />

<h1>Hello Select Page</h1>


${reservation}
${client}

</body>
</html>