package com.campusnumerique.vehiclerental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.campusnumerique.vehiclerental.entity.Car;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UtilityCar> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UtilityCar> findByFilter(Date dateStartResa,Date dateEndResa, int horsePower ,int kind) throws SQLException {
		ArrayList<Car> cars = new ArrayList<Car>();
		
		
		String query = "select * from car WHERE car.id NOT IN (select car.id from car JOIN reservation ON car.id = reservation.id_car Where (? BETWEEN reservation.dateStart  AND reservation.dateEnd ) OR (? BETWEEN reservation.dateStart  AND reservation.dateEnd ) OR (reservation.dateStart BETWEEN ? AND ?)) AND (car.horsePower < ?) AND (car.kind = ?);";
		
		PreparedStatement stmt = this.connection.prepareStatement(query);
		stmt.setDate(1, new java.sql.Date(dateStartResa.getTime() + Constante.DAY));
		stmt.setDate(2, new java.sql.Date(dateEndResa.getTime() + Constante.DAY ));
		stmt.setDate(3, new java.sql.Date(dateStartResa.getTime() + Constante.DAY));
		stmt.setDate(4, new java.sql.Date(dateEndResa.getTime() + Constante.DAY));
		stmt.setInt(5, horsePower);
		stmt.setInt(6, kind);
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
		return null;
	}
	
}
