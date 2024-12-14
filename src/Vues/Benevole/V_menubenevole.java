package Vues.Benevole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_menubenevole extends JMenuBar {

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

    public V_menubenevole() {
        // Initialisation des menus et items
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

        // Ajout des items aux menus
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

        // Ajout des menus à la barre de menu
        this.add(menuConsulter);
        this.add(menuCreer);
        this.add(menuRechercher);
        this.add(menuSupprimer);

        // Ajout des ActionListeners avec des classes internes
        itemConsulterArticle.addActionListener(new ConsulterArticleListener());
        itemConsulterCatalogues.addActionListener(new ConsulterCataloguesListener());
        itemConsulterArtCatalogues.addActionListener(new ConsulterArtCataloguesListener());

        itemCreerArticle.addActionListener(new CreerArticleListener());
        itemCreerCatalogue.addActionListener(new CreerCatalogueListener());

        itemRechercherArticle.addActionListener(new RechercherArticleListener());
        itemRechercherCatalogue.addActionListener(new RechercherCatalogueListener());
        itemRechercharArtCat.addActionListener(new RechercherArtCatListener());

        itemSupprimerArticle.addActionListener(new SupprimerArticleListener());
        itemSupprimerCatalogue.addActionListener(new SupprimerCatalogueListener());
        itemSupprimerArtCat.addActionListener(new SupprimerArtCatListener());
    }

    // Classes internes pour gérer les actions
    class ConsulterArticleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Consulter les articles");
        }
    }

    class ConsulterCataloguesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Consulter les catalogues");
        }
    }

    class ConsulterArtCataloguesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Consulter les articles d'un catalogue");
        }
    }

    class CreerArticleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Creer un article");
        }
    }

    class CreerCatalogueListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Creer un catalogue");
        }
    }

    class RechercherArticleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Rechercher un article");
        }
    }

    class RechercherCatalogueListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Rechercher un catalogue");
        }
    }

    class RechercherArtCatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Rechercher un article dans un catalogue");
        }
    }

    class SupprimerArticleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Supprimer un article");
        }
    }

    class SupprimerCatalogueListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Supprimer un catalogue");
        }
    }

    class SupprimerArtCatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action : Supprimer un article d'un catalogue");
        }
    }
}
