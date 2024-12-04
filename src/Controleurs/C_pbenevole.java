package Controleurs;

import Vues.*;
import Controleurs.*;

public class C_pbenevole {
	//attributs
		private V_principal vPrincipal;
		private V_menubenevole vMenuBenevole;
		
		//Constructeur
		/**
		* Constructeur du controleur principal
		*/
		public C_pbenevole() {
			vPrincipal = new V_principal();
			
		}
		
		//M�thodes utilitaires
		/**
		* Procèdure qui permet d'afficher la vue principal
		*/
		public void affichervPrincipal() {
			this.vPrincipal.setVisible(true);
		}
		
		/**
		* Procèdure qui permet de fermer la vue principal.
		*/
		public void fermervPrincipal() {
			this.vPrincipal.setVisible(false);
		}
}
