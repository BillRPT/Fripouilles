package Vues.Benevole.Article;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Modele.Modele;

public class V_supprimerarticle extends JPanel {
    private JTextField libelleArt;
    private JButton btnValider;
    private JLabel messageLabel;
    private GridBagConstraints gbc;

    public V_supprimerarticle() {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //libellé de l'article
        libelleArt = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Libellé de l'article : "), gbc);
        gbc.gridx = 1;
        add(libelleArt, gbc);

        //bouton pour valider la suppression
        btnValider = new JButton("Supprimer l'article");
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
        btnValider.addActionListener(new supprimerArticle());
    }

    class supprimerArticle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            messageLabel.setText("");

            //vérifier que le champ requis est rempli
            if (!libelleArt.getText().isEmpty()) {
                String libelle = libelleArt.getText();
 
                
                boolean articleSupprime = Modele.supprimerArticle(libelle);

                if (articleSupprime) {
                    messageLabel.setForeground(java.awt.Color.GREEN);
                    messageLabel.setText("Article supprimé : " + libelle);
                } else {
                    messageLabel.setForeground(java.awt.Color.RED);
                    messageLabel.setText("Aucun article trouvé pour le libellé : " + libelle);
                }

                libelleArt.setText("");
            } else {
                //afficher message d'erreur
                messageLabel.setForeground(java.awt.Color.RED);
                messageLabel.setText("Veuillez entrer un libellé pour supprimer un article.");
            }
        }
    }
}