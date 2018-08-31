
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
							<input type="text" id="dateStart" class="form-control" name="dateStart" placeholder="Date" value="<%= session.getAttribute("dateStart") %>">
						</div>
					</div>
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">To</div>
					        </div>
							<input type="text" id="dateEnd" class="form-control" name="dateEnd" placeholder="Date" value="<%= session.getAttribute("dateEnd") %>">
						</div>
					</div>
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">Days</div>
					        </div>
							<input type="text" id="dayNumber" class="form-control" name="dayNumber" placeholder="Days of booking" <%= session.getAttribute("dayNumber") %>>
								
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
								<option selected>Choose...</option>
								<option value="1">Tourism Car</option>
	      						<option value="2">Utility Car</option>
	      						<option value="3">Motorbike</option>
							</select><br/>
						</div>
					</div>
					<div class="form-group col-md-4">
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">Km</div>
					        </div>
							<input type="text" id="kilometerNumber" class="form-control" name="kilometerNumber" placeholder="estimate during the rental period" value="<%= session.getAttribute("kilometerNumber") %>"><br/>
						</div>
					</div>
				</div>
				<input type="submit" class="form-control btn-primary" value="Select Vehicle" /><br/>
			</form>
		</div>
	</body>
</html>