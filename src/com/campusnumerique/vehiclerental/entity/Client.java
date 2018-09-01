package com.campusnumerique.vehiclerental.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONObject;

public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id=0;
	private String login="";
	private String firstName="";
	private String lastName="";
	private String mail="";
	private boolean isGuest=false;
	private int age;
	private Date birthDate;
	private String licenseNumber;
	private Date licenseDate;
	private List<Reservation> reservations = null;
	
	
	public Client(){
		setLogin("guest");
		setGuest(true);
	}
	
	public Client(int id, String login, String firstName, String lastName, String mail, Date birthDate, String licenseNumber, Date licenseDate){
		setId(id);
		setLogin(login);  
		setFirstName(firstName);
		setLastName(lastName);
		setMail(mail);
		setGuest(false);
		setBirthDate(birthDate);
		setLicenseNumber(licenseNumber);
		setLicenseDate(licenseDate);
		
		setAge(birthDate);
		setReservations(new ArrayList<Reservation>());
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login!=null && !login.equals(""))
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

	public boolean isGuest() {
		return isGuest;
	}
	public void setGuest(boolean isGuest) {
		this.isGuest = isGuest;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public void addReservations(Reservation reservation) {
		this.reservations.add(reservation);
	}
	public void delReservations(Reservation reservation) {
		this.reservations.remove(reservation);
	}	
	
	public int getAge() {
		return age;
	}
	public void setAge(Date birthDate) {
		Calendar current = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthDate);
		int age = current.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		
		this.age = age;
	}

	public JSONObject getInfos(){
		JSONObject infos= new JSONObject();
		infos.put("login", login);
		infos.put("id", id);
		infos.put("firstName", firstName);
		infos.put("lastName", lastName);
		infos.put("mail", mail);
		infos.put("isGuest", isGuest);
		infos.put("birthDate", birthDate);
		infos.put("age", age);
		infos.put("licenseNumber", licenseNumber);
		infos.put("licenceDate", licenseDate);
		return infos;
	}
	
	public String toString(){
		return getInfos().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + (isGuest ? 1231 : 1237);
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((licenseDate == null) ? 0 : licenseDate.hashCode());
		result = prime * result + ((licenseNumber == null) ? 0 : licenseNumber.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((reservations == null) ? 0 : reservations.hashCode());
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
		Client other = (Client) obj;
		if (age != other.age)
			return false;
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
		if (id != other.id)
			return false;
		if (isGuest != other.isGuest)
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
		if (reservations == null) {
			if (other.reservations != null)
				return false;
		} else if (!reservations.equals(other.reservations))
			return false;
		return true;
	}
	
	
}