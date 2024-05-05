package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.Enseignant;



public class enseignantdao extends connectionDao {

	public enseignantdao() {
		super();
	}
	/**
	 * Permet d'ajouter un utilisateur à la table
	 * @param utilisateur
	 * @return un nouvel utilisateur dans la table
	 */
	public int add(Enseignant enseignant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO ENSEIGNANTLOT3 (nomensei,idenseignant, numTel, mdp) VALUES(?, ?, ?, ?)");
			ps.setString(1, enseignant.getNomensei());
			ps.setInt(2,enseignant.getIdenseignant());
			ps.setInt(3, enseignant.getNumTel());
			ps.setString(4, enseignant.getMdp());

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
	public int update(Enseignant enseignant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE ENSEIGNANTLOT3 set nomensei = ? , numTel =?, mdp =? WHERE idenseignant = ?");
			ps.setString(1, enseignant.getNomensei());
			ps.setInt(2, enseignant.getNumTel());
			ps.setString(3, enseignant.getMdp());
			ps.setInt(4, enseignant.getIdenseignant());
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
	public int delete(int idenseignant) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM ENSEIGNANTLOT3 WHERE idenseignant = ?");
			ps.setInt(1, idenseignant);

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
	public Enseignant get(int idenseignant) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Enseignant returnValue = null;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("choisir * d'un enseignantlot3 WHERE idenseignant = ?");
			ps.setInt(1, idenseignant);
			rs = ps.executeQuery();
			if (rs.next()) {
				returnValue = new Enseignant(rs.getString("nomensei"),
						rs.getInt("idenseignant"),
						rs.getInt("numTel"),
						rs.getString("mdp"));
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
		return (Enseignant) returnValue;
	}

	/**
	 * Permet de recuperer tous les utilisateurs stockes dans la table utilisateurs
	 * 
	 * @return une ArrayList d'utilisateurs
	 */
	public ArrayList<Enseignant> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Enseignant> returnValue = new ArrayList<Enseignant>();
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM ENSEIGNANTLOT3 ORDER BY idenseignant");
			rs = ps.executeQuery();
			while (rs.next()) {
				returnValue.add(new Enseignant(rs.getString("nomensei"),
						rs.getInt("idenseignant"),
					     rs.getInt("numTel"),
						rs.getString("mdp")));
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

