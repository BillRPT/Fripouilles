package Vues.Secretaire.Catalogue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Modele.Modele;



public class V_supprimercataVente extends JPanel {
	
	private GridBagConstraints gbc;
	
	private JTextField nomCata;
	private JLabel nomdelaCata;
	
	private JButton supprimerVente;
	
	private JLabel messageLabel;
	
	public V_supprimercataVente() {
		setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        // Espacement uniforme
        this.gbc.insets = new Insets(10, 10, 10, 10);
        this.gbc.fill = GridBagConstraints.HORIZONTAL;

        // Champs de saisie et étiquettes
        this.nomCata = new JTextField(20);
        this.nomdelaCata = new JLabel("Nom du catalogue à supprimer de sa vente :");

        // Bouton pour supprimer
        this.supprimerVente = new JButton("Supprimer le catalogue de la vente");
        this.supprimerVente.addActionListener(new supprimercataVente());

        // Label pour afficher les messages
        this.messageLabel = new JLabel();
        this.messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Ajout des composants au panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(nomdelaCata, gbc);

        gbc.gridy = 1;
        this.add(nomCata, gbc);

        gbc.gridy = 2;
        this.add(supprimerVente, gbc);

        gbc.gridy = 3;
        this.add(messageLabel, gbc);
	}
	
	class supprimercataVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!nomCata.getText().isEmpty()) {
				 if (Modele.rechercherCatalogue(nomCata.getText()) == true) {
					 if (Modele.verifCatalogue(nomCata.getText()) == true) {
							Modele.suppirmercatadeVente(nomCata.getText());
							messageLabel.setForeground(Color.GREEN);
							messageLabel.setText("Le catalogue a ete supp de sa vente");
						}
						else {
							messageLabel.setForeground(Color.RED);
							messageLabel.setText("Le catalogue a ete supp de sa vente");
						}
				 }
				 else {
					 messageLabel.setForeground(Color.RED);
					 messageLabel.setText("Le catalogue n'existe pas");
				 }
			}
			else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Des champs sont vides");
			}
		}
		
	}
}
