<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ page errorPage="/WEB-INF/pages/error.jsp" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/pages/header.jsp">
	<jsp:param name="title" value="MotorBikes List" />
</jsp:include>
<body>
	<jsp:include page="/WEB-INF/pages/nav.jsp" />

	<div class="container" id="content">
		<h2 class="text-center text-primary">Utility Cars List</h2><br/>
			<jsp:include page="/WEB-INF/pages/utilityCarTable.jsp"></jsp:include>
	</div>
	
	<jsp:include page="/WEB-INF/pages/footer.jsp"/>
</body>
</html>