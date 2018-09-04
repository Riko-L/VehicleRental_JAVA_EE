package com.campusnumerique.vehiclerental.servlet.motorbike;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.campusnumerique.vehiclerental.dao.MotorBikeDAO;
import com.campusnumerique.vehiclerental.entity.MotorBike;
import com.campusnumerique.vehiclerental.entity.Reservation;
import com.campusnumerique.vehiclerental.utils.UtilsChecker;

/**
 * Servlet implementation class MotorBikeAjaxServlet
 */
@WebServlet("/MotorBikeAjaxServlet")
public class MotorBikeAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MotorBikeDAO motorBikeDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotorBikeAjaxServlet() {
        super();
        motorBikeDAO = new MotorBikeDAO(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Reservation reservation = null;

		if (session != null && !session.isNew()) {
			reservation = (Reservation) session.getAttribute("reservation");
		}

		if (request.getParameter("action") != null && !request.getParameter("action").isEmpty()
				&& request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {

			if (request.getParameter("action").equals("getMotorBikesInfos")) {
				Writer out = response.getWriter();
				int id = Integer.parseInt(request.getParameter("id"));

				try {
					MotorBike motorBike = motorBikeDAO.find(id);
					Double rentalPrice = UtilsChecker.CalculRentalPriceMotorBike(reservation.getKilometerNumber(),
							motorBike.getKilometerPrice(), motorBike.getReservationPrice(), motorBike.getCapacity());
					JSONObject motorBikeJSON = new JSONObject();
					motorBikeJSON.put("motorBike", motorBike.getInfos());
					motorBikeJSON.put("rentalPrice", rentalPrice);
					reservation.setRentalPrice(rentalPrice);
					reservation.setMotorBike(motorBike);
					session.setAttribute("motorBike", motorBike);
					session.setAttribute("reservation", reservation);
					out.write(motorBikeJSON.toString());
					response.setStatus(HttpServletResponse.SC_OK);

				} catch (SQLException e) {
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					out.write(e.getMessage());
					e.printStackTrace();
				}

			} else {
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
