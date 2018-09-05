package com.campusnumerique.vehiclerental.registration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Client;

public final class ConnexionForm {

	private ClientBean clientBean;
	private ClientDAO clientDAO;
	private Client client;
	public ConnexionForm() {
		clientBean = new ClientBean();

	}
	
	public ClientBean connectPerson(HttpServletRequest request) throws Exception {
		
		if(request.getParameter("password") != null && request.getParameter("mail") != null ) {
			String password = request.getParameter("password");
			String mail = request.getParameter("mail");
			
			if(validateConnection(mail , password)) {
				
				try {
					client = clientDAO.findByMail(mail);
					clientBean = new ClientBean(client.getLogin());
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else {
				
				throw new Exception("mail or password not valid");
			}
			
			return clientBean;
		}



		return clientBean;
	}

	
	private boolean validateConnection(String mail , String password)  {
		
		int result = clientDAO.connection(password, mail);
		
		if(result == 1) {
			
			return true;
		}else {
			
			return false;
		}
		
	}
}
