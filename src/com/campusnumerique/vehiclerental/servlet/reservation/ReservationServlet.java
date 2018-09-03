package com.campusnumerique.vehiclerental.servlet.reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		session.setAttribute("clientBean", new ClientBean("Alex"));
		
		
		RequestDispatcher rd = request.getServletContext().getNamedDispatcher("reservation_VUE");

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
		RequestDispatcher rdSelectVehicle = request.getServletContext().getNamedDispatcher("SelectVehicleServlet");
		RequestDispatcher rdReservation = request.getServletContext().getNamedDispatcher("reservation_VUE");
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		Date dateStart;
		Date dateEnd;
		int kilometerNumber;
		int dayNumber;
		int kind;
		StringBuilder reservationNumber = new StringBuilder("RESA_");
		reservationNumber.append(Calendar.getInstance().getTimeInMillis());
		reservation.setReservationNumber(reservationNumber.toString());
		
		
		if(session.getAttribute("clientBean") != null ) {
			ClientBean clientBean = (ClientBean) session.getAttribute("clientBean");
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
				reservation.setDateStart(dateStart);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			session.setAttribute("reservation", reservation);
			request.setAttribute("error", "Date 'From' is required");
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
			session.setAttribute("reservation", reservation);
			request.setAttribute("error", "Date 'to' is required");
			rdReservation.forward(request, response);
			return;
		}

		if (request.getParameter("dayNumber") != null && !request.getParameter("dayNumber").isEmpty()) {

			dayNumber = Integer.parseInt(request.getParameter("dayNumber"));
			reservation.setDayNumber(dayNumber);

		} else {
			session.setAttribute("reservation", reservation);
			request.setAttribute("error", "Day Number is required");
			rdReservation.forward(request, response);
			return;
		}
		
		if (request.getParameter("kilometerNumber") != null && !request.getParameter("kilometerNumber").isEmpty()) {

			String kilometer = request.getParameter("kilometerNumber");
					
					if(kilometer.matches("^[0-9]*$")) {
						kilometerNumber = Integer.parseInt(kilometer);
						if(kilometerNumber != 0 ) {
							reservation.setKilometerNumber(kilometerNumber);
							
						}else {
							session.setAttribute("reservation", reservation);
							request.setAttribute("error", "Kilometer must be greater than 0 ");
							rdReservation.forward(request, response);
							return;
						}
					}else {
						session.setAttribute("reservation", reservation);
						request.setAttribute("error", "Kilometer must be only a digit number");
						rdReservation.forward(request, response);
						return;
					}
			
			

		} else {
			session.setAttribute("reservation", reservation);
			request.setAttribute("error", "Kilometer is required");
			rdReservation.forward(request, response);
			return;
		}

		

		if (request.getParameter("kind") != null && !request.getParameter("kind").isEmpty() && !request.getParameter("kind").equals("0")) {

			kind = Integer.parseInt(request.getParameter("kind"));
			reservation.setKind(kind);

		} else {
			session.setAttribute("reservation", reservation);
			request.setAttribute("error", "Kind is required");
			rdReservation.forward(request, response);
			return;
		}
		https://
		session.setAttribute("reservation", reservation);
		session.setAttribute("client", client);
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
