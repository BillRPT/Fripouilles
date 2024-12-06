package Vues.Benevole.Article;

import javax.swing.*;
import java.awt.*;

public class V_ajouterarticle extends JPanel {
    private JTextField libelleArt;
    private JTextField typeArt;
    private JTextField etatArt;
    private JTextField cateArt;
    private JButton btnValider;
    private GridBagConstraints gbc;

    public V_ajouterarticle() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplit horizontalement

        //Libellé de l'article
        libelleArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Libellé de l'article : "), gbc);
        gbc.gridx = 1;
        add(libelleArt, gbc);

        //Type de l'article
        typeArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Type de l'article : "), gbc);
        gbc.gridx = 1;
        add(typeArt, gbc);

        //État de l'article
        etatArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("État de l'article : "), gbc);
        gbc.gridx = 1;
        add(etatArt, gbc);

        //Catalogue
        cateArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Intégrer l'article dans un catalogue (libellé) : "), gbc);
        gbc.gridx = 1;
        add(cateArt, gbc);

        //Bouton Valider
        btnValider = new JButton("Ajouter l'article");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Le bouton prend toute la largeur
        add(btnValider, gbc);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Test de V_ajouterarticle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Taille de la fenêtre

        
        V_ajouterarticle panel = new V_ajouterarticle();
        frame.add(panel);

       
        frame.setVisible(true);
    }
}