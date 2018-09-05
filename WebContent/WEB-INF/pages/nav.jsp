<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<nav class="navbar navbar-light " id="header">
	<a class="navbar-brand" href="#"><img src="${pageContext.servletContext.contextPath}/resources/images/harley-davidson-motorcycle-batteries.png"/>
									<img src="${pageContext.servletContext.contextPath}/resources/images/challenger-srt-392.png"/>
	</a>

	<ul class="nav nav-pills">
		<li class="nav-item"><a class="btn btn-outline-info"
			href="./clients">Client List</a></li>
		<li class="nav-item"><a class="btn btn-outline-info ml-3"
			href="./cars">Cars List</a></li>
		<li class="nav-item"><a class="btn btn-outline-info ml-3"
			href="./utilityCars">Utilities List</a></li>
		<li class="nav-item"><a class="btn btn-outline-info ml-3"
			href="./motorBikes">MotorBikes List</a></li>
		<li class="nav-item"><a class="btn btn-outline-info ml-3"
			href="./reservation">Reservation</a></li>
	</ul>
	<ul class="nav nav-pills navbar-right">
		<li class="nav-item"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#connectionModal">Connection</button></li>
		<li class="nav-item"><button type="button" class="btn btn-success ml-3" data-toggle="modal" data-target="#registrationModal">Registration</button></li>
		<%-- 		<li>User Connected: <%=clientBean.getLogin()%></li> --%>
	</ul>
	
	<!-- 	Modal de Connexion -->
	
	<div class="modal fade" id="connectionModal" tabindex="-1"
		role="dialog" aria-labelledby="connectionModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-primary" id="connectionModalLabel">Connection</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="/connection" method="POST">
				<div class="modal-body">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">@</span>
						</div>
						<input type="text" class="form-control" placeholder="Email"
							aria-label="Email" aria-describedby="basic-addon1" name="mail">
					</div>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">Pwd</span>
						</div>
						<input type="text" class="form-control" placeholder="Password"
							aria-label="Password" aria-describedby="basic-addon1" name="password">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">Connect</button>
				</div>
			</form>
			</div>
		</div>
	</div>
	
	
	<!-- 	Modal d'Inscription -->
	<div class="modal fade" id="registrationModal" tabindex="-1"
		role="dialog" aria-labelledby="registrationModalLabel"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title text-primary" id="registrationModalLabel">Registration</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-row">
						<div class="form-group col-md-6">
							<div class="input-group">
				        		<div class="input-group-prepend">
				          			<div class="input-group-text">Firstname</div>
				        		</div>
								<input type="text" class="form-control" name="firstname" value="">
							</div>
						</div>
						<div class="form-group col-md-6">
							<div class="input-group">
				        		<div class="input-group-prepend">
		          					<div class="input-group-text">LastName</div>
				        		</div>
								<input type="text" class="form-control" name="lastname" value="">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</nav>