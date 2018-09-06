package com.campusnumerique.vehiclerental.registration;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.SQLException;
import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.utils.HashPassword;

public final class ConnexionForm {

	private ClientBean clientBean;
	private ClientDAO clientDAO;
	private Client client;
	private HashMap<String, String> errors;
	public ConnexionForm() {
		clientBean = new ClientBean();
		errors = new HashMap<>();
		clientDAO = new ClientDAO();

	}
	
	public ClientBean connectPerson(HttpServletRequest request){
		
		
		if(request.getParameter("password") != null && request.getParameter("mail") != null ) {
			String password = request.getParameter("password").toString().trim();
			String mail = request.getParameter("mail").toString().trim();
			
			try {
				password = HashPassword.securePassword(password);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			} catch (NoSuchProviderException e1) {
		
				e1.printStackTrace();
			}
			
			if(validateConnection(mail , password)) {
				
				try {
					client = clientDAO.findByMail(mail);
					clientBean = new ClientBean(client.getLogin());
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else {
				
				setErrors("error", "mail or password is invalid");
			}
			
			return clientBean;
		}



		return clientBean;
	}

	public HashMap<String, String> getErrors(){
		
		return this.errors;
	}
	
	public void setErrors(String champ, String message){
		
		this.errors.put(champ, message);
		
	}
	
	
	private boolean validateConnection(String mail , String password)  {
		boolean rs = false;
		
		int result = clientDAO.connection(password, mail);
		
		if(result == 1) {
			rs = true;
		}
			
		return rs;
	}
}
