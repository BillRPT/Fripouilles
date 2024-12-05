package Controleurs;

import java.awt.BorderLayout;

import Vues. *;

public class C_psecretaire {
	
	private V_logo vLogo;
	private V_principal vPrincipal;
	private V_menusecretaire vMenuSecretaire;
	
	public C_psecretaire() {
		vLogo = new V_logo();
		vPrincipal = new V_principal();
		vMenuSecretaire = new V_menusecretaire();
		
		
		vPrincipal.setJMenuBar(vMenuSecretaire);
		
		vPrincipal.getContentPane().add(vLogo, BorderLayout.NORTH);
	}
	
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
