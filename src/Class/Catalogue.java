package Class;

public class Catalogue {
	//private int idCat;
	private String libelleCat;
	private String Date;
	private String idCatalogue;
	private String idVenteEphemere;
	private String etatCat;
	private VenteEphemere saVente;
	
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
	
	//troisieme constructeur Catalogue pour consulter les catalogue et voir a quel vente il appartient
		public Catalogue(String unlibelleCat, String uneDate, String unidCate, String unetatCat, VenteEphemere lavente) {
			this.libelleCat = unlibelleCat;
			this.Date = uneDate;
			this.idCatalogue = unidCate;
			this.etatCat = unetatCat;
			this.saVente = lavente;
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
	
	public VenteEphemere getsaVente() {
		return this.saVente;
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
