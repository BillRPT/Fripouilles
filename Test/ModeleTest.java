import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Class.Catalogue;
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
	
	@Test
	public void testajouterArticle() {
		//Ajouter un article
		Modele.ajouterArticle("test", "test", "test", "test");
		Assert.assertEquals("L'article n'a pas été ajouté", true, Modele.rechercherArticle("test"));
		//Après avoir tester le supprimer
		Modele.supprimerArticle("test");
	}
	
	@Test
	public void testsupprimerArticle() {
		Modele.ajouterArticle("test", "test", "test", "test");
		Modele.supprimerArticle("test");
		Assert.assertEquals("L'article n'a pas été supprimé", false, Modele.rechercherArticle("test"));
	}
	
	@Test
	public void testhistoriqueCatalogue() {
		ArrayList<Catalogue> uneListe;
		uneListe = Modele.historiqueCatalogue();
		Assert.assertEquals("La liste de historiqueCatalogue ne correspond pas", 0, uneListe.size());
	}

}
