package Vues;

import javax.swing.*;

import Controleurs.*;
import Fonction.Fonction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_connexion extends JFrame {

    // ATTRIBUTS
	private C_connexion cConnex;
    private C_pbenevole cPBenevole;
    private C_psecretaire cPSecretaire;
    private C_principal uncPrincipal;
    private String roleUser;
	
    private JPanel contentPanel;
    private JLabel labelLogo;
    private JLabel labelPseudo;
    private JLabel labelMdp;
    private JTextField fieldPseudo;
    private JPasswordField fieldMdp;
    private JButton btnValider;

    //------------------------constructeur------------------------------
    public V_connexion(C_connexion cConnexion, C_pbenevole cPBenevole, C_psecretaire cPSecretaire, C_principal lecPrincipal) {
    	this.uncPrincipal = lecPrincipal;
    	this.cConnex = cConnexion;
    	this.cPBenevole = cPBenevole;
    	this.cPSecretaire = cPSecretaire;
    	
        // Param�tres de la fen�tre
        this.setTitle("Fripouilles - Connexion");
        this.setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Cr�ation du panneau principal
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPanel);

        // Logo
        labelLogo = new JLabel(Fonction.resizeImageIcon(new ImageIcon("images/fripouilles_logo.png"), 325,170)); // Redimensionne l'image gr�ce � ma m�thode dans le mod�le
        labelLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelLogo);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espace entre les �l�ments

        // Label et champ de texte pour le pseudonyme
        labelPseudo = new JLabel("Login :");
        labelPseudo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelPseudo);

        fieldPseudo = new JTextField(15);
        fieldPseudo.setMaximumSize(new Dimension(200, 30));
        contentPanel.add(fieldPseudo);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espace entre les �l�ments

        // Label et champ de texte pour le mot de passe
        labelMdp = new JLabel("Mot de passe :");
        labelMdp.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(labelMdp);

        //Un JPasswordField pour plus de sécurité au niveau des mots de passe, c'est-à-dire que le mot de passe ne sera pas stocké en clair en mémoire.
        fieldMdp = new JPasswordField(15);
        fieldMdp.setMaximumSize(new Dimension(200, 30));
        contentPanel.add(fieldMdp);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Espace entre les �l�ments

        // Bouton de validation
        btnValider = new JButton("Connexion");
        btnValider.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(btnValider);
        btnValider.addActionListener(new AfficherPgPrincipale());

        setVisible(false);
    }
    
    class AfficherPgPrincipale implements ActionListener{
    	
        public void actionPerformed(ActionEvent e) {
        	//verification connexion + ouvrir les vues celon le role
        	if (e.getSource() == btnValider && !fieldPseudo.getText().isEmpty() && fieldMdp.getPassword().length != 0) {
        		if(cConnex.verifierConnexion(fieldPseudo.getText(), fieldMdp.getPassword()) == true) {
        			JOptionPane.showMessageDialog(null, "Bienvenue !");
        			//Fermer la vue et afficher la vue du menu
        			cConnex.fermervConnexion();
        			roleUser = cConnex.verifierRole(fieldPseudo.getText(), fieldMdp.getPassword());
        			
        			if (roleUser.equals("benevole")) {
        				cPBenevole.affichervPrincipal();
        			}
        			else {
        				if (roleUser.equals("secretaire")) {
        					uncPrincipal.affichervPrincipal();
        				}
        				else {
        					if (roleUser.equals("maire")) {
        						System.out.println("maire");
        					}
        					else {
        						JOptionPane.showMessageDialog(null, "L'utilisateur n'a aucun r le d'attribu .");
                				System.out.println(cConnex.verifierRole(fieldPseudo.getText(), fieldMdp.getPassword()));
        					}
        				}
        			}
        			
                }else {
        			JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect.");
        		}
        		
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "Des champs sont vides.");
        	}
        }

    }
    
}
    