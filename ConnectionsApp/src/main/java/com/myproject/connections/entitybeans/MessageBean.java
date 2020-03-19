package com.myproject.connections.entitybeans;

import java.io.Serializable;

public class MessageBean implements Serializable{
	
	
	private static final long serialVersionUID = -7308147947092645013L;
	
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	

}
