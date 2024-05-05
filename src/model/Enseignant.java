package model;


import java.util.ArrayList;

public class Enseignant  {

	private int numTel;
	private String nomensei;
	private String prenom;
	private String mdp;
	private int idenseignant;
	

	/**
	 * /*
	 * Fonction permettant de construire un enseignant en héritant de utilisateur les attributs suivant :
	 * @param nom
	 * @param prenom
	 * @param id
	 * @param password
	 * 
	 * Pour cette classe on ajoutera également l'attribut
	 * @param numTel
	 */

	public Enseignant ( String nomensei, int idenseignant,int numTel, String mdp) {
		this.nomensei=nomensei;
				this.mdp=mdp;
				
				this.numTel=numTel;
				this.idenseignant= idenseignant;
	}

	/**
	 * Getter de l'attribut numTel
	 * @return le numéro de téléphone d'un enseignant
	 */

		public int getNumTel () {
		return numTel;
	}

		public String getMdp () {
		return mdp;
	}

		public String getNomensei () {
		return nomensei;
	}

		public int getIdenseignant () {
		return idenseignant;
	}

	/**
	 * Setter de l'attribut numTel
	 * @param numTel
	 */

	public void setNumTel (int numTel) {
		this.numTel = numTel;
	}

	public void setIdenseignant (int idenseignant) {
		
		
		
		this.idenseignant= idenseignant;
	}

	public void setNomensei (String nomensei) {
		this.nomensei=nomensei;
	}

	public void setMdp (String mdp) {
		this.mdp=mdp;
	}
	
	

}

