package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Fonction.Fonction;
import Modele.Modele;
import Vues.*;

public class C_connexion {
	private V_connexion vConnex;
	private C_principal cPrincipal;
	private V_principal vPrincipal;
	
	//------------------------------constructeur------------------------------
	public C_connexion() {
		cPrincipal = new C_principal();
		vConnex = new V_connexion(this, cPrincipal);
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
	
	public void fermervConnexion() {
		this.vConnex.setVisible(false);
	}
	
}
