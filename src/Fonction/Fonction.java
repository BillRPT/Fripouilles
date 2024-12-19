package Fonction;
import java.awt.Image;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
//jetest
public class Fonction {
	
	/**
	* Fonction qui hash en md5 une chaine de caractere
	* @param password 
	* @return une chaine de caractere hasher en md5
	*/
	public static String hashMD5(char[] password) {
	    StringBuilder hexString = new StringBuilder();
	    try {
	        // Convertir le tableau de caract�res en cha�ne
	        String passwordString = new String(password);
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] messageDigest = md.digest(passwordString.getBytes());

	        // Conversion des octets en repr�sentation hexad�cimale
	        for (byte b : messageDigest) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }
	    } catch (NoSuchAlgorithmException erreur) {
	        System.out.println("Erreur de hashage MD5 : " + erreur.getMessage());
	    }

	    return hexString.toString();
	}
	
	
	/**
	* Fonction qui verifie le format de la date
	* @param uneDate 
	* @return true ou false
	*/
	public static boolean verifDate(String uneDate) {
		boolean rep = false;
		
		try {
			java.sql.Date.valueOf(uneDate);
			rep = true;
		}
		catch(Exception erreur) {
			
		}
		
		return rep;
	}

	
    
	
	/**
	 * M�thode pour redimensionner le logo
	 * @param icon
	 * @param width
	 * @param height
	 * @return
	 */
	// M�thode pour redimensionner l'ImageIcon
	public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
	    Image img = icon.getImage();  // Obtenir l'image � partir de l'ImageIcon
	    Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Redimensionner l'image
	    return new ImageIcon(resizedImg);  // Retourner une nouvelle ImageIcon avec l'image redimensionn�e
	}
	
	/**
	 * Methode pour concertir un char en string
	 * @param chaine
	 * @return une chaine de caractere
	 */
	public static String charTostring(char[] chaine) {
	    return new String(chaine);
	}
	
	
	public static boolean checkPassword(char[] chaine) {
	    boolean rep = true;
		
		String password = charTostring(chaine);

	    if (password.length() < 12 || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
	    	rep = false; 
	    }
	    return rep;
	}

	
}
