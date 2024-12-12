package Class;

public class VenteEphemere {
	private String idVenteEph;
	private String dateEph;
	private String typeVente;
	private String nomVente;
	
	public VenteEphemere(String unidVente, String uneDate, String untypeVente, String unNomVente) {
		this.idVenteEph = unidVente;
		this.dateEph = uneDate;
		this.typeVente = untypeVente;
		this.nomVente = unNomVente;
	}
	
	public String getidVente() {
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
}
