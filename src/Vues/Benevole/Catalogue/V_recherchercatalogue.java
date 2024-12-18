package Vues.Benevole.Catalogue;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modele.Modele;
import javax.swing.*;

public class V_recherchercatalogue extends JPanel {
    private JTextField libelleArt;
    private JButton btnValider;
    private JLabel messageLabel;
    private GridBagConstraints gbc;

    public V_recherchercatalogue() {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //libellé du cat
        libelleArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Libellé de l'article : "), gbc);
        gbc.gridx = 1;
        add(libelleArt, gbc);

        //bouton pour valider la recherche
        btnValider = new JButton("Rechercher le catalogue");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Le bouton prend toute la largeur
        add(btnValider, gbc);

        //label pour afficher les messages
        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(java.awt.Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        //ajouter ActionListener au bouton
        btnValider.addActionListener(new rechercherCatalogue());
    }

    class rechercherCatalogue implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            messageLabel.setText("");


            if (!libelleArt.getText().isEmpty()) {
                String libelle = libelleArt.getText();
                
                boolean articleTrouve = Modele.rechercherCatalogue(libelle);

                if (articleTrouve) {
                    messageLabel.setForeground(java.awt.Color.GREEN);
                    messageLabel.setText("Article trouvé : " + libelle);
                } else {
                    messageLabel.setForeground(java.awt.Color.RED);
                    messageLabel.setText("Aucun article trouvé pour le libelle : " + libelle);
                }
 
                libelleArt.setText("");
            } else {
                //afficher un message d'erreur
                messageLabel.setForeground(java.awt.Color.RED);
                messageLabel.setText("Veuillez entrer un libelle pour rechercher un article.");
            }
        }
    }
}