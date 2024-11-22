package Fonction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Fonction {
	
	/**
	* Fonction qui hash en md5 une chaine de caractere
	* @param input 
	* @return une chaine de caractere hasher en md5
	*/
	public static String hashMD5(String input) {
		StringBuilder hexString = new StringBuilder();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
	        byte[] messageDigest = md.digest(input.getBytes());

	        for (byte b : messageDigest) {
	            String hex = Integer.toHexString(0xff & b);
	            if (hex.length() == 1) {
	                hexString.append('0');
	            }
	            hexString.append(hex);
	        }
	        
		}catch(NoSuchAlgorithmException erreur) {
			System.out.println("Erreur hashage md5 " + erreur);
		}
		
		return hexString.toString();
	}
}
