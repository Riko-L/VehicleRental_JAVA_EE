package com.campusnumerique.vehiclerental.servlet.selectvehicle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.dao.MotorBikeDAO;
import com.campusnumerique.vehiclerental.dao.UtilityCarDAO;
import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.entity.MotorBike;
import com.campusnumerique.vehiclerental.entity.Reservation;
import com.campusnumerique.vehiclerental.entity.UtilityCar;
import com.campusnumerique.vehiclerental.utils.Constante;
import com.campusnumerique.vehiclerental.utils.UtilsChecker;

/**
 * Servlet implementation class SelectVehicle
 */

public class SelectVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDAO carDAO = null;
	private UtilityCarDAO utilityCarDAO = null;
	private MotorBikeDAO motorBikeDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectVehicleServlet() {
		super();
		carDAO = new CarDAO();
		utilityCarDAO = new UtilityCarDAO();
		motorBikeDAO = new MotorBikeDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		RequestDispatcher rdSelectVehicle = request.getServletContext().getNamedDispatcher("selectVehicle_VUE");
		int checkAgeResult = 0;
		Reservation reservation = null;

		if (request.getAttribute("client") != null) {
			Client client = (Client) request.getAttribute("client");
			int age = client.getAge();
			checkAgeResult = UtilsChecker.checkAge(age);
		}

		if (request.getAttribute("reservation") != null) {
			reservation = (Reservation) request.getAttribute("reservation");

			if (reservation.getKind() == Constante.KIND_TOURISM_CAR) {
				try {
					List<Car> cars = carDAO.findByFilter(reservation.getDateStart(), reservation.getDateEnd(),
							checkAgeResult, reservation.getKind());
					request.setAttribute("cars", cars);
					response.setStatus(HttpServletResponse.SC_OK);

					rdSelectVehicle.forward(request, response);
					return;
				} catch (SQLException | ServletException | IOException e) {
					response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
					e.printStackTrace();
				}
			}else if (reservation.getKind() == Constante.KIND_UTILITY_CAR) {
				try {
					List<UtilityCar> utilityCars = utilityCarDAO.findByFilter(reservation.getDateStart(), reservation.getDateEnd(),
							checkAgeResult, reservation.getKind());
					request.setAttribute("utilityCars", utilityCars);
					response.setStatus(HttpServletResponse.SC_OK);

					rdSelectVehicle.forward(request, response);
					return;
				} catch (SQLException | ServletException | IOException e) {
					response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
					e.printStackTrace();
				}
				
				
				
				
			}else if(reservation.getKind() == Constante.KIND_MOTORBIKE) {
				try {
					List<MotorBike> motorBikes = motorBikeDAO.findByFilter(reservation.getDateStart(), reservation.getDateEnd(),
							 reservation.getKind());
					request.setAttribute("motorBikes", motorBikes);
					response.setStatus(HttpServletResponse.SC_OK);

					rdSelectVehicle.forward(request, response);
					return;
				} catch (SQLException | ServletException | IOException e) {
					response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
					e.printStackTrace();
				}
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
