package Vues.Secretaire.Catalogue;

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

import Modele.Modele;



public class V_supprimercataVente extends JPanel {
	
	private GridBagConstraints gbc;
	
	private JTextField nomCata;
	private JLabel nomdelaCata;
	
	private JButton supprimerVente;
	
	public V_supprimercataVente() {
		setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.gbc.insets = new Insets(5, 5, 5, 5); 
        this.gbc.fill = GridBagConstraints.HORIZONTAL; 


        this.nomCata = new JTextField(20);
        this.nomdelaCata = new JLabel("Nom du catalogue a supp de sa vente");


        this.supprimerVente = new JButton("Supprimer une cata de sa vente");
        this.supprimerVente.addActionListener(new supprimercataVente());

        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.gridwidth = 2;
        this.add(nomdelaCata, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 1; 
        gbc.gridwidth = 2; 
        this.add(nomCata, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 2; 
        gbc.gridwidth = 2; 
        this.add(supprimerVente, gbc);
	}
	
	class supprimercataVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!nomCata.getText().isEmpty()) {
				 if (Modele.rechercherCatalogue(nomCata.getText()) == true) {
					 if (Modele.verifCatalogue(nomCata.getText()) == true) {
							Modele.suppirmercatadeVente(nomCata.getText());
							JOptionPane.showMessageDialog(null, "Le catalogue a ete supp de sa vente");
						}
						else {
							JOptionPane.showMessageDialog(null, "Le catalogue est dans aucune vente");
						}
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Le catalogue n'existe pas");
				 }
			}
			else {
				JOptionPane.showMessageDialog(null, "Des champs sont vides");
			}
		}
		
	}
}
