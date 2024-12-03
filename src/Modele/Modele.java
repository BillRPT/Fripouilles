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
	private static String host = "localhost";
	private static String user = "root";
	private static String mdp = "";
	
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
	 * Mï¿½thode pour le rï¿½le Bï¿½nï¿½vole,
	 * Rechercher un article pour voir si il existe
	 * @return true ou false
	 */
	public static boolean rechercherArticle(String unArticle) {
		int chiffre = 0;
		boolean rep = false;
		try {
			
			String sql = "SELECT COUNT(*) AS NB FROM Article WHERE libelleArt = ?";
			
			pst = connexion.prepareStatement(sql);
			
			//Remplacer le ? par unLibelle
			pst.setString(1, unArticle);

			ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	chiffre = rs.getInt("nb");
	         }
	        
	        if (chiffre == 1) {
	        	rep = true;
	        }
			
		}catch(Exception erreur) {
			System.out.println("Erreur de recherche article " + erreur);
		}
		
		return rep;
	}
	
	
	/**
	 * Mï¿½thode pour le rï¿½le Bï¿½nï¿½vole,
	 * Ajouter un article
	 * @return true ou false
	 */
	public static boolean ajouterArticle(String unLibelle, String untypeArt, String unetatArt, String uncateArt) {
		boolean rep = false;
		
		try {
			String sql = "INSERT INTO Article (libelleArt, typeArt, etatArt, cateArt) VALUES (?, ?, ?, ?)";
			
			pst = connexion.prepareStatement(sql);
			
			//Remplacer le ? par unLibelle
			pst.setString(1, unLibelle);
			//Remplacer le ? par untypeArt
			pst.setString(2, untypeArt);
			//Remplacer le ? par untypeArt
			pst.setString(3, unetatArt);
			//Remplacer le ? par untypeArt
			pst.setString(4, uncateArt);
			// Exï¿½cute la requï¿½te d'insertion
			pst.executeUpdate();
			
			rep = true;
		}
		catch(Exception erreur) {
			System.out.println("Erreur de ajout de Article" + erreur);
		}
		
		
		return rep;
	}
	
	
	/**
	 * Mï¿½thode pour le rï¿½le Bï¿½nï¿½vole,
	 * Supprimer un article.
	 */
	public static boolean supprimerArticle(String unArticle) {
		boolean rep = false;
		
		if (rechercherArticle(unArticle) == true) {
			try {
				String sql = "DELETE FROM Article WHERE libelleArt = ?";
				
				pst = connexion.prepareStatement(sql);
				
				//Remplacer le ? par unArticle
				pst.setString(1, unArticle);
				
				pst.executeUpdate();
				
				rep = true;
				
			}catch(Exception erreur) {
				System.out.println("Erreur de suppresion de article " + erreur);
			}
		}
		
		return rep;
	}
	
	//---------------------METHODES POUR MAIRE---------------------
		//a completer...
	
	public static ArrayList<Catalogue> consulterCatalogue() {
		ArrayList<Catalogue> catalogue = new ArrayList<>();
		try {
			String sql = "SELECT ";
		}
		catch(Exception erreur) {
			System.out.println("Erreur de récupération catalogue " + erreur);
		}
		
		return catalogue;
	}
	
	
	/**
	 * Methode pour le role Benevole;
	 * Afficher l'historique des catalogues (peu importe son etat)
	 */
	
	public static ArrayList<Catalogue> historiqueCatalogue(){
		ArrayList<Catalogue> historiqueCat = new ArrayList<>();
		
		try {
			String sql = "SELECT idCat, idVenteEph, libelleCat, dateCat, etatCat FROM Catalogue WHERE etatCat = nonDisponible";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Catalogue unCatalogue = new Catalogue();
				
			}
			
		}catch(Exception erreur) {
			System.out.println("Erreur de rï¿½cupï¿½ration historique Catalogue" + erreur);
		}

		return historiqueCat;
	}
}

	
