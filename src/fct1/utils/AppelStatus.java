package fct1.utils;

/**
 * Cette classe permet de gérer le statut et l'utilisateur qui utilise le robot.
 * @author Maxence
 *
 */
public class AppelStatus {
	private static String status;
	private static String user;

	/**
	 * Getter de status
	 * @return
	 */
	public static String getStatus(){
		
		if(status == null)
		{
			status = "stopped";
		}
		return status;
	}
	
	/**
	 * Getter de user
	 * @return
	 */
	public static String getUser() {
		if(user == null) {
			user = "";
		}
		return user;
	}
	
	/**
	 * Setter de status
	 * @param s
	 */
	public static void setStatus(String s) {
		status = s;
	}
	
	/**
	 * Setter de user
	 * @param u
	 */
	public static void setUser(String u) {
		user = u;
	}
}
