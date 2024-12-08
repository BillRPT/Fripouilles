package Vues.Secretaire.Vente;

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

import Fonction.Fonction;
import Modele.Modele;

public class V_ajoutervente extends JPanel{
	
	private JPanel monPanel;
	private GridBagConstraints gbc;
	
	private JTextField nomVente;
	private JTextField dateVente;
	private JTextField typeVente;
	
	private JLabel nomdelaVente;
	private JLabel datedelaVente;
	private JLabel typedelaVente;
	
	private JButton btnAjouterVente;
	
	public V_ajoutervente() {
		setLayout(new GridBagLayout());
		// Gestionnaire de répartition (pour ordonner les champs et boutons)
		this.gbc = new GridBagConstraints();

		this.gbc.insets = new Insets(5, 5, 5, 5); 
		this.gbc.fill = GridBagConstraints.HORIZONTAL; 

		// Champs de saisie
		this.nomVente = new JTextField(20);
		this.dateVente = new JTextField(20);
		this.typeVente = new JTextField(20);

		// Étiquettes
		this.nomdelaVente = new JLabel("Nom de la vente");
		this.datedelaVente = new JLabel("Date de la vente");
		this.typedelaVente = new JLabel("Type de la vente");

		// Bouton
		this.btnAjouterVente = new JButton("Ajouter Vente");
		
		this.btnAjouterVente.addActionListener(new valideruneVente());

		//Positionnement des elements dans le panel avec gbc -> https://bbclone.developpez.com/fr/java/tutoriels/uiswing/gridbaglayout/?page=page_3
		gbc.gridx = 0; gbc.gridy = 0;
		this.add(nomdelaVente, gbc);

		gbc.gridx = 1;
		this.add(nomVente, gbc);

		gbc.gridx = 0; gbc.gridy = 1;
		this.add(datedelaVente, gbc);

		gbc.gridx = 1;
		this.add(dateVente, gbc); 

		gbc.gridx = 0; gbc.gridy = 2;
		this.add(typedelaVente, gbc); 

		gbc.gridx = 1;
		this.add(typeVente, gbc); 

		
		gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
		this.add(btnAjouterVente, gbc);

	}
	
	class valideruneVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!nomVente.getText().isEmpty() && !dateVente.getText().isEmpty() && !typeVente.getText().isEmpty()) {
				if (Fonction.verifDate(dateVente.getText()) == true) {
					
					Modele.ajouterVente(nomVente.getText(), dateVente.getText(), typeVente.getText());
					JOptionPane.showMessageDialog(null, "La vente a ete inseree");
				}
				else {
					JOptionPane.showMessageDialog(null, "La date doit etre sous la forme de AAAA-MM-JJ");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Des champs sont vides !");
			}
		}
		
	}
}
