package Controleurs;

import Vues.*;
import Vues.Benevole.*;
import Vues.Benevole.Article.*;
import Vues.Benevole.Catalogue.V_ajoutercatalogue;
import Vues.Secretaire.Consulter.V_consultercatalogue;
import Vues.Secretaire.Consulter.V_consultervente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Controleurs.*;
import Modele.Modele;

public class C_pbenevole {
	//attributs
	    private C_principal uncPrincipal;
	
		private V_logo vLogo;
		private V_principal vPrincipal;
		private V_menubenevole vMenuBenevole;
		private V_ajouterarticle vAjouterArticle;
		private V_rechercherarticle vRechercherArticle;
		private V_supprimerarticle vSupprimerArticle;
		private V_consultercatalogue vConsulterCatalogue;
		private V_consulterarticle vConsulterArticle;
		private V_ajoutercatalogue vAjouterCatalogue;

		private CardLayout cardLayout;
	    private JPanel cardPanel;

		
	    
	//Constructeur
		/**
		* Constructeur du controleur principal
		*/
		public C_pbenevole(C_principal lecPrincipal) {
			this.uncPrincipal = lecPrincipal;
			
			vLogo = new V_logo();
			vMenuBenevole = new V_menubenevole(this, uncPrincipal.getvPrincipal(), vAjouterArticle, vRechercherArticle, vSupprimerArticle, vAjouterCatalogue);
			//Ajouter le logo � la vue principale
			uncPrincipal.getvPrincipal().getContentPane().add(vLogo, BorderLayout.NORTH);
			//ajouter le menu
			uncPrincipal.getvPrincipal().setJMenuBar(vMenuBenevole);
		}
		
		
		
		
		public JPanel refreshArticles() {
			vConsulterArticle = new V_consulterarticle(Modele.afficherArticles());
			
			return vConsulterArticle;
		}
		
		public JPanel refreshCatalogue() {
			vConsulterCatalogue = new V_consultercatalogue(Modele.consulterCatalogue());
			
			return vConsulterArticle;
		}
}