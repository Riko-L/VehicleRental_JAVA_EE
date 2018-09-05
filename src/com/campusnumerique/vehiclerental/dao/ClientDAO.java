package com.campusnumerique.vehiclerental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Client;

public class ClientDAO extends DAO<Client>{

	@Override
	public boolean create(Client obj) {
		// TODO Auto-generated method stub
		return false;
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
