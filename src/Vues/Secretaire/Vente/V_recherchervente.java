package Vues.Secretaire.Vente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Modele.Modele;
import Vues.Secretaire.Vente.V_supprimevente.supprimerVente;

public class V_recherchervente extends JPanel{
	
	
	private JPanel monPanel;
	private GridBagConstraints gbc;
	
	private JTextField nomVente;
	private JLabel nomdelaVente;
	
	private JButton rechercherVente;
	
	public V_recherchervente() {
		setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.gbc.insets = new Insets(5, 5, 5, 5); 
        this.gbc.fill = GridBagConstraints.HORIZONTAL; 


        this.nomVente = new JTextField(20);
        this.nomdelaVente = new JLabel("Nom de la vente");


        this.rechercherVente = new JButton("Rechercher une Vente");
        this.rechercherVente.addActionListener(new rechercherVente());

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
        this.add(rechercherVente, gbc);
	}
	
	class rechercherVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!nomVente.getText().isEmpty()) {
				if (Modele.rechercherVente(nomVente.getText()) == true) {
					JOptionPane.showMessageDialog(null, "La vente existe");
				}
				else {
					JOptionPane.showMessageDialog(null, "La vente existe pas");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Des champs sont vides");
			}
		}
		
	}
}
