<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<jsp:include page="/WEB-INF/pages/header.jsp">
		<jsp:param name="title" value="Select Vehicle"/>
	</jsp:include> 
	<body>	
		<jsp:include page="/WEB-INF/pages/nav.jsp"/>
		<br/>
		<div class="container" id="content">
			<h2 class="text-center text-primary">Hello ${client.firstName}. You can now select your vehicle</h2><br/>
			<form action="/validation" method="POST">
				<jsp:include page="/WEB-INF/pages/tableCars.jsp"></jsp:include>
				<div class="form-row">
					<div class="form-group col-md-3">
						<button type="submit" value="submit" class="form-control btn-primary" value="Select Vehicle">Submit</button>
					</div>
					<div class="form-group col-md-3">
						<a href="/reservation" class="form-control btn-secondary text-center" role="button">Return</a>
					</div>
				</div>
			</form>
		</div>
		${reservation}
		${client}
	</body>
</html>