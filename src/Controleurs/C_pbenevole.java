package Controleurs;

import Vues.*;
import Vues.Benevole.*;
import Vues.Benevole.Article.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Controleurs.*;

public class C_pbenevole {
	//attributs
	    private C_principal uncPrincipal;
	
		private V_logo vLogo;
		private V_principal vPrincipal;
		private V_menubenevole vMenuBenevole;
		private V_ajouterarticle vAjouterArticle;
		private V_rechercherarticle vRechercherArticle;
		private V_supprimerarticle vSupprimerArticle;

		
		private CardLayout cardLayout;
	    private JPanel cardPanel;

		
	    
	//Constructeur
		/**
		* Constructeur du controleur principal
		*/
		public C_pbenevole(C_principal lecPrincipal) {
			this.uncPrincipal = lecPrincipal;
			
			vLogo = new V_logo();
			vMenuBenevole = new V_menubenevole(this, uncPrincipal.getvPrincipal(), vAjouterArticle, vRechercherArticle, vSupprimerArticle);
				
			//Ajouter le logo � la vue principale
			uncPrincipal.getvPrincipal().getContentPane().add(vLogo, BorderLayout.NORTH);
			
			//ajouter le menu
			uncPrincipal.getvPrincipal().setJMenuBar(vMenuBenevole);
		}
}