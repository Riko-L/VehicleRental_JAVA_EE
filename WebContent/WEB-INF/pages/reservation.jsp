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
		<div class="row">
			<h2>Réservation</h2>


			<form action="/reservation" method="POST">
			Date du : <input type="text" id="dateStart" name="dateStart" /> au : <input type="text" id="dateEnd" name="dateEnd"/>
			<br/>
			Nombre de jours : <input type="text" id="dayNumber" name="dayNumber" />
			
			Kilometer Number: <input type="text" name="first_name"> 
				<input type="submit" value="Select vehicle" />
			</form>



		</div>
	</div>

</body>
</html>