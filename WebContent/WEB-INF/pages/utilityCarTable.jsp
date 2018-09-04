<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.UtilityCar"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.Reservation"%>

<%List<UtilityCar> utilityCars = (List<UtilityCar>) request.getAttribute("utilityCars");%>

		<table id="utilityCarTable" class="table table-striped">
			<thead>
				<tr>
					<th class="text-center">Plate Number</th>
					<th class="text-center">Brand</th>
					<th class="text-center">Model</th>
					<th class="text-center">Horse Power</th>
					<th class="text-center">Color</th>
					<th class="text-center">Volume</th>
					<th class="text-center">Reservation Price</th>
					<th class="text-center">Kilometer Price</th>
				</tr>
			</thead>
			<tbody>
				<%if (utilityCars != null && !utilityCars.isEmpty()) {
						for (int i = 0; i < utilityCars.size(); ++i) {%>
				<tr>
					<td class="text-center"><%=utilityCars.get(i).getPlateNumber()%></td>
					<td class="text-center"><%=utilityCars.get(i).getBrand()%></td>
					<td class="text-center"><%=utilityCars.get(i).getModel()%></td>
					<td class="text-center"><%=utilityCars.get(i).getHorsePower()%></td>
					<td class="text-center"><%=utilityCars.get(i).getColor()%></td>
					<td class="text-center"><%=utilityCars.get(i).getVolume()%></td>
					<td class="text-center"><%=utilityCars.get(i).getReservationPrice()%></td>
					<td class="text-center"><%=utilityCars.get(i).getKilometerPrice()%></td>
 					<% if( request.getParameter("dateStart") != null ) { %>
					<td><input class="form-check-input" type="radio" name="choiceCheck" data-id="<%=utilityCars.get(i).getId()%>" id="<%=utilityCars.get(i).getId()%>" <% if(i == 0) { %> checked="checked" <%} %>  ></td>
 					<% } %>
				</tr>
				<% }
					} else { %>
				<tr id="notFoundTableRow">
					<td class="text-center" colspan="8">No utility Car found !</td>
				</tr>
				<% } %>

			</tbody>
		</table>
