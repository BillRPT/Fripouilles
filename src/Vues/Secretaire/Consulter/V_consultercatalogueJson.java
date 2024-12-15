package Vues.Secretaire.Consulter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Class.Catalogue;

public class V_consultercatalogueJson extends JPanel{
	
	private GridBagConstraints gbc;
	
	private JLabel monLabel;
	
	private String rep;
	
	public V_consultercatalogueJson(ArrayList<Catalogue> lesCatalogue) {
		
		rep = "<HTML>";
		
		setLayout(new GridBagLayout());
	    this.gbc = new GridBagConstraints();
	    
	    this.gbc.insets = new Insets(5, 5, 5, 5); 
	    this.gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    for (Catalogue unCatalogue : lesCatalogue) {
	        rep = rep + unCatalogue.toJSON() + "<br>";
	    }

	    rep = rep + "</HTML>";

	    this.monLabel = new JLabel(rep);

	    gbc.gridx = 0; 
	    gbc.gridy = 0; 
	    gbc.gridwidth = 2;
	    this.add(monLabel, gbc);
		
	}
}
