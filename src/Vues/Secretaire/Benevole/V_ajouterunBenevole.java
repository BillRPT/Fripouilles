package Vues.Secretaire.Benevole;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Fonction.Fonction;
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
	
	private JLabel messageLabel;
	
	public V_ajouterunBenevole() {
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Marges autour des composants
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Champs de saisie
        nomBenevole = new JTextField(20);
        prenomBenevole = new JTextField(20);
        loginBenevole = new JTextField(20);
        mdpBenevole = new JPasswordField(20);

        // Labels
        nomduBenevole = new JLabel("Nom :");
        prenomduBenevole = new JLabel("Prenom :");
        loginduBenevole = new JLabel("Login :");
        mdpduBenevole = new JLabel("Mot de passe :");

        // Bouton Ajouter
        btnAjouterBenevole = new JButton("Ajouter un benevole");
        btnAjouterBenevole.addActionListener(new ajouterunBenevole());

        // Message
        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Ajout des composants à la grille
        gbc.gridx = 0; 
        gbc.gridy = 0;
        add(nomduBenevole, gbc);

        gbc.gridx = 1;
        add(nomBenevole, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 1;
        add(prenomduBenevole, gbc);

        gbc.gridx = 1;
        add(prenomBenevole, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 2;
        add(loginduBenevole, gbc);

        gbc.gridx = 1;
        add(loginBenevole, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 3;
        add(mdpduBenevole, gbc);

        gbc.gridx = 1;
        add(mdpBenevole, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Le bouton occupe toute la ligne
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnAjouterBenevole, gbc);

        gbc.gridy = 5; // Message sous le bouton
        add(messageLabel, gbc);
	}
	
	class ajouterunBenevole implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!nomBenevole.getText().isEmpty() && !prenomBenevole.getText().isEmpty() && !loginBenevole.getText().isEmpty() && mdpBenevole.getPassword().length != 0) {
				
				if (Fonction.checkPassword(mdpBenevole.getPassword())) {
					if (Modele.rechercherUtilisateur(loginBenevole.getText()) == true) {
						messageLabel.setForeground(Color.RED);
						messageLabel.setText("Cette utilisateur existe deja");
					}
					else {
						Modele.ajouterBenevole(nomBenevole.getText(), prenomBenevole.getText(), loginBenevole.getText(), mdpBenevole.getPassword());
						messageLabel.setForeground(Color.GREEN);
						messageLabel.setText("Le benevole a ete ajoute");
					}
				}
				else {
					messageLabel.setForeground(Color.RED);
					messageLabel.setText("Mot de passe trop faible !");
				}
			}
			else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Des champs sont vides");
			}
		}
		
	}
}
