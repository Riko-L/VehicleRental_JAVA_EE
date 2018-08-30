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
				<h2 class="text-center text-primary">Réservation</h2><br/>
			<form action="/reservation" method="POST">
				<div class="form-row">
					<div class="form-group col-md-4">
						<label>Date</label>
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">From</div>
					        </div>
							<input type="text" id="dateStart" class="form-control" name="dateStart" placeholder="Date From">
						</div>
					</div>
					<div class="form-group col-md-4">
						<label>Date</label>
						<div class="input-group">
					        <div class="input-group-prepend">
					          <div class="input-group-text">To</div>
					        </div>
							<input type="text" id="dateEnd" class="form-control" name="dateEnd" placeholder="To">
						</div>
					</div>
					<div class="form-group col-md-4">
						<label>Day Number</label>
						<input type="text" id="dayNumber" class="form-control" name="dayNumber" placeholder="Day Number">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-4">
						<label>Kilometer Number</label>
						<input type="text" class="form-control" name="kilometerNumber" placeholder="Kilometer Number"><br/>
					</div>
				</div>
				<input type="submit" class="form-control btn-primary" value="Select Vehicle" /><br/>
			</form>
		</div>
	</body>
</html>