package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO extends DAO<Reservation>{

	@Override
	public boolean create(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation find(int id) throws SQLException {
		Reservation reservation = new Reservation();
		
		ResultSet result = this.connection.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE, 
			    ResultSet.CONCUR_READ_ONLY
			  ).executeQuery("SELECT * FROM reservation WHERE id = " + id);
			if(result.first())
				reservation = new Reservation(
						id,
						result.getString("reservationNumber"),
						result.getDate("dateStart"),
						result.getDate("dateEnd"),
						result.getInt("kilometerNumber"),
						result.getDouble("rentalPrice")
						);
		
			return reservation;
	}

	@Override
	public List<Reservation> findAll() throws SQLException {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		ResultSet result = this.connection.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE, 
			    ResultSet.CONCUR_READ_ONLY
			  ).executeQuery("SELECT * FROM reservation");
		while(result.next()) {
			Reservation reservation = new Reservation();
			reservation = new Reservation(
					result.getInt("id"),
					result.getString("reservationNumber"),
					result.getDate("dateStart"),
					result.getDate("dateEnd"),
					result.getInt("kilometerNumber"),
					result.getDouble("rentalPrice")
					);
			reservations.add(reservation);
		}
		
		return reservations;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
