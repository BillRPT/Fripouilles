package Modele;
import java.sql. *;

public class Modele {
	
	//Déclarer les différents attributs
	private static Connection connexion;
	private	static Statement st;
	private static ResultSet rs;
	private static PreparedStatement pst;
	
	/**
	* Procèdure qui permet de se connecter a la bdd
	*/
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.212/fripouilles?zeroDateTimeBehavior=CO" + 
			"NVERT_TO_NULL&serverTimezone=UTC", "sio", "Azerty123!");
			
			st = connexion.createStatement();
		}
		catch (ClassNotFoundException erreur){
			System.out.println("Le chargeur n'as pas été chargé " + erreur);
		}
		catch(SQLException erreur) {
			System.out.println("Erreur lors de la connexion à la base de données : " + erreur);
		}
	}
	
	
	/**
	* Procèdure qui permet de fermer la connexion a la bdd
	*/
	public static void fermetureBdd() {
		//Vérifier que connexion n'est pas null avant de fermer
		if (connexion != null) {
			try {
				connexion.close();
			}catch(SQLException erreur) {
				System.out.println("Echec de la fermeture de la base de données : " + erreur);
			}
		}
	}
	
	/**
	* Fonction qui permet de fermer la connexion a la bdd
	*/
	public static void connexionUtilisateur(String nom, String motdePasse) {
		try {
			String sql = "SELECT COUNT(*) FROM utilisateur WHERE nomUser = ? AND mdpUser = ?";
			pst = connexion.prepareStatement(sql);
			//Remplacer le ? par nom
			pst.setString(1, nom);
			//Remplacer le ? par motdePasse
			pst.setString(2, motdePasse);
		}catch(SQLException erreur) {
			System.out.println("Echec de la connexion a la base de données : " + erreur);
		}
	}
	
}
