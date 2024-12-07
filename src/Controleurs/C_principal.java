package Controleurs;

import Vues.*;
import Vues.Benevole.V_menubenevole;

import javax.swing.JFrame;

import Controleurs.*;

public class C_principal {
	//attributs
	private V_principal vPrincipal;
	private V_menubenevole vMenuBenevole;
	
	//Constructeur
	/**
	* Constructeur du controleur principal
	*/
	public C_principal() {
		vPrincipal = new V_principal();
		
	}
	
	public V_principal getvPrincipal() {
		return this.vPrincipal;
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
