package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Fonction.Fonction;
import Modele.Modele;
import Vues.*;

public class C_connexion {
	private V_connexion vConnex;
	private C_pbenevole cPBenevole;
	private C_psecretaire cPSecretaire;
	private V_principal vPrincipal;
	
	//------------------------------constructeur------------------------------
	public C_connexion() {
		cPBenevole = new C_pbenevole();
		cPSecretaire = new C_psecretaire();
		vConnex = new V_connexion(this, cPBenevole, cPSecretaire);
		this.vConnex.setVisible(true);
	}
	
	//------------------------------accesseurs------------------------------
	public V_connexion getConnexion() {
		return vConnex;
	}

	public void setConnexion(V_connexion connexion) {
		this.vConnex = connexion;
	}

	//------------------------------autres m�thodes------------------------------
	public boolean verifierConnexion(String pseudo, char[] password) {
        boolean rep = false;
        if (Modele.connexionUtilisateur(pseudo, Fonction.hashMD5(password))) {
            rep = true;
        }
        return rep;
    }
	
	public String verifierRole(String pseudo, char[] password) {
		String roleUser ="";
		if (Modele.connexionUtilisateur(pseudo, Fonction.hashMD5(password))) {
            roleUser = Modele.roleUtilisateur(pseudo, Fonction.hashMD5(password));
        }
		return roleUser;
	}
	
	public void fermervConnexion() {
		this.vConnex.setVisible(false);
	}
	
}
