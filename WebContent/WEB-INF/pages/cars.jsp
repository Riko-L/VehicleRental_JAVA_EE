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
<jsp:include page="/WEB-INF/pages/header.jsp">
	<jsp:param name="title" value="Cars List" />
</jsp:include>
<body>
	<jsp:include page="/WEB-INF/pages/nav.jsp" />
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