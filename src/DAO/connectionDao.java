package DAO;

public class connectionDao {

/**
 * Classe d'acces a la base de donnees
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */

	/**
	 * Parametres de connexion a la base de donnees oracle
	 * URL, LOGIN et PASS sont des constantes
	 */
	final static String URL   = "jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl";
	final static String LOGIN = "C##BDD1_31";   // remplacer les ********. Exemple BDD1
	final static String PASS  = "BDD131";   // remplacer les ********. Exemple BDD1
	
	/**
	 * Constructor
	 * 
	 */
	public connectionDao() {
		// chargement du pilote de bases de donnees
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}


}


