package com.campusnumerique.vehiclerental.servlet.motorbike;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.dao.MotorBikeDAO;
import com.campusnumerique.vehiclerental.entity.MotorBike;

/**
 * Servlet implementation class MotorBikeServlet
 */
public class MotorBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MotorBikeDAO motorBikeDAO = null;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotorBikeServlet() {
        super();
        motorBikeDAO = new MotorBikeDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		RequestDispatcher rd = request.getServletContext().getNamedDispatcher("motorBikes_VUE");
				try {
					List<MotorBike> motorBikes = motorBikeDAO.findAll();
					request.setAttribute("motorBikes", motorBikes);
					response.setStatus(HttpServletResponse.SC_OK);
					rd.forward(request, response) ;
				
					
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
		doGet(request, response);
	}

}
