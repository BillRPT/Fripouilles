package Vues;
import javax.swing.*;
import java.util.ArrayList;

public class V_menubenevole extends JMenuBar {
    private JMenu menuArticle;
    private JMenuItem itemAjouterArticle;
    private JMenuItem itemSupprimerArticle;
    private JMenuItem itemConsulterArticle;
    private JMenu menuCatalogue;
    private JMenuItem itemAjouterCatalogue;
    private JMenuItem itemConsulterCatalogues;
    private JMenuItem itemSupprimerCatalogue;
    private JMenuItem itemAjArtCat;
    private JMenuItem itemSupArtCat;


    public V_menubenevole() {
        menuCatalogue = new JMenu("Catalogue");

        menuArticle = new JMenu("Article");
        itemConsulterArticle = new JMenuItem("Consulter les articles");
        itemAjouterArticle = new JMenuItem("Ajouter nouvel article");
        itemSupprimerArticle = new JMenuItem("Supprimer un article");
        menuArticle.add(itemAjouterArticle);
        menuArticle.add(itemSupprimerArticle);

        menuCatalogue = new JMenu("Catalogue");
        itemConsulterCatalogues = new JMenuItem("Consulter les catalogues");
        itemAjouterCatalogue = new JMenuItem("Créer un catalogue");
        itemSupprimerCatalogue = new JMenuItem("Supprimer un catalogue");
        itemAjArtCat = new JMenuItem("Ajouter un article à un catalogue");
        itemSupArtCat = new JMenuItem("Supprimer un article d'un catalogue");
        
        menuCatalogue.add(itemConsulterCatalogues);
        menuCatalogue.add(itemAjouterCatalogue);
        menuCatalogue.add(itemSupprimerCatalogue);
        menuCatalogue.add(itemAjArtCat);
        menuCatalogue.add(itemSupArtCat);

        this.add(menuArticle);
        this.add(menuCatalogue);
    }

}
