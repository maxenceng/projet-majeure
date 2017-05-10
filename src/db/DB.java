package db;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.AdminModel;

public class DB {
	private static final String DB_HOST="db-tp.cpe.fr";
	private static final String DB_PORT="3306";
	private static final String DB_NAME="binome13";
	private static final String DB_USER="binome13";
	private static final String DB_PWD="binome13";
	private Connection connection;
	
	public DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			this.connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USER, DB_PWD);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

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