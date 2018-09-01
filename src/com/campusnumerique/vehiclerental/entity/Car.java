package com.campusnumerique.vehiclerental.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.campusnumerique.vehiclerental.utils.Constante;

public class Car implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String brand="";
	private String model="";
	private String plateNumber="";
	private String color="";
	private int horsePower;
	private Double reservationPrice;
	private Double kilometerPrice;
	private int kind;
	private List<Reservation> reservations;
	
	
	public Car() {}
	
	public Car(int id, String brand, String model, String plateNumber, String color, int horsePower, Double reservationPrice, Double kilometerPrice){
		setId(id);
		setBrand(brand);
		setModel(model);
		setPlateNumber(plateNumber);
		setColor(color);
		setHorsePower(horsePower);
		setReservationPrice(reservationPrice);
		setKilometerPrice(kilometerPrice);
		setReservations(new ArrayList<Reservation>());
		setKind(Constante.KIND_TOURISM_CAR);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public Double getReservationPrice() {
		return reservationPrice;
	}

	public void setReservationPrice(Double reservationPrice) {
		this.reservationPrice = reservationPrice;
	}

	public Double getKilometerPrice() {
		return kilometerPrice;
	}

	public void setKilometerPrice(Double kilometerPrice) {
		this.kilometerPrice = kilometerPrice;
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void addReservation (Reservation reservation) {
		this.reservations.add(reservation);
		
	}

	public void delReservation (Reservation reservation) {
		this.reservations.remove(reservation);
		
	}
	
	
	public JSONObject getInfos() {
		JSONObject infos= new JSONObject();
			infos.put("id", id);
			infos.put("brand", brand);
			infos.put("model", model);
			infos.put("color", color);
			infos.put("plateNumber", plateNumber);
			infos.put("horsePower", horsePower);
			infos.put("reservationPrice", reservationPrice);
			infos.put("kilometerPrice", kilometerPrice);
			infos.put("kind", kind);
		return infos;
		
	}
	
	
	
	public String toString(){
		return getInfos().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + horsePower;
		result = prime * result + id;
		result = prime * result + ((kilometerPrice == null) ? 0 : kilometerPrice.hashCode());
		result = prime * result + kind;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((plateNumber == null) ? 0 : plateNumber.hashCode());
		result = prime * result + ((reservationPrice == null) ? 0 : reservationPrice.hashCode());
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
		Car other = (Car) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (horsePower != other.horsePower)
			return false;
		if (id != other.id)
			return false;
		if (kilometerPrice == null) {
			if (other.kilometerPrice != null)
				return false;
		} else if (!kilometerPrice.equals(other.kilometerPrice))
			return false;
		if (kind != other.kind)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (plateNumber == null) {
			if (other.plateNumber != null)
				return false;
		} else if (!plateNumber.equals(other.plateNumber))
			return false;
		if (reservationPrice == null) {
			if (other.reservationPrice != null)
				return false;
		} else if (!reservationPrice.equals(other.reservationPrice))
			return false;
		if (reservations == null) {
			if (other.reservations != null)
				return false;
		} else if (!reservations.equals(other.reservations))
			return false;
		return true;
	}
	
	
}