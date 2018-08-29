<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="client" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Car List</title>
	
	<!-- JQuery 3.3.1 -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<!-- Bootstrap 4.1.3 -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
	<!-- General -->
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/global.css" />
	<script src="${pageContext.servletContext.contextPath}/resources/js/car.js"></script>
</head>
<body>
	<nav class="navbar navbar-light " id="header">
	 <a class="navbar-brand" href="#">
		<img  src="${pageContext.servletContext.contextPath}/resources/images/delorean.png"/>
	 </a>
	  <ul class="nav nav-pills">
	    <li class="nav-item">
	      <a class="nav-link" href="./clients">Client List</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="./cars">Car List</a>
	    </li>
	   </ul>
		<ul class="nav navbar-nav navbar-right">
			<li>User Connected: <%= client.getLogin() %></li>
		</ul>
	</nav>
	<br/>
	<div class="container" id="content">
		<div class="row">
			<h2>Car List</h2>
			<table id="carTable" class="table table-striped">
				<thead>
					<tr>
						<th>Plat Number</th>
						<th>Brand</th>
						<th>Model</th>
						<th>Horse Power</th>
						<th>Color</th>
						<th>Reservation Price</th>
						<th>Kilometer Price</th>
					</tr>
				</thead>
				<tbody>
		
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>