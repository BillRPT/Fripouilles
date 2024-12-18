package Vues.Secretaire.Benevole;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Modele.Modele;
public class V_ajouterunBenevole extends JPanel{
	
	private JPanel monPanel;
	private GridBagConstraints gbc;
	
	private JTextField nomBenevole;
	private JTextField prenomBenevole;
	private JTextField loginBenevole;
	private JPasswordField mdpBenevole;
	
	private JLabel nomduBenevole;
	private JLabel prenomduBenevole;
	private JLabel loginduBenevole;
	private JLabel mdpduBenevole;
	
	private JButton btnAjouterBenevole;
	
	public V_ajouterunBenevole() {
		setLayout(new GridBagLayout());
		// Gestionnaire de répartition (pour ordonner les champs et boutons)
		this.gbc = new GridBagConstraints();
		
		this.gbc.insets = new Insets(5, 5, 5, 5); 
		this.gbc.fill = GridBagConstraints.HORIZONTAL;
		
		// Champs de saisie
		this.nomBenevole = new JTextField(20);
		this.prenomBenevole = new JTextField(20);
		this.loginBenevole = new JTextField(20);
		this.mdpBenevole = new JPasswordField(20);
		
		this.nomduBenevole = new JLabel("Nom");
		this.prenomduBenevole = new JLabel("Prenom");
		this.loginduBenevole = new JLabel("Login");
		this.mdpduBenevole = new JLabel("Mot de passe");
		
		this.btnAjouterBenevole = new JButton("Ajouter un benevole");
		
		this.btnAjouterBenevole.addActionListener(new ajouterunBenevole());
		
		gbc.gridx = 0; gbc.gridy = 0;
	    this.add(nomduBenevole, gbc);
	    
	    gbc.gridx = 1; 
	    this.add(nomBenevole, gbc);
	    
	    // Prénom
	    gbc.gridx = 0; gbc.gridy = 1;
	    this.add(prenomduBenevole, gbc);
	    
	    gbc.gridx = 1; 
	    this.add(prenomBenevole, gbc); 

	    // Login
	    gbc.gridx = 0; gbc.gridy = 2;
	    this.add(loginduBenevole, gbc); 
	    
	    gbc.gridx = 1; 
	    this.add(loginBenevole, gbc); 

	    // Mot de passe
	    gbc.gridx = 0; gbc.gridy = 3;
	    this.add(mdpduBenevole, gbc); 
	    
	    gbc.gridx = 1; 
	    this.add(mdpBenevole, gbc); 

	    // Bouton Ajouter
	    gbc.gridx = 0; gbc.gridy = 4; 
	    gbc.gridwidth = 2;  // Le bouton doit occuper les deux colonnes
	    gbc.fill = GridBagConstraints.CENTER;  // Centrer le bouton
	    this.add(btnAjouterBenevole, gbc);
	}
	
	class ajouterunBenevole implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!nomBenevole.getText().isEmpty() && !prenomBenevole.getText().isEmpty() && !loginBenevole.getText().isEmpty() && mdpBenevole.getPassword().length != 0) {
				
				if (Modele.rechercherUtilisateur(loginBenevole.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Cette utilisateur existe deja");
				}
				else {
					Modele.ajouterBenevole(nomBenevole.getText(), prenomBenevole.getText(), loginBenevole.getText(), mdpBenevole.getPassword());
					JOptionPane.showMessageDialog(null, "Le benevole a ete ajoute");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Des champs sont vides");
			}
		}
		
	}
}
