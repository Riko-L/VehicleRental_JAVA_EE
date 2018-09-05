<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ page errorPage="/WEB-INF/pages/error.jsp" %>
<%@ page import="java.util.List"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.Client"%>

<%
	List<Client> clients = (List) request.getAttribute("clients");
%>


<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/pages/header.jsp">
	<jsp:param name="title" value="Client List" />
</jsp:include> 
<body>
	<jsp:include page="/WEB-INF/pages/nav.jsp" />
	
	<div class="container" id="content">
		<h2 class="text-center text-primary">Client List</h2><br/>
		<table id="userTable" class="table table-striped">
			<thead>
				<tr>
					<th>Login</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>License Number</th> 
					<th>Age</th> 
				</tr>
			</thead>
			<tbody>
				<%
					if (clients != null && !clients.isEmpty()) {
						for (int i = 0; i < clients.size(); ++i) {
				%>
				<tr>
					<td><%=clients.get(i).getLogin()%></td>
					<td><%=clients.get(i).getFirstName()%></td>
					<td><%=clients.get(i).getLastName()%></td>
					<td><%=clients.get(i).getMail()%></td>
					<td><%=clients.get(i).getLicenseNumber()%></td>
					<td><%=clients.get(i).getAge()%> years</td>
				</tr>
				<%
					}
					} else {
				%>
				<tr>
					<td>No Data Found</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	
	<jsp:include page="/WEB-INF/pages/footer.jsp"/>
</body>
</html>