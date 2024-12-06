package Class;

public class Categorie {
	private String nomCate;
	
	public Categorie(String unnomCate) {
		this.nomCate = unnomCate;
	}
	
	/**
	 * Fonction qui retourne une chaine sous format json
	 * @return une chaine sous format JSON
	 */
	public String toJSON() {
		String JSON = "{ \"nomCategorie\" : " + this.nomCate + "\"}";
		
		return JSON;
	}
	
	
	/**
	 * Fonction qui retourne une chaine sous format XML
	 * @return une chaine sous format XML
	 */
	public String toXML() {
		String XML = "<nomCate>" + this.nomCate + "</nomCate>\n";
		
		return XML;
	}
	
	/**
	 * Fonction qui retourne une chaine sous format CSV
	 * @return une chaine sous format CSV
	 */
	public String toCSV() {
		String CSV = this.nomCate + ';';
		
		return CSV;
	}
}
