package Vues.Secretaire.Consulter;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;

import Class.Catalogue;



public class V_consultercatalogue extends JPanel{
	
	private JPanel monPanel;
	private GridBagConstraints gbc;
	
	public V_consultercatalogue(ArrayList<Catalogue> lesCatalogue) {
		setLayout(new GridBagLayout());
		// Gestionnaire de répartition (pour ordonner les champs et boutons)
		this.gbc = new GridBagConstraints();
		
		this.gbc.insets = new Insets(5, 5, 5, 5); 
		this.gbc.fill = GridBagConstraints.HORIZONTAL; 
	}
}
