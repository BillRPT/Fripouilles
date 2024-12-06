package Controleurs;

import Vues.*;
import Vues.Benevole.V_menubenevole;

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
			
			
			//Ajouter le menu à la vue principale
			vPrincipal.setJMenuBar(vMenuBenevole);
			
			//Ajouter le logo à la vue principale
			vPrincipal.getContentPane().add(vLogo, BorderLayout.NORTH);
		}
		
	    //------------------------------méthodes------------------------------
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
		
		/**
		 * Listener du menu du benevole
		 */
		
		private void addMenuListener() {
			
		}
}
