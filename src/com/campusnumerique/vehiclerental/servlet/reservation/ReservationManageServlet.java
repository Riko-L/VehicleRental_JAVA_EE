package com.campusnumerique.vehiclerental.servlet.reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.dao.ReservationDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Reservation;

/**
 * Servlet implementation class ReservationManageServet
 */
public class ReservationManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationDAO reservationDAO = null;
	private ClientDAO clientDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationManageServlet() {
        super();
        reservationDAO = new ReservationDAO();
        clientDAO = new ClientDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		RequestDispatcher rdReservationManage = request.getServletContext().getNamedDispatcher("manageReservation_VUE");
		Reservation reservation = null;
		
			try {
				List<Reservation> reservations = reservationDAO.findAll();
				request.setAttribute("reservations", reservations);
				response.setStatus(HttpServletResponse.SC_OK);

				rdReservationManage.forward(request, response);
				return;
			} catch (SQLException | ServletException | IOException e) {
				response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if("delete".equals(request.getParameter("action"))) {
			doDelete(request, response);
		}
		
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("reservationId") != null && !request.getParameter("reservationId").isEmpty()){
			
			int id = Integer.parseInt(request.getParameter("reservationId").toString());
			
			Reservation reservation = null;
			try {
				
				reservation = reservationDAO.find(id);
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			reservationDAO.delete(reservation);
		}
	}
}
