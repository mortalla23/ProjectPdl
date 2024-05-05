package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//import pdl.Absence;

import GUI.declareabsence;
import model.Absence;


public class absencedao extends connectionDao {
	  
	/**
	 * Cette fonction permet de récupérer la liste d'absences d'un étudiant donné
	 * @return une ArrayList d'Absences pour un étudiant donné
	 */
	//
	public static  ArrayList<Absence> getList(int dateAbs) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Absence> returnValue = new ArrayList<Absence>();
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Absencelot3 WHERE dateAbs = ? ORDER BY dateAbs");
			ps.setInt(1, dateAbs);
			rs = ps.executeQuery();
			while (rs.next()) {
				returnValue.add(new Absence(rs.getString("dateAbs"),rs.getString("typeAbs"),rs.getInt("volumeHoraire")));
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
	
	public void ajouterAbsence(Absence absence) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO ABSENCELOT3 ( dateAbs, typeAbs, volumeHoraire) VALUES(?, ?, ?)");
		//	ps.setInt(1, absence.getIdAbsence());
			ps.setString(1, absence.getDateAbs());
			ps.setString(2, absence.getTypeAbs());
			ps.setDouble(3, absence.getVolumeHoraire());
			
			ps.executeUpdate();
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
	}
	
	
	
	/*public int modifierAbsence(Absence absence) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE Absencelot3 SET dateAbs = ?, typeAbs = ?, volumeHoraire = ? WHERE idAbsence = ?");
			ps.setString(1, absence.getDateAbs());
			ps.setString(2, absence.getTypeAbs());
			ps.setDouble(3, absence.getVolumeHoraire());
			ps.setInt(4, absence.getIdAbsence());
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
	
	
	/*public int supprimerAbsence(int idAbsence) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM Absencelot3 WHERE idAbsence = ?");
			ps.setInt(1, idAbsence);
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
	*/
	
	public Absence rechercher(int dateAbs) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Absence returnValue = null;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM ABSENCELOT3 WHERE dateAbs = ?");
			ps.setInt(1, dateAbs);
			rs = ps.executeQuery();
			if (rs.next()) {
				returnValue = new Absence(rs.getString("dateAbs"),rs.getString("typeAbs"),rs.getInt("volumeHoraire"));
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

	public static ArrayList<Absence> getListeabsence() {
		// TODO Auto-generated method stub
		return null;
	}


	
}


