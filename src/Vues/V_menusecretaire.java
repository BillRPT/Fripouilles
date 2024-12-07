package Vues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

public class V_menusecretaire extends JMenuBar{
	
	private V_creervente afficherpanelajoutVente;
	private V_principal unevuePrincipal;
	
	//Menu avec les items pour les ventes
	private JMenu menuAjouter;
	private JMenuItem nouvelleVente;
	private JMenuItem nouveauBenevole;
	
	//Menu avec les items pour les consultations
	private JMenu menuConsultere;
	private JMenuItem consulterCatalogue;
	
	
	//Menu avec les items pour les consultations
	private JMenu menuSupprimer;
	private JMenuItem supprimerVente;
	private JMenuItem supprimerBenevole;
	
	
	public V_menusecretaire(V_creervente unpanelajoutVente, V_principal lavuePrincipal) {
		
		this.afficherpanelajoutVente = unpanelajoutVente;
		this.unevuePrincipal = lavuePrincipal;
		
		//Section des Ajouts
		menuAjouter = new JMenu("Ajouter");
		nouvelleVente = new JMenuItem("Ajouter une Vente");
		nouveauBenevole = new JMenuItem("Ajouter un Benevole");
		//Ecouter les diff�rents boutton
		nouvelleVente.addActionListener(new choixSection());
		nouveauBenevole.addActionListener(new choixSection());
		menuAjouter.add(nouvelleVente);
		menuAjouter.add(nouveauBenevole);
		
		
		//Section des Consultations
		menuConsultere = new JMenu("Consulter");
		consulterCatalogue = new JMenuItem("Consulter les Catalogues");
		consulterCatalogue.addActionListener(new choixSection());
		menuConsultere.add(consulterCatalogue);
		
		
		menuSupprimer = new JMenu("Supprimer");
		supprimerVente = new JMenuItem("Supprimer une vente");
		supprimerBenevole = new JMenuItem("Supprimer un benevole");
		supprimerVente.addActionListener(new choixSection());
		supprimerBenevole.addActionListener(new choixSection());
		menuSupprimer.add(supprimerVente);
		menuSupprimer.add(supprimerBenevole);
		
		
		this.add(menuAjouter);
		this.add(menuConsultere);
		this.add(menuSupprimer);
		
	}
	
	//Action perfomed
	class choixSection implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == nouvelleVente) {
				unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

	            // Ajoute le panel de ventee
	            unevuePrincipal.add(afficherpanelajoutVente);  

	            unevuePrincipal.revalidate();
	            unevuePrincipal.repaint();
			}
		}
		
	}
	
}
