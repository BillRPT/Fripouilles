import Modele.Modele;
import Vues.*;
import Controleurs.*;
import Fonction.Fonction;

public class Main {
	public static void main(String[] args) {
		//attributs
		V_connexion vConnex;
		C_connexion cConnex;
		
		//---
		Modele.connexionBdd();
		
		cConnex = new C_connexion();
	}

}
