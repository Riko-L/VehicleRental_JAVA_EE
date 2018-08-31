package com.campusnumerique.vehiclerental.entity;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;

public class Reservation implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int id;
	private String reservationNumber;
	private Date dateStart;
	private Date dateEnd;
	private int kilometerNumber;
	private Double rentalPrice;
	private int dayNumber;
	private String kind;
	private Car car;
	private Client client;
	
	
	public Reservation() {}
	
	
	public Reservation(String reservationNumber, Date dateStart, Date dateEnd, int kilometerNumber, Double rentalPrice , String kind) {
		this.reservationNumber = reservationNumber;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.kilometerNumber = kilometerNumber;
		this.rentalPrice = rentalPrice;
		this.kind = kind;
		
	}


	public String getReservationNumber() {
		return reservationNumber;
	}


	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}


	public Date getDateStart() {
		return dateStart;
	}


	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}


	public Date getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}


	public int getKilometerNumber() {
		return kilometerNumber;
	}


	public void setKilometerNumber(int kilometerNumber) {
		this.kilometerNumber = kilometerNumber;
	}


	public Double getRentalPrice() {
		return rentalPrice;
	}


	public void setRentalPrice(Double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}


	public int getId() {
		return id;
	}


	public int getDayNumber() {
		return dayNumber;
	}


	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}

	
	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public JSONObject getInfos() {
		JSONObject infos = new JSONObject();
		infos.put("id", id);
		infos.put("reservationNumber", reservationNumber);
		infos.put("dateStart", dateStart);
		infos.put("dateEnd", dateEnd);
		infos.put("kilometerNumber", kilometerNumber);
		infos.put("rentalPrice", rentalPrice);
		infos.put("dayNumber", dayNumber);
		infos.put("car", car);
		infos.put("kind", kind);
		infos.put("client", client);
		return infos; 
	}
	

	@Override
	public String toString() {
		return getInfos().toString();
	}
	
	
	
}
