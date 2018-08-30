package com.campusnumerique.vehiclerental.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;

public class Client {

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
		this.reservations.add(rerservation);
	}
	public void delReservations(Reservation reservation) {
		this.reservations.remove(rerservation);
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
}