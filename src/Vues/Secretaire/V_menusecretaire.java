package Vues.Secretaire;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Vues.V_principal;
import Vues.Secretaire.Benevole.V_ajouterunBenevole;
import Vues.Secretaire.Benevole.V_supprimerBenevole;
import Vues.Secretaire.Consulter.V_consultercatalogue;
import Vues.Secretaire.Consulter.V_consultervente;
import Vues.Secretaire.Vente.V_ajoutervente;
import Vues.Secretaire.Vente.V_recherchervente;
import Vues.Secretaire.Vente.V_supprimevente;

public class V_menusecretaire extends JMenuBar{

	private V_ajoutervente V_ajouteruneVente;
	private V_supprimevente V_supprimeuneVente;
	private V_principal unevuePrincipal;
	private V_ajouterunBenevole V_ajouterBenevole;
	private V_supprimerBenevole V_supprimerunBenevole;
	private V_consultercatalogue V_consulterlesCatalogues;
	private V_recherchervente V_rechercheruneVente;
	private V_consultervente V_consulterlesVentes;
	
	//Menu avec les items pour les ventes
	private JMenu menuAjouter;
	private JMenuItem nouvelleVente;
	private JMenuItem nouveauBenevole;
	
	//Menu avec les items pour les consultations
	private JMenu menuConsulter;
	private JMenuItem consulterCatalogue;
	private JMenuItem consulterVente;
	
	
	//Menu avec les items pour les consultations
	private JMenu menuSupprimer;
	private JMenuItem supprimerVente;
	private JMenuItem supprimerBenevole;
	
	private JMenu menuRechercher;
	private JMenuItem rechercherVente;
	private JMenuItem rechercherBenevole;
	
	
	public V_menusecretaire(V_ajoutervente unpanelajoutVente, V_supprimevente unpanelsupprimerVente, V_ajouterunBenevole unpanelajouterBenevole, V_supprimerBenevole  unpanelsupprimerBenevole, V_consultercatalogue V_consulterunCatalogue, V_recherchervente V_rechercherVente, V_consultervente V_consulterVente,V_principal lavuePrincipal) {
		
		this.V_ajouteruneVente = unpanelajoutVente;
		this.V_supprimeuneVente = unpanelsupprimerVente;
		this.unevuePrincipal = lavuePrincipal;
		this.V_ajouterBenevole = unpanelajouterBenevole;
		this.V_supprimerunBenevole = unpanelsupprimerBenevole;
		this.V_consulterlesCatalogues = V_consulterunCatalogue;
		this.V_rechercheruneVente = V_rechercherVente;
		this.V_consulterlesVentes = V_consulterVente;
		
		//Section des Ajouts
		menuAjouter = new JMenu("Ajouter");
		nouvelleVente = new JMenuItem("Ajouter une Vente");
		nouveauBenevole = new JMenuItem("Ajouter un Benevole");
		//Ecouter les diff�rents boutton
		nouvelleVente.addActionListener(new ajouterVente());
		nouveauBenevole.addActionListener(new ajouterBenevole());
		menuAjouter.add(nouvelleVente);
		menuAjouter.add(nouveauBenevole);
		
		
		//Section des Consultations
		menuConsulter = new JMenu("Consulter");
		consulterCatalogue = new JMenuItem("Consulter les Catalogues");
		consulterVente = new JMenuItem("Consulter les Ventes");
		consulterCatalogue.addActionListener(new consulterCatalogue());
		consulterVente.addActionListener(new consulterVente());
		menuConsulter.add(consulterCatalogue);
		menuConsulter.add(consulterVente);
		
		
		//Section des suppresions
		menuSupprimer = new JMenu("Supprimer");
		supprimerVente = new JMenuItem("Supprimer une vente");
		supprimerBenevole = new JMenuItem("Supprimer un benevole");
		supprimerVente.addActionListener(new supprimerVente());
		supprimerBenevole.addActionListener(new supprimerBenevole());
		menuSupprimer.add(supprimerVente);
		menuSupprimer.add(supprimerBenevole);
		
		menuRechercher = new JMenu("Rechercher");
		rechercherVente = new JMenuItem("Rechercher une vente");
		rechercherBenevole = new JMenuItem("Rechecher un benevole");
		rechercherVente.addActionListener(new rechercherVente());
		menuRechercher.add(rechercherVente);
		menuRechercher.add(rechercherBenevole);
		
		
		this.add(menuAjouter);
		this.add(menuConsulter);
		this.add(menuSupprimer);
		this.add(menuRechercher);
		
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
	
	class ajouterBenevole implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(V_ajouterBenevole);  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
		}
		
	}
	
	class supprimerBenevole implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(V_supprimerunBenevole);  

            //Refresh tout
            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
		}
		
	}
	
	class consulterCatalogue implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(V_consulterlesCatalogues);  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consulterVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(V_consulterlesVentes);  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class rechercherVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(V_rechercheruneVente);  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	
	
}
