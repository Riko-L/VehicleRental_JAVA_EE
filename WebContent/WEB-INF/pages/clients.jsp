<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ page errorPage="/WEB-INF/pages/error.jsp" %>
<%@ page import="java.util.List"%>
<%@ page import="com.campusnumerique.vehiclerental.entity.Client"%>
<jsp:useBean id="clientBean" scope="session" type="com.campusnumerique.vehiclerental.bean.ClientBean" />
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
		<div class="row">
			<h2>Client List</h2>
			<table id="userTable" class="table table-striped">
				<thead>
					<tr>
						<th>Login</th>
						<th>First Name</th>
						<th>Last Name</th>
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
	</div>
	
	<jsp:include page="/WEB-INF/pages/footer.jsp"/>
</body>
</html>