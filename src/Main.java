import Modele.Modele;
import Vues.*;

import java.util.ArrayList;

import Class.Catalogue;
import Controleurs.*;
import Fonction.Fonction;

public class Main {
	public static void main(String[] args) {
		//attributs
		C_connexion cConnex;
		C_principal cPrincipal;
		
		//---
		Modele.connexionBdd();
		
		
		cPrincipal = new C_principal();
		cConnex = new C_connexion(cPrincipal);
	}

}
