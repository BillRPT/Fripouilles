package Vues.Secretaire.Vente;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Modele.Modele;

public class V_supprimevente extends JPanel{
	
	private GridBagConstraints gbc;
	
	private JTextField nomVente;
	private JLabel nomdelaVente;
	
	private JButton supprimerVente;
	
	private JLabel messageLabel;
	
	
	public V_supprimevente() {
		setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.gbc.insets = new Insets(5, 5, 5, 5);
        this.gbc.fill = GridBagConstraints.HORIZONTAL;

        // Champs de saisie
        this.nomVente = new JTextField(20);
        this.nomdelaVente = new JLabel("Nom de la vente :");

        // Bouton
        this.supprimerVente = new JButton("Supprimer une Vente");
        this.supprimerVente.addActionListener(new supprimerVente());

        // Message
        this.messageLabel = new JLabel();
        this.messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.gridwidth = 2;
        this.add(nomdelaVente, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.gridwidth = 2; 
        this.add(nomVente, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 2; 
        gbc.gridwidth = 2; 
        this.add(supprimerVente, gbc);

        gbc.gridy = 3; 
        this.add(messageLabel, gbc);
	}
	
	class supprimerVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!nomVente.getText().isEmpty()) {
				//Supprimer les catalogues
				Modele.supprimerCatalogue(Modele.getlibelleCat(Modele.getidVente(nomVente.getText())));
				//Après la suppresion des catalogues et des id cat dans article catalogue supprime les ventes
				if (Modele.supprimerVente(nomVente.getText()) == true) {
					messageLabel.setForeground(Color.GREEN);
					messageLabel.setText("La vente a ete supprimer");
				}
				else {
					messageLabel.setForeground(Color.RED);
					messageLabel.setText("La vente n'a pas etait supprimer");
				}
			}
			else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Des champs sont vides");
			}
		}
		
	}
}
