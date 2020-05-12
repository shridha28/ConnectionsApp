package com.myproject.connections.constants;

public enum RoleConstants {
	user("user",1001),
	admin("admin",1000);
	
	private final long value;
	private final String role;
	
	private RoleConstants(String role,long val) {
	 this.value= val;
	 this.role = role;
	}
	
	 public long getValue() {
	        return value;
	    }
	 public String getRole() {
		 return role;
	 }

}
