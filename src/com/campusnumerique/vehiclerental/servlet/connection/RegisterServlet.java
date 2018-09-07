package com.campusnumerique.vehiclerental.servlet.connection;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.registration.RegisterForm;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientBean clientBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
       
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
		HttpSession session = request.getSession();
		String requestURL = null;
		RegisterForm registerForm = new RegisterForm();
		
		
		try {
			clientBean = registerForm.registerClient(request);
			
			if(registerForm.getErrors().isEmpty()) {
				session.setAttribute("clientBean", clientBean);
				response.setStatus(HttpServletResponse.SC_OK);
				response.sendRedirect("./home");
				
			}else {
				session.setAttribute("clientBean", clientBean);
				session.setAttribute("registerBean", registerForm.getRegisterBean());
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				session.setAttribute("errorRegister", registerForm.getErrors());
				
				try {
					requestURL = new URI(request.getHeader("referer")).getPath();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}

				response.sendRedirect(requestURL);
				
				
			}
			
			
			
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
