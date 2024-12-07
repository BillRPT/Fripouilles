package Controleurs;

import Vues.*;
import Vues.Benevole.*;
import Vues.Benevole.Article.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Controleurs.*;

public class C_pbenevole {
	//attributs
		private V_logo vLogo;
		private V_principal vPrincipal;
		private V_menubenevole vMenuBenevole;
		private V_ajouterarticle vAjouterArticle;
		private V_rechercherarticle vRechercherArticle;
		private V_supprimerarticle vSupprimerArticle;
		
		private CardLayout cardLayout;
	    private JPanel cardPanel;
	    
	    private C_principal uncPrincipal;
		
	    
	    
	//Constructeur
		/**
		* Constructeur du controleur principal
		*/
		public C_pbenevole(C_principal lecPrincipal) {
			this.uncPrincipal = lecPrincipal;
		}
		
		public void affichervBenevole() {
			vLogo = new V_logo();
			vMenuBenevole = new V_menubenevole(this);
			
			//ajouter les cartes (vues) dans le cardPanel
			cardLayout = new CardLayout();
			cardPanel = new JPanel(cardLayout);
				
				/*cardPanel.add(vAjouterArticle, "vAjouterArticle");
				cardPanel.add(vRechercherArticle, "vRechercherArticle");
				cardPanel.add(vSupprimerArticle, "vSupprimerArticle");*/
				
			//Ajouter le menu � la vue principale
			uncPrincipal.getvPrincipal().setJMenuBar(vMenuBenevole);
				
			//Ajouter le logo � la vue principale
			uncPrincipal.getvPrincipal().getContentPane().add(vLogo, BorderLayout.NORTH);
			uncPrincipal.getvPrincipal().getContentPane().add(cardPanel, BorderLayout.CENTER);
		}
		
		
		
	    //------------------------------m�thodes------------------------------
		
		public void afficherCarte(String nomCarte) {
			this.cardLayout.show(cardPanel, nomCarte);
	    }
		
		/**
		* Procedure affichant la vue principale
		*/
		public void affichervPrincipal() {
			this.vPrincipal.setVisible(true);
		}
		
		/**
		* Procedure fermant la vue principale
		*/
		public void fermervPrincipal() {
			this.vPrincipal.setVisible(false);
		}
		
		//menu
		
		/**
		 * Afficher l'insertion d'un nouvel article
		 */
		public void afficherAjouterArticle() {
		}

		
}
