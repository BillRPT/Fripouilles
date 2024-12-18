package Vues;

import javax.swing.*;
import java.awt.*;

import Controleurs.*;
import Fonction.*;

/**
 * Classe repr�sentant la vue de la connexion dans l'application.
 * Cette vue permet � l'utilisateur de saisir son nom d'utilisateur (pseudo) et son mot de passe.
 * La classe g�re l'affichage de la fen�tre de connexion et l'interaction avec l'utilisateur.
 */
public class V_connexion extends JFrame {

    // Attributs
    /**
     * Contr�leur associ� � la gestion de la connexion.
     */
    private C_connexion cConnex;

    /**
     * Champ de texte pour saisir le pseudo (nom d'utilisateur).
     */
    private JTextField fieldPseudo;

    /**
     * Champ de texte pour saisir le mot de passe.
     */
    private JPasswordField fieldMdp;

    /**
     * Bouton pour valider la connexion.
     */
    private JButton btnValider;

    // ------------------------------ Constructeur ------------------------------
    /**
     * Constructeur de la vue de connexion.
     * Ce constructeur initialise la fen�tre de connexion avec les composants n�cessaires
     * et lie les �v�nements au contr�leur de connexion.
     * 
     * @param cConnexion Le contr�leur de la connexion.
     * @param cPBenevole Le contr�leur pour la gestion des b�n�voles (non utilis� ici mais pass� en param�tre).
     * @param cPSecretaire Le contr�leur pour la gestion des secr�taires (non utilis� ici mais pass� en param�tre).
     * @param lecPrincipal Le contr�leur principal de l'application (non utilis� ici mais pass� en param�tre).
     */
    public V_connexion(C_connexion cConnexion, C_pbenevole cPBenevole, C_psecretaire cPSecretaire, C_principal lecPrincipal) {
        this.cConnex = cConnexion;

        // Configuration de la fen�tre
        this.setTitle("Fripouilles - Connexion");
        this.setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal pour organiser les composants verticalement
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPanel);

        // Logo de l'application
        JLabel labelLogo = new JLabel(Fonction.resizeImageIcon(new ImageIcon("images/fripouilles_logo.png"), 325, 170));
        labelLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelLogo);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Champ pour saisir le pseudo (login)
        JLabel labelPseudo = new JLabel("Login :");
        labelPseudo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelPseudo);

        fieldPseudo = new JTextField(15);
        fieldPseudo.setMaximumSize(new Dimension(200, 30));
        contentPanel.add(fieldPseudo);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Champ pour saisir le mot de passe
        JLabel labelMdp = new JLabel("Mot de passe :");
        labelMdp.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelMdp);

        fieldMdp = new JPasswordField(15);
        fieldMdp.setMaximumSize(new Dimension(200, 30));
        contentPanel.add(fieldMdp);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Bouton de validation de la connexion
        btnValider = new JButton("Connexion");
        btnValider.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(btnValider);

        // Ajouter l'�couteur d'action pour le bouton de connexion
        btnValider.addActionListener(cConnexion);

        setVisible(false);  // La vue est cach�e au d�part
    }

    
    /**
     * M�thode pour r�cup�rer le pseudo saisi dans le champ de texte.
     * 
     * @return Le pseudo (nom d'utilisateur) saisi par l'utilisateur.
     */
    public String getPseudo() {
        return fieldPseudo.getText();
    }

    /**
     * M�thode pour r�cup�rer le mot de passe saisi dans le champ de texte.
     * 
     * @return Le mot de passe sous forme de tableau de caract�res.
     */
    public char[] getPassword() {
        return fieldMdp.getPassword();
    }
}
