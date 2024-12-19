package Vues.Secretaire.Catalogue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Fonction.Fonction;
import Modele.Modele;

public class V_ajoutecataVente extends JPanel {

    private GridBagConstraints gbc;

    private JTextField nomCatalogue;
    private JTextField nomVente;

    private JLabel nomdelaVente;
    private JLabel nomduCatalogue;

    private JButton btnAjouterCatalogue;
    
    private JLabel messageLabel;

    public V_ajoutecataVente() {
    	setLayout(new GridBagLayout());

        // Gestionnaire de répartition
        this.gbc = new GridBagConstraints();
        this.gbc.insets = new Insets(10, 10, 10, 10); // Marges uniformes
        this.gbc.fill = GridBagConstraints.HORIZONTAL;

        // Champs de saisie
        this.nomVente = new JTextField(20);
        this.nomCatalogue = new JTextField(20);

        // Étiquettes
        this.nomdelaVente = new JLabel("Nom de la vente :");
        this.nomduCatalogue = new JLabel("Nom du catalogue :");

        // Bouton
        this.btnAjouterCatalogue = new JButton("Ajouter Catalogue à la Vente");
        this.btnAjouterCatalogue.addActionListener(new validerajoutCatalogue());

        // Label pour afficher les messages
        this.messageLabel = new JLabel();
        this.messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Positionnement des éléments dans le panel avec gbc
        gbc.gridx = 0; gbc.gridy = 0;
        this.add(nomdelaVente, gbc);

        gbc.gridx = 1;
        this.add(nomVente, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        this.add(nomduCatalogue, gbc);

        gbc.gridx = 1;
        this.add(nomCatalogue, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(btnAjouterCatalogue, gbc);

        gbc.gridy = 3; // Message sous le bouton
        gbc.gridwidth = 2;
        this.add(messageLabel, gbc);
    }

    class validerajoutCatalogue implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // VÃ©rification que les champs ne sont pas vides
            if (!nomVente.getText().isEmpty() && !nomCatalogue.getText().isEmpty()) {
                
            	//Verifier que le catalogue et la vente existe
            	if (Modele.rechercherVente(nomVente.getText()) != false && Modele.rechercherCatalogue(nomCatalogue.getText()) != false) {
            		//Verifier que le catalogue n'est pas deja dans une vente
            		if (Modele.verifCatalogue(nomCatalogue.getText()) == false) {
            			//Verifier que la vente ne possede pas deja un catalogue
            			if (Modele.verifVente(Modele.getidVente(nomVente.getText())) == false) {
            				//L'ajouter
                			Modele.ajoutercatalogueaVente(nomCatalogue.getText(), Modele.getidVente(nomVente.getText()));
                			messageLabel.setForeground(Color.GREEN);
                			messageLabel.setText("Le catalogue a ete ajoute dans la vente ");
            			}
            			else {
            				messageLabel.setForeground(Color.RED);
                			messageLabel.setText("Cette vente possede deja un catalogue");
            			}
            		}
            		else {
            			messageLabel.setForeground(Color.RED);
            			messageLabel.setText("Le catalogue est deja dans une vente");
            		}
            	}
            	else {
            		messageLabel.setForeground(Color.RED);
        			messageLabel.setText("La vente ou le catalogue existe pas");
            	}
            	
            } else {
            	messageLabel.setForeground(Color.RED);
                messageLabel.setText("Des champs sont vides");
            }
        }
    }
}
