package Controleurs;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Class.Catalogue;
import Class.VenteEphemere;
import Modele.Modele;
import Vues.V_logo;
import Vues.Maire.V_menumaire;
import Vues.Maire.Consulter.V_consultercatalogue;
import Vues.Maire.Consulter.V_consulterstatistique;
import Vues.Secretaire.Consulter.V_consultercatalogueCsv;
import Vues.Secretaire.Consulter.V_consultercatalogueJson;
import Vues.Secretaire.Consulter.V_consultercatalogueXml;
import Vues.Secretaire.Consulter.V_consulterventeXml;

public class C_pmaire {
	
	private C_principal uncPrincipal;
	private V_logo vLogo;
	private V_menumaire unmenuSecretaire;
	
	private V_consultercatalogueJson V_consultercatalogueJson;
	private V_consultercatalogueCsv V_consultercataloguecsv;
	private V_consultercatalogueXml V_cataXml;
	
	private V_consultercatalogue V_consulterlesCatalogues;
	
	private V_consulterstatistique V_consulterlesstatistique;
	
	public C_pmaire(C_principal lecPrincipal) {
		this.uncPrincipal = lecPrincipal;
	}
	
	public void affichervMaire() {
		
		vLogo = new V_logo();
		
		unmenuSecretaire = new V_menumaire(this, uncPrincipal.getvPrincipal());
		
		uncPrincipal.getvPrincipal().setJMenuBar(unmenuSecretaire);
		
		uncPrincipal.getvPrincipal().getContentPane().add(vLogo, BorderLayout.NORTH);
	}
	
	public JPanel refreshtableCatalogue() {
		
		V_consulterlesCatalogues = new V_consultercatalogue(this.getlesCatalogues());
		
		return V_consulterlesCatalogues;
	}
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshcatalogueXml() {
		
		V_cataXml = new V_consultercatalogueXml(this.getlesCatalogues());
		
		return V_cataXml;
	}
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshcatalogueJson() {
		
		V_consultercatalogueJson = new V_consultercatalogueJson(this.getlesCatalogues());
		
		return V_consultercatalogueJson;
	}
	
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshcatalogueCsv() {
		
		V_consultercataloguecsv = new V_consultercatalogueCsv(this.getlesCatalogues());
		
		return V_consultercataloguecsv;
	}
	
	public JPanel refreshStat() {
		V_consulterlesstatistique = new V_consulterstatistique(this.getlesStatistique());
		
		return V_consulterlesstatistique;
	}
	
	
	private ArrayList<VenteEphemere> getlesStatistique() {
		ArrayList<VenteEphemere> lesStats = Modele.consulterStatistiques();
		
		return lesStats;
	}
	
	
	private ArrayList<Catalogue> getlesCatalogues() {
		ArrayList<Catalogue> lesCatalogues = Modele.consulterCatalogue();
		
		return lesCatalogues;
	}
}
