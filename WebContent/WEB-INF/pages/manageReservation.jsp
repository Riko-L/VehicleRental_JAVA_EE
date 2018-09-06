<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="/WEB-INF/pages/error.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

<!DOCTYPE html>
<html>
	<jsp:include page="/WEB-INF/pages/header.jsp">
		<jsp:param name="title" value="Admin Reservation"/>
	</jsp:include>
	<body>
		<jsp:include page="/WEB-INF/pages/nav.jsp" />
	
		<div class="container" id="content">
			<h2 class="text-center text-primary">Reservations Manager</h2>
			<br/>
			
				
				<jsp:include page="/WEB-INF/pages/reservationTable.jsp"></jsp:include>
				
				
						
				<div class="form-row">
					<div class="form-group col-md-2 offset-md-3">
						<a href="/reservation"
							class="form-control btn-success nounderline text-center"
							id="returnBTN" role="button">Create</a>
					</div>
					
					<div class="form-group col-md-2">
					<form action="/reservationManage" method="POST">
					<input type="hidden" id="reservationId" name="reservationId"/>
						<button type="submit" value="delete" name="action" class="form-control  btn-danger nounderline text-center">Delete</button>
					</form>
					</div>
					<div class="form-group col-md-2">
						<button class="form-control btn-primary nounderline text-center"
							id="promobtn" role="button">Special Offers</button>
					</div>
				</div>
			
		</div>
		<jsp:include page="/WEB-INF/pages/footer.jsp" />
	</body>
</html>