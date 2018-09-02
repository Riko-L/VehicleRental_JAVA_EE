<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page errorPage="/WEB-INF/pages/error.jsp" %>


<fmt:formatDate value="${reservation.dateStart}" var="dateStart" type="date" pattern="MM-dd-yyyy" />
<fmt:formatDate value="${reservation.dateEnd}" var="dateEnd" type="date" pattern="MM-dd-yyyy" />
                
                
<!DOCTYPE html>
<html>
	<jsp:include page="/WEB-INF/pages/header.jsp">
		<jsp:param name="title" value="Validation" />
	</jsp:include>
	<body>
		<jsp:include page="/WEB-INF/pages/nav.jsp" />
		
		<h1>Reservation is validate </h1>
		<p>ReservationNumber: ${reservation.reservationNumber}</p>
		<p>FirstName: ${reservation.client.firstName}</p>
		<p>LastName: ${reservation.client.lastName}</p>
		<p>Brand: ${reservation.car.brand}</p>
		<p>Model: ${reservation.car.model}</p>
		<p>Day Number: ${reservation.dayNumber} day(s)</p>
		<p>Kilometer Number: ${reservation.kilometerNumber} km</p>
		<p>From: ${dateStart}</p>
		<p>To: ${dateEnd}</p>
		<p>rentalPrice: ${reservation.rentalPrice} €</p>
	
		
		
		
		
		
		
		
		
		
		
		
<jsp:include page="/WEB-INF/pages/footer.jsp"/>
</body>
</html>