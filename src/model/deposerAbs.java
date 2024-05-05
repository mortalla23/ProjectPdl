package model;

public class deposerAbs {




private String dateAbs;
private int volumeHoraire;
private double typeAbs;

/**
 * Constructeur de cours, chaque cours est caractérisé par les paramètres suivants :
 * @param nom
 * @param d
 * @param enseignant
 */

public deposerAbs (String dateAbs, double typeAbs, int volumeHoraire) {
	this.dateAbs = dateAbs;
	this.typeAbs = typeAbs;
	this.volumeHoraire = volumeHoraire;
	
}

//public cours(String string, String string2, int int1, String string3) {
	// TODO Auto-generated constructor stub
//}

/**
 * getters de la classe cours
 * @return nom
 * @return masseHorairre
 * @return enseignant
 */

public String getDateAbs () {
	return dateAbs;
}

public int getVolumeHoraire () {
	return volumeHoraire;
}

public  double getTypeAbs () {
	return typeAbs;
}

/**
 * setters de la classe cours
 * @param nom
 * @param masseHoraire
 * @param enseignant
 */

public void set (String dateAbs ) {
	this.dateAbs = dateAbs;
}

public void setVolumeHoraire (int masseHoraire) {
	this.volumeHoraire = volumeHoraire;
}

public void setCours (double typeAbs) {
	this.typeAbs = typeAbs;
}

public void display () {
	System.out.println ("dateAbs : " + dateAbs + "masseHoraire : " + volumeHoraire + "typeABSENCE : " + typeAbs);
}


}

