package com.campusnumerique.vehiclerental.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.registration.ConnexionForm;

/**
 * Servlet implementation class Connection
 */
public class Connection extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Connection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String test = request.getServletContext().getContextPath();
		
        ConnexionForm form = new ConnexionForm();
        
    
        ClientBean clientBean = null;
		try {
			clientBean = form.connectPerson(request);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
        
      
        HttpSession session = request.getSession();
        
        
        if (form.getErrors().isEmpty()) {
            session.setAttribute("clientBean", clientBean);
        } else {
            session.setAttribute("clientBean", null);
        }
        
   
    }
}
