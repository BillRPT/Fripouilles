package Controleurs;

import java.awt.BorderLayout;

import Vues. *;
import Vues.Secretaire.V_menusecretaire;
import Vues.Secretaire.Benevole.V_ajouterunBenevole;
import Vues.Secretaire.Benevole.V_supprimerBenevole;
import Vues.Secretaire.Vente.V_ajoutervente;
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
		vMenuSecretaire = new V_menusecretaire(V_ajouteruneVente, V_supprimeuneVente, V_ajtunBenevole, V_supprimerunBenevole, uncPrincipal.getvPrincipal());
		
		uncPrincipal.getvPrincipal().setJMenuBar(vMenuSecretaire);
		
		uncPrincipal.getvPrincipal().getContentPane().add(vLogo, BorderLayout.NORTH);
	}
	
	public void affichermenuSecretaire() {
		this.vMenuSecretaire.setVisible(true);
	}
}
