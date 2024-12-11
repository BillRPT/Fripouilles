package Vues.Secretaire.Benevole;

import java.awt. *;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Modele.Modele;

public class V_supprimerBenevole extends JPanel{
	
	private JPanel monPanel;
	private GridBagConstraints gbc;
	
	private String loginUser;
	
	private JLabel labelloginUser;
	
	private JTextField textloginUser;
	
	private JButton btnSupprimerBenevole;
	
	public V_supprimerBenevole() {
		setLayout(new GridBagLayout());
        
        // Gestionnaire de répartition (pour ordonner les champs et boutons)
        this.gbc = new GridBagConstraints();
        
        // Marges entre les composants
        this.gbc.insets = new Insets(5, 5, 5, 5);
        
        // Champs de texte et labels
        this.textloginUser = new JTextField(20);
        this.labelloginUser = new JLabel("Login");
        
        // Bouton pour supprimer un bénévole
        this.btnSupprimerBenevole = new JButton("Supprimer le benevole");
        
        this.btnSupprimerBenevole.addActionListener(new supprimerBenevole());
        
        // Placement des composants
        
        // Label "Login"
        gbc.gridx = 0; gbc.gridy = 0;
        this.add(labelloginUser, gbc);
        
        // Champ de texte pour le login
        gbc.gridx = 1; gbc.gridy = 0;
        this.add(textloginUser, gbc);
        
        // Bouton pour supprimer
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;  // Le bouton doit occuper les deux colonnes
        gbc.fill = GridBagConstraints.CENTER;  // Centrer le bouton
        this.add(btnSupprimerBenevole, gbc);
		
	}
	
	class supprimerBenevole implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!textloginUser.getText().isEmpty()) {
				if (Modele.supprimerBenevole(textloginUser.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Le benevole a ete supp");
				}
				else {
					JOptionPane.showMessageDialog(null, "Le benevole n'existe pas");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Des champs sont vides");
			}
		}
		
	}
}
