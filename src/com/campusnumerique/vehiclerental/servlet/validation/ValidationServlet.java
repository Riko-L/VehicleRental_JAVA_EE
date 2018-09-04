package com.campusnumerique.vehiclerental.servlet.validation;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.MotorBike;
import com.campusnumerique.vehiclerental.entity.Reservation;
import com.campusnumerique.vehiclerental.entity.UtilityCar;

/**
 * Servlet implementation class ValidationServlet
 */

public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDAO reservationDAO = null;
	private ClientDAO clientDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidationServlet() {
		super();
		reservationDAO = new ReservationDAO();
		clientDAO = new ClientDAO();
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
		response.setContentType("text/html");
		Reservation reservation;
		Client client = null;
		ClientBean clientBean;
		Car car;
		UtilityCar utilityCar;
		MotorBike motorBike;
		
		HttpSession session = request.getSession();

		if (!session.isNew() && session != null) {
			if (session.getAttribute("reservation") != null && session.getAttribute("clientBean") != null) {
				reservation = (Reservation) session.getAttribute("reservation");
				clientBean = (ClientBean) session.getAttribute("clientBean");
				
				try {
					client = clientDAO.findByLogin(clientBean.getLogin());
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				
				if(request.getAttribute("car") != null) {
					car = (Car) request.getAttribute("car");
					reservation.setCar(car);
					client.addReservations(reservation);
					car.addReservation(reservation);
				}else if(request.getAttribute("utilityCar") != null) {
					utilityCar = (UtilityCar) request.getAttribute("utilityCar"); 
					reservation.setUtilityCar(utilityCar);
					client.addReservations(reservation);
					utilityCar.addReservation(reservation);
				}else if(request.getAttribute("motorBike") != null) {
					motorBike = (MotorBike) request.getAttribute("motorBike"); 
					reservation.setMotorBike(motorBike);
					client.addReservations(reservation);
					motorBike.addReservation(reservation);
					
				}
				reservation.setClient(client);
				
				boolean recordOk = reservationDAO.create(reservation);
				
				request.getSession().removeAttribute("reservation");
				session.removeAttribute("reservation");
				request.setAttribute("recordOk", recordOk);
				request.setAttribute("reservation", reservation);
				response.setStatus(HttpServletResponse.SC_OK);
				rd.forward(request, response);
				return;
				
			}else{
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				
				return;
			}

		}else {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			return;
		}

	}
}
