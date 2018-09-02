package com.campusnumerique.vehiclerental.entity;

import java.io.Serializable;

import org.json.JSONObject;

public class Kind implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int id;
	private String label;
	
	public Kind() {
	
	}
	
	public Kind(int id ,String label) {
		setId(id);
		setLabel(label);
	}

	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	
	public JSONObject getInfos(){
		JSONObject infos= new JSONObject();
		infos.put("label", label);
		infos.put("id", id);
		
		return infos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kind other = (Kind) obj;
		if (id != other.id)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getInfos().toString();
	}

	
	
}
