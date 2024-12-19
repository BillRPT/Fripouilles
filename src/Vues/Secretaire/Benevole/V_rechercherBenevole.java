package Vues.Secretaire.Benevole;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Modele.Modele;

public class V_rechercherBenevole extends JPanel{
	
	private JPanel monPanel;
	private GridBagConstraints gbc;
	
	private JTextField nomVente;
	private JLabel nomdelaVente;
	
	private JButton rechercherVente;
	
	private JLabel messageLabel;
	
	public V_rechercherBenevole() {
		setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();

        this.gbc.insets = new Insets(5, 5, 5, 5); 
        this.gbc.fill = GridBagConstraints.HORIZONTAL; 


        this.nomVente = new JTextField(20);
        this.nomdelaVente = new JLabel("Nom du benevole");


        this.rechercherVente = new JButton("Rechercher un benevole");
        this.rechercherVente.addActionListener(new rechercherBenevole());

        
        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(messageLabel, gbc);
        
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
	
	class rechercherBenevole implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			messageLabel.setText("");
			if (!nomVente.getText().isEmpty()) {
				if (Modele.rechercherBenevole(nomVente.getText()) == true) {
					messageLabel.setForeground(Color.GREEN);
					messageLabel.setText("Le benevole exist");
				}
				else {
					messageLabel.setForeground(Color.RED);
					messageLabel.setText("Le benevole existe pas");
				}
			}
			else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Des champs sont vides");
			}
		}
		
	}
}
