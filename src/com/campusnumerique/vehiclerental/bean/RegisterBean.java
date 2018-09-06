package com.campusnumerique.vehiclerental.bean;

import java.io.Serializable;
import java.util.Date;

public class RegisterBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String login;
	private String firstName;
	private String lastName;
	private String mail;
	private Date birthDate;
	private String licenseNumber;
	private Date licenseDate;
	
	
	
	public RegisterBean() {
		
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
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



	public Date getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}



	public String getLicenseNumber() {
		return licenseNumber;
	}



	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}



	public Date getLicenseDate() {
		return licenseDate;
	}



	public void setLicenseDate(Date licenseDate) {
		this.licenseDate = licenseDate;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((licenseDate == null) ? 0 : licenseDate.hashCode());
		result = prime * result + ((licenseNumber == null) ? 0 : licenseNumber.hashCode());
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
		RegisterBean other = (RegisterBean) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (licenseDate == null) {
			if (other.licenseDate != null)
				return false;
		} else if (!licenseDate.equals(other.licenseDate))
			return false;
		if (licenseNumber == null) {
			if (other.licenseNumber != null)
				return false;
		} else if (!licenseNumber.equals(other.licenseNumber))
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
		return "RegisterBean [login=" + login + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail
				+ ", birthDate=" + birthDate + ", licenseNumber=" + licenseNumber + ", licenseDate=" + licenseDate
				+ "]";
	}
	
	
}
