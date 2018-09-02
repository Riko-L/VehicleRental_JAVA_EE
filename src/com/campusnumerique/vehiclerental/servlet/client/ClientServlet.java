package com.campusnumerique.vehiclerental.servlet.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Client;

/**
 * Servlet implementation class MyServlet
 */

public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClientDAO clientDAO=null;
    
    /**
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() throws ClassNotFoundException {
        super();
        clientDAO= new ClientDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Client> clients  = clientDAO.findAll();
			request.setAttribute("clients", clients);
			RequestDispatcher rd = request.getServletContext().getNamedDispatcher("clients_VUE");
			response.setStatus(HttpServletResponse.SC_OK);
			rd.forward(request, response);
			
		} catch (SQLException e) {
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
