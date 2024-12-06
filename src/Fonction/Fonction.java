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
	        // Convertir le tableau de caractères en chaîne
	        String passwordString = new String(password);
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] messageDigest = md.digest(passwordString.getBytes());

	        // Conversion des octets en représentation hexadécimale
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
	 * Mï¿½thode pour redimensionner le logo
	 * @param icon
	 * @param width
	 * @param height
	 * @return
	 */
	// Mï¿½thode pour redimensionner l'ImageIcon
	public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
	    Image img = icon.getImage();  // Obtenir l'image ï¿½ partir de l'ImageIcon
	    Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Redimensionner l'image
	    return new ImageIcon(resizedImg);  // Retourner une nouvelle ImageIcon avec l'image redimensionnï¿½e
	}
	
}
