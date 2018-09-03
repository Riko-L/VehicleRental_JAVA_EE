package com.campusnumerique.vehiclerental.entity;

import java.io.Serializable;

import org.json.JSONObject;

import com.campusnumerique.vehiclerental.utils.Constante;

public class UtilityCar extends Car implements Serializable {

	private static final long serialVersionUID = 1L;
	private int volume;

	public UtilityCar() {

	}

	public UtilityCar(int id, String brand, String model, String plateNumber, String color, int horsePower,
			Double reservationPrice, Double kilometerPrice, int volume) {
		super(id, brand, model, plateNumber, color, horsePower, reservationPrice, kilometerPrice);
		setKind(Constante.KIND_UTILITY_CAR);
		setVolume(volume);
		
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + volume;
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
		UtilityCar other = (UtilityCar) obj;
		if (volume != other.volume)
			return false;
		return true;
	}

	public JSONObject getInfos() {
		JSONObject infos= new JSONObject();
			infos.put("id", getId());
			infos.put("brand", getBrand());
			infos.put("model", getModel());
			infos.put("color", getColor());
			infos.put("volume", getVolume());
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
