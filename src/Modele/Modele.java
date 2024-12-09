package Modele;
import java.sql. *;
import java.util.ArrayList;

import Class.*;
import Fonction.Fonction;

public class Modele {
	
	//Declarer les differents attributs
	private static Connection connexion;
	private	static Statement st;
	private static ResultSet rs;
	private static PreparedStatement pst;
	
	//Constante a modifier en fonction de l'�cole ou la maison
	private static String host = "172.16.203.212";
	private static String user = "sio";
	private static String mdp = "Azerty123!";


	
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
	* Fonction qui permet de verifier la connexion de l'utilisateur
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
			String sql = "SELECT COUNT(*) AS nbCo FROM utilisateur WHERE loginUser = ? AND mdpUser = ?";
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
	 * Fonction qui permet de verifier quel est le role de l'utilisateur connect� (pour le rediriger vers le bon controleur)
	 * @param login
	 * @param motdepasse
	 * @return le role de l'utilisateur
	 */
	public static String roleUtilisateur(String login, String motdepasse) {
		String sonRole = "";
		int count = 0;
		
		try {
			String sql = "SELECT roleUser FROM utilisateur WHERE loginUser = ? AND mdpUser = ?";
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
	
	/**
	 * Methode pour le role Benevole;
	 * Consulter les catalogues
	 * @return les catalogues qui sont disponible a la vente
	 */
	
	//---------------------METHODES POUR LE SECRETAIRE---------------------
	public static ArrayList<Catalogue> consulterCatalogue() {
		String idCat;
		String idVenteEph;
		String libelleCatalogue;
		String dateCatalogue;
		ArrayList<Catalogue> catalogue = new ArrayList<>();
		try {
			String sql = "SELECT idCat, idVenteEph , libelleCat, dateCat FROM Catalogue WHERE etatCat = 'Disponible'";
			
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				idCat = rs.getString("idCat");
				idVenteEph = rs.getString("idVenteEph");
				libelleCatalogue = rs.getString("libelleCat");
				dateCatalogue = rs.getString("dateCat");
				
				//Instancier un nouveau catalogue et l'ajouter.
				Catalogue unCatalogue = new Catalogue(libelleCatalogue, dateCatalogue, idCat, idVenteEph);
				
				catalogue.add(unCatalogue);
			}
		}
		catch(Exception erreur) {
			System.out.println("Erreur de recuperation0 catalogue " + erreur);
		}
		
		return catalogue;
	}
	
	/**
	 * Methode pour le role Secretaire;
	 * Consulter les Ventes
	 * @return une liste de toute les ventes existantes
	 */
	
	public static ArrayList<VenteEphemere> consulterlesVentes() {
		String idVenteEph;
		String dateEph;
		String typeVente;
		String nomVente;
		
		ArrayList<VenteEphemere> lesVentes = new ArrayList<VenteEphemere>();
		
		try {
			String sql = "SELECT idVenteEph, dateEph, typeVente, nomVente FROM Vente";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				idVenteEph = rs.getString("idVenteEph");
				dateEph = rs.getString("dateEph");
				typeVente = rs.getString("typeVente");
				nomVente = rs.getString("nomVente");
				
				VenteEphemere uneVente = new VenteEphemere(idVenteEph, dateEph, typeVente, nomVente);
				lesVentes.add(uneVente);
			}
		}
		catch(Exception erreur) {
			System.out.println("Erreur de consultation des ventes " + erreur);
		}
		
		return lesVentes;
	}
	
	
	/**
	 * Methode pour le role Benevole;
	 * Consulter les historiques des catalogues (peu importe son etat)
	 * @return historiqueCat collection de historiqueCatalogue
	 */
	public static ArrayList<Catalogue> historiqueCatalogue(){
		ArrayList<Catalogue> historiqueCat = new ArrayList<>();
		String idCat;
		String idVenteEph;
		String libelleCatalogue;
		String dateCatalogue;
		
		try {
			String sql = "SELECT idCat, idVenteEph, libelleCat, dateCat, etatCat FROM Catalogue WHERE etatCat = 'nonDisponible'";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				idCat = rs.getString("idCat");
				idVenteEph = rs.getString("idVenteEph");
				libelleCatalogue = rs.getString("libelleCat");
				dateCatalogue = rs.getString("dateCat");
				
				Catalogue unCatalogue = new Catalogue(libelleCatalogue, dateCatalogue, idCat, idVenteEph);
				
				//Ajouter un catalogue non disponible a l'historique des catalogues
				historiqueCat.add(unCatalogue);
			}
			
		}catch(Exception erreur) {
			System.out.println("Erreur de recuperation historique Catalogue" + erreur);
		}

