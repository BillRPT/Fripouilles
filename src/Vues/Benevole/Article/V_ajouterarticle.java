package Vues.Benevole.Article;

import javax.swing.*;
import Modele.Modele;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_ajouterarticle extends JPanel {
    private JTextField libelleArt;
    private JTextField typeArt;
    private JTextField etatArt;
    private JTextField cateArt;
    private JButton btnValider;
    private JLabel messageLabel;

    public V_ajouterarticle() {
    	setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
 
        
        JLabel titreLabel = new JLabel("Creer un article :");
        titreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titreLabel, gbc);

        //libelle de l'article
        libelleArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Réinitialiser la largeur
        add(new JLabel("Libelle de l'article : "), gbc);
        gbc.gridx = 1;
        add(libelleArt, gbc);

        //type de l'article
        typeArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Type de l'article : "), gbc);
        gbc.gridx = 1;
        add(typeArt, gbc);

        //catalogue
        cateArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Integrer l'article dans un catalogue (libelle) : "), gbc);
        gbc.gridx = 1;
        add(cateArt, gbc);

        //bouton Valider
        btnValider = new JButton("Ajouter l'article");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Le bouton prend toute la largeur
        add(btnValider, gbc);

        //label pour afficher les messages
        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        //ajouter ActionListener au bouton
        btnValider.addActionListener(new ajouterArticle());

        this.setVisible(true);
    }

    class ajouterArticle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //réinitialiser le texte du message
            messageLabel.setText("");

            //vérifier que les champs requis sont remplis
            if (!libelleArt.getText().isEmpty() && !typeArt.getText().isEmpty()) {
                if (cateArt.getText().isEmpty()) {
                    //ajouter l'article sans catalogue
                    Modele.ajouterArticle(libelleArt.getText(), typeArt.getText());
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Article ajoute avec succes sans catalogue.");
                } else {
                    //ajouter l'article avec catalogue
                    Modele.ajouterArticle(libelleArt.getText(), typeArt.getText(), cateArt.getText());
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Article ajoute avec succes.");
                }

                //réinitialiser les champs de texte
                libelleArt.setText("");
                typeArt.setText("");
                cateArt.setText("");

            } else {
                //afficher un message d'erreur
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Veuillez remplir tous les champs requis.");
            }
        }
    }
}
