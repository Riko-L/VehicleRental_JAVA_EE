package com.campusnumerique.vehiclerental.utils;

import java.util.Date;
import java.util.List;

import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Reservation;

public class UtilsChecker {

	public static  int checkAge(int age) {
		
		int horsePower;
		if (age < 18) {
			horsePower = Constante.AGE_MOINS_DE_18;
		} else if (age >= 18 && age < 21) {
			horsePower = Constante.AGE_MOINS_DE_21;
		} else if (age >= 21 && age < 25) {
			horsePower = Constante.AGE_ENTRE_21_ET_25;
		} else {
			horsePower = Constante.AGE_PLUS_25;
		}
		return horsePower;
	}

	/**
	 * Calcul for car
	 * @param kilometerNumber
	 * @param kilometerPrice
	 * @param reservationPrice
	 * @return
	 */
	public static Double CalculRentalPriceCar(int kilometerNumber, Double kilometerPrice, Double reservationPrice) {
		
		return kilometerNumber*kilometerPrice + reservationPrice;
	}
	
	/**
	 * Calcul for MotorBike
	 * @param kilometerNumber
	 * @param kilometerPrice
	 * @param reservationPrice
	 * @param volume
	 * @return
	 */
	public static Double CalculRentalPriceMotorBike(int kilometerNumber, Double kilometerPrice, Double reservationPrice, int capacity ) {
		
	
		
		return (double) Math.round(capacity * 0.001 * kilometerNumber * kilometerPrice + reservationPrice);
	}
	
	
	/**
	 * Calcul for Utility Car
	 * @param kilometerNumber
	 * @param kilometerPrice
	 * @param reservationPrice
	 * @param capacity
	 * @return
	 */
	public static Double CalculRentalPriceUtilityCar(int kilometerNumber, Double kilometerPrice, Double reservationPrice, int volume ) {
		
		return  (double) Math.round(volume * 0.05 * kilometerNumber * kilometerPrice + reservationPrice);
	}
	
	
	
	
}
