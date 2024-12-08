package Vues.Secretaire;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Vues.V_principal;
import Vues.Secretaire.Vente.V_ajoutervente;
import Vues.Secretaire.Vente.V_supprimevente;

public class V_menusecretaire extends JMenuBar{

	private V_ajoutervente V_ajouteruneVente;
	private V_supprimevente V_supprimeuneVente;
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
	
	
	public V_menusecretaire(V_ajoutervente unpanelajoutVente, V_supprimevente unpanelsupprimerVente, V_principal lavuePrincipal) {
		
		this.V_ajouteruneVente = unpanelajoutVente;
		this.V_supprimeuneVente = unpanelsupprimerVente;
		this.unevuePrincipal = lavuePrincipal;
		
		//Section des Ajouts
		menuAjouter = new JMenu("Ajouter");
		nouvelleVente = new JMenuItem("Ajouter une Vente");
		nouveauBenevole = new JMenuItem("Ajouter un Benevole");
		//Ecouter les diff�rents boutton
		nouvelleVente.addActionListener(new ajouterVente());
		//nouveauBenevole.addActionListener(new ajouterBenevole());
		menuAjouter.add(nouvelleVente);
		menuAjouter.add(nouveauBenevole);
		
		
		//Section des Consultations
		menuConsultere = new JMenu("Consulter");
		consulterCatalogue = new JMenuItem("Consulter les Catalogues");
		//consulterCatalogue.addActionListener(new choixSection());
		menuConsultere.add(consulterCatalogue);
		
		
		menuSupprimer = new JMenu("Supprimer");
		supprimerVente = new JMenuItem("Supprimer une vente");
		supprimerBenevole = new JMenuItem("Supprimer un benevole");
		supprimerVente.addActionListener(new supprimerVente());
		//supprimerBenevole.addActionListener(new choixSection());
		menuSupprimer.add(supprimerVente);
		menuSupprimer.add(supprimerBenevole);
		
		
		this.add(menuAjouter);
		this.add(menuConsultere);
		this.add(menuSupprimer);
		
	}
	
	//Class pour le action perfomed de ajouter une vente
	class ajouterVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(V_ajouteruneVente);  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	//Class pour le action perfomed de ajouter un benevole
	class supprimerVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(V_supprimeuneVente);  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
		}
		
	}
	
	
	
}
