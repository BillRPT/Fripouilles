package Vues.Secretaire;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing. *;

import Controleurs.C_psecretaire;
import Vues.V_principal;
import Vues.Secretaire.Benevole.V_ajouterunBenevole;
import Vues.Secretaire.Benevole.V_rechercherBenevole;
import Vues.Secretaire.Benevole.V_supprimerBenevole;
import Vues.Secretaire.Consulter.V_consultercatalogueXml;
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
	private V_recherchervente V_rechercheruneVente;
	private V_rechercherBenevole V_rechercherunBenevole;
	
	//Controleur secretaire
	private C_psecretaire uncontroleurSecretaire;
	
	//Menu avec les items pour les ventes
	private JMenu menuAjouter;
	private JMenuItem nouvelleVente;
	private JMenuItem nouveauBenevole;
	
	//Menu avec les items pour les consultations
	private JMenu menuConsulter;
	private JMenuItem consulterCatalogue;
	private JMenuItem consulterVente;
	private JMenuItem consulterCatalogueXml;
	private JMenuItem consulterCatalogueJson;
	private JMenuItem consulterCatalogueCsv;
	private JMenuItem consulterVenteXml;
	private JMenuItem consulterVenteJson;
	private JMenuItem consulterVenteCsv;
	private JMenuItem consulterCatalogueHistorique;
	private JMenuItem consulterBenevole;
	
	//Menu avec les items pour les consultations
	private JMenu menuSupprimer;
	private JMenuItem supprimerVente;
	private JMenuItem supprimerBenevole;
	
	private JMenu menuRechercher;
	private JMenuItem rechercherVente;
	private JMenuItem rechercherBenevole;
	
	
	public V_menusecretaire(C_psecretaire lecontroleurSecretaire, V_ajoutervente unpanelajoutVente, V_supprimevente unpanelsupprimerVente, V_ajouterunBenevole unpanelajouterBenevole, V_supprimerBenevole  unpanelsupprimerBenevole, V_recherchervente V_rechercherVente, V_rechercherBenevole V_rechercherleBenevole,V_principal lavuePrincipal) {
		
		this.V_ajouteruneVente = unpanelajoutVente;
		this.V_supprimeuneVente = unpanelsupprimerVente;
		this.unevuePrincipal = lavuePrincipal;
		this.V_ajouterBenevole = unpanelajouterBenevole;
		this.V_supprimerunBenevole = unpanelsupprimerBenevole;
		this.V_rechercheruneVente = V_rechercherVente;
		this.uncontroleurSecretaire = lecontroleurSecretaire;
		this.V_rechercherunBenevole = V_rechercherleBenevole;
		
		
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
		consulterVente = new JMenuItem("Consulter les Ventes");
		consulterCatalogueXml = new JMenuItem("Consulter les histo Catalogues XML");
		consulterCatalogueJson = new JMenuItem("Consulter les histo Catalogues JSON");
		consulterCatalogueCsv = new JMenuItem("Consulter les histo Catalogues Csv");
		consulterVenteXml = new JMenuItem("Consulter les Ventes Xml");
		consulterVenteJson = new JMenuItem("Consulter les Ventes Json");
		consulterVenteCsv = new JMenuItem("Consulter les Ventes Csv");
		consulterCatalogueHistorique = new JMenuItem("Consulter les historiques des catalogues");
		consulterBenevole = new JMenuItem("Consulter les benevoles");
		consulterCatalogueHistorique.addActionListener(new consulterhistoriqueCatalogue());
		consulterVenteCsv.addActionListener(new consulterVenteCsv());
		consulterVenteJson.addActionListener(new consulterventeJson());
		consulterVenteXml.addActionListener(new consulterventeXml());
		consulterVente.addActionListener(new consulterVente());
		consulterCatalogueXml.addActionListener(new consultercatalogueXml());
		consulterCatalogueJson.addActionListener(new consultercatalogueJson());
		consulterCatalogueCsv.addActionListener(new consultercatalogueCsv());
		consulterBenevole.addActionListener(new consulterBenevole());
		menuConsulter.add(consulterVente);
		menuConsulter.add(consulterCatalogueXml);
		menuConsulter.add(consulterCatalogueJson);
		menuConsulter.add(consulterCatalogueCsv);
		menuConsulter.add(consulterVenteXml);
		menuConsulter.add(consulterVenteJson);
		menuConsulter.add(consulterVenteCsv);
		menuConsulter.add(consulterCatalogueHistorique);
		menuConsulter.add(consulterBenevole);
		
		
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
		rechercherBenevole.addActionListener(new rechercherBenevole());
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
	
	class consulterVente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee avec cette m�thode pour refresh le JTable
            unevuePrincipal.add(uncontroleurSecretaire.refreshtableVente());  

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
	
	class rechercherBenevole implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(V_rechercherunBenevole);  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consultercatalogueXml implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(uncontroleurSecretaire.refreshcatalogueXml());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consultercatalogueJson implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(uncontroleurSecretaire.refreshcatalogueJson());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consultercatalogueCsv implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(uncontroleurSecretaire.refreshcatalogueCsv());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consulterventeXml implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(uncontroleurSecretaire.refreshventeXml());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consulterventeJson implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(uncontroleurSecretaire.refreshventeJson());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consulterVenteCsv implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(uncontroleurSecretaire.refreshventeCsv());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consulterhistoriqueCatalogue implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(uncontroleurSecretaire.refreshhistoriqueCatalogue());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	class consulterBenevole implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			unevuePrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            // Ajoute le panel de ventee
            unevuePrincipal.add(uncontroleurSecretaire.refreshhistoriqueCatalogue());  

            unevuePrincipal.revalidate();
            unevuePrincipal.repaint();
			
		}
		
	}
	
	
	
}
