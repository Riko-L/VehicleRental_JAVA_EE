package com.campusnumerique.vehiclerental.servlet.utilitycar;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusnumerique.vehiclerental.dao.UtilityCarDAO;
import com.campusnumerique.vehiclerental.entity.UtilityCar;

/**
 * Servlet implementation class UtilityCarServlet
 */
public class UtilityCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilityCarDAO utilityCarDAO = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilityCarServlet() {
        super();
        utilityCarDAO = new UtilityCarDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		RequestDispatcher rd = request.getServletContext().getNamedDispatcher("utilityCars_VUE");
				try {
					List<UtilityCar> utilityCars = utilityCarDAO.findAll();
					System.out.println(utilityCars);
					request.setAttribute("utilityCars", utilityCars);
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
