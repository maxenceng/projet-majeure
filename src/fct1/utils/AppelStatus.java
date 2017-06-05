package fct1.utils;

public class AppelStatus {
	private static String status;
	private static String user;

	
	public static String getStatus(){
		
		if(status == null)
		{
			status = "stopped";
		}
		return status;
	}
	
	public static String getUser() {
		if(user == null) {
			user = "";
		}
		return user;
	}
	
	public static void setStatus(String s) {
		status = s;
	}
	
	public static void setUser(String u) {
		user = u;
	}
}
