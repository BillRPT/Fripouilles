package Vues.Benevole.Article;


import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class V_ajouterarticle extends JPanel {
    private JTextField libelleArt;
    private JTextField typeArt;
    private JTextField etatArt;
    private JTextField cateArt;
    private JButton btnValider;
    private GridBagConstraints gbc;

    public V_ajouterarticle() {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.VERTICAL;


        libelleArt = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Libellé de l'article : "), gbc);
        gbc.gridx = 1;
        add(libelleArt, gbc);

        typeArt = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Type de l'article : "), gbc);
        gbc.gridx = 2;
        add(typeArt, gbc);

        etatArt = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Etat de l'article : "), gbc);
        gbc.gridx = 3;
        add(etatArt, gbc);

        typeArt = new JTextField(20);
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Intégrer l'article dans un catalogue : "), gbc);
        gbc.gridx = 4;
        add(typeArt, gbc);

        btnValider = new JButton("Ajouter un article");
        gbc.gridx = 1; gbc.gridy = 5;
        add(btnValider, gbc);
        
    }

}