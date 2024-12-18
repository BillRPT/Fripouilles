package Vues.Maire.Consulter;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class.VenteEphemere;

public class V_consulterstatistique extends JPanel{

	private JTable lesCatalogues;
	private  JScrollPane scrollPane;
	private GridBagConstraints gbc;
	
	public V_consulterstatistique(ArrayList<VenteEphemere> lesStat) {
		// Gestionnaire de répartition (pour ordonner les champs et boutons)
        this.gbc = new GridBagConstraints();
        
        this.gbc.insets = new Insets(5, 5, 5, 5);
	    
        Object data[][] = new Object[10][5];
	    String[] title = {"idVente", "DateVente", "TypeVente", "Article Vendu", "Etat Vente"};
	    
	    // Remplir le tableau avec les donn�es des catalogues
	    int i = 0;
	    for (VenteEphemere uneVente : lesStat) {
	    	data[i][0] = uneVente.getidVente();
	    	data[i][1] = uneVente.getdateEph();
	        data[i][2] = uneVente.gettypeVente();
	        data[i][3] = uneVente.getNbarticleVendu();
	        data[i][4] = uneVente.getEtatVente();
	        i++;
	    }
	    
	    lesCatalogues = new JTable(data, title);
	    
	    scrollPane = new JScrollPane(lesCatalogues);
	    
	    gbc.gridx = 0; gbc.gridy = 0;
        this.add(scrollPane, gbc);
	}
}
