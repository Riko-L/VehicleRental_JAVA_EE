package com.campusnumerique.vehiclerental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Client;
import com.campusnumerique.vehiclerental.utils.Constante;

public class ClientDAO extends DAO<Client>{

	@Override
	public boolean create(Client obj) {
		boolean result = false;
		String sql = "INSERT INTO client (login,firstName,lastName,mail,birthDate,age,licenseNumber,licenseDate,password)"
				+ " VALUES (?,?,?,?,?,?,?,?,?);";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, obj.getLogin());
			stmt.setString(2, obj.getFirstName());
			stmt.setString(3, obj.getLastName());
			stmt.setString(4, obj.getMail());
			stmt.setDate(5, new java.sql.Date(obj.getBirthDate().getTime() + Constante.DAY));
			stmt.setInt(6, obj.getAge());
			stmt.setString(7, obj.getLicenseNumber());
			stmt.setDate(8, new java.sql.Date(obj.getLicenseDate().getTime() + Constante.DAY));
			stmt.setString(9, obj.getPassword());
			
			result = stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		return result;
	}

	@Override
	public boolean delete(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int connection(String password, String mail) {
		
		String sql ="select COUNT(*) from client Where mail = ? AND password = ?";
		int connection = 0;
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, mail);
			stmt.setString(2, password);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				connection=	result.getInt(1);
			}else {
				
				connection = 0;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
		
		
	}
	@Override
	public Client find(int id) throws SQLException{
		Client client = new Client();  
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM client WHERE id = '" + id + "'");
		if(result.first())
			client = new Client(
					id,
					result.getString("login"),
					result.getString("firstName"),
					result.getString("lastName"),
					result.getString("mail"),
					result.getDate("birthDate"),
					result.getString("licenseNumber"),
					result.getDate("licenseDate")
					);          
		
		return client;
	}

	
	public Client findByLogin(String login) throws SQLException{
		Client client = new Client();  
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM client WHERE login = '" + login + "'");
		if(result.first())
			client = new Client(
					result.getInt("id"),
					login,
					result.getString("firstName"),
					result.getString("lastName"),
					result.getString("mail"),
					result.getDate("birthDate"),
					result.getString("licenseNumber"),
					result.getDate("licenseDate")
					);          
		
		return client;
	}
	
	public Client findByMail(String mail) throws SQLException{
		Client client = new Client();  
		
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM client WHERE mail = '" + mail + "'");
		if(result.first())
			client = new Client(
					result.getInt("id"),
					result.getString("login"),
					result.getString("firstName"),
					result.getString("lastName"),
					mail,
					result.getDate("birthDate"),
					result.getString("licenseNumber"),
					result.getDate("licenseDate")
					);          
		
		return client;
	}
	
	
	@Override
	public List<Client> findAll() throws SQLException{
		ArrayList<Client> clients = new ArrayList<Client>();
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM client");
		while(result.next()){
			Client client = new Client(); 
			client = new Client(
					result.getInt("id"),
					result.getString("login"),
					result.getString("firstName"),
					result.getString("lastName"),
					result.getString("mail"),
					result.getDate("birthDate"),
					result.getString("licenseNumber"),
					result.getDate("licenseDate")
					);    
			clients.add(client);
		}
		return clients;
	}

	public JSONArray findAllAsJson(){
		JSONArray clients = new JSONArray();
		ResultSet result;
		try {
			result = this.connection.createStatement(
			    ResultSet.TYPE_SCROLL_INSENSITIVE, 
			    ResultSet.CONCUR_READ_ONLY
			  ).executeQuery("SELECT * FROM client");
			while(result.next()){
				Client client = new Client(); 
				client = new Client(
						result.getInt("id"),
						result.getString("login"),
						result.getString("firstName"),
						result.getString("lastName"),
						result.getString("mail"),
						result.getDate("birthDate"),
						result.getString("licenseNumber"),
						result.getDate("licenseDate")
						);     
				clients.put(client.getInfos());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clients;
	}
}
