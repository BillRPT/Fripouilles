package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class C_menuBenevole implements ActionListener {
    private C_pbenevole cpBenevole;

    public C_menuBenevole(C_pbenevole cpBenevole) {
        this.cpBenevole = cpBenevole;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	String command = e.getActionCommand();
	    
	    switch (command) {
	        case "Consulter les articles":
	            System.out.println("Consulter les articles");
	            break;

	        case "Consulter les catalogues":
	            System.out.println("Consulter les catalogues");
	            break;

	        case "Consulter les articles d'un catalogue":
	            System.out.println("Consulter les articles d'un catalogue");
	            break;

	        case "Creer un article":
	            System.out.println("Créer un article");
	            break;

	        case "Creer un catalogue":
	            System.out.println("Créer un catalogue");
	            break;

	        case "Rechercher un article":
	            System.out.println("Rechercher un article");
	            break;

	        case "Rechercher un catalogue":
	            System.out.println("Rechercher un catalogue");
	            break;

	        case "Rechercher un article dans un catalogue":
	            System.out.println("Rechercher un article dans un catalogue");
	            break;

	        case "Supprimer un article":
	            System.out.println("Supprimer un article");
	            break;

	        case "Supprimer un catalogue":
	            System.out.println("Supprimer un catalogue");
	            break;

	        case "Supprimer un article d'un catalogue":
	            System.out.println("Supprimer un article d'un catalogue");
	            break;

	        default:
	            System.out.println("Action non reconnue : " + command);
	}
}
}
