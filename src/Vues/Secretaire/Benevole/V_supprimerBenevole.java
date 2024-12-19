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
	
	private JLabel messageLabel;
	
	public V_supprimerBenevole() {
		setLayout(new GridBagLayout());

        // Gestionnaire de répartition (pour ordonner les champs et boutons)
        this.gbc = new GridBagConstraints();

        // Marges entre les composants
        this.gbc.insets = new Insets(10, 10, 10, 10);
        this.gbc.fill = GridBagConstraints.HORIZONTAL;

        // Champs de texte et labels
        this.textloginUser = new JTextField(20);
        this.labelloginUser = new JLabel("Login :");

        // Bouton pour supprimer un bénévole
        this.btnSupprimerBenevole = new JButton("Supprimer le bénévole");
        this.btnSupprimerBenevole.addActionListener(new supprimerBenevole());

        // Label pour afficher les messages
        this.messageLabel = new JLabel();
        this.messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Placement des composants

        // Label "Login"
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(labelloginUser, gbc);

        // Champ de texte pour le login
        gbc.gridx = 1;
        this.add(textloginUser, gbc);

        // Bouton pour supprimer
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Le bouton doit occuper les deux colonnes
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(btnSupprimerBenevole, gbc);

        // Message d'erreur ou de confirmation
        gbc.gridy = 2; // En dessous du bouton
        gbc.gridwidth = 2; // S'étend sur deux colonnes
        this.add(messageLabel, gbc);
		
	}
	
	class supprimerBenevole implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!textloginUser.getText().isEmpty()) {
				if (Modele.verifierRole(textloginUser.getText()) == true) {
					Modele.supprimerBenevole(textloginUser.getText());
					 messageLabel.setForeground(Color.GREEN);
	                 messageLabel.setText("Le bénévole a été supprimé.");
				}
				else {
					messageLabel.setForeground(Color.RED);
                    messageLabel.setText("Le bénévole n'existe pas ou n'est pas un bénévole.");
				}
			}
			else {
				messageLabel.setForeground(Color.RED);
                messageLabel.setText("Des champs sont vides");
			}
		}
		
	}
}
