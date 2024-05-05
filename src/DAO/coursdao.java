
package DAO;

import java.sql.*;
import java.util.ArrayList;

import model.Utilisateur;
import model.cours;
//import pdl.*;


public class coursdao extends connectionDao {

	public coursdao() {
		super();
	}
	/**
	 * Permet d'ajouter un utilisateur à la table
	 * @param utilisateur
	 * @return un nouvel utilisateur dans la table
	 */
	public int add(cours cours) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO coursLOT3 (idcours, matiere, nbheure) VALUES(?, ?, ?)");
			ps.setInt(1, cours.getidcours());
			ps.setString(2, cours.getMatiere());
			ps.setDouble(3, cours.getMasseHoraire());
			

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
	public int update(cours cours) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE courslot3 set  matiere = ?,nbheure = ? WHERE idcours = ?");
			ps.setInt(3, cours.getidcours());
			ps.setString(1, cours.getMatiere());
			ps.setInt(2, (int) cours.getMasseHoraire());
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
	 * @param newUtil l'id de l'utilisateur à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(int idcours ) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM courslot3 WHERE idcours = ?");
			ps.setInt(1, idcours);

			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
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
	public cours get(int idcours) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		cours returnValue = null;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("choisir * d'un utilisateur WHERE idcours = ?");
			ps.setInt(1, idcours);
			rs = ps.executeQuery();
			if (rs.next()) {
				returnValue = new cours(rs.getString("matiere"),
						rs.getDouble("masseHoraire"),
						rs.getInt("idcours"));
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
		return returnValue;
	}

	/**
	 * Permet de recuperer tous les utilisateurs stockes dans la table utilisateurs
	 * 
	 * @return une ArrayList d'utilisateurs
	 */
	public ArrayList<cours> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<cours> returnValue = new ArrayList<cours>();
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM utilisateur ORDER BY idcours");
			rs = ps.executeQuery();
			while (rs.next()) {
				returnValue.add(new cours(rs.getString("matiere"),rs.getDouble("masseHoraire"),rs.getInt("idcours")));
						
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

