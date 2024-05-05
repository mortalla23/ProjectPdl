package model;

public class justifiactif {

private int idEtudiant;
private String typeJustificatif;
private String  dateAbs;

public justifiactif (int idEtudiant , String dateAbs, String typeJustificatif) {
	this.idEtudiant = idEtudiant;
	
	this.dateAbs = dateAbs;
	this.typeJustificatif = typeJustificatif;
	
}

/**
 * Getter de l'attribut type
 * @return le type d'absence d'un élève
 */

public String getTypeJustificatif () {
	return typeJustificatif;
}

public void setTypeJustificatif (String typeJustificatif) {
	this.typeJustificatif = typeJustificatif;
}

public String getDateAbs () {
	return dateAbs;
}

public void setDateAbs (String dateAbs) {
	this.dateAbs = dateAbs;
}

public int getIdEtudiant () {
	return idEtudiant;
}

public void setIdEtudiant (int idEtudiant ) {
	this.idEtudiant = idEtudiant;
}

//




}

