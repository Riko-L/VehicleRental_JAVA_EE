package com.campusnumerique.vehiclerental.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.campusnumerique.vehiclerental.entity.Kind;


public class KindDAO extends DAO<Kind> {

	@Override
	public boolean create(Kind obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Kind obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Kind obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Kind find(int id) throws SQLException {
	
		return null;
	}

	

	@Override
	public List<Kind> findAll() throws SQLException {
		
		List<Kind> kinds = new ArrayList<Kind>();
		ResultSet result = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  ).executeQuery("SELECT * FROM kind");
		while(result.next()) {
			Kind kind = new Kind( result.getInt("id"),result.getString("label"));
			kinds.add(kind);
		}
	
		return kinds;
	}
	
	public JSONArray findAllAsJson() throws SQLException {
		JSONArray kinds = new JSONArray();
		String sql ="SELECT * FROM kind;";
		Statement stmt = this.connection.createStatement(
		    ResultSet.TYPE_SCROLL_INSENSITIVE, 
		    ResultSet.CONCUR_READ_ONLY
		  );
		
		ResultSet result = stmt.executeQuery(sql);
		
		
		while(result.next()) {
			Kind kind = new Kind( result.getInt("id"),result.getString("label"));
			kinds.put(kind.getInfos());
		}
		
		stmt.close();
		return kinds;
	}


}
