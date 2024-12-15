package Vues.Secretaire.Consulter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Class.Catalogue;
import Class.VenteEphemere;

public class V_consulterventeXml extends JPanel{
	
	private GridBagConstraints gbc;
    private JTextArea monTextArea;
    private String rep;
	
	public V_consulterventeXml(ArrayList<VenteEphemere> lesVentes) {
		rep = "";

	    setLayout(new GridBagLayout());
	    this.gbc = new GridBagConstraints();

	    this.gbc.insets = new Insets(5, 5, 5, 5);
	    this.gbc.fill = GridBagConstraints.HORIZONTAL;
	    
	    monTextArea = new JTextArea(10, 90); 
        monTextArea.setEditable(false);  
        monTextArea.setLineWrap(true);   
        monTextArea.setWrapStyleWord(true);

	    for (VenteEphemere uneVente : lesVentes) {
	    	String xml = uneVente.toXML();

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
