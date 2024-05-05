package model;

/**
 * La classe cours permet de définir les cours qui réuniront les
 * étudiants et les professeurs
 * @author Groupe 1, équipe 4, lot 2
 *
 */

public class cours {
	
	private String matiere;
	private double masseHoraire;
	private int idcours;
	
	/**
	 * Constructeur de cours, chaque cours est caractérisé par les paramètres suivants :
	 * @param nom
	 * @param d
	 * @param enseignant
	 */
	
	public cours (String matiere, double d, int id) {
		this.matiere = matiere;
		this.masseHoraire = d;
		this.idcours = id;
	}
	
	public cours(String string, String string2, int int1, String string3) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * getters de la classe cours
	 * @return nom
	 * @return masseHorairre
	 * @return enseignant
	 */
	
	public String getMatiere () {
		return matiere;
	}
	
	public double getMasseHoraire () {
		return masseHoraire;
	}
	
	public  int getidcours () {
		return idcours;
	}
	
	/**
	 * setters de la classe cours
	 * @param nom
	 * @param masseHoraire
	 * @param enseignant
	 */
	
	public void setMatiere (String matiere) {
		this.matiere = matiere;
	}
	
	public void setMasseHoraire (double masseHoraire) {
		this.masseHoraire = masseHoraire;
	}
	
	public void setCours (int idcours) {
		this.idcours = idcours;
	}
	
	public void display () {
		System.out.println ("cours : " + idcours + "masseHoraire : " + masseHoraire + "matiere : " + matiere);
	}

	
}

