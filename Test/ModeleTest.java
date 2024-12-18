import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Class.Catalogue;
import Class.VenteEphemere;
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
	public void testhistoriqueCatalogue() {
		ArrayList<Catalogue> uneListe;
		uneListe = Modele.historiqueCatalogue();
		Assert.assertEquals("La liste de historiqueCatalogue ne correspond pas", 4, uneListe.size());
	}
	
	@Test
	public void testRoleUtilisateur() {
		Assert.assertEquals("La connexion utilisateur n'a pas fonctionner", "secretaire", Modele.roleUtilisateur("eMusk", Fonction.hashMD5(tableau)));
	}
	
	public void testStatistique () {
		ArrayList<VenteEphemere> uneListe;
		uneListe = Modele.consulterStatistiques();
		Assert.assertEquals("La liste de historiqueCatalogue ne correspond pas", 4, uneListe.size());
	}
	
	@Test
	public void testajouterBenevole() {
	    // Créez le mot de passe
	    char[] mdp = {'t', 'e', 's', 't'};

	    Modele.ajouterBenevole("test", "test", "test", mdp);
	
	    Assert.assertTrue("Le bénévole n'a pas ete ajoute correctement", Modele.rechercherBenevole("test"));

	    Modele.supprimerBenevole("test");

	}
	@Test
	public void testsupprimerBenevole() {
		// Créez le mot de passe
	    char[] mdp = {'t', 'e', 's', 't'};

	    Modele.ajouterBenevole("test", "test", "test", mdp);
	    Modele.supprimerBenevole("test");
	    Assert.assertFalse("Le bénévole n'a pas ete supprime correctement", Modele.rechercherBenevole("test"));
	}
	@Test
	public void testrechercherBenevole() {
	    // Créez le mot de passe
	    char[] mdp = {'t', 'e', 's', 't'};
	    
	    Modele.ajouterBenevole("test", "test", "test", mdp);
	    Assert.assertTrue("Le bénévole n'a pas été trouvé", Modele.rechercherBenevole("test"));
	    Modele.supprimerBenevole("test");
	}
	@Test
	public void testconsulterBenevole() {
		Assert.assertEquals("La liste benevole ne correspond pas", 0, Modele.consulterBenevole().size());
	}
	
	@Test
	public void testconsulterVente() {
		Assert.assertEquals("La liste vente ne correspond pas", 4, Modele.consulterlesVentes().size());
	}
	
	@Test
	public void testconsulterCatalogue() {
		System.out.println(Modele.consulterCatalogue().size());
		Assert.assertEquals("La liste catalogue correspond pas", 3, Modele.consulterCatalogue().size());
	}
	
	@Test
	public void testajouterCatalogue() {
         Modele.ajouterCatalogue("test", Date.valueOf("2024-02-02"));
        Assert.assertTrue("Le catalogue n'a pas ete ajouter", Modele.rechercherCatalogue("test"));
        Modele.supprimerCatalogue("test");
    }
	
	@Test
	public void testsupprimerCatalogue() {
		Modele.ajouterCatalogue("test", Date.valueOf("2024-02-02"));
		Modele.supprimerCatalogue("test");
		Assert.assertFalse("Le catalogue n'a pas ete supprimer", Modele.rechercherCatalogue("test"));
	}
	
	@Test
	public void testrechercherCatalogue() {
		Modele.ajouterCatalogue("test", Date.valueOf("2024-02-02"));
		Assert.assertTrue("Le catalogue n'a pas ete trouver", Modele.rechercherCatalogue("test"));
		Modele.supprimerCatalogue("test");
	}

}
