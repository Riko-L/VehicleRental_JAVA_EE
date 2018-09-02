package com.campusnumerique.vehiclerental.servlet.validation;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Reservation;

/**
 * Servlet implementation class ValidationServlet
 */

public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDAO reservationDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidationServlet() {
		super();
		reservationDAO = new ReservationDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getServletContext().getNamedDispatcher("validation_VUE");
		response.setCharacterEncoding("UTF-8");
		Reservation reservation;
		Client client;
		Car car;
		HttpSession session = request.getSession();

		if (!session.isNew() && session != null) {
			if (session.getAttribute("reservation") != null && session.getAttribute("client") != null) {
				reservation = (Reservation) session.getAttribute("reservation");
				client = (Client) session.getAttribute("client"); 
				car = (Car) session.getAttribute("car"); 
				client.addReservations(reservation);
				car.addReservation(reservation);
				
				reservationDAO.create(reservation);
				
				session.removeAttribute("reservation");
				session.invalidate();
				request.setAttribute("reservation", reservation);
				response.setStatus(HttpServletResponse.SC_OK);
				rd.forward(request, response);
				return;
				
			}else{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				
				return;
			}

		}

	}
}
