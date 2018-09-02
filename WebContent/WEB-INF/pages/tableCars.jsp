<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.Car"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.Reservation"%>

<%List<Car> cars = (List<Car>) request.getAttribute("cars");%>
<!DOCTYPE html>
<html>
	<body>
		<table id="carTable" class="table table-striped">
			<thead>
				<tr>
					<th class="text-center">Plate Number</th>
					<th class="text-center">Brand</th>
					<th class="text-center">Model</th>
					<th class="text-center">Horse Power</th>
					<th class="text-center">Color</th>
					<th class="text-center">Reservation Price</th>
					<th class="text-center">Kilometer Price</th>
				</tr>
			</thead>
			<tbody>
				<%if (cars != null && !cars.isEmpty()) {
						for (int i = 0; i < cars.size(); ++i) {%>
				<tr>
					<td class="text-center"><%=cars.get(i).getPlateNumber()%></td>
					<td class="text-center"><%=cars.get(i).getBrand()%></td>
					<td class="text-center"><%=cars.get(i).getModel()%></td>
					<td class="text-center"><%=cars.get(i).getHorsePower()%></td>
					<td class="text-center"><%=cars.get(i).getColor()%></td>
					<td class="text-center"><%=cars.get(i).getReservationPrice()%></td>
					<td class="text-center"><%=cars.get(i).getKilometerPrice()%></td>
 					<% if( request.getParameter("dateStart") != null ) { %>
					<td><input class="form-check-input" type="radio" name="choiceCheck" data-id="<%=cars.get(i).getId()%>" id="<%=cars.get(i).getId()%>" <% if(i == 0) { %> checked="checked" <%} %>  ></td>
 					<% } %>
				</tr>
				<% }
					} else { %>
				<tr id="notFoundTableRow">
					<td class="text-center" colspan="7">No car found !</td>
				</tr>
				<% } %>

			</tbody>
		</table>
	</body>
</html>