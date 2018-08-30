package com.campusnumerique.vehiclerental.servlet.reservation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Reservation;

/**
 * Servlet implementation class Reservation
 */

public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDAO reservationDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationServlet() {
		super();
		reservationDAO = new ReservationDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getServletContext().getNamedDispatcher("reservation");

		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Reservation reservation = new Reservation();
		RequestDispatcher rdSelectVehicle = request.getServletContext().getNamedDispatcher("selectVehicle");
		RequestDispatcher rdReservation = request.getServletContext().getNamedDispatcher("reservation");
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
		Date dateStart;
		Date dateEnd;
		int kilometerNumber;
		int dayNumber;

		if (request.getParameter("dateStart") != null && !request.getParameter("dateStart").isEmpty()) {
			try {
				dateStart = formater.parse(request.getParameter("dateStart"));
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
				reservation.setDateEnd(dateEnd);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("error", "Date is empty");
			rdReservation.forward(request, response);
			return;
		}
		
		if (request.getParameter("KilometerNumber") != null && !request.getParameter("KilometerNumber").isEmpty()) {
		
			kilometerNumber = Integer.parseInt(request.getParameter("KilometerNumber").trim());
			reservation.setKilometerNumber(kilometerNumber);
			
		} else {
			request.setAttribute("error", "Kilometer Number is empty");
			rdReservation.forward(request, response);
			return;
		}
		
		
		if (request.getParameter("dayNumber") != null && !request.getParameter("dayNumber").isEmpty()) {
			
			dayNumber = Integer.parseInt(request.getParameter("dayNumber"));
			reservation.setDayNumber(dayNumber);
			
		} else {
			request.setAttribute("error", "Day Number is not ...");
			rdReservation.forward(request, response);
			return;
		}
		
		
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
