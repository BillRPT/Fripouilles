import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import Fonction.Fonction;

class FonctionTest {

    @Test
    public void testHashMD5() {

        char[] input = "testpassword".toCharArray();
        String hashInconnu = "5e884898da28047151d0e56f8dc6292773603d0d"; 
        assertEquals(hashInconnu, Fonction.hashMD5(input));


        char[] chaineVide = "".toCharArray();
        String hasconnu = "d41d8cd98f00b204e9800998ecf8427e";
        assertEquals(hasconnu, Fonction.hashMD5(chaineVide));
    }

    @Test
    public void testVerifDate() {

        assertTrue(Fonction.verifDate("2023-12-19"));


        assertFalse(Fonction.verifDate("19-12-2023"));
        assertFalse(Fonction.verifDate("invalid-date"));
        assertFalse(Fonction.verifDate("2023-02-30")); 
    }

    @Test
    public void testCharToString() {
        // Tester la conversion d'un tableau de caractères
        char[] chaine = {'t', 'e', 's', 't'};
        assertEquals("test", Fonction.charTostring(chaine));

        // Tester un tableau vide
        char[] chaineVide = {};
        assertEquals("", Fonction.charTostring(chaineVide));
    }

}
