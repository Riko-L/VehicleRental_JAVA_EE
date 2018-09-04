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
import com.campusnumerique.vehiclerental.entity.UtilityCar;
import com.campusnumerique.vehiclerental.utils.Constante;

public class UtilityCarDAO extends DAO<UtilityCar> {

	@Override
	public boolean create(UtilityCar obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UtilityCar obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UtilityCar obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UtilityCar find(int id) throws SQLException {
		UtilityCar utilityCar = new UtilityCar();  
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM utilitycar WHERE id = '" + id + "'");
		if(result.first())
			utilityCar =  new UtilityCar(
					id,
					result.getString("brand"),
					result.getString("model"),
					result.getString("plateNumber"),
					result.getString("color"),
					result.getInt("horsePower"),
					result.getDouble("reservationPrice"),
					result.getDouble("kilometerPrice"),
					result.getInt("volume"));        
		
		return utilityCar;
	}

	@Override
	public List<UtilityCar> findAll() throws SQLException {
		ArrayList<UtilityCar> utilityCars = new ArrayList<UtilityCar>();
		ResultSet result = this.connection.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE, 
			    ResultSet.CONCUR_READ_ONLY
			  ).executeQuery("SELECT * FROM utilitycar");
		while(result.next()){
			UtilityCar utilityCar = new UtilityCar(
					result.getInt("id"),
					result.getString("brand"),
					result.getString("model"),
					result.getString("plateNumber"),
					result.getString("color"),
					result.getInt("horsePower"),
					result.getDouble("reservationPrice"),
					result.getDouble("kilometerPrice"),
					result.getInt("volume"));
			
			utilityCars.add(utilityCar);
		}
		return utilityCars;
	}

	public List<UtilityCar> findByFilter(Date dateStartResa,Date dateEndResa, int horsePower ,int kind) throws SQLException {
		ArrayList<UtilityCar> utilityCars = new ArrayList<UtilityCar>();
		
		
		String query = "select * from utilitycar WHERE utilitycar.id NOT IN (select utilitycar.id from utilitycar JOIN reservation ON utilitycar.id = reservation.id_utilitycar Where (? BETWEEN reservation.dateStart  AND reservation.dateEnd ) OR (? BETWEEN reservation.dateStart  AND reservation.dateEnd ) OR (reservation.dateStart BETWEEN ? AND ?)) AND (utilitycar.horsePower < ?) AND (utilitycar.kind = ?);";
		
		PreparedStatement stmt = this.connection.prepareStatement(query);
		stmt.setDate(1, new java.sql.Date(dateStartResa.getTime() + Constante.DAY));
		stmt.setDate(2, new java.sql.Date(dateEndResa.getTime() + Constante.DAY ));
		stmt.setDate(3, new java.sql.Date(dateStartResa.getTime() + Constante.DAY));
		stmt.setDate(4, new java.sql.Date(dateEndResa.getTime() + Constante.DAY));
		stmt.setInt(5, horsePower);
		stmt.setInt(6, kind);
		ResultSet result = stmt.executeQuery();
		while(result.next()){
			UtilityCar utilityCar = new UtilityCar(
					result.getInt("id"),
					result.getString("brand"),
					result.getString("model"),
					result.getString("plateNumber"),
					result.getString("color"),
					result.getInt("horsePower"),
					result.getDouble("reservationPrice"),
					result.getDouble("kilometerPrice"),
					result.getInt("volume")); 
			
			utilityCars.add(utilityCar);
		}
		return utilityCars;
	}
	
	public JSONArray findAllAsJson() {
		JSONArray utilityCars = new JSONArray();
		ResultSet result;
		try {
			result = this.connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY
					).executeQuery("SELECT * FROM utilitycar");
			while(result.next()){
				UtilityCar utilityCar = new UtilityCar(
						result.getInt("id"),
						result.getString("brand"),
						result.getString("model"),
						result.getString("plateNumber"),
						result.getString("color"),
						result.getInt("horsePower"),
						result.getDouble("reservationPrice"),
						result.getDouble("kilometerPrice"),
						result.getInt("volume")); 
				
				utilityCars.put(utilityCar.getInfos());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilityCars;
	}
	
}
