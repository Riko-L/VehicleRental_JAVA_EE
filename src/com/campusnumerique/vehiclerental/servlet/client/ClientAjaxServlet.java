package com.campusnumerique.vehiclerental.servlet.client;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.campusnumerique.vehiclerental.dao.ClientDAO;

/**
 * Servlet implementation class ClientAjaxServlet
 */
@WebServlet("/ClientAjaxServlet")
public class ClientAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO = null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientAjaxServlet() {
        super();
        clientDAO = new ClientDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray clients = new JSONArray();
		Writer out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject results = new JSONObject();
		
		if(request.getParameter("action") != null && !request.getParameter("action").isEmpty()) {
			
			if(request.getParameter("action").equals("getClient")) {
				
				clients = clientDAO.findAllAsJson();
				results.put("results", clients);
				out.write(results.toString());
				response.setStatus(HttpServletResponse.SC_OK);
				
			
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			
		} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
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
