<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="/WEB-INF/pages/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/pages/header.jsp">
	<jsp:param name="title" value="Select Vehicle" />
</jsp:include>
<body>
	<jsp:include page="/WEB-INF/pages/nav.jsp" />

	<div class="container" id="content">
		<h2 class="text-center text-primary">Hello ${client.firstName}.
			You can now select your vehicle</h2>
		<br />
		<form action="/validation" method="POST">
		
			<c:if test="${not empty requestScope.cars}">
				<jsp:include page="/WEB-INF/pages/tableCars.jsp"></jsp:include>
			</c:if>
			<c:if test="${not empty requestScope.utilityCar}">
				<jsp:include page="/WEB-INF/pages/utilityCarTable.jsp"></jsp:include>
			</c:if>
			<c:if test="${not empty requestScope.motorBikes}">
				<jsp:include page="/WEB-INF/pages/motorBikeTable.jsp"></jsp:include>
			</c:if>
			
			<input type="hidden" id="rentalPrice" name="rentalPrice" value="" />
			<div class="text-center">
				<p>
					Your price for the selected car is : <span id="rentalPriceShow"></span>
					€
				</p>

			</div>
			<div class="form-row">
				<div class="form-group col-md-3 offset-md-3">
					<button type="submit" value="submit"
						class="form-control btn-primary" value="Select Vehicle">Confirm
						my reservation</button>
				</div>
				<div class="form-group col-md-3">
					<a href="/reservation"
						class="form-control btn-secondary nounderline text-center"
						id="returnBTN" role="button">Return</a>
				</div>
			</div>
		</form>
	</div>


	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>