		return historiqueCat;
	}
	
	
	public static void ajouterBenevole(String nomUser, String prenomUser, String loginUser, char[] mdpUser) {
		
		try {
			String sql = "INSERT INTO utilisateur (nomUser, prenomUser, mdpUser, loginUser, roleUser) VALUES (?, ?, ?, ?, 'benevole')";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, nomUser);
			
			pst.setString(2, prenomUser);
			
			pst.setString(3, Fonction.hashMD5(mdpUser));
			
			//Hash le mdp et le mettre en string
			pst.setString(4, loginUser);
			
			
			pst.executeUpdate();
		}
		catch(Exception erreur) {
			System.out.println("Erreur d'ajout de benevole " + erreur);
		}
	}
	
	public static boolean rechercherVente(String uneVente) {
		boolean rep = false;
		int chiffre = 0;
		
		try {
			String sql = "SELECT COUNT(nomVente) AS nb FROM Vente Where nomVente = ?";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, uneVente);
			
			ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	chiffre = rs.getInt("nb");
	         }
	        
	        if (chiffre == 1) {
	        	rep = true;
	        }
		}
		catch(Exception erreur) {
			System.out.println("Erreur rechercher vente " + erreur);
		}
		
		return rep;
	}
	
	
	/**
	 * Methode pour ajouter une vente
	 * @param unnomVente, unedateVente, untypeVente
	 */
	public static void ajouterVente(String unnomVente, String unedateVente, String untypeVente) {
		try {
			String sql = "INSERT INTO Vente (nomVente, dateEph, typeVente) VALUES (?, ?, ?)";
			
			//Convertir la date type string en type date pour l'insertion
			
			Date sqlDate = Date.valueOf(unedateVente);
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, unnomVente);
			
			pst.setDate(2, sqlDate);
			
			pst.setString(3, untypeVente);
			
			pst.executeUpdate();
		}
		catch(Exception erreur) {
			System.out.println("erreur de insertion de vente " + erreur);
		}
	}
	
	public static boolean supprimerVente(String unnomVente) {
		boolean rep = false;
		try {
			String sql = "Delete FROM vente WHERE nomVente = ?";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, unnomVente);
			
			int ligne = pst.executeUpdate();
			
			if (ligne > 0) {
			    rep = true;
			}
		}
		catch (Exception erreur) {
			System.out.println("Erreur de suppresion vente" + erreur);
		}
		
		return rep;
	}
	
	public static boolean supprimerBenevole(String unBenevole) {
		boolean rep = false;
		try {
			String sql = "DELETE FROM utilisateur WHERE loginUser = ?";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, unBenevole);
			
			int ligne = pst.executeUpdate();
			
			if (ligne > 0) {
			    rep = true;
			}
		}
		catch(Exception erreur) {
			System.out.println("Erreur supression benevole " + erreur);
		}
		
		return rep;
	}
	
	public static boolean verifierRole(String user) {
		boolean rep = false;
		int chiffre = 0;
		
		try {
			String sql = "SELECT COUNT(idUser) as nb FROM utilisateur WHERE loginUser = ? AND roleUser = 'benevole'";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, user);
			
			ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	chiffre = rs.getInt("nb");
	         }
	        
	        if (chiffre == 1) {
	        	rep = true;
	        }
		}
		catch(Exception erreur) {
			System.out.println("Erreur de r�cup�ration de role" + erreur);
		}
		
		return rep;
	}
	
}




