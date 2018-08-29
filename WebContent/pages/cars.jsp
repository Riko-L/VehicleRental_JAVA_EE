<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.Car"%>
<jsp:useBean id="client" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />


<%
	List<Car> cars = (List<Car>) request.getAttribute("cars");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Car List</title>

<!-- JQuery 3.3.1 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<!-- Bootstrap 4.1.3 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<!-- General -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/global.css" />
<script
	src="${pageContext.servletContext.contextPath}/resources/js/car.js"></script>
</head>
<body>
	<nav class="navbar navbar-light " id="header">
		<a class="navbar-brand" href="#"> <img
			src="${pageContext.servletContext.contextPath}/resources/images/delorean.png" />
		</a>
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link" href="./clients">Client
					List</a></li>
			<li class="nav-item"><a class="nav-link" href="./cars">Car
					List</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>User Connected: <%=client.getLogin()%></li>
		</ul>
	</nav>
	<br />
	<div class="container" id="content">
		<div class="row">
			<h2>Car List</h2>
			<table id="carTable" class="table table-striped">
				<thead>
					<tr>
						<th>Plate Number</th>
						<th>Brand</th>
						<th>Model</th>
						<th>Horse Power</th>
						<th>Color</th>
						<th>Reservation Price</th>
						<th>Kilometer Price</th>
					</tr>
				</thead>
				<tbody>
					<%
						if (cars != null && !cars.isEmpty()) {
							for (int i = 0; i < cars.size(); ++i) {
					%>
					<tr>
						<td><%=cars.get(i).getPlateNumber()%></td>
						<td><%=cars.get(i).getBrand()%></td>
						<td><%=cars.get(i).getModel()%></td>
						<td><%=cars.get(i).getHorsePower()%></td>
						<td><%=cars.get(i).getColor()%></td>
						<td><%=cars.get(i).getReservationPrice()%></td>
						<td><%=cars.get(i).getKilometerPrice()%></td>
					</tr>
					<%
						}

						} else {
					%>
					<tr>
						<td>No data Found</td>
					</tr>
						<%
							}
						%>
					
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>