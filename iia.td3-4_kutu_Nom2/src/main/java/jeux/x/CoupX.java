package jeux.x;

import iia.jeux.modele.CoupJeu;

public class CoupX implements CoupJeu{
	/****** Attributs *******/ 
	private int colonne;
	private int graines;
	
	public CoupX(int c, int g) {
		this.colonne = c;
		this.graines = g;
	}
	
	/****** Accesseurs *******/ 
	public int getColonne() {
		return this.colonne;
	}
	
	public int getGraines() {
		return this.graines;
	}

	/****** Accesseurs *******/ 

	public String toString() {
		return "("+this.colonne+")";
	}
	     
}
