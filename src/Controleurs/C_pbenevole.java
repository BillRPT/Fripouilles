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
		private C_menuBenevole menuBenevole;
	
		private V_logo vLogo;
		private V_principal vPrincipal;
		private V_menubenevole vMenuBenevole;
		private V_ajouterarticle vAjouterArticle;
		private V_rechercherarticle vRechercherArticle;
		private V_supprimerarticle vSupprimerArticle;
		
	    private JPanel mainPanel;

		
		private CardLayout cardLayout;
	    private JPanel cardPanel;
	    
	    private C_principal uncPrincipal;
		
	    
	//Constructeur
		/**
		* Constructeur du controleur principal
		*/
		public C_pbenevole(C_principal lecPrincipal, C_menuBenevole menuBenevole) {
			this.uncPrincipal = lecPrincipal;
			this.menuBenevole = menuBenevole;
			this.mainPanel = new JPanel(new BorderLayout());
			
			vLogo = new V_logo();
			vMenuBenevole = new V_menubenevole(this);
				
			//Ajouter le menu � la vue principale
			uncPrincipal.getvPrincipal().setJMenuBar(vMenuBenevole);
				
			//Ajouter le logo � la vue principale
			uncPrincipal.getvPrincipal().getContentPane().add(vLogo, BorderLayout.NORTH);
		}

}
