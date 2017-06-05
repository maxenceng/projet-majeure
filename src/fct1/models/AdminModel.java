package fct1.models;

/**
 * cette classe permet de générer l'administrateur
 * @author hong_ch
 *
 */
public class AdminModel {

	private String login;
	private String pwd;
	
	public AdminModel(String login, String pwd) {
		this.login = login;
		this.pwd = pwd;
	}
	/**
	 * Cette méthode de récupérer le nom d'administrateur 
	 * @return le nom de l'administrateur courant
	 */
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * Cette méthode de récupérer le mot de passe
	 * @return le mot de passe de l'administrateur courant
	 */
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}