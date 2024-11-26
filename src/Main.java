import Modele.Modele;
import Fonction.Fonction;

public class Main {
	public static void main(String[] args) {
		Modele.connexionBdd();
		
		if (Modele.connexionUtilisateur("eMusk", Fonction.hashMD5("Azerty123")) == true) {
			System.out.println("Correcte");
		}
		else {
			System.out.println("Incorrecte");
		}
		Modele.fermetureBdd();

	}

}
