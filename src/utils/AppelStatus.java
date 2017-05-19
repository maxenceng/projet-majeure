package utils;

public class AppelStatus {
	private static String status;

	
	public static String getStatus(){
		
		if(status == null)
		{
			status = "stopped";
		}
		return status;
	}
	
	public static void setStatus(String s) {
		status = s;
	}
}
