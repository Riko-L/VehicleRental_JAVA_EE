package com.campusnumerique.vehiclerental.servlet.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.registration.ConnexionForm;


/**
 * Servlet implementation class Connection
 */
public class ConnectionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ClientBean clientBean;
	private String requestURL;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClientBean clientBeanOK = null;
		ConnexionForm form = new ConnexionForm();
		HttpSession session = request.getSession();
		clientBean = (ClientBean)session.getAttribute("clientBean");
		
		
		if (clientBean.isGuest()) {
			
			clientBeanOK = form.connectPerson(request);

			if (form.getErrors().isEmpty()) {
				session.setAttribute("clientBean", clientBeanOK);
				response.setStatus(HttpServletResponse.SC_OK);
				response.sendRedirect("/home");
				return;
			} else {
				session.setAttribute("clientBean", clientBean);
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				session.setAttribute("errorLogin", "Password or mail invalide");
				try {
					requestURL = new URI(request.getHeader("referer")).getPath();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}

				response.sendRedirect(requestURL);
				
				
				
			}

		} else {
			clientBean = (ClientBean) session.getAttribute("clientBean");
			response.setStatus(HttpServletResponse.SC_OK);
			response.sendRedirect("/home");
		}

	}
}
