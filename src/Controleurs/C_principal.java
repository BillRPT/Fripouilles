package Controleurs;

import Vues.*;
import Controleurs.*;

public class C_principal {
	//attributs
	V_principal vPrincipal;
	V_menu vMenu;
	//constructeur
	/**
	* Constructeur du controleur principal
	*/
	public C_principal() {
		vPrincipal = new V_principal();
	}
	
	/**
	* Procèdure qui permet de afficher la vue principal
	*/
	public void affichervPrincipal() {
		this.vPrincipal.setVisible(true);
	}
	
	/**
	* Procèdure qui permet de fermer la vue principal
	*/
	public void fermervPrincipal() {
		this.vPrincipal.setVisible(false);
	}
}
