package Vues;

import javax.swing.*;

import Controleurs.*;
import Fonction.Fonction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_connexion extends JFrame {

    // ATTRIBUTS
	private C_connexion cConnex;
	
    private JPanel contentPanel;
    private JLabel labelLogo;
    private JLabel labelPseudo;
    private JLabel labelMdp;
    private JTextField fieldPseudo;
    private JPasswordField fieldMdp;
    private JButton btnValider;

    //------------------------constructeur------------------------------
    public V_connexion(C_connexion cConnexion) {
    	this.cConnex = cConnexion;
    	
        // Paramètres de la fenêtre
        setTitle("Fripouilles - Connexion");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Création du panneau principal
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPanel);

        // Logo
        labelLogo = new JLabel(Fonction.resizeImageIcon(new ImageIcon("images/fripouilles_logo.png"), 325,170)); // Redimensionne l'image grâce à ma méthode dans le modèle
        labelLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelLogo);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espace entre les éléments

        // Label et champ de texte pour le pseudonyme
        labelPseudo = new JLabel("Login :");
        labelPseudo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelPseudo);

        fieldPseudo = new JTextField(15);
        fieldPseudo.setMaximumSize(new Dimension(200, 30));
        contentPanel.add(fieldPseudo);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espace entre les éléments

        // Label et champ de texte pour le mot de passe
        labelMdp = new JLabel("Mot de passe :");
        labelMdp.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelMdp);

        fieldMdp = new JPasswordField(15);
        fieldMdp.setMaximumSize(new Dimension(200, 30));
        contentPanel.add(fieldMdp);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espace entre les éléments

        // Bouton de validation
        btnValider = new JButton("Connexion");
        btnValider.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(btnValider);
        btnValider.addActionListener(new AfficherPgPrincipale());

        setVisible(true);
    }
    
    class AfficherPgPrincipale implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	if (e.getSource() == btnValider) {
        		if(cConnex.verifierConnexion(fieldPseudo.getText(), fieldMdp.getPassword()) == true) {
        			JOptionPane.showMessageDialog(null, "Bienvenue !");
                }
        		else {
        			JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect !");
        		}
        	}
        }
    }
    
}
    