package Class;

public class Catalogue {
	//private int idCat;
	private String libelleCat;
	private String Date;
	private String idCatalogue;
	private String idVenteEphemere;
	private String etatCat;
	
	//Constructeur Catalogue
	
	public Catalogue(String unlibelleCat, String uneDate, String unidCate, String unidventeEph) {
		this.libelleCat = unlibelleCat;
		this.Date = uneDate;
		this.idCatalogue = unidCate;
		this.idVenteEphemere = unidventeEph;
	}
	
	//Deuxieme constructeur Catalogue
	public Catalogue(String unlibelleCat, String uneDate, String unidCate, String unidventeEph, String unetatCat) {
		this.libelleCat = unlibelleCat;
		this.Date = uneDate;
		this.idCatalogue = unidCate;
		this.idVenteEphemere = unidventeEph;
		this.etatCat = unetatCat;
	}
	
	//Les ascenseur
	
	public String getunLibelle() {
		return this.libelleCat;
	}
	
	public String getuneDate() {
		return this.Date;
	}
	
	public String getunidCategorie() {
		return this.idCatalogue;
	}
	
	public String getunidventeEphemere() {
		return this.idVenteEphemere;
	}
	
	public String getunEtat() {
		return this.etatCat;
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
