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
	
	//Constante a modifier en fonction de l'�cole ou la maison
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
			System.out.println("Erreur lors de la connexion � la base de donnees : " + erreur);
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
	* Fonction qui permet de v�rifier la connexion de l'utilisateur
	* @param login
	* @param motdePasse
	* @return true ou false
	*/
	public static boolean connexionUtilisateur(String login, String motdePasse) {
		//NomUser : eMusk mdpUser : Azerty123
		
		//maire : eMusk - Azerty123
		//secretaire : AEmmy - e
		//benevole : JAhmad - a
		boolean rep = false;
		int count = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS nbCo FROM Utilisateur WHERE loginUser = ? AND mdpUser = ?";
			pst = connexion.prepareStatement(sql);
			//Remplacer le ? par nom
			pst.setString(1, login);
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
	
	/**
	 * Fonction qui permet de v�rifier quel est le r�le de l'utilisateur connect� (pour le rediriger vers le bon controleur)
	 * @param login
	 * @param motdepasse
	 * @return le role de l'utilisateur
	 */
	public static String roleUtilisateur(String login, String motdepasse) {
		String sonRole = "";
		int count = 0;
		
		try {
			String sql = "SELECT roleUser FROM Utilisateur WHERE loginUser = ? AND mdpUser = ?";
			pst = connexion.prepareStatement(sql);
			//Remplacer le ? par nom
			pst.setString(1, login);
			//Remplacer le ? par le mdp
			pst.setString(2, motdepasse);
			
			rs = pst.executeQuery();
			
			rs.next();
			sonRole = rs.getString("roleUser");
		}catch(SQLException erreur) {
			System.out.println("Echec connexion bdd" + erreur);
		}
		return sonRole;
	}
	
	//---------------------METHODES POUR BENEVOLE---------------------
	
	/**
	 * Methode pour rechercher un article
	 * Rechercher un article pour voir si il existe
	 * @param unArticle
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
	 * Fonction pour ajouter un article,
	 * Ajouter des articles dans une collection
	 * @param unLibelle
	 * @param untypeArt
	 * @param unetatArt
	 * @param uncateArt
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
			// Ex�cute la requ�te d'insertion
			pst.executeUpdate();
			
			rep = true;
		}
		catch(Exception erreur) {
			System.out.println("Erreur de ajout de Article" + erreur);
		}
		
		
		return rep;
	}
	
	
	/**
	 * Methode pour supprimer un article,
	 * Supprimer un article.
	 * @param unArticle
	 * @eturn true ou false
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
	/**
	 * Methode pour le role Benevole;
	 * Consulter les catalogues
	 * @return les catalogues qui sont disponible a la vente
	 */
	public static ArrayList<Catalogue> consulterCatalogue() {
		String libelleCatalogue;
		String dateCatalogue;
		ArrayList<Catalogue> catalogue = new ArrayList<>();
		try {
			String sql = "SELECT libelleCat, dateCat FROM Catalogue WHERE etatCat = 'Disponible'";
			
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				libelleCatalogue = rs.getString("libelleCat");
				dateCatalogue = rs.getString("dateCat");
				
				//Instancier un nouveau catalogue et l'ajouter.
				Catalogue unCatalogue = new Catalogue(libelleCatalogue, dateCatalogue);
				
				catalogue.add(unCatalogue);
			}
		}
		catch(Exception erreur) {
			System.out.println("Erreur de r�cup�ration catalogue " + erreur);
		}
		
		return catalogue;
	}
	
	
	/**
	 * Methode pour le role Benevole;
	 * Consulter les historiques des catalogues (peu importe son etat)
	 * @return historiqueCat collection de historiqueCatalogue
	 */
	public static ArrayList<Catalogue> historiqueCatalogue(){
		ArrayList<Catalogue> historiqueCat = new ArrayList<>();
		String libelleCategorie;
		String dateCat;
		
		try {
			String sql = "SELECT idCat, idVenteEph, libelleCat, dateCat, etatCat FROM Catalogue WHERE etatCat = 'nonDisponible'";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				libelleCategorie = rs.getString("libelleCat");
				dateCat = rs.getString("dateCat");
				
				Catalogue unCatalogue = new Catalogue(libelleCategorie, dateCat);
				
				//Ajouter un catalogue non disponible a l'historique des catalogues
				historiqueCat.add(unCatalogue);
			}
			
		}catch(Exception erreur) {
			System.out.println("Erreur de recuperation historique Catalogue" + erreur);
		}

		return historiqueCat;
	}
}

	
