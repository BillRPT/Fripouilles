import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Fonction.Fonction;

import org.junit. *;

import Modele.Modele;

class ModeleTest {
	char[] tableau = {'A', 'z', 'e', 'r', 't', 'y', '1', '2', '3'};


	@BeforeEach
	void setUp() throws Exception {
		//Connexion a la bdd pour commencer a faire les test
		Modele.connexionBdd();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testconnexionUtilisateur() {
		Assert.assertEquals("La connexion utilisateur n'a pas fonctionner", true, Modele.connexionUtilisateur("eMusk", Fonction.hashMD5(tableau)));
	}

}
