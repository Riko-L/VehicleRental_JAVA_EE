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
	public static final String ATT_USER         = "client";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionClient";
    public static final String VUE              = "/WEB-INF/pages/connection.jsp";
       
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
		/* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();
        
        /* Traitement de la requête et récupération du bean en résultant */
        ClientBean client = form.connectPerson(request);
        
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if (form.getErrors().isEmpty()) {
            session.setAttribute(ATT_SESSION_USER, client);
        } else {
            session.setAttribute(ATT_SESSION_USER, null);
        }
        
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, client);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
