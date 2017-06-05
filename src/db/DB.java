package db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fct1.models.AdminModel;
/**
 * cette classe permet de la creation de la connection avec
 * le base de donnee, de recuperer les utilisateur et aussi de 
 * verifier le mot de passe avec l'utilisateur
 */
public class DB {
	// Dev Ecole
	/*
	private static final String DB_HOST="db-tp.cpe.fr";
	private static final String DB_PORT="3306";
	private static final String DB_NAME="binome13";
	private static final String DB_USER="binome13";
	private static final String DB_PWD="binome13";
	*/
	// Dev Maison
	private static final String DB_HOST="localhost";
	private static final String DB_NAME="javadev";
	private static final String DB_USER="root";
	private static final String DB_PWD="root";
	private Connection connection;
	/**
	 * Ce constructeur permet d'établir une connection avec le base de donnee 
	 */
	public DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Dev Ecole
			// this.connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USER, DB_PWD);
			// Dev Maison
			this.connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + "/" + DB_NAME, DB_USER, DB_PWD);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * cette méthode permet de recuper les utilisateur dans notre
	 * base de donnee
	 * @return liste des utilisateurs
	 */

	public ArrayList<AdminModel> getAllUser() {
		ArrayList<AdminModel> userList = new ArrayList<AdminModel>();
		Statement query;
		try {
			query = this.connection.createStatement();
			ResultSet rs = query.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				AdminModel user = new AdminModel(
						rs.getString("login"),
						rs.getString("pwd"));
				userList.add(user);
			}
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * cette methode permet la verification de mot de passe avec l'utilisateur currant
	 * @param login
	 * @param pwd
	 * @return l'utilisateur si le mot de passe est correct
	 */
	public AdminModel checkUser(String login, String pwd) {
		ArrayList<AdminModel> userList=new ArrayList<AdminModel>();
		userList=this.getAllUser();
		for(AdminModel user:userList){
			if(login.equals(user.getLogin())){
				if(pwd.equals(user.getPwd())){
					return user;
				}
			}
		}
		return null;
	}
	
}