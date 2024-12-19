package Modele;
import java.sql. *;
import java.util.ArrayList;

import org.jdesktop.swingx.JXDatePicker;

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
	 * Fonction qui permet de verifier quel est le role de l'utilisateur connect� (pour le rediriger vers le bon controleur)
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
			
			String sql = "SELECT COUNT(*) AS nb FROM Article WHERE libelleArt = ?";
			
			pst = connexion.prepareStatement(sql);
			
			//Remplacer le ? par unLibelle
			pst.setString(1, unArticle);

			ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	chiffre = rs.getInt("nb");
	         }
	        
	        if (chiffre != 0) {
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
	public static boolean ajouterArticle(String unLibelle, String untypeArt, String uncateArt) {
	    boolean rep = false;
	    
	    try {
	        //vérif si la catégorie existe
	        String checkCatSql = "SELECT idCat FROM Catalogue WHERE libelleCat = ?";
	        pst = connexion.prepareStatement(checkCatSql);
	        pst.setString(1, uncateArt);
	        ResultSet rs = pst.executeQuery();

	        int idCatalogue;
	        if (rs.next()) {
	            //recup l'id de la catégorie existante
	            idCatalogue = rs.getInt("idCat");
	        } else {
	            throw new Exception("La categorie specifiee n'existe pas.");
	        }

	        //aj l'article
	        String insertArticleSql = "INSERT INTO Article (libelleArt, typeArt, etatArt) VALUES (?, ?, 'En vente')";
	        pst = connexion.prepareStatement(insertArticleSql, Statement.RETURN_GENERATED_KEYS);
	        pst.setString(1, unLibelle);
	        pst.setString(2, untypeArt);
	        pst.executeUpdate();

	        //recup l'id de l'article
	        rs = pst.getGeneratedKeys();
	        int idArticle;
	        if (rs.next()) {
	            idArticle = rs.getInt(1);
	        } else {
	            throw new Exception("Erreur lors de la récupération de l'id de l'article inséré.");
	        }

	        //ajouter une liaison dans la table article_catalogue
	        String insertLinkSql = "INSERT INTO article_catalogue (idArt, idCat) VALUES (?, ?)";
	        pst = connexion.prepareStatement(insertLinkSql);
	        pst.setInt(1, idArticle);
	        pst.setInt(2, idCatalogue);
	        pst.executeUpdate();

	        rep = true;
	    } catch (Exception erreur) {
	        System.out.println("Erreur lors de l'ajout de l'article : " + erreur.getMessage());
	    }

	    return rep;
	}

	/**
	 * Fonction pour ajouter un article sans catalogue
	 * Ajouter des articles dans une collection
	 * @param unLibelle
	 * @param untypeArt
	 * @param unetatArt
	 * @return true ou false
	 */
	
	public static boolean ajouterArticle(String unLibelle, String untypeArt) {
		boolean rep = false;
		
		try {
			String sql = "INSERT INTO Article (libelleArt, typeArt, etatArt) VALUES (?, ?, 'En vente')";
			
			pst = connexion.prepareStatement(sql);
			
			//Remplacer le ? par unLibelle
			pst.setString(1, unLibelle);
			//Remplacer le ? par untypeArt
			pst.setString(2, untypeArt);
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

	    if (rechercherArticle(unArticle)) {
	        try {
	            //récupérer l'id de l'article à partir de son libellé
	            String getIdArticleSql = "SELECT idArt FROM Article WHERE libelleArt = ?";
	            pst = connexion.prepareStatement(getIdArticleSql);
	            pst.setString(1, unArticle);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                int idArticle = rs.getInt("idArt");

	                //supprimer l(entrée de la table article_catalogue
	                String deleteFromArticleCatalogueSql = "DELETE FROM Article_Catalogue WHERE idArt = ?";
	                pst = connexion.prepareStatement(deleteFromArticleCatalogueSql);
	                pst.setInt(1, idArticle);
	                pst.executeUpdate();

	                //supprimer l'article de la table Article
	                String deleteArticleSql = "DELETE FROM Article WHERE idArt = ?";
	                pst = connexion.prepareStatement(deleteArticleSql);
	                pst.setInt(1, idArticle);
	                pst.executeUpdate();

	                rep = true;
	            } else {
	                System.out.println("Article non trouvé pour le libellé : " + unArticle);
	            }
	        } catch (Exception erreur) {
	            System.out.println("Erreur lors de la suppression de l'article : " + erreur.getMessage());
	        }
	    }

	    return rep;
	}
	
	/**
	 * recup tt les articles dans une liste
	 * @return
	 */
	
	public static ArrayList<Article> afficherArticles() {
		int idArt;
		String libelleArt;
		String typeArt;
		String etatArt;
		
		ArrayList<Article> lesArticles = new ArrayList<Article>();
		
		try {
			String sql = "SELECT * FROM Article";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				idArt = rs.getInt("idArt");
				libelleArt = rs.getString("libelleArt");
				typeArt = rs.getString("typeArt");
				etatArt = rs.getString("etatArt");
				
				Article unArticle = new Article(idArt, libelleArt, typeArt, etatArt);
				lesArticles.add(unArticle);
			}
		}
		catch(Exception erreur) {
			System.out.println("Erreur de consultation des ventes " + erreur);
		}
		
		return lesArticles;
	}
	
	/**
	 * Méthode pour ajouter un catalogue
	 * @param libelle
	 * @param date
	 * 
	 */
	public static boolean ajouterCatalogue(String libelle, Date date) {
		boolean rep = false;
		
		try {
			String sql = "INSERT INTO Catalogue (libelleCat, dateCat, etatCat) VALUES (?,?, 'Disponible')";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, libelle);
			pst.setDate(2, date);
			pst.executeUpdate();
			rep = true;
		}
		catch(Exception erreur) {
			System.out.println("Erreur de ajout de Article" + erreur);
		}
		return rep;
	}
	
	/**
	 * Rechercher un catalogue
	 * @param libelle
	 * @return
	 */
	
	public static boolean rechercherCatalogue(String libelle) {
		int chiffre = 0;
		boolean rep = false;
		try {
			
			String sql = "SELECT COUNT(*) AS NB FROM Catalogue WHERE libelleCat = ?";
			
			pst = connexion.prepareStatement(sql);
			
			//Remplacer le ? par unLibelle
			pst.setString(1, libelle);

			ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	chiffre = rs.getInt("nb");
	         }
	        
	        if (chiffre == 1) {
	        	rep = true;
	        }
			
		}catch(Exception erreur) {
			System.out.println("Erreur de recherche catalogue " + erreur);
		}
		
		return rep;
	}
	
	/**
	 * Supprimer un catalogue
	 * @param libelle
	 * @return
	 */
	
	public static boolean supprimerCatalogue(String libelle) {
		 boolean rep = false;

		    if (rechercherCatalogue(libelle)) {
		        try {
		            //récupérer l'id du cat
		            String getIdArticleSql = "SELECT idCat FROM Catalogue WHERE libelleCat = ?";
		            pst = connexion.prepareStatement(getIdArticleSql);
		            pst.setString(1, libelle);
		            ResultSet rs = pst.executeQuery();

		            if (rs.next()) {
		                int idCat = rs.getInt("idCat");

		                //supprimer l(entrée de la table article_catalogue
		                String deleteFromArticleCatalogueSql = "DELETE FROM Article_Catalogue WHERE idCat = ?";
		                pst = connexion.prepareStatement(deleteFromArticleCatalogueSql);
		                pst.setInt(1, idCat);
		                pst.executeUpdate();

		                //supprimer l'article de la table Article
		                String deleteArticleSql = "DELETE FROM Catalogue WHERE idCat = ?";
		                pst = connexion.prepareStatement(deleteArticleSql);
		                pst.setInt(1, idCat);
		                pst.executeUpdate();

		                rep = true;
		            } else {
		                System.out.println("Article non trouvé pour le libellé : " + libelle);
		            }
		        } catch (Exception erreur) {
		            System.out.println("Erreur lors de la suppression de l'article : " + erreur.getMessage());
		        }
		    }

		    return rep;
	}
	
	/**
	 * Methode pour le role Maire;
	 * Consulter les catalogues
	 * @return les catalogues qui sont disponible a la vente
	 */
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
			System.out.println("Erreur de recuperation catalogue " + erreur);
		}
		
		return catalogue;
	}
	
	/**
	 * Méthode pour ajouter un article dans un catalogue, bénévole
	 * @param article
	 * @param catalogue
	 * @return
	 */
	
	public static boolean ajouterArtCat(String article, String catalogue) {
		boolean rep = false;
		
		if (rechercherCatalogue(catalogue)) {
		    try {
		        //récup l'id du catalogue
		        String getIdCatSql = "SELECT idCat FROM Catalogue WHERE libelleCat = ?";
		        pst = connexion.prepareStatement(getIdCatSql);
		        pst.setString(1, catalogue);
		        ResultSet rs = pst.executeQuery();

		        if (rs.next()) {
		            int idCat = rs.getInt("idCat");

		            if (rechercherArticle(article)) {
		                //recup l'id de l'article
		                String getIdArticleSql = "SELECT idArt FROM Article WHERE libelleArt = ?";
		                pst = connexion.prepareStatement(getIdArticleSql);
		                pst.setString(1, article);
		                ResultSet rss = pst.executeQuery();

		                if (rss.next()) {
		                    int idArt = rss.getInt("idArt");

		                    //ajouter l'article au catalogue
		                    String addArticleSql = "INSERT INTO Article_Catalogue VALUES (?, ?)";
		                    pst = connexion.prepareStatement(addArticleSql);
		                    pst.setInt(1, idArt);
		                    pst.setInt(2, idCat);
		                    pst.executeUpdate();

		                    rep = true;
		                } else {
		                    System.out.println("Aucun article trouvé pour le libellé : " + article);
		                }
		            } else {
		                System.out.println("Article non présent dans la base pour : " + article);
		            }
		        } else {
		            System.out.println("Catalogue non trouvé pour le libellé : " + catalogue);
		        }
		    } catch (SQLException sqlErreur) {
		        System.out.println("Erreur SQL : " + sqlErreur.getMessage());
		    } catch (Exception erreur) {
		        System.out.println("autre erreur : " + erreur.getMessage());
		    }
		} else {
		    System.out.println("Le catalogue " + catalogue + " n'existe pas.");
		}

		return rep;
	}
	
	/**
	 * Méthode pour rechercher un article d'un catalogue, bénévole
	 * @param article
	 * @param catalogue
	 * @return
	 */
	
	public static boolean rechercherArtCat(String article, String catalogue) {
	    boolean rep = false;

	    String sql = "SELECT COUNT(*) AS nb FROM Article_Catalogue ac "
	    		+ "JOIN Article a ON ac.idArt = a.idArt JOIN Catalogue c "
	    		+ "ON ac.idCat = c.idCat WHERE a.libelleArt = ? AND c.libelleCat = ?";

	    try (PreparedStatement pst = connexion.prepareStatement(sql)) {
	        pst.setString(1, article);
	        pst.setString(2, catalogue);

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                int count = rs.getInt("nb");
	                rep = count > 0;
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Erreur SQL : " + e.getMessage());
	    }

	    return rep;
	}
	
	/**
	 * Méthode pour suprimer un article d'un catalogue, pour bénévole
	 * @param article
	 * @param catalogue
	 * @return
	 */
	
	public static boolean supprimerArtCat(String article, String catalogue) {
	    boolean rep = false;

	    String sql = "DELETE FROM Article_Catalogue "
	    		+ "WHERE idArt = (SELECT idArt FROM Article WHERE libelleArt = ?)"
	    		+ "AND idCat = (SELECT idCat FROM Catalogue WHERE libelleCat = ?)";

	    try (PreparedStatement pst = connexion.prepareStatement(sql)) {
	        pst.setString(1, article);
	        pst.setString(2, catalogue);

	        int rowsAffected = pst.executeUpdate();
	        rep = rowsAffected > 0; 
	    } catch (SQLException e) {
	        System.out.println("Erreur SQL : " + e.getMessage());
	    }

	    return rep;
	}
	
	public static ArrayList<Article> consulterArtCat(String libelleCat) {
	    ArrayList<Article> lesArticles = new ArrayList<>();
	    int idCat;
	    int idArt;
	    String libelleArt;
	    String typeArt;
	    String etatArt;

	    String sqlCat = "SELECT idCat FROM Catalogue WHERE libelleCat = ?";
	    String sqlArticles = "SELECT a.idArt, a.libelleArt, a.typeArt, a.etatArt " +
	                         "FROM Article a JOIN Article_Catalogue ac ON a.idArt = ac.idArt " +
	                         "WHERE ac.idCat = ?";

	    try {
	        PreparedStatement pstCat = connexion.prepareStatement(sqlCat);
	        pstCat.setString(1, libelleCat);
	        ResultSet rsCat = pstCat.executeQuery();

	        if (rsCat.next()) {
	            idCat = rsCat.getInt("idCat");

	            PreparedStatement pstArt = connexion.prepareStatement(sqlArticles);
	            pstArt.setInt(1, idCat);
	            ResultSet rsArt = pstArt.executeQuery();

	            while (rsArt.next()) {
	                idArt = rsArt.getInt("idArt");
	                libelleArt = rsArt.getString("libelleArt");
	                typeArt = rsArt.getString("typeArt");
	                etatArt = rsArt.getString("etatArt");

	                Article unArticle = new Article(idArt, libelleArt, typeArt, etatArt);
	                lesArticles.add(unArticle);
	            }

	            rsArt.close();
	            pstArt.close();
	        } else {
	            System.out.println("Aucune catégorie trouvée pour le libellé : " + libelleCat);
	        }
	        // Fermeture des ressources liées à la catégorie
	        rsCat.close();
	        pstCat.close();
	    } catch (SQLException e) {
	        System.out.println("Erreur lors de la consultation des articles : " + e.getMessage());
	    }
	    return lesArticles;
	}
	/**
	 * Methode pour le role Secretaire;
	 * Consulter les Ventes
	 * @return une liste de toute les ventes existantes
	 */
	
	public static ArrayList<VenteEphemere> consulterlesVentes() {
		int idVenteEph;
		String dateEph;
		String typeVente;
		String nomVente;
		
		ArrayList<VenteEphemere> lesVentes = new ArrayList<VenteEphemere>();
		
		try {
			String sql = "SELECT idVenteEph, dateEph, typeVente, nomVente FROM Vente";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				idVenteEph = rs.getInt("idVenteEph");
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
	 * Methode pour le role secretaire;
	 * Consulter les historiques des catalogues (peu importe son etat)
	 * @return historiqueCat collection de historiqueCatalogue
	 */
	public static ArrayList<Catalogue> historiqueCatalogue(){
		ArrayList<Catalogue> historiqueCat = new ArrayList<>();
		String idCat;
		String idVenteEph;
		String libelleCatalogue;
		String dateCatalogue;
		String etatCat;
		
		try {
			String sql = "SELECT idCat, idVenteEph, libelleCat, dateCat, etatCat FROM Catalogue";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				idCat = rs.getString("idCat");
				idVenteEph = rs.getString("idVenteEph");
				libelleCatalogue = rs.getString("libelleCat");
				dateCatalogue = rs.getString("dateCat");
				etatCat = rs.getString("etatCat");
				
				Catalogue unCatalogue = new Catalogue(libelleCatalogue, dateCatalogue, idCat, idVenteEph, etatCat);
				
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
			String sql = "INSERT INTO Utilisateur (nomUser, prenomUser, mdpUser, loginUser, roleUser) VALUES (?, ?, ?, ?, 'benevole')";
			
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
			String sql = "Delete FROM Vente WHERE nomVente = ?";
			
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
			String sql = "DELETE FROM Utilisateur WHERE loginUser = ?";
			
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
		//test
		try {
			String sql = "SELECT COUNT(idUser) as nb FROM Utilisateur WHERE loginUser = ? AND roleUser = 'benevole'";
			
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
	
	public static boolean rechercherBenevole(String user) {
		boolean rep = false;
		int chiffre = 0;
		
		try {
			String sql = "SELECT COUNT(idUser) AS nb FROM Utilisateur Where loginUser = ? AND roleUser = 'benevole'";
			
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
			System.out.println("Erreur rechercher benevole " + erreur);
		}
		
		return rep;
	}
	
	public static ArrayList<Utilisateur> consulterBenevole(){
		ArrayList<Utilisateur> lesUtilisateur = new ArrayList<>();
		String nom;
		String prenom;
		String login;
		try {
			String sql = "SELECT nomUser, prenomUser, loginUser FROM Utilisateur WHERE roleUser = 'benevole'";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				nom = rs.getString("nomUser");
				prenom = rs.getString("prenomUser");
				login = rs.getString("loginUser");
				Utilisateur unUtilisateur = new Utilisateur(nom, prenom, login);
				
				//Ajouter un catalogue non disponible a l'historique des catalogues
				lesUtilisateur.add(unUtilisateur);
			}
			
		}catch(Exception erreur) {
			System.out.println("Erreur de recuperation historique Catalogue" + erreur);
		}

		return lesUtilisateur;
	}
	
	public static boolean rechercherUtilisateur(String user) {
		boolean rep = false;
		int chiffre = 0;
		
		try {
			String sql = "SELECT COUNT(idUser) AS nb FROM Utilisateur Where loginUser = ?";
			
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
			System.out.println("Erreur rechercher utilisateur " + erreur);
		}
		
		return rep;
	}
	
	public static ArrayList<VenteEphemere> consulterStatistiques() {
		
		ArrayList<VenteEphemere> lesStats = new ArrayList<VenteEphemere>();
		
		int idVenteEph;
		String unNom;
		String dateEph;
		String typeVente;
		String etatCat;
		int nbArticlesVendues;
		
		try {
			String sql = "SELECT Vente.nomVente, Vente.idVenteEph, Vente.dateEph, Vente.typeVente, Catalogue.etatCat,COUNT(Article_Catalogue.idArt) AS nbArticlesVendus\r\n" + 
					"FROM Vente, Article_Catalogue, Catalogue, Article\r\n" + 
					"WHERE Vente.idVenteEph = Catalogue.idVenteEph\r\n" + 
					"AND Article_Catalogue.idCat = Catalogue.idCat\r\n" + 
					"AND Article_Catalogue.idArt = Article.idArt\r\n" + 
					"AND Article.etatArt = 'Vendu'\r\n" + 
					"GROUP BY Vente.idVenteEph, Vente.dateEph, Vente.typeVente, Catalogue.etatCat\r\n" + 
					"ORDER BY Vente.dateEph";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				idVenteEph = rs.getInt("idVenteEph");
				dateEph = rs.getString("dateEph");
				typeVente = rs.getString("typeVente");
				etatCat = rs.getString("etatCat");
				nbArticlesVendues = rs.getInt("nbArticlesVendues");
				unNom = rs.getString("nomVente");
				
				VenteEphemere uneVente = new VenteEphemere(idVenteEph, dateEph, typeVente, unNom, etatCat, nbArticlesVendues);
				
				lesStats.add(uneVente);
				
			}
		}
		catch(Exception erreur) {
			System.out.println("Erreur de statistique " + erreur);
		}
		
		return lesStats;
	}
	
	
	public static int getidVente(String unNomVente) {
		int chiffre = 0;
		
		try {
			String sql = "SELECT idVenteEph FROM Vente WHERE nomVente = ?";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, unNomVente);
			
			ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	chiffre = rs.getInt("idVenteEph");
	         }
			
		}
		catch(Exception erreur) {
			System.out.println("erreur de recuperation de id vente " + erreur);
		}
		
		return chiffre;
	}
	
	
	public static String getlibelleCat(int unidVente) {
		String libelle = "";
		
		try {
			String sql = "SELECT libelleCat FROM Catalogue WHERE idVenteEph = ?";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setInt(1, unidVente);
			
			ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	libelle = rs.getString("libelleCat");
	         }
		}
		catch(Exception erreur) {
			System.out.println("Erreur de r�cup�ration de libelleCategorie" + erreur);
		}
		
		return libelle;
	}
	
	public static boolean verifCatalogue(String unlibelle) {
		int chiffre = 0;
		
		boolean rep = false;
		
		try {
			String sql = "SELECT COUNT(idVenteEph) as nb FROM Catalogue WHERE libelleCat = ?";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, unlibelle);
			
			ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	chiffre = rs.getInt("nb");
	         }
	        
	        if (chiffre == 1) {
	        	rep = true;
	        }
		}
		catch(Exception erreur) {
			System.out.println("Erreur de verification id Catalogue" + erreur);
		}
		
		return rep;
	}
	
	public static void ajoutercatalogueaVente(String unlibelleCatalogue, int unidVente) {
		boolean rep = false;
		
		try {
			String sql = "UPDATE Catalogue SET idVenteEph = ? WHERE libelleCat = ?";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setInt(1, unidVente);
			pst.setString(2, unlibelleCatalogue);
			
			
			pst.executeUpdate();
			
		}
		catch(Exception erreur) {
			System.out.println("Erreur de ajout de catalogue dans une vente" + erreur);
		}
	}
	
	public static boolean verifVente(int idVente) {
		int chiffre = 0;
		
		boolean rep = false;
		
		try {
			String sql = "SELECT COUNT(idVenteEph) AS nb FROM Catalogue WHERE idVenteEph = ?";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setInt(1, idVente);
			
			ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	chiffre = rs.getInt("nb");
	         }
	        
	        if (chiffre == 1) {
	        	rep = true;
	        }
		}
		catch(Exception erreur) {
			System.out.println("Erreur de verification id vente" + erreur);
		}
		
		return rep;
	}
	
	public static void suppirmercatadeVente(String uncatalogue) {
		try {
			String sql = "UPDATE Catalogue SET idVenteEph = NULL WHERE libelleCat = ?";
			
			pst = connexion.prepareStatement(sql);
			
			pst.setString(1, uncatalogue);

			pst.executeUpdate();
		}
		catch(Exception erreur) {
			System.out.println("Erreur de supression de catalogue d'une vente");
		}
	}
	
	public static ArrayList<Catalogue> getcataetlesVentes() {
		ArrayList<Catalogue> lescateetVente = new ArrayList<Catalogue>();
		
		String idCat;
		String idVenteEph;
		String libelleCatalogue;
		String dateCatalogue;
		String etatCat;
		String nomVente;
		
		try {
			String sql = "SELECT idCat, libelleCat, dateCat, etatCat, Vente.nomVente\r\n" + 
					"FROM Catalogue, Vente\r\n" + 
					"WHERE Catalogue.idVenteEph = Vente.idVenteEph";
			
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				idCat = rs.getString("idCat");
				libelleCatalogue = rs.getString("libelleCat");
				etatCat = rs.getString("etatCat");
				dateCatalogue = rs.getString("dateCat");
				nomVente = rs.getString("nomVente");
				
				VenteEphemere uneVente = new VenteEphemere(nomVente);
				
				Catalogue unCatalogue = new Catalogue(libelleCatalogue, dateCatalogue, idCat, etatCat, uneVente);
				
				
				lescateetVente.add(unCatalogue);
			}
		}
		catch(Exception erreur) {
			System.out.println("Erreur de r�cup�rations des catalogues et sa vente" + erreur);
		}
		
		return lescateetVente;
	}

	
}
