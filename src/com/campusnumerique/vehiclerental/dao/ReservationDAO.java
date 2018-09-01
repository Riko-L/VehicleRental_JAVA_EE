package com.campusnumerique.vehiclerental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.campusnumerique.vehiclerental.entity.Reservation;
import com.campusnumerique.vehiclerental.utils.Constante;

public class ReservationDAO extends DAO<Reservation>{

	@SuppressWarnings("deprecation")
	@Override
	public boolean create(Reservation obj) {
		
		boolean isOk = false;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO reservation("
					+ "reservationNumber,"
					+ "dateStart,"
					+ "dateEnd,"
					+ "kilometerNumber,"
					+ "rentalPrice,"
					+ "dayNumber,"
					+ "kind,"
					+ "id_car,"
					+ "id_client)"
					+ " VALUES (?, ?, ?, ?, ? , ? ,? ,? ,?)");
			stmt.setString(1, obj.getReservationNumber());
			stmt.setDate(2, new java.sql.Date(obj.getDateStart().getTime() + Constante.DAY));
			stmt.setDate(3, new java.sql.Date(obj.getDateEnd().getTime() + Constante.DAY));
			stmt.setInt(4, obj.getKilometerNumber());
			stmt.setDouble(5, obj.getRentalPrice());
			stmt.setInt(6, obj.getDayNumber());
			stmt.setInt(7, obj.getKind());
			stmt.setInt(8, obj.getCar().getId());
			stmt.setInt(9, obj.getClient().getId());
			
			int result = stmt.executeUpdate(); 
			
			if(result == 0 ) {
				isOk = false;
			} else {
				isOk = true;
			}
			
		} catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		
		return isOk;
	}

	@Override
	public boolean delete(Reservation obj){
		
		boolean isOk = false;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM reservation WHERE reservationNumber=?");
			stmt.setString(1, obj.getReservationNumber());
			
			int result = stmt.executeUpdate();
			
			if(result == 0 ) {
				isOk = false;
			} else {
				isOk = true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return isOk;
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
			  ).executeQuery("SELECT * FROM reservation WHERE id = '" + id +"'");
			if(result.first())
				reservation = new Reservation(
						result.getString("reservationNumber"),
						result.getDate("dateStart"),
						result.getDate("dateEnd"),
						result.getInt("kilometerNumber"),
						result.getDouble("rentalPrice"),
						result.getInt("kind")
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
					result.getString("reservationNumber"),
					result.getDate("dateStart"),
					result.getDate("dateEnd"),
					result.getInt("kilometerNumber"),
					result.getDouble("rentalPrice"),
					result.getInt("kind")
					);
			reservations.add(reservation);
		}
		
		return reservations;
	}
}
