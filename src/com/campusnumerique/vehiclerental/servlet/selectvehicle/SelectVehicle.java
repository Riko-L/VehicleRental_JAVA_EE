package com.campusnumerique.vehiclerental.servlet.selectvehicle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusnumerique.vehiclerental.dao.CarDAO;
import com.campusnumerique.vehiclerental.entity.Car;

/**
 * Servlet implementation class SelectVehicle
 */

public class SelectVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDAO carDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectVehicle() {
        super();
        carDAO=new CarDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rdSelectVehicle = request.getServletContext().getNamedDispatcher("selectVehicle");
		try {
			List<Car> cars = carDAO.findAll();
			request.setAttribute("cars", cars);
			response.setStatus(HttpServletResponse.SC_OK);
			
			rdSelectVehicle.forward(request, response);
			
		} catch (SQLException | ServletException | IOException e) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			e.printStackTrace();
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
		
	}

}
