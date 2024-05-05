package model;

import java.util.ArrayList;

/**
 * Etudiant est une classe qui hérite d'utilisateur car chaque étudiant est un utilisateur du système
 * @author Groupe 1, équipe 4, lot 2
 *
 */

public class Etudiant extends Utilisateur {

	private String adresseMail;
	private ArrayList<Absence> listeAbsences;

	/**
	 *
	 * Fonction permettant de construire un etudiant en héritant de utilisateur les attributs suivant :
	 * @param nom
	 * @param prenom
	 * @param id
	 * @param password
	 * 
	 * Pour cette classe on ajoutera également l'attribut
	 * @param adresseMail
	 */

	public Etudiant (String adresseMail, String nom, String prenom, int id, String password) {
		super (nom, prenom, id, password);
		this.adresseMail = adresseMail;
		this.listeAbsences = listeAbsences;
	}

	/**
	 * Getter de l'attribut adresseMail
	 * @return l'adresseMail d'un etudiant
	 */

	public String getAdresseMail () {
		return adresseMail;
	}

	/**
	 * Setter de l'attribut adresseMail
	 * @param adresseMail
	 */

	public void setAdresseMail (String adresseMail) {
		this.adresseMail = adresseMail;
	}

	/**
	 * Ce getter permet d'afficher la liste des absences d'un élève
	 * @return listeAbsences
	 */

	public ArrayList<Absence> getListeAbsences (){
		return listeAbsences;
	}

	/**
	 * Ce setter permet de modifier la liste des absences d'un élève
	 * @param listeAbsences
	 */

	public void setListeAbsences (ArrayList<Absence> listeAbsences) {
		this.listeAbsences = listeAbsences;
	}

	/**
	 * display est une classe héritée de la classe utilisateur qui permet d'afficher tous les attributs d'un étudiant
	 * @override
	 */

	public void display () {
		super.display();
		System.out.println ("adresse mail : " + adresseMail);
	}
}

