package Vues.Benevole.ArtCat;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Modele.Modele;
import Vues.V_principal;
import Vues.Benevole.ArtCat.V_consulterartcat.RechercherArtCat;
import Vues.Benevole.Article.V_consulterarticle;
import Vues.Benevole.Article.V_jsonarticle;
import Vues.Benevole.Article.V_xmlarticle;

public class V_xmlconsulterartcat extends JPanel {
    private JTextField libelleCat;
    private JButton btnValider;
    private JLabel messageLabel;
    private V_principal vPrincipal;
 
    public V_xmlconsulterartcat(V_principal vPrincipal) {
    	this.vPrincipal = vPrincipal;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titreLabel = new JLabel("Consulter les articles d'un catalogue XML :");
        titreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titreLabel, gbc);

        libelleCat = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Libelle du catalogue : "), gbc);
        gbc.gridx = 1;
        add(libelleCat, gbc);

        btnValider = new JButton("Consulter les articles");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(btnValider, gbc);

        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        btnValider.addActionListener(new RechercherArtCat());

        this.setVisible(true);
    }

    class RechercherArtCat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            messageLabel.setText("");

            if (!libelleCat.getText().isEmpty()) {
                if (Modele.rechercherCatalogue(libelleCat.getText())) {
                    if (vPrincipal != null) {

                        vPrincipal.getContentPane().removeAll();
                        vPrincipal.add(new V_xmlarticle(Modele.consulterArtCat(libelleCat.getText())));
                        vPrincipal.revalidate();
                        vPrincipal.repaint();
                    } else {
                        messageLabel.setText("Erreur : vPrincipal n'est pas initialise.");
                    }
                } else {
                    messageLabel.setText("Catalogue non trouve.");
                }
                libelleCat.setText("");
            } else {
                messageLabel.setText("Veuillez remplir tous les champs requis.");
            }
        }
    }
}
