<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<nav class="navbar navbar-light " id="header">
	<a class="navbar-brand" href="#">
		<img src="${pageContext.servletContext.contextPath}/resources/images/challenger-srt-392.png"/>
		<img src="${pageContext.servletContext.contextPath}/resources/images/SIXT.png"/>
	</a>

	<ul class="nav nav-pills">
		<li class="nav-item"><a class="btn btn-outline-warning"
			href="./clients">Client List</a></li>
		<li class="nav-item"><a class="btn btn-outline-warning ml-3"
			href="./cars">Cars List</a></li>
		<li class="nav-item"><a class="btn btn-outline-warning ml-3"
			href="./utilityCars">Utilities List</a></li>
		<li class="nav-item"><a class="btn btn-outline-warning ml-3"
			href="./motorBikes">MotorBikes List</a></li>
		<li class="nav-item"><a class="btn btn-outline-warning ml-3"
			href="./reservation">Reservation</a></li>
	</ul>
	<ul class="nav nav-pills navbar-right">
		<c:if test="${clientBean.isGuest()}">
		<li class="nav-item"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#connectionModal">Connection</button></li>
		<li class="nav-item"><button type="button" class="btn btn-success ml-3" data-toggle="modal" data-target="#registrationModal">Registration</button></li>
		</c:if>
		<c:if test="${not clientBean.isGuest()}">
		<li class="nav-item"><button type="button" class="btn btn-info ml-3">Profil ${clientBean.getLogin()}</button></li>
		<li class="nav-item"><form action="/logout" method="POST"><button type="submit" class="btn btn-danger ml-3">Logout</button></form></li>
		</c:if>
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
							<input type="email" class="form-control" placeholder="Email"
								aria-label="Email" aria-describedby="basic-addon1" name="mail">
						</div>
					</div>
					<div class="modal-body">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text" id="basic-addon1">Pwd</span>
							</div>
							<input type="password" class="form-control" placeholder="Password"
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
					<h5 class="modal-title text-success" id="registrationModalLabel">Registration</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="/registration" method="POST">
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
							<div class="form-group col-md-12">
								<div class="input-group">
					        		<div class="input-group-prepend">
			          					<div class="input-group-text">Email</div>
					        		</div>
									<input type="email" class="form-control" name="email" value="">
								</div>
							</div>
							<div class="form-group col-md-12">
								<div class="input-group">
					        		<div class="input-group-prepend">
			          					<div class="input-group-text">BirthDate</div>
					        		</div>
									<input type="date" class="form-control" name="birthdate" value="">
								</div>
							</div>
							<div class="form-group col-md-6">
								<div class="input-group">
					        		<div class="input-group-prepend">
			          					<div class="input-group-text">License n°</div>
					        		</div>
									<input type="text" class="form-control" name="licensenumber" value="">
								</div>
							</div>
							<div class="form-group col-md-6">
								<div class="input-group">
					        		<div class="input-group-prepend">
			          					<div class="input-group-text">Date</div>
					        		</div>
									<input type="date" class="form-control" name="licensedate" value="">
								</div>
							</div><div class="form-group col-md-12">
								<div class="input-group">
					        		<div class="input-group-prepend">
			          					<div class="input-group-text">Login</div>
					        		</div>
									<input type="password" class="form-control" name="login" placeholder="Choose a login" value="">
								</div>
							</div>
							<div class="form-group col-md-12">
								<div class="input-group">
					        		<div class="input-group-prepend">
			          					<div class="input-group-text">Password</div>
					        		</div>
									<input type="password" class="form-control" name="password" placeholder="3 characters at least" value="">
								</div>
							</div>
							<div class="form-group col-md-12">
								<div class="input-group">
					        		<div class="input-group-prepend">
			          					<div class="input-group-text">Password</div>
					        		</div>
									<input type="password" class="form-control" name="password" placeholder="Re-type" value="">
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-success">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>


</nav>