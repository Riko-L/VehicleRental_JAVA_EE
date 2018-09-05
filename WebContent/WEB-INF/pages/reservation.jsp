<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ page errorPage="/WEB-INF/pages/error.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@page import="com.campusnumerique.vehiclerental.utils.Constante"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>


<fmt:formatDate value="${reservation.dateStart}" var="dateStart" type="date" pattern="dd-MM-yyyy" />
<fmt:formatDate value="${reservation.dateEnd}" var="dateEnd" type="date" pattern="dd-MM-yyyy" />


<!DOCTYPE html>
<html>
	<jsp:include page="/WEB-INF/pages/header.jsp">
		<jsp:param name="title" value="Reservation" />
	</jsp:include>
	<body >
	
		<jsp:include page="/WEB-INF/pages/nav.jsp" />
		
		<div class="container" id="content">
			<h2 class="text-center text-primary">Reservation</h2><br/>
			<form action="/reservation" method="POST">
				<div class="form-row">
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">From</div>
					        </div>
							<input type="text" id="dateStart" class="form-control" name="dateStart" placeholder="Date" value="${dateStart}">
						</div>
					</div>
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">To</div>
					        </div>
							<input type="text" id="dateEnd" class="form-control" name="dateEnd" placeholder="Date" value="${dateEnd}">
						</div>
					</div>
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">Days</div>
					        </div>
							<input type="text" id="dayNumber" class="form-control" name="dayNumber" placeholder="Days of booking" value="${reservation.dayNumber}" style="background-color:white;" readonly="readonly">
								
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">Kind</div>
					        </div>
							<select class="form-control" id="kind" name="kind">
<%-- 								<option value="${ Constante.KIND_NO_CHOICE }" <c:if test="${reservation.kind == Constante.KIND_NO_CHOICE }"> selected </c:if>>Choose...</option> --%>
<%-- 								<option value="${ Constante.KIND_TOURISM_CAR }" <c:if test="${reservation.kind == Constante.KIND_TOURISM_CAR }"> selected </c:if>>Tourism Car</option> --%>
<%-- 	      						<option value="${ Constante.KIND_UTILITY_CAR }" <c:if test="${reservation.kind == Constante.KIND_UTILITY_CAR }"> selected </c:if>>Utility Car</option> --%>
<%-- 	      						<option value="${ Constante.KIND_MOTORBIKE }" <c:if test="${reservation.kind == Constante.KIND_MOTORBIKE }"> selected </c:if>>Motorbike</option> --%>
							</select><br/> 
						</div>
					</div>
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">Km</div>
					        </div>
							<input type="text" id="kilometerNumber" class="form-control" name="kilometerNumber" placeholder="estimate during the rental period" value="${reservation.kilometerNumber}"><br/>
						</div>
					</div>
				</div>
				<input type="submit" class="form-control btn-primary" value="Select Vehicle" /><br/>
				<% if(request.getAttribute("error") != null) { %>
				<div class="alert alert-danger">
					  <strong>Warning !</strong> <%= request.getAttribute("error") %>
				</div>
				<% } %>
			</form>
		</div>
		<jsp:include page="/WEB-INF/pages/footer.jsp"/>
	</body>
</html>