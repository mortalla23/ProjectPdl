package DAO;

import java.sql.*;
import java.util.ArrayList;

import model.Etudiant;
import model.Utilisateur;
//import pdl.*;


public class etudiantDAO extends connectionDao {

	public etudiantDAO() {
		super();
	}
	/**
	 * Permet d'ajouter un utilisateur à la table
	 * @param utilisateur
	 * @return un nouvel utilisateur dans la table
	 */
	public int add(Utilisateur utilisateur) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO ETUDIANTLOT3 (idetudiant, nometudiant, prenometudiant, motdepasse) VALUES(?, ?, ?, ?)");
			ps.setInt(1, utilisateur.getId());
			ps.setString(2, utilisateur.getNom());
			ps.setString(3, utilisateur.getPrenom());
			ps.setString(4, utilisateur.getPassword());

			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant d'utilisateur existe déjà. Ajout impossible !");
			else
				e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de modifier un fournisseur dans la table utilisateur.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * @param utilisateur l'utilisateur a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Etudiant etudiant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE etudiantlot3 set nometudiant = ? , prenometudiant =?, motdepasse =? WHERE idetudiant = ?");
			ps.setString(1, etudiant.getNom());
			ps.setString(2, etudiant.getPrenom());
			ps.setString(3, etudiant.getPassword());
			ps.setInt(4, etudiant.getId());
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de supprimer un utilisateur par id dans la table utilisateur.
	 * Si ce dernier possede des articles, la suppression n'a pas lieu.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * @param id l'id de l'utilisateur à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(int idetudiant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM etudiantlot3 WHERE idetudiant = ?");
			ps.setInt(1, idetudiant);

			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00904"))
				System.out.println("Ce fournisseur possede des articles, suppression impossible !"
						+ " Supprimer d'abord ses articles ou utiiser la méthode de suppression avec articles.");
			else
				e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}


	/**
	 * Permet de recuperer un utilisateur a partir de son id
	 * @param reference la reference du fournisseur a recuperer
	 * @return le fournisseur trouve;
	 * 			null si aucun fournisseur ne correspond a cette reference
	 */
	public Etudiant get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Utilisateur returnValue = null;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("choisir * d'un utilisateur WHERE id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				returnValue = new Utilisateur(rs.getString("nometudiant"),
						rs.getString("prenometudiant"),
						rs.getInt("idetudiant"),
						rs.getString("motdepasse"));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return (Etudiant) returnValue;
	}

	/**
	 * Permet de recuperer tous les utilisateurs stockes dans la table utilisateurs
	 * 
	 * @return une ArrayList d'utilisateurs
	 */
	public ArrayList<Etudiant> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Etudiant> returnValue = new ArrayList<Etudiant>();
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM  ORDER BY idetudiant");
			rs = ps.executeQuery();
			while (rs.next()) {
				returnValue.add(new Etudiant(rs.getString("nometudiant"),
						rs.getString("prenometudiant"),
						null, rs.getInt("idetudiant"),
						rs.getString("motdepasse")));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
}

