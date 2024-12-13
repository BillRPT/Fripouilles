package Class;

public class Catalogue {
	//private int idCat;
	private String libelleCat;
	private String Date;
	private String idCategorie;
	private String idVenteEphemere;
	
	//Constructeur Catalogue
	
	public Catalogue(String unlibelleCat, String uneDate, String unidCate, String unidventeEph) {
		this.libelleCat = unlibelleCat;
		this.Date = uneDate;
		this.idCategorie = unidCate;
		this.idVenteEphemere = unidventeEph;
	}
	
	//Les ascenseur
	
	public String getunLibelle() {
		return this.libelleCat;
	}
	
	public String getuneDate() {
		return this.Date;
	}
	
	public String getunidCategorie() {
		return this.idCategorie;
	}
	
	public String getunidventeEphemere() {
		return this.idVenteEphemere;
	}
	

	/**
	 * Fonction qui retourne une chaine sous format XML
	 * @return une chaine sous format XML
	 */
	public String toXML() {
	    String XML = "<Catalogue>\n"
	               + "    <libelle>" + this.libelleCat + "</libelle>\n"
	               + "    <date>" + this.Date + "</date>\n"
	               + "</Catalogue>\n";
	    return XML;
	}

	
	
	/**
	 * Fonction qui retourne une chaine sous format json
	 * @return une chaine sous format JSON
	 */
	public String toJSON() {
		String JSON = "{\"libelle\": \"" + this.libelleCat + "\", \"date\": \"" + this.Date + "\"}";
		
		return JSON;
	}
	
	/**
	 * Fonction qui retourne une chaine sous format json
	 * @return une chaine sous format CSV
	 */
	public String toCSV() {
		String CSV = this.libelleCat + ";" + this.Date;
		
		return CSV;
	}
}
