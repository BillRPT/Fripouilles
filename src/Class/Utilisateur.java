package Class;

public class Utilisateur {
	
	private String nomUser;
	private String prenomUser;
	private String loginUser;
	
	public Utilisateur(String unNomuser, String unPrenomuser, String unloginUser) {
		this.nomUser = unNomuser;
		this.prenomUser = unPrenomuser;
		this.loginUser = unloginUser;
	}
	
	public String getunNom() {
		return this.nomUser;
	}
	
	public String getunPrenom() {
		return this.prenomUser;
	}
	
	public String getunloginUser() {
		return this.loginUser;
	}
	
	public String toCSV() {
		return this.nomUser + ";" + this.prenomUser + ";" + this.loginUser;
	}

	public String toXML() {
		return "<Utilisateur>\n" +
			   "   <nomUser>" + this.nomUser + "</nomUser>\n" +
			   "   <prenomUser>" + this.prenomUser + "</prenomUser>\n" +
			   "   <loginUser>" + this.loginUser + "</loginUser>\n" +
			   "</Utilisateur>";
	}
	
	public String toJSON() {
		return "{\"nomUser\": \"" + this.nomUser + "\", \"prenomUser\": \"" + this.prenomUser + "\", \"loginUser\": \"" + this.loginUser + "\"}";
	}
}
