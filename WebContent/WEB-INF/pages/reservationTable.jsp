<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.List"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.Reservation"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.Client"%>
<jsp:useBean id="clientBean" scope="session" type="com.campusnumerique.vehiclerental.bean.ClientBean" />

<%List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");%>

	<table id="reservationTable" class="table table-striped">
		<thead>
			<tr>
				<th class="text-center">Reservation Number</th>
				<th class="text-center">Kind</th>
				<th class="text-center">FirstName</th>
				<th class="text-center">LastName</th>
				<th class="text-center">Date Start</th>
				<th class="text-center">Date End</th>
				<th class="text-center">Rental Price</th>
		
			</tr>
		</thead>
		<tbody>
			<%if (reservations != null && !reservations.isEmpty()) {
					for (int i = 0; i < reservations.size(); ++i) {%>
			<tr>
				<td class="text-center"><%=reservations.get(i).getReservationNumber()%></td>
				<td class="text-center"><%=reservations.get(i).getKindLabel()%></td>
   				<td class="text-center"><%=reservations.get(i).getClient().getFirstName()%></td>
   				<td class="text-center"><%=reservations.get(i).getClient().getLastName()%></td>
				<td class="text-center"><%=reservations.get(i).getDateStart()%></td>
				<td class="text-center"><%=reservations.get(i).getDateEnd()%></td>
				<td class="text-center"><%=reservations.get(i).getRentalPrice()%></td>
				<td><input class="form-check-input" type="radio" name="choiceCheck" data-id="<%=reservations.get(i).getId()%>" id="<%=reservations.get(i).getId()%>"></td>
			</tr>
			<% }
				} else { %>
			<tr id="notFoundTableRow">
				<td class="text-center" colspan="7">No reservation found !</td>
			</tr>
			<% } %>
		</tbody>
	</table>