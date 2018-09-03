package com.campusnumerique.vehiclerental.servlet.car;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Reservation;
import com.campusnumerique.vehiclerental.utils.UtilsChecker;


/**
 * Servlet implementation class CarAjaxServlet
 */

public class CarAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDAO carDAO = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarAjaxServlet() {
        super();
        carDAO = new CarDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Reservation reservation = null;
		
		if(session!=null && !session.isNew()) {
			reservation = (Reservation) session.getAttribute("reservation");
		}
		
		if(request.getParameter("action") != null && !request.getParameter("action").isEmpty() && request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
			
		if(request.getParameter("action").equals("getCarsInfos")) {
			Writer out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				Car car = carDAO.find(id);
				Double rentalPrice = UtilsChecker.CalculRentalPriceCar(reservation.getKilometerNumber(), car.getKilometerPrice(), car.getReservationPrice());
				JSONObject carJSON = new JSONObject();
				carJSON.put("car", car.getInfos());
				carJSON.put("rentalPrice", rentalPrice);
				reservation.setRentalPrice(rentalPrice);
				reservation.setCar(car);
				session.setAttribute("car", car);
				session.setAttribute("reservation", reservation);
				out.write(carJSON.toString());
				response.setStatus(HttpServletResponse.SC_OK);
				
			} catch (SQLException e) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				out.write(e.getMessage());
				e.printStackTrace();
			}

		}else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		}
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
