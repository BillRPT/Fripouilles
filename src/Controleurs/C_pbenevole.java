package Controleurs;

import Vues.*;
import Vues.Benevole.*;
import Vues.Benevole.Article.*;
import Vues.Benevole.Catalogue.V_ajoutercatalogue;
import Vues.Maire.Consulter.V_consultercatalogue;
import Vues.Secretaire.Consulter.*;

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
		
		private V_consultercatalogueJson vConsulterCatJson;
		private V_consultercatalogueXml vConsulterCatXml;
		private V_consultercatalogueCsv vConsulterCatCsv;
		
		private V_jsonarticle vJsonArticle;
		private V_xmlarticle vXmlArticle;
		private V_csvarticle vCsvArticle;

		private CardLayout cardLayout;
	    private JPanel cardPanel;

		
	    
	//Constructeur
		/**
		* Constructeur du controleur principal
		*/
		public C_pbenevole(C_principal lecPrincipal) {
			this.uncPrincipal = lecPrincipal;
			
			
			vLogo = new V_logo();
			vMenuBenevole = new V_menubenevole(this, this.uncPrincipal.getvPrincipal(), vAjouterArticle, vRechercherArticle, vSupprimerArticle, vAjouterCatalogue);
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
			vConsulterCatalogue = new V_consultercatalogue(Modele.historiqueCatalogue());
			
			return vConsulterCatalogue;
		}
		
		public JPanel refreshArticlesJson() {
			
			vJsonArticle = new V_jsonarticle(Modele.afficherArticles());
			
			return vJsonArticle;
		}
		
		public JPanel refreshArticlesXml() {
			
			vXmlArticle = new V_xmlarticle(Modele.afficherArticles());
			
			return vXmlArticle;
		}
		
		public JPanel refreshArticlesCsv() {
			
			vCsvArticle = new V_csvarticle(Modele.afficherArticles());
			
			return vCsvArticle;
		}
		
		public JPanel refreshCatalogueXml() {
			
			vConsulterCatXml = new V_consultercatalogueXml(Modele.historiqueCatalogue());
			
			return vConsulterCatXml;
		}
		
		/**
		 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
		 * @return un JPanel
		 * */
		public JPanel refreshCatalogueJson() {
			
			vConsulterCatJson = new V_consultercatalogueJson(Modele.historiqueCatalogue());
			
			return vConsulterCatJson;
		}
		
		
		/**
		 * Fonction qui permet de refresh la vue pour voir les nouvelles donnees qui ont ete add
		 * @return un JPanel
		 * */
		public JPanel refreshCatalogueCsv() {
			
			vConsulterCatCsv = new V_consultercatalogueCsv(Modele.historiqueCatalogue());
			
			return vConsulterCatCsv;
		}
		
}