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
	
	
	public Reservation() {}
	
	
	public Reservation(String reservationNumber, Date dateStart, Date dateEnd, int kilometerNumber, Double rentalPrice ) {
		this.reservationNumber = reservationNumber;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.kilometerNumber = kilometerNumber;
		this.rentalPrice = rentalPrice;
		
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEnd == null) ? 0 : dateEnd.hashCode());
		result = prime * result + ((dateStart == null) ? 0 : dateStart.hashCode());
		result = prime * result + id;
		result = prime * result + kilometerNumber;
		result = prime * result + ((rentalPrice == null) ? 0 : rentalPrice.hashCode());
		result = prime * result + ((reservationNumber == null) ? 0 : reservationNumber.hashCode());
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
		Reservation other = (Reservation) obj;
		if (dateEnd == null) {
			if (other.dateEnd != null)
				return false;
		} else if (!dateEnd.equals(other.dateEnd))
			return false;
		if (dateStart == null) {
			if (other.dateStart != null)
				return false;
		} else if (!dateStart.equals(other.dateStart))
			return false;
		if (id != other.id)
			return false;
		if (kilometerNumber != other.kilometerNumber)
			return false;
		if (rentalPrice == null) {
			if (other.rentalPrice != null)
				return false;
		} else if (!rentalPrice.equals(other.rentalPrice))
			return false;
		if (reservationNumber == null) {
			if (other.reservationNumber != null)
				return false;
		} else if (!reservationNumber.equals(other.reservationNumber))
			return false;
		return true;
	}

	
	public JSONObject getInfos() {
		JSONObject infos = new JSONObject();
		infos.put("id", id);
		infos.put("reservationNumber", reservationNumber);
		infos.put("dateStart", dateStart);
		infos.put("dateEnd", dateEnd);
		infos.put("kilometerNumber", kilometerNumber);
		infos.put("rentalPrice", rentalPrice);
		return infos;
	}
	

	@Override
	public String toString() {
		return getInfos().toString();
	}
	
	
	
}
