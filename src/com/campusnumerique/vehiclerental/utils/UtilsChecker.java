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

	public static Double CalculRentalPrice(int kilometerNumber, Double kilometerPrice, Double reservationPrice) {
		
		return kilometerNumber*kilometerPrice + reservationPrice;
	}
	
	public boolean carIsAvialable(Car car, Date dateStart, Date dateEnd) {

		boolean isAvialable = false;
		if (car.getReservations() != null) {
			if (!car.getReservations().isEmpty()) {
				List<Reservation> reservations = car.getReservations();
				for (Reservation reservation : reservations) {
					Date dateStartResaCar = reservation.getDateStart();
					Date dateEndResaCar = reservation.getDateEnd();

					if (isBetween(dateStart, dateStartResaCar, dateEndResaCar) || isBetween(dateEnd, dateStartResaCar, dateEndResaCar) || isBetween(dateStartResaCar, dateStart, dateEnd)) {
						isAvialable = false;
					} else {
						isAvialable = true;
					}
				}

			} else {

				isAvialable = true;
			}
		}

		return isAvialable;
	}
	
	private boolean isBetween(Date dateToCheck , Date dateStart , Date dateEnd) {
		
		return dateToCheck.after(dateStart) && dateToCheck.before(dateEnd);
	}

	
	
}
