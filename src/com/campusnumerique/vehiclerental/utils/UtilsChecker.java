package com.campusnumerique.vehiclerental.utils;

import java.util.Date;
import java.util.List;

import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.Reservation;

public class UtilsChecker {

	public String checkAge(int age) {
		String message;
		if (age < 18) {
			message = Constante.AGE_MOINS_DE_18;
		} else if (age >= 18 || age < 21) {
			message = Constante.AGE_MOINS_DE_21;
		} else if (age >= 21 || age < 25) {
			message = Constante.AGE_ENTRE_21_ET_25;
		} else {
			message = Constante.AGE_PLUS_25;
		}
		return message;
	}

	public boolean carIsAvialable(Car car, Date dateStart, Date dateEnd) {

		boolean isAvialable = false;
		if (car.getReservations() != null) {
			if (!car.getReservations().isEmpty()) {
				List<Reservation> reservations = car.getReservations();
				for (Reservation reservation : reservations) {
					Date dateStartResaCar = reservation.getDateStart();
					Date dateEndResaCar = reservation.getDateEnd();

					if ((dateStart.before(dateStartResaCar) && dateStart.after(dateEndResaCar)) || (dateEnd.before(dateStartResaCar) && dateEnd.after(dateEndResaCar))) {
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
	
	private boolean isBetween() {
		
		return false;
	}

}
