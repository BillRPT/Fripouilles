package Vues.Benevole;
import javax.swing.*;
import Controleurs.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class V_menubenevole extends JMenuBar {
	private C_pbenevole cpBenevole;
	private C_menuBenevole menuBenevole;
	
    private JMenu menuConsulter;
    private JMenuItem itemConsulterArticle;
    private JMenuItem itemConsulterCatalogues;
    private JMenuItem itemConsulterArtCatalogues;
    
    private JMenu menuCreer;
    private JMenuItem itemCreerArticle;
    private JMenuItem itemCreerCatalogue;

    private JMenu menuRechercher;
    private JMenuItem itemRechercherArticle;
    private JMenuItem itemRechercherCatalogue;
    private JMenuItem itemRechercharArtCat;

    private JMenu menuSupprimer;
    private JMenuItem itemSupprimerArticle;
    private JMenuItem itemSupprimerCatalogue;
    private JMenuItem itemSupprimerArtCat;


public V_menubenevole(C_pbenevole cpBenevole, C_menuBenevole menuBenevole) {
        this.cpBenevole = cpBenevole;
        this.menuBenevole = menuBenevole;

        menuConsulter = new JMenu("Consulter");
        itemConsulterArticle = new JMenuItem("Consulter les articles");
        itemConsulterCatalogues = new JMenuItem("Consulter les catalogues");
        itemConsulterArtCatalogues = new JMenuItem("Consulter les articles d'un catalogue");

        menuCreer = new JMenu("Creer");
        itemCreerArticle = new JMenuItem("Creer un article");
        itemCreerCatalogue = new JMenuItem("Creer un catalogue");

        menuRechercher = new JMenu("Rechercher");
        itemRechercherArticle = new JMenuItem("Rechercher un article");
        itemRechercherCatalogue = new JMenuItem("Rechercher un catalogue");
        itemRechercharArtCat = new JMenuItem("Rechercher un article dans un catalogue");
        
        menuSupprimer = new JMenu("Supprimer");
        itemSupprimerArticle = new JMenuItem("Supprimer un article");
        itemSupprimerCatalogue = new JMenuItem("Supprimer un catalogue");
        itemSupprimerArtCat = new JMenuItem("Supprimer un article d'un catalogue");

        menuConsulter.add(itemConsulterArticle);
        menuConsulter.add(itemConsulterCatalogues);
        menuConsulter.add(itemConsulterArtCatalogues);
        
        menuCreer.add(itemCreerArticle);
        menuCreer.add(itemCreerCatalogue);
        
        menuRechercher.add(itemRechercherArticle);
        menuRechercher.add(itemRechercherCatalogue);
        menuRechercher.add(itemRechercharArtCat);
        
        menuSupprimer.add(itemSupprimerArticle);
        menuSupprimer.add(itemSupprimerCatalogue);
        menuSupprimer.add(itemSupprimerArtCat);

        this.add(menuConsulter);
        this.add(menuCreer);
        this.add(menuRechercher);
        this.add(menuSupprimer);
        
        itemConsulterArticle.addActionListener(menuBenevole);
        itemConsulterCatalogues.addActionListener(menuBenevole);
        itemConsulterArtCatalogues.addActionListener(menuBenevole);

        itemCreerArticle.addActionListener(menuBenevole);
        itemCreerCatalogue.addActionListener(menuBenevole);

        itemRechercherArticle.addActionListener(menuBenevole);
        itemRechercherCatalogue.addActionListener(menuBenevole);
        itemRechercharArtCat.addActionListener(menuBenevole);

        itemSupprimerArticle.addActionListener(menuBenevole);
        itemSupprimerCatalogue.addActionListener(menuBenevole);
        itemSupprimerArtCat.addActionListener(menuBenevole);
    }
    public C_pbenevole getCpBenevole() {
        return cpBenevole;
    }

    public JMenu getMenuConsulter() {
        return menuConsulter;
    }

    public JMenuItem getItemConsulterArticle() {
        return itemConsulterArticle;
    }

    public JMenuItem getItemConsulterCatalogues() {
        return itemConsulterCatalogues;
    }

    public JMenuItem getItemConsulterArtCatalogues() {
        return itemConsulterArtCatalogues;
    }

    public JMenu getMenuCreer() {
        return menuCreer;
    }

    public JMenuItem getItemCreerArticle() {
        return itemCreerArticle;
    }

    public JMenuItem getItemCreerCatalogue() {
        return itemCreerCatalogue;
    }

    public JMenu getMenuRechercher() {
        return menuRechercher;
    }

    public JMenuItem getItemRechercherArticle() {
        return itemRechercherArticle;
    }

    public JMenuItem getItemRechercherCatalogue() {
        return itemRechercherCatalogue;
    }

    public JMenuItem getItemRechercharArtCat() {
        return itemRechercharArtCat;
    }

    public JMenu getMenuSupprimer() {
        return menuSupprimer;
    }

    public JMenuItem getItemSupprimerArticle() {
        return itemSupprimerArticle;
    }

    public JMenuItem getItemSupprimerCatalogue() {
        return itemSupprimerCatalogue;
    }

    public JMenuItem getItemSupprimerArtCat() {
        return itemSupprimerArtCat;
    }
    
}