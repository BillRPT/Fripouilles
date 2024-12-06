package Vues.Benevole.Article;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class V_rechercherarticle extends JPanel {
	private JTextField libelleArt;
    private JButton btnValider;
    private GridBagConstraints gbc;

    public V_rechercherarticle() {
    	setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplit horizontalement

        //Libell� de l'article
        libelleArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Libell� de l'article : "), gbc);
        gbc.gridx = 1;
        add(libelleArt, gbc);
        
        //Bouton pour valider la recherche
        btnValider = new JButton("Rechercher l'article");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Le bouton prend toute la largeur
        add(btnValider, gbc);

    }
}
