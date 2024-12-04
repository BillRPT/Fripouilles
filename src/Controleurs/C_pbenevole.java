package Controleurs;

import Vues.*;

import java.awt.*;

import Controleurs.*;

public class C_pbenevole {
	//attributs
		private V_logo vLogo;
		private V_principal vPrincipal;
		private V_menubenevole vMenuBenevole;
		
		private CardLayout cardLayout;
		
		//Constructeur
		/**
		* Constructeur du controleur principal
		*/
		public C_pbenevole() {
			vPrincipal = new V_principal();
			vMenuBenevole = new V_menubenevole();
			vLogo = new V_logo();
			
			//ajouter les cartes (vues) dans le cardPanel
			
			
			//Ajouter le menu ‡ la vue principale
			vPrincipal.setJMenuBar(vMenuBenevole);
			
			//Ajouter le logo ‡ la vue principale
			vPrincipal.getContentPane().add(vLogo, BorderLayout.NORTH);
		}
		
		//MÈthodes utilitaires
		/**
		* Proc√®dure qui permet d'afficher la vue principal
		*/
		public void affichervPrincipal() {
			this.vPrincipal.setVisible(true);
		}
		
		/**
		* Proc√®dure qui permet de fermer la vue principal.
		*/
		public void fermervPrincipal() {
			this.vPrincipal.setVisible(false);
		}
}
