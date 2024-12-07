package Vues.Benevole;
import javax.swing.*;
import Controleurs.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class V_menubenevole extends JMenuBar {
	private C_pbenevole cpBenevole;
	
    private JMenu menuArticle;
    private JMenuItem itemAjouterArticle;
    private JMenuItem itemRechercherArticle;
    private JMenuItem itemSupprimerArticle;
    private JMenuItem itemConsulterArticle;
    private JMenu menuCatalogue;
    private JMenuItem itemAjouterCatalogue;
    private JMenuItem itemConsulterCatalogues;
    private JMenuItem itemRechercherCatalogue;
    private JMenuItem itemSupprimerCatalogue;
    private JMenuItem itemAjArtCat;
    private JMenuItem itemSupArtCat;
    private JMenuItem itemReArtCat;


    public V_menubenevole(C_pbenevole cpBenevole) {
    	cpBenevole = new C_pbenevole();
        menuCatalogue = new JMenu("Catalogue");

        menuArticle = new JMenu("Article");
        itemConsulterArticle = new JMenuItem("Consulter les articles");
        itemAjouterArticle = new JMenuItem("Ajouter un nouvel article");
        itemRechercherArticle = new JMenuItem("Rechercher un article");
        itemSupprimerArticle = new JMenuItem("Supprimer un article");

        menuArticle.add(itemConsulterArticle);
        menuArticle.add(itemAjouterArticle);
        menuArticle.add(itemRechercherArticle);
        menuArticle.add(itemSupprimerArticle);

        menuCatalogue = new JMenu("Catalogue");
        itemConsulterCatalogues = new JMenuItem("Consulter les catalogues");
        itemAjouterCatalogue = new JMenuItem("Cr�er un catalogue");
        itemRechercherCatalogue = new JMenuItem("Rechercher un catalogue");
        itemSupprimerCatalogue = new JMenuItem("Supprimer un catalogue");
        itemAjArtCat = new JMenuItem("Ajouter un article � un catalogue");
        itemReArtCat = new JMenuItem("Rechercher un article dans un catalogue");
        itemSupArtCat = new JMenuItem("Supprimer un article d'un catalogue");
        
        menuCatalogue.add(itemConsulterCatalogues);
        menuCatalogue.add(itemAjouterCatalogue);
        menuCatalogue.add(itemRechercherCatalogue);
        menuCatalogue.add(itemSupprimerCatalogue);
        menuCatalogue.add(itemAjArtCat);
        menuCatalogue.add(itemReArtCat);
        menuCatalogue.add(itemSupArtCat);
        
        

        this.add(menuArticle);
        this.add(menuCatalogue);
    }
    
    //accesseurs
    
    public JMenuItem getItemAjouterArticle(){
    	return this.itemAjouterArticle;
    }
    
    public JMenuItem getItemConsulterArticle() {
    	return this.itemConsulterArticle;
    }
    
    public JMenuItem getItemRechercherArticle() {
    	return this.itemRechercherArticle;
    }
    
    public JMenuItem getItemSupprimerArticle() {
    	return this.itemSupprimerArticle;
    }
    
}