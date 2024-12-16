package Vues.Maire.Consulter;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class.Catalogue;



public class V_consultercatalogue extends JPanel{
	
	private JPanel monPanel;
	private JTable lesCatalogues;
	private  JScrollPane scrollPane;
	private GridBagConstraints gbc;
	
	public V_consultercatalogue(ArrayList<Catalogue> lesCatalogue) {
		
		setLayout(new GridBagLayout());
        
        // Gestionnaire de répartition (pour ordonner les champs et boutons)
        this.gbc = new GridBagConstraints();
        
        this.gbc.insets = new Insets(5, 5, 5, 5);
	    
        Object data[][] = new Object[10][4];
	    String[] title = {"idCategorie", "idVenteEphemere", "Libelle", "Date"};
	    
	    // Remplir le tableau avec les donn�es des catalogues
	    int i = 0;
	    for (Catalogue unCatalogue : lesCatalogue) {
	    	data[i][0] = unCatalogue.getunidCategorie();
	    	data[i][1] = unCatalogue.getunidventeEphemere();
	        data[i][2] = unCatalogue.getunLibelle();
	        data[i][3] = unCatalogue.getuneDate();
	        i++;
	    }
	    
	    lesCatalogues = new JTable(data, title);
	    
	    scrollPane = new JScrollPane(lesCatalogues);
	    
	    gbc.gridx = 0; gbc.gridy = 0;
        this.add(scrollPane, gbc);
	}

}
