package com.campusnumerique.vehiclerental.registration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;


import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.campusnumerique.vehiclerental.bean.ClientBean;
import com.campusnumerique.vehiclerental.bean.RegisterBean;
import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.exception.DuplicateMailException;

public class RegisterForm {

	private RegisterBean registerBean;
	private ClientBean clientBean;
	private Client client;
	private ClientDAO clientDAO;
	private JSONObject errors;

	public RegisterForm() {
		clientDAO = new ClientDAO();
		errors = new JSONObject();
		client = new Client();
	}

	public ClientBean registerClient(HttpServletRequest request) throws ParseException {
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
		String password = null;
		registerBean = new RegisterBean();
		
		if (request.getParameterNames() != null) {
			Enumeration<String> parameters = request.getParameterNames();

			while (parameters.hasMoreElements()) {

				String param = parameters.nextElement();

				if (param.equals("firstname") && !param.isEmpty() && param != null) {
					if(!request.getParameter(param.toString()).isEmpty() && request.getParameter(param.toString()) != null) {
					String firstName = request.getParameter(param.toString()).trim();
					if (firstName.matches("^[a-zA-Z ]+$")) {
						client.setFirstName(firstName);
						registerBean.setFirstName(firstName);
					} else {
						setErrors("firstname", "Only letter accepted and space");
					}

				} else {
					setErrors("firstname", "Firstname is required ");
				}
				}
				
				if (param.equals("lastname") && !param.isEmpty() && param != null) {
					if(!request.getParameter(param.toString()).isEmpty() && request.getParameter(param.toString()) != null) {
					String lastName = request.getParameter(param.toString()).trim();
					if (lastName.matches("^[a-zA-Z ]+$")) {
						client.setLastName(lastName);
						registerBean.setLastName(lastName);
					} else {
						setErrors("lastname", "Only letter accepted and space");
					}

				} else {
					setErrors("lastname", "Lastname is required ");
				}
				}

				if (param.equals("email") && !param.isEmpty() && param != null) {
					if(!request.getParameter(param.toString()).isEmpty() && request.getParameter(param.toString()) != null) {
					String Email = request.getParameter(param.toString()).trim();
					if (Email.matches(
							"[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-\\=?^_`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,6}")) {
						client.setMail(Email);
						registerBean.setMail(Email);
						
					} else {
						setErrors("email", "Email not valid");
					}
				} else {
					setErrors("email", "Email is required ");

				}
				}

				if (param.equals("birthdate") && !param.isEmpty() && param != null) {
					if(!request.getParameter(param.toString()).isEmpty() && request.getParameter(param.toString()) != null) {
					Date birthDate = formater.parse(request.getParameter(param.toString()));

					client.setBirthDate(birthDate);

					if (client.getAge() > 18) {
						client.setBirthDate(birthDate);
						registerBean.setBirthDate(birthDate);
						
					} else {
						setErrors("birthdate", "You must have 18 years old");

					}

				} else {
					setErrors("birthdate", "Birthdate is required ");
				}
				}
				
				if (param.equals("licensenumber") && !param.isEmpty() && param != null) {
					if(!request.getParameter(param.toString()).isEmpty() && request.getParameter(param.toString()) != null) {
					String licenseNumber = request.getParameter(param.toString()).trim();

					if (licenseNumber.matches("^[a-zA-Z_0-9]+$")) {
						client.setLicenseNumber(licenseNumber);
						registerBean.setLicenseNumber(licenseNumber);
						
					} else {
						setErrors("licensenumber", "License Number is not correct");

					}

				} else {
					setErrors("licensenumber", "License Number is required ");
				}
				}
				
				if (param.equals("licensedate") && !param.isEmpty() && param != null) {
					if(!request.getParameter(param.toString()).isEmpty() && request.getParameter(param.toString()) != null) {
					Date licenseDate = formater.parse(request.getParameter(param.toString()));

					client.setLicenseDate(licenseDate);
					registerBean.setLicenseDate(licenseDate);
				} else {
					setErrors("licensedate", "License Date is required ");
				}
				}
				
				
				if (param.equals("login") && !param.isEmpty() && param != null) {
					if(!request.getParameter(param.toString()).isEmpty() && request.getParameter(param.toString()) != null) {
					String login = request.getParameter(param.toString()).trim();
					if (login.matches("^[a-zA-Z ]+$")) {
						client.setLogin(login);
						registerBean.setLogin(login);
					} else {
						setErrors("login", "Only letter accepted and space");
					}

				} else {
					setErrors("login", "Login is required ");
				}
				}
				
				if (param.equals("password") && !param.isEmpty() && param != null) {
					if(!request.getParameter(param.toString()).isEmpty() && request.getParameter(param.toString()) != null) {
					password = request.getParameter(param.toString()).trim();
					if (password.length() > 3 && password.length() < 25) {

						password = request.getParameter(param.toString()).trim();

					} else {
						setErrors("password", "Password length must be in 3 to 25 caracters");
					}

				} else {
					setErrors("password", "Password is required ");
				}
				}
				
				if (param.equals("password_confirm") && !param.isEmpty() && param != null) {
					if(!request.getParameter(param.toString()).isEmpty() && request.getParameter(param.toString()) != null) {
					String password_confirm = request.getParameter(param.toString()).trim();
					if (password_confirm.length() > 3 && password_confirm.length() < 25) {

						if (password_confirm.equals(password)) {

							client.setPassword(password);

						} else {
							setErrors("password_confirm", "Password don't match");
						}

					} else {
						setErrors("password_confirm", "Password length must be in 3 to 25 caracters");
					}

				} else {
					setErrors("password_confirm", "Password confirm is required ");
				}
				}
			}

		}

		if (getErrors().isEmpty()) {

			boolean result = false;
			try {
				result = clientDAO.create(client);
			} catch (DuplicateMailException e) {
				setErrors("email", "Email is already exist");
				e.printStackTrace();
			}

			if(result) {
				clientBean = new ClientBean(client.getLogin());
			}

		} 

		return clientBean;

	}

	public JSONObject getErrors() {

		return this.errors;
	}

	public void setErrors(String champ, String message) {

		this.errors.put(champ, message);

	}

	public RegisterBean getRegisterBean() {
		return registerBean;
	}

	public void setRegisterBean(RegisterBean registerBean) {
		this.registerBean = registerBean;
	}
	

}
