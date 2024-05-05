package model;
/**
 * Cette classe représente les absences d'un élève, on retrouve une liste deces absences dans les attributs d'un élève
 * @author Groupe 1, équipe 4, lot 2
 *
 */


public class Absence {

	private String typeAbs;
	private int volumeHoraire;
	private String dateAbs;

	public Absence(String dateAbs,String typeAbs, int volumeHoraire) {
		this.typeAbs = typeAbs;
		this.volumeHoraire = volumeHoraire;
		this.dateAbs = dateAbs;
	}

	public String getTypeAbs() {
		return typeAbs;
	}

	public void setTypeAbs(String typeAbs) {
		this.typeAbs = typeAbs;
	}

	public int getVolumeHoraire() {
		return volumeHoraire;
	}

	public void setVolumeHoraire(int volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}

	public String getDateAbs() {
		return dateAbs;
	}

	public void setDateAbs(String dateAbs) {
		this.dateAbs = dateAbs;
	}






}
