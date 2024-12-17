package Vues.Secretaire.Consulter;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing. *;

import Class.Catalogue;
import Class.Utilisateur;

public class V_consulterbenevole extends JPanel{
	
	private JPanel monPanel;
	private JTable lesCatalogues;
	private  JScrollPane scrollPane;
	private GridBagConstraints gbc;
	
	public V_consulterbenevole(ArrayList<Utilisateur> lesUtilisateurs) {
		// Gestionnaire de rÃ©partition (pour ordonner les champs et boutons)
        this.gbc = new GridBagConstraints();
        
        this.gbc.insets = new Insets(5, 5, 5, 5);
	    
        Object data[][] = new Object[10][3];
	    String[] title = {"Nom", "Prenom", "Login"};
	    
	    // Remplir le tableau avec les données des catalogues
	    int i = 0;
	    for (Utilisateur unUtilisateur : lesUtilisateurs) {
	    	data[i][0] = unUtilisateur.getunNom();
	    	data[i][1] = unUtilisateur.getunPrenom();
	        data[i][2] = unUtilisateur.getunloginUser();
	        i++;
	    }
	    
	    lesCatalogues = new JTable(data, title);
	    
	    scrollPane = new JScrollPane(lesCatalogues);
	    
	    gbc.gridx = 0; gbc.gridy = 0;
        this.add(scrollPane, gbc);
	}
}
