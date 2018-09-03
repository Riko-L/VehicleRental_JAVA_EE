package com.campusnumerique.vehiclerental.servlet.utilitycar;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import com.campusnumerique.vehiclerental.dao.UtilityCarDAO;
import com.campusnumerique.vehiclerental.entity.Reservation;
import com.campusnumerique.vehiclerental.entity.UtilityCar;
import com.campusnumerique.vehiclerental.utils.UtilsChecker;

/**
 * Servlet implementation class UtilityCarAjaxServlet
 */

public class UtilityCarAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtilityCarDAO utilityCarDAO = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilityCarAjaxServlet() {
        super();
        utilityCarDAO =new UtilityCarDAO();
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
			
		if(request.getParameter("action").equals("getUtilityCarsInfos")) {
			Writer out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			
			try {
				UtilityCar utilityCar = utilityCarDAO.find(id);
				Double rentalPrice = UtilsChecker.CalculRentalPriceUtilityCar(reservation.getKilometerNumber(), utilityCar.getKilometerPrice(), utilityCar.getReservationPrice(),utilityCar.getVolume());
				JSONObject utilityCarJSON = new JSONObject();
				utilityCarJSON.put("utilityCar", utilityCar.getInfos());
				utilityCarJSON.put("rentalPrice", rentalPrice);
				reservation.setRentalPrice(rentalPrice);
				reservation.setUtilityCar(utilityCar);
				session.setAttribute("utilityCar", utilityCar);
				session.setAttribute("reservation", reservation);
				out.write(utilityCarJSON.toString());
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
		
		doGet(request, response);
	}

}
