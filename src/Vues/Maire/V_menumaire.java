package Vues.Maire;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controleurs.C_pmaire;

public class V_menumaire extends JMenuBar{
	
	private C_pmaire uncontroleurMaire;
	
	private JMenu menuConsulter;
	private JMenuItem consulterCatalogue;
	private JMenuItem consulterStatistique;
	
	public V_menumaire(C_pmaire lecontroleurMaire) {
		this.uncontroleurMaire = lecontroleurMaire;
		
		menuConsulter = new JMenu("Catalogue");
		consulterCatalogue = new JMenuItem("Consulter les catalogues");
		consulterStatistique = new JMenuItem("Consulter les statistiques");
		menuConsulter.add(consulterCatalogue);
		menuConsulter.add(consulterStatistique);
		
		this.add(menuConsulter);
	}
}
