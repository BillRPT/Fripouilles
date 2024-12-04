package Class;

public class Catalogue {
	//private int idCat;
	private String libelleCat;
	private String Date;
	
	//Constructeur Catalogue
	
	public Catalogue(String unlibelleCat, String uneDate) {
		this.libelleCat = unlibelleCat;
		this.Date = uneDate;
	}

	/**
	 * Fonction qui retourne une chaine sous format XML
	 * @return une chaine sous format XML
	 */
	public String toXML() {
		String XML = "<libelle>" + this.libelleCat + "</libelle>\n" + "<date>" + this.Date + "</date>\n";
		
		return XML;
	}
	
	
	/**
	 * Fonction qui retourne une chaine sous format json
	 * @return une chaine sous format JSON
	 */
	public String toJSON() {
		String JSON = "{\"libelle\":" + this.libelleCat + ", \"date\":" + this.Date + "}";
		
		return JSON;
	}
	
	/**
	 * Fonction qui retourne une chaine sous format json
	 * @return une chaine sous format JSON
	 */
	public String toCSV() {
		String CSV = "";
		
		return CSV;
	}
}
