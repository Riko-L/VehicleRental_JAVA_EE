<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="clientBean" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />

<nav class="navbar navbar-light " id="header">
	<a class="navbar-brand" href="#"> <img
		src="${pageContext.servletContext.contextPath}/resources/images/delorean.png" />

	</a>
	<ul class="nav nav-pills">
		<li class="nav-item"><a class="nav-link" href="./clients">Client List</a></li>
		<li class="nav-item"><a class="nav-link" href="./cars">Cars List</a></li>
		<li class="nav-item"><a class="nav-link" href="./utilityCars">Utilities List</a></li>
		<li class="nav-item"><a class="nav-link" href="./motorBikes">MotorBikes List</a></li>
		<li class="nav-item"><a class="nav-link" href="./reservation">Reservation</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li>User Connected: <%=clientBean.getLogin()%></li>
	</ul>
</nav>