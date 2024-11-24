package Modele;
import java.sql. *;

public class Modele {
	
	//Declarer les differents attributs
	private static Connection connexion;
	private	static Statement st;
	private static ResultSet rs;
	private static PreparedStatement pst;
	
	/**
	* Procedure qui permet de se connecter a la bdd
	*/
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/fripouilles?zeroDateTimeBehavior=CO" + 
			"NVERT_TO_NULL&serverTimezone=UTC", "root", "");
			
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
	* Fonction qui permet de fermer la connexion a la bdd
	* @param nom
	* @param motdePasse
	* @return true ou false
	*/
	public static boolean connexionUtilisateur(String nom, String motdePasse) {
		//NomUser : eMusk mdpUser : Azerty123
		boolean rep = false;
		int count = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS nbCo FROM utilisateur WHERE loginUser = ? AND mdpUser = ?";
			pst = connexion.prepareStatement(sql);
			//Remplacer le ? par nom
			pst.setString(1, nom);
			//Remplacer le ? par motdePasse
			pst.setString(2, motdePasse);
			
			rs = pst.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("nbCo"); // Récupère la colonne nbCo du résultat
	        }
			
			if (count == 1) {
				rep = true;
			}
			
		}catch(SQLException erreur) {
			System.out.println("Echec de la connexion a la base de donnees : " + erreur);
		}
		
		return rep;
	}
	
}
