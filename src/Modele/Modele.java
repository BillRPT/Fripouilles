package Modele;
import java.sql. *;
import java.util.ArrayList;

import Class.*;

public class Modele {
	
	//Declarer les differents attributs
	private static Connection connexion;
	private	static Statement st;
	private static ResultSet rs;
	private static PreparedStatement pst;
	
	//Constante a modifier en fonction de l'ï¿½cole ou la maison
	private static String host = "172.16.203.206";
	private static String user = "sio";
	private static String mdp = "Vanille2010";
	
	/**
	* Procedure qui permet de se connecter a la bdd
	*/
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://" + host + "/fripouilles?zeroDateTimeBehavior=CO" + 
			"NVERT_TO_NULL&serverTimezone=UTC", user, mdp);
			
			st = connexion.createStatement();
		}
		catch (ClassNotFoundException erreur){
			System.out.println("Le chargeur n'as pas ete charge " + erreur);
		}
		catch(SQLException erreur) {
			System.out.println("Erreur lors de la connexion ï¿½ la base de donnees : " + erreur);
		}
	}
	
	
	/**
	* Procedure qui permet de fermer la connexion a la bdd
	*/
	public static void fermetureBdd() {
		//Verifier que connexion n'est pas null avant de fermer
		if (connexion != null) {
			try {
				connexion.close();
			}catch(SQLException erreur) {
				System.out.println("Echec de la fermeture de la base de donnees : " + erreur);
			}
		}
	}
	
	/**
	* Fonction qui permet de fermer la connexion a la bdd
	* @param nom
	* @param motdePasse
	* @return true ou false
	*/
	public static boolean connexionUtilisateur(String nom, String motdePasse) {
		//NomUser : eMusk mdpUser : Azerty123
		
		//maire : eMusk - Azerty123
		//secretaire : AEmmy - e
		//benevole : ahmad - a
		boolean rep = false;
		int count = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS nbCo FROM Utilisateur WHERE loginUser = ? AND mdpUser = ?";
			pst = connexion.prepareStatement(sql);
			//Remplacer le ? par nom
			pst.setString(1, nom);
			//Remplacer le ? par motdePasse
			pst.setString(2, motdePasse);
			
			rs = pst.executeQuery();
			
			rs.next();
			count = rs.getInt("nbCo"); // recupere la colonne nbCo du resultat
			
			if (count == 1) {
				rep = true;
			}
			
		}catch(SQLException erreur) {
			System.out.println("Echec de la connexion a la base de donnees : " + erreur);
		}
		
		return rep;
	}
	
	//---------------------METHODES POUR BENEVOLE---------------------
	/**
	 * Méthode pour le rôle Bénévole,
	 * Ajouter un article
	 */
	
	public static boolean ajouterArticle(/*a completer*/) {
		boolean rep = false;
		//a completer
		return rep;
	}
	
	/**
	 * Méthode pour le rôle Bénévole,
	 * Supprimer un article
	 */
	
	public static boolean supprimerArticle(/*a completer*/) {
		boolean rep = false;
		//a completer
		return rep;
	}
	
	/**
	 * Méthode pour le rôle Bénévole;
	 * Afficher l'historique des catalogues (peu importe son état)
	 */
	
	public static ArrayList<Catalogue> historiqueCatalogue(){
		ArrayList<Catalogue> historiqueCat = new ArrayList<>();
		//a completer
		return historiqueCat;
	}
	//---------------------METHODES POUR MAIRE---------------------
	/**
	 * Méthode pour le rôle Maire
	 * Consulter les catalogues (état en vente)
	 */
	
	public static ArrayList<Catalogue> lesCatalogues(){
		ArrayList<Catalogue> lesCat = new ArrayList<>();
		
		return lesCat;
	}
}
