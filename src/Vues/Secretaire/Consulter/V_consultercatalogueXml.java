package Vues.Secretaire.Consulter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing. *;

import Class.Catalogue;

public class V_consultercatalogueXml extends JPanel{

	private GridBagConstraints gbc;
    private JTextArea monTextArea;
    private String rep;
	
	public V_consultercatalogueXml(ArrayList<Catalogue> lesCatalogue) {
		rep = "";

	    setLayout(new GridBagLayout());
	    this.gbc = new GridBagConstraints();

	    this.gbc.insets = new Insets(5, 5, 5, 5);
	    this.gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    monTextArea = new JTextArea(10, 90); 
        monTextArea.setEditable(false);  
        monTextArea.setLineWrap(true);   
        monTextArea.setWrapStyleWord(true);

	    for (Catalogue unCatalogue : lesCatalogue) {
	    	String xml = unCatalogue.toXML();

            rep = rep + xml + "\n";
	    }

	    monTextArea.setText(rep);

	    gbc.gridx = 0; 
	    gbc.gridy = 0; 
	    gbc.gridwidth = 2;
	    JScrollPane scrollPane = new JScrollPane(monTextArea);
	    this.add(scrollPane, gbc);
	}

}
