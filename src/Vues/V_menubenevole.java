package Vues;
import javax.swing.*;
import java.util.ArrayList;

public class V_menubenevole extends JMenuBar {
    private JMenu menuArticle;
    private JMenu menuCatalogue;
    private JMenuItem itemAjouterArticle;
    private JMenuItem itemSupprimerArticle;
    private JMenu menuSupprimer;
    private JMenuItem itemSupprimerJeu;
    private JMenuItem itemSupprimerCategorie;
    private JMenuItem itemSupprimerEditeur;
    private JMenuItem itemSupprimerPlateforme;

    public V_menubenevole() {
        menuCatalogue = new JMenu("Catalogue");

        menuArticle = new JMenu("Article");
        itemAjouterArticle = new JMenuItem("Ajouter nouvel article");
        itemSupprimerArticle = new JMenuItem("Supprimer un article");
        menuArticle.add(itemAjouterArticle);
        menuArticle.add(itemSupprimerArticle);

        menuSupprimer = new JMenu("Supprimer");
        itemSupprimerJeu = new JMenuItem("un jeu");
        itemSupprimerCategorie = new JMenuItem("une catégorie");
        itemSupprimerEditeur = new JMenuItem("un éditeur");
        itemSupprimerPlateforme = new JMenuItem("une plateforme");
        
        menuSupprimer.add(itemSupprimerJeu);
        menuSupprimer.add(itemSupprimerCategorie);
        menuSupprimer.add(itemSupprimerEditeur);
        menuSupprimer.add(itemSupprimerPlateforme);

        this.add(menuArticle);
        this.add(menuSupprimer);
    }

}
