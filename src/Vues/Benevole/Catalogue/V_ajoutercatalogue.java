package Vues.Benevole.Catalogue;

import javax.swing.*;
import Modele.Modele;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jdesktop.swingx.JXDatePicker;


public class V_ajoutercatalogue extends JPanel {
    private JTextField libelleCat;
    private JXDatePicker dateCat; // Remplacement de JTextField par JXDatePicker
    private JButton btnValider;
    private JLabel messageLabel;

    public V_ajoutercatalogue() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL; // Remplit horizontalement

        // Libellé du catalogue
        libelleCat = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Libellé du catalogue : "), gbc);
        gbc.gridx = 1;
        add(libelleCat, gbc);

        // Date du catalogue
        dateCat = new JXDatePicker(); // Initialisation du sélecteur de date
        dateCat.setFormats("yyyy-MM-dd"); // Format de la date
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Date du catalogue : "), gbc);
        gbc.gridx = 1;
        add(dateCat, gbc);

        // Bouton Valider
        btnValider = new JButton("Ajouter le catalogue");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Le bouton prend toute la largeur
        add(btnValider, gbc);

        // Label pour afficher les messages
        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);

        // Ajouter ActionListener au bouton
        btnValider.addActionListener(new ajouterCatalogue());

        this.setVisible(true);
    }

    class ajouterCatalogue implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //renitialiser le texte du message
            messageLabel.setText("");

            //verif que les champs requis sont remplis
            if (!libelleCat.getText().isEmpty() && dateCat.getDate() != null) {
                //recup la date de JXDatePicker
                java.util.Date utilDate = dateCat.getDate();
                
                //Convertir java.util.Date en java.sql.Date
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                // Ajouter le catalogue
                boolean catalogueAjoute = Modele.ajouterCatalogue(libelleCat.getText(), sqlDate);

                if (catalogueAjoute) {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Catalogue ajouté avec succès.");

                    //reinitialiser les champs de texte
                    libelleCat.setText("");
                    dateCat.setDate(null);
                } else {
                    messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Erreur lors de l'ajout du catalogue.");
                }
            } else {
                //aficher un message d'erreur
                messageLabel.setForeground(Color.RED);
                messageLabel.setText("Veuillez remplir tous les champs requis.");
            }
        }
    }
}