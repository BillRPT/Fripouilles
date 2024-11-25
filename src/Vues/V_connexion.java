package Vues;

import javax.swing.*;

import Fonction.Fonction;

import java.awt.*;
import java.awt.event.ActionListener;

public class V_connexion extends JFrame {

    // ATTRIBUTS
    private JPanel contentPanel;
    private JLabel labelLogo;
    private JLabel labelPseudo;
    private JLabel labelMdp;
    private JTextField fieldPseudo;
    private JPasswordField fieldMdp;
    private JButton btnValider;

    //------------------------constructeur------------------------------
    public V_connexion() {
        // Paramètres de la fenêtre
        setTitle("SIO2JEU - Connexion");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Création du panneau principal
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPanel);

        // Logo
        labelLogo = new JLabel(Fonction.resizeImageIcon(new ImageIcon("D:\\emmy\\AP\\SIO2JEU\\images\\sio2jeu_icon.png"), 250,170)); // Redimensionne l'image grâce à ma méthode dans le modèle
        labelLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelLogo);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espace entre les éléments

        // Label et champ de texte pour le pseudonyme
        labelPseudo = new JLabel("Pseudonyme :");
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
        btnValider = new JButton("Valider");
        btnValider.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(btnValider);

        setVisible(false);
    }
    
    //------------------------accesseurs------------------------------
    
    // Accesseurs pour les champs
    public JTextField getFieldPseudo() {
        return fieldPseudo;
    }

    public JPasswordField getFieldMdp() {
        return fieldMdp;
    }
    
    //------------------------méthodes------------------------------

    // Méthode pour ajouter un écouteur au bouton de validation
    public void addBtnListener(ActionListener listener) {
        btnValider.addActionListener(listener);
    }
}
    