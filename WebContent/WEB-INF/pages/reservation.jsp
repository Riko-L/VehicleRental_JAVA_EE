
<%@page import="com.campusnumerique.vehiclerental.utils.Constante"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>


<!DOCTYPE html>
<html>
	<jsp:include page="/WEB-INF/pages/header.jsp">
		<jsp:param name="title" value="Reservation" />
	</jsp:include>
	<body>
		<jsp:include page="/WEB-INF/pages/nav.jsp" />
		<br/>
		<div class="container" id="content">
			<h2 class="text-center text-primary">Reservation</h2><br/>
			<form action="/reservation" method="POST">
				<div class="form-row">
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">From</div>
					        </div>
							<input type="text" id="dateStart" class="form-control" name="dateStart" placeholder="Date" value="${sessionScope.dateStart}">
						</div>
					</div>
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">To</div>
					        </div>
							<input type="text" id="dateEnd" class="form-control" name="dateEnd" placeholder="Date" value="${sessionScope.dateEnd}">
						</div>
					</div>
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">Days</div>
					        </div>
							<input type="text" id="dayNumber" class="form-control" name="dayNumber" placeholder="Days of booking" value="${sessionScope.dayNumber}" readonly="readonly">
								
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
								<option value="<%= Constante.KIND_NO_CHOICE %>" <%if (session.getAttribute("kind") != null && session.getAttribute("kind").equals(Constante.KIND_NO_CHOICE)){ %> selected <% } %>>Choose...</option>
								<option value="<%= Constante.KIND_TOURISM_CAR %>" <%if (session.getAttribute("kind") != null && session.getAttribute("kind").equals(Constante.KIND_TOURISM_CAR)){ %> selected <% } %> >Tourism Car</option>
	      						<option value="<%= Constante.KIND_UTILITY_CAR %>"<%if (session.getAttribute("kind") != null && session.getAttribute("kind").equals(Constante.KIND_UTILITY_CAR)){ %> selected <% } %> >Utility Car</option>
	      						<option value="<%= Constante.KIND_MOTORBIKE %>"<%if (session.getAttribute("kind") != null && session.getAttribute("kind").equals(Constante.KIND_MOTORBIKE)){ %> selected <% } %>>Motorbike</option>
							</select><br/>
						</div>
					</div>
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">Km</div>
					        </div>
							<input type="text" id="kilometerNumber" class="form-control" name="kilometerNumber" placeholder="estimate during the rental period" value="${sessionScope.kilometerNumber}"><br/>
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