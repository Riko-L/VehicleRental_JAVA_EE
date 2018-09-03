package com.campusnumerique.vehiclerental.entity;

import org.json.JSONObject;

import com.campusnumerique.vehiclerental.utils.Constante;

public class MotorBike extends Car {

	private static final long serialVersionUID = 1L;
	private int capacity;

	public MotorBike() {
	}

	public MotorBike(int id, String brand, String model, String plateNumber, String color, int horsePower, Double reservationPrice, Double kilometerPrice , int capacity) {
		super(id, brand, model, plateNumber, color, horsePower, reservationPrice, kilometerPrice);
		setKind(Constante.KIND_MOTORBIKE);
		setCapacity(capacity);
		
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + capacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MotorBike other = (MotorBike) obj;
		if (capacity != other.capacity)
			return false;
		return true;
	}

	public JSONObject getInfos() {
		JSONObject infos= new JSONObject();
			infos.put("id", getId());
			infos.put("brand", getBrand());
			infos.put("model", getModel());
			infos.put("color", getColor());
			infos.put("capacity", getCapacity());
			infos.put("plateNumber", getPlateNumber());
			infos.put("horsePower", getHorsePower());
			infos.put("reservationPrice", getReservationPrice());
			infos.put("kilometerPrice", getKilometerPrice());
			infos.put("kind", getKind());
		return infos;
		
	}
	
	public String toString(){
		return getInfos().toString();
	}
	
}
