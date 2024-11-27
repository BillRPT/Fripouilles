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
	
	//------------------------------constructeur------------------------------
	public C_connexion() {
		
		
	}
	
	//------------------------------accesseurs------------------------------
	public V_connexion getConnexion() {
		return vConnex;
	}

	public void setConnexion(V_connexion connexion) {
		this.vConnex = connexion;
	}

	//------------------------------autres méthodes------------------------------
	public boolean verifierConnexion(String pseudo, char[] password) {
        boolean rep = false;
        Modele.connexionBdd();
        if (Modele.connexionUtilisateur(pseudo, Fonction.hashMD5(password))) {
        	Modele.fermetureBdd();
        	//Erreur a fix ici
            /*vConnex.setVisible(false);  // Masquer la fenêtre de connexion
            cPrincipal = new C_principal(); // Initialise le contrôleur principal
            cPrincipal.afficherMain();*/  // Affiche la page principale
            rep = true;
        }
        return rep;
    }
	
}
