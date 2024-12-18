package Vues.Secretaire.Vente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Modele.Modele;

public class V_supprimevente extends JPanel{
	
	private JPanel monPanel;
	private GridBagConstraints gbc;
	
	private JTextField nomVente;
	private JLabel nomdelaVente;
	
	private JButton supprimerVente;
	
	
	public V_supprimevente() {
		setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.gbc.insets = new Insets(5, 5, 5, 5); 
        this.gbc.fill = GridBagConstraints.HORIZONTAL; 


        this.nomVente = new JTextField(20);
        this.nomdelaVente = new JLabel("Nom de la vente");


        this.supprimerVente = new JButton("Supprimer une Vente");
        this.supprimerVente.addActionListener(new supprimerVente());

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
	}
	
	class supprimerVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!nomVente.getText().isEmpty()) {
				//Supprimer les catalogues
				if (Modele.supprimerCatalogue(Modele.getlibelleCat(Modele.getidVente(nomVente.getText()))) == true) {
					//Après la suppresion des catalogues et des id cat dans article catalogue supprime les ventes
					if (Modele.supprimerVente(nomVente.getText()) == true) {
						JOptionPane.showMessageDialog(null, "La vente a ete supprimer");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "La vente n'a pas etait supprimer");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Des champs sont vides");
			}
		}
		
	}
}
