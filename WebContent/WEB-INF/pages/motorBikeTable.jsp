<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.MotorBike"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.Reservation"%>

<%List<MotorBike> motorBikes = (List<MotorBike>) request.getAttribute("motorBikes");%>

		<table id="motorBikeTable" class="table table-striped">
			<thead>
				<tr>
					<th class="text-center">Plate Number</th>
					<th class="text-center">Brand</th>
					<th class="text-center">Model</th>
					<th class="text-center">Color</th>
					<th class="text-center">Horse Power</th>
					<th class="text-center">Capacity</th>
					<th class="text-center">Reservation Price</th>
					<th class="text-center">Kilometer Price</th>
				</tr>
			</thead>
			<tbody>
				<%if (motorBikes != null && !motorBikes.isEmpty()) {
						for (int i = 0; i < motorBikes.size(); ++i) {%>
				<tr>
					<td class="text-center"><%=motorBikes.get(i).getPlateNumber()%></td>
					<td class="text-center"><%=motorBikes.get(i).getBrand()%></td>
					<td class="text-center"><%=motorBikes.get(i).getModel()%></td>
					<td class="text-center"><%=motorBikes.get(i).getColor()%></td>
					<td class="text-center"><%=motorBikes.get(i).getHorsePower()%></td>
					<td class="text-center"><%=motorBikes.get(i).getCapacity()%></td>
					<td class="text-center"><%=motorBikes.get(i).getReservationPrice()%></td>
					<td class="text-center"><%=motorBikes.get(i).getKilometerPrice()%></td>
 					<% if( request.getParameter("dateStart") != null ) { %>
					<td><input class="form-check-input" type="radio" name="choiceCheck" data-id="<%=motorBikes.get(i).getId()%>" id="<%=motorBikes.get(i).getId()%>" <% if(i == 0) { %> checked="checked" <%} %>  ></td>
 					<% } %>
				</tr>
				<% }
					} else { %>
				<tr id="notFoundTableRow">
					<td class="text-center" colspan="8">No MotorBike found !</td>
				</tr>
				<% } %>

			</tbody>
		</table>