package Vues.Benevole.ArtCat;

import javax.swing.*;
import Modele.Modele;
import Vues.V_principal;
import Vues.Benevole.Article.V_consulterarticle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_consulterartcat extends JPanel {
    private JTextField libelleCat;
    private JButton btnValider;
    private JLabel messageLabel;
    private V_principal vPrincipal;

    // Modifiez le constructeur pour accepter une instance de V_principal
    public V_consulterartcat(V_principal vPrincipal) {
        this.vPrincipal = vPrincipal; // Assignez l'instance passée à la variable membre

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titreLabel = new JLabel("Consulter les articles d'un catalogue :");
        titreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titreLabel, gbc);

        libelleCat = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Libellé du catalogue : "), gbc);
        gbc.gridx = 1;
        add(libelleCat, gbc);

        btnValider = new JButton("Ajouter l'article");
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
                        vPrincipal.add(new V_consulterarticle(Modele.consulterArtCat(libelleCat.getText())));
                        vPrincipal.revalidate();
                        vPrincipal.repaint();
                    } else {
                        messageLabel.setText("Erreur : vPrincipal n'est pas initialisé.");
                    }
                } else {
                    messageLabel.setText("Catalogue non trouvé.");
                }
                libelleCat.setText("");
            } else {
                messageLabel.setText("Veuillez remplir tous les champs requis.");
            }
        }
    }
}
