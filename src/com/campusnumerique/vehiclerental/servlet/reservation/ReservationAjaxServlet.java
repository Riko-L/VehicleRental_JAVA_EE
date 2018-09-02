package com.campusnumerique.vehiclerental.servlet.reservation;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.campusnumerique.vehiclerental.dao.DAO;
import com.campusnumerique.vehiclerental.dao.KindDAO;
import com.campusnumerique.vehiclerental.entity.Kind;


/**
 * Servlet implementation class ReservationAjaxServlet
 */
@WebServlet("/ReservationAjaxServlet")
public class ReservationAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private KindDAO kindDAO = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationAjaxServlet() {
        super();
        kindDAO = new KindDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray kinds = new JSONArray();
		Writer out = response.getWriter();
		response.setContentType("application/json");
		JSONObject results = new JSONObject();
		if(request.getParameter("action") != null && !request.getParameter("action").isEmpty()) {
			
			if(request.getParameter("action").equals("getKind")) {
				
				try {
					kinds = kindDAO.findAllAsJson();
					results.put("results", kinds);
					out.write(results.toString());
					response.setStatus(HttpServletResponse.SC_OK);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				
			}else {
				
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			
			
			}else {
				
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
