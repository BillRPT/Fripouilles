package Vues.Maire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Controleurs.C_pmaire;
import Vues.V_principal;

public class V_menumaire extends JMenuBar{
	
	private C_pmaire uncontroleurMaire;
	
	private JMenu menuConsulter;
	private JMenuItem consulterCatalogue;
	private JMenuItem consulterCatalogueCsv;
	private JMenuItem consulterCatalogueXml;
	private JMenuItem consulterCatalogueJson;
	private JMenuItem consulterStatistique;
	
	private V_principal unevuePrincipal;
	
	public V_menumaire(C_pmaire lecontroleurMaire, V_principal lavuePrincipal) {
		this.uncontroleurMaire = lecontroleurMaire;
		this.unevuePrincipal = lavuePrincipal;
		
		menuConsulter = new JMenu("Consulter");
		consulterCatalogue = new JMenuItem("Consulter les catalogues");
		consulterCatalogueCsv = new JMenuItem("Consulter les catalogues Csv");
		consulterCatalogueXml = new JMenuItem("Consulter les catalogues Xml");
		consulterCatalogueJson = new JMenuItem("Consulter les catalogues Json");
		consulterStatistique = new JMenuItem("Consulter les statistiques");
		consulterCatalogue.addActionListener(new consulterCatalogue());
		consulterCatalogueCsv.addActionListener(new consulterCatalogueCsv());
		consulterCatalogueXml.addActionListener(new consulterCatalogueXml());
		consulterCatalogueJson.addActionListener(new consulterCatalogueJson());
		menuConsulter.add(consulterCatalogue);
		menuConsulter.add(consulterCatalogueCsv);
		menuConsulter.add(consulterCatalogueXml);
		menuConsulter.add(consulterCatalogueJson);
		menuConsulter.add(consulterStatistique);
		
		this.add(menuConsulter);
	}
	
	class consulterCatalogue implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee avec cette m�thode pour refresh le JTable
            unevuePrincipal.add(uncontroleurMaire.refreshtableCatalogue());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consulterCatalogueCsv implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee avec cette m�thode pour refresh le JTable
            unevuePrincipal.add(uncontroleurMaire.refreshcatalogueCsv());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consulterCatalogueXml implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee avec cette m�thode pour refresh le JTable
            unevuePrincipal.add(uncontroleurMaire.refreshcatalogueXml());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consulterCatalogueJson implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee avec cette m�thode pour refresh le JTable
            unevuePrincipal.add(uncontroleurMaire.refreshcatalogueJson());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
}
