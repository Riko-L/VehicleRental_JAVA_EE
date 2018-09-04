package com.campusnumerique.vehiclerental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Car;
import com.campusnumerique.vehiclerental.entity.MotorBike;
import com.campusnumerique.vehiclerental.utils.Constante;


public class MotorBikeDAO extends DAO<MotorBike> {

	@Override
	public boolean create(MotorBike obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(MotorBike obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(MotorBike obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MotorBike find(int id) throws SQLException {
		MotorBike motorBike = new MotorBike();
		
		ResultSet result = this.connection.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE, 
			    ResultSet.CONCUR_READ_ONLY
			  ).executeQuery("SELECT * FROM motorbike WHERE id = '" + id + "'");
			if(result.first())
				motorBike =  new MotorBike(
						id,
						result.getString("brand"),
						result.getString("model"),
						result.getString("plateNumber"),
						result.getString("color"),
						result.getInt("horsePower"),
						result.getDouble("reservationPrice"),
						result.getDouble("kilometerPrice"),
						result.getInt("capacity"));
			
			return motorBike;
	}

	@Override
	public List<MotorBike> findAll() throws SQLException {
		ArrayList<MotorBike> motorBikes = new ArrayList<MotorBike>();
		ResultSet result = this.connection.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE, 
			    ResultSet.CONCUR_READ_ONLY
			  ).executeQuery("SELECT * FROM motorbike");
		while(result.next()){
			MotorBike motorBike = new MotorBike(
					result.getInt("id"),
					result.getString("brand"),
					result.getString("model"),
					result.getString("plateNumber"),
					result.getString("color"),
					result.getInt("horsePower"),
					result.getDouble("reservationPrice"),
					result.getDouble("kilometerPrice"),
					result.getInt("capacity")); 
			
			motorBikes.add(motorBike);
		}
		return motorBikes;
	}

	
	public List<MotorBike> findByFilter(Date dateStartResa,Date dateEndResa ,int kind) throws SQLException {
		ArrayList<MotorBike> motorBikes = new ArrayList<MotorBike>();
		
		
		String query = "select * from motorbike WHERE motorbike.id NOT IN (select motorbike.id from motorbike JOIN reservation ON motorbike.id = reservation.id_motorbike Where (? BETWEEN reservation.dateStart  AND reservation.dateEnd ) OR (? BETWEEN reservation.dateStart  AND reservation.dateEnd ) OR (reservation.dateStart BETWEEN ? AND ?)) AND (motorbike.kind = ?);";
		
		PreparedStatement stmt = this.connection.prepareStatement(query);
		stmt.setDate(1, new java.sql.Date(dateStartResa.getTime() + Constante.DAY));
		stmt.setDate(2, new java.sql.Date(dateEndResa.getTime() + Constante.DAY ));
		stmt.setDate(3, new java.sql.Date(dateStartResa.getTime() + Constante.DAY));
		stmt.setDate(4, new java.sql.Date(dateEndResa.getTime() + Constante.DAY));
		
		stmt.setInt(5, kind);
		
		ResultSet result = stmt.executeQuery();
		while(result.next()){
			MotorBike motorBike = new MotorBike(
					result.getInt("id"),
					result.getString("brand"),
					result.getString("model"),
					result.getString("plateNumber"),
					result.getString("color"),
					result.getInt("horsePower"),
					result.getDouble("reservationPrice"),
					result.getDouble("kilometerPrice"),
					result.getInt("capacity")); 
			
			motorBikes.add(motorBike);
		} 
		
		return motorBikes;
	}

	
	public JSONArray findAllAsJson() {
		JSONArray motorBikes = new JSONArray();
		ResultSet result;
		try {
			result = this.connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY
					).executeQuery("SELECT * FROM motorbike");
			while(result.next()){
				MotorBike motorBike = new MotorBike(
						result.getInt("id"),
						result.getString("brand"),
						result.getString("model"),
						result.getString("plateNumber"),
						result.getString("color"),
						result.getInt("horsePower"),
						result.getDouble("reservationPrice"),
						result.getDouble("kilometerPrice"),
						result.getInt("capacity")); 
				
				motorBikes.put(motorBike.getInfos());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return motorBikes;
	}

}
