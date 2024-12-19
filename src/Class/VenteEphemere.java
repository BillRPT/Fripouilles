package Class;

public class VenteEphemere {
	private int idVenteEph;
	private String dateEph;
	private String typeVente;
	private String nomVente;
	
	//Pour les statistiques
	
	private int nbCatalogue;
	private int nbarticleVendu;
	private String etatVente;
	
	public VenteEphemere(int unidVente, String uneDate, String untypeVente, String unNomVente) {
		this.idVenteEph = unidVente;
		this.dateEph = uneDate;
		this.typeVente = untypeVente;
		this.nomVente = unNomVente;
	}
	
	
	//Constructeur pour les stats
	
	public VenteEphemere(int unidVente, String uneDate, String untypeVente, String unNomVente,String unetatVente, int nbarticleVendu) {
		this.idVenteEph = unidVente;
		this.dateEph = uneDate;
		this.typeVente = untypeVente;
		this.nomVente = unNomVente;
		this.etatVente = unetatVente;
		this.nbarticleVendu = nbarticleVendu;
	}
	
	public VenteEphemere(String unNomVente) {
		this.nomVente = unNomVente;
	}
	
	public int getidVente() {
		return this.idVenteEph;
	}
	
	public String getdateEph() {
		return this.dateEph;
	}
	
	public String gettypeVente() {
		return this.typeVente;
	}
	
	public String getnomVente() {
		return this.nomVente;
	}
	
	public int getNbCatalogue() {
        return this.nbCatalogue;
    }

    public int getNbarticleVendu() {
        return this.nbarticleVendu;
    }
    
    public String getEtatVente() {
        return this.etatVente;
    }
	
	/**
	 * Fonction qui retourne une chaine sous format XML
	 * @return une chaine sous format XML
	 */
	public String toXML() {
		String XML = "<Vente><idVenteEph>" + this.idVenteEph + "</idVenteEph>"  + " <date>" + this.dateEph + "</date>" + " <typevente>" + this.typeVente + "</typevente>" + " <nomVente>" + this.nomVente + "</nomVente><Vente>";
		
		return XML;
	}
	
	/**
	 * Fonction qui retourne une chaine sous format Json
	 * @return une chaine sous format JSON
	 */
	public String toJson() {
	    String json = "{"
	            + "\"idVenteEph\": \"" + this.idVenteEph + "\", "
	            + "\"dateEph\": \"" + this.dateEph + "\", "
	            + "\"typeVente\": \"" + this.typeVente + "\", "
	            + "\"nomVente\": \"" + this.nomVente + "\""
	            + "}";
	    return json;
	}
	
	
	/**
	 * Fonction qui retourne une chaine sous format csv
	 * @return une chaine sous format csv
	 */
	public String toCSV() {
	    return this.idVenteEph + ";" + this.dateEph + ";" + this.typeVente + ";" + this.nomVente;
	}


}
