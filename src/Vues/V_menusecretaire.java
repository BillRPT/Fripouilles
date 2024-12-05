package Vues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

public class V_menusecretaire extends JMenuBar{
	
	//Menu avec les items pour les ventes
	private JMenu menuVente;
	private JMenuItem nouvelleVente;
	
	
	//Menu avec les items pour les catalogues
	private JMenu menuCatalogue;
	private JMenuItem consulterCatalogue;
	
	
	//Menu avec les items pour les créations de bénévole
	private JMenu menuBenevole;
	private JMenuItem nouveauBenevole;
	
	
	public V_menusecretaire() {
		
		//Section des ventes
		menuVente = new JMenu("Vente");
		nouvelleVente = new JMenuItem("Créer une Vente");
		//Ecouter les différents boutton
		nouvelleVente.addActionListener(new choixSection());
		menuVente.add(nouvelleVente);
		
		
		//Section des catalogues
		menuCatalogue = new JMenu("Catalogue");
		consulterCatalogue = new JMenuItem("Consulter les Catalogues");
		consulterCatalogue.addActionListener(new choixSection());
		menuCatalogue.add(consulterCatalogue);
		
		//Section des benevoles
		menuBenevole = new JMenu("Benevole");
		nouveauBenevole = new JMenuItem("Créer un Bénévole");
		nouveauBenevole.addActionListener(new choixSection());
		menuBenevole.add(nouveauBenevole);
		
		
		
		this.add(menuVente);
		this.add(menuCatalogue);
		this.add(menuBenevole);
		
	}
	
	class choixSection implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == nouvelleVente) {
				System.out.println("salut");
			}
		}
		
	}
	
}
