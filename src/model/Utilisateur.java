package model;


public class Utilisateur {
	/**
	 * Utilisateur est une classe commune à professeur, etudiant et gestionaire. Cela permet de factoriser certains attributs et certaines fonctions
	 * car chaque personne faisant partie de l'ESIGELEC a un nom, un prénom, un id et un mot de passe
	 * @author Groupe 1, équipe 4, lot 2
	 * @version 1
	 *
	 */

	protected String nom;
	protected String prenom;
	protected int id;
	protected String password;

	/**
	 * Fonction permettant de construire un utilisateur en utilisant les attributs :
	 * @param nom le nom de l'utilisateur
	 * @param prenom le prenom de l'utilisateur
	 * @param id l'id de l'utilisateur
	 * @param pasword le mot de passe de l'utilisateur
	 */

	public Utilisateur (String nom, String prenom, int id, String password) {
		this.prenom = prenom;
		this.nom = nom;
		this.id = id;
		this.password = password;
	}

	/**
	 * Getter de l'attribut nom
	 * @return le nom d'un utilisateur
	 */

	public String getNom () {
		return nom;
	}

	/**
	 * Getter de l'attribut prenom
	 * @return le prenom d'un utilisateur
	 */

	public String getPrenom () {
		return prenom;
	}

	/**
	 * Getter de l'attribut id
	 * @return l'identifiant d'un utilisateur
	 */

	public int getId () {
		return id;
	}

	/**
	 * Getter de l'attribut password
	 * @return le mot de passe d'un utilisateur
	 */

	public String getPassword () {
		return password;
	}

	/**
	 * Setter de l'attribut nom
	 * @param nom
	 */
	public void setNom (String nom) {
		this.nom = nom;
	}

	/**
	 * Setter de l'attribut prenom
	 * @param prenom
	 */

	public void setPrenom (String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Setter de l'identifiant
	 * @param id
	 */

	public void setId (int id) {
		this.id = id;
	}

	/**
	 * Setter du mot de passe
	 * @param password
	 */

	public void setPassword (String password) {
		this.password = password;
	}

	public void display () {
		System.out.println ("nom : " + nom + "prenom : " + prenom + "id : " + id);
	}
}
