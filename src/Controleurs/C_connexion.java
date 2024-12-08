package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Fonction.Fonction;
import Modele.Modele;
import Vues.*;

public class C_connexion implements ActionListener {

    private V_connexion vConnex;
    private C_pbenevole cPBenevole;
    private C_psecretaire cPSecretaire;
    private C_principal cPrincipal;

    // ------------------------------ Constructeur ------------------------------
    public C_connexion(C_principal uncPrincipal) {
        this.cPrincipal = uncPrincipal;
        this.cPBenevole = new C_pbenevole(cPrincipal);
        this.cPSecretaire = new C_psecretaire(cPrincipal);
        this.vConnex = new V_connexion(this, cPBenevole, cPSecretaire, cPrincipal);
        this.vConnex.setVisible(true);
    }

    // ------------------------------ Méthodes d'événement ------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        String pseudo = vConnex.getPseudo();
        char[] password = vConnex.getPassword();

        if (!pseudo.isEmpty() && password.length != 0) {
            if (verifierConnexion(pseudo, password)) {
                String roleUser = verifierRole(pseudo, password);
                vConnex.setVisible(false);

                switch (roleUser) {
                    case "benevole":
                        cPrincipal.affichervPrincipal();
                        break;
                    case "secretaire":
                        cPSecretaire.affichagevSecretaire();
                        cPrincipal.affichervPrincipal();
                        break;
                    case "maire":
                        System.out.println("maire");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "L'utilisateur n'a aucun rôle attribué.");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Des champs sont vides.");
        }
    }

    // ------------------------------ Méthodes utilitaires ------------------------------
    public boolean verifierConnexion(String pseudo, char[] password) {
        return Modele.connexionUtilisateur(pseudo, Fonction.hashMD5(password));
    }

    public String verifierRole(String pseudo, char[] password) {
        return Modele.roleUtilisateur(pseudo, Fonction.hashMD5(password));
    }
}