package com.campusnumerique.vehiclerental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Car;

public class CarDAO extends DAO<Car>{

	@Override
	public boolean create(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Car obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Car find(int id) throws SQLException {
	Car car = new Car();  
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM car WHERE id = '" + id + "'");
		if(result.first())
			car =  new Car(
					id,
					result.getString("brand"),
					result.getString("model"),
					result.getString("plateNumber"),
					result.getString("color"),
					result.getInt("horsePower"),
					result.getDouble("reservationPrice"),
					result.getDouble("kilometerPrice"));        
		
		return car;
	}

	@Override
	public List<Car> findAll() throws SQLException {
		ArrayList<Car> cars = new ArrayList<Car>();
		ResultSet result = this.connection.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE, 
			    ResultSet.CONCUR_READ_ONLY
			  ).executeQuery("SELECT * FROM car");
		while(result.next()){
			Car car = new Car(
					result.getInt("id"),
					result.getString("brand"),
					result.getString("model"),
					result.getString("plateNumber"),
					result.getString("color"),
					result.getInt("horsePower"),
					result.getDouble("reservationPrice"),
					result.getDouble("kilometerPrice")); 
			
			cars.add(car);
		}
		return cars;
	}
	
	
	public List<Car> findByFilter(Date dateStartResa,Date dateEndResa, int horsePower) throws SQLException {
		ArrayList<Car> cars = new ArrayList<Car>();
		
		String query = "select * from car JOIN reservation ON car.id = reservation.id_car Where (reservation.dateStart BETWEEN ? AND ?) AND (reservation.dateEnd BETWEEN ? AND ?) AND (? BETWEEN reservation.dateStart AND reservation.dateEnd) AND (car.horsePower < ?);";
		
		PreparedStatement stmt = this.connection.prepareStatement(query);
		stmt.setDate(1, (java.sql.Date) dateStartResa);
		stmt.setDate(2, (java.sql.Date) dateEndResa);
		stmt.setDate(3, (java.sql.Date) dateStartResa);
		stmt.setDate(4, (java.sql.Date) dateEndResa);
		stmt.setDate(5, (java.sql.Date) dateStartResa);
		stmt.setInt(6, horsePower);
		
		ResultSet result = stmt.executeQuery();
		while(result.next()){
			Car car = new Car(
					result.getInt("id"),
					result.getString("brand"),
					result.getString("model"),
					result.getString("plateNumber"),
					result.getString("color"),
					result.getInt("horsePower"),
					result.getDouble("reservationPrice"),
					result.getDouble("kilometerPrice")); 
			
			cars.add(car);
		}
		return cars;
	}
	
	
	public JSONArray findAllAsJson() {
		JSONArray cars = new JSONArray();
		ResultSet result;
		try {
			result = this.connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY
					).executeQuery("SELECT * FROM car");
			while(result.next()){
				Car car = new Car(
						result.getInt("id"),
						result.getString("brand"),
						result.getString("model"),
						result.getString("plateNumber"),
						result.getString("color"),
						result.getInt("horsePower"),
						result.getDouble("reservationPrice"),
						result.getDouble("kilometerPrice")); 
				
				cars.put(car.getInfos());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}

}
