package Vues.Secretaire.Consulter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing. *;
import Class.Catalogue;
import Class.VenteEphemere;

public class V_consultervente extends JPanel{
	
	private JPanel monPanel;
	private JTable lesVentestable;
	private  JScrollPane scrollPane;
	private GridBagConstraints gbc;
	
	public V_consultervente(ArrayList<VenteEphemere> lesVentes) {
		setLayout(new GridBagLayout());
        
        // Gestionnaire de rÃ©partition (pour ordonner les champs et boutons)
        this.gbc = new GridBagConstraints();
        
        this.gbc.insets = new Insets(5, 5, 5, 5);
	    
        Object data[][] = new Object[10][4];
	    String[] title = {"idVenteEphemere", "nomVente", "Type vente", "Date"};
	    
	    // Remplir le tableau avec les données des catalogues
	    int i = 0;
	    for (VenteEphemere uneVente : lesVentes) {
	    	data[i][0] = uneVente.getidVente();
	    	data[i][1] = uneVente.getnomVente();
	        data[i][2] = uneVente.gettypeVente();
	        data[i][3] = uneVente.getdateEph();
	        i++;
	    }
	    
	    lesVentestable = new JTable(data, title);
	    
	    scrollPane = new JScrollPane(lesVentestable);
	    
	    gbc.gridx = 0; gbc.gridy = 0;
        this.add(scrollPane, gbc);
	}
}
