package Vues.Secretaire.Consulter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class.Catalogue;

public class V_consultercataetlesVentes extends JPanel{
	
	private JTable lesVentestable;
	private  JScrollPane scrollPane;
	private GridBagConstraints gbc;
	
	public V_consultercataetlesVentes(ArrayList<Catalogue> lesCatalogue) {
		setLayout(new GridBagLayout());
        
        // Gestionnaire de rÃ©partition (pour ordonner les champs et boutons)
        this.gbc = new GridBagConstraints();
        
        this.gbc.insets = new Insets(5, 5, 5, 5);
	    
        Object data[][] = new Object[10][5];
	    String[] title = {"idCategorie", "LibelleVente", "dateCat", "etat" ,"sa Vente"};
	    
	    // Remplir le tableau avec les données des catalogues
	    int i = 0;
	    for (Catalogue leCatalogue : lesCatalogue) {
	    	data[i][0] = leCatalogue.getunidCategorie();
	    	data[i][1] = leCatalogue.getunLibelle();
	        data[i][2] = leCatalogue.getuneDate();
	        data[i][3] = leCatalogue.getunEtat();
	        data[i][4] = leCatalogue.getsaVente().getnomVente();
	        i++;
	    }
	    
	    lesVentestable = new JTable(data, title);
	    
	    scrollPane = new JScrollPane(lesVentestable);
	    
	    gbc.gridx = 0; gbc.gridy = 0;
        this.add(scrollPane, gbc);
	}
}
