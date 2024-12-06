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
		
	    
	    
	//Constructeur
		/**
		* Constructeur du controleur principal
		*/
		public C_pbenevole() {
			vPrincipal = new V_principal();
			vLogo = new V_logo();
			
		//ajouter les cartes (vues) dans le cardPanel
			cardLayout = new CardLayout();
			cardPanel = new JPanel(cardLayout);
			
			cardPanel.add(vAjouterArticle, "vAjouterArticle");
			cardPanel.add(vRechercherArticle, "vRechercherArticle");
			cardPanel.add(vSupprimerArticle, "vSupprimerArticle");
			
		//Ajouter le menu à la vue principale
			vPrincipal.setJMenuBar(vMenuBenevole);
			
		//Ajouter le logo à la vue principale
			vPrincipal.getContentPane().add(vLogo, BorderLayout.NORTH);
			vPrincipal.getContentPane().add(cardPanel, BorderLayout.CENTER);
		}
		
		
		
	    //------------------------------méthodes------------------------------
		
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
