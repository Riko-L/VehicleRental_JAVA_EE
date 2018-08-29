package com.campusnumerique.vehiclerental.entity;

import java.io.Serializable;

import org.json.JSONObject;

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
		return infos;
		
	}
	
	
	
	public String toString(){
		return getInfos().toString();
	}
	
	
}