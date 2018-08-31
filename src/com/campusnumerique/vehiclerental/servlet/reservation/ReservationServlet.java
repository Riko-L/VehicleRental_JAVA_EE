package com.campusnumerique.vehiclerental.servlet.reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.Reservation;

/**
 * Servlet implementation class Reservation
 */

public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationServlet() {
		super();
		clientDAO = new ClientDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Pour les tests
		HttpSession session = request.getSession();
		session.setAttribute("client", new ClientBean("Alex"));
		
		
		RequestDispatcher rd = request.getServletContext().getNamedDispatcher("reservation");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Reservation reservation = new Reservation();
		Client client = new Client();
		RequestDispatcher rdSelectVehicle = request.getServletContext().getNamedDispatcher("SelectVehicle");
		RequestDispatcher rdReservation = request.getServletContext().getNamedDispatcher("reservation");
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		Date dateStart;
		Date dateEnd;
		int kilometerNumber;
		int dayNumber;
		String reservationNumber = UUID.randomUUID().toString();
		
		reservation.setReservationNumber(reservationNumber);
		
		
		if(session.getAttribute("client") != null ) {
			ClientBean clientBean = (ClientBean) session.getAttribute("client");
			if(!clientBean.getLogin().equals("NoUserLogin") ) {
			try {
				client = clientDAO.findByLogin(clientBean.getLogin());
				reservation.setClient(client);
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
		}
		}
		
		
		if (request.getParameter("dateStart") != null && !request.getParameter("dateStart").isEmpty()) {
			try {
				dateStart = formater.parse(request.getParameter("dateStart"));
				session.setAttribute("dateStart",dateStart);
				reservation.setDateStart(dateStart);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("error", "Date is empty");
			rdReservation.forward(request, response);
			return;
		}

		if (request.getParameter("dateEnd") != null && !request.getParameter("dateEnd").isEmpty()) {
			try {
				dateEnd = formater.parse(request.getParameter("dateEnd"));
				session.setAttribute("dateEnd",dateEnd);
				reservation.setDateEnd(dateEnd);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("error", "Date is empty");
			rdReservation.forward(request, response);
			return;
		}

		if (request.getParameter("kilometerNumber") != null && !request.getParameter("kilometerNumber").isEmpty()) {

			kilometerNumber = Integer.parseInt(request.getParameter("kilometerNumber"));
			session.setAttribute("kilometerNumber",kilometerNumber);
			reservation.setKilometerNumber(kilometerNumber);

		} else {
			request.setAttribute("error", "Kilometer Number is empty");
			rdReservation.forward(request, response);
			return;
		}

		if (request.getParameter("dayNumber") != null && !request.getParameter("dayNumber").isEmpty()) {

			dayNumber = Integer.parseInt(request.getParameter("dayNumber"));
			session.setAttribute("dayNumber",dayNumber);
			reservation.setDayNumber(dayNumber);

		} else {
			request.setAttribute("error", "Day Number is not ...");
			rdReservation.forward(request, response);
			return;
		}

		request.setAttribute("client", client);
		request.setAttribute("reservation", reservation);
		
		rdSelectVehicle.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
