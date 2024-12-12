package Controleurs;

import java.awt.BorderLayout;
import java.util.ArrayList;

import Class.VenteEphemere;
import Modele.Modele;
import Vues. *;
import Vues.Secretaire.V_menusecretaire;
import Vues.Secretaire.Benevole.V_ajouterunBenevole;
import Vues.Secretaire.Benevole.V_supprimerBenevole;
import Vues.Secretaire.Consulter.V_consultercatalogue;
import Vues.Secretaire.Consulter.V_consultervente;
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
	private V_consultercatalogue V_consulterlesCatalogues;
	private V_recherchervente V_rechercheruneVente;
	private V_consultervente V_consulterVente;
	
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
		V_consulterlesCatalogues = new V_consultercatalogue(Modele.consulterCatalogue());
		V_consulterVente = new V_consultervente(Modele.consulterlesVentes());
		V_rechercheruneVente = new V_recherchervente();
		vMenuSecretaire = new V_menusecretaire(this, V_ajouteruneVente, V_supprimeuneVente, V_ajtunBenevole, V_supprimerunBenevole, V_consulterlesCatalogues, V_rechercheruneVente, V_consulterVente, uncPrincipal.getvPrincipal());
		
		uncPrincipal.getvPrincipal().setJMenuBar(vMenuSecretaire);
		
		uncPrincipal.getvPrincipal().getContentPane().add(vLogo, BorderLayout.NORTH);
	}
	
	//Pour consultation des Ventes, créer une procèdure ici qui va remplacer le panel car au moment ou j'insert ca ne se met pas a jour donc le faire ici
	public void refreshtableVente() {
	    ArrayList<VenteEphemere> lesVentes = Modele.consulterlesVentes();
	    V_consulterVente = new V_consultervente(lesVentes);
		
		uncPrincipal.getvPrincipal().getContentPane().removeAll();
	    uncPrincipal.getvPrincipal().add(V_consulterVente);
	    uncPrincipal.getvPrincipal().revalidate();
	    uncPrincipal.getvPrincipal().repaint();
	}
	
	public void affichermenuSecretaire() {
		this.vMenuSecretaire.setVisible(true);
	}
}
