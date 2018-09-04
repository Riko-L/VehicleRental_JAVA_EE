package com.campusnumerique.vehiclerental.bean;

import java.io.Serializable;
import java.sql.SQLException;

import com.campusnumerique.vehiclerental.dao.ClientDAO;
import com.campusnumerique.vehiclerental.entity.Client;

public class ClientBean implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int id;
	private String login;
	private String firstName;
	private String lastName;
	private String mail;
	private Client client;
	private ClientDAO clientDAO;


	public ClientBean(){
		setLogin("NoUserLogin");
	}

	public ClientBean(String aLogin){
		setLogin(aLogin);
		clientDAO = new ClientDAO();
		initialize();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	private void initialize() {
		try {
			client = clientDAO.findByLogin(getLogin());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		this.setId(client.getId());
		this.setFirstName(client.getFirstName());
		this.setLastName(client.getLastName());
		this.setMail(client.getMail());
		return;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientBean other = (ClientBean) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientBean [id=" + id + ", login=" + login + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mail=" + mail + "]";
	}
	
	

	
	
	
	
	
}
