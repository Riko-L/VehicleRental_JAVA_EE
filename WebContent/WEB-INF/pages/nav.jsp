<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="registerBean" scope="session" type="com.campusnumerique.vehiclerental.bean.RegisterBean" class="com.campusnumerique.vehiclerental.bean.RegisterBean" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<nav class="navbar navbar-light " id="header">
	<div class="navbar-brand">
		<img
			src="${pageContext.servletContext.contextPath}/resources/images/challenger-srt-392.png" />
		<img
			src="${pageContext.servletContext.contextPath}/resources/images/SIXT.png" />
	</div>

	<ul class="nav nav-pills">
		<c:if test="${not clientBean.isGuest()}">
			<li class="nav-item"><a class="btn btn-outline-warning"
				href="./clients">Client List</a></li>
		</c:if>
		<c:if test="${clientBean.getRole() == 'agent'}">
		<li class="nav-item"><a class="btn btn-outline-warning ml-3"
			href="./reservationManage">Reservation List</a></li>
		</c:if>
		<li class="nav-item"><a class="btn btn-outline-warning ml-3"
			href="./cars">Cars List</a></li>
		<li class="nav-item"><a class="btn btn-outline-warning ml-3"
			href="./utilityCars">Utilities List</a></li>
		<li class="nav-item"><a class="btn btn-outline-warning ml-3"
			href="./motorBikes">MotorBikes List</a></li>
		<c:if test="${not clientBean.isGuest()}">
			<li class="nav-item"><a class="btn btn-outline-warning ml-3"
				href="./reservation">Reservation</a></li>
		</c:if>
	</ul>

	<div class="nav nav-pills navbar-right">
		<c:if test="${clientBean.isGuest()}">
			<button class="btn btn-primary nav-item" data-toggle="modal"
				data-target="#connectionModal">Connection</button>
			<button class="btn btn-success nav-item ml-3" data-toggle="modal"
				data-target="#registrationModal">Registration</button>
		</c:if>
		<c:if test="${not clientBean.isGuest()}">
			<button class="btn btn-info nav-item">Profil
				${clientBean.getLogin()}</button>
			<form action="/logout" method="POST">
				<button type="submit" class="btn btn-danger nav-item ml-3">Logout</button>
			</form>
		</c:if>
	</div>

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
				<c:if test="${not empty sessionScope.errorLogin}">
					<span class="text-danger text-center">${sessionScope.errorLogin}</span>
				</c:if>
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
							<input type="password" class="form-control"
								placeholder="Password" aria-label="Password"
								aria-describedby="basic-addon1" name="password">
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
				<form action="/register" method="POST">
					<div class="modal-body">
						<div class="form-row">
							<div class="form-group col-md-6">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">Firstname</div>
									</div>
									<input type="text" class="form-control" name="firstname"
										value="${registerBean.firstName}">
								</div>
								<c:if test="${ not empty errorRegister and errorRegister.has('firstname')}">
									<span class="text-danger">${errorRegister.getString('firstname')}</span>
								</c:if>
							</div>
							<div class="form-group col-md-6">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">LastName</div>
									</div>
									<input type="text" class="form-control" name="lastname"
										value="${registerBean.lastName}">
								</div>
								<c:if test="${ not empty errorRegister and errorRegister.has('lastname')}">
									<span class="text-danger">${errorRegister.getString('lastname')}</span>
								</c:if>
							</div>
							<div class="form-group col-md-12">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">Email</div>
									</div>
									<input type="email" class="form-control" name="email" value="${registerBean.mail}">
								</div>
								<c:if test="${ not empty errorRegister and errorRegister.has('email')}">
									<span class="text-danger">${errorRegister.getString('email')}</span>
								</c:if>
							</div>
							<div class="form-group col-md-12">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">BirthDate</div>
									</div>
									<fmt:formatDate value="${registerBean.birthDate}" var="birthDate" type="date" pattern="dd-MM-yyyy" />
									<input id="birthdate" type="text"
										class="form-control datepickerRegister" name="birthdate"
										value="${birthDate}">
								</div>
								<c:if
									test="${ not empty errorRegister and errorRegister.has('birthdate')}">
									<span class="text-danger">${errorRegister.getString('birthdate')}</span>
								</c:if>
							</div>
							<div class="form-group col-md-6">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">License n°</div>
									</div>
									<input type="text" class="form-control" name="licensenumber"
										value="${registerBean.licenseNumber}">
								</div>
								<c:if
									test="${ not empty errorRegister and errorRegister.has('licensenumber')}">
									<span class="text-danger">${errorRegister.getString('licensenumber')}</span>
								</c:if>
							</div>
							<div class="form-group col-md-6">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">Date</div>
									</div>
									<fmt:formatDate value="${registerBean.licenseDate}" var="licensedate" type="date" pattern="dd-MM-yyyy" />
									<input type="text" id="licensedate"
										class="form-control datepickerRegister" name="licensedate"
										value="${licensedate}">
								</div>
								<c:if
									test="${ not empty errorRegister and errorRegister.has('licensedate')}">
									<span class="text-danger">${errorRegister.getString('licensedate')}</span>
								</c:if>
							</div>
							<div class="form-group col-md-12">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">Login</div>
									</div>
									<input type="text" class="form-control" name="login"
										placeholder="Choose a login" value="${registerBean.login}">
								</div>
								<c:if
									test="${ not empty errorRegister and errorRegister.has('login')}">
									<span class="text-danger">${errorRegister.getString('login')}</span>
								</c:if>
							</div>
							<div class="form-group col-md-12">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">Password</div>
									</div>
									<input type="password" class="form-control" name="password"
										placeholder="3 characters at least" value="">
								</div>
								<c:if
									test="${ not empty errorRegister and errorRegister.has('password')}">
									<span class="text-danger">${errorRegister.getString('password')}</span>
								</c:if>
							</div>
							<div class="form-group col-md-12">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">Password Confirm</div>
									</div>
									<input type="password" class="form-control"
										name="password_confirm" placeholder="Re-type" value="">
								</div>
								<c:if
									test="${ not empty errorRegister and errorRegister.has('password_confirm')}">
									<span class="text-danger">${errorRegister.getString('password_confirm')}</span>
								</c:if>
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

	<c:if test="${not empty sessionScope.errorLogin}">

		<script type="text/javascript">
		
			$("#connectionModal").modal();
		</script>
	</c:if>

	<c:remove var="errorLogin" scope="session" />

	<c:if test="${not empty sessionScope.errorRegister}">

		<script type="text/javascript">
		
			$("#registrationModal").modal();
		</script>
	</c:if>

	<c:remove var="errorRegister" scope="session" />

</nav>