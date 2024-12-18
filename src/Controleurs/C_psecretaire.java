package Controleurs;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import Class.Catalogue;
import Class.Utilisateur;
import Class.VenteEphemere;
import Modele.Modele;
import Vues. *;
import Vues.Benevole.Catalogue.V_ajoutercatalogue;
import Vues.Secretaire.V_menusecretaire;
import Vues.Secretaire.Benevole.V_ajouterunBenevole;
import Vues.Secretaire.Benevole.V_rechercherBenevole;
import Vues.Secretaire.Benevole.V_supprimerBenevole;
import Vues.Secretaire.Catalogue.V_ajoutecataVente;
import Vues.Secretaire.Catalogue.V_supprimercataVente;
import Vues.Secretaire.Consulter.V_consulterbenevole;
import Vues.Secretaire.Consulter.V_consultercatalogueCsv;
import Vues.Secretaire.Consulter.V_consultercatalogueXml;
import Vues.Secretaire.Consulter.V_consulterhistoriquecatalogue;
import Vues.Secretaire.Consulter.V_consultervente;
import Vues.Secretaire.Consulter.V_consulterventeCsv;
import Vues.Secretaire.Consulter.V_consulterventeXml;
import Vues.Secretaire.Consulter.V_consultercatalogueJson;
import Vues.Secretaire.Consulter.V_consulterventeJson;
import Vues.Secretaire.Vente.V_ajoutervente;
import Vues.Secretaire.Vente.V_recherchervente;
import Vues.Secretaire.Vente.V_supprimevente;

public class C_psecretaire {
	
	private C_principal uncPrincipal;
	
	private V_logo vLogo;
	private V_menusecretaire vMenuSecretaire;
	//Panel ajouter une vente du secretaire
	private V_ajoutervente V_ajouteruneVente;
	private V_supprimevente V_supprimeuneVente;
	private V_ajouterunBenevole V_ajtunBenevole;
	private V_supprimerBenevole V_supprimerunBenevole;
	private V_recherchervente V_rechercheruneVente;
	private V_consultervente V_consulterVente;
	private V_rechercherBenevole V_rechercherunBenevole;
	private V_consultercatalogueXml V_cataXml;
	private V_consultercatalogueJson V_consultercatalogueJson;
	private V_consultercatalogueCsv V_consultercataloguecsv;
	private V_consulterventeXml V_consulterlesventesXml;
	private V_consulterventeJson V_consulterlesventesJson;
	private V_consulterventeCsv V_consulterlesventeCsv;
	private V_consulterhistoriquecatalogue V_consulterleshistoriquecatalogue;
	private V_consulterbenevole V_consulterBenevole;
	private V_ajoutecataVente V_ajoutcataVente;
	private V_supprimercataVente V_suppCataVente;
	
	//Constructeur
	public C_psecretaire(C_principal lecPrincipal) {
		this.uncPrincipal = lecPrincipal;
	}
	
	public void affichagevSecretaire() {
		vLogo = new V_logo();
		//Instancier les differents panel de ajouts,suppresion,recherche ect ici
		V_ajouteruneVente = new V_ajoutervente();
		V_supprimeuneVente = new V_supprimevente();
		V_ajtunBenevole = new V_ajouterunBenevole();
		V_supprimerunBenevole = new V_supprimerBenevole();
		V_rechercheruneVente = new V_recherchervente();
		V_rechercherunBenevole = new V_rechercherBenevole();
		V_ajoutcataVente = new V_ajoutecataVente();
		V_suppCataVente = new V_supprimercataVente();
		vMenuSecretaire = new V_menusecretaire(this, V_suppCataVente, V_ajoutcataVente, V_ajouteruneVente, V_supprimeuneVente, V_ajtunBenevole, V_supprimerunBenevole, V_rechercheruneVente, V_rechercherunBenevole, uncPrincipal.getvPrincipal());
		
		uncPrincipal.getvPrincipal().setJMenuBar(vMenuSecretaire);
		
		uncPrincipal.getvPrincipal().getContentPane().add(vLogo, BorderLayout.NORTH);
	}
	
	//Pour consultation des Ventes, créer une procèdure ici qui va remplacer le panel car au moment ou j'insert ca ne se met pas a jour donc le faire ici
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshtableVente() {
	    V_consulterVente = new V_consultervente(this.getlesVentes());
		
		return V_consulterVente;
	}
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshcatalogueXml() {
		
		V_cataXml = new V_consultercatalogueXml(this.getlescataloguesHistorique());
		
		return V_cataXml;
	}
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshcatalogueJson() {
		
		V_consultercatalogueJson = new V_consultercatalogueJson(this.getlescataloguesHistorique());
		
		return V_consultercatalogueJson;
	}
	
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshcatalogueCsv() {
		
		V_consultercataloguecsv = new V_consultercatalogueCsv(this.getlescataloguesHistorique());
		
		return V_consultercataloguecsv;
	}
	
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshventeXml() {
		
		V_consulterlesventesXml = new V_consulterventeXml(this.getlesVentes());
		
		return V_consulterlesventesXml;
	}
	
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshventeJson() {
		
		V_consulterlesventesJson = new V_consulterventeJson(this.getlesVentes());
		
		return V_consulterlesventesJson;
	}
	
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshventeCsv() {
		
		V_consulterlesventeCsv = new V_consulterventeCsv(this.getlesVentes());
		
		return V_consulterlesventeCsv;
	}
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refreshhistoriqueCatalogue() {
		
		V_consulterleshistoriquecatalogue = new V_consulterhistoriquecatalogue(this.getlescataloguesHistorique());
		
		return V_consulterleshistoriquecatalogue;
	}
	
	/**
	 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
	 * @return un JPanel
	 * */
	public JPanel refresheconsulterBenevole() {
		
		V_consulterBenevole = new V_consulterbenevole(this.getlesBenevoles());
		
		return V_consulterBenevole;
	}
	
	/**
	 * Fonction qui permet de récupérer les ventes pour refresh le JTable
	 * @return une liste de vente lesVentes
	 * */
	private ArrayList<VenteEphemere> getlesVentes() {
		ArrayList<VenteEphemere> lesVentes = Modele.consulterlesVentes();
		
		return lesVentes;
	}
	
	
	
	/**
	 * Fonction qui permet de recuperer les historiques des catalogues (c'est a dire les cata dispo et non dispo)
	 * @return une liste de catalogues lesCatalogues
	 * */
	private ArrayList<Catalogue> getlescataloguesHistorique() {
		ArrayList<Catalogue> lesCatalogues = Modele.historiqueCatalogue();
		
		return lesCatalogues;
	}
	
	/**
	 * Fonction qui permet de récupérer les ventes pour refresh le JTable
	 * @return une liste de vente lesVentes
	 * */
	private ArrayList<Utilisateur> getlesBenevoles() {
		ArrayList<Utilisateur> lesUtilisateurs = Modele.consulterBenevole();
		
		return lesUtilisateurs;
	}
	
	public void affichermenuSecretaire() {
		this.vMenuSecretaire.setVisible(true);
	}
}
