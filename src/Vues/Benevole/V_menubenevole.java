package Vues.Benevole;

import javax.swing.*;

import Controleurs.C_pbenevole;
import Modele.Modele;
import Vues.V_principal;
import Vues.Benevole.ArtCat.V_ajouterartcat;
import Vues.Benevole.ArtCat.V_consulterartcat;
import Vues.Benevole.ArtCat.V_rechercherartcat;
import Vues.Benevole.ArtCat.V_supprimerartcat;
import Vues.Benevole.Article.V_ajouterarticle;
import Vues.Benevole.Article.V_consulterarticle;
import Vues.Benevole.Article.V_rechercherarticle;
import Vues.Benevole.Article.V_supprimerarticle;
import Vues.Benevole.Catalogue.*;
import Vues.Maire.Consulter.V_consultercatalogue;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_menubenevole extends JMenuBar {
	
	private C_pbenevole cBenevole;
	//les vues
	private V_principal vPrincipal;
	
	private V_ajouterarticle vAjouterArticle;
	private V_rechercherarticle vRechercherArticle;
	private V_supprimerarticle vSupprimerArticle;
	
	private V_ajoutercatalogue vAjouterCatalogue;
	private V_recherchercatalogue vRechercherCatalogue;
	private V_supprimercatalogue vSupprimerCatalogue;
	
	private V_consulterartcat vConArtCat;
	private V_ajouterartcat vAjouterArtCat;
	private V_rechercherartcat vRechercherArtCat;
	private V_supprimerartcat VSupprimerArtCat;
	
	
	//attributs du menu
    private JMenu menuConsulter;
    private JMenuItem itemConsulterArticle;
    private JMenuItem itemConsulterCatalogues;
    private JMenuItem itemConsulterArtCatalogues;

    private JMenu menuCreer;
    private JMenuItem itemCreerArticle;
    private JMenuItem itemCreerCatalogue;
    private JMenuItem itemAjtArtCat;

    private JMenu menuRechercher;
    private JMenuItem itemRechercherArticle;
    private JMenuItem itemRechercherCatalogue;
    private JMenuItem itemRechercharArtCat;

    private JMenu menuSupprimer;
    private JMenuItem itemSupprimerArticle;
    private JMenuItem itemSupprimerCatalogue;
    private JMenuItem itemSupprimerArtCat;
    
    private JMenu xml;
    private JMenuItem itemXmlArticle;
    private JMenuItem itemXmlCatalogue;
    private JMenuItem itemXmlArtCat;
    
    private JMenu json;
    private JMenuItem itemJsonArticle;
    private JMenuItem itemJsonCatalogue;
    private JMenuItem itemJsonArtCat;
    
    private JMenu csv;
    private JMenuItem itemCsvArticle;
    private JMenuItem itemCsvCatalogue;
    private JMenuItem itemCsvArtCat;

    public V_menubenevole(C_pbenevole cBenevole,V_principal vPrincipal ,V_ajouterarticle vAjouterArticle, V_rechercherarticle vRechercherArticle, V_supprimerarticle vSupprimerArticle, V_ajoutercatalogue vAjouterCatalogue) {
    	
    	this.cBenevole = cBenevole;
    	this.vPrincipal = vPrincipal;
    	this.vAjouterArticle = vAjouterArticle;
    	this.vRechercherArticle = vRechercherArticle;
    	this.vSupprimerArticle = vSupprimerArticle;
    	this.vAjouterCatalogue = vAjouterCatalogue;
    	
    	
    	
        //initialisation des menus et items
        menuConsulter = new JMenu("Consulter");
        itemConsulterArticle = new JMenuItem("Consulter les articles");
        itemConsulterCatalogues = new JMenuItem("Consulter les catalogues");
        itemConsulterArtCatalogues = new JMenuItem("Consulter les articles d'un catalogue");

        menuCreer = new JMenu("Ajouter");
        itemCreerArticle = new JMenuItem("Ajouter un article");
        itemCreerCatalogue = new JMenuItem("Creer un catalogue");
        itemAjtArtCat = new JMenuItem("Ajouter un article dans un catalogue");

        menuRechercher = new JMenu("Rechercher");
        itemRechercherArticle = new JMenuItem("Rechercher un article");
        itemRechercherCatalogue = new JMenuItem("Rechercher un catalogue");
        itemRechercharArtCat = new JMenuItem("Rechercher un article dans un catalogue");

        menuSupprimer = new JMenu("Supprimer");
        itemSupprimerArticle = new JMenuItem("Supprimer un article");
        itemSupprimerCatalogue = new JMenuItem("Supprimer un catalogue");
        itemSupprimerArtCat = new JMenuItem("Supprimer un article d'un catalogue");
        
        xml = new JMenu("XML");
        itemXmlArticle = new JMenuItem("XML Article");
        itemXmlCatalogue = new JMenuItem("XML Catalogue");
        itemXmlArtCat = new JMenuItem("XML Article");

        json = new JMenu("JSON");
        itemJsonArticle = new JMenuItem("JSON Article");
        itemJsonCatalogue = new JMenuItem("JSON Catalogue");
        itemJsonArtCat = new JMenuItem("JSON Article");

        csv = new JMenu("CSV");
        itemCsvArticle = new JMenuItem("CSV Article");
        itemCsvCatalogue = new JMenuItem("CSV Catalogue");
        itemCsvArtCat = new JMenuItem("CSV Article");

        //Ajout des items aux menus
        menuConsulter.add(itemConsulterArticle);
        menuConsulter.add(itemConsulterCatalogues);
        menuConsulter.add(itemConsulterArtCatalogues);

        menuCreer.add(itemCreerArticle);
        menuCreer.add(itemCreerCatalogue);
        menuCreer.add(itemAjtArtCat);

        menuRechercher.add(itemRechercherArticle);
        menuRechercher.add(itemRechercherCatalogue);
        menuRechercher.add(itemRechercharArtCat);

        menuSupprimer.add(itemSupprimerArticle);
        menuSupprimer.add(itemSupprimerCatalogue);
        menuSupprimer.add(itemSupprimerArtCat);
        
        json.add(itemJsonArticle);
        json.add(itemJsonCatalogue);
        json.add(itemJsonArtCat);

        csv.add(itemCsvArticle);
        csv.add(itemCsvCatalogue);
        csv.add(itemCsvArtCat);
        
        xml.add(itemXmlArticle);
        xml.add(itemXmlCatalogue);
        xml.add(itemXmlArtCat);

        //ajout des menus à la barre de menu
        this.add(menuConsulter);
        this.add(menuCreer);
        this.add(menuRechercher);
        this.add(menuSupprimer);
        this.add(json);
        this.add(xml);
        this.add(csv);

        //ajout des ActionListeners avec des classes internes
        itemConsulterArticle.addActionListener(new ConsulterArticleListener());
        itemConsulterCatalogues.addActionListener(new ConsulterCataloguesListener());
        itemConsulterArtCatalogues.addActionListener(new ConsulterArtCataloguesListener());

        itemCreerArticle.addActionListener(new CreerArticleListener());
        itemCreerCatalogue.addActionListener(new CreerCatalogueListener());
        itemAjtArtCat.addActionListener(new CreerArtCat());

        itemRechercherArticle.addActionListener(new RechercherArticleListener());
        itemRechercherCatalogue.addActionListener(new RechercherCatalogueListener());
        itemRechercharArtCat.addActionListener(new RechercherArtCatListener());

        itemSupprimerArticle.addActionListener(new SupprimerArticleListener());
        itemSupprimerCatalogue.addActionListener(new SupprimerCatalogueListener());
        itemSupprimerArtCat.addActionListener(new SupprimerArtCatListener());
        
        itemJsonArticle.addActionListener(new JsonArticle());
        itemJsonCatalogue.addActionListener(new JsonCatalogue());
        itemJsonArtCat.addActionListener(new JsonArtCat());
        
        itemXmlArticle.addActionListener(new XmlArticle());
        itemXmlCatalogue.addActionListener(new XmlCatalogue());
        itemXmlArtCat.addActionListener(new XmlArtCat());
        
        itemCsvArticle.addActionListener(new CsvArticle());
        itemCsvCatalogue.addActionListener(new CsvCatalogue());
        itemCsvArtCat.addActionListener(new CsvArtCat());
    }

    //classes internes pour gérer les actions
    class ConsulterArticleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Consulter les articles");
            
            vPrincipal.getContentPane().removeAll();
            
            vPrincipal.add(cBenevole.refreshArticles());

            vPrincipal.revalidate();
            vPrincipal.repaint();
            
        }
    }

    class ConsulterCataloguesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Consulter les catalogues");
            
            vPrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            vPrincipal.add(cBenevole.refreshCatalogue());  

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    class ConsulterArtCataloguesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Consulter les articles d'un catalogue");
            
            vPrincipal.getContentPane().removeAll();  // Retire tous les composants du JFrame

            vConArtCat = new V_consulterartcat(vPrincipal);
            vPrincipal.add(vConArtCat); 

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    class CreerArticleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Creer un article");
            
            vPrincipal.getContentPane().removeAll();

			vAjouterArticle = new V_ajouterarticle();
            vPrincipal.add(vAjouterArticle);  

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    class CreerCatalogueListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Creer un catalogue");
            
            vPrincipal.getContentPane().removeAll();
            
            vAjouterCatalogue = new V_ajoutercatalogue();
            vPrincipal.add(vAjouterCatalogue);
            
            vPrincipal.revalidate();
            vPrincipal.repaint();
            }
    }
    
    class CreerArtCat implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Action : Ajt article categ");
            
            vPrincipal.getContentPane().removeAll();

            vAjouterArtCat = new V_ajouterartcat();
            vPrincipal.add(vAjouterArtCat);  

            vPrincipal.revalidate();
            vPrincipal.repaint();
		}
    	
    }

    class RechercherArticleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Rechercher un article");
            
            vPrincipal.getContentPane().removeAll();

            vRechercherArticle = new V_rechercherarticle();
            vPrincipal.add(vRechercherArticle);  

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    class RechercherCatalogueListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Rechercher un catalogue");
            
            vPrincipal.getContentPane().removeAll();

            vRechercherCatalogue = new V_recherchercatalogue();
            vPrincipal.add(vRechercherCatalogue);  

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    class RechercherArtCatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Rechercher un article dans un catalogue");
            
            vPrincipal.getContentPane().removeAll();

            vRechercherArtCat = new V_rechercherartcat();
            vPrincipal.add(vRechercherArtCat);  

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    class SupprimerArticleListener implements ActionListener {
    	
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Supprimer un article");
            
            vPrincipal.getContentPane().removeAll();

            vSupprimerArticle = new V_supprimerarticle();
            vPrincipal.add(vSupprimerArticle);  

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    class SupprimerCatalogueListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Supprimer un catalogue");
            
            vPrincipal.getContentPane().removeAll();

            vSupprimerCatalogue = new V_supprimercatalogue();
            vPrincipal.add(vSupprimerCatalogue);  

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    class SupprimerArtCatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Supprimer un article d'un catalogue");
            
            vPrincipal.getContentPane().removeAll();

            VSupprimerArtCat = new V_supprimerartcat();
            vPrincipal.add(VSupprimerArtCat);  

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    // JSON Article Listener
    class JsonArticle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Exporter article en JSON");

            vPrincipal.getContentPane().removeAll();

            vPrincipal.add(cBenevole.refreshArticlesJson());

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    // JSON Catalogue Listener
    class JsonCatalogue implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	System.out.println("Action : Exporter article en JSON");

            vPrincipal.getContentPane().removeAll();

            vPrincipal.add(cBenevole.refreshCatalogueJson());

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    // JSON Article-Catalogue Listener
    class JsonArtCat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Exporter articles d'un catalogue en JSON");

            vPrincipal.getContentPane().removeAll();

            vPrincipal.add(cBenevole.refreshCatalogueJson());

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    // XML Article Listener
    class XmlArticle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Exporter article en XML");

            vPrincipal.getContentPane().removeAll();

            vPrincipal.add(cBenevole.refreshArticlesXml());

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    // XML Catalogue Listener
    class XmlCatalogue implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Exporter catalogue en XML");

            vPrincipal.getContentPane().removeAll();

            vPrincipal.add(cBenevole.refreshCatalogueXml());

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    // XML Article-Catalogue Listener
    class XmlArtCat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Exporter articles d'un catalogue en XML");

            vPrincipal.getContentPane().removeAll();

            JPanel xmlArtCatView = new JPanel();
            xmlArtCatView.add(new JLabel("Exportation des articles d'un catalogue en XML..."));
            vPrincipal.add(xmlArtCatView);

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    // CSV Article Listener
    class CsvArticle implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	System.out.println("Action : Exporter catalogue en CSV");

            vPrincipal.getContentPane().removeAll();

            vPrincipal.add(cBenevole.refreshArticlesCsv());

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    // CSV Catalogue Listener
    class CsvCatalogue implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Exporter catalogue en CSV");

            vPrincipal.getContentPane().removeAll();

            vPrincipal.add(cBenevole.refreshCatalogueCsv());

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }

    // CSV Article-Catalogue Listener
    class CsvArtCat implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Exporter articles d'un catalogue en CSV");

            vPrincipal.getContentPane().removeAll();

            JPanel csvArtCatView = new JPanel();
            csvArtCatView.add(new JLabel("Exportation des articles d'un catalogue en CSV..."));
            vPrincipal.add(csvArtCatView);

            vPrincipal.revalidate();
            vPrincipal.repaint();
        }
    }
}
