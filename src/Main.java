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
		vConnex = new V_connexion(cConnex);
		
		/*if (Modele.connexionUtilisateur("eMusk", Fonction.hashMD5("Azerty123")) == true) {
			System.out.println("Correcte");
		}
		else {
			System.out.println("Incorrecte");
		}*/
		

	}

}
