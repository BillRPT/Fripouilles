package Class;

public class Article {
	private int idArt;
	private String libelleArt;
	private String typeArt;
	private String etatArt;
	
	public Article(int id, String libelle, String type, String etat) {
		this.setIdArt(id);
		this.setLibelleArt(libelle);
		this.setTypeArt(type);
		this.setEtatArt(etat);
	}
	
	public Article(String libelle, String type, String etat) {
		this.setLibelleArt(libelle);
		this.setTypeArt(type);
		this.setEtatArt(etat);
	}

	public String getLibelleArt() {
		return libelleArt;
	}

	public void setLibelleArt(String libelleArt) {
		this.libelleArt = libelleArt;
	}

	public String getTypeArt() {
		return typeArt;
	}

	public void setTypeArt(String typeArt) {
		this.typeArt = typeArt;
	}

	public String getEtatArt() {
		return etatArt;
	}

	public void setEtatArt(String etatArt) {
		this.etatArt = etatArt;
	}
	
	/**
	 * Fonction qui retourne une chaine sous format XML
	 * @return une chaine sous format XML
	 */
	public String toXML() {
	    String XML = "<Article>\n"
	               + "    <libelle>" + this.libelleArt + "</libelle>\n"
	               + "    <type>" + this.typeArt + "</type>\n"
	               + "    <etat>" + this.etatArt + "</type>\n"
	               + "</Article>\n";
	    return XML;
	}
	/**
	 * Fonction qui retourne une chaine sous format json
	 * @return une chaine sous format JSON
	 */
	public String toJSON() {
		String JSON = "{\"libelle\": \"" + this.libelleArt + "\", \"type\": \"" + this.typeArt + "\", \"etat\": \"" + this.etatArt + "\"}";
		
		return JSON;
	}
	/**
	 * Fonction qui retourne une chaine sous format json
	 * @return une chaine sous format CSV
	 */
	public String toCSV() {
		String CSV = this.libelleArt + ";" + this.typeArt + ";" + this.etatArt;
		
		return CSV;
	}

	public int getIdArt() {
		return idArt;
	}

	public void setIdArt(int idArt) {
		this.idArt = idArt;
	}
	
}
